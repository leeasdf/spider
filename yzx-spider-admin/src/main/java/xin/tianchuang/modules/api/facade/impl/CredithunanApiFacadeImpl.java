package xin.tianchuang.modules.api.facade.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.api.bean.v1.*;
import xin.tianchuang.modules.api.facade.CredithunanApiFacade;
import xin.tianchuang.modules.dataparser.service.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhuzhengliang on 2018/11/1.
 */
@Service
public class CredithunanApiFacadeImpl extends BaseFacadeImpl implements CredithunanApiFacade{

    private static  final Logger LOGGER= LoggerFactory.getLogger(CredithunanApiFacadeImpl.class);

    @Autowired
    private CredithunanAbnormalNoticeService credithunanAbnormalNoticeService;

    @Autowired
    private CredithunanAdministrativeLicensingService credithunanAdministrativeLicensingService;

    @Autowired
    private CredithunanAdministrativePenaltyService credithunanAdministrativePenaltyService;

    @Autowired
    private CredithunanTaxAService credithunanTaxAService;

    @Autowired
    private CredithunanTaxContraventionService credithunanTaxContraventionService;

    @Override
    public PageUtils getLevelATaxpayer(String name, Integer currPage) {
        Map map=new HashMap<String,Object>();
        map.put("taxpayer",name);
        map.put("page",currPage);
        map.put("limit","10");

        PageUtils page=credithunanTaxAService.queryPage(map);
        page.setList(ejbGenerator.convert(page.getList(), CredithunanTaxADTO.class));
        return page;
    }

    @Override
    public PageUtils getTaxIllegal(String name, Integer currPage) {
        Map map=new HashMap<String,Object>();
        map.put("taxpayer",name);
        map.put("page",currPage);
        map.put("limit","10");

        PageUtils page=credithunanTaxContraventionService.queryPage(map);
        page.setList(ejbGenerator.convert(page.getList(), CredithunanTaxContraventionDTO.class));
        return page;
    }

    @Override
    public PageUtils getAbnormalNotice(String name, Integer currPage) {
        Map map=new HashMap<String,Object>();
        map.put("taxpayer",name);
        map.put("page",currPage);
        map.put("limit","10");

        PageUtils page=credithunanAbnormalNoticeService.queryPage(map);
        page.setList(ejbGenerator.convert(page.getList(), CredithunanAbnormalNoticeDTO.class));
        return page;
    }

    @Override
    public PageUtils getAdministrativePenalty(String name, Integer currPage) {
        Map map=new HashMap<String,Object>();
        map.put("caseObject",name);
        map.put("page",currPage);
        map.put("limit","10");

        PageUtils page=credithunanAdministrativePenaltyService.queryPage(map);
        page.setList(ejbGenerator.convert(page.getList(), CredithunanAdministrativePenaltyDTO.class));
        return page;
    }

    @Override
    public PageUtils getAdministrativeLicensing(String name, Integer currPage) {
        Map map=new HashMap<String,Object>();
        map.put("caseObject",name);
        map.put("page",currPage);
        map.put("limit","10");

        PageUtils page=credithunanAdministrativeLicensingService.queryPage(map);
        page.setList(ejbGenerator.convert(page.getList(), CredithunanAdministrativeLicensingDTO.class));
        return page;
    }
}
