package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;


import xin.tianchuang.modules.spider.bean.tyc.dto.LicensingXyzgDTO;

public class LicensingXyzgResultsDTO extends BaseTycResultsDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -177665016310968284L;


	private List<LicensingXyzgDTO> licensingXyzgResults;

	public List<LicensingXyzgDTO> getLicensingXyzgResults() {
		return licensingXyzgResults;
	}

	public void setLicensingXyzgResults(List<LicensingXyzgDTO> licensingXyzgResults) {
		this.licensingXyzgResults = licensingXyzgResults;
	}

}
