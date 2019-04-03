package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;


import xin.tianchuang.modules.spider.bean.tyc.dto.TrademarkDTO;

public class TrademarkResultsDTO extends BaseTycResultsDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3082185945506277128L;


	private List<TrademarkDTO> trademarkResults;

	public List<TrademarkDTO> getTrademarkResults() {
		return trademarkResults;
	}

	public void setTrademarkResults(List<TrademarkDTO> trademarkResults) {
		this.trademarkResults = trademarkResults;
	}

}
