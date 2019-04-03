package xin.tianchuang.modules.spider.processor;

import java.util.Date;

import org.springframework.stereotype.Service;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.enums.TysDataStateEnum;
import xin.tianchuang.modules.spider.entity.SpiderRawDataEntity;
import xin.tianchuang.modules.spider.enums.SpiderTypeEnum;
import xin.tianchuang.modules.spider.rabbit.MsgSender;
import xin.tianchuang.modules.spider.service.SpiderRawDataService;

import javax.annotation.Resource;

/**
 * Created by zhuzhengliang on 2018/10/11.
 */
@Service
public class CreditATaxpayerContentProcessor implements PageProcessor{

    public static final String CONTENT_URL = "http://www.credithunan.gov.cn/page/info/promptsDetail.jsp?tableId=1CBF63C2806A3AEEFFDAE00989DA4353&cId=";

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);

    @Resource
    private SpiderRawDataService spiderRawDataService;

    @Resource(name = "creditHunanSender")
    private MsgSender msgSender;

    public void process(Page page) {
        SpiderRawDataEntity levelATaxer = new SpiderRawDataEntity();
        //创建时间
        levelATaxer.setCreateTime(new Date());
        //数据有效性
        levelATaxer.setDataState(TysDataStateEnum.FINISH.key());
        //发布时间，字符串类型
        String publishTimeStr = (String) page.getRequest().getExtra("publishTimeStr");
        levelATaxer.setContent(page.getHtml().get().trim());
        levelATaxer.setCursorIndex(publishTimeStr);
        levelATaxer.setType(SpiderTypeEnum.CREDIT_A_TAXPAYER.key());
        levelATaxer.setTypeDesc(SpiderTypeEnum.CREDIT_A_TAXPAYER.desc());
        levelATaxer.setEntName((String) page.getRequest().getExtra("entName"));
        levelATaxer.setUrl(page.getUrl().get());
        //todo 保存数据
        spiderRawDataService.insert(levelATaxer);
        msgSender.send(levelATaxer);

    }

    public Site getSite() {
        return site;
    }
}
