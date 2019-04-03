package xin.tianchuang.modules.api.interceptor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Priority;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import xin.tianchuang.common.utils.RedisUtils;
import xin.tianchuang.modules.api.annotation.CountLimit;
import xin.tianchuang.modules.api.annotation.ApiToken;
import xin.tianchuang.modules.api.exception.CounterLimitException;

@Component
@Priority(10)
public class CountLimitImterceptor extends HandlerInterceptorAdapter {

	private static Logger logger = LoggerFactory.getLogger(CountLimitImterceptor.class);

	@Autowired
	private RedisUtils redis;

	private static SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ParseException {
		logger.info("counter_interceptor_before_start");

		ApiToken token;
		CountLimit counterLimit;
		// 只有@ApiToken @CountLimit 才会进行被校验
		if (handler instanceof HandlerMethod) {
			token = ((HandlerMethod) handler).getMethodAnnotation(ApiToken.class);
			counterLimit = ((HandlerMethod) handler).getMethodAnnotation(CountLimit.class);
		} else {
			return true;
		}

		if (handler instanceof HandlerMethod) {

			HandlerMethod hm = (HandlerMethod) handler;
			CountLimit accessLimit = hm.getMethodAnnotation(CountLimit.class);// 请求的方法是否带有accesslimit注解
			ApiToken accessToken = hm.getMethodAnnotation(ApiToken.class);// 请求的方法是否带有accesslimit注解
			if (accessLimit == null || accessToken == null) {
				logger.info("not need Counter,method {}", request.getMethod());
				return true;
			}

			// 判断总次数
			String key = "counter_" + getName(handler) + "_" + request.getParameter("appId");
			// 最大值
			CountLimit counter = hm.getMethodAnnotation(CountLimit.class);
			long countMax = counter.count();
			long countDaymax = counter.countDay();
			String endDate = counter.endDate();
			String countSession = redis.get(key);
			long countNow = 0;
			if (StringUtils.isNotEmpty(countSession)) {
				countNow = Long.parseLong(countSession);
			}

			if (countNow > countMax) {
				logger.info("超出使用次数:{}", request.getMethod());
				// return new ReturnData(7, "超出使用次数", "", "").toJson();
				throw new CounterLimitException("超出使用次数");
			} else {
				logger.info("使用次数:{}", countNow);
			}

			long endTime = fmt.parse(endDate).getTime();
			if (System.currentTimeMillis() > endTime) {
				logger.info("过期{}", request.getMethod());
				logger.info("counter_interceptor_before_end");
				// return new ReturnData(7, "过期", "", "").toJson();
				throw new CounterLimitException("过期");
			}

			// 判断当天次数
			String dayKey = "counter_day" + fmt.format(new Date()) + "_" + getName(handler) + "_" + request.getParameter("appId");
			countSession = redis.get(dayKey);
			long countday = 0;
			if (StringUtils.isNotEmpty(countSession)) {
				countday = Long.parseLong(countSession);
			}

			if (countday > countDaymax) {
				logger.info("超出当天使用次数{}", request.getMethod());
				logger.info("counter_interceptor_before_end");
				// return new ReturnData(7, "超出当天使用次数,请明天再试", "", "").toJson();
				throw new CounterLimitException("超出当天使用次数,请明天再试");
			} else {
				// System.out.println("当天使用次数:" + countday);
				logger.info("当天使用次数:{}", countNow);
			}

		}
		logger.info("counter_interceptor_before_end");
		return true;
	}

	private String getName(Object handler) {
		StringBuffer sb = new StringBuffer();
		if (handler instanceof HandlerMethod) {
			HandlerMethod hm = (HandlerMethod) handler;
			if (hm.getMethodAnnotation(RequestMapping.class) != null) {
				sb.append(getArrayStr(hm.getMethodAnnotation(RequestMapping.class).value()));
			}
			if (hm.getMethodAnnotation(PostMapping.class) != null) {
				sb.append("_");
				sb.append(getArrayStr(hm.getMethodAnnotation(PostMapping.class).value()));
			} else if (hm.getMethodAnnotation(GetMapping.class) != null) {
				sb.append("_");
				sb.append(getArrayStr(hm.getMethodAnnotation(GetMapping.class).value()));
			}
		}
		return sb.toString();
	}

	private String getArrayStr(String[] str) {
		StringBuffer sb = new StringBuffer();
		for (String s : str) {
			sb.append(s);
		}
		return sb.toString();
	}
}