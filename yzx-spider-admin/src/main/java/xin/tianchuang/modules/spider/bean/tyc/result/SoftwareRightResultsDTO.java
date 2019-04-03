package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;


import xin.tianchuang.modules.spider.bean.tyc.dto.SoftwareRightDTO;

public class SoftwareRightResultsDTO extends BaseTycResultsDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6785335740739673125L;


	private List<SoftwareRightDTO> softwareRightResults;

	public List<SoftwareRightDTO> getSoftwareRightResults() {
		return softwareRightResults;
	}

	public void setSoftwareRightResults(List<SoftwareRightDTO> softwareRightResults) {
		this.softwareRightResults = softwareRightResults;
	}

}
