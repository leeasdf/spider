package xin.tianchuang.modules.api.facade.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.api.bean.v1.QccCopyrightApiDTO;
import xin.tianchuang.modules.api.bean.v1.QccPatentApiDTO;
import xin.tianchuang.modules.api.bean.v1.QccSeriousViolationApiDTO;
import xin.tianchuang.modules.api.bean.v1.QccTenderApiDTO;
import xin.tianchuang.modules.api.bean.v1.QccTrademarkApiDTO;
import xin.tianchuang.modules.api.bean.v1.result.QccFullDetailsDTO;
import xin.tianchuang.modules.api.facade.QichachaApiFacade;
import xin.tianchuang.modules.api.form.ApiQueryForm;
import xin.tianchuang.modules.externalApi.qichacha.QichachaUtils;
import xin.tianchuang.modules.externalApi.qichacha.config.QichachaApiConfig;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccBasicEntity;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccCopyrightEntity;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccSeriousViolationEntity;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccTenderEntity;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccTradeMarkEntity;
import xin.tianchuang.modules.externalApi.qichacha.entity.QichachaDataPatentEntity;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicBranchesService;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicChangeRecordsService;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicCompanyProductsService;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicCompanyTaxCreditItemsService;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicContactInfoService;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicEmployeesService;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicExceptionsService;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicIndustryService;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicLiquidationService;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicMPledgeService;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicOriginalNameService;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicPartnersService;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicPenaltyCreditChinaService;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicPenaltyService;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicPermissionEciinfoService;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicPermissionInfoService;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicPledgeService;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicService;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicShixinItemsService;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicSpotCheckService;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicZhixingItemsService;
import xin.tianchuang.modules.externalApi.qichacha.service.QccCopyrightService;
import xin.tianchuang.modules.externalApi.qichacha.service.QccSeriousViolationService;
import xin.tianchuang.modules.externalApi.qichacha.service.QccTenderService;
import xin.tianchuang.modules.externalApi.qichacha.service.QccTradeMarkService;
import xin.tianchuang.modules.externalApi.qichacha.service.QichachaDataPatentService;
import cn.hutool.core.date.DateUtil;

/**
 * Created by lee on 2018/12/20.
 */
@Component
public class QichachaApiFacadeImpl extends BaseFacadeImpl implements QichachaApiFacade {

    @Autowired
    private QccCopyrightService copyrightService;

    @Autowired
    private QichachaApiConfig config;
    @Resource
    private QichachaDataPatentService qichachaDataPatentService;
    @Resource
    private QccTradeMarkService qccTradeMarkService;
    @Resource
    private QccSeriousViolationService qccSeriousViolationService;
    @Resource
    private QccBasicService qccBasicService;

    @Autowired
    private QccTenderService qccTenderService;
    @Resource
    private QccBasicBranchesService qccBasicBranchesService;
    @Resource
    private QccBasicChangeRecordsService qccBasicChangeRecordsService;
    @Resource
    private QccBasicCompanyProductsService qccBasicCompanyProductsService;
    @Resource
    private QccBasicCompanyTaxCreditItemsService qccBasicCompanyTaxCreditItemsService;
    @Resource
    private QccBasicContactInfoService qccBasicContactInfoService;
    @Resource
    private QccBasicEmployeesService qccBasicEmployeesService;
    @Resource
    private QccBasicIndustryService qccBasicIndustryService;
    @Resource
    private QccBasicLiquidationService qccBasicLiquidationService;
    @Resource
    private QccBasicMPledgeService qccBasicMPledgeService;
    @Resource
    private QccBasicOriginalNameService qccBasicOriginalNameService;
    @Resource
    private QccBasicPartnersService qccBasicPartnersService;
    @Resource
    private QccBasicPenaltyCreditChinaService qccBasicPenaltyCreditChinaService;
    @Resource
    private QccBasicPenaltyService qccBasicPenaltyService;
    @Resource
    private QccBasicPermissionEciinfoService qccBasicPermissionEciinfoService;
    @Resource
    private QccBasicPermissionInfoService qccBasicPermissionInfoService;
    @Resource
    private QccBasicPledgeService qccBasicPledgeService;
    @Resource
    private QccBasicShixinItemsService qccBasicShixinItemsService;
    @Resource
    private QccBasicSpotCheckService qccBasicSpotCheckService;
    @Resource
    private QccBasicZhixingItemsService qccBasicZhixingItemsService;
    @Resource
    private QccBasicExceptionsService exceptionsService;

