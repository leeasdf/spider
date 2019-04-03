package xin.tianchuang.modules.spider.task;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;
import xin.tianchuang.common.annotation.ExceptionLog;
import xin.tianchuang.modules.spider.biz.CreditChinaSpiderBiz;
import xin.tianchuang.modules.spider.entity.SpiderMissionEntity;
import xin.tianchuang.modules.spider.service.SpiderMissionService;

import javax.annotation.Resource;

/**
 * Created by yp-tc-m-7179 on 2018/10/10.
 */
@Component("creditChinaSpiderTask")
public class CreditChinaSpiderTask {
    @Resource
    private CreditChinaSpiderBiz creditChinaSpiderBiz;
    @Resource
    private SpiderMissionService spiderMissionService;

    /**
     * 爬取信用中国数据
     */
    @ExceptionLog("爬取数据-信用中国")
    void crawlCreditChina() throws Throwable {
        SpiderMissionEntity searchCondition = new SpiderMissionEntity();
        searchCondition.setBeanName("creditChinaSpiderTask");
        searchCondition.setMethodName("crawlCreditChina");
        //查询是否启用，重试次数
        SpiderMissionEntity spiderMissionEntity = spiderMissionService.selectOne(new EntityWrapper<>(searchCondition));
        if (spiderMissionEntity != null && spiderMissionEntity.getIfAvailable() == 1) {
            RetryTemplate template = new RetryTemplate();
            SimpleRetryPolicy policy = new SimpleRetryPolicy();
            policy.setMaxAttempts(spiderMissionEntity.getRetryTimes());
            template.setRetryPolicy(policy);
            template.execute(new RetryCallback<Boolean, Throwable>() {
                @Override
                public Boolean doWithRetry(RetryContext retryContext) throws Throwable {
                    creditChinaSpiderBiz.crawlData();
                    return true;
                }
            });
        }
    }
}
