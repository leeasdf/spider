package xin.tianchuang.modules.spider.bean.enterprise.verify;

import java.util.List;

public class OperatingAnomalyDTO {

	/**
	 * 企业是否被列⼊经营异常名录，0-否 1-是
	 */
	private int status;
	
	private List<DetailDTO> details;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<DetailDTO> getDetails() {
		return details;
	}

	public void setDetails(List<DetailDTO> details) {
		this.details = details;
	}
	
	
}
