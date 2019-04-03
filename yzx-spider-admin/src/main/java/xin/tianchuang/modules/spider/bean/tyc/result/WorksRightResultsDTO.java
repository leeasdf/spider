package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;


import xin.tianchuang.modules.spider.bean.tyc.dto.WorksRightDTO;

public class WorksRightResultsDTO extends BaseTycResultsDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2730815935735658189L;


	private List<WorksRightDTO> worksRightResults;

	public List<WorksRightDTO> getWorksRightResults() {
		return worksRightResults;
	}

	public void setWorksRightResults(List<WorksRightDTO> worksRightResults) {
		this.worksRightResults = worksRightResults;
	}

}
