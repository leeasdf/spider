package xin.tianchuang.modules.spider.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 国税基础信息(导入)
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:23
 */
@TableName("ori_national_tax_base")
public class OriNationalTaxBaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 组织机构代码
	 */
	private String organizationCode;
	/**
	 * 企业名称
	 */
	private String enterpriseName;
	/**
	 * 工商营业执照注册号
	 */
	private String licenseRegisterNumber;
	/**
	 * 税务登记证号
	 */
	private String taxNumber;
	/**
	 * 法定代表人（负责人）
	 */
	private String legal;
	/**
	 * 法定代表人（负责人）身份证件号
	 */
	private String cardNumber;
	/**
	 * 注册地址
	 */
	private String registerAddress;
	/**
	 * 经营地址（国）
	 */
	private String businessAddress;
	/**
	 * 经营方式
	 */
	private String businessWay;
	/**
	 * 电话
	 */
	private String telephone;
	/**
	 * 企业状态编码（国）
	 */
	private String enterpriseStatus;
	/**
	 * 税务部门编码（国）
	 */
	private String taxDepartmentCode;
	/**
	 * 发证日期
	 */
	private String certificationDate;
	/**
	 * 税务登记日期（国）
	 */
	private String taxRegisterDate;
	/**
	 * 登记注册类型
	 */
	private String registerType;
	/**
	 * 经营期限
	 */
	private String businessDeadline;
	/**
	 * 注册资本
	 */
	private String registeredCapital;
	/**
	 * 注册资本币种
	 */
	private String currency;
	/**
	 * 银行编码（国）
	 */
	private String bank;
	/**
	 * 银行网点编码（国）
	 */
	private String bankDot;
	/**
	 * 缴税银行帐号（国）
	 */
	private String payingBankAccount;

	/**
	 * 设置：主键
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：组织机构代码
	 */
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	/**
	 * 获取：组织机构代码
	 */
	public String getOrganizationCode() {
		return organizationCode;
	}
	/**
	 * 设置：企业名称
	 */
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	/**
	 * 获取：企业名称
	 */
	public String getEnterpriseName() {
		return enterpriseName;
	}
	/**
	 * 设置：工商营业执照注册号
	 */
	public void setLicenseRegisterNumber(String licenseRegisterNumber) {
		this.licenseRegisterNumber = licenseRegisterNumber;
	}
	/**
	 * 获取：工商营业执照注册号
	 */
	public String getLicenseRegisterNumber() {
		return licenseRegisterNumber;
	}
	/**
	 * 设置：税务登记证号
	 */
	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}
	/**
	 * 获取：税务登记证号
	 */
	public String getTaxNumber() {
		return taxNumber;
	}
	/**
	 * 设置：法定代表人（负责人）
	 */
	public void setLegal(String legal) {
		this.legal = legal;
	}
	/**
	 * 获取：法定代表人（负责人）
	 */
	public String getLegal() {
		return legal;
	}
	/**
	 * 设置：法定代表人（负责人）身份证件号
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	/**
	 * 获取：法定代表人（负责人）身份证件号
	 */
	public String getCardNumber() {
		return cardNumber;
	}
	/**
	 * 设置：注册地址
	 */
	public void setRegisterAddress(String registerAddress) {
		this.registerAddress = registerAddress;
	}
	/**
	 * 获取：注册地址
	 */
	public String getRegisterAddress() {
		return registerAddress;
	}
	/**
	 * 设置：经营地址（国）
	 */
	public void setBusinessAddress(String businessAddress) {
		this.businessAddress = businessAddress;
	}
	/**
	 * 获取：经营地址（国）
	 */
	public String getBusinessAddress() {
		return businessAddress;
	}
	/**
	 * 设置：经营方式
	 */
	public void setBusinessWay(String businessWay) {
		this.businessWay = businessWay;
	}
	/**
	 * 获取：经营方式
	 */
	public String getBusinessWay() {
		return businessWay;
	}
	/**
	 * 设置：电话
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/**
	 * 获取：电话
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * 设置：企业状态编码（国）
	 */
	public void setEnterpriseStatus(String enterpriseStatus) {
		this.enterpriseStatus = enterpriseStatus;
	}
	/**
	 * 获取：企业状态编码（国）
	 */
	public String getEnterpriseStatus() {
		return enterpriseStatus;
	}
	/**
	 * 设置：税务部门编码（国）
	 */
	public void setTaxDepartmentCode(String taxDepartmentCode) {
		this.taxDepartmentCode = taxDepartmentCode;
	}
	/**
	 * 获取：税务部门编码（国）
	 */
	public String getTaxDepartmentCode() {
		return taxDepartmentCode;
	}
	/**
	 * 设置：发证日期
	 */
	public void setCertificationDate(String certificationDate) {
		this.certificationDate = certificationDate;
	}
	/**
	 * 获取：发证日期
	 */
	public String getCertificationDate() {
		return certificationDate;
	}
	/**
	 * 设置：税务登记日期（国）
	 */
	public void setTaxRegisterDate(String taxRegisterDate) {
		this.taxRegisterDate = taxRegisterDate;
	}
	/**
	 * 获取：税务登记日期（国）
	 */
	public String getTaxRegisterDate() {
		return taxRegisterDate;
	}
	/**
	 * 设置：登记注册类型
	 */
	public void setRegisterType(String registerType) {
		this.registerType = registerType;
	}
	/**
	 * 获取：登记注册类型
	 */
	public String getRegisterType() {
		return registerType;
	}
	/**
	 * 设置：经营期限
	 */
	public void setBusinessDeadline(String businessDeadline) {
		this.businessDeadline = businessDeadline;
	}
	/**
	 * 获取：经营期限
	 */
	public String getBusinessDeadline() {
		return businessDeadline;
	}
	/**
	 * 设置：注册资本
	 */
	public void setRegisteredCapital(String registeredCapital) {
		this.registeredCapital = registeredCapital;
	}
	/**
	 * 获取：注册资本
	 */
	public String getRegisteredCapital() {
		return registeredCapital;
	}
	/**
	 * 设置：注册资本币种
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	/**
	 * 获取：注册资本币种
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 设置：银行编码（国）
	 */
	public void setBank(String bank) {
		this.bank = bank;
	}
	/**
	 * 获取：银行编码（国）
	 */
	public String getBank() {
		return bank;
	}
	/**
	 * 设置：银行网点编码（国）
	 */
	public void setBankDot(String bankDot) {
		this.bankDot = bankDot;
	}
	/**
	 * 获取：银行网点编码（国）
	 */
	public String getBankDot() {
		return bankDot;
	}
	/**
	 * 设置：缴税银行帐号（国）
	 */
	public void setPayingBankAccount(String payingBankAccount) {
		this.payingBankAccount = payingBankAccount;
	}
	/**
	 * 获取：缴税银行帐号（国）
	 */
	public String getPayingBankAccount() {
		return payingBankAccount;
	}
}
