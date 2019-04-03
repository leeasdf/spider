package xin.tianchuang.modules.spider.bean.tyc.result;

import xin.tianchuang.common.bean.BaseDTO;

public class BaseTycResultsDTO extends BaseDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6645529199124391208L;

	private String pageTotal;

	private Integer pageNum;

	public String getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(String pageTotal) {
		this.pageTotal = pageTotal;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

}
