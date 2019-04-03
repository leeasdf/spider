package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;


import xin.tianchuang.modules.spider.bean.tyc.dto.CertificateDTO;

public class CertificateResultsDTO extends BaseTycResultsDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2144209251023101365L;


	private List<CertificateDTO> certificateResults;

	public List<CertificateDTO> getCertificateResults() {
		return certificateResults;
	}

	public void setCertificateResults(List<CertificateDTO> certificateResults) {
		this.certificateResults = certificateResults;
	}

}
