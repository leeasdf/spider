package xin.tianchuang.modules.spider.bean.tyc.dto.report;

import java.io.Serializable;

public class ReportSocialInfoResult implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6639488515128369879L;

	/**
	 * 单位参加工伤保险缴费基数
	 */
	private String injuryRadix;
	/**
	 * 工伤保险
	 * 
	 */
	private String injuryNum;
	/**
	 * 参加工伤保险本期实际缴费金额
	 */
	private String injuryAmount;
	/**
	 * 参加失业保险本期实际缴费金额
	 */
	private String unemployAmount;
	/**
	 * 单位参加职工基本医疗保险累积欠缴金额
	 */
	private String medicalnsureOweAmount;
	/**
	 * 参加城镇职工基本养老保险本期实际缴费金额
	 */
	private String oldAgeAmount;
	/**
	 * 城镇职工基本养老保险
	 */
	private String oldAgeNum;
	/**
	 * 失业保险
	 */
	private String unemployNum;
	/**
	 * 职工基本医疗保险
	 */
	private String medicalNum;
	/**
	 * 生育保险
	 */
	private String maternityNum;
	/**
	 * 单位参加生育保险缴费基数
	 */
	private String maternityRadix;
	/**
	 * 单位参加工伤保险累积欠缴金额
	 */
	private String injuryInsureOweAmount;
	/**
	 * 单位参加城镇职工基本养老保险缴费基数
	 */
	private String oldAgeRadix;
	/**
	 * 单位参加城镇职工基本养老保险累积欠缴金额
	 */
	private String oldAgelnsureOweAmount;
	/**
	 * 参加职工基本医疗保险本期实际缴费金额
	 */
	private String medicalAmount;
	/**
	 * 单位参加失业保险缴费基数
	 */
	private String unemployRadix;
	/**
	 * 单位参加生育保险累积欠缴金额
	 */
	private String maternityInsureOweAmount;
	/**
	 * 参加生育保险本期实际缴费金额
	 */
	private String maternityAmount;
	/**
	 * 单位参加失业保险累积欠缴金额
	 */
	private String unemploylnsureOweAmount;
	/**
	 * 单位参加职工基本医疗保险缴费基数
	 */
	private String medicalRadix;

	public void setInjuryRadix(String injuryRadix) {
		this.injuryRadix = injuryRadix;
	}

	public String getInjuryRadix() {
		return injuryRadix;
	}

	public void setInjuryNum(String injuryNum) {
		this.injuryNum = injuryNum;
	}

	public String getInjuryNum() {
		return injuryNum;
	}

	public void setInjuryAmount(String injuryAmount) {
		this.injuryAmount = injuryAmount;
	}

	public String getInjuryAmount() {
		return injuryAmount;
	}

	public void setUnemployAmount(String unemployAmount) {
		this.unemployAmount = unemployAmount;
	}

	public String getUnemployAmount() {
		return unemployAmount;
	}

	public void setOldAgeAmount(String oldAgeAmount) {
		this.oldAgeAmount = oldAgeAmount;
	}

	public String getOldAgeAmount() {
		return oldAgeAmount;
	}

	public void setOldAgeNum(String oldAgeNum) {
		this.oldAgeNum = oldAgeNum;
	}

	public String getOldAgeNum() {
		return oldAgeNum;
	}

	public void setUnemployNum(String unemployNum) {
		this.unemployNum = unemployNum;
	}

	public String getUnemployNum() {
		return unemployNum;
	}

	public void setMedicalNum(String medicalNum) {
		this.medicalNum = medicalNum;
	}

	public String getMedicalNum() {
		return medicalNum;
	}

	public void setMaternityNum(String maternityNum) {
		this.maternityNum = maternityNum;
	}

	public String getMaternityNum() {
		return maternityNum;
	}

	public void setMaternityRadix(String maternityRadix) {
		this.maternityRadix = maternityRadix;
	}

	public String getMaternityRadix() {
		return maternityRadix;
	}

	public void setInjuryInsureOweAmount(String injuryInsureOweAmount) {
		this.injuryInsureOweAmount = injuryInsureOweAmount;
	}

	public String getInjuryInsureOweAmount() {
		return injuryInsureOweAmount;
	}

	public void setOldAgeRadix(String oldAgeRadix) {
		this.oldAgeRadix = oldAgeRadix;
	}

	public String getOldAgeRadix() {
		return oldAgeRadix;
	}

	public void setOldAgelnsureOweAmount(String oldAgelnsureOweAmount) {
		this.oldAgelnsureOweAmount = oldAgelnsureOweAmount;
	}

	public String getOldAgelnsureOweAmount() {
		return oldAgelnsureOweAmount;
	}

	public void setMedicalAmount(String medicalAmount) {
		this.medicalAmount = medicalAmount;
	}

	public String getMedicalAmount() {
		return medicalAmount;
	}

	public void setUnemployRadix(String unemployRadix) {
		this.unemployRadix = unemployRadix;
	}

	public String getUnemployRadix() {
		return unemployRadix;
	}

	public String getMedicalnsureOweAmount() {
		return medicalnsureOweAmount;
	}

	public void setMedicalnsureOweAmount(String medicalnsureOweAmount) {
		this.medicalnsureOweAmount = medicalnsureOweAmount;
	}

	public String getMaternityInsureOweAmount() {
		return maternityInsureOweAmount;
	}

	public void setMaternityInsureOweAmount(String maternityInsureOweAmount) {
		this.maternityInsureOweAmount = maternityInsureOweAmount;
	}

	public void setMaternityAmount(String maternityAmount) {
		this.maternityAmount = maternityAmount;
	}

	public String getMaternityAmount() {
		return maternityAmount;
	}

	public void setUnemploylnsureOweAmount(String unemploylnsureOweAmount) {
		this.unemploylnsureOweAmount = unemploylnsureOweAmount;
	}

	public String getUnemploylnsureOweAmount() {
		return unemploylnsureOweAmount;
	}

	public void setMedicalRadix(String medicalRadix) {
		this.medicalRadix = medicalRadix;
	}

	public String getMedicalRadix() {
		return medicalRadix;
	}
}
