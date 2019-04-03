package xin.tianchuang.modules.dataparser.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xin.tianchuang.common.component.spring.SpringContextUtils;
import xin.tianchuang.common.utils.tcredit.StringUtil;
import xin.tianchuang.modules.dataparser.dto.CreditChinaDTO;
import xin.tianchuang.modules.dataparser.entity.CreditchinaBaseInfoEntity;
import xin.tianchuang.modules.dataparser.entity.CreditchinaCreditTypeRecordEntity;
import xin.tianchuang.modules.dataparser.entity.CreditchinaPubPenaltyEntity;
import xin.tianchuang.modules.dataparser.entity.CreditchinaPubPermissionEntity;
import xin.tianchuang.modules.dataparser.service.*;
import xin.tianchuang.modules.spider.entity.SpiderRawDataEntity;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by lee on 2018/10/16.
 */
@Service("creditchinaService")
public class CreditchinaServiceImpl implements CreditchinaService {

//    @Autowired
//    private SpiderRawDataService spiderRawDataService;
    @Autowired
    private CreditchinaBaseInfoService baseInfoService;
    @Autowired
    private CreditchinaCreditTypeRecordService creditTypeRecordService;
    @Autowired
    private CreditchinaPubPermissionService permissionService;
    @Autowired
    private CreditchinaPubPenaltyService penaltyService;

    @Override
    @Transactional(rollbackFor = Exception.class,propagation= Propagation.REQUIRED)
    public void saveParserData(CreditChinaDTO dto, SpiderRawDataEntity spiderRawDataEntity) throws Exception{

        Long spiderId=spiderRawDataEntity.getId();
        //1.保存基本信息
        CreditchinaBaseInfoEntity baseInfo=dto.getBaseInfo();
        baseInfo.setSpiderId(spiderId);
        //删除重复
        baseInfoService.deleteByEntName(spiderRawDataEntity.getEntName());
        baseInfoService.insert(dto.getBaseInfo());

        //2。保存行政许可
        permissionService.deleteByEntName(spiderRawDataEntity.getEntName());
        List<CreditchinaPubPermissionEntity> permissions=dto.getPermissions();
        if(permissions!=null && !permissions.isEmpty()) {
            for (CreditchinaPubPermissionEntity entity : permissions) {
                entity.setSpiderId(spiderId);
            }
            permissionService.insertBatch(permissions);
        }

        //3.保存行政处罚
        penaltyService.deleteByEntName(spiderRawDataEntity.getEntName());
        List<CreditchinaPubPenaltyEntity> penaltys=dto.getPenaltys();
        if(penaltys!=null && !penaltys.isEmpty()) {
            for (CreditchinaPubPenaltyEntity entity : penaltys) {
                entity.setSpiderId(spiderId);
            }
            penaltyService.insertBatch(penaltys);
        }

        //4.保存守信红名单信息
        //5.保存重点关注名单信息
        //6.保存黑名单信息

        //先删除
        List<CreditchinaCreditTypeRecordEntity> routeOlds= creditTypeRecordService.selectByEntName(spiderRawDataEntity.getEntName());
        if(routeOlds!=null && !routeOlds.isEmpty()){
            int size=routeOlds.size();
            for(int i=0;i<size;i++){
                CreditchinaCreditTypeRecordEntity route=routeOlds.get(i);
                String entityName=route.getEntityName();
                String serviceName= StringUtil.lowCaseFirstChar(entityName.substring(0,entityName.length()-6)+"Service");
                ServiceImpl service=SpringContextUtils.getBean(serviceName, ServiceImpl.class);
                service.deleteById(route.getTableId());
            }
        }
        creditTypeRecordService.deleteByEntName(spiderRawDataEntity.getEntName());

        List list=dto.getLists();
        List<CreditchinaCreditTypeRecordEntity> routes= dto.getRoutes();
        if(list!=null && !list.isEmpty()){
            int size=routes.size();
            for(int i=0;i<size;i++){
                CreditchinaCreditTypeRecordEntity route=routes.get(i);
                route.setSpiderId(spiderId);

                String entityName=route.getEntityName();
                String serviceName= StringUtil.lowCaseFirstChar(entityName.substring(0,entityName.length()-6)+"Service");
                ServiceImpl service=SpringContextUtils.getBean(serviceName, ServiceImpl.class);

                Object object=list.get(i);
                service.insert(object);
                //反射获得id
                Method getIdMethod=object.getClass().getMethod("getId");
                Long id=(Long)getIdMethod.invoke(object);
                route.setTableId(id);
            }
            creditTypeRecordService.insertBatch(routes);
        }
        //7.修改记录为已解析
//        spiderRawDataEntity.setIfAnalysised(1);
//        spiderRawDataService.updateById(spiderRawDataEntity);
    }
}
