package xin.tianchuang.modules.api.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;

import xin.tianchuang.modules.api.bean.api.tyc.biz.BizRequestHeadParamDTO;
import xin.tianchuang.modules.api.bean.api.tyc.biz.BizRequestParamDTO;
import xin.tianchuang.modules.api.service.TycApiService;

import com.alibaba.fastjson.JSON;

@Component
public class TycApiServiceImpl<T> implements TycApiService<Object> {

	@Override
	public Object queryApi(BizRequestParamDTO param, BizRequestHeadParamDTO head, Class cls) throws Exception {
		String token = head.getToken();
		Connection connect = Jsoup.connect(head.getUrl());
		connect.header("Authorization", token);
		Map<String, String> beanToMap = new HashMap<String, String>();
		beanToMap.put("name", param.getName());

		if (null != param.getId()) {
			beanToMap.put("id", "" + param.getId());
		}

		if (null != param.getPageNum()) {
			beanToMap.put("pageNum", "" + param.getPageNum());
		}
		if (null != param.getPageSize()) {
			beanToMap.put("pageSize", "" + param.getPageSize());
		}
		Response execute = connect.ignoreContentType(true).method(Method.GET).data(beanToMap).execute();
		String body = execute.body();
		if (StringUtils.isBlank(body)) {
			// TODO 自定义异常
			throw new Exception("");
		}
		// TODO 是否考虑重试
		return (T) JSON.parseObject(body, cls);

	}

}
