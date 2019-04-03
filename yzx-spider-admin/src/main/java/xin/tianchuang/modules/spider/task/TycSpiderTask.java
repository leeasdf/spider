package xin.tianchuang.modules.spider.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import xin.tianchuang.modules.spider.bean.task.SpiderTaskParamDTO;
import xin.tianchuang.modules.spider.biz.TycSpiderBiz;

import com.alibaba.fastjson.JSON;

@Component("tycSpiderTask")
public class TycSpiderTask {

	private static Logger logger = LoggerFactory.getLogger(TycSpiderTask.class);

	@Autowired
	private TycSpiderBiz tycSpiderBiz;

	public void getJsData(String params) {
		logger.info("我是带参数的test方法，正在被执行，参数为：" + params);
		SpiderTaskParamDTO parse = JSON.parseObject(params, SpiderTaskParamDTO.class);
		Integer fetch = parse.getFetch();
		Integer status = parse.getStatus();
		String provice = parse.getProvice();
		String city = parse.getCity();
		String remark = parse.getRemark();
		Boolean isAsc = parse.getIsAsc();
		tycSpiderBiz.getTycSpiderEnterpriseListData(fetch, status, provice, city, remark, isAsc);
	}
}
