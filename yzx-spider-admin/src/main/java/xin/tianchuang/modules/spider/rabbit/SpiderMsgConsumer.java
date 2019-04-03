package xin.tianchuang.modules.spider.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import xin.tianchuang.common.annotation.ExceptionLog;
import xin.tianchuang.common.component.rabbit.RabbitConfig;
import xin.tianchuang.modules.spider.service.CreditChinaService;
import xin.tianchuang.modules.spider.entity.SpiderRawDataEntity;
import xin.tianchuang.modules.spider.enums.SpiderTypeEnum;
import xin.tianchuang.modules.spider.service.CreditHunanSpiderService;
import xin.tianchuang.modules.spider.service.SpiderRawDataService;

import javax.annotation.Resource;

/**
 * Created by yp-tc-m-7179 on 2018/10/29.
 *
 */
@Component
public class SpiderMsgConsumer {

    private static final Logger LOGGER= LoggerFactory.getLogger(SpiderMsgConsumer.class);
    @Resource
    private CreditHunanSpiderService creditHunanSpiderService;
    @Resource
    private CreditChinaService creditChinaService;
    @Resource
    private SpiderRawDataService spiderRawDataService;


    @RabbitListener(queues = RabbitConfig.DATAPARSER_OK_SPIDER)
    @RabbitHandler
    public void consumeResult(SpiderRawDataEntity msg) throws Throwable{
        LOGGER.info(Thread.currentThread().getName() + " 接收到来自"+RabbitConfig.DATAPARSER_OK_SPIDER +"队列的消息：" + msg.toString());
        spiderRawDataService.updateById(msg);
    }

    @RabbitListener(queues = RabbitConfig.DATAPARSER_RETRY_SPIDER)
    @RabbitHandler
    @ExceptionLog("通过企业名称查询、爬取数据")
    public void consumeNewEntData(SpiderRawDataEntity msg) throws Throwable{
        LOGGER.info(Thread.currentThread().getName() + " 接收到来自"+RabbitConfig.DATAPARSER_RETRY_SPIDER +"队列的消息：" + msg.toString());
        Integer type = msg.getType();
        SpiderTypeEnum typeEnum=SpiderTypeEnum.transfar(type);
        String entName = msg.getEntName();
        switch (typeEnum){
            case CREDIT_CHINA:
                creditChinaService.crawlData(entName);
                break;
            case ADMINISTRATIVE_PUNISHMENT:
                creditHunanSpiderService.crawlAdministrativePunishment(entName);
                break;
            case MAJOR_TAX_OFFENCES:
                creditHunanSpiderService.crawlMajorTaxOffences(entName);
                break;
            case LEVEL_A_TAXER:
                creditHunanSpiderService.crawlLevelATaxer(entName);
                break;
            case ADMINISTRATIVE_LICENSING:
                creditHunanSpiderService.crawAdministrativeLicensing(entName);
                break;
            case ABNORMAL_NOTICE:
                creditHunanSpiderService.crawAbnormalNotice(entName);
                break;
            case CREDIT_A_TAXPAYER:
                creditHunanSpiderService.crawCreditATaxpayer(entName);
                break;
        }
    }
}
