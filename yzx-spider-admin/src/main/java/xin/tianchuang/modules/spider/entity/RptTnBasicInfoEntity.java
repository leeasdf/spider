package xin.tianchuang.modules.spider.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.Version;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * 工商基本信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:22
 */
@TableName("rpt_tn_basic_info")
public class RptTnBasicInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 企业主键
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long enterpriseId;

	/**
	 * 企业名称
	 */
	private String entName;
	// 公司
	/**
	 * 工商注册号
	 */
	private String regNo;
	/**
	 * 企业类别/公司类型
	 */
	private String entType;
	/**
	 * 行业
	 */
	private String industryPhyName;
	/**
	 * 纳税人识别号
	 */
	private String ideNum;
	/**
	 * 统一社会信用代码
	 */
	private String creCode;
	/**
	 * 英文名称
	 */
	private String engName;
	/**
	 * 组织机构代码
	 */
	private String orgCode;
	/**
	 * 登记机关
	 */
	private String regAuthority;
	/**
	 * 营业期限
	 */
	private String opePeriod;
	/**
	 * 核准日期
	 */
	private String appDate;
	/**
	 * 注册地址
	 */
	private String regAddress;
	/**
	 * 经营范围
	 */
	private String busScope;
	/**
	 * 公司名称
	 */
	private String cmpName;
	/**
	 * 注册时间
	 */
	private String regTime;
	/**
	 * 法人
	 */
	private String legalPerson;
	/**
	 * 注册资本
	 */
	private String regCap;
	/**
	 * 企业状态
	 */
	private String status;

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

	/**
	 * 创建人ID
	 */
	private Integer creator;
	/**
	 * 创建时间
	 */
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;
	/**
	 * 修改人ID
	 */
	private Integer updater;
	/**
	 * 修改时间
	 */
	@TableField(value = "update_time", fill = FieldFill.UPDATE)
	private Date updateTime;
	/**
	 * 数据状态：1-正常 0-删除
	 */
	@TableField(value = "data_state", fill = FieldFill.INSERT)
	private Integer dataState;
	/**
	 * 版本号
	 */
	@Version
	private Integer version;

	/**
	 * 人员规模
	 */
	private String staffNum;
	/**
	 * 标签列表
	 */
	private String tagList;

	/**
	 * 实缴资本
	 */
	private String paidCap;
	/**
	 * 参保人数
	 */
	private String insureNum;

	/**
	 * 标签类别
	 */
	private String tagType;

	/**
	 * 纳税人资质
	 */
	private String taxType;

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
	 * 设置：企业主键
	 */
	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	/**
	 * 获取：企业主键
	 */
	public Long getEnterpriseId() {
		return enterpriseId;
	}

	/**
	 * 设置：企业名称
	 */
	public void setEntName(String entName) {
		this.entName = entName;
	}

	/**
	 * 获取：企业名称
	 */
	public String getEntName() {
		return entName;
	}

	/**
	 * 设置：工商注册号
	 */
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	/**
	 * 获取：工商注册号
	 */
	public String getRegNo() {
		return regNo;
	}

	/**
	 * 设置：企业类别
	 */
	public void setEntType(String entType) {
		this.entType = entType;
	}

	/**
	 * 获取：企业类别
	 */
	public String getEntType() {
		return entType;
	}

	/**
	 * 设置：行业
	 */
	public void setIndustryPhyName(String industryPhyName) {
		this.industryPhyName = industryPhyName;
	}

	/**
	 * 获取：行业
	 */
	public String getIndustryPhyName() {
		return industryPhyName;
	}

	/**
	 * 设置：纳税人识别号
	 */
	public void setIdeNum(String ideNum) {
		this.ideNum = ideNum;
	}

	/**
	 * 获取：纳税人识别号
	 */
	public String getIdeNum() {
		return ideNum;
	}

	/**
	 * 设置：统一社会信用代码
	 */
	public void setCreCode(String creCode) {
		this.creCode = creCode;
	}

	/**
	 * 获取：统一社会信用代码
	 */
	public String getCreCode() {
		return creCode;
	}

	/**
	 * 设置：英文名称
	 */
	public void setEngName(String engName) {
		this.engName = engName;
	}

	/**
	 * 获取：英文名称
	 */
	public String getEngName() {
		return engName;
	}

	/**
	 * 设置：组织机构代码
	 */
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	/**
	 * 获取：组织机构代码
	 */
	public String getOrgCode() {
		return orgCode;
	}

	/**
	 * 设置：登记机关
	 */
	public void setRegAuthority(String regAuthority) {
		this.regAuthority = regAuthority;
	}

	/**
	 * 获取：登记机关
	 */
	public String getRegAuthority() {
		return regAuthority;
	}

	/**
	 * 设置：营业期限
	 */
	public void setOpePeriod(String opePeriod) {
		this.opePeriod = opePeriod;
	}

	/**
	 * 获取：营业期限
	 */
	public String getOpePeriod() {
		return opePeriod;
	}

	/**
	 * 设置：核准日期
	 */
	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}

	/**
	 * 获取：核准日期
	 */
	public String getAppDate() {
		return appDate;
	}

	/**
	 * 设置：注册地址
	 */
	public void setRegAddress(String regAddress) {
		this.regAddress = regAddress;
	}

	/**
	 * 获取：注册地址
	 */
	public String getRegAddress() {
		return regAddress;
	}

	/**
	 * 设置：经营范围
	 */
	public void setBusScope(String busScope) {
		this.busScope = busScope;
	}

	/**
	 * 获取：经营范围
	 */
	public String getBusScope() {
		return busScope;
	}

	/**
	 * 设置：公司名称
	 */
	public void setCmpName(String cmpName) {
		this.cmpName = cmpName;
	}

	/**
	 * 获取：公司名称
	 */
	public String getCmpName() {
		return cmpName;
	}

	/**
	 * 设置：注册时间
	 */
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}

	/**
	 * 获取：注册时间
	 */
	public String getRegTime() {
		return regTime;
	}

	/**
	 * 设置：法人
	 */
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	/**
	 * 获取：法人
	 */
	public String getLegalPerson() {
		return legalPerson;
	}

	/**
	 * 设置：注册资本
	 */
	public void setRegCap(String regCap) {
		this.regCap = regCap;
	}

	/**
	 * 获取：注册资本
	 */
	public String getRegCap() {
		return regCap;
	}

	/**
	 * 设置：企业状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 获取：企业状态
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 设置：创建人ID
	 */
	public void setCreator(Integer creator) {
		this.creator = creator;
	}

	/**
	 * 获取：创建人ID
	 */
	public Integer getCreator() {
		return creator;
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

	/**
	 * 设置：修改人ID
	 */
	public void setUpdater(Integer updater) {
		this.updater = updater;
	}

	/**
	 * 获取：修改人ID
	 */
	public Integer getUpdater() {
		return updater;
	}

	/**
	 * 设置：修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 获取：修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * 设置：数据状态：1-正常 0-删除
	 */
	public void setDataState(Integer dataState) {
		this.dataState = dataState;
	}

	/**
	 * 获取：数据状态：1-正常 0-删除
	 */
	public Integer getDataState() {
		return dataState;
	}

	/**
	 * 设置：版本号
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * 获取：版本号
	 */
	public Integer getVersion() {
		return version;
	}

	public String getStaffNum() {
		return staffNum;
	}

	public void setStaffNum(String staffNum) {
		this.staffNum = staffNum;
	}

	public String getTagList() {
		return tagList;
	}

	public void setTagList(String tagList) {
		this.tagList = tagList;
	}

	public String getPaidCap() {
		return paidCap;
	}

	public void setPaidCap(String paidCap) {
		this.paidCap = paidCap;
	}

	public String getInsureNum() {
		return insureNum;
	}

	public void setInsureNum(String insureNum) {
		this.insureNum = insureNum;
	}

	public String getTagType() {
		return tagType;
	}

	public void setTagType(String tagType) {
		this.tagType = tagType;
	}

	public String getTaxType() {
		return taxType;
	}

	public void setTaxType(String taxType) {
		this.taxType = taxType;
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