    @Override
    public PageUtils getCopyright(String name, Integer currPage, Integer pageSize, Integer updatePeriod) {
        //1.先查询 没有 请求
        Map map = new HashMap<String, Object>();
        map.put("page", currPage);
        map.put("limit", pageSize);
        map.put("ent_name", name);
        PageUtils page = copyrightService.queryPage(map);

        Integer period = updatePeriod != null && updatePeriod >= 0 ? updatePeriod : config.getUpdatePeriod();

        //没有查到  掉接口 如果接口还没有就说明都没有
        if (page.getTotalCount() == 0) {
            copyrightService.getApiQccCopyright(name);
            page = copyrightService.queryPage(map);

        } else if (
                DateUtil.betweenDay(((QccCopyrightEntity) page.getList().get(0)).getCreateTime(),
                        new Date(), false) >= period) {
            copyrightService.updateDataStatusByEntName(name, DataStatusEnum.UN_ACTIVE);
            copyrightService.getApiQccCopyright(name);
            page = copyrightService.queryPage(map);
        }

        page.setList(ejbGenerator.convert(page.getList(), QccCopyrightApiDTO.class));
        return page;
    }

    @Override
    public PageUtils getPatent(String name, Integer currPage, Integer pageSize, Integer updatePeriod) {
        //1.先查询 没有 请求
        Map map = new HashMap<String, Object>();
        map.put("page", currPage);
        map.put("limit", pageSize);
        map.put("ent_name", name);
        PageUtils page = qichachaDataPatentService.queryPage(map);

        Integer period = updatePeriod != null && updatePeriod >= 0 ? updatePeriod : config.getUpdatePeriod();

        //没有查到  掉接口 如果接口还没有就说明都没有
        //TODO 超过多久了要更新
        if (page.getTotalCount() == 0) {
            qichachaDataPatentService.getApiQccPatent(name);
            page = qichachaDataPatentService.queryPage(map);
        } else if (DateUtil.betweenDay(((QichachaDataPatentEntity) page.getList().get(0)).getCreateTime(),
                new Date(), false) >= period) {
            qichachaDataPatentService.updateDataStatusByEntName(name, DataStatusEnum.UN_ACTIVE);
            qichachaDataPatentService.getApiQccPatent(name);
            page = qichachaDataPatentService.queryPage(map);
        }
        page.setList(ejbGenerator.convert(page.getList(), QccPatentApiDTO.class));
        return page;
    }

    @Override
    public PageUtils getTradeMark(String name, Integer currPage, Integer pageSize, Integer updatePeriod) {
        //1.先查询 没有 请求
        Map map = new HashMap<String, Object>();
        map.put("page", currPage);
        map.put("limit", pageSize);
        map.put("ent_name", name);
        PageUtils page = qccTradeMarkService.queryPage(map);

        Integer period = updatePeriod != null && updatePeriod >= 0 ? updatePeriod : config.getUpdatePeriod();

        //没有查到  掉接口 如果接口还没有就说明都没有
        //TODO 超过多久了要更新
        if (page.getTotalCount() == 0) {
            qccTradeMarkService.getApiQccTradeMark(name);
            page = qccTradeMarkService.queryPage(map);
        } else if (DateUtil.betweenDay(((QccTradeMarkEntity) page.getList().get(0)).getCreateTime(),
                new Date(), false) >= period) {
            qccTradeMarkService.updateDataStatusByEntName(name, DataStatusEnum.UN_ACTIVE);
            qccTradeMarkService.getApiQccTradeMark(name);
            page = qccTradeMarkService.queryPage(map);
        }
        page.setList(ejbGenerator.convert(page.getList(), QccTrademarkApiDTO.class));
        return page;
    }

