package xin.tianchuang.modules.dataparser.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.dataparser.dao.CredithunanAdministrativePenaltyDao;
import xin.tianchuang.modules.dataparser.entity.CredithunanAdministrativePenaltyEntity;
import xin.tianchuang.modules.dataparser.service.CredithunanAdministrativePenaltyService;
import xin.tianchuang.modules.spider.entity.SpiderRawDataEntity;
import xin.tianchuang.modules.spider.service.SpiderRawDataService;

import java.util.Map;


@Service("credithunanAdministrativePenaltyService")
public class CredithunanAdministrativePenaltyServiceImpl extends ServiceImpl<CredithunanAdministrativePenaltyDao, CredithunanAdministrativePenaltyEntity> implements CredithunanAdministrativePenaltyService {

    @Autowired
    private SpiderRawDataService spiderRawDataService;

    @Autowired
    private CredithunanAdministrativePenaltyDao dao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String caseObject = (String)params.get("caseObject");
        String representative=(String)params.get("representative");

        params.put("sidx","createTime");
        params.put("order","DESC");

        Page<CredithunanAdministrativePenaltyEntity> page = this.selectPage(
                new Query<CredithunanAdministrativePenaltyEntity>(params).getPage(),
                new EntityWrapper<CredithunanAdministrativePenaltyEntity>()
                        .like(StringUtils.isNotBlank(caseObject),"case_object",caseObject)
                        .like(StringUtils.isNotBlank(representative),"representative",representative)
                        .eq("data_status", DataStatusEnum.ACTIVE.key())
        );

        return new PageUtils(page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation= Propagation.REQUIRED)
    public void saveParserData(CredithunanAdministrativePenaltyEntity entity, SpiderRawDataEntity spiderRawDataEntity) throws Exception {
        delete(new EntityWrapper<CredithunanAdministrativePenaltyEntity>()
                .eq("case_object",entity.getCaseObject())
                .eq("data_status", DataStatusEnum.ACTIVE.key())
        );
        insert(entity);
        //test
        //String a=null;a.equals("1");
//        spiderRawDataEntity.setIfAnalysised(1);
//        spiderRawDataService.updateById(spiderRawDataEntity);
    }

    @Override
    public CredithunanAdministrativePenaltyEntity selectByCaseObject(String caseObject) {
        return selectOne(new EntityWrapper<CredithunanAdministrativePenaltyEntity>()
                .eq("case_object",caseObject)
                .eq("data_status", DataStatusEnum.ACTIVE.key())
        );
    }

    @Override
    public PageUtils queryPageCaseObject(Map<String, Object> params) {
        String caseObject = (String)params.get("caseObject");

        params.put("sidx","createTime");
        params.put("order","DESC");

        Page<CredithunanAdministrativePenaltyEntity> page = this.selectPage(
                new Query<CredithunanAdministrativePenaltyEntity>(params).getPage(),
                new EntityWrapper<CredithunanAdministrativePenaltyEntity>()
                        .eq("case_object",caseObject)
                        .eq("data_status", DataStatusEnum.ACTIVE.key())
        );

        return new PageUtils(page);
    }
}
