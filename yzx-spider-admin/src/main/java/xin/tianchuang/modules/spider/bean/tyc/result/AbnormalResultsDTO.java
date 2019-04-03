package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;


import xin.tianchuang.modules.spider.bean.tyc.dto.AbnormalDTO;

public class AbnormalResultsDTO extends BaseTycResultsDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6645529199124391208L;


	private List<AbnormalDTO> abnormalResults;

	public List<AbnormalDTO> getAbnormalResults() {
		return abnormalResults;
	}

	public void setAbnormalResults(List<AbnormalDTO> abnormalResults) {
		this.abnormalResults = abnormalResults;
	}

}
