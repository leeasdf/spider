package xin.tianchuang.modules.spider.biz.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.stereotype.Service;
import xin.tianchuang.modules.spider.biz.CreditChinaSpiderBiz;
import xin.tianchuang.modules.spider.entity.HighTechZoneEnterpriseInfoEntity;
import xin.tianchuang.modules.spider.enums.SpiderTypeEnum;
import xin.tianchuang.modules.spider.service.CreditChinaService;
import xin.tianchuang.modules.spider.service.HighTechZoneEnterpriseInfoService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yp-tc-m-7179 on 2018/10/10.
 */
@Service
public class CreditChinaSpiderBizImpl implements CreditChinaSpiderBiz{
    @Resource
    private HighTechZoneEnterpriseInfoService highTechZoneEnterpriseInfoService;
    @Resource
    private CreditChinaService creditChinaService;

    @Override
    public void crawlData() throws Throwable{
        long id = creditChinaService.selectLatestIdByType(SpiderTypeEnum.CREDIT_CHINA.key());
        long max = highTechZoneEnterpriseInfoService.selectMaxId();
        long step = 10000;
        for (long i = id; i < max; i=i+step) {
            List<HighTechZoneEnterpriseInfoEntity> enterpriseInfoList = highTechZoneEnterpriseInfoService.selectList(new EntityWrapper<HighTechZoneEnterpriseInfoEntity>().gt("id",id).le("id",i+step));
            for (final HighTechZoneEnterpriseInfoEntity enterpriseInfo : enterpriseInfoList) {
                try {
                    creditChinaService.crawlData(enterpriseInfo);
                    Thread.sleep(20000);
                } catch (Throwable e) {
                    throw e;
                }
            }
        }
    }
}
