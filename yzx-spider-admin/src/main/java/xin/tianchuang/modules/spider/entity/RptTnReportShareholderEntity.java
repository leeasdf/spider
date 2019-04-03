package xin.tianchuang.modules.spider.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * tyc企业年报-股东及出资信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-12-05 17:21:31
 */
@TableName("rpt_tn_report_shareholder")
public class RptTnReportShareholderEntity implements Serializable {
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
	 * 年报主键
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long reportId;
	/**
	 * 认缴出资时间
	 */
	private String paidDate;
	/**
	 * 股东url
	 */
	private String nameUrl;
	/**
	 * 股东
	 */
	private String name;
	/**
	 * 认缴出资方式
	 */
	private String paidInvestType;
	/**
	 * 实缴出资方式
	 */
	private String actInvestType;
	/**
	 * 认缴出资额（万元）
	 */
	private String paidAmount;
	/**
	 * 实缴出资额（万元）
	 */
	private String actAmount;
	/**
	 * 实缴出资时间
	 */
	private String actDate;
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
	 * 设置：主键
	 */
	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	/**
	 * 获取：主键
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
	 * 设置：年报主键
	 */
	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}
	/**
	 * 获取：年报主键
	 */
	public Long getReportId() {
		return reportId;
	}
	/**
	 * 设置：认缴出资时间
	 */
	public void setPaidDate(String paidDate) {
		this.paidDate = paidDate;
	}
	/**
	 * 获取：认缴出资时间
	 */
	public String getPaidDate() {
		return paidDate;
	}
	/**
	 * 设置：股东url
	 */
	public void setNameUrl(String nameUrl) {
		this.nameUrl = nameUrl;
	}
	/**
	 * 获取：股东url
	 */
	public String getNameUrl() {
		return nameUrl;
	}
	/**
	 * 设置：股东
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：股东
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：认缴出资方式
	 */
	public void setPaidInvestType(String paidInvestType) {
		this.paidInvestType = paidInvestType;
	}
	/**
	 * 获取：认缴出资方式
	 */
	public String getPaidInvestType() {
		return paidInvestType;
	}
	/**
	 * 设置：实缴出资方式
	 */
	public void setActInvestType(String actInvestType) {
		this.actInvestType = actInvestType;
	}
	/**
	 * 获取：实缴出资方式
	 */
	public String getActInvestType() {
		return actInvestType;
	}
	/**
	 * 设置：认缴出资额（万元）
	 */
	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}
	/**
	 * 获取：认缴出资额（万元）
	 */
	public String getPaidAmount() {
		return paidAmount;
	}
	/**
	 * 设置：实缴出资额（万元）
	 */
	public void setActAmount(String actAmount) {
		this.actAmount = actAmount;
	}
	/**
	 * 获取：实缴出资额（万元）
	 */
	public String getActAmount() {
		return actAmount;
	}
	/**
	 * 设置：实缴出资时间
	 */
	public void setActDate(String actDate) {
		this.actDate = actDate;
	}
	/**
	 * 获取：实缴出资时间
	 */
	public String getActDate() {
		return actDate;
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
