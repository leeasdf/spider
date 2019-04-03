package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;


import xin.tianchuang.modules.spider.bean.tyc.dto.IcpDTO;

public class IcpResultsDTO extends BaseTycResultsDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7492044801557826632L;


	private List<IcpDTO> icpResults;

	public List<IcpDTO> getIcpResults() {
		return icpResults;
	}

	public void setIcpResults(List<IcpDTO> icpResults) {
		this.icpResults = icpResults;
	}

}
