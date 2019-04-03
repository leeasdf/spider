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
import xin.tianchuang.modules.dataparser.dao.CredithunanTaxContraventionDao;
import xin.tianchuang.modules.dataparser.entity.CredithunanTaxContraventionEntity;
import xin.tianchuang.modules.dataparser.service.CredithunanTaxContraventionService;
import xin.tianchuang.modules.spider.entity.SpiderRawDataEntity;
import xin.tianchuang.modules.spider.service.SpiderRawDataService;

import java.util.Map;


@Service("credithunanTaxContraventionService")
public class CredithunanTaxContraventionServiceImpl extends ServiceImpl<CredithunanTaxContraventionDao, CredithunanTaxContraventionEntity> implements CredithunanTaxContraventionService {

    @Autowired
    private SpiderRawDataService spiderRawDataService;

    @Autowired
    private CredithunanTaxContraventionDao dao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String taxpayer = (String)params.get("taxpayer");
        String taxpayerNo=(String)params.get("taxpayerNo");
        String creditCode=(String)params.get("creditCode");
        String legal=(String)params.get("legal");

        params.put("sidx","createTime");
        params.put("order","DESC");

        Page<CredithunanTaxContraventionEntity> page = this.selectPage(
                new Query<CredithunanTaxContraventionEntity>(params).getPage(),
                new EntityWrapper<CredithunanTaxContraventionEntity>()
                        .like(StringUtils.isNotBlank(taxpayer),"taxpayer",taxpayer)
                        .eq(StringUtils.isNotBlank(taxpayerNo),"taxpayer_no",taxpayerNo)
                        .eq(StringUtils.isNotBlank(creditCode),"credit_code",creditCode)
                        .like(StringUtils.isNotBlank(legal),"legal",legal)
                        .eq("data_status", DataStatusEnum.ACTIVE.key())
        );

        return new PageUtils(page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation= Propagation.REQUIRED)
    public void saveParserData(CredithunanTaxContraventionEntity entity, SpiderRawDataEntity spiderRawDataEntity) {


        //删除老数据
        delete(new EntityWrapper<CredithunanTaxContraventionEntity>()
                .eq("taxpayer",entity.getTaxpayer())
                .eq("data_status", DataStatusEnum.ACTIVE.key())
        );
        insert(entity);

        //test
        //String a=null;a.equals("1");
//        spiderRawDataEntity.setIfAnalysised(1);
//        spiderRawDataService.updateById(spiderRawDataEntity);
    }


    @Override
    public CredithunanTaxContraventionEntity selectByTaxpayer(String taxpayer, String source) {
        return selectOne(new EntityWrapper<CredithunanTaxContraventionEntity>()
                .eq("taxpayer",taxpayer).eq("source",source)
                .eq("data_status", DataStatusEnum.ACTIVE.key())
        );
    }
}
