package xin.tianchuang.modules.dataparser.biz;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import xin.tianchuang.common.component.spring.SpringContextUtils;
import xin.tianchuang.common.utils.tcredit.StringUtil;
import xin.tianchuang.modules.api.facade.impl.CreditchinaApiFacadeImpl;
import xin.tianchuang.modules.dataparser.annotation.EntName;
import xin.tianchuang.modules.dataparser.dto.CreditChinaDTO;
import xin.tianchuang.modules.dataparser.entity.*;
import xin.tianchuang.modules.dataparser.enums.CreditChinaCreditTypeEnum;
import xin.tianchuang.modules.dataparser.enums.DataTypeEnum;
import xin.tianchuang.modules.dataparser.service.CreditchinaCreditTypeService;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by lee on 2018/10/12.
 * 信用中国数据解析
 */
@Component
public class CreditChinaParser extends Parser<CreditChinaDTO> {
    private static  final Logger LOGGER= LoggerFactory.getLogger(CreditChinaParser.class);

    private static final String SOURCE="数据来源";

    private static final String TABLE_PREX="xin.tianchuang.modules.dataparser.entity.";

    private static final String BASE_INFO="creditInfoDetail";
    private static final String PERMISSION="pubPermissionsName";
    private static final String PENALTY="pubPenaltyName";
    private static final String HONESTY="recordParam2";
    private static final String FOCUS="recordParam4";
    private static final String BLACK="recordParam8";

    private Map<String,CreditchinaCreditTypeEntity> creditTypeMap;

    /**
     * 初始化路由表
     * 暂时用的key：数据来源， 将来可能要key：数据来源+数据类型
     */
    CreditChinaParser()  {
        creditTypeMap = new HashMap<String,CreditchinaCreditTypeEntity>();
        CreditchinaCreditTypeService creditTypeService=SpringContextUtils.getBean("creditchinaCreditTypeService",CreditchinaCreditTypeService.class);
        List<CreditchinaCreditTypeEntity> list=creditTypeService.getAllCreditTypeEntity();
        if(list != null){
            for(CreditchinaCreditTypeEntity entity:list){
                creditTypeMap.put(entity.getSource(),entity);
            }
        }

    }

    @Override
    public CreditChinaDTO jsonParser(String jsonContent) throws Exception{
        if(StringUtils.isBlank(jsonContent)){
            return  null;
        }
        CreditChinaDTO  dto  = new CreditChinaDTO();
        JSONObject json=  JSONObject.parseObject(jsonContent);

        String baseInfo= json.getString(BASE_INFO);
        if(StringUtils.isNotBlank(baseInfo)) {
            CreditchinaBaseInfoEntity baseInfoEntity = JSONObject.parseObject(baseInfo, CreditchinaBaseInfoEntity.class);
            dto.setBaseInfo(baseInfoEntity);
        }
        String permission=json.getString(PERMISSION);
        if(StringUtils.isNotBlank(permission)){
            List<CreditchinaPubPermissionEntity> permissionEntities=JSONObject.parseArray(permission,CreditchinaPubPermissionEntity.class);
            dto.setPermissions(permissionEntities);
        }

        String penalty=json.getString(PENALTY);
        if(StringUtils.isNotBlank(penalty)){
            List<CreditchinaPubPenaltyEntity> penaltyEntities=JSONObject.parseArray(penalty,CreditchinaPubPenaltyEntity.class);
            dto.setPenaltys(penaltyEntities);
        }
        JSONArray array=new JSONArray();
        /**
         * 获取 守信红名单信息
         */
        array.addAll(json.getJSONArray(HONESTY));
        /**
         * 获取 重点关注名单信息
         */
        array.addAll(json.getJSONArray(FOCUS));
        /**
         * 获取 黑名单信息
         */
        array.addAll(json.getJSONArray(BLACK));

        if(!array.isEmpty()){
            List<Object> entities=new ArrayList<Object>() ;
            List<CreditchinaCreditTypeRecordEntity> rotues=new ArrayList<CreditchinaCreditTypeRecordEntity>() ;
            int count=array.size();
            for(int i = 0;i < count;i ++){
                JSONObject record = (JSONObject) array.get(i);
                CreditchinaCreditTypeEntity creditTypeEntity=creditTypeMap.get(record.getString(SOURCE));
                if(creditTypeEntity==null
                        ||  StringUtils.isBlank(creditTypeEntity.getEntityName())
                        || StringUtils.isBlank(creditTypeEntity.getTableName())){
                    throw new Exception("配置表[creditchina_credit_type]中 [creditType="
                            +CreditChinaCreditTypeEnum.HONESTY.getValue()
                            +"，source="+record.getString(SOURCE)
                            +"] 的配置不存在或未配置table_name、entity_name，无法解析此记录.");
                }
                String entityName= creditTypeEntity.getEntityName();
                //CreditchinaHonestyTaxEntity--->creditchinaHonestyTaxParser
                String parserName=StringUtil.lowCaseFirstChar(entityName.substring(0,entityName.length()-6)+"Parser");
                Parser parser=SpringContextUtils.getBean(parserName,Parser.class);
                Object entity=parser.parser(record.toJSONString(), DataTypeEnum.JSON);

                entities.add(entity);
                CreditchinaCreditTypeRecordEntity rotue=initRecordEntityByCreditTypeEntity(creditTypeEntity);
                //获得企业名称
                try {
                    Class<?> clz = entity.getClass();
                    Field[] fields = clz.getFields();
                    for ( Field field : fields) {
                        if (field.isAnnotationPresent(EntName.class)) {
                            //打开私有访问
                            field.setAccessible(true);
                            //获取属性值
                            String value = (String)field.get(entity);
                            rotue.setEntName(value);
                            break;
                        }
                    }
                }catch (Exception e){
                    LOGGER.error(" 获取该对象的企业名称出错 确保对象企业名称属性上有EntName注解");
                    e.printStackTrace();
                }
                rotues.add(initRecordEntityByCreditTypeEntity(creditTypeEntity));
            }
            dto.setLists(entities);
            dto.setRoutes(rotues);
        }
        return  dto;
    }

    private CreditchinaCreditTypeRecordEntity initRecordEntityByCreditTypeEntity(CreditchinaCreditTypeEntity creditTypeEntity) {
        CreditchinaCreditTypeRecordEntity entity=new CreditchinaCreditTypeRecordEntity();
        if(creditTypeEntity!=null){
            entity.setCreditType(creditTypeEntity.getCreditType());
            entity.setCreditTypeId(creditTypeEntity.getId());
            entity.setSource(creditTypeEntity.getSource());
            entity.setTableName(creditTypeEntity.getTableName());
            entity.setEntityName(creditTypeEntity.getEntityName());

            entity.setCreateTime(new Date());
            //entity.setVersion(0);
            entity.setDataStatus(1);

        }
        return entity;
    }
}
