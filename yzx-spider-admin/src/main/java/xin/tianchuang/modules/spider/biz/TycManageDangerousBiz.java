package xin.tianchuang.modules.spider.biz;

import xin.tianchuang.modules.spider.bean.tyc.result.TycApiDataResultRespDTO;

import com.alibaba.fastjson.JSONObject;



/**
 * 经营风险
 * @author denghui
 *
 */
public interface TycManageDangerousBiz {
	
	boolean saveData(Long enterpriseId, String name, TycApiDataResultRespDTO result);
}