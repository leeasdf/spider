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
import xin.tianchuang.modules.dataparser.dao.CredithunanAdministrativeLicensingDao;
import xin.tianchuang.modules.dataparser.entity.CredithunanAdministrativeLicensingEntity;
import xin.tianchuang.modules.dataparser.service.CredithunanAdministrativeLicensingService;
import xin.tianchuang.modules.spider.entity.SpiderRawDataEntity;
import xin.tianchuang.modules.spider.service.SpiderRawDataService;

import java.util.Map;

@Service("credithunanAdministrativeLicensingService")
public class CredithunanAdministrativeLicensingServiceImpl extends ServiceImpl<CredithunanAdministrativeLicensingDao, CredithunanAdministrativeLicensingEntity> implements CredithunanAdministrativeLicensingService {

    @Autowired
    private SpiderRawDataService spiderRawDataService;

    @Autowired
    private CredithunanAdministrativeLicensingDao dao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        String caseObject = (String)params.get("caseObject");
        String legalRepresentative=(String)params.get("legalRepresentative");
        params.put("sidx","createTime");
        params.put("order","DESC");

        Page<CredithunanAdministrativeLicensingEntity> page = this.selectPage(
                new Query<CredithunanAdministrativeLicensingEntity>(params).getPage(),
                new EntityWrapper<CredithunanAdministrativeLicensingEntity>()
                        .like(StringUtils.isNotBlank(caseObject),"case_object",caseObject)
                        .like(StringUtils.isNotBlank(legalRepresentative),"legal_representative",legalRepresentative)
                        .eq("data_status", DataStatusEnum.ACTIVE.key())
        );

        return new PageUtils(page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation= Propagation.REQUIRED)
    public void saveParserData(CredithunanAdministrativeLicensingEntity entity, SpiderRawDataEntity spiderRawDataEntity) throws Exception {
//        entity.setSpiderId(spiderRawDataEntity.getId());
//        spiderRawDataEntity.setIfAnalysised(1);
        delete(new EntityWrapper<CredithunanAdministrativeLicensingEntity>().eq("case_object",entity.getCaseObject()));
        insert(entity);
//        spiderRawDataService.updateById(spiderRawDataEntity);
    }

    @Override
    public CredithunanAdministrativeLicensingEntity selectByCaseObject(String caseObject) {
        return selectOne(
                new EntityWrapper<CredithunanAdministrativeLicensingEntity>()
                        .eq("case_object",caseObject)
                        .eq("data_status", DataStatusEnum.ACTIVE.key())
        );
    }

    @Override
    public PageUtils queryPageByCaseObject(Map<String, Object> params) {

        params.put("sidx","createTime");
        params.put("order","DESC");

        Page<CredithunanAdministrativeLicensingEntity> page = this.selectPage(
                new Query<CredithunanAdministrativeLicensingEntity>(params).getPage(),
                new EntityWrapper<CredithunanAdministrativeLicensingEntity>()
                        .eq("case_object",params.get("caseObject").toString())
                        .eq("data_status", DataStatusEnum.ACTIVE.key())
        );

        return new PageUtils(page);
    }
}
