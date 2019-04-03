package xin.tianchuang.modules.spider.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import xin.tianchuang.common.component.rabbit.RabbitConfig;

import javax.annotation.Resource;

/**
 * Created by yp-tc-m-7179 on 2018/10/29.
 *
 */
@Component("creditHunanSender")
public class CreditHunanSender implements MsgSender{

    private static final Logger LOGGER= LoggerFactory.getLogger(CreditHunanSender.class);

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Override
    public void send(Object msg) {
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME,RabbitConfig.SPIDER_KEY_HUNAN,msg);
    }
}
