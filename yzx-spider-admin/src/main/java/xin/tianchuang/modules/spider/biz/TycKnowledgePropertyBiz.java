package xin.tianchuang.modules.spider.biz;

import xin.tianchuang.modules.spider.bean.tyc.result.TycApiDataResultRespDTO;

import com.alibaba.fastjson.JSONObject;



/**
 * 天眼查知识产权
 * @author denghui
 *
 */
public interface TycKnowledgePropertyBiz {
	
	boolean saveData(Long enterpriseId, String name, TycApiDataResultRespDTO result);
}