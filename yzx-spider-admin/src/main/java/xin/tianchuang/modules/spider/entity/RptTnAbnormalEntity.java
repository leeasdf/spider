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
 * 经营异常信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:21
 */
@TableName("rpt_tn_abnormal")
public class RptTnAbnormalEntity implements Serializable {
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
	 * 列入日期
	 */
	private String date;
	/**
	 * 决定机关
	 */
	private String agency;
	/**
	 * 列入原因
	 */
	private String reason;
	/**
	 * 移除日期
	 */
	private String removeDate;
	/**
	 * 移除机关
	 */
	private String removeAgency;
	/**
	 * 移除原因
	 */
	private String removeReason;
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
	 * 设置：列入日期
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * 获取：列入日期
	 */
	public String getDate() {
		return date;
	}
	/**
	 * 设置：决定机关
	 */
	public void setAgency(String agency) {
		this.agency = agency;
	}
	/**
	 * 获取：决定机关
	 */
	public String getAgency() {
		return agency;
	}
	/**
	 * 设置：列入原因
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	 * 获取：列入原因
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * 设置：移除日期
	 */
	public void setRemoveDate(String removeDate) {
		this.removeDate = removeDate;
	}
	/**
	 * 获取：移除日期
	 */
	public String getRemoveDate() {
		return removeDate;
	}
	/**
	 * 设置：移除机关
	 */
	public void setRemoveAgency(String removeAgency) {
		this.removeAgency = removeAgency;
	}
	/**
	 * 获取：移除机关
	 */
	public String getRemoveAgency() {
		return removeAgency;
	}
	/**
	 * 设置：移除原因
	 */
	public void setRemoveReason(String removeReason) {
		this.removeReason = removeReason;
	}
	/**
	 * 获取：移除原因
	 */
	public String getRemoveReason() {
		return removeReason;
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
