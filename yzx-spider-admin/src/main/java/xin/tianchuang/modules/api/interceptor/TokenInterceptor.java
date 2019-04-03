package xin.tianchuang.modules.api.interceptor;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Priority;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.enums.ErrorCodeEnum;
import xin.tianchuang.common.exception.SpiderException;
import xin.tianchuang.common.utils.tcredit.MD5Util;
import xin.tianchuang.modules.api.annotation.ApiToken;
import xin.tianchuang.modules.api.entity.SysApiMenuEntity;
import xin.tianchuang.modules.api.entity.SysAppApiEntity;
import xin.tianchuang.modules.api.entity.SysUserApiTokenEntity;
import xin.tianchuang.modules.api.listener.ApiAnnotationScanListener;
import xin.tianchuang.modules.api.service.SysApiMenuService;
import xin.tianchuang.modules.api.service.SysAppApiService;
import xin.tianchuang.modules.api.service.SysUserApiTokenService;

/**
 * 权限(ApiToken)验证
 * 
 * @author hui.deng
 * 
 * @date 2017-03-23 15:38
 */
@Component
@Priority(20)
public class TokenInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(TokenInterceptor.class);
	@Autowired
	private SysUserApiTokenService sysUserApiTokenService;
	@Autowired
	private SysApiMenuService sysApiMenuService;
	@Autowired
	private SysAppApiService sysAppApiService;

	public static final String USER_KEY = "appId";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("token_interceptor_round_start");
		ApiToken annotation;
		// 只有@NeedToken 才会进行被校验
		if (handler instanceof HandlerMethod) {
			annotation = ((HandlerMethod) handler).getMethodAnnotation(ApiToken.class);
		} else {
			return true;
		}

		// 如果没有@NeedToken注解，则不验证token
		if (annotation == null) {
			return true;
		}
		checkMustyParam(request);

		// 设置userId到request里，后续根据appId，获取用户信息
		request.setAttribute(USER_KEY, request.getParameter("appId"));

		return true;
	}

	private void checkMustyParam(HttpServletRequest request) {
		// 1、必填项校验
		// 获取 -> userid 
		String appId = request.getParameter("appId");
		// 获取 -> token
		String userToken = request.getParameter("tokenKey");
		if (null == appId || null == userToken) {
			throw new SpiderException("请输入必填项", ErrorCodeEnum.MISS_NECESSARA_PARAM.key());
		}
		// 判断checkApis中是否包含当前请求的uri,检查API的白名单权限
		
		String urlPrefix = request.getServletPath();
		String pathInfo = request.getPathInfo();
		if (pathInfo != null && pathInfo.length() > 0) {
			urlPrefix = urlPrefix + pathInfo;
		}

		if (!ApiAnnotationScanListener.checkApis.contains(urlPrefix)) {
			throw new SpiderException("访问路径不存在", ErrorCodeEnum.URL_NOT_EXIST.key());
		}
		// 2、api白名单权限校验
		SysApiMenuEntity apiMenuEntity = sysApiMenuService.queryApiMenuByApiUrl(urlPrefix);
		if (null == apiMenuEntity || apiMenuEntity.getStatus() != DataStatusEnum.ACTIVE.key()) {
			throw new SpiderException("访问路径禁止访问", ErrorCodeEnum.NO_AUTH_ACCESS_API.key());
		}
		// 3、检查app对应权限
		SysUserApiTokenEntity sysUserTokenEntity = sysUserApiTokenService.getTokenByAppId(appId);
		// 校验 user用户是否存在
		if (sysUserTokenEntity == null) {
			throw new SpiderException("用户信息不存在或配置错误", ErrorCodeEnum.ACCOUNT_INCORRECT.key());
		}
		// 校验 user状态是否正常
		if (sysUserTokenEntity.getStatus() != DataStatusEnum.ACTIVE.key()) {
			throw new SpiderException("用户接口暂停使用", ErrorCodeEnum.NO_AUTH_ACCESS_API.key());
		}
		// 校验过期时间
		if (sysUserTokenEntity.getExpireTime().getTime() < System.currentTimeMillis()) {
			throw new SpiderException("token已失效，请联系管理员", ErrorCodeEnum.NO_AUTH_ACCESS_API.key());
		}
		// 校验api路径权限
		SysAppApiEntity sysAppApiEntity = sysAppApiService.queryInfoByApiIdAndAppId(appId, apiMenuEntity.getApiId());
		if (null == sysAppApiEntity) {
			throw new SpiderException("不存在该接口权限", ErrorCodeEnum.NO_AUTH_ACCESS_API.key());
		}
		// 校验 user状态是否正常
		if (sysAppApiEntity.getStatus() != DataStatusEnum.ACTIVE.key()) {
			throw new SpiderException("该接口暂停使用", ErrorCodeEnum.NO_AUTH_ACCESS_API.key());
		}
		// 4、校验签名
		String url = request.getRequestURL().toString();
		Map<String, String> paramMap = getParameterMap(request);
		String checkToken = getToken(url, sysUserTokenEntity.getToken(), paramMap);
		logger.info("right token is :[{}] --> user token is : [{}]", checkToken, userToken);
		// 校验 加密token是否正确
		if (!checkToken.equals(userToken)) {
			throw new SpiderException("token验证失败", ErrorCodeEnum.REQ_FAIL.key());
		}
		// 5、校验时间戳，检查如果时间范围大于10分钟，即可抛出超时异常
	}

	/**
	 * 把request转为map
	 * 
	 * @param request
	 * @return
	 */
	private Map<String, String> getParameterMap(HttpServletRequest request) {
		// 参数Map
		Map<String, String[]> properties = request.getParameterMap();
		// 返回值Map
		Map<String, String> returnMap = new HashMap<String, String>();
		String name = "";
		String value = "";
		for (Map.Entry<String, String[]> entry : properties.entrySet()) {
			name = entry.getKey();
			String[] values = entry.getValue();
			if (null == values) {
				value = "";
			} else if (values.length > 1) {
				for (int i = 0; i < values.length; i++) { // 用于请求参数中有多个相同名称
					value = values[i] + ",";
				}
				value = value.substring(0, value.length() - 1);
			} else {
				value = values[0];// 用于请求参数中请求参数名唯一
			}
			returnMap.put(name, value);

		}
		return returnMap;
	}

	public static String getToken(String url, String token, Map<String, String> param) {
		String paramStr = getParamStr(param);// url加密 -> userid放在tokenid之前
		return MD5Util.md5(url + token + paramStr);
	}

	// 请求参数 剔除 appId,tokenKey。拼接成字符串。
	public static String getParamStr(Map<String, String> map) {
		if (null == map) {
			return "";
		}
		// 删除制定元素
		map.remove("appId");
		map.remove("tokenKey");

		if (map.size() == 0) {
			return "";
		}

		// 将Map-key拿出来放入数组并排序
		String[] arr = new String[map.size()];

		Iterator<String> iterator = map.keySet().iterator();
		int i = 0;
		while (iterator.hasNext()) {
			String key = iterator.next();
			arr[i] = key;
			i++;
		}
		getSortedArr(arr);

		StringBuffer paramStr = new StringBuffer();
		for (String s : arr) {
			String value = map.get(s);
			paramStr.append(s).append("=").append(value).append(",");
		}
		String urlRet = paramStr.substring(0, paramStr.length() - 1);
		return urlRet;
	}

	public static String[] getSortedArr(String[] arr) {
		Comparator<Object> comparator = Collator.getInstance(java.util.Locale.US);
		Arrays.sort(arr, comparator);
		return arr;
	}
}
