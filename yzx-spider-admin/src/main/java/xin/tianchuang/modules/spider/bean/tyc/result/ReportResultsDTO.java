package xin.tianchuang.modules.spider.bean.tyc.result;

import java.io.Serializable;
import java.util.List;

import xin.tianchuang.modules.spider.bean.tyc.dto.ReportDTO;

public class ReportResultsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1037250350196601089L;

	private List<ReportDTO> reportResults;

	public List<ReportDTO> getReportResults() {
		return reportResults;
	}

	public void setReportResults(List<ReportDTO> reportResults) {
		this.reportResults = reportResults;
	}

}