    @Override
    public PageUtils getViolation(String name, Integer currPage, Integer pageSize, Integer updatePeriod) {
        //1.先查询 没有 请求
        Map map = new HashMap<String, Object>();
        map.put("page", currPage);
        map.put("limit", pageSize);
        map.put("ent_name", name);
        PageUtils page = qccSeriousViolationService.queryPage(map);

        Integer period = updatePeriod != null && updatePeriod >= 0 ? updatePeriod : config.getUpdatePeriod();

        //没有查到  掉接口 如果接口还没有就说明都没有
        //TODO 超过多久了要更新
        if (page.getTotalCount() == 0) {
            qccSeriousViolationService.getApiQccViolation(name);
            page = qccSeriousViolationService.queryPage(map);
        } else if (DateUtil.betweenDay(((QccSeriousViolationEntity) page.getList().get(0)).getCreateTime(),
                new Date(), false) >= period) {
            qccSeriousViolationService.updateDataStatusByEntName(name, DataStatusEnum.UN_ACTIVE);
            qccSeriousViolationService.getApiQccViolation(name);
            page = qccSeriousViolationService.queryPage(map);
        }
        page.setList(ejbGenerator.convert(page.getList(), QccSeriousViolationApiDTO.class));
        return page;
    }

    @Override
    public QccFullDetailsDTO getFullDetailsByName(ApiQueryForm api) {
        Integer updatePeriod = api.getUpdatePeriod();
        Integer period = updatePeriod != null && updatePeriod >= 0 ? updatePeriod : config.getUpdatePeriod();
        QccBasicEntity qccBasicEntity = qccBasicService.selectOne(QichachaUtils.createWrapperByEntName(api.getName()));
        if (qccBasicEntity == null || DateUtil.betweenDay(qccBasicEntity.getCreateTime(), new Date(), true) > period) {
            qccBasicService.getData(api.getName());
            qccBasicEntity = qccBasicService.selectOne(QichachaUtils.createWrapperByEntName(api.getName()));
        }
        QccFullDetailsDTO qccFullDetailsDTO = new QccFullDetailsDTO();
        try {
            qccFullDetailsDTO.setBasic(QichachaUtils.toDtoMap(qccBasicEntity));
            qccFullDetailsDTO.setContactInfo(QichachaUtils.toDtoMap(qccBasicContactInfoService.selectOne(QichachaUtils.createWrapperByEntName(api.getName()))));
            qccFullDetailsDTO.setIndustry(QichachaUtils.toDtoMap(qccBasicIndustryService.selectOne(QichachaUtils.createWrapperByEntName(api.getName()))));
            qccFullDetailsDTO.setLiquidation(QichachaUtils.toDtoMap(qccBasicLiquidationService.selectOne(QichachaUtils.createWrapperByEntName(api.getName()))));
            qccFullDetailsDTO.setBranches(QichachaUtils.toListDtoMap(qccBasicBranchesService.selectList(QichachaUtils.createWrapperByEntName(api.getName()))));
            qccFullDetailsDTO.setChangeRecords(QichachaUtils.toListDtoMap(qccBasicChangeRecordsService.selectList(QichachaUtils.createWrapperByEntName(api.getName()))));
            qccFullDetailsDTO.setCompanyProducts(QichachaUtils.toListDtoMap(qccBasicCompanyProductsService.selectList(QichachaUtils.createWrapperByEntName(api.getName()))));
            qccFullDetailsDTO.setCompanyTaxCreditItems(QichachaUtils.toListDtoMap(qccBasicCompanyTaxCreditItemsService.selectList(QichachaUtils.createWrapperByEntName(api.getName()))));
            qccFullDetailsDTO.setEmployees(QichachaUtils.toListDtoMap(qccBasicEmployeesService.selectList(QichachaUtils.createWrapperByEntName(api.getName()))));
            qccFullDetailsDTO.setmPledge(QichachaUtils.toListDtoMap(qccBasicMPledgeService.selectList(QichachaUtils.createWrapperByEntName(api.getName()))));
            qccFullDetailsDTO.setOriginalName(QichachaUtils.toListDtoMap(qccBasicOriginalNameService.selectList(QichachaUtils.createWrapperByEntName(api.getName()))));
            qccFullDetailsDTO.setPartners(QichachaUtils.toListDtoMap(qccBasicPartnersService.selectList(QichachaUtils.createWrapperByEntName(api.getName()))));
            qccFullDetailsDTO.setPenaltyCreditChina(QichachaUtils.toListDtoMap(qccBasicPenaltyCreditChinaService.selectList(QichachaUtils.createWrapperByEntName(api.getName()))));
            qccFullDetailsDTO.setPenalty(QichachaUtils.toListDtoMap(qccBasicPenaltyService.selectList(QichachaUtils.createWrapperByEntName(api.getName()))));
            qccFullDetailsDTO.setPermissionEciInfo(QichachaUtils.toListDtoMap(qccBasicPermissionEciinfoService.selectList(QichachaUtils.createWrapperByEntName(api.getName()))));
            qccFullDetailsDTO.setPermissionInfo(QichachaUtils.toListDtoMap(qccBasicPermissionInfoService.selectList(QichachaUtils.createWrapperByEntName(api.getName()))));
            qccFullDetailsDTO.setPledge(QichachaUtils.toListDtoMap(qccBasicPledgeService.selectList(QichachaUtils.createWrapperByEntName(api.getName()))));
            qccFullDetailsDTO.setShiXinItems(QichachaUtils.toListDtoMap(qccBasicShixinItemsService.selectList(QichachaUtils.createWrapperByEntName(api.getName()))));
            qccFullDetailsDTO.setSpotCheck(QichachaUtils.toListDtoMap(qccBasicSpotCheckService.selectList(QichachaUtils.createWrapperByEntName(api.getName()))));
            qccFullDetailsDTO.setZhiXingItems(QichachaUtils.toListDtoMap(qccBasicZhixingItemsService.selectList(QichachaUtils.createWrapperByEntName(api.getName()))));
            qccFullDetailsDTO.setExceptions(QichachaUtils.toListDtoMap(exceptionsService.selectList(QichachaUtils.createWrapperByEntName(api.getName()))));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return qccFullDetailsDTO;
    }


    @Override
    public PageUtils getTender(String name, Integer currPage, Integer pageSize, Integer updatePeriod) {
        //1.先查询 没有 请求
        Map map = new HashMap<String, Object>();
        map.put("page", currPage);
        map.put("limit", pageSize);
        map.put("ent_name", name);
        PageUtils page = qccTenderService.queryPage(map);

        Integer period = updatePeriod != null && updatePeriod >= 0 ? updatePeriod : config.getUpdatePeriod();

        //没有查到  掉接口 如果接口还没有就说明都没有
        if (page.getTotalCount() == 0) {
            qccTenderService.getApiQccTender(name);
            page = qccTenderService.queryPage(map);
        } else if (
                DateUtil.betweenDay(((QccTenderEntity) page.getList().get(0)).getCreateTime(),
                        new Date(), false) >= period) {
            qccTenderService.updateDataStatusByEntName(name, DataStatusEnum.UN_ACTIVE);
            qccTenderService.getApiQccTender(name);
            page = qccTenderService.queryPage(map);
        }
        page.setList(ejbGenerator.convert(page.getList(), QccTenderApiDTO.class));
        return page;
    }
}
