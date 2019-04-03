package xin.tianchuang.modules.spider.processor;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhuzhengliang.
 * 行政许可分页列表爬取
 */
@Service
public class AdministrativeLicensingListProcessor implements PageProcessor {

    @Resource
    private AdministrativeLicensingContentProcessor administrativeLicensingContentProcessor;
    //行政许可第一页地址，包含部分数据，比如总条数等
    public static final String LICENSING_FIRST_PAGE_URL = "http://www.credithunan.gov.cn:30816/publicity_hn/webInfo/licenseList.do";
    //行政许可分页json数据请求地址
    public static final String LICENSING_LIST_URL = "http://www.credithunan.gov.cn:30816/publicity_hn/webInfo/licenseProxy.do?id2=8B86B4A723181B63D0AB54F8B6CA0C53D8909B58BDA72D9C7A30FFF2B3598F03F600E1D69D039FF84D0B009D64D2FAB223855768E587C9E7C515347BCBB75541D2D87A24DC3357DF&perpage=1&totalRecord=1";
    //最多尝试翻多少页,理论上如果每天都爬的话，应该翻不了多少页
    public static final int OVER_PAGE_NUM = 100 * 1000;
    //单页条数,依赖网站所能提供的每页数据量，不能随便改
    public static final int NUM_PER_PAGE = 10;

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);

    public void process(Page page) {
        String dataListStr = page.getRawText();
        dataListStr = dataListStr.substring(dataListStr.indexOf("["), dataListStr.indexOf("]") + 1);
        if (StringUtils.isNotBlank(dataListStr)) {
            Spider contentSpider = Spider.create(administrativeLicensingContentProcessor).thread(5);
            String[] dataArr = JSON.parseArray(dataListStr).toArray(new String[]{});
            for (String dataStr : dataArr) {
                String[] fields = dataStr.split("\\$");
                //将发布时间和id保存到request
                Map<String, Object> extras = new HashMap<String, Object>();
                extras.put("publishTimeStr", fields[5].trim());
                extras.put("unionId", fields[1].trim());
                Request request = new Request(AdministrativeLicensingContentProcessor.LICENSING_CONTENT_URL + fields[1])
                        .setExtras(extras)
                        .setMethod("post");
                contentSpider.addRequest(request);
            }
            contentSpider.run();
        }
    }

    public Site getSite() {
        return site;
    }

}
