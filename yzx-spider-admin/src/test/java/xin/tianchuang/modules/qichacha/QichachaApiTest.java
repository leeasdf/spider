package xin.tianchuang.modules.qichacha;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import xin.tianchuang.modules.api.facade.QichachaApiFacade;
import xin.tianchuang.modules.externalApi.qichacha.service.QccCopyrightService;
import xin.tianchuang.modules.externalApi.qichacha.service.QccTenderService;
import xin.tianchuang.modules.externalApi.qichacha.service.QccTradeMarkService;

/**
 * Created by lee on 2018/12/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
public class QichachaApiTest {

    @Autowired
    private QccCopyrightService  copyrightService;
    @Autowired
    private QccTradeMarkService qccTradeMarkService;

    @Autowired
    private QccTenderService qccTenderService;


    @Autowired
    private QichachaApiFacade qichachaApiFacade;

    @Test
    public void copyrightTest(){
        copyrightService.getApiQccCopyright("小米科技有限责任公司");
    }

    @Test
    public void tenderTest(){
        qccTenderService.getApiQccTender("上海携程商务有限公司");
    }

    @Test
    public void apiCopyrightTest(){
        //qichachaApiFacade.getCopyright("小米科技有限责任公司",1,20);
    }

    @Test
    public void tradeMarkTest(){
        qccTradeMarkService.getApiQccTradeMark("小米科技有限责任公司");
    }

}
