package xin.tianchuang.modules.spider.biz;

import xin.tianchuang.modules.spider.bean.tyc.result.TycApiDataResultRespDTO;

import com.alibaba.fastjson.JSONObject;



/**
 * 司法风险
 * @author denghui
 *
 */
public interface TycLawDangerBiz {
	
	boolean saveData(Long enterpriseId, String name, TycApiDataResultRespDTO result);
}