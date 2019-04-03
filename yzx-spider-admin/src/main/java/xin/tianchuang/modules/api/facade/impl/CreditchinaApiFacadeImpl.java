package xin.tianchuang.modules.api.facade.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.tianchuang.common.component.spring.SpringContextUtils;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.common.utils.tcredit.StringUtil;
import xin.tianchuang.modules.api.bean.v1.CreditchinaBaseInfoDTO;
import xin.tianchuang.modules.api.bean.v1.CreditchinaPenaltyDTO;
import xin.tianchuang.modules.api.bean.v1.CreditchinaPermissionDTO;
import xin.tianchuang.modules.api.facade.CreditchinaApiFacade;
import xin.tianchuang.modules.dataparser.annotation.EntName;
import xin.tianchuang.modules.dataparser.entity.CreditchinaBaseInfoEntity;
import xin.tianchuang.modules.dataparser.entity.CreditchinaCreditTypeEntity;
import xin.tianchuang.modules.dataparser.enums.CreditChinaCreditTypeEnum;
import xin.tianchuang.modules.dataparser.service.CreditchinaBaseInfoService;
import xin.tianchuang.modules.dataparser.service.CreditchinaCreditTypeService;
import xin.tianchuang.modules.dataparser.service.CreditchinaPubPenaltyService;
import xin.tianchuang.modules.dataparser.service.CreditchinaPubPermissionService;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lee on 2018/10/23.
 */
@Service
public class CreditchinaApiFacadeImpl extends BaseFacadeImpl implements CreditchinaApiFacade {

    private static  final Logger LOGGER= LoggerFactory.getLogger(CreditchinaApiFacadeImpl.class);

    private static final String BEAN_PACKAGE="xin.tianchuang.modules.dataparser.entity";

    @Autowired
    private CreditchinaBaseInfoService baseInfoService;

    @Autowired
    private CreditchinaPubPermissionService permissionService;

    @Autowired
    private CreditchinaPubPenaltyService penaltyService;

    @Autowired
    private CreditchinaCreditTypeService creditTypeService;

    @Override
    public CreditchinaBaseInfoDTO getBaseInfo(String name, String creditCode) {
        CreditchinaBaseInfoEntity  entity = baseInfoService.getByNameOrCreditCode(name,creditCode);
        CreditchinaBaseInfoDTO dto = new CreditchinaBaseInfoDTO();
        BeanUtils.copyProperties(entity,dto);
        return dto;
    }

    @Override
    public PageUtils getPermissions(String name,Integer currPage) {

        Map map=new HashMap<String,Object>();
        map.put("xkXdr",name);
        map.put("page",currPage);
        map.put("limit","10");

        PageUtils page=permissionService.queryPage(map);
        page.setList(ejbGenerator.convert(page.getList(), CreditchinaPermissionDTO.class));

        return page;
    }

    @Override
    public PageUtils getPenaltys(String name,Integer currPage) {
        Map map=new HashMap<String,Object>();
        map.put("cfXdrMc",name);
        map.put("page",currPage);
        map.put("limit","10");

        PageUtils page=penaltyService.queryPage(map);
        page.setList(ejbGenerator.convert(page.getList(), CreditchinaPenaltyDTO.class));

        return page;
    }

    /**
     * 暂时只考虑只存在一张表的情况 也就是说只有一种结果的
     * @param name
     * @param currPage
     * @return
     */
    @Override
    public PageUtils getHonestys(String name,Integer currPage) {
        return getInfoByCreditType(name,currPage,CreditChinaCreditTypeEnum.HONESTY);
    }

    @Override
    public PageUtils getFocuss(String name,Integer currPage) {
        return getInfoByCreditType(name,currPage,CreditChinaCreditTypeEnum.FOCUS);
    }

    @Override
    public PageUtils getBlacks(String name,Integer currPage) {
        return getInfoByCreditType(name,currPage,CreditChinaCreditTypeEnum.BLACK);
    }

    private PageUtils getInfoByCreditType(String name,Integer currPage,CreditChinaCreditTypeEnum creditTypeEnum) {
        Map map=new HashMap<String,Object>();
        map.put("page",currPage);
        map.put("limit","10");

        List<CreditchinaCreditTypeEntity> properties = creditTypeService.getByCreditType(creditTypeEnum);
        for(CreditchinaCreditTypeEntity creditTypeEntity: properties){
            String entityName=creditTypeEntity.getEntityName();
            String serviceName= StringUtil.lowCaseFirstChar(entityName.substring(0,entityName.length()-6)+"Service");
            ServiceImpl service=SpringContextUtils.getBean(serviceName, ServiceImpl.class);

            // todo 这里要想想获得表明怎么知道那一列是企业名称 要么统一加个固定列 或者 加个配置项 或者在实体属性上加个注解啥的
            try {
                Class<?> clz = Class.forName(BEAN_PACKAGE+entityName).getClass();
                Field[] fields = clz.getFields();
                for ( Field field : fields) {
                    if (field.isAnnotationPresent(EntName.class)) {
                        map.put(field.getName(), name);
                    }
                }
            }catch (Exception e){
                LOGGER.error(" 不存在该对象");
                e.printStackTrace();
            }
            //todo 这里要不要传入实体对象？
            //Object obj=Class.forName(BEAN_PACKAGE+entityName).newInstance();
            Page page=service.selectPage(
                    new Query<>(map).getPage(),
                    new EntityWrapper<>()
            );
            //有记录
            if(page.getTotal()>0) {
                return new PageUtils(page);
            }
        }
        return null;
    }
}

