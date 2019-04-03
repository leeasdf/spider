package xin.tianchuang.modules.spider.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import xin.tianchuang.common.constant.PageConstant;
import xin.tianchuang.modules.spider.biz.TycSpiderBiz;

@Controller
@RequestMapping("/spider/out")
public class TycController {

	private static Logger logger = LoggerFactory.getLogger(TycController.class);

	@Autowired
	private TycSpiderBiz tycSpiderBiz;

	/**
	 * 查询状态为成功的所有企业列表
	 * 
	 * @param request
	 */
	@ResponseBody
	@RequestMapping("/getData")
	public void getData(HttpServletRequest request) {
		logger.info("获取");
		tycSpiderBiz.getTycSpiderEnterpriseListData(PageConstant.PAGE_FETCH, 0, null, null, null, true); // 未生成
	}

	@ResponseBody
	@RequestMapping("/getErrorData")
	public void getErrorData(HttpServletRequest request) {
		tycSpiderBiz.getTycSpiderEnterpriseListData(PageConstant.PAGE_FETCH, 5, null, null, null, true); // 爬取异常
	}

	@ResponseBody
	@RequestMapping("/getDataByStatus")
	public void getTycSpiderSjzEnterpriseListData(HttpServletRequest request, @RequestParam("fetch") Integer fetch, @RequestParam("status") Integer status, @RequestParam("province") String province,
			@RequestParam("city") String city) {
		tycSpiderBiz.getTycSpiderEnterpriseListData(fetch, status, province, city, null, true);
	}

	@ResponseBody
	@RequestMapping("/cs/getDataByStatus")
	public void getData(HttpServletRequest request, @RequestParam("fetch") Integer fetch, @RequestParam("status") Integer status) {
		tycSpiderBiz.getTycSpiderEnterpriseListData(fetch, status, "湖南", "长沙", null, true);
	}

	@ResponseBody
	@RequestMapping("/sjz/getDataByStatus")
	public void getTycSpiderSjzEnterpriseListData(HttpServletRequest request, @RequestParam("fetch") Integer fetch, @RequestParam("status") Integer status) {
		tycSpiderBiz.getTycSpiderEnterpriseListData(fetch, status, "河北", "石家庄", "石家庄第一批", true);
	}

	@ResponseBody
	@RequestMapping("/gd/getDataByStatus")
	public void getGdData(HttpServletRequest request, @RequestParam("fetch") Integer fetch, @RequestParam("status") Integer status) {
		tycSpiderBiz.getTycSpiderEnterpriseListData(fetch, status, "广东", "", "第一批", true);
	}
	
	@ResponseBody
	@RequestMapping("/gd/getDataByStatusBak")
	public void getGdDatByStatusa(HttpServletRequest request, @RequestParam("fetch") Integer fetch, @RequestParam("status") Integer status) {
		tycSpiderBiz.getTycSpiderEnterpriseListData(fetch, status, "广东", "", "第一批", false);
	}

	@ResponseBody
	@RequestMapping("/js/getDataByStatus")
	public void getJsData(HttpServletRequest request, @RequestParam("fetch") Integer fetch, @RequestParam("status") Integer status) {
		tycSpiderBiz.getTycSpiderEnterpriseListData(fetch, status, "江苏", "", "第一批", true);
	}
	
	@ResponseBody
	@RequestMapping("/js/getDataByStatusBak")
	public void getJsDatByStatus(HttpServletRequest request, @RequestParam("fetch") Integer fetch, @RequestParam("status") Integer status) {
		tycSpiderBiz.getTycSpiderEnterpriseListData(fetch, status, "江苏", "", "第一批", false);
	}
	
	@ResponseBody
	@RequestMapping("/getEnterpriseData")
	public void getData(HttpServletRequest request, @RequestParam("enterpriseName") String enterpriseName) {
		tycSpiderBiz.getTycSpiderEnterpriseDataByName(enterpriseName);
	}

}