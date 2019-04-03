package xin.tianchuang.modules.spider.bean.task;

import java.io.Serializable;

public class SpiderTaskParamDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1153818442913323339L;

	/**
	 * 条数
	 */
	private Integer fetch;

	/**
	 * 状态
	 */
	private Integer status;

	/**
	 * 省份
	 */
	private String provice;

	/**
	 * 城市
	 */
	private String city;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 升序
	 */
	private Boolean isAsc;

	public Integer getFetch() {
		return fetch;
	}

	public void setFetch(Integer fetch) {
		this.fetch = fetch;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getProvice() {
		return provice;
	}

	public void setProvice(String provice) {
		this.provice = provice;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Boolean getIsAsc() {
		return isAsc;
	}

	public void setIsAsc(Boolean isAsc) {
		this.isAsc = isAsc;
	}

}
