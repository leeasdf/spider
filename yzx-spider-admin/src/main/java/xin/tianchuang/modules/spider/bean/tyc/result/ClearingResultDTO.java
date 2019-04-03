package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;

import xin.tianchuang.modules.spider.bean.tyc.dto.ClearingDTO;

public class ClearingResultDTO extends BaseTycResultsDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5723947197238685365L;


	private List<ClearingDTO> clearingResults;

	public List<ClearingDTO> getClearingResults() {
		return clearingResults;
	}

	public void setClearingResults(List<ClearingDTO> clearingResults) {
		this.clearingResults = clearingResults;
	}

}
