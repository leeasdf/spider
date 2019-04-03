package xin.tianchuang.modules.dataparser.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xin.tianchuang.common.component.rabbit.RabbitConfig;
import xin.tianchuang.modules.dataparser.facade.CreditChinaFacade;
import xin.tianchuang.modules.dataparser.facade.CreditHunanFacade;
import xin.tianchuang.modules.spider.entity.SpiderRawDataEntity;

/**
 * Created by lee on 2018/10/25.
 * 监听消息队列处理消息
 */
@Component
public class CustomerMsg {

    private static final Logger LOGGER= LoggerFactory.getLogger(CustomerMsg.class);

    @Autowired
    private CustomerMsgHandler handler;

    @RabbitListener(queues = RabbitConfig.SPIDER_HUNAN_DATAPARSER)
    @RabbitHandler
    public void processCreditHunanMessage(SpiderRawDataEntity msg) {
        LOGGER.info(Thread.currentThread().getName() + " 接收到来自"+RabbitConfig.SPIDER_HUNAN_DATAPARSER +"队列的消息：" + msg.toString());
        handler.customerCreditHunanMsg(msg);
    }

    /**
     * 解析信用中国数据
     * @param msg
     */
    @RabbitListener(queues = RabbitConfig.SPIDER_CHINA_DATAPARSER)
    @RabbitHandler
    public void processCreditChinaMessage(SpiderRawDataEntity msg) {
        LOGGER.info(Thread.currentThread().getName() + " 接收到来自"+RabbitConfig.SPIDER_CHINA_DATAPARSER +"队列的消息：" + msg.toString());
        handler.customerCreditChinaMsg(msg);

    }


}
