package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;


import xin.tianchuang.modules.spider.bean.tyc.dto.ImportExportDTO;

public class ImportExportResultsDTO extends BaseTycResultsDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5663139625145623785L;

	private List<ImportExportDTO> importAndExportResults;

	public List<ImportExportDTO> getImportAndExportResults() {
		return importAndExportResults;
	}

	public void setImportAndExportResults(List<ImportExportDTO> importAndExportResults) {
		this.importAndExportResults = importAndExportResults;
	}

}
