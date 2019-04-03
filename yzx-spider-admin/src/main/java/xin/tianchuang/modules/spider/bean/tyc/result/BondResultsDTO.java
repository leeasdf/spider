package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;


import xin.tianchuang.modules.spider.bean.tyc.dto.BondDTO;

public class BondResultsDTO extends BaseTycResultsDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7930360202501200257L;


	private List<BondDTO> bondResults;

	public List<BondDTO> getBondResults() {
		return bondResults;
	}

	public void setBondResults(List<BondDTO> bondResults) {
		this.bondResults = bondResults;
	}

}
