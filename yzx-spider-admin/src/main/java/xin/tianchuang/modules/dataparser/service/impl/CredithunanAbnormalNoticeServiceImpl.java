package xin.tianchuang.modules.dataparser.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.dataparser.dao.CredithunanAbnormalNoticeDao;
import xin.tianchuang.modules.dataparser.entity.CredithunanAbnormalNoticeEntity;
import xin.tianchuang.modules.dataparser.entity.CredithunanTaxContraventionEntity;
import xin.tianchuang.modules.dataparser.service.CredithunanAbnormalNoticeService;
import xin.tianchuang.modules.spider.entity.SpiderRawDataEntity;
import xin.tianchuang.modules.spider.service.SpiderRawDataService;


@Service("credithunanAbnormalNoticeService")
public class CredithunanAbnormalNoticeServiceImpl extends ServiceImpl<CredithunanAbnormalNoticeDao, CredithunanAbnormalNoticeEntity> implements CredithunanAbnormalNoticeService {

    @Autowired
    private SpiderRawDataService spiderRawDataService;
    @Autowired
    private CredithunanAbnormalNoticeDao credithunanAbnormalNoticeDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String taxpayer = (String)params.get("taxpayer");
        String organizeCode=(String)params.get("organizeCode");
        String legalRepresentative=(String)params.get("legalRepresentative");

        params.put("sidx","createTime");
        params.put("order","DESC");

        Page<CredithunanAbnormalNoticeEntity> page = this.selectPage(
                new Query<CredithunanAbnormalNoticeEntity>(params).getPage(),
                new EntityWrapper<CredithunanAbnormalNoticeEntity>()
                .like(StringUtils.isNotBlank(taxpayer),"taxpayer",taxpayer)
                .eq(StringUtils.isNotBlank(organizeCode),"organize_code",organizeCode)
                .like(StringUtils.isNotBlank(legalRepresentative),"legal_representative",legalRepresentative)
        );

        return new PageUtils(page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation= Propagation.REQUIRED)
    public void saveParserData(CredithunanAbnormalNoticeEntity entity, SpiderRawDataEntity spiderRawDataEntity) {
//        entity.setSpiderId(spiderRawDataEntity.getId());
//        spiderRawDataEntity.setIfAnalysised(1);
        delete(new EntityWrapper<CredithunanAbnormalNoticeEntity>()
                .eq("taxpayer",entity.getTaxpayer())
                .eq("data_status", DataStatusEnum.ACTIVE.key())
        );
        insert(entity);

//        spiderRawDataService.updateById(spiderRawDataEntity);
    }

    @Override
    public CredithunanAbnormalNoticeEntity  selectByTaxpayer(String taxpayer) {
        return selectOne(new EntityWrapper<CredithunanAbnormalNoticeEntity>()
                .eq("taxpayer",taxpayer)
                .eq("data_status", DataStatusEnum.ACTIVE.key()));
    }
}
