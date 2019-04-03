package xin.tianchuang.modules.spider.bean.tyc.result;

import java.io.Serializable;
import java.util.List;

public class SimpleBackgroundResultDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4802805939231936531L;
	private String tycUpdateTime;
	private String website;
	private String address;
	private List<String> historyList;
	private String phones;
	private String enterpriseName;
	private String email;
	private String content;

	public String getTycUpdateTime() {
		return tycUpdateTime;
	}

	public void setTycUpdateTime(String tycUpdateTime) {
		this.tycUpdateTime = tycUpdateTime;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getWebsite() {
		return website;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setHistoryList(List<String> historyList) {
		this.historyList = historyList;
	}

	public List<String> getHistoryList() {
		return historyList;
	}

	public void setPhones(String phones) {
		this.phones = phones;
	}

	public String getPhones() {
		return phones;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}
}
