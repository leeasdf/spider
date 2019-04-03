package xin.tianchuang.modules.spider.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 省发改委-长沙工商-企业基础信息(导入)
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:23
 */
@TableName("ori_enterprise_business_base_info")
public class OriEnterpriseBusinessBaseInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 企业ID
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long enterpriseId;
	/**
	 * 企业(机构)名称
	 */
	private String enterpriseName;
	/**
	 * 原注册号
	 */
	private String oriRegisterNo;
	/**
	 * 注册号
	 */
	private String registerNo;
	/**
	 * 企业(机构)类型
	 */
	private String enterpriseType;
	/**
	 * 隶属企业主体身份代码
	 */
	private String subjectIdentityCode;
	/**
	 * 隶属企业机构名称
	 */
	private String belongEnterpriseName;
	/**
	 * 隶属企业注册号
	 */
	private String belongRegisterNo;
	/**
	 * 隶属关系
	 */
	private String belongRelationship;
	/**
	 * 行业门类
	 */
	private String industryCategories;
	/**
	 * 行业代码
	 */
	private String industryCode;
	/**
	 * 许可经营项目
	 */
	private String permittedOperatingItems;
	/**
	 * 一般经营项目
	 */
	private String generalOperatingItems;
	/**
	 * 经营(驻在)期限自
	 */
	private String businessPeriodBegin;
	/**
	 * 经营(驻在)期限至
	 */
	private String businessPeriodEnd;
	/**
	 * 邮政编码
	 */
	private String zipCode;
	/**
	 * 联系电话
	 */
	private String phone;
	/**
	 * 电子邮箱
	 */
	private String email;
	/**
	 * 属地监管工商所
	 */
	private String belongIndustryCommerceBureau;
	/**
	 * 信用等级
	 */
	private String creditRating;
	/**
	 * 分类日期
	 */
	private String classificationDate;
	/**
	 * 成立日期
	 */
	private String setUpDate;
	/**
	 * 核准日期
	 */
	private String approvalDate;
	/**
	 * 登记机关
	 */
	private String registrationAuthority;
	/**
	 * 企业分类码
	 */
	private String enterpriseClassificationCode;
	/**
	 * 企业状态
	 */
	private String enterpriseState;
	/**
	 * 注册资金
	 */
	private String registeredCapital;
	/**
	 * 经营(业务)范围
	 */
	private String operationScope;
	/**
	 * 经营方式
	 */
	private String operationMode;
	/**
	 * 经营范围及方式
	 */
	private String operationScopeMode;
	/**
	 * 兼营范围
	 */
	private String engagedScope;
	/**
	 * 住所所在行政区划
	 */
	private String domicileArea;
	/**
	 * 住所
	 */
	private String domicile;
	/**
	 * 住所所在经济开发区
	 */
	private String domicileDevelopZone;
	/**
	 * 住所产权
	 */
	private String houseProperty;
	/**
	 * 经营场所所在行政区划
	 */
	private String premisesArea;
	/**
	 * 经营场所
	 */
	private String premises;
	/**
	 * 实收资本
	 */
	private String paidInCapital;
	/**
	 * 设立方式
	 */
	private String setUpMode;
	/**
	 * 合伙人数
	 */
	private String partnershipNo;
	/**
	 * 有限合伙人数
	 */
	private String partnersLimitedNo;
	/**
	 * 合伙方式
	 */
	private String partnershipMode;
	/**
	 * 执行人数
	 */
	private String performNo;
	/**
	 * 从业人数
	 */
	private String employeesNo;
	/**
	 * 出资方式(个独)或组成形式（个体）
	 */
	private String contributionMode;
	/**
	 * 外资产业代码
	 */
	private String foreignIndustryCode;
	/**
	 * 中西部优势产业代码
	 */
	private String midwestIndustrialCode;
	/**
	 * 项目类型
	 */
	private String projectType;
	/**
	 * 投资总额
	 */
	private String investmentTotalAmount;
	/**
	 * 投资总额币种
	 */
	private String investmentTotalAmountCurrency;
	/**
	 * 投资总额折万美元
	 */
	private String investmentTotalAmountUsd;
	/**
	 * 注册资本(金)折万美元
	 */
	private String registeredCapitalUsd;
	/**
	 * 注册资本(金)币种
	 */
	private String registeredCapitalCurrency;
	/**
	 * 注册资本(金)折万人民币
	 */
	private String registeredCapitalCny;
	/**
	 * 外方注册资本(金)币种
	 */
	private String foreignRegisteredCapitalCurrency;
	/**
	 * 外方注册资本(金)折万美元
	 */
	private String foreignRegisteredCapitalUsd;
	/**
	 * 外方实收资本折万美元
	 */
	private String foreignPaidInCapitalUsd;
	/**
	 * 营运资金
	 */
	private String workingCapital;
	/**
	 * 转型日期
	 */
	private String transformationDate;
	/**
	 * 经营活动类型
	 */
	private String businessType;
	/**
	 * 外国(地区)企业名称
	 */
	private String foreignEnterpriseName;
	/**
	 * 主管部门
	 */
	private String competentDepartment;
	/**
	 * 国别(地区)
	 */
	private String country;
	/**
	 * 承包工程或经营管理项目
	 */
	private String contractProject;
	/**
	 * 承包工程或经营管理内容
	 */
	private String contractProjectRemark;
	/**
	 * 境外住所
	 */
	private String outsideHouse;
	/**
	 * 境外注册资本
	 */
	private String overseasRegisteredCapital;
	/**
	 * 境外经营范围
	 */
	private String overseasBusinessScope;
	/**
	 * 企业性质
	 */
	private String enterpriseNature;
	/**
	 * 境外主体类型
	 */
	private String overseasSubjectType;
	/**
	 * 经营类别
	 */
	private String businessCategory;
	/**
	 * 统一社会信用代码
	 */
	private String uniformSocialCreditCode;
	/**
	 * 隶属企业统一社会信用代码
	 */
	private String belongUniformSocialCreditCode;
	/**
	 * 主体身份代码
	 */
	private String principalIdentityCode;
	/**
	 * 创建时间
	 */
	 @TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;

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
	 * 设置：企业ID
	 */
	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	/**
	 * 获取：企业ID
	 */
	public Long getEnterpriseId() {
		return enterpriseId;
	}
	/**
	 * 设置：企业(机构)名称
	 */
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	/**
	 * 获取：企业(机构)名称
	 */
	public String getEnterpriseName() {
		return enterpriseName;
	}
	/**
	 * 设置：原注册号
	 */
	public void setOriRegisterNo(String oriRegisterNo) {
		this.oriRegisterNo = oriRegisterNo;
	}
	/**
	 * 获取：原注册号
	 */
	public String getOriRegisterNo() {
		return oriRegisterNo;
	}
	/**
	 * 设置：注册号
	 */
	public void setRegisterNo(String registerNo) {
		this.registerNo = registerNo;
	}
	/**
	 * 获取：注册号
	 */
	public String getRegisterNo() {
		return registerNo;
	}
	/**
	 * 设置：企业(机构)类型
	 */
	public void setEnterpriseType(String enterpriseType) {
		this.enterpriseType = enterpriseType;
	}
	/**
	 * 获取：企业(机构)类型
	 */
	public String getEnterpriseType() {
		return enterpriseType;
	}
	/**
	 * 设置：隶属企业主体身份代码
	 */
	public void setSubjectIdentityCode(String subjectIdentityCode) {
		this.subjectIdentityCode = subjectIdentityCode;
	}
	/**
	 * 获取：隶属企业主体身份代码
	 */
	public String getSubjectIdentityCode() {
		return subjectIdentityCode;
	}
	/**
	 * 设置：隶属企业机构名称
	 */
	public void setBelongEnterpriseName(String belongEnterpriseName) {
		this.belongEnterpriseName = belongEnterpriseName;
	}
	/**
	 * 获取：隶属企业机构名称
	 */
	public String getBelongEnterpriseName() {
		return belongEnterpriseName;
	}
	/**
	 * 设置：隶属企业注册号
	 */
	public void setBelongRegisterNo(String belongRegisterNo) {
		this.belongRegisterNo = belongRegisterNo;
	}
	/**
	 * 获取：隶属企业注册号
	 */
	public String getBelongRegisterNo() {
		return belongRegisterNo;
	}
	/**
	 * 设置：隶属关系
	 */
	public void setBelongRelationship(String belongRelationship) {
		this.belongRelationship = belongRelationship;
	}
	/**
	 * 获取：隶属关系
	 */
	public String getBelongRelationship() {
		return belongRelationship;
	}
	/**
	 * 设置：行业门类
	 */
	public void setIndustryCategories(String industryCategories) {
		this.industryCategories = industryCategories;
	}
	/**
	 * 获取：行业门类
	 */
	public String getIndustryCategories() {
		return industryCategories;
	}
	/**
	 * 设置：行业代码
	 */
	public void setIndustryCode(String industryCode) {
		this.industryCode = industryCode;
	}
	/**
	 * 获取：行业代码
	 */
	public String getIndustryCode() {
		return industryCode;
	}
	/**
	 * 设置：许可经营项目
	 */
	public void setPermittedOperatingItems(String permittedOperatingItems) {
		this.permittedOperatingItems = permittedOperatingItems;
	}
	/**
	 * 获取：许可经营项目
	 */
	public String getPermittedOperatingItems() {
		return permittedOperatingItems;
	}
	/**
	 * 设置：一般经营项目
	 */
	public void setGeneralOperatingItems(String generalOperatingItems) {
		this.generalOperatingItems = generalOperatingItems;
	}
	/**
	 * 获取：一般经营项目
	 */
	public String getGeneralOperatingItems() {
		return generalOperatingItems;
	}
	/**
	 * 设置：经营(驻在)期限自
	 */
	public void setBusinessPeriodBegin(String businessPeriodBegin) {
		this.businessPeriodBegin = businessPeriodBegin;
	}
	/**
	 * 获取：经营(驻在)期限自
	 */
	public String getBusinessPeriodBegin() {
		return businessPeriodBegin;
	}
	/**
	 * 设置：经营(驻在)期限至
	 */
	public void setBusinessPeriodEnd(String businessPeriodEnd) {
		this.businessPeriodEnd = businessPeriodEnd;
	}
	/**
	 * 获取：经营(驻在)期限至
	 */
	public String getBusinessPeriodEnd() {
		return businessPeriodEnd;
	}
	/**
	 * 设置：邮政编码
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	/**
	 * 获取：邮政编码
	 */
	public String getZipCode() {
		return zipCode;
	}
	/**
	 * 设置：联系电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：联系电话
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：电子邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：电子邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：属地监管工商所
	 */
	public void setBelongIndustryCommerceBureau(String belongIndustryCommerceBureau) {
		this.belongIndustryCommerceBureau = belongIndustryCommerceBureau;
	}
	/**
	 * 获取：属地监管工商所
	 */
	public String getBelongIndustryCommerceBureau() {
		return belongIndustryCommerceBureau;
	}
	/**
	 * 设置：信用等级
	 */
	public void setCreditRating(String creditRating) {
		this.creditRating = creditRating;
	}
	/**
	 * 获取：信用等级
	 */
	public String getCreditRating() {
		return creditRating;
	}
	/**
	 * 设置：分类日期
	 */
	public void setClassificationDate(String classificationDate) {
		this.classificationDate = classificationDate;
	}
	/**
	 * 获取：分类日期
	 */
	public String getClassificationDate() {
		return classificationDate;
	}
	/**
	 * 设置：成立日期
	 */
	public void setSetUpDate(String setUpDate) {
		this.setUpDate = setUpDate;
	}
	/**
	 * 获取：成立日期
	 */
	public String getSetUpDate() {
		return setUpDate;
	}
	/**
	 * 设置：核准日期
	 */
	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}
	/**
	 * 获取：核准日期
	 */
	public String getApprovalDate() {
		return approvalDate;
	}
	/**
	 * 设置：登记机关
	 */
	public void setRegistrationAuthority(String registrationAuthority) {
		this.registrationAuthority = registrationAuthority;
	}
	/**
	 * 获取：登记机关
	 */
	public String getRegistrationAuthority() {
		return registrationAuthority;
	}
	/**
	 * 设置：企业分类码
	 */
	public void setEnterpriseClassificationCode(String enterpriseClassificationCode) {
		this.enterpriseClassificationCode = enterpriseClassificationCode;
	}
	/**
	 * 获取：企业分类码
	 */
	public String getEnterpriseClassificationCode() {
		return enterpriseClassificationCode;
	}
	/**
	 * 设置：企业状态
	 */
	public void setEnterpriseState(String enterpriseState) {
		this.enterpriseState = enterpriseState;
	}
	/**
	 * 获取：企业状态
	 */
	public String getEnterpriseState() {
		return enterpriseState;
	}
	/**
	 * 设置：注册资金
	 */
	public void setRegisteredCapital(String registeredCapital) {
		this.registeredCapital = registeredCapital;
	}
	/**
	 * 获取：注册资金
	 */
	public String getRegisteredCapital() {
		return registeredCapital;
	}
	/**
	 * 设置：经营(业务)范围
	 */
	public void setOperationScope(String operationScope) {
		this.operationScope = operationScope;
	}
	/**
	 * 获取：经营(业务)范围
	 */
	public String getOperationScope() {
		return operationScope;
	}
	/**
	 * 设置：经营方式
	 */
	public void setOperationMode(String operationMode) {
		this.operationMode = operationMode;
	}
	/**
	 * 获取：经营方式
	 */
	public String getOperationMode() {
		return operationMode;
	}
	/**
	 * 设置：经营范围及方式
	 */
	public void setOperationScopeMode(String operationScopeMode) {
		this.operationScopeMode = operationScopeMode;
	}
	/**
	 * 获取：经营范围及方式
	 */
	public String getOperationScopeMode() {
		return operationScopeMode;
	}
	/**
	 * 设置：兼营范围
	 */
	public void setEngagedScope(String engagedScope) {
		this.engagedScope = engagedScope;
	}
	/**
	 * 获取：兼营范围
	 */
	public String getEngagedScope() {
		return engagedScope;
	}
	/**
	 * 设置：住所所在行政区划
	 */
	public void setDomicileArea(String domicileArea) {
		this.domicileArea = domicileArea;
	}
	/**
	 * 获取：住所所在行政区划
	 */
	public String getDomicileArea() {
		return domicileArea;
	}
	/**
	 * 设置：住所
	 */
	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}
	/**
	 * 获取：住所
	 */
	public String getDomicile() {
		return domicile;
	}
	/**
	 * 设置：住所所在经济开发区
	 */
	public void setDomicileDevelopZone(String domicileDevelopZone) {
		this.domicileDevelopZone = domicileDevelopZone;
	}
	/**
	 * 获取：住所所在经济开发区
	 */
	public String getDomicileDevelopZone() {
		return domicileDevelopZone;
	}
	/**
	 * 设置：住所产权
	 */
	public void setHouseProperty(String houseProperty) {
		this.houseProperty = houseProperty;
	}
	/**
	 * 获取：住所产权
	 */
	public String getHouseProperty() {
		return houseProperty;
	}
	/**
	 * 设置：经营场所所在行政区划
	 */
	public void setPremisesArea(String premisesArea) {
		this.premisesArea = premisesArea;
	}
	/**
	 * 获取：经营场所所在行政区划
	 */
	public String getPremisesArea() {
		return premisesArea;
	}
	/**
	 * 设置：经营场所
	 */
	public void setPremises(String premises) {
		this.premises = premises;
	}
	/**
	 * 获取：经营场所
	 */
	public String getPremises() {
		return premises;
	}
	/**
	 * 设置：实收资本
	 */
	public void setPaidInCapital(String paidInCapital) {
		this.paidInCapital = paidInCapital;
	}
	/**
	 * 获取：实收资本
	 */
	public String getPaidInCapital() {
		return paidInCapital;
	}
	/**
	 * 设置：设立方式
	 */
	public void setSetUpMode(String setUpMode) {
		this.setUpMode = setUpMode;
	}
	/**
	 * 获取：设立方式
	 */
	public String getSetUpMode() {
		return setUpMode;
	}
	/**
	 * 设置：合伙人数
	 */
	public void setPartnershipNo(String partnershipNo) {
		this.partnershipNo = partnershipNo;
	}
	/**
	 * 获取：合伙人数
	 */
	public String getPartnershipNo() {
		return partnershipNo;
	}
	/**
	 * 设置：有限合伙人数
	 */
	public void setPartnersLimitedNo(String partnersLimitedNo) {
		this.partnersLimitedNo = partnersLimitedNo;
	}
	/**
	 * 获取：有限合伙人数
	 */
	public String getPartnersLimitedNo() {
		return partnersLimitedNo;
	}
	/**
	 * 设置：合伙方式
	 */
	public void setPartnershipMode(String partnershipMode) {
		this.partnershipMode = partnershipMode;
	}
	/**
	 * 获取：合伙方式
	 */
	public String getPartnershipMode() {
		return partnershipMode;
	}
	/**
	 * 设置：执行人数
	 */
	public void setPerformNo(String performNo) {
		this.performNo = performNo;
	}
	/**
	 * 获取：执行人数
	 */
	public String getPerformNo() {
		return performNo;
	}
	/**
	 * 设置：从业人数
	 */
	public void setEmployeesNo(String employeesNo) {
		this.employeesNo = employeesNo;
	}
	/**
	 * 获取：从业人数
	 */
	public String getEmployeesNo() {
		return employeesNo;
	}
	/**
	 * 设置：出资方式(个独)或组成形式（个体）
	 */
	public void setContributionMode(String contributionMode) {
		this.contributionMode = contributionMode;
	}
	/**
	 * 获取：出资方式(个独)或组成形式（个体）
	 */
	public String getContributionMode() {
		return contributionMode;
	}
	/**
	 * 设置：外资产业代码
	 */
	public void setForeignIndustryCode(String foreignIndustryCode) {
		this.foreignIndustryCode = foreignIndustryCode;
	}
	/**
	 * 获取：外资产业代码
	 */
	public String getForeignIndustryCode() {
		return foreignIndustryCode;
	}
	/**
	 * 设置：中西部优势产业代码
	 */
	public void setMidwestIndustrialCode(String midwestIndustrialCode) {
		this.midwestIndustrialCode = midwestIndustrialCode;
	}
	/**
	 * 获取：中西部优势产业代码
	 */
	public String getMidwestIndustrialCode() {
		return midwestIndustrialCode;
	}
	/**
	 * 设置：项目类型
	 */
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	/**
	 * 获取：项目类型
	 */
	public String getProjectType() {
		return projectType;
	}
	/**
	 * 设置：投资总额
	 */
	public void setInvestmentTotalAmount(String investmentTotalAmount) {
		this.investmentTotalAmount = investmentTotalAmount;
	}
	/**
	 * 获取：投资总额
	 */
	public String getInvestmentTotalAmount() {
		return investmentTotalAmount;
	}
	/**
	 * 设置：投资总额币种
	 */
	public void setInvestmentTotalAmountCurrency(String investmentTotalAmountCurrency) {
		this.investmentTotalAmountCurrency = investmentTotalAmountCurrency;
	}
	/**
	 * 获取：投资总额币种
	 */
	public String getInvestmentTotalAmountCurrency() {
		return investmentTotalAmountCurrency;
	}
	/**
	 * 设置：投资总额折万美元
	 */
	public void setInvestmentTotalAmountUsd(String investmentTotalAmountUsd) {
		this.investmentTotalAmountUsd = investmentTotalAmountUsd;
	}
	/**
	 * 获取：投资总额折万美元
	 */
	public String getInvestmentTotalAmountUsd() {
		return investmentTotalAmountUsd;
	}
	/**
	 * 设置：注册资本(金)折万美元
	 */
	public void setRegisteredCapitalUsd(String registeredCapitalUsd) {
		this.registeredCapitalUsd = registeredCapitalUsd;
	}
	/**
	 * 获取：注册资本(金)折万美元
	 */
	public String getRegisteredCapitalUsd() {
		return registeredCapitalUsd;
	}
	/**
	 * 设置：注册资本(金)币种
	 */
	public void setRegisteredCapitalCurrency(String registeredCapitalCurrency) {
		this.registeredCapitalCurrency = registeredCapitalCurrency;
	}
	/**
	 * 获取：注册资本(金)币种
	 */
	public String getRegisteredCapitalCurrency() {
		return registeredCapitalCurrency;
	}
	/**
	 * 设置：注册资本(金)折万人民币
	 */
	public void setRegisteredCapitalCny(String registeredCapitalCny) {
		this.registeredCapitalCny = registeredCapitalCny;
	}
	/**
	 * 获取：注册资本(金)折万人民币
	 */
	public String getRegisteredCapitalCny() {
		return registeredCapitalCny;
	}
	/**
	 * 设置：外方注册资本(金)币种
	 */
	public void setForeignRegisteredCapitalCurrency(String foreignRegisteredCapitalCurrency) {
		this.foreignRegisteredCapitalCurrency = foreignRegisteredCapitalCurrency;
	}
	/**
	 * 获取：外方注册资本(金)币种
	 */
	public String getForeignRegisteredCapitalCurrency() {
		return foreignRegisteredCapitalCurrency;
	}
	/**
	 * 设置：外方注册资本(金)折万美元
	 */
	public void setForeignRegisteredCapitalUsd(String foreignRegisteredCapitalUsd) {
		this.foreignRegisteredCapitalUsd = foreignRegisteredCapitalUsd;
	}
	/**
	 * 获取：外方注册资本(金)折万美元
	 */
	public String getForeignRegisteredCapitalUsd() {
		return foreignRegisteredCapitalUsd;
	}
	/**
	 * 设置：外方实收资本折万美元
	 */
	public void setForeignPaidInCapitalUsd(String foreignPaidInCapitalUsd) {
		this.foreignPaidInCapitalUsd = foreignPaidInCapitalUsd;
	}
	/**
	 * 获取：外方实收资本折万美元
	 */
	public String getForeignPaidInCapitalUsd() {
		return foreignPaidInCapitalUsd;
	}
	/**
	 * 设置：营运资金
	 */
	public void setWorkingCapital(String workingCapital) {
		this.workingCapital = workingCapital;
	}
	/**
	 * 获取：营运资金
	 */
	public String getWorkingCapital() {
		return workingCapital;
	}
	/**
	 * 设置：转型日期
	 */
	public void setTransformationDate(String transformationDate) {
		this.transformationDate = transformationDate;
	}
	/**
	 * 获取：转型日期
	 */
	public String getTransformationDate() {
		return transformationDate;
	}
	/**
	 * 设置：经营活动类型
	 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	/**
	 * 获取：经营活动类型
	 */
	public String getBusinessType() {
		return businessType;
	}
	/**
	 * 设置：外国(地区)企业名称
	 */
	public void setForeignEnterpriseName(String foreignEnterpriseName) {
		this.foreignEnterpriseName = foreignEnterpriseName;
	}
	/**
	 * 获取：外国(地区)企业名称
	 */
	public String getForeignEnterpriseName() {
		return foreignEnterpriseName;
	}
	/**
	 * 设置：主管部门
	 */
	public void setCompetentDepartment(String competentDepartment) {
		this.competentDepartment = competentDepartment;
	}
	/**
	 * 获取：主管部门
	 */
	public String getCompetentDepartment() {
		return competentDepartment;
	}
	/**
	 * 设置：国别(地区)
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * 获取：国别(地区)
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * 设置：承包工程或经营管理项目
	 */
	public void setContractProject(String contractProject) {
		this.contractProject = contractProject;
	}
	/**
	 * 获取：承包工程或经营管理项目
	 */
	public String getContractProject() {
		return contractProject;
	}
	/**
	 * 设置：承包工程或经营管理内容
	 */
	public void setContractProjectRemark(String contractProjectRemark) {
		this.contractProjectRemark = contractProjectRemark;
	}
	/**
	 * 获取：承包工程或经营管理内容
	 */
	public String getContractProjectRemark() {
		return contractProjectRemark;
	}
	/**
	 * 设置：境外住所
	 */
	public void setOutsideHouse(String outsideHouse) {
		this.outsideHouse = outsideHouse;
	}
	/**
	 * 获取：境外住所
	 */
	public String getOutsideHouse() {
		return outsideHouse;
	}
	/**
	 * 设置：境外注册资本
	 */
	public void setOverseasRegisteredCapital(String overseasRegisteredCapital) {
		this.overseasRegisteredCapital = overseasRegisteredCapital;
	}
	/**
	 * 获取：境外注册资本
	 */
	public String getOverseasRegisteredCapital() {
		return overseasRegisteredCapital;
	}
	/**
	 * 设置：境外经营范围
	 */
	public void setOverseasBusinessScope(String overseasBusinessScope) {
		this.overseasBusinessScope = overseasBusinessScope;
	}
	/**
	 * 获取：境外经营范围
	 */
	public String getOverseasBusinessScope() {
		return overseasBusinessScope;
	}
	/**
	 * 设置：企业性质
	 */
	public void setEnterpriseNature(String enterpriseNature) {
		this.enterpriseNature = enterpriseNature;
	}
	/**
	 * 获取：企业性质
	 */
	public String getEnterpriseNature() {
		return enterpriseNature;
	}
	/**
	 * 设置：境外主体类型
	 */
	public void setOverseasSubjectType(String overseasSubjectType) {
		this.overseasSubjectType = overseasSubjectType;
	}
	/**
	 * 获取：境外主体类型
	 */
	public String getOverseasSubjectType() {
		return overseasSubjectType;
	}
	/**
	 * 设置：经营类别
	 */
	public void setBusinessCategory(String businessCategory) {
		this.businessCategory = businessCategory;
	}
	/**
	 * 获取：经营类别
	 */
	public String getBusinessCategory() {
		return businessCategory;
	}
	/**
	 * 设置：统一社会信用代码
	 */
	public void setUniformSocialCreditCode(String uniformSocialCreditCode) {
		this.uniformSocialCreditCode = uniformSocialCreditCode;
	}
	/**
	 * 获取：统一社会信用代码
	 */
	public String getUniformSocialCreditCode() {
		return uniformSocialCreditCode;
	}
	/**
	 * 设置：隶属企业统一社会信用代码
	 */
	public void setBelongUniformSocialCreditCode(String belongUniformSocialCreditCode) {
		this.belongUniformSocialCreditCode = belongUniformSocialCreditCode;
	}
	/**
	 * 获取：隶属企业统一社会信用代码
	 */
	public String getBelongUniformSocialCreditCode() {
		return belongUniformSocialCreditCode;
	}
	/**
	 * 设置：主体身份代码
	 */
	public void setPrincipalIdentityCode(String principalIdentityCode) {
		this.principalIdentityCode = principalIdentityCode;
	}
	/**
	 * 获取：主体身份代码
	 */
	public String getPrincipalIdentityCode() {
		return principalIdentityCode;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
