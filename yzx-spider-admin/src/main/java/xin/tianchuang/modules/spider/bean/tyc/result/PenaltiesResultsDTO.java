package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;


import xin.tianchuang.modules.spider.bean.tyc.dto.PenaltiesDTO;

public class PenaltiesResultsDTO extends BaseTycResultsDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7936460556525593512L;


	private List<PenaltiesDTO> penaltiesResults;

	public List<PenaltiesDTO> getPenaltiesResults() {
		return penaltiesResults;
	}

	public void setPenaltiesResults(List<PenaltiesDTO> penaltiesResults) {
		this.penaltiesResults = penaltiesResults;
	}

}
