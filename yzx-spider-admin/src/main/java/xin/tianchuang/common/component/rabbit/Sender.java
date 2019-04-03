package xin.tianchuang.common.component.rabbit;

import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class Sender implements RabbitTemplate.ConfirmCallback, ReturnCallback {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@PostConstruct
	public void init() {
		rabbitTemplate.setConfirmCallback(this);
		rabbitTemplate.setReturnCallback(this);
	}

	@Override
	public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
//		System.out.println(message.getMessageProperties().getCorrelationIdString() + " 发送失败");
		System.out.println("发送失败");
	}

	// 发送消息，不需要实现任何接口，供外部调用。
	public void send(String topic, String message) {
		CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());

		System.out.println("开始发送消息 : " + message.toLowerCase());
		System.out.println("消息id:" + correlationData.getId());
		// 用RabbitMQ发送MQTT需将exchange配置为amq.topic,
		// convertAndSend和send的区别是这个convert更方便使用，可以传object进去
		// this.rabbitTemplate.convertAndSend("amq.topicExchange", topic, message, correlationData);
		String response = rabbitTemplate.convertSendAndReceive("topicExchange", "key.1", message, correlationData).toString();
		System.out.println("结束发送消息 : " + message.toLowerCase());
		System.out.println("消费者响应 : " + response + " 消息处理完成");
	}

	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		System.out.println("消息id:" + correlationData.getId());
		if (ack) {
			System.out.println("消息发送确认成功");
		} else {
			System.out.println("消息发送确认失败:" + cause);
		}
	}

}
