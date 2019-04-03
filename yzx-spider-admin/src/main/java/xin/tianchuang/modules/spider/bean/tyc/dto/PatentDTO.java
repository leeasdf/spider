package xin.tianchuang.modules.spider.bean.tyc.dto;

import java.io.Serializable;

/**
 * 专利信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:20
 */

public class PatentDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2753543602680353393L;
	/**
	 * 申请公布日期
	 */
	private String appDate;
	/**
	 * 专利名称
	 */
	private String name;
	/**
	 * 申请号
	 */
	private String appNum;

	/**
	 * 申请公开号
	 */
	private String appPubNum;
	/**
	 * 专利类型
	 */
	private String type;

	/**
	 * 设置：申请公布日期
	 */
	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}

	/**
	 * 获取：申请公布日期
	 */
	public String getAppDate() {
		return appDate;
	}

	/**
	 * 设置：专利名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取：专利名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置：申请号
	 */
	public void setAppNum(String appNum) {
		this.appNum = appNum;
	}

	/**
	 * 获取：申请号
	 */
	public String getAppNum() {
		return appNum;
	}

	/**
	 * 设置：申请公开号
	 */
	public void setAppPubNum(String appPubNum) {
		this.appPubNum = appPubNum;
	}

	/**
	 * 获取：申请公开号
	 */
	public String getAppPubNum() {
		return appPubNum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


}
