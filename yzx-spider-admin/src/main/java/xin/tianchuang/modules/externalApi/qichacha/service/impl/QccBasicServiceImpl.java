package xin.tianchuang.modules.externalApi.qichacha.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;

import xin.tianchuang.modules.externalApi.qichacha.QichachaUtils;
import xin.tianchuang.modules.externalApi.qichacha.config.QichachaApiConfig;
import xin.tianchuang.modules.externalApi.qichacha.dao.QccBasicDao;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccBasicEntity;
import xin.tianchuang.modules.externalApi.qichacha.meta.QichachaDefaultRq;
import xin.tianchuang.modules.externalApi.qichacha.meta.QichachaDefaultRs;
import xin.tianchuang.modules.externalApi.qichacha.meta.QichachaPagingRq;
import xin.tianchuang.modules.externalApi.qichacha.service.*;
import xin.tianchuang.modules.externalApi.qichacha.vo.QccBasicInfo;

import javax.annotation.Resource;


@Service("qccBasicService")
public class QccBasicServiceImpl extends ServiceImpl<QccBasicDao, QccBasicEntity> implements QccBasicService {

    @Autowired
    private QichachaApiConfig config;
    @Resource
    private QichachaService qichachaService;
    @Resource
    private QccBasicBranchesService branchesService;
    @Resource
    private QccBasicChangeRecordsService changeRecordsService;
    @Resource
    private QccBasicCompanyProductsService companyProductsService;
    @Resource
    private QccBasicCompanyTaxCreditItemsService companyTaxCreditItemsService;
    @Resource
    private QccBasicContactInfoService contactInfoService;
    @Resource
    private QccBasicEmployeesService employeesService;
    @Resource
    private QccBasicIndustryService industryService;
    @Resource
    private QccBasicLiquidationService liquidationService;
    @Resource
    private QccBasicMPledgeService mPledgeService;
    @Resource
    private QccBasicOriginalNameService originalNameService;
    @Resource
    private QccBasicPartnersService partnersService;
    @Resource
    private QccBasicPenaltyCreditChinaService penaltyCreditChinaService;
    @Resource
    private QccBasicPenaltyService penaltyService;
    @Resource
    private QccBasicPermissionEciinfoService permissionEciinfoService;
    @Resource
    private QccBasicPermissionInfoService permissionInfoService;
    @Resource
    private QccBasicPledgeService pledgeService;
    @Resource
    private QccBasicShixinItemsService shixinItemsService;
    @Resource
    private QccBasicSpotCheckService spotCheckService;
    @Resource
    private QccBasicZhixingItemsService zhixingItemsService;
    @Resource
    private QccBasicExceptionsService exceptionsService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QccBasicEntity> page = this.selectPage(
                new Query<QccBasicEntity>(params).getPage(),
                new EntityWrapper<QccBasicEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void getData(String name) {
        final QichachaDefaultRq rq = QichachaUtils.newDefaultRq();
        rq.getParam().setSearchKey(name);
        rq.setUrl(config.fullDetails);
        try {
            QichachaDefaultRs<QccBasicInfo> rs = qichachaService.getData(rq, QccBasicInfo.class, "企业关键字精确获取详细信息(Full)");
            deleteBasicInfo(name);
            if (rs.getResult().getBasicEntity() != null)
                insert(rs.getResult().getBasicEntity());
            if (rs.getResult().getIndustryEntity() != null)
                industryService.insert(rs.getResult().getIndustryEntity());
            if (rs.getResult().getContactInfoEntity() != null)
                contactInfoService.insert(rs.getResult().getContactInfoEntity());
            if (rs.getResult().getLiquidationEntity() != null)
                liquidationService.insert(rs.getResult().getLiquidationEntity());
            if (rs.getResult().getBasicBranchesEntityList() != null)
                branchesService.insertBatch(rs.getResult().getBasicBranchesEntityList());
            if (rs.getResult().getChangeRecordsEntityList() != null)
                changeRecordsService.insertBatch(rs.getResult().getChangeRecordsEntityList());
            if (rs.getResult().getCompanyProductsEntityList() != null)
                companyProductsService.insertBatch(rs.getResult().getCompanyProductsEntityList());
            if (rs.getResult().getCompanyTaxCreditItemsEntityList() != null)
                companyTaxCreditItemsService.insertBatch(rs.getResult().getCompanyTaxCreditItemsEntityList());
            if (rs.getResult().getEmployeesEntityList() != null)
                employeesService.insertBatch(rs.getResult().getEmployeesEntityList());
            if (rs.getResult().getmPledgeEntityList() != null)
                mPledgeService.insertBatch(rs.getResult().getmPledgeEntityList());
            if (rs.getResult().getOriginalNameEntityList() != null)
                originalNameService.insertBatch(rs.getResult().getOriginalNameEntityList());
            if (rs.getResult().getPartnersEntityList() != null)
                partnersService.insertBatch(rs.getResult().getPartnersEntityList());
            if (rs.getResult().getPenaltyCreditChinaEntityList() != null)
                penaltyCreditChinaService.insertBatch(rs.getResult().getPenaltyCreditChinaEntityList());
            if (rs.getResult().getPenaltyEntityList() != null)
                penaltyService.insertBatch(rs.getResult().getPenaltyEntityList());
            if (rs.getResult().getPermissionEciinfoEntityList() != null)
                permissionEciinfoService.insertBatch(rs.getResult().getPermissionEciinfoEntityList());
            if (rs.getResult().getPermissionInfoEntityList() != null)
                permissionInfoService.insertBatch(rs.getResult().getPermissionInfoEntityList());
            if (rs.getResult().getPledgeEntityList() != null)
                pledgeService.insertBatch(rs.getResult().getPledgeEntityList());
            if (rs.getResult().getShixinItemsEntityList() != null)
                shixinItemsService.insertBatch(rs.getResult().getShixinItemsEntityList());
            if (rs.getResult().getSpotCheckEntityList() != null)
                spotCheckService.insertBatch(rs.getResult().getSpotCheckEntityList());
            if (rs.getResult().getZhixingItemsEntityList() != null)
                zhixingItemsService.insertBatch(rs.getResult().getZhixingItemsEntityList());
            if (rs.getResult().getExceptionsEntityList() != null)
                exceptionsService.insertBatch(rs.getResult().getExceptionsEntityList());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteBasicInfo(String name) {
        Wrapper wrapper = QichachaUtils.createWrapperByEntName(name);
        delete(wrapper);
        branchesService.delete(wrapper);
        changeRecordsService.delete(wrapper);
        companyProductsService.delete(wrapper);
        companyTaxCreditItemsService.delete(wrapper);
        contactInfoService.delete(wrapper);
        employeesService.delete(wrapper);
        industryService.delete(wrapper);
        liquidationService.delete(wrapper);
        mPledgeService.delete(wrapper);
        originalNameService.delete(wrapper);
        partnersService.delete(wrapper);
        penaltyCreditChinaService.delete(wrapper);
        penaltyService.delete(wrapper);
        permissionEciinfoService.delete(wrapper);
        permissionInfoService.delete(wrapper);
        pledgeService.delete(wrapper);
        shixinItemsService.delete(wrapper);
        spotCheckService.delete(wrapper);
        zhixingItemsService.delete(wrapper);
    }

}
