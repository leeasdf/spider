package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;

import xin.tianchuang.modules.spider.bean.tyc.dto.JudicialSaleDTO;

public class JudicialSaleResultsDTO extends BaseTycResultsDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9061675431784152813L;

	private List<JudicialSaleDTO> judicialSaleResults;

	public List<JudicialSaleDTO> getJudicialSaleResults() {
		return judicialSaleResults;
	}

	public void setJudicialSaleResults(List<JudicialSaleDTO> judicialSaleResults) {
		this.judicialSaleResults = judicialSaleResults;
	}

}
