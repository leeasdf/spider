package xin.tianchuang.modules.spider.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * 省发改委-排污许可证信息(省环保厅)
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:19
 */
@TableName("cs_sfgw_hbt_epinformation")
public class CsSfgwHbtEpinformationEntity implements Serializable {
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
	 * 排污许可证编号
	 */
	private String license;
	/**
	 * 排污许可证类型
	 */
	private String type;
	/**
	 * 发证机关名称
	 */
	private String issuingauthority;
	/**
	 * 有效期
	 */
	private String periodofvalidity;
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
	 * 设置：排污许可证编号
	 */
	public void setLicense(String license) {
		this.license = license;
	}
	/**
	 * 获取：排污许可证编号
	 */
	public String getLicense() {
		return license;
	}
	/**
	 * 设置：排污许可证类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：排污许可证类型
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：发证机关名称
	 */
	public void setIssuingauthority(String issuingauthority) {
		this.issuingauthority = issuingauthority;
	}
	/**
	 * 获取：发证机关名称
	 */
	public String getIssuingauthority() {
		return issuingauthority;
	}
	/**
	 * 设置：有效期
	 */
	public void setPeriodofvalidity(String periodofvalidity) {
		this.periodofvalidity = periodofvalidity;
	}
	/**
	 * 获取：有效期
	 */
	public String getPeriodofvalidity() {
		return periodofvalidity;
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
