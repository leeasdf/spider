package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;


import xin.tianchuang.modules.spider.bean.tyc.dto.JudicialAidDTO;

public class JudicialAidResultsDTO extends BaseTycResultsDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2407502024646295609L;


	private List<JudicialAidDTO> judicialAidResults;

	public List<JudicialAidDTO> getJudicialAidResults() {
		return judicialAidResults;
	}

	public void setJudicialAidResults(List<JudicialAidDTO> judicialAidResults) {
		this.judicialAidResults = judicialAidResults;
	}

}
