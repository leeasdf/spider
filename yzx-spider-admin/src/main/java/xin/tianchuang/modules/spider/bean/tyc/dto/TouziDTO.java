package xin.tianchuang.modules.spider.bean.tyc.dto;

import java.io.Serializable;

public class TouziDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2383333330301688118L;

	private String date;
	private String turn;
	private String amount;
	private String investors;
	private String product;
	private String area;
	private String industry;
	private String business;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTurn() {
		return turn;
	}

	public void setTurn(String turn) {
		this.turn = turn;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getInvestors() {
		return investors;
	}

	public void setInvestors(String investors) {
		this.investors = investors;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

}
