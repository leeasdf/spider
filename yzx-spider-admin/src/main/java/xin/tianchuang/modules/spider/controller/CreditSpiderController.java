package xin.tianchuang.modules.spider.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xin.tianchuang.common.utils.R;
import xin.tianchuang.modules.spider.bean.task.HnEntEnvCreditTaskParamDTO;
import xin.tianchuang.modules.spider.biz.CreditSpiderBiz;

@RestController
@RequestMapping("spider/out/")
@Api("")
public class CreditSpiderController {

	private static Logger logger = LoggerFactory.getLogger(CreditSpiderController.class);

	@Autowired
	private CreditSpiderBiz creditSpiderBiz;

	/**
	 * 爬取
	 */
	// http://202.103.114.13:8085/xypj/xypj/website/result_show.jsp?bg_class=topimg&area_id=430000
	@GetMapping("/hn/xypj/result_show")
	@ApiOperation("爬取湖南省企业环境信用评价系统")
	public R resultShow(@RequestBody String[] years) {
		List<String> yearList = Arrays.asList(years);
		HnEntEnvCreditTaskParamDTO dto = null;
		for (String year : yearList) {
			dto = new HnEntEnvCreditTaskParamDTO();
			dto.setYear(year);
			try {
				creditSpiderBiz.resultShow(dto);
			} catch (Exception e) {
				logger.error("爬取湖南省企业环境信号用评价系统异常", e);
				return R.error("采集失败");
			}
		}

		return R.ok("采集成功");
	}

	@GetMapping("/hntax/zhuanti/qsgg")
	@ApiOperation("爬取-国家税务总局湖南省税务局")
	public R hnTaxQsgg() {
		try {
			creditSpiderBiz.hnTaxQsgg();
		} catch (Exception e) {
			logger.error("爬取-国家税务总局湖南省税务局", e);
			return R.error("采集失败");
		}

		return R.ok("采集成功");
	}

	// 驰名商标 http://www.hnaic.gov.cn/visit/socialservice/a/listmark?marktype=1
	// 著名商标 http://www.hnaic.gov.cn/visit/socialservice/a/listmark?marktype=2
	// SELECT CASE mark_type WHEN 1 THEN '驰名商标' WHEN 2 THEN '著名商标' END '商标类别', mark_name '商标', blong_to_enterprise
	// '持有人', mark_to_pro '核定商品/服务', select_time '认定时间', enterprise_addr '所在地' FROM hnaic_mark_info;
	@GetMapping("/hnaic/listmark")
	@ApiOperation("爬取湖南省工商行政管理局-驰名商标和著名商标信息")
	public R hnaicListmark() {
		try {
			creditSpiderBiz.hnaicListmark();
		} catch (Exception e) {
			logger.error("爬取湖南省工商行政管理局-驰名商标和著名商标信息", e);
			return R.error("采集失败");
		}

		return R.ok("采集成功");
	}

	@GetMapping("/ccgp/cr")
	@ApiOperation("爬取中国政府采购网-中国政府购买服务信息平台-政府采购严重违法失信行为信用记录")
	public R ccgpCr() {
		try {
			creditSpiderBiz.ccgpCr();
		} catch (Exception e) {
			logger.error("爬取中国政府采购网-中国政府购买服务信息平台-政府采购严重违法失信行为信用记录", e);
			return R.error("采集失败");
		}

		return R.ok("采集成功");
	}

	// SELECT COUNT(*) FROM hnds_credit_level WHERE years='2017年度'; -- 11694
	// SELECT COUNT(*) FROM hnds_credit_level WHERE years='2016年度'; -- 4939
	// SELECT COUNT(*) FROM hnds_credit_level WHERE years='2015年度'; -- 2837
	// SELECT COUNT(*) FROM hnds_credit_level WHERE years='2014年度'; -- 960
	// SELECT COUNT(*) FROM hnds_credit_level WHERE years='2012-2013年度'; -- 815
	@GetMapping("/hnds/xydj")
	@ApiOperation("爬取湖南省地方税务局-信用等级查询")
	public R hndsXydj() {
		try {
			creditSpiderBiz.hndsXydj();
		} catch (Exception e) {
			logger.error("爬取湖南省地方税务局-信用等级查询", e);
			return R.error("采集失败");
		}

		return R.ok("采集成功");
	}

	@GetMapping("/hnds/swdj")
	@ApiOperation("爬取湖南省地方税务局-税务登记信息查询")
	public R hndsSwdj() {
		try {
			creditSpiderBiz.hndsSwdj();
		} catch (Exception e) {
			logger.error("爬取湖南省地方税务局-税务登记查询", e);
			return R.error("采集失败");
		}

		return R.ok("采集成功");
	}

	@GetMapping("/hnaic/notice")
	@ApiOperation("爬取湖南省地方税务局-税务登记信息查询")
	public R hnaicNotice() {
		String url = "http://gsxt.hnaic.gov.cn/notice/notice/view?uuid=am0Tuetld_35QWU1uOGAew6CNo0wJ1Io"; // 进入页面
		Connection conn = Jsoup.connect(url);
		conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		conn.header("Accept-Encoding", "gzip, deflate");
		conn.header("Accept-Language", "zh-CN,zh;q=0.9");
		conn.header("Connection", "keep-alive");
		conn.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");

		try {
			Response response = conn.ignoreContentType(true).followRedirects(true).method(Method.GET).execute();
			Map<String, String> cookies = response.cookies();
			logger.info(response.body());
			Document doc = response.parse();
			Element elementById = doc.getElementById("iconOpState");
			logger.info(elementById.text());

		} catch (IOException e) {
			e.printStackTrace();
			R.error();
		}
		return R.ok();
	}
}
