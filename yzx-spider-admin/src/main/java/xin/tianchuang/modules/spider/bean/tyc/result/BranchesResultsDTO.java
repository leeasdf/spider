package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;


import xin.tianchuang.modules.spider.bean.tyc.dto.BranchesDTO;

public class BranchesResultsDTO extends BaseTycResultsDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6800754521979894603L;


	private List<BranchesDTO> branchesResults;

	public List<BranchesDTO> getBranchesResults() {
		return branchesResults;
	}

	public void setBranchesResults(List<BranchesDTO> branchesResults) {
		this.branchesResults = branchesResults;
	}


}
