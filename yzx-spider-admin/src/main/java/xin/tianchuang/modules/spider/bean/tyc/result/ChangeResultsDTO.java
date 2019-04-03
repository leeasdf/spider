package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;


import xin.tianchuang.modules.api.bean.v1.RptTnChangeDTO;

public class ChangeResultsDTO extends BaseTycResultsDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1586900025153950268L;


	private List<RptTnChangeDTO> changeResults;

	public List<RptTnChangeDTO> getChangeResults() {
		return changeResults;
	}

	public void setChangeResults(List<RptTnChangeDTO> changeResults) {
		this.changeResults = changeResults;
	}

}
