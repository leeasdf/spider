package xin.tianchuang.modules.spider.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 工业地产注入项目情况表
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:24
 */
@TableName("ent_high_tech_industrial_estate")
public class EntHighTechIndustrialEstateEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 工业地产单位
	 */
	private String industrialEstateUnit;
	/**
	 * 企业名称
	 */
	private String company;
	/**
	 * 面积（平方米）
	 */
	private BigDecimal area;
	/**
	 * 楼栋及房号
	 */
	private String address;
	/**
	 * 主要产品及服务
	 */
	private String mainProduct;
	/**
	 * 购入还是承租
	 */
	private String belongType;
	/**
	 * 是否转租
	 */
	private String isSublet;
	/**
	 * 备注
	 */
	private String note;
	/**
	 * 所属会员
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
	 * 设置：工业地产单位
	 */
	public void setIndustrialEstateUnit(String industrialEstateUnit) {
		this.industrialEstateUnit = industrialEstateUnit;
	}
	/**
	 * 获取：工业地产单位
	 */
	public String getIndustrialEstateUnit() {
		return industrialEstateUnit;
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
	 * 设置：面积（平方米）
	 */
	public void setArea(BigDecimal area) {
		this.area = area;
	}
	/**
	 * 获取：面积（平方米）
	 */
	public BigDecimal getArea() {
		return area;
	}
	/**
	 * 设置：楼栋及房号
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：楼栋及房号
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：主要产品及服务
	 */
	public void setMainProduct(String mainProduct) {
		this.mainProduct = mainProduct;
	}
	/**
	 * 获取：主要产品及服务
	 */
	public String getMainProduct() {
		return mainProduct;
	}
	/**
	 * 设置：购入还是承租
	 */
	public void setBelongType(String belongType) {
		this.belongType = belongType;
	}
	/**
	 * 获取：购入还是承租
	 */
	public String getBelongType() {
		return belongType;
	}
	/**
	 * 设置：是否转租
	 */
	public void setIsSublet(String isSublet) {
		this.isSublet = isSublet;
	}
	/**
	 * 获取：是否转租
	 */
	public String getIsSublet() {
		return isSublet;
	}
	/**
	 * 设置：备注
	 */
	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * 获取：备注
	 */
	public String getNote() {
		return note;
	}
	/**
	 * 设置：所属会员
	 */
	public void setMemId(Integer memId) {
		this.memId = memId;
	}
	/**
	 * 获取：所属会员
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
