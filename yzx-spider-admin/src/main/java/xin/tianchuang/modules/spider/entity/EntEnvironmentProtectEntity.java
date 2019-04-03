package xin.tianchuang.modules.spider.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 企业-环保信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:16
 */
@TableName("ent_environment_protect")
public class EntEnvironmentProtectEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 组织机构代码
	 */
	private String organizationCode;
	/**
	 * 序号
	 */
	private String serialNo;
	/**
	 * 来源
	 */
	private String source;
	/**
	 * 行 政 区代码
	 */
	private String areaCode;
	/**
	 * 县（区）
	 */
	private String county;
	/**
	 * 企业名称
	 */
	private String companyName;
	/**
	 * 年份
	 */
	private String year;
	/**
	 * 否是国家监控污染企业:1-是，0-否
	 */
	private String countryMonitorFlag;
	/**
	 * 市（地、州、盟）
	 */
	private String city;

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
	 * 设置：组织机构代码
	 */
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	/**
	 * 获取：组织机构代码
	 */
	public String getOrganizationCode() {
		return organizationCode;
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
	 * 设置：来源
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * 获取：来源
	 */
	public String getSource() {
		return source;
	}
	/**
	 * 设置：行 政 区代码
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	/**
	 * 获取：行 政 区代码
	 */
	public String getAreaCode() {
		return areaCode;
	}
	/**
	 * 设置：县（区）
	 */
	public void setCounty(String county) {
		this.county = county;
	}
	/**
	 * 获取：县（区）
	 */
	public String getCounty() {
		return county;
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
	 * 设置：否是国家监控污染企业:1-是，0-否
	 */
	public void setCountryMonitorFlag(String countryMonitorFlag) {
		this.countryMonitorFlag = countryMonitorFlag;
	}
	/**
	 * 获取：否是国家监控污染企业:1-是，0-否
	 */
	public String getCountryMonitorFlag() {
		return countryMonitorFlag;
	}
	/**
	 * 设置：市（地、州、盟）
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：市（地、州、盟）
	 */
	public String getCity() {
		return city;
	}
}
