package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;

import xin.tianchuang.modules.spider.bean.tyc.dto.LicensingDTO;

public class LicensingResultDTO extends BaseTycResultsDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6673919752358662790L;


	private List<LicensingDTO> licensingResults;

	public List<LicensingDTO> getLicensingResults() {
		return licensingResults;
	}

	public void setLicensingResults(List<LicensingDTO> licensingResults) {
		this.licensingResults = licensingResults;
	}

}
