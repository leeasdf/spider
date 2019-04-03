package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;


import xin.tianchuang.modules.spider.bean.tyc.dto.InvestDTO;

public class InvestResultsDTO extends BaseTycResultsDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -642582912612285304L;


	private List<InvestDTO> investResults;

	public List<InvestDTO> getInvestResults() {
		return investResults;
	}

	public void setInvestResults(List<InvestDTO> investResults) {
		this.investResults = investResults;
	}

}
