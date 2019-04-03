package xin.tianchuang.modules.spider.processor;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import xin.tianchuang.common.constant.HttpClientConstant;

public class CreditHunanTaxAProcessor implements PageProcessor {

	private static final Logger logger = LoggerFactory.getLogger(CreditHunanTaxAProcessor.class);

	private Site site = null;

	public CreditHunanTaxAProcessor() {
		site = Site.me().setRetryTimes(3).setSleepTime(0).setTimeOut(1 * 1000).addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
				.addHeader("Accept-Encoding", "gzip, deflate").addHeader("Accept-Language", "zh-CN,zh;q=0.9").addHeader("Cache-Control", "max-age=0").addHeader("Connection", "keep-alive")
				.addHeader("Referer", "http://www.credithunan.gov.cn/search/enterpriseCreditTips.do").addHeader("Upgrade-Insecure-Requests", "1")
				.addCookie("Hm_lvt_7d526091137c4d73c0972b442b5d0a93", "1537153102,1537173151").addCookie("Hm_lvt_551f91d17e549ed1201d2298a4623a11", "1537153102,1537173151")
				.addCookie("JSESSIONID", "AA6942F2A562EE4DC26EABB7CCECB875").addCookie("Hm_lpvt_7d526091137c4d73c0972b442b5d0a93", "1537259850")
				.addCookie("Hm_lpvt_551f91d17e549ed1201d2298a4623a11", "1537259850").setDomain("www.credithunan.gov.cn").setUserAgent(HttpClientConstant.USER_AGENT_GOOGLE);
	}

	@Override
	public Site getSite() {
		return site;
	}

	@Override
	public void process(Page page) {
		Html html = page.getHtml();
		Document doc = Jsoup.parse(html.toString());
		String baseUri = page.getUrl().toString();
		doc.setBaseUri(baseUri.substring(0, baseUri.lastIndexOf("/") + 1));
		if (page.getUrl().regex("http://www.credithunan.gov.cn/page/info/sincerityList.jsp").match()) { // 市
			/* 用來封裝要保存的参数 */
			Map<String, Object> map = new HashMap<String, Object>();
			// 数据更新时间
			String tid = doc.getElementById("tid").val();
			// String dataTime = tid.substring(tid.indexOf("更新时间：", tid.length()));
			Elements es = doc.getElementsByTag("script").eq(12);
			for (Element e : es) {
				/* 取得JS变量数组 */
				String scriptStr = e.data().toString();
				String[] data = scriptStr.split("var");
				/* 取得单个JS变量 */
				for (String variable : data) {
					/* 过滤variable为空的数据 */
					if (variable.contains("=")) {
						/* 取到满足条件的JS变量 */
						if (variable.contains("initData")) {
							String[] kvp = variable.split("=");
							if (!map.containsKey(kvp[0].trim())) {
								map.put(kvp[0].trim(), kvp[1].trim().substring(0, kvp[1].trim().length() - 1).toString());
							}
						}
					}

					// 获取 totalRecord
					// 获取 perPage
				}

				// 获取$('#promptspage').jpage({
				String promptspage = scriptStr.substring(scriptStr.indexOf("$('#promptspage').jpage({"), scriptStr.indexOf("});"));
				Gson gson = new Gson();
				Map<String, Object> map1 = new HashMap<String, Object>();
				map1 = gson.fromJson(promptspage, map.getClass()); // #关键
				String goodsid = (String) map1.get("goods_id");
				System.out.println("map的值为:" + goodsid);
				// 获取 totalRecord
				// 获取 perPage

			}
			// String tableId = doc.getElementById("tableId").val();
			// String inTime = ""; // yyyy-mm-dd hh:MM:ss
			// String cId = "";

			// String initData = (String) map.get("initData");
			// initData.substring(initData.indexOf("["), initData.lastIndexOf("]"));
			// post 提交 详情页
			// http://www.credithunan.gov.cn/page/info/promptsDetail.jsp
		}

	}

}
