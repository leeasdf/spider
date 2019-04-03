package xin.tianchuang.modules.spider.bean.tyc.dto;

import java.io.Serializable;

public class JingpinDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3755080061844012093L;
	private String area;
	private String product;
	private String datetime;
	private String business;
	private String price;
	private String turn;
	private String hangye;

	public void setArea(String area) {
		this.area = area;
	}

	public String getArea() {
		return area;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getProduct() {
		return product;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public String getBusiness() {
		return business;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPrice() {
		return price;
	}

	public void setTurn(String turn) {
		this.turn = turn;
	}

	public String getTurn() {
		return turn;
	}

	public void setHangye(String hangye) {
		this.hangye = hangye;
	}

	public String getHangye() {
		return hangye;
	}
}
