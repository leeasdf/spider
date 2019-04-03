package xin.tianchuang.modules.spider.processor;

import java.util.Date;

import org.springframework.stereotype.Component;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.modules.spider.entity.SpiderRawDataEntity;
import xin.tianchuang.modules.spider.enums.SpiderTypeEnum;
import xin.tianchuang.modules.spider.rabbit.MsgSender;
import xin.tianchuang.modules.spider.service.SpiderRawDataService;

import javax.annotation.Resource;

/**
 * Created by yp-tc-m-7179 on 2018/10/10.
 */
@Component
public class LevelATaxerContentProcessor implements PageProcessor {

    public static final String CONTENT_URL = "http://www.credithunan.gov.cn/page/info/promptsDetail.jsp?tableId=70FC85017BB464A4EE20219D484A0716&cId=";
    @Resource
    private SpiderRawDataService spiderRawDataService;
    @Resource(name = "creditHunanSender")
    private MsgSender msgSender;

    private Site site = Site.me().setRetryTimes(3).setSleepTime(5000).setTimeOut(10000);

    public void process(Page page) {
        SpiderRawDataEntity levelATaxer = new SpiderRawDataEntity();
        //创建时间
        levelATaxer.setCreateTime(new Date());
        //数据有效性
        levelATaxer.setDataState(DataStatusEnum.ACTIVE.key());
        //发布时间，字符串类型
        String publishTimeStr = (String) page.getRequest().getExtra("publishTimeStr");
        levelATaxer.setType(SpiderTypeEnum.LEVEL_A_TAXER.key());
        levelATaxer.setUrl(page.getUrl().get());
        levelATaxer.setCursorIndex(publishTimeStr);
        levelATaxer.setEntName((String) page.getRequest().getExtra("entName"));
        levelATaxer.setContent(page.getHtml().get().trim());
        // 保存数据,消息发送
        spiderRawDataService.insert(levelATaxer);
        msgSender.send(levelATaxer);

    }

    public Site getSite() {
        return site;
    }
}
