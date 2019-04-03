package xin.tianchuang.modules.spider.bean.task;

import java.io.Serializable;

public class HnEntEnvCreditTaskParamDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4591616987324416825L;

	/**
	 * 企业名称
	 */
	private String comName;

	/**
	 * 区域id
	 */
	private String areaId;

	/**
	 * 评级年度
	 */
	private String year;

	/**
	 * 评定等级
	 */
	private String level;

	private String page;

	private String rows;

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

}
