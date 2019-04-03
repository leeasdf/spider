package xin.tianchuang.modules.spider.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 国土发证台账情况表
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:24
 */
@TableName("ent_high_tech_land_ledger")
public class EntHighTechLandLedgerEntity implements Serializable {
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
	private String company;
	/**
	 * 业务类型
	 */
	private String businessType;
	/**
	 * 土地使用权证号
	 */
	private String landUseNumber;
	/**
	 * 原土地证号
	 */
	private String oldLandUseNumber;
	/**
	 * 土地位置
	 */
	private String landAddress;
	/**
	 * 宗地面积
	 */
	private BigDecimal area;
	/**
	 * 土地用途
	 */
	private String landUse;
	/**
	 * 使用权类型
	 */
	private String landUseType;
	/**
	 * 登记审批日期
	 */
	private Date registerDate;
	/**
	 * 土地使用期限
	 */
	private String limitDate;
	/**
	 * 联系方式
	 */
	private String contact;
	/**
	 * 台账年份
	 */
	private Integer year;
	/**
	 * 绑定mem_id
	 */
	private Integer memId;
	/**
	 * 企业ID
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long enterpriseId;

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
	public void setCompany(String company) {
		this.company = company;
	}
	/**
	 * 获取：企业名称
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * 设置：业务类型
	 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	/**
	 * 获取：业务类型
	 */
	public String getBusinessType() {
		return businessType;
	}
	/**
	 * 设置：土地使用权证号
	 */
	public void setLandUseNumber(String landUseNumber) {
		this.landUseNumber = landUseNumber;
	}
	/**
	 * 获取：土地使用权证号
	 */
	public String getLandUseNumber() {
		return landUseNumber;
	}
	/**
	 * 设置：原土地证号
	 */
	public void setOldLandUseNumber(String oldLandUseNumber) {
		this.oldLandUseNumber = oldLandUseNumber;
	}
	/**
	 * 获取：原土地证号
	 */
	public String getOldLandUseNumber() {
		return oldLandUseNumber;
	}
	/**
	 * 设置：土地位置
	 */
	public void setLandAddress(String landAddress) {
		this.landAddress = landAddress;
	}
	/**
	 * 获取：土地位置
	 */
	public String getLandAddress() {
		return landAddress;
	}
	/**
	 * 设置：宗地面积
	 */
	public void setArea(BigDecimal area) {
		this.area = area;
	}
	/**
	 * 获取：宗地面积
	 */
	public BigDecimal getArea() {
		return area;
	}
	/**
	 * 设置：土地用途
	 */
	public void setLandUse(String landUse) {
		this.landUse = landUse;
	}
	/**
	 * 获取：土地用途
	 */
	public String getLandUse() {
		return landUse;
	}
	/**
	 * 设置：使用权类型
	 */
	public void setLandUseType(String landUseType) {
		this.landUseType = landUseType;
	}
	/**
	 * 获取：使用权类型
	 */
	public String getLandUseType() {
		return landUseType;
	}
	/**
	 * 设置：登记审批日期
	 */
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	/**
	 * 获取：登记审批日期
	 */
	public Date getRegisterDate() {
		return registerDate;
	}
	/**
	 * 设置：土地使用期限
	 */
	public void setLimitDate(String limitDate) {
		this.limitDate = limitDate;
	}
	/**
	 * 获取：土地使用期限
	 */
	public String getLimitDate() {
		return limitDate;
	}
	/**
	 * 设置：联系方式
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	/**
	 * 获取：联系方式
	 */
	public String getContact() {
		return contact;
	}
	/**
	 * 设置：台账年份
	 */
	public void setYear(Integer year) {
		this.year = year;
	}
	/**
	 * 获取：台账年份
	 */
	public Integer getYear() {
		return year;
	}
	/**
	 * 设置：绑定mem_id
	 */
	public void setMemId(Integer memId) {
		this.memId = memId;
	}
	/**
	 * 获取：绑定mem_id
	 */
	public Integer getMemId() {
		return memId;
	}
	/**
	 * 设置：企业ID
	 */
	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	/**
	 * 获取：企业ID
	 */
	public Long getEnterpriseId() {
		return enterpriseId;
	}
}
