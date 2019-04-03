package xin.tianchuang.modules.spider.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * 省发改委-环境行政处罚(省环保厅)
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:19
 */
@TableName("cs_sfgw_hbt_penalties")
public class CsSfgwHbtPenaltiesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 数据状态（0：正常 1：更新 2：删除）
	 */
	private Integer isinvalid;
	/**
	 * 数据最后修改时间
	 */
	private Date lastdate;
	/**
	 * 所属地区
	 */
	private String reginname;
	/**
	 * 执法部门
	 */
	private String executionpunishment;
	/**
	 * 处罚书文号
	 */
	private String penaltyid;
	/**
	 * 被处罚单位及法人姓名
	 */
	private String corporationname;
	/**
	 * 处罚日期
	 */
	private String dateofpunishment;
	/**
	 * 处罚类别
	 */
	private String cfTypr;
	/**
	 * 处罚事由
	 */
	private String illegalfacts;
	/**
	 * 整改情况
	 */
	private String rectification;
	/**
	 * 备注
	 */
	private String remarks;
	/**
	 * 主键
	 */
	@TableId(value = "zjid", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long zjid;

	/**
	 * 设置：数据状态（0：正常 1：更新 2：删除）
	 */
	public void setIsinvalid(Integer isinvalid) {
		this.isinvalid = isinvalid;
	}
	/**
	 * 获取：数据状态（0：正常 1：更新 2：删除）
	 */
	public Integer getIsinvalid() {
		return isinvalid;
	}
	/**
	 * 设置：数据最后修改时间
	 */
	public void setLastdate(Date lastdate) {
		this.lastdate = lastdate;
	}
	/**
	 * 获取：数据最后修改时间
	 */
	public Date getLastdate() {
		return lastdate;
	}
	/**
	 * 设置：所属地区
	 */
	public void setReginname(String reginname) {
		this.reginname = reginname;
	}
	/**
	 * 获取：所属地区
	 */
	public String getReginname() {
		return reginname;
	}
	/**
	 * 设置：执法部门
	 */
	public void setExecutionpunishment(String executionpunishment) {
		this.executionpunishment = executionpunishment;
	}
	/**
	 * 获取：执法部门
	 */
	public String getExecutionpunishment() {
		return executionpunishment;
	}
	/**
	 * 设置：处罚书文号
	 */
	public void setPenaltyid(String penaltyid) {
		this.penaltyid = penaltyid;
	}
	/**
	 * 获取：处罚书文号
	 */
	public String getPenaltyid() {
		return penaltyid;
	}
	/**
	 * 设置：被处罚单位及法人姓名
	 */
	public void setCorporationname(String corporationname) {
		this.corporationname = corporationname;
	}
	/**
	 * 获取：被处罚单位及法人姓名
	 */
	public String getCorporationname() {
		return corporationname;
	}
	/**
	 * 设置：处罚日期
	 */
	public void setDateofpunishment(String dateofpunishment) {
		this.dateofpunishment = dateofpunishment;
	}
	/**
	 * 获取：处罚日期
	 */
	public String getDateofpunishment() {
		return dateofpunishment;
	}
	/**
	 * 设置：处罚类别
	 */
	public void setCfTypr(String cfTypr) {
		this.cfTypr = cfTypr;
	}
	/**
	 * 获取：处罚类别
	 */
	public String getCfTypr() {
		return cfTypr;
	}
	/**
	 * 设置：处罚事由
	 */
	public void setIllegalfacts(String illegalfacts) {
		this.illegalfacts = illegalfacts;
	}
	/**
	 * 获取：处罚事由
	 */
	public String getIllegalfacts() {
		return illegalfacts;
	}
	/**
	 * 设置：整改情况
	 */
	public void setRectification(String rectification) {
		this.rectification = rectification;
	}
	/**
	 * 获取：整改情况
	 */
	public String getRectification() {
		return rectification;
	}
	/**
	 * 设置：备注
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * 获取：备注
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * 设置：主键
	 */
	public void setZjid(Long zjid) {
		this.zjid = zjid;
	}
	/**
	 * 获取：主键
	 */
	public Long getZjid() {
		return zjid;
	}
}
