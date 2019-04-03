package xin.tianchuang.common.component.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
public class Receiver {

	@RabbitListener(queues = "hello.queue1")
	@RabbitHandler
	public String processMessage1(String msg) {
		System.out.println(Thread.currentThread().getName() + " 接收到来自amq.topic.queue1队列的消息：" + msg);
		return msg.toUpperCase();
	}

	@RabbitListener(queues = "hello.queue2")
	@RabbitHandler
	public void processMessage2(String msg) {
		System.out.println(Thread.currentThread().getName() + " 接收到来自amq.topic.queue2队列的消息：" + msg);
	}
}