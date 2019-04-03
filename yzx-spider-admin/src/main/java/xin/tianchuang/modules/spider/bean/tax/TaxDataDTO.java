package xin.tianchuang.modules.spider.bean.tax;

import java.util.List;

public class TaxDataDTO {

	/**
	 * 查询结果 0 -无数据 1 有数据，计费 resultMsg
	 */
	private String result;

	/**
	 * 查询结果描述
	 */
	private String resultMsg;

	/**
	 * 不同年度的企业税务信息
	 */
	private List<TaxDTO> taxes;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public List<TaxDTO> getTaxes() {
		return taxes;
	}

	public void setTaxes(List<TaxDTO> taxes) {
		this.taxes = taxes;
	}

}
