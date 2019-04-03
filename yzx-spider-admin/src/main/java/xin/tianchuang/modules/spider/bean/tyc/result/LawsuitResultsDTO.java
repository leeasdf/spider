package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;


import xin.tianchuang.modules.spider.bean.tyc.dto.LawsuitDTO;

public class LawsuitResultsDTO extends BaseTycResultsDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5996414871223953651L;


	private List<LawsuitDTO> lawsuitResults;

	public List<LawsuitDTO> getLawsuitResults() {
		return lawsuitResults;
	}

	public void setLawsuitResults(List<LawsuitDTO> lawsuitResults) {
		this.lawsuitResults = lawsuitResults;
	}

}
