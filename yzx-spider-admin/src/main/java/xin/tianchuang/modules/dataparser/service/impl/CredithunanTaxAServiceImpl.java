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
import xin.tianchuang.modules.dataparser.dao.CredithunanTaxADao;
import xin.tianchuang.modules.dataparser.entity.CredithunanTaxAEntity;
import xin.tianchuang.modules.dataparser.service.CredithunanTaxAService;
import xin.tianchuang.modules.spider.entity.SpiderRawDataEntity;
import xin.tianchuang.modules.spider.service.SpiderRawDataService;

import java.util.Map;


@Service("credithunanTaxAService")
public class CredithunanTaxAServiceImpl extends ServiceImpl<CredithunanTaxADao, CredithunanTaxAEntity> implements CredithunanTaxAService {

    @Autowired
    private SpiderRawDataService spiderRawDataService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String taxpayer = (String)params.get("taxpayer");
        String taxpayerNo=(String)params.get("taxpayerNo");
        String year=(String)params.get("year");

        params.put("sidx","createTime");
        params.put("order","DESC");

        Page<CredithunanTaxAEntity> page = this.selectPage(
                new Query<CredithunanTaxAEntity>(params).getPage(),
                new EntityWrapper<CredithunanTaxAEntity>()
                        .like(StringUtils.isNotBlank(taxpayer),"taxpayer",taxpayer)
                        .eq(StringUtils.isNotBlank(taxpayerNo),"taxpayer_no",taxpayerNo)
                        .eq(StringUtils.isNotBlank(year),"year",year)
                        .eq("data_status", DataStatusEnum.ACTIVE.key())
        );

        return new PageUtils(page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation= Propagation.REQUIRED)
    public void saveParserData(CredithunanTaxAEntity entity, SpiderRawDataEntity spiderRawDataEntity) throws Exception{

        //去重复
        delete(new EntityWrapper<CredithunanTaxAEntity>()
                .eq("taxpayer",entity.getTaxpayer())
                .eq("tax_type",entity.getTaxType())
                .eq("year",entity.getYear())
                .eq("data_status", DataStatusEnum.ACTIVE.key()));
        insert(entity);
        //test
        //String a=null;a.equals("1");
//        spiderRawDataEntity.setIfAnalysised(1);
//        spiderRawDataService.updateById(spiderRawDataEntity);
    }

    @Override
    public CredithunanTaxAEntity selectByTaxpayer(String taxpayer, String source) {
        return selectOne( new EntityWrapper<CredithunanTaxAEntity>()
                .eq("taxpayer",taxpayer)
                .eq("source",source)
                .eq("data_status", DataStatusEnum.ACTIVE.key())
        );
    }
}
