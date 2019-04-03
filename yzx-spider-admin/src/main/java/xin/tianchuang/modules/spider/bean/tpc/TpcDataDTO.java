package xin.tianchuang.modules.spider.bean.tpc;

import java.util.List;

public class TpcDataDTO {

	/**
	 * 商标信息
	 */
	private List<TrademarkDTO> trademark;

	/**
	 * 著作权信息
	 */
	private List<CopyrightDTO> copyright;

	/**
	 * 专利信息
	 */
	private List<PatentsDTO> patents;

	public List<TrademarkDTO> getTrademark() {
		return trademark;
	}

	public void setTrademark(List<TrademarkDTO> trademark) {
		this.trademark = trademark;
	}

	public List<CopyrightDTO> getCopyright() {
		return copyright;
	}

	public void setCopyright(List<CopyrightDTO> copyright) {
		this.copyright = copyright;
	}

	public List<PatentsDTO> getPatents() {
		return patents;
	}

	public void setPatents(List<PatentsDTO> patents) {
		this.patents = patents;
	}

}
