package xin.tianchuang.modules.dataparser;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import xin.tianchuang.modules.dataparser.rabbitmq.SendMsgHandler;
import xin.tianchuang.modules.spider.entity.SpiderRawDataEntity;
import xin.tianchuang.modules.spider.enums.SpiderTypeEnum;
import xin.tianchuang.modules.spider.service.SpiderRawDataService;

import java.util.List;

/**
 * Created by lee on 2018/10/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
public class MqTest {

    @Autowired
    private SendMsgHandler handler;

    @Autowired
    private SpiderRawDataService spiderRawDataService;

    @Test
    public void testSenderMessage(){
        List<SpiderRawDataEntity> entityList= spiderRawDataService.selectListByEnterpriseNameAndType("", SpiderTypeEnum.CREDIT_CHINA);
        for(SpiderRawDataEntity entity:entityList){
            handler.sendSuccessMsgToSpider(entity);
        }

    }
}
