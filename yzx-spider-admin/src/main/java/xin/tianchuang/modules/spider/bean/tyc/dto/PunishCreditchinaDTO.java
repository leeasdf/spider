package xin.tianchuang.modules.spider.bean.tyc.dto;

import java.io.Serializable;

/**
 * 行政处罚[信用中国]
 * 
 * @author denghui
 *
 */
public class PunishCreditchinaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4794488140626204904L;

	/**
	 * 处罚内容
	 */
	private String result;
	/**
	 * 决定机关
	 */
	private String departmentName;
	/**
	 * 原因
	 */
	private String reason;
	/**
	 * 处罚名称
	 */
	private String punishName;
	private String evidence;
	/**
	 * 区域名称
	 */
	private String areaName;
	/**
	 * 决定书文号
	 */
	private String punishNumber;

	private String typeSecond;
	/**
	 * 类型
	 */
	private String type;
	/**
	 * 决定日期
	 */
	private String decisionDate;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getPunishName() {
		return punishName;
	}

	public void setPunishName(String punishName) {
		this.punishName = punishName;
	}

	public String getEvidence() {
		return evidence;
	}

	public void setEvidence(String evidence) {
		this.evidence = evidence;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getPunishNumber() {
		return punishNumber;
	}

	public void setPunishNumber(String punishNumber) {
		this.punishNumber = punishNumber;
	}

	public String getTypeSecond() {
		return typeSecond;
	}

	public void setTypeSecond(String typeSecond) {
		this.typeSecond = typeSecond;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDecisionDate() {
		return decisionDate;
	}

	public void setDecisionDate(String decisionDate) {
		this.decisionDate = decisionDate;
	}

}
