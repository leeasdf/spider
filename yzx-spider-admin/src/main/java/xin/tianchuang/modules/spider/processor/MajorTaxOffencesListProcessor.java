package xin.tianchuang.modules.spider.processor;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yp-tc-m-7179 on 2018/10/8.
 */
@Component
public class MajorTaxOffencesListProcessor implements PageProcessor {
    public static final String FIRST_PAGE_URL = "http://www.credithunan.gov.cn/page/info/sincerityList.jsp?id=36BB388C42A2F9BBD16A1BA1E3A41200";
    //找到发布时间，最多尝试翻多少页,理论上如果每天都爬的话，应该翻不了多少页
    public static final int OVER_PAGE_NUM = 100 * 1000;
    //行政处罚分页json数据请求地址
    public static final String LIST_URL = "http://www.credithunan.gov.cn/page/info/promptsProxy.jsp?id=36BB388C42A2F9BBD16A1BA1E3A41200&perpage=20&totalRecord=20949";
    public static final String SEARCH_URL = "http://www.credithunan.gov.cn/page/searchList.jsp";
    //单页条数,依赖网站所能提供的每页数据量，不能随便改
    public static final int NUM_PER_PAGE = 10;

    @Resource
    private MajorTaxOffencesContentProcessor majorTaxOffencesContentProcessor;

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);

    public void process(Page page) {
        String dataListStr = page.getRawText();
        dataListStr = dataListStr.substring(dataListStr.indexOf("["), dataListStr.indexOf("]") + 1);
        spiderRun(dataListStr);
    }

    public Site getSite() {
        return site;
    }

    public void spiderRun(String dataListStr){
        if (StringUtils.isNotBlank(dataListStr)) {
            Spider contentSpider = Spider.create(majorTaxOffencesContentProcessor).thread(5);
            String[] dataArr = JSON.parseArray(dataListStr).toArray(new String[]{});
            for (String dataStr : dataArr) {
                String[] fields = dataStr.split("\\$");
                //将发布时间和id保存到request
                Map<String, Object> extras = new HashMap<String, Object>();
                extras.put("publishTimeStr", fields[3].trim());
                extras.put("unionId", fields[1].trim());
                extras.put("entName", fields[2].trim());
                Request request = new Request(MajorTaxOffencesContentProcessor.CONTENT_URL + fields[1])
                        .setExtras(extras)
                        .setMethod("post");
                contentSpider.addRequest(request);
            }
            contentSpider.run();
        }
    }
}
