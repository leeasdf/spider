package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;

import xin.tianchuang.modules.spider.bean.tyc.dto.JingpinDTO;

public class JingpinResultDTO extends BaseTycResultsDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6199415956777661219L;
	private List<JingpinDTO> jingpinResults;

	public List<JingpinDTO> getJingpinResults() {
		return jingpinResults;
	}

	public void setJingpinResults(List<JingpinDTO> jingpinResults) {
		this.jingpinResults = jingpinResults;
	}

}
