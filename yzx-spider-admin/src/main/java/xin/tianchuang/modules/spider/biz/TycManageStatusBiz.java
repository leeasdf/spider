package xin.tianchuang.modules.spider.biz;

import xin.tianchuang.modules.spider.bean.tyc.result.TycApiDataResultRespDTO;

import com.alibaba.fastjson.JSONObject;

/**
 * 经营状况
 * 
 * @author denghui
 *
 */
public interface TycManageStatusBiz {

	boolean saveData(Long enterpriseId, String name, TycApiDataResultRespDTO result);
}