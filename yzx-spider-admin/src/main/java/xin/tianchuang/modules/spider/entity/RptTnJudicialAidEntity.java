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
 * 企业-司法协助信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 10:14:18
 */
@TableName("rpt_tn_judicial_aid")
public class RptTnJudicialAidEntity implements Serializable {
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
	 * 被执行人
	 */
	private String executedPerson;
	/**
	 * 股权数额
	 */
	private String equityAmountOther;
	/**
	 * 执行法院
	 */
	private String executiveCourt;
	/**
	 * 执行通知文号
	 */
	private String executeNoticeNum;
	/**
	 * 类型|状态
	 */
	private String executedPersonType;
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
	 * 设置：被执行人
	 */
	public void setExecutedPerson(String executedPerson) {
		this.executedPerson = executedPerson;
	}

	/**
	 * 获取：被执行人
	 */
	public String getExecutedPerson() {
		return executedPerson;
	}

	/**
	 * 设置：股权数额
	 */
	public void setEquityAmountOther(String equityAmountOther) {
		this.equityAmountOther = equityAmountOther;
	}

	/**
	 * 获取：股权数额
	 */
	public String getEquityAmountOther() {
		return equityAmountOther;
	}

	/**
	 * 设置：执行法院
	 */
	public void setExecutiveCourt(String executiveCourt) {
		this.executiveCourt = executiveCourt;
	}

	/**
	 * 获取：执行法院
	 */
	public String getExecutiveCourt() {
		return executiveCourt;
	}

	/**
	 * 设置：执行通知文号
	 */
	public void setExecuteNoticeNum(String executeNoticeNum) {
		this.executeNoticeNum = executeNoticeNum;
	}

	/**
	 * 获取：执行通知文号
	 */
	public String getExecuteNoticeNum() {
		return executeNoticeNum;
	}

	/**
	 * 设置：类型|状态
	 */
	public void setExecutedPersonType(String executedPersonType) {
		this.executedPersonType = executedPersonType;
	}

	/**
	 * 获取：类型|状态
	 */
	public String getExecutedPersonType() {
		return executedPersonType;
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
