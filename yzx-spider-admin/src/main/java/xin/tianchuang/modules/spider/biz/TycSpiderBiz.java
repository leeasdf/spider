package xin.tianchuang.modules.spider.biz;

import xin.tianchuang.modules.spider.entity.HighTechZoneEnterpriseInfoEntity;

public interface TycSpiderBiz {

	/**
	 * 根据省份、城市、状态查询企业列表信息
	 * 
	 * @param fetch
	 * @param status
	 * @param province
	 * @param city
	 * @return
	 */
	boolean getTycSpiderEnterpriseListData(Integer fetch, Integer status, String province, String city, String remark, Boolean isAsc);

	boolean getTycSpiderEnterpriseDataByName(String enterpriseName);

	boolean spiderEnterpriseData(HighTechZoneEnterpriseInfoEntity entity);

	void parseData(HighTechZoneEnterpriseInfoEntity dto, String apiData);

	boolean getTycSpiderEnterpriseDataByCreditCode(String creditCode);
}