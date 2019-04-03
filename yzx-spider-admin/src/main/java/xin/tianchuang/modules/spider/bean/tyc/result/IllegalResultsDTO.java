package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;


import xin.tianchuang.modules.spider.bean.tyc.dto.IllegalDTO;

public class IllegalResultsDTO extends BaseTycResultsDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5024833494454735781L;


	private List<IllegalDTO> illegalResults;

	public List<IllegalDTO> getIllegalResults() {
		return illegalResults;
	}

	public void setIllegalResults(List<IllegalDTO> illegalResults) {
		this.illegalResults = illegalResults;
	}

}
