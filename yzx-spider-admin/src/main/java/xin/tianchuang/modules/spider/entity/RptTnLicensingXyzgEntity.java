package xin.tianchuang.modules.spider.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * 企业-行政处罚[信用中国]
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:21
 */
@TableName("rpt_tn_licensing_xyzg")
public class RptTnLicensingXyzgEntity implements Serializable {
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
	/**
	 * 有效时间
	 */
	private String validityTime;
	/**
	 * 决定书文号
	 */
	private String licenceNumber;
	/**
	 * 决定机关
	 */
	private String department;
	/**
	 * 处罚内容
	 */
	private String licenceContent;
	/**
	 * 结束日期
	 */
	private String endDate;
	/**
	 * 类型
	 */
	private String audiType;
	/**
	 * 决定日期
	 */
	private String decisionDate;
	/**
	 * 法人
	 */
	private String legalPersonName;
	/**
	 * 处罚ID
	 */
	private String cid;
	/**
	 * 当地编码
	 */
	private String localCode;
	/**
	 * 法人ID
	 */
	private String legalPersonId;
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
	 * 设置：有效时间
	 */
	public void setValidityTime(String validityTime) {
		this.validityTime = validityTime;
	}
	/**
	 * 获取：有效时间
	 */
	public String getValidityTime() {
		return validityTime;
	}
	/**
	 * 设置：决定书文号
	 */
	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}
	/**
	 * 获取：决定书文号
	 */
	public String getLicenceNumber() {
		return licenceNumber;
	}
	/**
	 * 设置：决定机关
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * 获取：决定机关
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * 设置：处罚内容
	 */
	public void setLicenceContent(String licenceContent) {
		this.licenceContent = licenceContent;
	}
	/**
	 * 获取：处罚内容
	 */
	public String getLicenceContent() {
		return licenceContent;
	}
	/**
	 * 设置：结束日期
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * 获取：结束日期
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * 设置：类型
	 */
	public void setAudiType(String audiType) {
		this.audiType = audiType;
	}
	/**
	 * 获取：类型
	 */
	public String getAudiType() {
		return audiType;
	}
	/**
	 * 设置：决定日期
	 */
	public void setDecisionDate(String decisionDate) {
		this.decisionDate = decisionDate;
	}
	/**
	 * 获取：决定日期
	 */
	public String getDecisionDate() {
		return decisionDate;
	}
	/**
	 * 设置：法人
	 */
	public void setLegalPersonName(String legalPersonName) {
		this.legalPersonName = legalPersonName;
	}
	/**
	 * 获取：法人
	 */
	public String getLegalPersonName() {
		return legalPersonName;
	}
	/**
	 * 设置：处罚ID
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}
	/**
	 * 获取：处罚ID
	 */
	public String getCid() {
		return cid;
	}
	/**
	 * 设置：当地编码
	 */
	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}
	/**
	 * 获取：当地编码
	 */
	public String getLocalCode() {
		return localCode;
	}
	/**
	 * 设置：法人ID
	 */
	public void setLegalPersonId(String legalPersonId) {
		this.legalPersonId = legalPersonId;
	}
	/**
	 * 获取：法人ID
	 */
	public String getLegalPersonId() {
		return legalPersonId;
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
}
