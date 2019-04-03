package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;


import xin.tianchuang.modules.spider.bean.tyc.dto.CourtNoticeDTO;

public class CourtNoticeResultsDTO extends BaseTycResultsDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -11520580106980814L;


	private List<CourtNoticeDTO> courtNoticeResults;

	public List<CourtNoticeDTO> getCourtNoticeResults() {
		return courtNoticeResults;
	}

	public void setCourtNoticeResults(List<CourtNoticeDTO> courtNoticeResults) {
		this.courtNoticeResults = courtNoticeResults;
	}

}
