package xin.tianchuang.modules.spider.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * 省发改委-强制性清洁生产审核(省环保厅)
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:19
 */
@TableName("cs_sfgw_hbt_ccproductionaudit")
public class CsSfgwHbtCcproductionauditEntity implements Serializable {
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
	 * 企业名称
	 */
	private String corporationname;
	/**
	 * 组织机构代码
	 */
	private String organizationcode;
	/**
	 * 注册所在地
	 */
	private String placeofregistration;
	/**
	 * 企业性质
	 */
	private String nature;
	/**
	 * 所属行业
	 */
	private String industry;
	/**
	 * 名单发布机关
	 */
	private String releasemechanism;
	/**
	 * 名单发布日期
	 */
	private String releasedate;
	/**
	 * 文号
	 */
	private String documentnumber;
	/**
	 * 强制执行时限
	 */
	private String executiontimelimit;
	/**
	 * 提交审核报告时间
	 */
	private String auditdate;
	/**
	 * 完成验收时间
	 */
	private String completedacceptancetime;
	/**
	 * 完成评估时间
	 */
	private String finishtime;
	/**
	 * 审核机构名称
	 */
	private String auditorganizationname;
	/**
	 * 验收证明材料
	 */
	private String acceptanceproofmaterial;
	/**
	 * 最近一轮清洁生产审核时段
	 */
	private String productionaudit;
	/**
	 * 上轮清洁生产验收时间
	 */
	private String praccetime;
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
	 * 设置：企业名称
	 */
	public void setCorporationname(String corporationname) {
		this.corporationname = corporationname;
	}
	/**
	 * 获取：企业名称
	 */
	public String getCorporationname() {
		return corporationname;
	}
	/**
	 * 设置：组织机构代码
	 */
	public void setOrganizationcode(String organizationcode) {
		this.organizationcode = organizationcode;
	}
	/**
	 * 获取：组织机构代码
	 */
	public String getOrganizationcode() {
		return organizationcode;
	}
	/**
	 * 设置：注册所在地
	 */
	public void setPlaceofregistration(String placeofregistration) {
		this.placeofregistration = placeofregistration;
	}
	/**
	 * 获取：注册所在地
	 */
	public String getPlaceofregistration() {
		return placeofregistration;
	}
	/**
	 * 设置：企业性质
	 */
	public void setNature(String nature) {
		this.nature = nature;
	}
	/**
	 * 获取：企业性质
	 */
	public String getNature() {
		return nature;
	}
	/**
	 * 设置：所属行业
	 */
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	/**
	 * 获取：所属行业
	 */
	public String getIndustry() {
		return industry;
	}
	/**
	 * 设置：名单发布机关
	 */
	public void setReleasemechanism(String releasemechanism) {
		this.releasemechanism = releasemechanism;
	}
	/**
	 * 获取：名单发布机关
	 */
	public String getReleasemechanism() {
		return releasemechanism;
	}
	/**
	 * 设置：名单发布日期
	 */
	public void setReleasedate(String releasedate) {
		this.releasedate = releasedate;
	}
	/**
	 * 获取：名单发布日期
	 */
	public String getReleasedate() {
		return releasedate;
	}
	/**
	 * 设置：文号
	 */
	public void setDocumentnumber(String documentnumber) {
		this.documentnumber = documentnumber;
	}
	/**
	 * 获取：文号
	 */
	public String getDocumentnumber() {
		return documentnumber;
	}
	/**
	 * 设置：强制执行时限
	 */
	public void setExecutiontimelimit(String executiontimelimit) {
		this.executiontimelimit = executiontimelimit;
	}
	/**
	 * 获取：强制执行时限
	 */
	public String getExecutiontimelimit() {
		return executiontimelimit;
	}
	/**
	 * 设置：提交审核报告时间
	 */
	public void setAuditdate(String auditdate) {
		this.auditdate = auditdate;
	}
	/**
	 * 获取：提交审核报告时间
	 */
	public String getAuditdate() {
		return auditdate;
	}
	/**
	 * 设置：完成验收时间
	 */
	public void setCompletedacceptancetime(String completedacceptancetime) {
		this.completedacceptancetime = completedacceptancetime;
	}
	/**
	 * 获取：完成验收时间
	 */
	public String getCompletedacceptancetime() {
		return completedacceptancetime;
	}
	/**
	 * 设置：完成评估时间
	 */
	public void setFinishtime(String finishtime) {
		this.finishtime = finishtime;
	}
	/**
	 * 获取：完成评估时间
	 */
	public String getFinishtime() {
		return finishtime;
	}
	/**
	 * 设置：审核机构名称
	 */
	public void setAuditorganizationname(String auditorganizationname) {
		this.auditorganizationname = auditorganizationname;
	}
	/**
	 * 获取：审核机构名称
	 */
	public String getAuditorganizationname() {
		return auditorganizationname;
	}
	/**
	 * 设置：验收证明材料
	 */
	public void setAcceptanceproofmaterial(String acceptanceproofmaterial) {
		this.acceptanceproofmaterial = acceptanceproofmaterial;
	}
	/**
	 * 获取：验收证明材料
	 */
	public String getAcceptanceproofmaterial() {
		return acceptanceproofmaterial;
	}
	/**
	 * 设置：最近一轮清洁生产审核时段
	 */
	public void setProductionaudit(String productionaudit) {
		this.productionaudit = productionaudit;
	}
	/**
	 * 获取：最近一轮清洁生产审核时段
	 */
	public String getProductionaudit() {
		return productionaudit;
	}
	/**
	 * 设置：上轮清洁生产验收时间
	 */
	public void setPraccetime(String praccetime) {
		this.praccetime = praccetime;
	}
	/**
	 * 获取：上轮清洁生产验收时间
	 */
	public String getPraccetime() {
		return praccetime;
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
