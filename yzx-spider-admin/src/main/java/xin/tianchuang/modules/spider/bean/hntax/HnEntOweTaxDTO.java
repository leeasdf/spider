package xin.tianchuang.modules.spider.bean.hntax;

import java.io.Serializable;
import java.util.List;

public class HnEntOweTaxDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2428010922127019558L;
	/**
	 * 纳税人名称
	 */
	private String taxName;
	/**
	 * 纳税人识别号
	 */
	private String taxNo;
	/**
	 * 法定代表人(负责人)姓名
	 */
	private String legalName;
	/**
	 * 法定代表人(负责人)证件类型
	 */
	private String certType;
	/**
	 * 法定代表人(负责人)证件号码
	 */
	private String certNo;
	/**
	 * 经营地点
	 */
	private String address;
	/**
	 * 欠税税种
	 */
	private String oweTaxType;
	/**
	 * 欠税余额（元）
	 */
	private String oweTaxBalance;
	/**
	 * 当期新发生的欠税金额（元）
	 */
	private String currentOccurreAmount;
	/**
	 * 公示时间
	 */
	private String publishDate;

	public String getTaxName() {
		return taxName;
	}

	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}

	public String getTaxNo() {
		return taxNo;
	}

	public void setTaxNo(String taxNo) {
		this.taxNo = taxNo;
	}

	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public String getCertType() {
		return certType;
	}

	public void setCertType(String certType) {
		this.certType = certType;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOweTaxType() {
		return oweTaxType;
	}

	public void setOweTaxType(String oweTaxType) {
		this.oweTaxType = oweTaxType;
	}

	public String getOweTaxBalance() {
		return oweTaxBalance;
	}

	public void setOweTaxBalance(String oweTaxBalance) {
		this.oweTaxBalance = oweTaxBalance;
	}

	public String getCurrentOccurreAmount() {
		return currentOccurreAmount;
	}

	public void setCurrentOccurreAmount(String currentOccurreAmount) {
		this.currentOccurreAmount = currentOccurreAmount;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

}
