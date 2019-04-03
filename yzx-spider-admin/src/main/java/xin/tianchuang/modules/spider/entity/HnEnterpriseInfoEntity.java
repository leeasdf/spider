package xin.tianchuang.modules.spider.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 湖南省企业名录
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:17
 */
@TableName("hn_enterprise_info")
public class HnEnterpriseInfoEntity implements Serializable {
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
	private String esdate;
	/**
	 * 注册资本
	 */
	private String regcap;
	/**
	 * 入园时间
	 */
	private String entrydate;
	/**
	 * 创建时间
	 */
	 @TableField(value = "createtime", fill = FieldFill.INSERT)
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
	public void setEsdate(String esdate) {
		this.esdate = esdate;
	}
	/**
	 * 获取：注册日期
	 */
	public String getEsdate() {
		return esdate;
	}
	/**
	 * 设置：注册资本
	 */
	public void setRegcap(String regcap) {
		this.regcap = regcap;
	}
	/**
	 * 获取：注册资本
	 */
	public String getRegcap() {
		return regcap;
	}
	/**
	 * 设置：入园时间
	 */
	public void setEntrydate(String entrydate) {
		this.entrydate = entrydate;
	}
	/**
	 * 获取：入园时间
	 */
	public String getEntrydate() {
		return entrydate;
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
}
