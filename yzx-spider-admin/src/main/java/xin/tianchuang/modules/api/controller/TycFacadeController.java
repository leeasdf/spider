package xin.tianchuang.modules.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xin.tianchuang.modules.api.facade.tyc.TycFacade;
import xin.tianchuang.modules.spider.service.HighTechZoneEnterpriseInfoService;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.toolkit.IdWorker;

@Controller
@RequestMapping("/api/tyc")
public class TycFacadeController {

	private static Logger logger = LoggerFactory.getLogger(TycFacadeController.class);

	private static final String ENT_STATUS = "status";
	private static final String ENT_MESSAGE = "message";

	@Autowired
	private TycFacade tycFacade;

	@Autowired
	private HighTechZoneEnterpriseInfoService highTechZoneEnterpriseInfoService;

	/**
	 * 查询状态为成功的所有企业列表
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getData")
	public String getData(HttpServletRequest request) {
		logger.info("获取API数据");
		final JSONObject result = new JSONObject();
		final String uuid = IdWorker.get32UUID();
		result.put(ENT_STATUS, 0);
		result.put(ENT_MESSAGE, "成功");
		result.put("uuid", uuid);

		String enterpriseName = request.getParameter("enterpriseName");
		// 替换对应的英文括号为中文括号
		if (StringUtils.isNotBlank(enterpriseName)) {
			if (enterpriseName.indexOf('(') > -1) {
				enterpriseName = enterpriseName.replace("(", "（");
			}
			if (enterpriseName.indexOf(')') > -1) {
				enterpriseName = enterpriseName.replace(")", "）");
			}
		}
		String creditCode = request.getParameter("creditCode");
		String pageFlag = request.getParameter("pageFlag");
		String type = request.getParameter("type");

		final JSONObject json = new JSONObject();
		json.put("uuid", uuid);
		json.put("enterpriseName", enterpriseName);
		json.put("creditCode", creditCode);
		json.put("pageFlag", pageFlag);
		json.put("type", type);

		try {
			logger.info("[{}]API开始获取企业信息: {}", uuid, enterpriseName);

			if (StringUtils.isBlank(enterpriseName) && StringUtils.isBlank(creditCode)) {
				result.put(ENT_STATUS, 2);
				result.put(ENT_MESSAGE, "企业名称和统一社会信用代码不能同时为空");
			} else {

				JSONObject re = tycFacade.getEnterpriseData(json.toJSONString());
				result.put("data", re.getJSONObject("result").getJSONObject("result"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			JSONObject msg = new JSONObject(json);
			// msg.put("msg", "天眼查接口异常-".concat(ErrorMessageUtil.getExeptionMessage(e)));
			msg.put("msg", e.getMessage());
			logger.info(msg.toJSONString());
			result.put(ENT_STATUS, 1);
			result.put(ENT_MESSAGE, "系统错误");
		}
		return result.toJSONString();

	}
}