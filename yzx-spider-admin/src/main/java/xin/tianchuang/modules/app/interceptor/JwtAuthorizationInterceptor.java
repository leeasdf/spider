package xin.tianchuang.modules.app.interceptor;

import io.jsonwebtoken.Claims;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import xin.tianchuang.common.exception.SpiderException;
import xin.tianchuang.modules.app.annotation.Login;
import xin.tianchuang.modules.app.utils.JwtUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限(ApiToken)验证
 * 
 * @author hui.deng
 * 
 * @date 2017-03-23 15:38
 */
@Component
public class JwtAuthorizationInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(JwtAuthorizationInterceptor.class);
	@Autowired
	private JwtUtils jwtUtils;

	public static final String USER_KEY = "userId";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Login annotation;
		if (handler instanceof HandlerMethod) {
			annotation = ((HandlerMethod) handler).getMethodAnnotation(Login.class);
		} else {
			return true;
		}

		// 如果没有@Login注解，则不验证token
		if (annotation == null) {
			return true;
		}

		String token = getRequestToken(request);

		// 凭证为空
		if (StringUtils.isBlank(token)) {
			logger.error("{}不能为空，返回码{}", jwtUtils.getHeader(), HttpStatus.UNAUTHORIZED.value());
			throw new SpiderException(jwtUtils.getHeader() + "不能为空", HttpStatus.UNAUTHORIZED.value());
		}

		// 检查claims
		Claims claims = jwtUtils.getClaimByToken(token);
		if (claims == null || jwtUtils.isTokenExpired(claims.getExpiration())) {
			logger.error("{}失效，请重新登录，返回码{}", jwtUtils.getHeader(), HttpStatus.UNAUTHORIZED.value());
			throw new SpiderException(jwtUtils.getHeader() + "失效，请重新登录", HttpStatus.UNAUTHORIZED.value());
		}

		// 设置userId到request里，后续根据userId，获取用户信息
		request.setAttribute(USER_KEY, Long.parseLong(claims.getSubject()));

		return true;
	}

	private String getRequestToken(HttpServletRequest request) {
		// 从header中获取token,获取用户凭证
		String token = request.getHeader(jwtUtils.getHeader());
		// 如果header中不存在token，则从参数中获取token
		if (StringUtils.isBlank(token)) {
			token = request.getParameter(jwtUtils.getHeader());
		}
		return token;
	}
}
