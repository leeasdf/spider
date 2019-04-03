package xin.tianchuang.modules.dataparser.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xin.tianchuang.common.component.rabbit.RabbitConfig;
import xin.tianchuang.modules.spider.entity.SpiderRawDataEntity;
import xin.tianchuang.modules.spider.enums.SpiderTypeEnum;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lee on 2018/10/29.
 */
@Component
public class SendMsgHandler {

    @Autowired
    private SenderMsgToSpider producer;

    private static ExecutorService executors= Executors.newFixedThreadPool(10);

    /**
     * 发消息异步化，用过启动一个线程去异步处理 保证速度
     * @param message
     */
    public void sendSuccessMsgToSpider(SpiderRawDataEntity message) {
        message.setIfAnalysised(1);
        executors.submit(new Thread(){
            @Override
            public void run() {
                producer.send(message,RabbitConfig.EXCHANGE_NAME,RabbitConfig.DATAPARSER_KEY_OK);
            }
        });
    }

    /**
     * 还有两个属性 一个企业名称一个类型(网站内容项)
     * @param
     */
    public void sendSpiderDataMsgToSpider(String entName , SpiderTypeEnum  typeEnum) {
        SpiderRawDataEntity message=new SpiderRawDataEntity();
        message.setEntName(entName);
        message.setType(typeEnum.key());
        executors.submit(new Thread(){
            @Override
            public void run() {
                producer.send(message,RabbitConfig.EXCHANGE_NAME,RabbitConfig.DATAPARSER_KEY_RETRY);
            }
        });
    }

}
