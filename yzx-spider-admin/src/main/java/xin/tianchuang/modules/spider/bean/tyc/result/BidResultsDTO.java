package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;


import xin.tianchuang.modules.spider.bean.tyc.dto.BidDTO;

public class BidResultsDTO extends BaseTycResultsDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 964128430928746879L;


	private List<BidDTO> bidResults;

	public List<BidDTO> getBidResults() {
		return bidResults;
	}

	public void setBidResults(List<BidDTO> bidResults) {
		this.bidResults = bidResults;
	}

}
