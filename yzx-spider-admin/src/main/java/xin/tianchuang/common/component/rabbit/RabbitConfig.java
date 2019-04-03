package xin.tianchuang.common.component.rabbit;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class RabbitConfig {

	@Value("${spring.rabbitmq.host}")
	private String addresses;

	@Value("${spring.rabbitmq.port}")
	private Integer port;

	@Value("${spring.rabbitmq.username}")
	private String username;

	@Value("${spring.rabbitmq.password}")
	private String password;

	@Value("${spring.rabbitmq.virtual-host}")
	private String virtualHost;

	@Value("${spring.rabbitmq.publisher-confirms}")
	private boolean publisherConfirms;

	@Value("${spring.rabbitmq.publisher-returns}")
	private boolean publisherReturns;

//	@Value("${spring.rabbitmq.queues}")
//	private String queues;

	public final static String EXCHANGE_NAME = "yzx_spider";
	// spider->dataspider 信用中国
	public final static String SPIDER_HUNAN_DATAPARSER = "spider_credithunan_dataparser";
	public final static String SPIDER_KEY_HUNAN = "spider_credithunan";
	//spider->dataspider 信用中国
	public final static String SPIDER_CHINA_DATAPARSER = "spider_creditchina_dataparser";
	public final static String SPIDER_KEY_CHINA = "spider_creditchina";

	// data-> spider 解析成功
	public final static String DATAPARSER_OK_SPIDER = "dataparser_ok";
	public final static String DATAPARSER_KEY_OK = "dataparser_ok";
	// data ->spider 重试
	public final static String DATAPARSER_RETRY_SPIDER = "dataparser_retry";
	public final static String DATAPARSER_KEY_RETRY = "dataparser_retry";
	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setHost(addresses);
		connectionFactory.setPort(port);
		connectionFactory.setUsername(username);
		connectionFactory.setPassword(password);
		connectionFactory.setVirtualHost(virtualHost);
		/** 如果要进行消息回调，则这里必须要设置为true */
		connectionFactory.setPublisherConfirms(publisherConfirms);
		connectionFactory.setPublisherReturns(publisherReturns);

		return connectionFactory;
	}

	/** 因为要设置回调类，所以应是prototype类型，如果是singleton类型，则回调类为最后一次设置 */
	// 发送消息的格式转换器
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate template = new RabbitTemplate(connectionFactory());
		template.setMessageConverter(new Jackson2JsonMessageConverter());
		return template;
	}

	// 接收消息的格式转换器
	@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		factory.setMessageConverter(new Jackson2JsonMessageConverter());
		return factory;
	}

	// 信道配置，直连交换机
	@Bean
	DirectExchange exchange() {
		return new DirectExchange(EXCHANGE_NAME, true, false);
	}

	// 配置队列规则属性 例如保活时间 持久化 是否自动删除等
	@Bean
	public Queue queueHunan() {
		Map<String, Object> arguments = new HashMap<>();
//		arguments.put("x-message-ttl", 25000);// 25秒自动删除
		Queue queue = new Queue(SPIDER_HUNAN_DATAPARSER, true, false, false, arguments);
		return queue;
	}
	@Bean
	public Queue queueChina() {
		Map<String, Object> arguments = new HashMap<>();
//		arguments.put("x-message-ttl", 25000);// 25秒自动删除
		Queue queue = new Queue(SPIDER_CHINA_DATAPARSER, true, false, false, arguments);
		return queue;
	}

	@Bean
	public Queue queueOK() {
		Map<String, Object> arguments = new HashMap<>();
//		arguments.put("x-message-ttl", 25000);// 25秒自动删除
		Queue queue = new Queue(DATAPARSER_OK_SPIDER, true, false, false, arguments);
		return queue;
	}
	@Bean
	public Queue queueRetry() {
		Map<String, Object> arguments = new HashMap<>();
//		arguments.put("x-message-ttl", 25000);// 25秒自动删除
		Queue queue = new Queue(DATAPARSER_RETRY_SPIDER, true, false, false, arguments);
		return queue;
	}

	// 绑定队列和exchange
	@Bean
	public Binding bindingHunan() {
		return BindingBuilder.bind(queueHunan()).to(exchange()).with(SPIDER_KEY_HUNAN);
	}
	@Bean
	public Binding bindingChina() {
		return BindingBuilder.bind(queueChina()).to(exchange()).with(SPIDER_KEY_CHINA);
	}
	@Bean
	public Binding bindingOK() {
		return BindingBuilder.bind(queueOK()).to(exchange()).with(DATAPARSER_KEY_OK);
	}
	@Bean
	public Binding bindingRetry() {
		return BindingBuilder.bind(queueRetry()).to(exchange()).with(DATAPARSER_KEY_RETRY);
	}

//	@Bean
//	public SimpleMessageListenerContainer messageContainer() {
//		// 加载处理消息A的队列
//		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
//		container.setQueues(queueChina(),queueHunan(),queueOK(),queueRetry());
//		container.setExposeListenerChannel(true);
//		// 设置最大的并发的消费者数量
//		container.setMaxConcurrentConsumers(10);
//		// 最小的并发消费者的数量
//		container.setConcurrentConsumers(1);
//		// 设置确认模式手工确认
//		container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
//		container.setMessageListener(new ChannelAwareMessageListener() {
//			@Override
//			public void onMessage(Message message, com.rabbitmq.client.Channel channel) throws Exception {
//				try {
//					System.out.println("消费端接收到消息:" + message.getMessageProperties() + ":" + new String(message.getBody()));
//					/**
//					 * 通过basic.qos方法设置prefetch_count=1，这样RabbitMQ就会使得每个Consumer在同一个时间点最多处理一个Message，
//					 * 换句话说,在接收到该Consumer的ack前,它不会将新的Message分发给它
//					*/
//					channel.basicQos(1);
//					byte[] body = message.getBody();
//					// logger.info("接收处理队列A当中的消息:" + new String(body));
//					/**
//					 * 为了保证永远不会丢失消息，RabbitMQ支持消息应答机制。 当消费者接收到消息并完成任务后会往RabbitMQ服务器发送一条确认的命令，然后RabbitMQ才会将消息删除。
//					 */
//					channel.basicAck(message.getMessageProperties().getDeliveryTag(), false); // false只确认当前一个消息收到，true确认所有consumer获得的消息
//				} catch (Exception e) {
//					e.printStackTrace();
//
//					if (message.getMessageProperties().getRedelivered()) {
//						System.out.println("消息已重复处理失败,拒绝再次接收...");
//						channel.basicReject(message.getMessageProperties().getDeliveryTag(), true); // 拒绝消息
//					} else {
//						System.out.println("消息即将再次返回队列处理...");
//						channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true); // requeue为是否重新回到队列
//					}
//				}
//			}
//		});
//		return container;
//	}

}