package xin.tianchuang.common.utils.tcredit;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiComponent {

	private static Logger logger = LoggerFactory.getLogger(ApiComponent.class);

	private static String appId = "111111";
	private static String tokenId = "a3e33b69c0bae57f3c46a33c27026104";
	private static String baseUrl = "http://localhost:8080/yzx-spider-admin";

	
	private static String getApiRespInfo(String key, String url, Map<String, String> param, Method method) {
		param.put("tokenKey", ParamUtil.getTokenKey(url, tokenId, param));
		param.put("appId", appId);
		Response content = SpiderJsoupUtil.getContent(url, param, null, method);
		logger.info("{}API查询结果：\n", key, content.body());
		return content.body();
	}

	private static String getApiRespInfo(String key, String url, Map<String, String> param, Method method, String tokenId, String appId) {
		param.put("tokenKey", ParamUtil.getTokenKey(url, tokenId, param));
		param.put("appId", appId);
		Response content = SpiderJsoupUtil.getContent(url, param, null, method);
		logger.info("{}API查询结果：\n", key, content.body());
		return content.body();
	}

	/**
	 * 查询企业工商信息
	 * @param enterpriseName
	 * @return
	 */
	@Deprecated
	public static String getIndustryCommerce(String enterpriseName) {
		String url = baseUrl + "/enterprise/getIndustryCommerce";
		Map<String, String> param = new HashMap<String, String>();
		param.put("key", enterpriseName);
		param.put("keyType", "2");
		return getApiRespInfo(enterpriseName, url, param, Method.POST);
	}

	public static String getIndustryCommerce(String enterpriseName, String creditCode) {
		String url = baseUrl + "/enterprise/getIndustryCommerceInfo";
		Map<String, String> param = new HashMap<String, String>();
		param.put("companyName", enterpriseName);
        param.put("uniformCreditCode", creditCode);
		return getApiRespInfo(enterpriseName, url, param, Method.POST);
	}

	public static String getTpcInfo(String enterpriseName) {
		String url = baseUrl + "/enterprise/getTpcInfo";
		Map<String, String> param = new HashMap<String, String>();
		param.put("ename", enterpriseName);
		return getApiRespInfo(enterpriseName, url, param, Method.POST);
	}

	public static String getEnterpriseLitigation(String enterpriseName, String datatype) {
		String url = baseUrl + "/litigation/getEnterpriseLitigation";
		Map<String, String> param = new HashMap<String, String>();
		param.put("ename", enterpriseName);
		if (!StringUtils.isBlank(datatype)) {
			param.put("datatype", datatype);
		}
		param.put("pageno", "1");
		param.put("range", "10");
		return getApiRespInfo(enterpriseName, url, param, Method.POST);
	}

	public static String getTaxInfo(String enterpriseName) {
		String url = baseUrl + "/enterprise/getTaxInfo";
		Map<String, String> param = new HashMap<String, String>();
		param.put("ename", enterpriseName);
		return getApiRespInfo(enterpriseName, url, param, Method.POST);
	}

	public static String getLitigationDetail(String dataid, String datatype) {
		String url = baseUrl + "/litigation/getLitigationDetail";
		Map<String, String> param = new HashMap<String, String>();
		param.put("dataid", dataid);
		param.put("datatype", datatype);
		return getApiRespInfo(dataid, url, param, Method.POST);
	}

	public static String verifyEnterpriseInfo(String enterpriseName) {
		String url = baseUrl + "/enterprise/verifyEnterpriseInfo";
		Map<String, String> param = new HashMap<String, String>();
		param.put("ename", enterpriseName);
		return getApiRespInfo(enterpriseName, url, param, Method.POST);
	}

	/**
	 * 查询个人不良信息，如在逃、前科、吸毒、涉毒
	 *
	 * @param name
	 * @param idcard
	 * @return
	 */
	public static String getBadInfo(String name, String idcard) {
		String url = baseUrl + "/litigation/getBadInfo";
		Map<String, String> param = new HashMap<String, String>();
		param.put("name", name);
		param.put("idcard", idcard);
		return getApiRespInfo(name, url, param, Method.POST);
	}

	/**
	 * 个人身份认证
	 *
	 * @param name
	 * @param idcard
	 * @throws Exception
	 */
	public static String verifyIdcard(String name, String idcard) {
		String url = baseUrl + "/identity/verifyIdcard";
		Map<String, String> param = new HashMap<String, String>();
		param.put("name", name);
		param.put("idcard", idcard);
		return getApiRespInfo(name, url, param, Method.POST);
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
	public static String verifyMobileIdcard(String name, String mobile, String idCard) {
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
	private static String verifyMobileIdcardForDX(String mobile, String idCard) {
		String url = baseUrl + "/mobile/verifyCard";
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
	private static String verifyMobileIdcardForYD(String mobile, String idcard, String name) {
		String url = baseUrl + "/mobile/cmcc/verifyMobileInfo3";
		Map<String, String> param = new HashMap<String, String>();
		param.put("mobile", mobile);// 仅支持移动
		param.put("idcard", idcard);
		param.put("name", name);
		return getApiRespInfo(mobile, url, param, Method.POST);
	}

	/**
	 * 手机号三要素验证－联通
	 */
	private static String verifyMobileCardName(String mobile, String idno, String name) {
		String url = baseUrl + "/mobile/cucc/verifyMobileCardName";
		Map<String, String> param = new HashMap<String, String>();
		param.put("mobile", mobile); // 仅支持联通
		param.put("idno", idno); // 办手机号时的证件号
		param.put("name", name); // 办手机号时的姓名
		return getApiRespInfo(mobile, url, param, Method.POST);
	}

	/**
	 * 不良信息
	 *
	 * @throws Exception
	 */
	public static String getBadInfoB(String name, String idCard) {
		String url = baseUrl + "/litigation/getBadInfoB";
		Map<String, String> param = new HashMap<String, String>();
		param.put("name", name);
		param.put("idcard", idCard);
		return getApiRespInfo(name, url, param, Method.POST);
	}

	/**
	 * 手机号码当前状态查询+在网时长（联通）
	 *
	 * @param mobile
	 * @return
	 */
	public static String getStateLT(String mobile) {
		String url = baseUrl + "/mobile/cucc/getMobileState";
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
	public static String getOnlineTime(String mobile, String idCard, String name) {
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
	public static String getOnlineTimeDX(String mobile) {
		String url = baseUrl + "/mobile/getOnlineTime";
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
	public static String getOnlineTimeYD(String mobile, String idcard, String name) {
		String url = baseUrl + "/mobile/cmcc/getOnlineTime";
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
	public static String getPaymentAvgM3(String mobile, String idCard, String name, String month) {
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
	public static String getPaymentAvgM3DX(String mobile, String month) {
		String url = baseUrl + "/mobile/getPaymentAvgM3";
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
	public static String getConsumeGradeYD(String mobile, String idcard, String name) {
		String url = baseUrl + "/mobile/cmcc/getConsumeGrade";
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
	public static String getSuspendTimesM3(String mobile) {
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
	public static String getSuspendTimesM3ForDX(String mobile) {
		String url = baseUrl + "/mobile/getSuspendTimesM3";
		Map<String, String> param = new HashMap<String, String>();
		param.put("mobile", mobile); // 仅支持电信
		return getApiRespInfo(mobile, url, param, Method.POST);
	}

	/**
	 * 精准查询个人涉诉信息
	 *
	 * @param name
	 * @param idCard
	 * @return
	 */
	public static String getPersonLitigation(String name, String idCard, String page) {
		String url = baseUrl + "/litigation/getPersonLitigation";
		Map<String, String> param = new HashMap<String, String>();
		param.put("datatype", "all");
		param.put("name", name);
		param.put("idcard", idCard);
		param.put("pageno", page);
		param.put("range", "10");
		return getApiRespInfo(name, url, param, Method.POST);

	}

	/**
	 * 银行卡认证
	 */
	public static String verifyBankcardInfo(String name, String idCard, String bankCard) {
		String url = baseUrl + "/bankcard/verifyBankcardInfo";
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
	public static String verifyBankcardValidate(String name, String bankCard, String type) {
		String url = baseUrl + "/bankcard/verifyRelation";
		Map<String, String> param = new HashMap<String, String>();
		param.put("name", name);
		param.put("telphone", name);
		param.put("bankcard", bankCard);
		param.put("type", type);
		return getApiRespInfo(name, url, param, Method.POST);
	}

	/**
	 * 学历信息
	 *
	 * @param name
	 * @param bankCard
	 * @return
	 */
	public static String getDegreeInfo(String name, String idcard) {
		String url = baseUrl + "/identity/getDegreeInfo";
		Map<String, String> param = new HashMap<String, String>();
		param.put("name", name);
		param.put("idcard", idcard);
		return getApiRespInfo(name, url, param, Method.POST);
	}

	/**
	 * 手机号码状态查询
	 *
	 * @param mobile
	 * @return
	 */
	public static String getState(String mobile) {
		String url = baseUrl + "/mobile/getState";
		Map<String, String> param = new HashMap<String, String>();
		param.put("mobile", mobile); // 仅支持联通
		return getApiRespInfo(mobile, url, param, Method.POST);
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
	public static String carIsReal(String carNo, String plateType) {
		String url = baseUrl + "/driver/authMotorVehicleInfo";
		Map<String, String> param = new HashMap<String, String>();
		String plate = AESUtil.encode(appId.replaceAll("-", ""), carNo);
		param.put("plate", plate);
		param.put("plateType", plateType);
		return getApiRespInfo(carNo, url, param, Method.POST);
	}

	/**
	 * 天创-天眼查爬虫接口
	 * @param enterpriseName
	 * @return
	 */
	public static String getEntInfoB(String enterpriseName, String creditCode) {
		String url = "http://123.57.23.67/api/enterprise/getEntInfoB";
		Map<String, String> param = new HashMap<String, String>();
		param.put("entName", enterpriseName);
		param.put("regNo", creditCode);
		String tokenId = "7c6b380d5b3140499a74886e89fbacb4";
		String appId = "tc-cloud";
		return getApiRespInfo(enterpriseName, url, param, Method.POST, tokenId, appId);
	}

	/**
	 * 查询天眼查的API数据
	 * @param enterpriseName
	 * @return
	 */

	public static String getCopyrightWorks(String enterpriseName) {
		String url = baseUrl + "/api/v1/getCopyrightWorks";
		Map<String, String> param = new HashMap<String, String>();
		param.put("name", enterpriseName);
		return getApiRespInfo(enterpriseName, url, param, Method.GET);
	}
}
