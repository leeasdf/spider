package xin.tianchuang.modules.spider.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 作品著作权信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:22
 */
@TableName("rpt_tn_announcementcourt")
public class RptTnAnnouncementcourtEntity implements Serializable {
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
	 * 开庭日期
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
	private String startDate;

	/**
	 * 原告/上诉人
	 */
	private String plaintiff;
	/**
	 * 被告/被上诉人
	 */
	private String defendant;
	/**
	 * 案件原由
	 */
	private String caseReason;
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
	 * 法庭
	 */
	private String courtroom;
	/**
	 * 案件编号
	 */
	private String caseNo;
	/**
	 * 法院
	 */
	private String court;
	/**
	 * 事件ID
	 */
	private String aId;
	/**
	 * 搜索类别
	 */
	private String searchType;
	/**
	 * 诉讼当事人
	 */
	private String litigant;
	/**
	 * 类别
	 */
	private String type;
	/**
	 * 关联名单
	 */
	private String connList;
	/**
	 * 审判者/主审人
	 */
	private String contractors;
	/**
	 * 事件时间
	 */
	private String eventTime;

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
	 * 设置：开庭日期
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * 获取：开庭日期
	 */
	public String getStartDate() {
		return startDate;
	}

	public String getaId() {
		return aId;
	}

	public void setaId(String aId) {
		this.aId = aId;
	}

	/**
	 * 设置：原告/上诉人
	 */
	public void setPlaintiff(String plaintiff) {
		this.plaintiff = plaintiff;
	}

	/**
	 * 获取：原告/上诉人
	 */
	public String getPlaintiff() {
		return plaintiff;
	}

	/**
	 * 设置：被告/被上诉人
	 */
	public void setDefendant(String defendant) {
		this.defendant = defendant;
	}

	/**
	 * 获取：被告/被上诉人
	 */
	public String getDefendant() {
		return defendant;
	}

	/**
	 * 设置：案件原由
	 */
	public void setCaseReason(String caseReason) {
		this.caseReason = caseReason;
	}

	/**
	 * 获取：案件原由
	 */
	public String getCaseReason() {
		return caseReason;
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
	 * 设置：法庭
	 */
	public void setCourtroom(String courtroom) {
		this.courtroom = courtroom;
	}

	/**
	 * 获取：法庭
	 */
	public String getCourtroom() {
		return courtroom;
	}

	/**
	 * 设置：案件编号
	 */
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	/**
	 * 获取：案件编号
	 */
	public String getCaseNo() {
		return caseNo;
	}

	/**
	 * 设置：法院
	 */
	public void setCourt(String court) {
		this.court = court;
	}

	/**
	 * 获取：法院
	 */
	public String getCourt() {
		return court;
	}

	/**
	 * 设置：事件ID
	 */
	public void setAId(String aId) {
		this.aId = aId;
	}

	/**
	 * 获取：事件ID
	 */
	public String getAId() {
		return aId;
	}

	/**
	 * 设置：搜索类别
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	/**
	 * 获取：搜索类别
	 */
	public String getSearchType() {
		return searchType;
	}

	/**
	 * 设置：诉讼当事人
	 */
	public void setLitigant(String litigant) {
		this.litigant = litigant;
	}

	/**
	 * 获取：诉讼当事人
	 */
	public String getLitigant() {
		return litigant;
	}

	/**
	 * 设置：类别
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 获取：类别
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置：关联名单
	 */
	public void setConnList(String connList) {
		this.connList = connList;
	}

	/**
	 * 获取：关联名单
	 */
	public String getConnList() {
		return connList;
	}

	/**
	 * 设置：审判者/主审人
	 */
	public void setContractors(String contractors) {
		this.contractors = contractors;
	}

	/**
	 * 获取：审判者/主审人
	 */
	public String getContractors() {
		return contractors;
	}

	/**
	 * 设置：事件时间
	 */
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	/**
	 * 获取：事件时间
	 */
	public String getEventTime() {
		return eventTime;
	}
}
