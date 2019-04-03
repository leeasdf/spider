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
 * Created by zhuzhengliang on 2018/10/10.
 */
@Service
public class AbnormalNoticeContentProcessor implements PageProcessor{
    public static final String ABNORMAL_NOTICE_CONTENT_URL = "http://www.credithunan.gov.cn/page/info/promptsDetail.jsp?tableId=9FEBBC60E2B677A9856C6D384C6E39C74C4C2B28B963A80D&cId=";
    @Resource
    private SpiderRawDataService spiderRawDataService;

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);

    @Resource(name = "creditHunanSender")
    private MsgSender msgSender;

    @Override
    public void process(Page page) {
        SpiderRawDataEntity abnormalNotice = new SpiderRawDataEntity();
        //创建时间
        abnormalNotice.setCreateTime(new Date());
        //数据有效性
        abnormalNotice.setDataState(TysDataStateEnum.FINISH.key());
        abnormalNotice.setUrl(page.getUrl().get());
        abnormalNotice.setEntName((String) page.getRequest().getExtra("entName"));
        abnormalNotice.setType(SpiderTypeEnum.ABNORMAL_NOTICE.key());
        abnormalNotice.setTypeDesc(SpiderTypeEnum.ABNORMAL_NOTICE.desc());
        //发布时间，字符串类型
        String publishTimeStr = (String) page.getRequest().getExtra("publishTimeStr");
        abnormalNotice.setContent(page.getHtml().get().trim());
        abnormalNotice.setCursorIndex(publishTimeStr);
        spiderRawDataService.insert(abnormalNotice);
        msgSender.send(abnormalNotice);
    }

    @Override
    public Site getSite() {
        return site;
    }
}
