package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;


import xin.tianchuang.modules.spider.bean.tyc.dto.OwingTaxDTO;

public class OwingTaxResultsDTO extends BaseTycResultsDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1778714415017981774L;


	private List<OwingTaxDTO> owingTaxResults;

	public List<OwingTaxDTO> getOwingTaxResults() {
		return owingTaxResults;
	}

	public void setOwingTaxResults(List<OwingTaxDTO> owingTaxResults) {
		this.owingTaxResults = owingTaxResults;
	}

}
