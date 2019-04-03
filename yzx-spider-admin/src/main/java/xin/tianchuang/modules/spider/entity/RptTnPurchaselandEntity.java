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
 * 企业-购地信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:22
 */
@TableName("rpt_tn_purchaseland")
public class RptTnPurchaselandEntity implements Serializable {
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
	 * 购地ID
	 */
	private String plId;
	/**
	 * 行政区
	 */
	private String adminRegion;
	/**
	 * 电子监管号
	 */
	private String elecSupervisorNo;
	/**
	 * 签订日期
	 */
	private String signedDate;
	/**
	 * 供地总面积（公顷）
	 */
	private String totalArea;
	/**
	 * 宗地位置
	 */
	private String location;
	/**
	 * 受让人
	 */
	private String assignee;
	/**
	 * 上级公司
	 */
	private String parentCompany;
	/**
	 * 土地用途
	 */
	private String purpose;
	/**
	 * 供应方式
	 */
	private String supplyWay;
	/**
	 * 最小容积率
	 */
	private String minVolume;
	/**
	 * 最大容积率
	 */
	private String maxVolume;
	/**
	 * 成交价款（万元）
	 */
	private String dealPrice;
	/**
	 * 约定动工时间
	 */
	private String startTime;
	/**
	 * 链接地址
	 */
	private String linkUrl;
	/**
	 * 约定竣工时间
	 */
	private String endTime;
	/**
	 * 创建时间
	 */
	private String plCreateTime;
	/**
	 * 修改时间
	 */
	private String plUpdateTime;
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
	 * 设置：购地ID
	 */
	public void setPlId(String plId) {
		this.plId = plId;
	}

	/**
	 * 获取：购地ID
	 */
	public String getPlId() {
		return plId;
	}

	/**
	 * 设置：行政区
	 */
	public void setAdminRegion(String adminRegion) {
		this.adminRegion = adminRegion;
	}

	/**
	 * 获取：行政区
	 */
	public String getAdminRegion() {
		return adminRegion;
	}

	/**
	 * 设置：电子监管号
	 */
	public void setElecSupervisorNo(String elecSupervisorNo) {
		this.elecSupervisorNo = elecSupervisorNo;
	}

	/**
	 * 获取：电子监管号
	 */
	public String getElecSupervisorNo() {
		return elecSupervisorNo;
	}

	/**
	 * 设置：签订日期
	 */
	public void setSignedDate(String signedDate) {
		this.signedDate = signedDate;
	}

	/**
	 * 获取：签订日期
	 */
	public String getSignedDate() {
		return signedDate;
	}

	/**
	 * 设置：供地总面积（公顷）
	 */
	public void setTotalArea(String totalArea) {
		this.totalArea = totalArea;
	}

	/**
	 * 获取：供地总面积（公顷）
	 */
	public String getTotalArea() {
		return totalArea;
	}

	/**
	 * 设置：宗地位置
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * 获取：宗地位置
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * 设置：受让人
	 */
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	/**
	 * 获取：受让人
	 */
	public String getAssignee() {
		return assignee;
	}

	/**
	 * 设置：上级公司
	 */
	public void setParentCompany(String parentCompany) {
		this.parentCompany = parentCompany;
	}

	/**
	 * 获取：上级公司
	 */
	public String getParentCompany() {
		return parentCompany;
	}

	/**
	 * 设置：土地用途
	 */
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	/**
	 * 获取：土地用途
	 */
	public String getPurpose() {
		return purpose;
	}

	/**
	 * 设置：供应方式
	 */
	public void setSupplyWay(String supplyWay) {
		this.supplyWay = supplyWay;
	}

	/**
	 * 获取：供应方式
	 */
	public String getSupplyWay() {
		return supplyWay;
	}

	/**
	 * 设置：最小容积率
	 */
	public void setMinVolume(String minVolume) {
		this.minVolume = minVolume;
	}

	/**
	 * 获取：最小容积率
	 */
	public String getMinVolume() {
		return minVolume;
	}

	/**
	 * 设置：最大容积率
	 */
	public void setMaxVolume(String maxVolume) {
		this.maxVolume = maxVolume;
	}

	/**
	 * 获取：最大容积率
	 */
	public String getMaxVolume() {
		return maxVolume;
	}

	/**
	 * 设置：成交价款（万元）
	 */
	public void setDealPrice(String dealPrice) {
		this.dealPrice = dealPrice;
	}

	/**
	 * 获取：成交价款（万元）
	 */
	public String getDealPrice() {
		return dealPrice;
	}

	/**
	 * 设置：约定动工时间
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * 获取：约定动工时间
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * 设置：链接地址
	 */
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	/**
	 * 获取：链接地址
	 */
	public String getLinkUrl() {
		return linkUrl;
	}

	/**
	 * 设置：约定竣工时间
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * 获取：约定竣工时间
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * 设置：创建时间
	 */
	public void setPlCreateTime(String plCreateTime) {
		this.plCreateTime = plCreateTime;
	}

	/**
	 * 获取：创建时间
	 */
	public String getPlCreateTime() {
		return plCreateTime;
	}

	/**
	 * 设置：修改时间
	 */
	public void setPlUpdateTime(String plUpdateTime) {
		this.plUpdateTime = plUpdateTime;
	}

	/**
	 * 获取：修改时间
	 */
	public String getPlUpdateTime() {
		return plUpdateTime;
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
