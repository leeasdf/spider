package xin.tianchuang.modules.spider.bean.tyc.dto.report;

import java.io.Serializable;

public class ReportBaseInfoResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -773337612453954531L;
	/**
	 * 统一社会信息代码
	 */
	private String creditCode;
	/**
	 * 企业通信地址
	 */
	private String address;
	/**
	 * 是否有网站或网点
	 */
	private String websiteFlag;
	/**
	 * 企业联系电话
	 */
	private String phone;
	
	/**
	 * 邮政编码
	 */
	private String postalcode;
	/**
	 * 企业名称
	 */
	private String name;
	/**
	 * 企业是否有投资信息或购买其他公司股权
	 */
	private String investFlag;
	/**
	 * 从业人数
	 */
	private String employeeCount;
	/**
	 * 电子邮箱
	 */
	private String email;
	/**
	 * 企业经营状况
	 */
	private String status;

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

	public String getCreditCode() {
		return creditCode;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setWebsiteFlag(String websiteFlag) {
		this.websiteFlag = websiteFlag;
	}

	public String getWebsiteFlag() {
		return websiteFlag;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setInvestFlag(String investFlag) {
		this.investFlag = investFlag;
	}

	public String getInvestFlag() {
		return investFlag;
	}

	public void setEmployeeCount(String employeeCount) {
		this.employeeCount = employeeCount;
	}

	public String getEmployeeCount() {
		return employeeCount;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
