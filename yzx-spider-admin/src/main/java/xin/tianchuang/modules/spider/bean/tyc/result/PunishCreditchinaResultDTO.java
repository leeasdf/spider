package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;

import xin.tianchuang.modules.spider.bean.tyc.dto.PunishCreditchinaDTO;

public class PunishCreditchinaResultDTO extends BaseTycResultsDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7680705938439447759L;
	private List<PunishCreditchinaDTO> punishCreditchinaResults;

	public List<PunishCreditchinaDTO> getPunishCreditchinaResults() {
		return punishCreditchinaResults;
	}

	public void setPunishCreditchinaResults(List<PunishCreditchinaDTO> punishCreditchinaResults) {
		this.punishCreditchinaResults = punishCreditchinaResults;
	}

}
