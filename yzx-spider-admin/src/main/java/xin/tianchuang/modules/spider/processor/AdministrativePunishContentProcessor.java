package xin.tianchuang.modules.spider.processor;

import java.util.Date;

import org.springframework.stereotype.Service;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import xin.tianchuang.common.enums.TysDataStateEnum;
import xin.tianchuang.modules.spider.entity.SpiderRawDataEntity;
import xin.tianchuang.modules.spider.enums.SpiderTypeEnum;
import xin.tianchuang.modules.spider.rabbit.MsgSender;
import xin.tianchuang.modules.spider.service.SpiderRawDataService;

import javax.annotation.Resource;

/**
 * Created by yp-tc-m-7179 on 2018/9/29.
 *
 */
@Service
public class AdministrativePunishContentProcessor implements PageProcessor {
    @Resource
    private SpiderRawDataService spiderRawDataService;
    @Resource(name = "creditHunanSender")
    private MsgSender msgSender;
    public static final String PUNISH_CONTENT_URL = "http://www.credithunan.gov.cn:30816/publicity_hn/webInfo/punishmentDetail.do?id=";

    private Site site = Site.me().setRetryTimes(3).setSleepTime(5000).setTimeOut(10000);

    public void process(Page page) {
        SpiderRawDataEntity administrativePunishment = new SpiderRawDataEntity();
        //创建时间
        administrativePunishment.setCreateTime(new Date());
        //数据有效性
        administrativePunishment.setDataState(TysDataStateEnum.FINISH.key());
        //发布时间，字符串类型
        String publishTimeStr = (String) page.getRequest().getExtra("publishTimeStr");
        administrativePunishment.setType(SpiderTypeEnum.ADMINISTRATIVE_PUNISHMENT.key());
        administrativePunishment.setUrl(page.getUrl().get());
        administrativePunishment.setCursorIndex(publishTimeStr);
        administrativePunishment.setEntName(page.getHtml().xpath("//table[@class='xzcf_bg']/tbody/tr[2]/td[@class='xzcf_xx']/text(1)").get().trim());
        administrativePunishment.setContent(page.getHtml().xpath("//table[@class='round3']").get().trim());
        //todo 保存数据
        spiderRawDataService.insert(administrativePunishment);
        msgSender.send(administrativePunishment);
    }

    public Site getSite() {
        return site;
    }
}
