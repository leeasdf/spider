package xin.tianchuang.modules.spider.bean.tyc.result;

import java.io.Serializable;

public class BusinessResultDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8184182757684739244L;
	// 1、公司
	private String regNo; // 公司注册号 -登记证号 -公司编号
	private String industryPhyName; // 行业
	private String ideNum; // 纳税人识别号 - 税务登记号
	private String creCode; // 统一信用代码
	private String regAuthority; // 登记机关 -登记管理机关
	private String opePeriod; // 营业期限
	private String cmpName; // 公司名称
	private String appDate; // 核准日期 - 批准日期
	private String staffNum; // 人员规模
	private String entType; // 公司类型 -社会组织类型
	private String paidCap; // 实缴资本
	private String insureNum; // 参保人数
	private String regTime; // 注册时间
	private String engName; // 英文名称
	private String orgCode; // 组织机构代码
	private String legalPerson; // 法人姓名 - 律所负责人
	private String regCap; // 注册资本 -资本总额（新台币）
	private String regAddress; // 注册地址
	private String busScope; // 经营范围 -宗旨和业务范围 -所营事业资料
	private String taxType; // 纳税人资质
	private String status; // 公司状态 - 执业状态 -公司现状
	// 社会组织
	private String manageUnit; // 业务主管单位
	private String bizType; // 业务类型
	// 律所
	private String approveNo; // 执业许可证号
	private String creditRating; // 信用等级
	private String certTime; // 发证日期
	private String bizExpertise; // 业务特长
	// 香港企业
	private String regInfo; // 押计登记册
	private String cancleDate; // 已告解散日期
	private String cleanMode; // 清盘模式
	private String importEvent; // 重要事项
	// 事业单位
	private String effectiveDate; // 有效期
	private String oriCertNo; // 原证书号
	private String feeSource; // 经费来源
	private String publishUnit; // 举办单位
	// 基金会
	private String oriAmount; // 原始基金数额
	private String chairman; // 理事长
	private String secretaryGeneral; // 秘书长
	private String contactName; // 对外联系人姓名
	private String contactLevel; // 联系人职务
	private String telephone; // 联系人固话
	private String fax; // 联系人传真
	private String email; // 联系人电子邮箱
	private String countryPersonNo; // 负责人中国家工作人员数
	private String domain; // 关注领域
	private String provincePersonNo; // 负责人中担任过省部级工作人员数
	private String dataSource; // 数据来源
	private String allPersonNo; // 全职员工数量
	private String fundsRange; // 基金会范围
	private String volunteerCount; // 志愿者数量
	private String assessRegister; // 评估登记
	private String specialFundsNo; // 专项基金数
	private String preferentialType; // 优惠资格类型
	private String postalCode; // 邮政编码
	private String purpose; // 宗旨
	// 台湾企业
	private String lastAppDate; // 最后核准变更日期

	private String tagList;
	private String tagType; // 标签类型 entityType ==1 公司 ，2香港，3社会组织，4律所 5事业单位 6基金会 8台湾

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setIndustryPhyName(String industryPhyName) {
		this.industryPhyName = industryPhyName;
	}

	public String getIndustryPhyName() {
		return industryPhyName;
	}

	public void setIdeNum(String ideNum) {
		this.ideNum = ideNum;
	}

	public String getIdeNum() {
		return ideNum;
	}

	public void setCreCode(String creCode) {
		this.creCode = creCode;
	}

	public String getCreCode() {
		return creCode;
	}

	public void setRegAuthority(String regAuthority) {
		this.regAuthority = regAuthority;
	}

	public String getRegAuthority() {
		return regAuthority;
	}

	public void setOpePeriod(String opePeriod) {
		this.opePeriod = opePeriod;
	}

	public String getOpePeriod() {
		return opePeriod;
	}

	public void setCmpName(String cmpName) {
		this.cmpName = cmpName;
	}

	public String getCmpName() {
		return cmpName;
	}

	public void setStaffNum(String staffNum) {
		this.staffNum = staffNum;
	}

	public String getStaffNum() {
		return staffNum;
	}

	public void setTagList(String tagList) {
		this.tagList = tagList;
	}

	public String getTagList() {
		return tagList;
	}

	public void setEntType(String entType) {
		this.entType = entType;
	}

	public String getEntType() {
		return entType;
	}

	public void setPaidCap(String paidCap) {
		this.paidCap = paidCap;
	}

	public String getPaidCap() {
		return paidCap;
	}

	public void setInsureNum(String insureNum) {
		this.insureNum = insureNum;
	}

	public String getInsureNum() {
		return insureNum;
	}

	public void setEngName(String engName) {
		this.engName = engName;
	}

	public String getEngName() {
		return engName;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setTagType(String tagType) {
		this.tagType = tagType;
	}

	public String getTagType() {
		return tagType;
	}

	public void setRegCap(String regCap) {
		this.regCap = regCap;
	}

	public String getRegCap() {
		return regCap;
	}

	public void setRegAddress(String regAddress) {
		this.regAddress = regAddress;
	}

	public String getRegAddress() {
		return regAddress;
	}

	public void setBusScope(String busScope) {
		this.busScope = busScope;
	}

	public String getBusScope() {
		return busScope;
	}

	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}

	public String getTaxType() {
		return taxType;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public String getAppDate() {
		return appDate;
	}

	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}

	public String getRegTime() {
		return regTime;
	}

	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}

	public String getManageUnit() {
		return manageUnit;
	}

	public void setManageUnit(String manageUnit) {
		this.manageUnit = manageUnit;
	}

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public String getApproveNo() {
		return approveNo;
	}

	public void setApproveNo(String approveNo) {
		this.approveNo = approveNo;
	}

	public String getCreditRating() {
		return creditRating;
	}

	public void setCreditRating(String creditRating) {
		this.creditRating = creditRating;
	}

	public String getCertTime() {
		return certTime;
	}

	public void setCertTime(String certTime) {
		this.certTime = certTime;
	}

	public String getBizExpertise() {
		return bizExpertise;
	}

	public void setBizExpertise(String bizExpertise) {
		this.bizExpertise = bizExpertise;
	}

	public String getRegInfo() {
		return regInfo;
	}

	public void setRegInfo(String regInfo) {
		this.regInfo = regInfo;
	}

	public String getCancleDate() {
		return cancleDate;
	}

	public void setCancleDate(String cancleDate) {
		this.cancleDate = cancleDate;
	}

	public String getCleanMode() {
		return cleanMode;
	}

	public void setCleanMode(String cleanMode) {
		this.cleanMode = cleanMode;
	}

	public String getImportEvent() {
		return importEvent;
	}

	public void setImportEvent(String importEvent) {
		this.importEvent = importEvent;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getOriCertNo() {
		return oriCertNo;
	}

	public void setOriCertNo(String oriCertNo) {
		this.oriCertNo = oriCertNo;
	}

	public String getFeeSource() {
		return feeSource;
	}

	public void setFeeSource(String feeSource) {
		this.feeSource = feeSource;
	}

	public String getPublishUnit() {
		return publishUnit;
	}

	public void setPublishUnit(String publishUnit) {
		this.publishUnit = publishUnit;
	}

	public String getOriAmount() {
		return oriAmount;
	}

	public void setOriAmount(String oriAmount) {
		this.oriAmount = oriAmount;
	}

	public String getChairman() {
		return chairman;
	}

	public void setChairman(String chairman) {
		this.chairman = chairman;
	}

	public String getSecretaryGeneral() {
		return secretaryGeneral;
	}

	public void setSecretaryGeneral(String secretaryGeneral) {
		this.secretaryGeneral = secretaryGeneral;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactLevel() {
		return contactLevel;
	}

	public void setContactLevel(String contactLevel) {
		this.contactLevel = contactLevel;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountryPersonNo() {
		return countryPersonNo;
	}

	public void setCountryPersonNo(String countryPersonNo) {
		this.countryPersonNo = countryPersonNo;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getProvincePersonNo() {
		return provincePersonNo;
	}

	public void setProvincePersonNo(String provincePersonNo) {
		this.provincePersonNo = provincePersonNo;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getAllPersonNo() {
		return allPersonNo;
	}

	public void setAllPersonNo(String allPersonNo) {
		this.allPersonNo = allPersonNo;
	}

	public String getFundsRange() {
		return fundsRange;
	}

	public void setFundsRange(String fundsRange) {
		this.fundsRange = fundsRange;
	}

	public String getVolunteerCount() {
		return volunteerCount;
	}

	public void setVolunteerCount(String volunteerCount) {
		this.volunteerCount = volunteerCount;
	}

	public String getAssessRegister() {
		return assessRegister;
	}

	public void setAssessRegister(String assessRegister) {
		this.assessRegister = assessRegister;
	}

	public String getSpecialFundsNo() {
		return specialFundsNo;
	}

	public void setSpecialFundsNo(String specialFundsNo) {
		this.specialFundsNo = specialFundsNo;
	}

	public String getPreferentialType() {
		return preferentialType;
	}

	public void setPreferentialType(String preferentialType) {
		this.preferentialType = preferentialType;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getLastAppDate() {
		return lastAppDate;
	}

	public void setLastAppDate(String lastAppDate) {
		this.lastAppDate = lastAppDate;
	}

}
