package xin.tianchuang.modules.spider.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.Version;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 企业基础信息表
 * 
 * @author hui.deng
 * @email 
 * @date 2018-08-28 15:28:25
 */
@TableName("high_tech_zone_enterprise_info")
public class HighTechZoneEnterpriseInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 企业名称
	 */
	private String enterpriseName;
	/**
	 * 组织机构编码
	 */
	private String organizationCode;
	/**
	 * 营业执照号
	 */
	private String businessLicenseNo;
	/**
	 * 税号
	 */
	private String taxNo;
	/**
	 * 注册日期
	 */
	private String esDate;
	/**
	 * 注册资本
	 */
	private String regCap;
	/**
	 * 入园时间
	 */
	private String entryDate;
	/**
	 * 创建时间
	 */
	@TableField(value ="createtime")
	private Date createtime;
	/**
	 * 统一社会信用代码
	 */
	private String creditCode;
	/**
	 * 行业归属 1先进装备制造产业 2电子信息及互联网应用产业 3新材料产业 4新能源与节能环保产业 5生物医药与健康产业 6现代服务业 7其他
	 */
	private Integer industryType;
	/**
	 * 数据状态：1-正常 0-删除
	 */
	 @TableField(value = "data_state", fill = FieldFill.INSERT)
	private Integer dataState;
	/**
	 * 更新时间
	 */
	@TableField(value = "update_time", fill = FieldFill.UPDATE)
	private Date updateTime;
	/**
	 * 省份
	 */
	private String province;
	/**
	 * 城市
	 */
	private String city;
	/**
	 * 注册时间
	 */
	private String regTime;
	/**
	 * 天眼查企业ID
	 */
	private String tycEnterpriseid;
	/**
	 * 企业状态
	 */
	private String status;
	/**
	 * 数据来源
	 */
	private String dataSource;
	/**
	 * 官网网址
	 */
	private String webSite;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 联系电话列表
	 */
	private String phones;
	/**
	 * 
	 */
	private String email;
	/**
	 * 简介
	 */
	private String content;
	/**
	 * 企业法人
	 */
	private String legalPersonName;
	/**
	 * 更名标识
	 */
	private Boolean renameFlag;
	/**
	 * 历史名称
	 */
	private String oldName;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 出资时间
	 */
	private String tycUpdateTime;
	/**
	 * 天眼查得分
	 */
	private String score;
	/**
	 * 版本号
	 */
	@Version
	private Integer version;
	/**
	 * 旧企业ID
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long oldEnterpriseId;
	/**
	 * 新企业名称
	 */
	private String newName;
	/**
	 * 新企业ID
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long newEnterpriseId;
	/**
	 * 标签列表
	 */
	private String tagList;
	/**
	 * 曾用名列表
	 */
	private String historyList;

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
	 * 设置：企业名称
	 */
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	/**
	 * 获取：企业名称
	 */
	public String getEnterpriseName() {
		return enterpriseName;
	}
	/**
	 * 设置：组织机构编码
	 */
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	/**
	 * 获取：组织机构编码
	 */
	public String getOrganizationCode() {
		return organizationCode;
	}
	/**
	 * 设置：营业执照号
	 */
	public void setBusinessLicenseNo(String businessLicenseNo) {
		this.businessLicenseNo = businessLicenseNo;
	}
	/**
	 * 获取：营业执照号
	 */
	public String getBusinessLicenseNo() {
		return businessLicenseNo;
	}
	/**
	 * 设置：税号
	 */
	public void setTaxNo(String taxNo) {
		this.taxNo = taxNo;
	}
	/**
	 * 获取：税号
	 */
	public String getTaxNo() {
		return taxNo;
	}
	/**
	 * 设置：注册日期
	 */
	public void setEsDate(String esDate) {
		this.esDate = esDate;
	}
	/**
	 * 获取：注册日期
	 */
	public String getEsDate() {
		return esDate;
	}
	/**
	 * 设置：注册资本
	 */
	public void setRegCap(String regCap) {
		this.regCap = regCap;
	}
	/**
	 * 获取：注册资本
	 */
	public String getRegCap() {
		return regCap;
	}
	/**
	 * 设置：入园时间
	 */
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}
	/**
	 * 获取：入园时间
	 */
	public String getEntryDate() {
		return entryDate;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreatetime() {
		return createtime;
	}
	/**
	 * 设置：统一社会信用代码
	 */
	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}
	/**
	 * 获取：统一社会信用代码
	 */
	public String getCreditCode() {
		return creditCode;
	}
	/**
	 * 设置：行业归属 1先进装备制造产业 2电子信息及互联网应用产业 3新材料产业 4新能源与节能环保产业 5生物医药与健康产业 6现代服务业 7其他
	 */
	public void setIndustryType(Integer industryType) {
		this.industryType = industryType;
	}
	/**
	 * 获取：行业归属 1先进装备制造产业 2电子信息及互联网应用产业 3新材料产业 4新能源与节能环保产业 5生物医药与健康产业 6现代服务业 7其他
	 */
	public Integer getIndustryType() {
		return industryType;
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
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：省份
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取：省份
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 设置：城市
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：城市
	 */
	public String getCity() {
		return city;
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
	 * 设置：天眼查企业ID
	 */
	public void setTycEnterpriseid(String tycEnterpriseid) {
		this.tycEnterpriseid = tycEnterpriseid;
	}
	/**
	 * 获取：天眼查企业ID
	 */
	public String getTycEnterpriseid() {
		return tycEnterpriseid;
	}
	/**
	 * 设置：企业状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：企业状态
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：数据来源
	 */
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	/**
	 * 获取：数据来源
	 */
	public String getDataSource() {
		return dataSource;
	}
	/**
	 * 设置：官网网址
	 */
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	/**
	 * 获取：官网网址
	 */
	public String getWebSite() {
		return webSite;
	}
	/**
	 * 设置：地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：联系电话列表
	 */
	public void setPhones(String phones) {
		this.phones = phones;
	}
	/**
	 * 获取：联系电话列表
	 */
	public String getPhones() {
		return phones;
	}
	/**
	 * 设置：
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：简介
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：简介
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：企业法人
	 */
	public void setLegalPersonName(String legalPersonName) {
		this.legalPersonName = legalPersonName;
	}
	/**
	 * 获取：企业法人
	 */
	public String getLegalPersonName() {
		return legalPersonName;
	}
	/**
	 * 设置：更名标识
	 */
	public void setRenameFlag(Boolean renameFlag) {
		this.renameFlag = renameFlag;
	}
	/**
	 * 获取：更名标识
	 */
	public Boolean getRenameFlag() {
		return renameFlag;
	}
	/**
	 * 设置：历史名称
	 */
	public void setOldName(String oldName) {
		this.oldName = oldName;
	}
	/**
	 * 获取：历史名称
	 */
	public String getOldName() {
		return oldName;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：出资时间
	 */
	public void setTycUpdateTime(String tycUpdateTime) {
		this.tycUpdateTime = tycUpdateTime;
	}
	/**
	 * 获取：出资时间
	 */
	public String getTycUpdateTime() {
		return tycUpdateTime;
	}
	/**
	 * 设置：天眼查得分
	 */
	public void setScore(String score) {
		this.score = score;
	}
	/**
	 * 获取：天眼查得分
	 */
	public String getScore() {
		return score;
	}
	/**
	 * 设置：版本号
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	/**
	 * 获取：版本号
	 */
	public Integer getVersion() {
		return version;
	}
	/**
	 * 设置：旧企业ID
	 */
	public void setOldEnterpriseId(Long oldEnterpriseId) {
		this.oldEnterpriseId = oldEnterpriseId;
	}
	/**
	 * 获取：旧企业ID
	 */
	public Long getOldEnterpriseId() {
		return oldEnterpriseId;
	}
	/**
	 * 设置：新企业名称
	 */
	public void setNewName(String newName) {
		this.newName = newName;
	}
	/**
	 * 获取：新企业名称
	 */
	public String getNewName() {
		return newName;
	}
	/**
	 * 设置：新企业ID
	 */
	public void setNewEnterpriseId(Long newEnterpriseId) {
		this.newEnterpriseId = newEnterpriseId;
	}
	/**
	 * 获取：新企业ID
	 */
	public Long getNewEnterpriseId() {
		return newEnterpriseId;
	}
	/**
	 * 设置：标签列表
	 */
	public void setTagList(String tagList) {
		this.tagList = tagList;
	}
	/**
	 * 获取：标签列表
	 */
	public String getTagList() {
		return tagList;
	}
	/**
	 * 设置：曾用名列表
	 */
	public void setHistoryList(String historyList) {
		this.historyList = historyList;
	}
	/**
	 * 获取：曾用名列表
	 */
	public String getHistoryList() {
		return historyList;
	}
}
