package xin.tianchuang.modules.spider.bean.tyc.dto;

import java.io.Serializable;

public class ClearingDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 502291810104952274L;

	private String clearTitle;

	private String clearContent;

	public String getClearTitle() {
		return clearTitle;
	}

	public void setClearTitle(String clearTitle) {
		this.clearTitle = clearTitle;
	}

	public String getClearContent() {
		return clearContent;
	}

	public void setClearContent(String clearContent) {
		this.clearContent = clearContent;
	}
}
