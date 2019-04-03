package xin.tianchuang.common.component.tcredit;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import xin.tianchuang.common.enums.ApiStatusEnum;
import xin.tianchuang.common.enums.ChannelTypeEnum;
import xin.tianchuang.common.utils.tcredit.AESUtil;
import xin.tianchuang.common.utils.tcredit.MD5Util;
import xin.tianchuang.common.utils.tcredit.MobileUtil;
import xin.tianchuang.common.utils.tcredit.ParamUtil;
import xin.tianchuang.common.utils.tcredit.SpiderJsoupUtil;
import xin.tianchuang.modules.spider.entity.ApiLogEntity;
import xin.tianchuang.modules.spider.service.ApiLogService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.toolkit.IdWorker;

@Component
public class TcreditApiTool {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TcreditTools tcreditTools;

	@Autowired
	private ApiLogService apiLogService;

	private String getApiRespInfo(String key, String url, Map<String, String> param, Method method) {
		if (null == param) {
			logger.error("Map不能为空");
			return null;
		}

		param.put("tokenKey", ParamUtil.getTokenKey(url, tcreditTools.getTokenId(), param));
		param.put("appId", tcreditTools.getAppId());

		String jsonString = JSON.toJSONString(param);
		logger.info("{}-->API请求信息:{}", key, jsonString);
		// 插入日志信息
		ApiLogEntity entity = new ApiLogEntity();
		// TODO
		entity.setBizId("" + System.currentTimeMillis());
		entity.setReqId(key);
		entity.setReqInfo(jsonString);
		entity.setChannelType(ChannelTypeEnum.TCREDIT.name());
		entity.setStatus(ApiStatusEnum.INIT.name());

		boolean flag = apiLogService.insert(entity);
		if (!flag) {
			logger.error("插入api日志信息失败");
		}

		Response content = SpiderJsoupUtil.getContent(url, param, null, method);

		try {
			String body = updateRespInfo(key, entity, content);
			logger.info("{} : API结果：\n{}\n", key, content.body());
			// String body = new String(content.body().getBytes("utf-8"), "utf-8");
			return body;
		} catch (Exception e) {
			entity.setRespCode("999999");
			entity.setRespMessage("网络异常");
			entity.setStatus(ApiStatusEnum.FAIL.name());
			flag = apiLogService.updateById(entity);
			if (!flag) {
				logger.error("更新api日志信息失败");
			}
			logger.error("调用API过程异常", e);
		}
		return null;
	}

	private String updateRespInfo(String key, ApiLogEntity entity, Response content) throws UnsupportedEncodingException {
		boolean flag = false;
		String body = new String(content.body().getBytes("utf-8"), "utf-8");
		logger.info("{}-->API查询结果：{}", key, body);
		JSONObject json = JSONObject.parseObject(body);
		String respCode = json.getString("status");
		String respMsg = json.getString("message");

		// String basePath = "E:/svn/git/oschina/spring-boot/panda-spring-boot-gxst/sql/json";
		// String filePath = basePath + File.separator + DateUtils.format(new Date(), "yyyy-MM-dd")+"_" + key + ".json";
		// try {
		// File file = new File(filePath);
		// if (!file.exists())//如果文件不存在,则新建.
		// {
		// File parentDir = new File(file.getParent());
		// if (!parentDir.exists())//如果所在目录不存在,则新建.
		// {
		// parentDir.mkdirs();
		// }
		// file.createNewFile();
		// }
		// PrintStream ps = new PrintStream(new FileOutputStream(file));
		// ps.println(body);// 往文件里写入字符串
		// ps.append(body);// 在已有的基础上添加字符串
		// } catch (FileNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// 保存到本地,返回信息存储为本地路径
		entity.setRespInfo(new String(content.body().getBytes("utf-8"), "utf-8"));
		entity.setRespCode(respCode);
		entity.setRespMessage(respMsg);
		entity.setStatus(ApiStatusEnum.PROCESS.name());
		flag = apiLogService.updateById(entity);
		if (!flag) {
			logger.error("更新api日志信息失败");
		}
		return body;
	}

	/**
	 * 通过企业名称查询企业工商信息
	 * 
	 * @param enterpriseName
	 * @return
	 */
	public String getIndustryCommerceByName(String enterpriseName) {
		return getIndustryCommerce(enterpriseName, "2");
	}

