package xin.tianchuang.modules.spider.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 企业-水费欠缴信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:16
 */
@TableName("ent_drainage_owe_fee")
public class EntDrainageOweFeeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 企业名称
	 */
	private String companyName;
	/**
	 * 年开单金额(单位：元)
	 */
	private BigDecimal billingFee;
	/**
	 * 是否欠排污费：1-是，0-否
	 */
	private String oweFlag;
	/**
	 * 序号
	 */
	private String serialNo;
	/**
	 * 年入库金额(单位：元)
	 */
	private BigDecimal payIn;
	/**
	 * 上级机构
	 */
	private String parentInstitution;
	/**
	 * 年份
	 */
	private String year;
	/**
	 * 欠缴排污费(单位：元)
	 */
	private BigDecimal oweFee;
	/**
	 * 缴纳金额(单位：元)
	 */
	private BigDecimal payOweFee;
	/**
	 * 缴纳时间
	 */
	private String payTime;
	/**
	 * 说明（处理意见等说明）
	 */
	private String remark;

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
	 * 设置：企业名称
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * 获取：企业名称
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * 设置：年开单金额(单位：元)
	 */
	public void setBillingFee(BigDecimal billingFee) {
		this.billingFee = billingFee;
	}
	/**
	 * 获取：年开单金额(单位：元)
	 */
	public BigDecimal getBillingFee() {
		return billingFee;
	}
	/**
	 * 设置：是否欠排污费：1-是，0-否
	 */
	public void setOweFlag(String oweFlag) {
		this.oweFlag = oweFlag;
	}
	/**
	 * 获取：是否欠排污费：1-是，0-否
	 */
	public String getOweFlag() {
		return oweFlag;
	}
	/**
	 * 设置：序号
	 */
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	/**
	 * 获取：序号
	 */
	public String getSerialNo() {
		return serialNo;
	}
	/**
	 * 设置：年入库金额(单位：元)
	 */
	public void setPayIn(BigDecimal payIn) {
		this.payIn = payIn;
	}
	/**
	 * 获取：年入库金额(单位：元)
	 */
	public BigDecimal getPayIn() {
		return payIn;
	}
	/**
	 * 设置：上级机构
	 */
	public void setParentInstitution(String parentInstitution) {
		this.parentInstitution = parentInstitution;
	}
	/**
	 * 获取：上级机构
	 */
	public String getParentInstitution() {
		return parentInstitution;
	}
	/**
	 * 设置：年份
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * 获取：年份
	 */
	public String getYear() {
		return year;
	}
	/**
	 * 设置：欠缴排污费(单位：元)
	 */
	public void setOweFee(BigDecimal oweFee) {
		this.oweFee = oweFee;
	}
	/**
	 * 获取：欠缴排污费(单位：元)
	 */
	public BigDecimal getOweFee() {
		return oweFee;
	}
	/**
	 * 设置：缴纳金额(单位：元)
	 */
	public void setPayOweFee(BigDecimal payOweFee) {
		this.payOweFee = payOweFee;
	}
	/**
	 * 获取：缴纳金额(单位：元)
	 */
	public BigDecimal getPayOweFee() {
		return payOweFee;
	}
	/**
	 * 设置：缴纳时间
	 */
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	/**
	 * 获取：缴纳时间
	 */
	public String getPayTime() {
		return payTime;
	}
	/**
	 * 设置：说明（处理意见等说明）
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：说明（处理意见等说明）
	 */
	public String getRemark() {
		return remark;
	}
}
