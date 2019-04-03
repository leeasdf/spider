package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;


import xin.tianchuang.modules.spider.bean.tyc.dto.PatentDTO;

public class PatentResultsDTO extends BaseTycResultsDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7092899636924628226L;


	private List<PatentDTO> patentResults;

	public List<PatentDTO> getPatentResults() {
		return patentResults;
	}

	public void setPatentResults(List<PatentDTO> patentResults) {
		this.patentResults = patentResults;
	}

}
