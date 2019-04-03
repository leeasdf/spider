package xin.tianchuang.modules.dataparser.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by lee on 2018/10/26.
 */
@Component
public class SenderMsgToSpider {

    private static final Logger LOGGER= LoggerFactory.getLogger(SenderMsgToSpider.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(Object message,String ecxhangeName,String routingKey) {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        LOGGER.info("开始发送消息 : " + message);
        LOGGER.info("消息id:" + correlationData.getId());
        rabbitTemplate.convertAndSend(ecxhangeName, routingKey, message);
        LOGGER.info("结束发送消息 : " + message);
    }

}
