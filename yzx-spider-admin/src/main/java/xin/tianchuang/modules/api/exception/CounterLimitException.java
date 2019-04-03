package xin.tianchuang.modules.api.exception;

import xin.tianchuang.common.exception.SpiderException;

/**
 * 自定义异常
 * 
 * @author hui.deng
 * 
 * @date 2016年10月27日 下午10:11:27
 */
public class CounterLimitException extends SpiderException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6192733400458774881L;

	public CounterLimitException() {
		super("HTTP请求超出设定的限制");
	}

	public CounterLimitException(String msg) {
		super(msg);
	}

}
