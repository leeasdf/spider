package xin.tianchuang.modules.spider.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import xin.tianchuang.modules.api.bean.v1.BaseResponse;

@RestControllerAdvice
public class ExceptionController {

	// 捕捉shiro的异常
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(ShiroException.class)
	public BaseResponse<ShiroException> handle401(ShiroException e) {
		return new BaseResponse(false, "shiro的异常", null);
	}

	// 捕捉UnauthorizedException
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(UnauthorizedException.class)
	public BaseResponse<UnauthorizedException> handle401() {
		return new BaseResponse(false, "UnauthorizedException", null);
	}

	// 捕捉其他所有异常
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public BaseResponse<Exception> globalException(HttpServletRequest request, Throwable ex) {
		return new BaseResponse(false, "其他异常", null);
	}

	private HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		if (statusCode == null) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return HttpStatus.valueOf(statusCode);
	}
}