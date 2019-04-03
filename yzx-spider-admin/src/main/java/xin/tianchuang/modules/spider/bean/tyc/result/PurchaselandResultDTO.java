package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;

import xin.tianchuang.modules.spider.bean.tyc.dto.PurchaselandDTO;

public class PurchaselandResultDTO extends BaseTycResultsDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1347604326660928752L;


	private List<PurchaselandDTO> purchaselandResults;

	public List<PurchaselandDTO> getPurchaselandResults() {
		return purchaselandResults;
	}

	public void setPurchaselandResults(List<PurchaselandDTO> purchaselandResults) {
		this.purchaselandResults = purchaselandResults;
	}

}
