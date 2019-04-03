package xin.tianchuang.modules.spider.biz;

import xin.tianchuang.modules.spider.bean.tyc.result.TycApiDataResultRespDTO;

/**
 * 天眼查公司背景
 * @author denghui
 *
 */
public interface TycCompanyGrowthBiz {

	boolean saveData(Long enterpriseId, String name, TycApiDataResultRespDTO result);
}