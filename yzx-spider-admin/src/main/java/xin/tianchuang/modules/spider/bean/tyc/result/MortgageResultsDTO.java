package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;


import xin.tianchuang.modules.spider.bean.tyc.dto.MortgageDTO;

public class MortgageResultsDTO extends BaseTycResultsDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3223163716956962282L;


	private List<MortgageDTO> mortgageResults;

	public List<MortgageDTO> getMortgageResults() {
		return mortgageResults;
	}

	public void setMortgageResults(List<MortgageDTO> mortgageResults) {
		this.mortgageResults = mortgageResults;
	}

}
