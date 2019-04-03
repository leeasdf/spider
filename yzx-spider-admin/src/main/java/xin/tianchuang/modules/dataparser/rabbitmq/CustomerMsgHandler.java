package xin.tianchuang.modules.dataparser.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xin.tianchuang.common.component.rabbit.RabbitConfig;
import xin.tianchuang.modules.dataparser.facade.CreditChinaFacade;
import xin.tianchuang.modules.dataparser.facade.CreditHunanFacade;
import xin.tianchuang.modules.spider.entity.SpiderRawDataEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lee on 2018/11/2.
 */
@Component
public class CustomerMsgHandler {

    @Autowired
    private SenderMsgToSpider producer;

    @Autowired
    private CreditChinaFacade creditChinaFacade;

    @Autowired
    private CreditHunanFacade creditHunanFacade;

    private static ExecutorService executors= Executors.newFixedThreadPool(10);

    public void customerCreditChinaMsg(SpiderRawDataEntity message) {
        executors.submit(new Thread(){
            @Override
            public void run() {
                if(creditChinaFacade.doBussiness(message)) {
                    message.setIfAnalysised(1);
                    producer.send(message, RabbitConfig.EXCHANGE_NAME,RabbitConfig.DATAPARSER_KEY_OK);
                }
            }
        });
    }

    public void customerCreditHunanMsg(SpiderRawDataEntity message) {
        executors.submit(new Thread(){
            @Override
            public void run() {
                if(creditHunanFacade.doBussiness(message)){
                    message.setIfAnalysised(1);
                    producer.send(message, RabbitConfig.EXCHANGE_NAME,RabbitConfig.DATAPARSER_KEY_OK);
                }
            }
        });
    }
}
