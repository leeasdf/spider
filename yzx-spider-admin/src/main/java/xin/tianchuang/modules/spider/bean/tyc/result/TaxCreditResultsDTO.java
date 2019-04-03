package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;


import xin.tianchuang.modules.spider.bean.tyc.dto.TaxCreditDTO;

public class TaxCreditResultsDTO extends BaseTycResultsDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5505906851289781077L;


	private List<TaxCreditDTO> taxCreditResults;

	public List<TaxCreditDTO> getTaxCreditResults() {
		return taxCreditResults;
	}

	public void setTaxCreditResults(List<TaxCreditDTO> taxCreditResults) {
		this.taxCreditResults = taxCreditResults;
	}

}
