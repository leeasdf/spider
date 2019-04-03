package xin.tianchuang.modules.spider.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 行政处罚信息(导入)
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:23
 */
@TableName("ori_administrative_penalty")
public class OriAdministrativePenaltyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 序号
	 */
	private String no;
	/**
	 * 污染源编号
	 */
	private String pollutionSourceNumber;
	/**
	 * 污染源名称
	 */
	private String pollutionSourceName;
	/**
	 * 年度
	 */
	private Integer year;
	/**
	 * 处罚主体
	 */
	private String enterpriseName;
	/**
	 * 调查机构
	 */
	private String investigationOrganization;
	/**
	 * 立案号
	 */
	private String caseNumber;
	/**
	 * 决定书文号
	 */
	private String decisionDocument;
	/**
	 * 立案日期
	 */
	private String caseDate;
	/**
	 * 案情简介
	 */
	private String caseIntroduction;
	/**
	 * 主要违法行为
	 */
	private String majorViolations;
	/**
	 * 处罚依据
	 */
	private String punishmentBasis;
	/**
	 * 处罚种类
	 */
	private String punishmentType;
	/**
	 * 罚款数额（万元）
	 */
	private String fineFee;
	/**
	 * 行政命令种类
	 */
	private String administrativeDecree;
	/**
	 * 是否举行听证
	 */
	private String isHearing;
	/**
	 * 决定下达日期
	 */
	private String decideDate;
	/**
	 * 决定书内容
	 */
	private String decideContent;
	/**
	 * 执行情况
	 */
	private String implementation;
	/**
	 * 执行完毕日期
	 */
	private String executionDate;
	/**
	 * 复议结果
	 */
	private String reconsiderationResult;
	/**
	 * 诉讼结果
	 */
	private String lawsuitResult;
	/**
	 * 移送信息
	 */
	private String transferInformation;
	/**
	 * 结案日期
	 */
	private String closeDate;
	/**
	 * 是否结案N：未结案 Y：已结案
	 */
	private String isClose;
	/**
	 * 案卷号
	 */
	private String fileNumber;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 修改时间
	 */
	private String updateTine;
	/**
	 * 数据来源
	 */
	private String resource;
	/**
	 * 状态0：新增 1：修改 2：删除
	 */
	private String status;
	/**
	 * 是否已交换N：未交换 Y：已交换
	 */
	private String exchangeStatus;
	/**
	 * 审核状态
	 */
	private String examineStatus;
	/**
	 * 统一社会信用代码
	 */
	private String creditCode;
	/**
	 * 作出决定的相关材料
	 */
	private String relatedMaterials;
	/**
	 * 违法案件类型
	 */
	private String casesType;
	/**
	 * 更新时间戳
	 */
	private String timestamp;

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
	 * 设置：序号
	 */
	public void setNo(String no) {
		this.no = no;
	}
	/**
	 * 获取：序号
	 */
	public String getNo() {
		return no;
	}
	/**
	 * 设置：污染源编号
	 */
	public void setPollutionSourceNumber(String pollutionSourceNumber) {
		this.pollutionSourceNumber = pollutionSourceNumber;
	}
	/**
	 * 获取：污染源编号
	 */
	public String getPollutionSourceNumber() {
		return pollutionSourceNumber;
	}
	/**
	 * 设置：污染源名称
	 */
	public void setPollutionSourceName(String pollutionSourceName) {
		this.pollutionSourceName = pollutionSourceName;
	}
	/**
	 * 获取：污染源名称
	 */
	public String getPollutionSourceName() {
		return pollutionSourceName;
	}
	/**
	 * 设置：年度
	 */
	public void setYear(Integer year) {
		this.year = year;
	}
	/**
	 * 获取：年度
	 */
	public Integer getYear() {
		return year;
	}
	/**
	 * 设置：处罚主体
	 */
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	/**
	 * 获取：处罚主体
	 */
	public String getEnterpriseName() {
		return enterpriseName;
	}
	/**
	 * 设置：调查机构
	 */
	public void setInvestigationOrganization(String investigationOrganization) {
		this.investigationOrganization = investigationOrganization;
	}
	/**
	 * 获取：调查机构
	 */
	public String getInvestigationOrganization() {
		return investigationOrganization;
	}
	/**
	 * 设置：立案号
	 */
	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}
	/**
	 * 获取：立案号
	 */
	public String getCaseNumber() {
		return caseNumber;
	}
	/**
	 * 设置：决定书文号
	 */
	public void setDecisionDocument(String decisionDocument) {
		this.decisionDocument = decisionDocument;
	}
	/**
	 * 获取：决定书文号
	 */
	public String getDecisionDocument() {
		return decisionDocument;
	}
	/**
	 * 设置：立案日期
	 */
	public void setCaseDate(String caseDate) {
		this.caseDate = caseDate;
	}
	/**
	 * 获取：立案日期
	 */
	public String getCaseDate() {
		return caseDate;
	}
	/**
	 * 设置：案情简介
	 */
	public void setCaseIntroduction(String caseIntroduction) {
		this.caseIntroduction = caseIntroduction;
	}
	/**
	 * 获取：案情简介
	 */
	public String getCaseIntroduction() {
		return caseIntroduction;
	}
	/**
	 * 设置：主要违法行为
	 */
	public void setMajorViolations(String majorViolations) {
		this.majorViolations = majorViolations;
	}
	/**
	 * 获取：主要违法行为
	 */
	public String getMajorViolations() {
		return majorViolations;
	}
	/**
	 * 设置：处罚依据
	 */
	public void setPunishmentBasis(String punishmentBasis) {
		this.punishmentBasis = punishmentBasis;
	}
	/**
	 * 获取：处罚依据
	 */
	public String getPunishmentBasis() {
		return punishmentBasis;
	}
	/**
	 * 设置：处罚种类
	 */
	public void setPunishmentType(String punishmentType) {
		this.punishmentType = punishmentType;
	}
	/**
	 * 获取：处罚种类
	 */
	public String getPunishmentType() {
		return punishmentType;
	}
	/**
	 * 设置：罚款数额（万元）
	 */
	public void setFineFee(String fineFee) {
		this.fineFee = fineFee;
	}
	/**
	 * 获取：罚款数额（万元）
	 */
	public String getFineFee() {
		return fineFee;
	}
	/**
	 * 设置：行政命令种类
	 */
	public void setAdministrativeDecree(String administrativeDecree) {
		this.administrativeDecree = administrativeDecree;
	}
	/**
	 * 获取：行政命令种类
	 */
	public String getAdministrativeDecree() {
		return administrativeDecree;
	}
	/**
	 * 设置：是否举行听证
	 */
	public void setIsHearing(String isHearing) {
		this.isHearing = isHearing;
	}
	/**
	 * 获取：是否举行听证
	 */
	public String getIsHearing() {
		return isHearing;
	}
	/**
	 * 设置：决定下达日期
	 */
	public void setDecideDate(String decideDate) {
		this.decideDate = decideDate;
	}
	/**
	 * 获取：决定下达日期
	 */
	public String getDecideDate() {
		return decideDate;
	}
	/**
	 * 设置：决定书内容
	 */
	public void setDecideContent(String decideContent) {
		this.decideContent = decideContent;
	}
	/**
	 * 获取：决定书内容
	 */
	public String getDecideContent() {
		return decideContent;
	}
	/**
	 * 设置：执行情况
	 */
	public void setImplementation(String implementation) {
		this.implementation = implementation;
	}
	/**
	 * 获取：执行情况
	 */
	public String getImplementation() {
		return implementation;
	}
	/**
	 * 设置：执行完毕日期
	 */
	public void setExecutionDate(String executionDate) {
		this.executionDate = executionDate;
	}
	/**
	 * 获取：执行完毕日期
	 */
	public String getExecutionDate() {
		return executionDate;
	}
	/**
	 * 设置：复议结果
	 */
	public void setReconsiderationResult(String reconsiderationResult) {
		this.reconsiderationResult = reconsiderationResult;
	}
	/**
	 * 获取：复议结果
	 */
	public String getReconsiderationResult() {
		return reconsiderationResult;
	}
	/**
	 * 设置：诉讼结果
	 */
	public void setLawsuitResult(String lawsuitResult) {
		this.lawsuitResult = lawsuitResult;
	}
	/**
	 * 获取：诉讼结果
	 */
	public String getLawsuitResult() {
		return lawsuitResult;
	}
	/**
	 * 设置：移送信息
	 */
	public void setTransferInformation(String transferInformation) {
		this.transferInformation = transferInformation;
	}
	/**
	 * 获取：移送信息
	 */
	public String getTransferInformation() {
		return transferInformation;
	}
	/**
	 * 设置：结案日期
	 */
	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}
	/**
	 * 获取：结案日期
	 */
	public String getCloseDate() {
		return closeDate;
	}
	/**
	 * 设置：是否结案N：未结案 Y：已结案
	 */
	public void setIsClose(String isClose) {
		this.isClose = isClose;
	}
	/**
	 * 获取：是否结案N：未结案 Y：已结案
	 */
	public String getIsClose() {
		return isClose;
	}
	/**
	 * 设置：案卷号
	 */
	public void setFileNumber(String fileNumber) {
		this.fileNumber = fileNumber;
	}
	/**
	 * 获取：案卷号
	 */
	public String getFileNumber() {
		return fileNumber;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public String getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateTine(String updateTine) {
		this.updateTine = updateTine;
	}
	/**
	 * 获取：修改时间
	 */
	public String getUpdateTine() {
		return updateTine;
	}
	/**
	 * 设置：数据来源
	 */
	public void setResource(String resource) {
		this.resource = resource;
	}
	/**
	 * 获取：数据来源
	 */
	public String getResource() {
		return resource;
	}
	/**
	 * 设置：状态0：新增 1：修改 2：删除
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态0：新增 1：修改 2：删除
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：是否已交换N：未交换 Y：已交换
	 */
	public void setExchangeStatus(String exchangeStatus) {
		this.exchangeStatus = exchangeStatus;
	}
	/**
	 * 获取：是否已交换N：未交换 Y：已交换
	 */
	public String getExchangeStatus() {
		return exchangeStatus;
	}
	/**
	 * 设置：审核状态
	 */
	public void setExamineStatus(String examineStatus) {
		this.examineStatus = examineStatus;
	}
	/**
	 * 获取：审核状态
	 */
	public String getExamineStatus() {
		return examineStatus;
	}
	/**
	 * 设置：统一社会信用代码
	 */
	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}
	/**
	 * 获取：统一社会信用代码
	 */
	public String getCreditCode() {
		return creditCode;
	}
	/**
	 * 设置：作出决定的相关材料
	 */
	public void setRelatedMaterials(String relatedMaterials) {
		this.relatedMaterials = relatedMaterials;
	}
	/**
	 * 获取：作出决定的相关材料
	 */
	public String getRelatedMaterials() {
		return relatedMaterials;
	}
	/**
	 * 设置：违法案件类型
	 */
	public void setCasesType(String casesType) {
		this.casesType = casesType;
	}
	/**
	 * 获取：违法案件类型
	 */
	public String getCasesType() {
		return casesType;
	}
	/**
	 * 设置：更新时间戳
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * 获取：更新时间戳
	 */
	public String getTimestamp() {
		return timestamp;
	}
}
