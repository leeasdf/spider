package xin.tianchuang.modules.spider.bean.tyc.dto;

import java.io.Serializable;

public class ListResultsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4053651187271546700L;

	/**
	 * 天眼查得分
	 */
	private String score;

	/**
	 * 注册时间
	 */
	private String regTime;

	/**
	 * 省份
	 */
	private String province;

	/**
	 * 天眼查id
	 */
	private String tycEnterpriseId;

	/**
	 * 是否重命名标识
	 */
	private Boolean renameFlag;

	private String oldName;

	private String newName;

	/**
	 * 注册资金
	 */
	private String regCap;

	/**
	 * 企业名称
	 */
	private String enterpriseName;

	/**
	 * 法人姓名
	 */
	private String legalPersonName;

	/**
	 * 状态
	 */
	private String status;
	

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getRegTime() {
		return regTime;
	}

	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getTycEnterpriseId() {
		return tycEnterpriseId;
	}

	public void setTycEnterpriseId(String tycEnterpriseId) {
		this.tycEnterpriseId = tycEnterpriseId;
	}

	public Boolean getRenameFlag() {
		return renameFlag;
	}

	public void setRenameFlag(Boolean renameFlag) {
		this.renameFlag = renameFlag;
	}

	public String getRegCap() {
		return regCap;
	}

	public void setRegCap(String regCap) {
		this.regCap = regCap;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public String getLegalPersonName() {
		return legalPersonName;
	}

	public void setLegalPersonName(String legalPersonName) {
		this.legalPersonName = legalPersonName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOldName() {
		return oldName;
	}

	public void setOldName(String oldName) {
		this.oldName = oldName;
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	
}
