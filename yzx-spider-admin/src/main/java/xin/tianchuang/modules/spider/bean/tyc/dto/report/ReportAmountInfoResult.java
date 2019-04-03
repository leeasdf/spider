package xin.tianchuang.modules.spider.bean.tyc.dto.report;

import java.io.Serializable;

public class ReportAmountInfoResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6796577448020837920L;

	/**
	 * 资产总额
	 */
	private String totalAmount;
	/**
	 * 所有者权益合计
	 */
	private String ownerAmount;
	/**
	 * 销售总额
	 */
	private String saleAmount;
	/**
	 * 利润总额
	 */
	private String profitAmount;
	/**
	 * 营业总收入中主营业务收入
	 */
	private String mainBusinessIncome;
	/**
	 * 净利润
	 */
	private String netProfitAmount;
	/**
	 * 纳税总额
	 */
	private String taxAmount;
	/**
	 * 负债总额
	 */
	private String indebtAmount;

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getOwnerAmount() {
		return ownerAmount;
	}

	public void setOwnerAmount(String ownerAmount) {
		this.ownerAmount = ownerAmount;
	}

	public String getSaleAmount() {
		return saleAmount;
	}

	public void setSaleAmount(String saleAmount) {
		this.saleAmount = saleAmount;
	}

	public String getProfitAmount() {
		return profitAmount;
	}

	public void setProfitAmount(String profitAmount) {
		this.profitAmount = profitAmount;
	}

	public String getMainBusinessIncome() {
		return mainBusinessIncome;
	}

	public void setMainBusinessIncome(String mainBusinessIncome) {
		this.mainBusinessIncome = mainBusinessIncome;
	}

	public String getNetProfitAmount() {
		return netProfitAmount;
	}

	public void setNetProfitAmount(String netProfitAmount) {
		this.netProfitAmount = netProfitAmount;
	}

	public String getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(String taxAmount) {
		this.taxAmount = taxAmount;
	}

	public String getIndebtAmount() {
		return indebtAmount;
	}

	public void setIndebtAmount(String indebtAmount) {
		this.indebtAmount = indebtAmount;
	}

}
