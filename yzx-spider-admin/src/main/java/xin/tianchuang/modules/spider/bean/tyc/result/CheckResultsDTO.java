package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;


import xin.tianchuang.modules.spider.bean.tyc.dto.CheckDTO;

public class CheckResultsDTO extends BaseTycResultsDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6671449453532805830L;


	private List<CheckDTO> checkResults;

	public List<CheckDTO> getCheckResults() {
		return checkResults;
	}

	public void setCheckResults(List<CheckDTO> checkResults) {
		this.checkResults = checkResults;
	}

}
