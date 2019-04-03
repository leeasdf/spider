package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;


import xin.tianchuang.modules.spider.bean.tyc.dto.EquityDTO;

public class EquityResultsDTO extends BaseTycResultsDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1772048107539077387L;


	private List<EquityDTO> equityResults;

	public List<EquityDTO> getEquityResults() {
		return equityResults;
	}

	public void setEquityResults(List<EquityDTO> equityResults) {
		this.equityResults = equityResults;
	}

}
