package xin.tianchuang.modules.api.bean.v1;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;

/**
 * Api结果返回统一格式
 * 
 * @author denghui
 *
 */
public class ApiResultDTO extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;

	public ApiResultDTO() {
		put("code", 0);
		put("msg", "success");
	}

	public <T> ApiResultDTO(T data) {
		put("code", 0);
		put("msg", "success");
		put("data", data);
	}

	public static ApiResultDTO error() {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
	}

	public static ApiResultDTO error(String msg) {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
	}

	public static ApiResultDTO error(int code, String msg) {
		ApiResultDTO result = new ApiResultDTO();
		result.put("code", code);
		result.put("msg", msg);
		return result;
	}

	public static ApiResultDTO ok(String msg) {
		ApiResultDTO result = new ApiResultDTO();
		result.put("msg", msg);
		return result;
	}

	public static ApiResultDTO ok(Map<String, Object> map) {
		ApiResultDTO result = new ApiResultDTO();
		result.putAll(map);
		return result;
	}

	public static ApiResultDTO ok() {
		return new ApiResultDTO();
	}

	@Override
	public ApiResultDTO put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
