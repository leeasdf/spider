package xin.tianchuang.modules.spider.bean.tyc.dto.report;

import java.io.Serializable;
import java.util.Date;

public class ReportShareholderResults implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6732716674514042434L;
	/**
	 * 认缴出资时间
	 */
	private String paidDate;
	/**
	 * 股东url
	 */
	private String nameUrl;
	/**
	 * 股东
	 */
	private String name;
	/**
	 * 认缴出资方式
	 */
	private String paidInvestType;
	/**
	 * 实缴出资方式
	 */
	private String actInvestType;
	/**
	 * 认缴出资额（万元）
	 */
	private String paidAmount;
	/**
	 * 实缴出资额（万元）
	 */
	private String actAmount;
	/**
	 * 实缴出资时间
	 */
	private String actDate;

	public String getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(String paidDate) {
		this.paidDate = paidDate;
	}

	public void setNameUrl(String nameUrl) {
		this.nameUrl = nameUrl;
	}

	public String getNameUrl() {
		return nameUrl;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPaidInvestType(String paidInvestType) {
		this.paidInvestType = paidInvestType;
	}

	public String getPaidInvestType() {
		return paidInvestType;
	}

	public void setActInvestType(String actInvestType) {
		this.actInvestType = actInvestType;
	}

	public String getActInvestType() {
		return actInvestType;
	}

	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getPaidAmount() {
		return paidAmount;
	}

	public void setActAmount(String actAmount) {
		this.actAmount = actAmount;
	}

	public String getActAmount() {
		return actAmount;
	}

	public String getActDate() {
		return actDate;
	}

	public void setActDate(String actDate) {
		this.actDate = actDate;
	}

}
