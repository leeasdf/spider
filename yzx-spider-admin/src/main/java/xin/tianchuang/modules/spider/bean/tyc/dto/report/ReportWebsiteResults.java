package xin.tianchuang.modules.spider.bean.tyc.dto.report;

import java.io.Serializable;

public class ReportWebsiteResults implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -40781300203360909L;
	/**
	 * 类型
	 */
	private String name;
	/**
	 * 名称
	 */
	private String type;
	/**
	 * 网址
	 */
	private String url;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}
}
