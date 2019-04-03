package xin.tianchuang.modules.spider.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import xin.tianchuang.modules.spider.processor.CreditHunanTaxAProcessor;

@Api(value = "信用湖南")
@RestController
@RequestMapping("spider/credithunan")
public class SpiderCreditHunanTaxAController {

	private static final Logger logger = LoggerFactory.getLogger(SpiderCreditHunanTaxAController.class);

	@ApiOperation("采集省市区信息")
	@ResponseBody
	@RequestMapping(value = "/query")
	public String query() {
		try {
			String url = "http://www.credithunan.gov.cn/page/info/sincerityList.jsp?id=1CBF63C2806A3AEEFFDAE00989DA4353";
			CreditHunanTaxAProcessor processor = new CreditHunanTaxAProcessor();
			Spider spider = Spider.create(processor);
			spider.addUrl(url).addPipeline(new ConsolePipeline())
			// 开启5个线程同时执行
					.thread(50)
					// 启动爬虫
					.setExitWhenComplete(true).start();
			spider.stop();

		} catch (Exception e) {
			logger.error("异常：", e);
		}
		return "success";
	}

}
