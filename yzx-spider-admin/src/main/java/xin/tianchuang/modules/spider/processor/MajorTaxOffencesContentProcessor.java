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
 * Created by yp-tc-m-7179 on 2018/10/8.
 */
@Component
public class MajorTaxOffencesContentProcessor implements PageProcessor {
    public static final String CONTENT_URL = "http://www.credithunan.gov.cn/page/info/promptsDetail.jsp?tableId=36BB388C42A2F9BBD16A1BA1E3A41200&cId=";
    @Resource
    private SpiderRawDataService spiderRawDataService;
    @Resource(name = "creditHunanSender")
    private MsgSender msgSender;
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);

    public void process(Page page) {
        SpiderRawDataEntity majorTaxOffences = new SpiderRawDataEntity();
        //创建时间
        majorTaxOffences.setCreateTime(new Date());
        //数据有效性
        majorTaxOffences.setDataState(DataStatusEnum.ACTIVE.key());
        //发布时间，字符串类型
        String publishTimeStr = (String) page.getRequest().getExtra("publishTimeStr");
        majorTaxOffences.setType(SpiderTypeEnum.MAJOR_TAX_OFFENCES.key());
        majorTaxOffences.setUrl(page.getUrl().get());
        majorTaxOffences.setCursorIndex(publishTimeStr);
        majorTaxOffences.setEntName((String) page.getRequest().getExtra("entName"));
        majorTaxOffences.setContent(page.getHtml().get().trim());
        // 保存数据
        spiderRawDataService.insert(majorTaxOffences);
        msgSender.send(majorTaxOffences);
    }

    public Site getSite() {
        return site;
    }
}
