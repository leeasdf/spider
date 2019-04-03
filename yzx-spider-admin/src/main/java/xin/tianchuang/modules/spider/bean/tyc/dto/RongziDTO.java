package xin.tianchuang.modules.spider.bean.tyc.dto;

import java.io.Serializable;

public class RongziDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4328264908571304384L;
	private String date;
	private String news;
	private String amount;
	private String newsUrl;
	private String price;
	private String company;
	private String time;
	private String perice;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setNews(String news) {
		this.news = news;
	}

	public String getNews() {
		return news;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getAmount() {
		return amount;
	}

	public void setNewsUrl(String newsUrl) {
		this.newsUrl = newsUrl;
	}

	public String getNewsUrl() {
		return newsUrl;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPrice() {
		return price;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompany() {
		return company;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTime() {
		return time;
	}

	public void setPerice(String perice) {
		this.perice = perice;
	}

	public String getPerice() {
		return perice;
	}
}
