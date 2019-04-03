package xin.tianchuang.modules.spider.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * 失信信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:24
 */
@TableName("ent_high_tech_faith_lose")
public class EntHighTechFaithLoseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 
	 */
	private Integer memId;
	/**
	 * 信息名称
	 */
	private String infoName;
	/**
	 * 数据来源
	 */
	private String source;
	/**
	 * 信息类型
	 */
	private String infoType;
	/**
	 * 更新时间，保留原始数据
	 */
	private Date updateTime;
	/**
	 * 
	 */
	private String company;
	/**
	 * 所在市州
	 */
	private String cityState;
	/**
	 * 所在区县
	 */
	private String districtCounty;
	/**
	 * 企业类型
	 */
	private String companyType;
	/**
	 * 评价年份
	 */
	private String evaluationYear;
	/**
	 * 案件名称
	 */
	private String caseName;
	/**
	 * 处罚文件号
	 */
	private String punishNo;
	/**
	 * 行政相对人名称
	 */
	private String executiveRelativeName;
	/**
	 * 法定代表人
	 */
	private String legalPerson;
	/**
	 * 执法部门
	 */
	private String enforcementDept;
	/**
	 * 作出行政处罚的日期
	 */
	private String punishDate;
	/**
	 * 被抽查单位
	 */
	private String checkedCompany;
	/**
	 * 报告编号
	 */
	private String reportId;
	/**
	 * 检品名称
	 */
	private String checkedProductionName;
	/**
	 * 批号或生产日期
	 */
	private String productDate;
	/**
	 * 规格
	 */
	private String specification;
	/**
	 * 标示生产单位
	 */
	private String productCompany;
	/**
	 * 不合格项目
	 */
	private String unPassProject;
	/**
	 * 检验依据
	 */
	private String inspectionStandard;
	/**
	 * 检验结果
	 */
	private String inspectionResult;
	/**
	 * 标准规定
	 */
	private String standardRegulation;
	/**
	 * 检验机构
	 */
	private String inspectionOrganization;
	/**
	 * 检查日期
	 */
	private String checkDate;
	/**
	 * 检查单位
	 */
	private String checkDept;
	/**
	 * 检查内容
	 */
	private String checkContent;
	/**
	 * 不合格内容
	 */
	private String unPassContent;
	/**
	 * 监测点名称
	 */
	private String monitoringPointName;
	/**
	 * 样品名称
	 */
	private String sampleName;
	/**
	 * 抽样编号
	 */
	private String samplingNum;
	/**
	 * 检测部门
	 */
	private String testingDepartment;
	/**
	 * 检测日期
	 */
	private String testDate;
	/**
	 * 产地来源
	 */
	private String originSource;
	/**
	 * 检测结果判断
	 */
	private String testResultJudgment;
	/**
	 * 失信被执行人名称
	 */
	private String brokenFaithPersonName;
	/**
	 * 案号
	 */
	private String caseNo;
	/**
	 * 组织机构代码
	 */
	private String organizationCode;
	/**
	 * 企业法人姓名
	 */
	private String enterpriseLegalPersonName;
	/**
	 * 执行法院
	 */
	private String executionCourt;
	/**
	 * 地域名称
	 */
	private String geographicalName;
	/**
	 * 执行依据文号
	 */
	private String executionReferenceNo;
	/**
	 * 作出执行依据单位
	 */
	private String executionUnit;
	/**
	 * 被执行人的履行情况
	 */
	private String personExecutedPerformance;
	/**
	 * 失信被执行人具体情形
	 */
	private String specificCircumstances;
	/**
	 * 发布时间
	 */
	private String releaseTime;
	/**
	 * 立案时间
	 */
	private String filingTime;
	/**
	 * 已履行部分
	 */
	private String executedPart;
	/**
	 * 未履行部分
	 */
	private String unexecutedPart;
	/**
	 * 评价结果
	 */
	private String evaluationResult;
	/**
	 * 升级结果
	 */
	private String upgradeResult;
	/**
	 * 定级依据
	 */
	private String gradationBasis;
	/**
	 * 处罚（理）日期
	 */
	private String punishmentDate;
	/**
	 * 决定文书号
	 */
	private String documentNum;
	/**
	 * 处罚（理）依据
	 */
	private String punishmentBasis;
	/**
	 * 处罚（理）结果
	 */
	private String punishmentResult;
	/**
	 * 行政区划代码
	 */
	private String areaCode;
	/**
	 * 实施处罚单位名称
	 */
	private String punishmentUnitName;
	/**
	 * 处罚（理）原因
	 */
	private String punishmentReason;
	/**
	 * 企业ID
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long enterpriseId;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setMemId(Integer memId) {
		this.memId = memId;
	}
	/**
	 * 获取：
	 */
	public Integer getMemId() {
		return memId;
	}
	/**
	 * 设置：信息名称
	 */
	public void setInfoName(String infoName) {
		this.infoName = infoName;
	}
	/**
	 * 获取：信息名称
	 */
	public String getInfoName() {
		return infoName;
	}
	/**
	 * 设置：数据来源
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * 获取：数据来源
	 */
	public String getSource() {
		return source;
	}
	/**
	 * 设置：信息类型
	 */
	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}
	/**
	 * 获取：信息类型
	 */
	public String getInfoType() {
		return infoType;
	}
	/**
	 * 设置：更新时间，保留原始数据
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间，保留原始数据
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	/**
	 * 获取：
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * 设置：所在市州
	 */
	public void setCityState(String cityState) {
		this.cityState = cityState;
	}
	/**
	 * 获取：所在市州
	 */
	public String getCityState() {
		return cityState;
	}
	/**
	 * 设置：所在区县
	 */
	public void setDistrictCounty(String districtCounty) {
		this.districtCounty = districtCounty;
	}
	/**
	 * 获取：所在区县
	 */
	public String getDistrictCounty() {
		return districtCounty;
	}
	/**
	 * 设置：企业类型
	 */
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}
	/**
	 * 获取：企业类型
	 */
	public String getCompanyType() {
		return companyType;
	}
	/**
	 * 设置：评价年份
	 */
	public void setEvaluationYear(String evaluationYear) {
		this.evaluationYear = evaluationYear;
	}
	/**
	 * 获取：评价年份
	 */
	public String getEvaluationYear() {
		return evaluationYear;
	}
	/**
	 * 设置：案件名称
	 */
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	/**
	 * 获取：案件名称
	 */
	public String getCaseName() {
		return caseName;
	}
	/**
	 * 设置：处罚文件号
	 */
	public void setPunishNo(String punishNo) {
		this.punishNo = punishNo;
	}
	/**
	 * 获取：处罚文件号
	 */
	public String getPunishNo() {
		return punishNo;
	}
	/**
	 * 设置：行政相对人名称
	 */
	public void setExecutiveRelativeName(String executiveRelativeName) {
		this.executiveRelativeName = executiveRelativeName;
	}
	/**
	 * 获取：行政相对人名称
	 */
	public String getExecutiveRelativeName() {
		return executiveRelativeName;
	}
	/**
	 * 设置：法定代表人
	 */
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}
	/**
	 * 获取：法定代表人
	 */
	public String getLegalPerson() {
		return legalPerson;
	}
	/**
	 * 设置：执法部门
	 */
	public void setEnforcementDept(String enforcementDept) {
		this.enforcementDept = enforcementDept;
	}
	/**
	 * 获取：执法部门
	 */
	public String getEnforcementDept() {
		return enforcementDept;
	}
	/**
	 * 设置：作出行政处罚的日期
	 */
	public void setPunishDate(String punishDate) {
		this.punishDate = punishDate;
	}
	/**
	 * 获取：作出行政处罚的日期
	 */
	public String getPunishDate() {
		return punishDate;
	}
	/**
	 * 设置：被抽查单位
	 */
	public void setCheckedCompany(String checkedCompany) {
		this.checkedCompany = checkedCompany;
	}
	/**
	 * 获取：被抽查单位
	 */
	public String getCheckedCompany() {
		return checkedCompany;
	}
	/**
	 * 设置：报告编号
	 */
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	/**
	 * 获取：报告编号
	 */
	public String getReportId() {
		return reportId;
	}
	/**
	 * 设置：检品名称
	 */
	public void setCheckedProductionName(String checkedProductionName) {
		this.checkedProductionName = checkedProductionName;
	}
	/**
	 * 获取：检品名称
	 */
	public String getCheckedProductionName() {
		return checkedProductionName;
	}
	/**
	 * 设置：批号或生产日期
	 */
	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}
	/**
	 * 获取：批号或生产日期
	 */
	public String getProductDate() {
		return productDate;
	}
	/**
	 * 设置：规格
	 */
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	/**
	 * 获取：规格
	 */
	public String getSpecification() {
		return specification;
	}
	/**
	 * 设置：标示生产单位
	 */
	public void setProductCompany(String productCompany) {
		this.productCompany = productCompany;
	}
	/**
	 * 获取：标示生产单位
	 */
	public String getProductCompany() {
		return productCompany;
	}
	/**
	 * 设置：不合格项目
	 */
	public void setUnPassProject(String unPassProject) {
		this.unPassProject = unPassProject;
	}
	/**
	 * 获取：不合格项目
	 */
	public String getUnPassProject() {
		return unPassProject;
	}
	/**
	 * 设置：检验依据
	 */
	public void setInspectionStandard(String inspectionStandard) {
		this.inspectionStandard = inspectionStandard;
	}
	/**
	 * 获取：检验依据
	 */
	public String getInspectionStandard() {
		return inspectionStandard;
	}
	/**
	 * 设置：检验结果
	 */
	public void setInspectionResult(String inspectionResult) {
		this.inspectionResult = inspectionResult;
	}
	/**
	 * 获取：检验结果
	 */
	public String getInspectionResult() {
		return inspectionResult;
	}
	/**
	 * 设置：标准规定
	 */
	public void setStandardRegulation(String standardRegulation) {
		this.standardRegulation = standardRegulation;
	}
	/**
	 * 获取：标准规定
	 */
	public String getStandardRegulation() {
		return standardRegulation;
	}
	/**
	 * 设置：检验机构
	 */
	public void setInspectionOrganization(String inspectionOrganization) {
		this.inspectionOrganization = inspectionOrganization;
	}
	/**
	 * 获取：检验机构
	 */
	public String getInspectionOrganization() {
		return inspectionOrganization;
	}
	/**
	 * 设置：检查日期
	 */
	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}
	/**
	 * 获取：检查日期
	 */
	public String getCheckDate() {
		return checkDate;
	}
	/**
	 * 设置：检查单位
	 */
	public void setCheckDept(String checkDept) {
		this.checkDept = checkDept;
	}
	/**
	 * 获取：检查单位
	 */
	public String getCheckDept() {
		return checkDept;
	}
	/**
	 * 设置：检查内容
	 */
	public void setCheckContent(String checkContent) {
		this.checkContent = checkContent;
	}
	/**
	 * 获取：检查内容
	 */
	public String getCheckContent() {
		return checkContent;
	}
	/**
	 * 设置：不合格内容
	 */
	public void setUnPassContent(String unPassContent) {
		this.unPassContent = unPassContent;
	}
	/**
	 * 获取：不合格内容
	 */
	public String getUnPassContent() {
		return unPassContent;
	}
	/**
	 * 设置：监测点名称
	 */
	public void setMonitoringPointName(String monitoringPointName) {
		this.monitoringPointName = monitoringPointName;
	}
	/**
	 * 获取：监测点名称
	 */
	public String getMonitoringPointName() {
		return monitoringPointName;
	}
	/**
	 * 设置：样品名称
	 */
	public void setSampleName(String sampleName) {
		this.sampleName = sampleName;
	}
	/**
	 * 获取：样品名称
	 */
	public String getSampleName() {
		return sampleName;
	}
	/**
	 * 设置：抽样编号
	 */
	public void setSamplingNum(String samplingNum) {
		this.samplingNum = samplingNum;
	}
	/**
	 * 获取：抽样编号
	 */
	public String getSamplingNum() {
		return samplingNum;
	}
	/**
	 * 设置：检测部门
	 */
	public void setTestingDepartment(String testingDepartment) {
		this.testingDepartment = testingDepartment;
	}
	/**
	 * 获取：检测部门
	 */
	public String getTestingDepartment() {
		return testingDepartment;
	}
	/**
	 * 设置：检测日期
	 */
	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}
	/**
	 * 获取：检测日期
	 */
	public String getTestDate() {
		return testDate;
	}
	/**
	 * 设置：产地来源
	 */
	public void setOriginSource(String originSource) {
		this.originSource = originSource;
	}
	/**
	 * 获取：产地来源
	 */
	public String getOriginSource() {
		return originSource;
	}
	/**
	 * 设置：检测结果判断
	 */
	public void setTestResultJudgment(String testResultJudgment) {
		this.testResultJudgment = testResultJudgment;
	}
	/**
	 * 获取：检测结果判断
	 */
	public String getTestResultJudgment() {
		return testResultJudgment;
	}
	/**
	 * 设置：失信被执行人名称
	 */
	public void setBrokenFaithPersonName(String brokenFaithPersonName) {
		this.brokenFaithPersonName = brokenFaithPersonName;
	}
	/**
	 * 获取：失信被执行人名称
	 */
	public String getBrokenFaithPersonName() {
		return brokenFaithPersonName;
	}
	/**
	 * 设置：案号
	 */
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}
	/**
	 * 获取：案号
	 */
	public String getCaseNo() {
		return caseNo;
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
	 * 设置：企业法人姓名
	 */
	public void setEnterpriseLegalPersonName(String enterpriseLegalPersonName) {
		this.enterpriseLegalPersonName = enterpriseLegalPersonName;
	}
	/**
	 * 获取：企业法人姓名
	 */
	public String getEnterpriseLegalPersonName() {
		return enterpriseLegalPersonName;
	}
	/**
	 * 设置：执行法院
	 */
	public void setExecutionCourt(String executionCourt) {
		this.executionCourt = executionCourt;
	}
	/**
	 * 获取：执行法院
	 */
	public String getExecutionCourt() {
		return executionCourt;
	}
	/**
	 * 设置：地域名称
	 */
	public void setGeographicalName(String geographicalName) {
		this.geographicalName = geographicalName;
	}
	/**
	 * 获取：地域名称
	 */
	public String getGeographicalName() {
		return geographicalName;
	}
	/**
	 * 设置：执行依据文号
	 */
	public void setExecutionReferenceNo(String executionReferenceNo) {
		this.executionReferenceNo = executionReferenceNo;
	}
	/**
	 * 获取：执行依据文号
	 */
	public String getExecutionReferenceNo() {
		return executionReferenceNo;
	}
	/**
	 * 设置：作出执行依据单位
	 */
	public void setExecutionUnit(String executionUnit) {
		this.executionUnit = executionUnit;
	}
	/**
	 * 获取：作出执行依据单位
	 */
	public String getExecutionUnit() {
		return executionUnit;
	}
	/**
	 * 设置：被执行人的履行情况
	 */
	public void setPersonExecutedPerformance(String personExecutedPerformance) {
		this.personExecutedPerformance = personExecutedPerformance;
	}
	/**
	 * 获取：被执行人的履行情况
	 */
	public String getPersonExecutedPerformance() {
		return personExecutedPerformance;
	}
	/**
	 * 设置：失信被执行人具体情形
	 */
	public void setSpecificCircumstances(String specificCircumstances) {
		this.specificCircumstances = specificCircumstances;
	}
	/**
	 * 获取：失信被执行人具体情形
	 */
	public String getSpecificCircumstances() {
		return specificCircumstances;
	}
	/**
	 * 设置：发布时间
	 */
	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}
	/**
	 * 获取：发布时间
	 */
	public String getReleaseTime() {
		return releaseTime;
	}
	/**
	 * 设置：立案时间
	 */
	public void setFilingTime(String filingTime) {
		this.filingTime = filingTime;
	}
	/**
	 * 获取：立案时间
	 */
	public String getFilingTime() {
		return filingTime;
	}
	/**
	 * 设置：已履行部分
	 */
	public void setExecutedPart(String executedPart) {
		this.executedPart = executedPart;
	}
	/**
	 * 获取：已履行部分
	 */
	public String getExecutedPart() {
		return executedPart;
	}
	/**
	 * 设置：未履行部分
	 */
	public void setUnexecutedPart(String unexecutedPart) {
		this.unexecutedPart = unexecutedPart;
	}
	/**
	 * 获取：未履行部分
	 */
	public String getUnexecutedPart() {
		return unexecutedPart;
	}
	/**
	 * 设置：评价结果
	 */
	public void setEvaluationResult(String evaluationResult) {
		this.evaluationResult = evaluationResult;
	}
	/**
	 * 获取：评价结果
	 */
	public String getEvaluationResult() {
		return evaluationResult;
	}
	/**
	 * 设置：升级结果
	 */
	public void setUpgradeResult(String upgradeResult) {
		this.upgradeResult = upgradeResult;
	}
	/**
	 * 获取：升级结果
	 */
	public String getUpgradeResult() {
		return upgradeResult;
	}
	/**
	 * 设置：定级依据
	 */
	public void setGradationBasis(String gradationBasis) {
		this.gradationBasis = gradationBasis;
	}
	/**
	 * 获取：定级依据
	 */
	public String getGradationBasis() {
		return gradationBasis;
	}
	/**
	 * 设置：处罚（理）日期
	 */
	public void setPunishmentDate(String punishmentDate) {
		this.punishmentDate = punishmentDate;
	}
	/**
	 * 获取：处罚（理）日期
	 */
	public String getPunishmentDate() {
		return punishmentDate;
	}
	/**
	 * 设置：决定文书号
	 */
	public void setDocumentNum(String documentNum) {
		this.documentNum = documentNum;
	}
	/**
	 * 获取：决定文书号
	 */
	public String getDocumentNum() {
		return documentNum;
	}
	/**
	 * 设置：处罚（理）依据
	 */
	public void setPunishmentBasis(String punishmentBasis) {
		this.punishmentBasis = punishmentBasis;
	}
	/**
	 * 获取：处罚（理）依据
	 */
	public String getPunishmentBasis() {
		return punishmentBasis;
	}
	/**
	 * 设置：处罚（理）结果
	 */
	public void setPunishmentResult(String punishmentResult) {
		this.punishmentResult = punishmentResult;
	}
	/**
	 * 获取：处罚（理）结果
	 */
	public String getPunishmentResult() {
		return punishmentResult;
	}
	/**
	 * 设置：行政区划代码
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	/**
	 * 获取：行政区划代码
	 */
	public String getAreaCode() {
		return areaCode;
	}
	/**
	 * 设置：实施处罚单位名称
	 */
	public void setPunishmentUnitName(String punishmentUnitName) {
		this.punishmentUnitName = punishmentUnitName;
	}
	/**
	 * 获取：实施处罚单位名称
	 */
	public String getPunishmentUnitName() {
		return punishmentUnitName;
	}
	/**
	 * 设置：处罚（理）原因
	 */
	public void setPunishmentReason(String punishmentReason) {
		this.punishmentReason = punishmentReason;
	}
	/**
	 * 获取：处罚（理）原因
	 */
	public String getPunishmentReason() {
		return punishmentReason;
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
}
