package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;


import xin.tianchuang.modules.spider.bean.tyc.dto.ZhixingDTO;

public class ZhixingResultsDTO extends BaseTycResultsDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2407502024646295609L;


	private List<ZhixingDTO> zhixingResults;

	public List<ZhixingDTO> getZhixingResults() {
		return zhixingResults;
	}

	public void setZhixingResults(List<ZhixingDTO> zhixingResults) {
		this.zhixingResults = zhixingResults;
	}

}