	/**
	 * 通过工商注册号查询企业工商信息
	 */
	public String getIndustryCommerceByRegno(String regno) {
		return getIndustryCommerce(regno, "3");
	}

	/**
	 * 通过法人身份证号码查询企业工商信息
	 * 
	 * @param certno
	 * @return
	 */
	public String getIndustryCommerceByCertno(String certno) {
		return getIndustryCommerce(certno, "4");
	}

	/**
	 * 查询企业工商信息 ，2-企业名称 3-⼯商注册号 4-法人身份证号码
	 * 
	 * @param enterpriseName
	 * @return
	 */
	public String getIndustryCommerce(String enterpriseName, String creditCode) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("companyName", enterpriseName);
		param.put("uniformCreditCode", creditCode);
		return getApiRespInfo(enterpriseName, tcreditTools.getIndustryCommerce(), param, Method.POST);
	}

	/**
	 * 通过企业名称查询商品专利著作权
	 * 
	 * @param enterpriseName
	 * @return
	 */
	public String getTpcInfo(String enterpriseName) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("ename", enterpriseName);
		return getApiRespInfo(enterpriseName, tcreditTools.getTpcInfo(), param, Method.POST);
	}

	/**
	 * 通过企业名称，查询企业涉诉信息
	 * 
	 * @param enterpriseName
	 * @param datatype
	 * @return
	 */
	public String getEnterpriseLitigation(String enterpriseName, String datatype) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("ename", enterpriseName);
		if (!StringUtils.isBlank(datatype)) {
			param.put("datatype", datatype);
		}
		param.put("pageno", "1");
		param.put("range", "10");
		return getApiRespInfo(enterpriseName, tcreditTools.getEnterpriseLitigation(), param, Method.POST);
	}

	/**
	 * 
	 * 通过企业名称查询企业税务信息
	 * 
	 * @param enterpriseName
	 * @return
	 */
	public String getTaxInfo(String enterpriseName) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("ename", enterpriseName);
		return getApiRespInfo(enterpriseName, tcreditTools.getTaxInfo(), param, Method.POST);
	}

	/**
	 * 查询企业涉诉详细信息
	 * 
	 * @param dataid
	 * @param datatype
	 * @return
	 */
	public String getLitigationDetail(String dataid, String datatype) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("dataid", dataid);
		param.put("datatype", datatype);
		return getApiRespInfo(dataid, tcreditTools.getLitigationDetail(), param, Method.POST);
	}

	/**
	 * 验证企业信息
	 * 
	 * @param enterpriseName
	 * @return
	 */
	public String getVerifyEnterpriseInfo(String enterpriseName) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("ename", enterpriseName);
		return getApiRespInfo(enterpriseName, tcreditTools.getVerifyEnterpriseInfo(), param, Method.POST);
	}

	/**
	 * 查询个人不良信息，如在逃、前科、吸毒、涉毒
	 * 
	 * @param name
	 * @param idcard
	 * @return
	 */
	public String getBadInfo(String name, String idcard) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("name", name);
		param.put("idcard", idcard);
		return getApiRespInfo(name, tcreditTools.getBadInfo(), param, Method.POST);
	}

	/**
	 * 不良信息
	 * 
	 * @throws Exception
	 */
	public String getBadInfoB(String name, String idCard) {
		String url = tcreditTools.getBadInfoB();
		Map<String, String> param = new HashMap<String, String>();
		param.put("name", name);
		param.put("idcard", idCard);
		return getApiRespInfo(name, url, param, Method.POST);
	}

	/**
	 * 精准查询个人涉诉信息
	 * 
	 * @param name
	 * @param idCard
	 * @return
	 */
	public String getPersonLitigation(String name, String idCard, String page) {
		String url = tcreditTools.getPersonLitigation();
		Map<String, String> param = new HashMap<String, String>();
		param.put("datatype", "all");
		param.put("name", name);
		param.put("idcard", idCard);
		param.put("pageno", page);
		param.put("range", "10");
		return getApiRespInfo(name, url, param, Method.POST);
	}

	/**
	 * 个人身份认证
	 * 
	 * @param name
	 * @param idcard
	 * @throws Exception
	 */
	public String verifyIdcard(String name, String idcard) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("name", name);
		param.put("idcard", idcard);
		return getApiRespInfo(name, tcreditTools.getVerifyIdcard(), param, Method.POST);
	}

	/**
	 * 常用手机号码验证
	 * 
	 * @param name
	 * @param mobile
	 * @param idtype
	 * @param idCard
	 * @return
	 */
	public String verifyMobileIdcard(String name, String mobile, String idCard) {
		int flag = MobileUtil.operatorFlag(mobile);
		switch (flag) {
		case 1:// 移动
			return verifyMobileIdcardForYD(mobile, idCard, name);
		case 2:// 联通
			return verifyMobileCardName(mobile, idCard, name);
		case 3:// 电信
			return verifyMobileIdcardForDX(mobile, idCard);
		default:
			return null;
		}
	}

	/**
	 * 手机号码－证件类型－证件号码验证、电信
	 */
	private String verifyMobileIdcardForDX(String mobile, String idCard) {
		String url = tcreditTools.getApiBaseUrl() + "/mobile/verifyCard";
		Map<String, String> param = new HashMap<String, String>();
		param.put("mobile", mobile); // 仅支持电信
		param.put("idtype", "idcard"); // idcard或passport
		param.put("idno", idCard);
		return getApiRespInfo(mobile, url, param, Method.POST);
	}

	/**
	 * 手机号码--身份证号姓名验证（移动号码）
	 * 
	 * @param mobile
	 * @param idcard
	 * @param name
	 * @return
	 */
	private String verifyMobileIdcardForYD(String mobile, String idcard, String name) {
		String url = tcreditTools.getApiBaseUrl() + "/mobile/cmcc/verifyMobileInfo3";
		Map<String, String> param = new HashMap<String, String>();
		param.put("mobile", mobile);// 仅支持移动
		param.put("idcard", idcard);
		param.put("name", name);
		return getApiRespInfo(mobile, url, param, Method.POST);
	}

	/**
	 * 手机号三要素验证－联通
	 */
	private String verifyMobileCardName(String mobile, String idno, String name) {
		String url = tcreditTools.getApiBaseUrl() + "/mobile/cucc/verifyMobileCardName";
		Map<String, String> param = new HashMap<String, String>();
		param.put("mobile", mobile); // 仅支持联通
		param.put("idno", idno); // 办手机号时的证件号
		param.put("name", name); // 办手机号时的姓名
		return getApiRespInfo(mobile, url, param, Method.POST);
	}

	/**
	 * 手机号码当前状态查询+在网时长（联通）
	 * 
	 * @param mobile
	 * @return
	 */
	public String getStateLT(String mobile) {
		String url = tcreditTools.getApiBaseUrl() + "/mobile/cucc/getMobileState";
		Map<String, String> param = new HashMap<String, String>();
		param.put("mobile", mobile); // 仅支持联通
		return getApiRespInfo(mobile, url, param, Method.POST);
	}

	/**
	 * 在网时长查询
	 * 
	 * @param mobile
	 * @param idCard
	 * @param name
	 * @return
	 */
	public String getOnlineTime(String mobile, String idCard, String name) {
		int flag = MobileUtil.operatorFlag(mobile);
		switch (flag) {
		case 1:// 移动
			return getOnlineTimeYD(mobile, idCard, name);
		case 2:// 联通
			return getStateLT(mobile);
		case 3:// 电信
			return getOnlineTimeDX(mobile);
		default:
			return null;
		}
	}

	/**
	 * 电信 在网时长查询
	 * 
	 * @param mobile
	 * @return
	 */
	public String getOnlineTimeDX(String mobile) {
		String url = tcreditTools.getApiBaseUrl() + "/mobile/getOnlineTime";
		Map<String, String> param = new HashMap<String, String>();
		param.put("mobile", mobile); // 仅支持电信
		return getApiRespInfo(mobile, url, param, Method.POST);
	}

	/**
	 * 移动 在网时长 移动号码
	 * 
	 * @param mobile
	 * @param idcard
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public String getOnlineTimeYD(String mobile, String idcard, String name) {
		String url = tcreditTools.getApiBaseUrl() + "/mobile/cmcc/getOnlineTime";
		Map<String, String> param = new HashMap<String, String>();
		param.put("mobile", mobile);// 仅支持移动
		param.put("idcard", idcard);
		param.put("name", name);
		return getApiRespInfo(mobile, url, param, Method.POST);
	}

	/***
	 * 月均消费
	 * 
	 * @param mobile
	 * @param idCard
	 * @param name
	 * @param month
	 * @return
	 */
	public String getPaymentAvgM3(String mobile, String idCard, String name, String month) {
		int flag = MobileUtil.operatorFlag(mobile);
		switch (flag) {
		case 1:// 移动
			return getConsumeGradeYD(mobile, idCard, name);
		case 2:// 联通
			return null;
		case 3:// 电信
			return getPaymentAvgM3DX(mobile, month);
		default:
			return null;
		}
	}

	/**
	 * 电信连续三月缴费区间 查询目标月之前连续三个月的缴费金额均值区间
	 * 
	 * @param mobile
	 * @param month
	 *            yyyymm
	 * @return
	 */
	public String getPaymentAvgM3DX(String mobile, String month) {
		String url = tcreditTools.getApiBaseUrl() + "/mobile/getPaymentAvgM3";
		Map<String, String> param = new HashMap<String, String>();
		param.put("mobile", mobile); // 仅支持电信
		param.put("month", month); // 目标月
		return getApiRespInfo(mobile, url, param, Method.POST);
	}

	/**
	 * 移动 月消费档次
	 * 
	 * @param mobile
	 * @param idcard
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public String getConsumeGradeYD(String mobile, String idcard, String name) {
		String url = tcreditTools.getApiBaseUrl() + "/mobile/cmcc/getConsumeGrade";
		Map<String, String> param = new HashMap<String, String>();
		param.put("mobile", mobile);// 仅支持移动
		param.put("idcard", idcard);
		param.put("name", name);
		return getApiRespInfo(mobile, url, param, Method.POST);
	}

	/**
	 * 停机次数查询
	 * 
	 * @param mobile
	 * @return
	 */
	public String getSuspendTimesM3(String mobile) {
		int flag = MobileUtil.operatorFlag(mobile);
		switch (flag) {
		case 1:// 移动
			return null;
		case 2:// 联通
			return null;
		case 3:// 电信
			return getSuspendTimesM3ForDX(mobile);
		default:
			return null;
		}
	}

	/**
	 * 停机次数查询-电信
	 * 
	 * @param mobile
	 * @return
	 */
	public String getSuspendTimesM3ForDX(String mobile) {
		String url = tcreditTools.getApiBaseUrl() + "/mobile/getSuspendTimesM3";
		Map<String, String> param = new HashMap<String, String>();
		param.put("mobile", mobile); // 仅支持电信
		return getApiRespInfo(mobile, url, param, Method.POST);
	}

	/**
	 * 银行卡认证
	 */
	public String verifyBankcardInfo(String name, String idCard, String bankCard) {
		String url = tcreditTools.getApiBaseUrl() + "/bankcard/verifyBankcardInfo";
		Map<String, String> param = new HashMap<String, String>();
		param.put("name", name);
		param.put("idcard", idCard);
		param.put("bankcard", bankCard);
		return getApiRespInfo(name, url, param, Method.POST);
	}

	/**
	 * 银行卡三要素验证
	 * 
	 * @param name
	 * @param bankCard
	 * @return
	 */
	public String verifyBankcardValidate(String name, String bankCard, String type) {
		String url = tcreditTools.getApiBaseUrl() + "/bankcard/verifyRelation";
		Map<String, String> param = new HashMap<String, String>();
		param.put("name", name);
		param.put("telphone", name);
		param.put("bankcard", bankCard);
		param.put("type", type);
		return getApiRespInfo(name, url, param, Method.POST);
	}

	/**
	 * 手机号码状态查询
	 * 
	 * @param mobile
	 * @return
	 */
	public String getState(String mobile) {
		String url = tcreditTools.getApiBaseUrl() + "/mobile/getState";
		Map<String, String> param = new HashMap<String, String>();
		param.put("mobile", mobile); // 仅支持联通
		return getApiRespInfo(mobile, url, param, Method.POST);
	}

	/**
	 * 学历信息
	 * 
	 * @param name
	 * @param bankCard
	 * @return
	 */
	public String getDegreeInfo(String name, String idcard) {
		String url = tcreditTools.getApiBaseUrl() + "/identity/getDegreeInfo";
		Map<String, String> param = new HashMap<String, String>();
		param.put("name", name);
		param.put("idcard", idcard);
		return getApiRespInfo(name, url, param, Method.POST);
	}

	/**
	 * 机动车信息认证
	 * 
	 * @param carNo
	 * @param engineNumber
	 * @param identityNumber
	 * @param name
	 * @return
	 */
	public String carIsReal(String carNo, String plateType) {
		String url = tcreditTools.getApiBaseUrl() + "/driver/authMotorVehicleInfo";
		Map<String, String> param = new HashMap<String, String>();
		String plate = AESUtil.encode(tcreditTools.getAppId().replaceAll("-", ""), carNo);
		param.put("plate", plate);
		param.put("plateType", plateType);
		return getApiRespInfo(carNo, url, param, Method.POST);
	}

	/**
	 * 天眼查爬取（免登陆）
	 * 
	 * @param enterpriseName
	 * @return
	 */
	public String getTycEnterpriseInfo(String enterpriseName) {
		try {
			// 企业名称修正，小写符号的()修改为中文状态的（）
			if (enterpriseName.indexOf('(') > -1) {
				enterpriseName = enterpriseName.replace("(", "（");
			}

			if (enterpriseName.indexOf(')') > -1) {
				enterpriseName = enterpriseName.replace(")", "）");
			}

			Map<String, String> param = new HashMap<String, String>();
			param.put("entName", enterpriseName);
			param.put("tokenKey", ParamUtil.getTokenKey(tcreditTools.getTycEnterpriseInfo(), tcreditTools.getSpiderTokenId(), param));
			param.put("appId", tcreditTools.getSpiderAppId());

			String jsonString = JSON.toJSONString(param);
			logger.info("[{}],requestInfo:[{}]", enterpriseName, jsonString);
			// 插入日志信息 
			ApiLogEntity entity = new ApiLogEntity();
			entity.setBizId(IdWorker.get32UUID());
			entity.setReqId(enterpriseName);
			entity.setReqInfo(jsonString);
			entity.setChannelType(ChannelTypeEnum.TCREDIT.name());
			entity.setStatus(ApiStatusEnum.INIT.name());

			boolean flag = apiLogService.insert(entity);
			if (!flag) {
				logger.error("插入api日志信息失败");
			}

			Response content = SpiderJsoupUtil.getContent(tcreditTools.getTycEnterpriseInfo(), param, null, Method.POST);
			logger.info("{} : 企业信息查询B结果：\n{}\n", enterpriseName, content.body());

			// saveFile(enterpriseName, "工商", content);

			try {
				String body = updateRespInfo(enterpriseName, entity, content);
				logger.info("{} : API结果：\n{}\n", enterpriseName, content.body());
				// String body = new String(content.body().getBytes("utf-8"), "utf-8");
				return body;

			} catch (Exception e) {
				entity.setRespCode("999999");
				entity.setRespMessage("网络异常");
				entity.setStatus(ApiStatusEnum.FAIL.name());
				flag = apiLogService.updateById(entity);
				if (!flag) {
					logger.error("更新api日志信息失败");
				}
				logger.error("调用API过程异常", e);
			}
		} catch (Exception e) {
			logger.error("查询企业工商信息失败", e);
		}
		return null;
	}

	/**
	 * 天眼查爬取（登陆）
	 * 
	 * @param enterpriseName
	 * @param mobile
	 * @param password
	 * @return
	 */
	public String getTycLoginPageEnterpriseInfo(String enterpriseName, String mobile, String password) {
		try {
			String url = tcreditTools.getTycLoginPageEnterpriseInfo();
			Map<String, String> param = new HashMap<String, String>();
			param.put("entName", enterpriseName);
			param.put("type", "4");
			// param.put("mobile", "13510850358");
			param.put("mobile", mobile);
			param.put("password", MD5Util.md5(password));
			param.put("tokenKey", ParamUtil.getTokenKey(url, tcreditTools.getSpiderTokenId(), param));
			param.put("appId", tcreditTools.getSpiderAppId());

			Response content = SpiderJsoupUtil.getContent(url, param, null, Method.POST);
			logger.info("{} : 企业信息查询B结果：\n{}\n", enterpriseName, content.body());

			// saveFile(enterpriseName, "工商", content);

			return content.body();
		} catch (Exception e) {
			logger.error("查询企业工商信息失败", e);
			return null;
		}
	}
}
