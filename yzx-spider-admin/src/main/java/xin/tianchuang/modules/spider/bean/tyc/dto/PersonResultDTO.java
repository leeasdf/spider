package xin.tianchuang.modules.spider.bean.tyc.dto;

import java.io.Serializable;

public class PersonResultDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3163763667523886415L;
	private String name;
	private String job;
	private String url;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getJob() {
		return job;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}
}
