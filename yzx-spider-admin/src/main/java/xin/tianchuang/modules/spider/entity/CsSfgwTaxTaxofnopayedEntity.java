package xin.tianchuang.modules.spider.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * 省发改委-纳税企业欠税信息(省国税局)
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:19
 */
@TableName("cs_sfgw_tax_taxofnopayed")
public class CsSfgwTaxTaxofnopayedEntity implements Serializable {
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
	 * 组织机构代码
	 */
	private String organizationcode;
	/**
	 * 企业名称
	 */
	private String corporationname;
	/**
	 * 欠税余额（元）
	 */
	private Float taxbalance;
	/**
	 * 截止日期
	 */
	private String enddate;
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
	 * 设置：欠税余额（元）
	 */
	public void setTaxbalance(Float taxbalance) {
		this.taxbalance = taxbalance;
	}
	/**
	 * 获取：欠税余额（元）
	 */
	public Float getTaxbalance() {
		return taxbalance;
	}
	/**
	 * 设置：截止日期
	 */
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	/**
	 * 获取：截止日期
	 */
	public String getEnddate() {
		return enddate;
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
