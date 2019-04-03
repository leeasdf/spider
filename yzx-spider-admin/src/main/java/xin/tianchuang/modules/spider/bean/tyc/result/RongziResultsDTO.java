package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;

import xin.tianchuang.modules.spider.bean.tyc.dto.RongziDTO;

public class RongziResultsDTO extends BaseTycResultsDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1816834830252367885L;
	private List<RongziDTO> rongziResults;

	public List<RongziDTO> getRongziResults() {
		return rongziResults;
	}

	public void setRongziResults(List<RongziDTO> rongziResults) {
		this.rongziResults = rongziResults;
	}

}
