package xin.tianchuang.modules.dataparser.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import xin.tianchuang.modules.dataparser.annotation.EntName;

import java.io.Serializable;
import java.util.Date;

/**
 * 信用中国-黑名单-最高法
 * 
 * @author hui.deng
 * @email 
 * @date 2018-10-16 14:58:55
 */
@TableName("creditchina_black_law")
public class CreditchinaBlackLawEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 数据类别
	 */
	private String type;
	/**
	 * 数据来源
	 */
	private String source;
	/**
	 * 案号
	 */
	private String caseNo;
	/**
	 * 失信被执行人名称
	 */
	@EntName
	private String dishonestName;
	/**
	 * 企业法人姓名
	 */
	private String enterpriseLegal;
	/**
	 * 执行法院
	 */
	private String court;
	/**
	 * 地域名称
	 */
	private String area;
	/**
	 * 执行依据文号
	 */
	private String basisNumber;
	/**
	 * 作出执行依据单位
	 */
	private String executionBasis;
	/**
	 * 法律生效文书确定的义务
	 */
	private String lawDuty;
	/**
	 * 被执行人的履行情况
	 */
	private String performance;
	/**
	 * 失信被执行人具体情形
	 */
	private String situation;
	/**
	 * 发布时间
	 */
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date published;
	/**
	 * 立案时间
	 */
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date filingTime;
	/**
	 * 已履行部分
	 */
	private String fulfilledPart;
	/**
	 * 未履行部分
	 */
	private String unfulfilledPart;
	/**
	 * 最新更新日期
	 */
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date lastUpdateTime;
	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;
	/**
	 * 更新时间
	 */
	@TableField(fill = FieldFill.UPDATE)
	private Date updateTime;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 数据状态
	 */
	@TableField(fill = FieldFill.INSERT)
	private Integer dataStatus;

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
	 * 设置：数据类别
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：数据类别
	 */
	public String getType() {
		return type;
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
	 * 设置：失信被执行人名称
	 */
	public void setDishonestName(String dishonestName) {
		this.dishonestName = dishonestName;
	}
	/**
	 * 获取：失信被执行人名称
	 */
	public String getDishonestName() {
		return dishonestName;
	}
	/**
	 * 设置：企业法人姓名
	 */
	public void setEnterpriseLegal(String enterpriseLegal) {
		this.enterpriseLegal = enterpriseLegal;
	}
	/**
	 * 获取：企业法人姓名
	 */
	public String getEnterpriseLegal() {
		return enterpriseLegal;
	}
	/**
	 * 设置：执行法院
	 */
	public void setCourt(String court) {
		this.court = court;
	}
	/**
	 * 获取：执行法院
	 */
	public String getCourt() {
		return court;
	}
	/**
	 * 设置：地域名称
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * 获取：地域名称
	 */
	public String getArea() {
		return area;
	}
	/**
	 * 设置：执行依据文号
	 */
	public void setBasisNumber(String basisNumber) {
		this.basisNumber = basisNumber;
	}
	/**
	 * 获取：执行依据文号
	 */
	public String getBasisNumber() {
		return basisNumber;
	}
	/**
	 * 设置：作出执行依据单位
	 */
	public void setExecutionBasis(String executionBasis) {
		this.executionBasis = executionBasis;
	}
	/**
	 * 获取：作出执行依据单位
	 */
	public String getExecutionBasis() {
		return executionBasis;
	}
	/**
	 * 设置：法律生效文书确定的义务
	 */
	public void setLawDuty(String lawDuty) {
		this.lawDuty = lawDuty;
	}
	/**
	 * 获取：法律生效文书确定的义务
	 */
	public String getLawDuty() {
		return lawDuty;
	}
	/**
	 * 设置：被执行人的履行情况
	 */
	public void setPerformance(String performance) {
		this.performance = performance;
	}
	/**
	 * 获取：被执行人的履行情况
	 */
	public String getPerformance() {
		return performance;
	}
	/**
	 * 设置：失信被执行人具体情形
	 */
	public void setSituation(String situation) {
		this.situation = situation;
	}
	/**
	 * 获取：失信被执行人具体情形
	 */
	public String getSituation() {
		return situation;
	}
	/**
	 * 设置：发布时间
	 */
	public void setPublished(Date published) {
		this.published = published;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getPublished() {
		return published;
	}
	/**
	 * 设置：立案时间
	 */
	public void setFilingTime(Date filingTime) {
		this.filingTime = filingTime;
	}
	/**
	 * 获取：立案时间
	 */
	public Date getFilingTime() {
		return filingTime;
	}
	/**
	 * 设置：已履行部分
	 */
	public void setFulfilledPart(String fulfilledPart) {
		this.fulfilledPart = fulfilledPart;
	}
	/**
	 * 获取：已履行部分
	 */
	public String getFulfilledPart() {
		return fulfilledPart;
	}
	/**
	 * 设置：未履行部分
	 */
	public void setUnfulfilledPart(String unfulfilledPart) {
		this.unfulfilledPart = unfulfilledPart;
	}
	/**
	 * 获取：未履行部分
	 */
	public String getUnfulfilledPart() {
		return unfulfilledPart;
	}
	/**
	 * 设置：最新更新日期
	 */
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	/**
	 * 获取：最新更新日期
	 */
	public Date getLastUpdateTime() {
		return lastUpdateTime;
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
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
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
	 * 设置：数据状态
	 */
	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}
	/**
	 * 获取：数据状态
	 */
	public Integer getDataStatus() {
		return dataStatus;
	}
}
