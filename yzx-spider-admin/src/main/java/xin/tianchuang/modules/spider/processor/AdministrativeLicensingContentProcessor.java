package xin.tianchuang.modules.spider.processor;

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
import java.util.Date;

/**
 * Created by zhuzhengliang on 2018/7/3.
 * 行政许可详细数据爬取
 */
@Service
public class AdministrativeLicensingContentProcessor implements PageProcessor {

    @Resource
    private SpiderRawDataService spiderRawDataService;

    public static final String LICENSING_CONTENT_URL = "http://www.credithunan.gov.cn:30816/publicity_hn/webInfo/licenseDetail.do?id=";

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);

    @Resource(name = "creditHunanSender")
    private MsgSender msgSender;

    public void process(Page page) {
        SpiderRawDataEntity spiderRawDataEntity = new SpiderRawDataEntity();
        spiderRawDataEntity.setEntName(page.getHtml().xpath("//table[@class='xzcf_bg']/tbody/tr[2]/td[@class='xzcf_xx']/text(1)").get().trim());
        spiderRawDataEntity.setCursorIndex((String) page.getRequest().getExtra("publishTimeStr"));
        spiderRawDataEntity.setCreateTime(new Date());
        spiderRawDataEntity.setUrl(page.getUrl().get());
        spiderRawDataEntity.setDataState(TysDataStateEnum.FINISH.key());
        spiderRawDataEntity.setType(SpiderTypeEnum.ADMINISTRATIVE_LICENSING.key());
        spiderRawDataEntity.setTypeDesc(SpiderTypeEnum.ADMINISTRATIVE_LICENSING.desc());
        spiderRawDataEntity.setContent(page.getHtml().xpath("//table[@class='round3']").get().trim());
        spiderRawDataService.insert(spiderRawDataEntity);
        msgSender.send(spiderRawDataEntity);
    }

    public Site getSite() {
        return site;
    }

}
