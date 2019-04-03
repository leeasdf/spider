package xin.tianchuang.modules.spider.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 企业驰名商标信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:23
 */
@TableName("ent_wellknown_trademark")
public class EntWellknownTrademarkEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 会员id
	 */
	private Integer memId;
	/**
	 * 企业ID
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long enterpriseId;
	/**
	 * 类别
	 */
	private String type;
	/**
	 * 序号
	 */
	private String serialNumber;
	/**
	 * 企业名称(商标所有人)
	 */
	private String enterpriseName;
	/**
	 * 主要商品
	 */
	private String mainProduct;
	/**
	 * 注册时间
	 */
	private String regTime;
	/**
	 * 区县
	 */
	private String country;
	/**
	 * 市州
	 */
	private String city;
	/**
	 * 注册号
	 */
	private String regNumber;
	/**
	 * 商标
	 */
	private String trademark;

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
	 * 设置：会员id
	 */
	public void setMemId(Integer memId) {
		this.memId = memId;
	}
	/**
	 * 获取：会员id
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
	 * 设置：序号
	 */
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	/**
	 * 获取：序号
	 */
	public String getSerialNumber() {
		return serialNumber;
	}
	/**
	 * 设置：企业名称(商标所有人)
	 */
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	/**
	 * 获取：企业名称(商标所有人)
	 */
	public String getEnterpriseName() {
		return enterpriseName;
	}
	/**
	 * 设置：主要商品
	 */
	public void setMainProduct(String mainProduct) {
		this.mainProduct = mainProduct;
	}
	/**
	 * 获取：主要商品
	 */
	public String getMainProduct() {
		return mainProduct;
	}
	/**
	 * 设置：注册时间
	 */
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	/**
	 * 获取：注册时间
	 */
	public String getRegTime() {
		return regTime;
	}
	/**
	 * 设置：区县
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * 获取：区县
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * 设置：市州
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：市州
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置：注册号
	 */
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}
	/**
	 * 获取：注册号
	 */
	public String getRegNumber() {
		return regNumber;
	}
	/**
	 * 设置：商标
	 */
	public void setTrademark(String trademark) {
		this.trademark = trademark;
	}
	/**
	 * 获取：商标
	 */
	public String getTrademark() {
		return trademark;
	}
}
