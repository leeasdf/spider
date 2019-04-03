package xin.tianchuang.modules.spider.task;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;
import xin.tianchuang.common.annotation.ExceptionLog;
import xin.tianchuang.modules.spider.entity.SpiderMissionEntity;
import xin.tianchuang.modules.spider.enums.SpiderTypeEnum;
import xin.tianchuang.modules.spider.service.CreditHunanSpiderService;
import xin.tianchuang.modules.spider.service.SpiderMissionService;
import xin.tianchuang.modules.spider.service.SpiderRawDataService;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by yp-tc-m-7179 on 2018/9/29.
 */
@Component("creditHunanSpiderTask")
public class CreditHunanSpiderTask {

    @Resource
    private CreditHunanSpiderService creditHunanSpiderService;
    @Resource
    private SpiderRawDataService spiderRawDataService;
    @Resource
    private SpiderMissionService spiderMissionService;

    /**
     * 爬取重大税收违法案件公告信息
     */
    @ExceptionLog("爬取重大税收违法案件公告信息")
    void crawlMajorTaxOffences() throws Throwable {
        RetryTemplate template = buildRetryTemplate("creditHunanSpiderTask", "crawlMajorTaxOffences");
        template.execute(new RetryCallback<Boolean, Throwable>() {
            @Override
            public Boolean doWithRetry(RetryContext retryContext) throws Throwable {
                final Date latestPublishDate = spiderRawDataService.selectLatestDateByType(SpiderTypeEnum.MAJOR_TAX_OFFENCES.key());
                creditHunanSpiderService.crawlMajorTaxOffences(latestPublishDate);
//                creditHunanSpiderService.crawlAdministrativePunishment("澧县宏达保安服务有限公司");
//                creditHunanSpiderService.crawlMajorTaxOffences("张家界宏天房地产开发有限公司");
//                creditHunanSpiderService.crawlLevelATaxer("光大永明人寿保险有限公司湖南分公司");
                return true;
            }
        });
    }

    /**
     * 爬取年度A级纳税人
     */
    @ExceptionLog("爬取年度A级纳税人")
    void crawlLevelATaxer() throws Throwable {
        RetryTemplate template = buildRetryTemplate("creditHunanSpiderTask", "crawlLevelATaxer");
        template.execute(new RetryCallback<Boolean, Throwable>() {
            @Override
            public Boolean doWithRetry(RetryContext retryContext) throws Throwable {
                final Date latestPublishDate = spiderRawDataService.selectLatestDateByType(SpiderTypeEnum.LEVEL_A_TAXER.key());
                creditHunanSpiderService.crawlLevelATaxer(latestPublishDate);
                return true;
            }
        });
    }

    /**
     * 爬取行政处罚信息
     */
    @ExceptionLog("爬取行政处罚信息")
    void crawlAdministrativePunishment() throws Throwable {
        RetryTemplate template = buildRetryTemplate("creditHunanSpiderTask", "crawlAdministrativePunishment");
        template.execute(new RetryCallback<Boolean, Throwable>() {
            @Override
            public Boolean doWithRetry(RetryContext retryContext) throws Throwable {
                final Date latestPublishDate = spiderRawDataService.selectLatestDateByType(SpiderTypeEnum.ADMINISTRATIVE_PUNISHMENT.key());
                creditHunanSpiderService.crawlAdministrativePunishment(latestPublishDate);
                return true;
            }
        });
    }

    /**
     * 爬取信用湖南-行政许可数据
     */
    @ExceptionLog("爬取信用湖南-行政许可数据")
    void crawlAdministrativeLicensing() throws Throwable {
        RetryTemplate template = buildRetryTemplate("creditHunanSpiderTask", "crawlAdministrativeLicensing");
        template.execute(new RetryCallback<Boolean, Throwable>() {
            @Override
            public Boolean doWithRetry(RetryContext retryContext) throws Throwable {
                final Date latestPublishDate = spiderRawDataService.selectLatestDateByType(SpiderTypeEnum.ADMINISTRATIVE_LICENSING.key());
                creditHunanSpiderService.crawAdministrativeLicensing(latestPublishDate);
//                creditHunanSpiderService.crawAdministrativeLicensing("浏阳市金豹烟花制造燃放有限公司");
//                creditHunanSpiderService.crawAbnormalNotice("岳阳昕安车友俱乐部有限公司");
//                creditHunanSpiderService.crawCreditATaxpayer("长沙市顺鑫机电紧固件有限公司");
                return true;
            }
        });
    }

    /**
     * 爬取信用湖南-非正常户公告数据
     */
    @ExceptionLog("爬取信用湖南-非正常户公告数据")
    void crawAbnormalNotice() throws Throwable {
        RetryTemplate template = buildRetryTemplate("creditHunanSpiderTask", "crawlAdministrativePunishment");
        template.execute(new RetryCallback<Boolean, Throwable>() {
            @Override
            public Boolean doWithRetry(RetryContext retryContext) throws Throwable {
                final Date latestPublishDate = spiderRawDataService.selectLatestDateByType(SpiderTypeEnum.ABNORMAL_NOTICE.key());
                creditHunanSpiderService.crawAbnormalNotice(latestPublishDate);
//                creditHunanSpiderService.crawAbnormalNoticeFirstPage();
                return true;
            }
        });
    }

    /**
     * 爬取信用湖南-地税-信用A级纳税人数据
     */
    @ExceptionLog("爬取信用湖南-信用A级纳税人数据")
    void crawCreditATaxpayer() throws Throwable {
        RetryTemplate template = buildRetryTemplate("creditHunanSpiderTask", "crawlAdministrativePunishment");
        template.execute(new RetryCallback<Boolean, Throwable>() {
            @Override
            public Boolean doWithRetry(RetryContext retryContext) throws Throwable {
                final Date latestPublishDate = spiderRawDataService.selectLatestDateByType(SpiderTypeEnum.CREDIT_A_TAXPAYER.key());
                creditHunanSpiderService.crawCreditATaxpayer(latestPublishDate);
                return true;
            }
        });
    }

    private RetryTemplate buildRetryTemplate(String beanName, String methodName) throws Throwable {
        SpiderMissionEntity searchCondition = new SpiderMissionEntity();
        searchCondition.setBeanName(beanName);
        searchCondition.setMethodName(methodName);
        //查询是否启用，重试次数
        SpiderMissionEntity spiderMissionEntity = spiderMissionService.selectOne(new EntityWrapper<>(searchCondition));
        if (spiderMissionEntity != null && spiderMissionEntity.getIfAvailable() == 1) {
            RetryTemplate template = new RetryTemplate();
            SimpleRetryPolicy policy = new SimpleRetryPolicy();
            policy.setMaxAttempts(spiderMissionEntity.getRetryTimes());
            template.setRetryPolicy(policy);
            return template;
        }
        return null;
    }

}
