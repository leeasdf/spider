package xin.tianchuang.modules.spider.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import xin.tianchuang.modules.spider.bean.task.HnEntEnvCreditTaskParamDTO;
import xin.tianchuang.modules.spider.biz.CreditSpiderBiz;

import com.alibaba.fastjson.JSON;

@Component("creditSpiderTask")
public class CreditSpiderTask {

	private static Logger logger = LoggerFactory.getLogger(CreditSpiderTask.class);

	@Autowired
	private CreditSpiderBiz creditSpiderBiz;

	public void resultShow(String params) {
		logger.info("带参数{}，正在被执行", params);
		HnEntEnvCreditTaskParamDTO paramDTO = JSON.parseObject(params, HnEntEnvCreditTaskParamDTO.class);
		logger.info("爬取湖南省企业环境信用评价系统开始");
		creditSpiderBiz.resultShow(paramDTO);
		logger.info("爬取湖南省企业环境信用评价系统结束");
	}

	public void hnTaxQsgg() {
		logger.info("爬取-国家税务总局湖南省税务局开始");
		creditSpiderBiz.hnTaxQsgg();
		logger.info("爬取-国家税务总局湖南省税务局结束");
	}

	public void hnaicListmark() {
		logger.info("爬取湖南省工商行政管理局-驰名商标和著名商标开始");
		creditSpiderBiz.hnTaxQsgg();
		logger.info("爬取湖南省工商行政管理局-驰名商标和著名商标结束");
	}

	public void ccgpCr() {
		logger.info("爬取中国政府采购网-中国政府购买服务信息平台-政府采购严重违法失信行为信用记录开始");
		creditSpiderBiz.hnTaxQsgg();
		logger.info("爬取中国政府采购网-中国政府购买服务信息平台-政府采购严重违法失信行为信用记录结束");
	}

	public void hndsXydj() {
		logger.info("爬取-湖南省地方税务局-信用等级开始");
		creditSpiderBiz.hnTaxQsgg();
		logger.info("爬取-国家省地方税务局-信用等级结束");
	}

	public void hndsSwdj() {
		logger.info("爬取湖南省地方税务局-税务登记查询开始");
		creditSpiderBiz.hnTaxQsgg();
		logger.info("爬取湖南省地方税务局-税务登记查询结束");
	}
}
