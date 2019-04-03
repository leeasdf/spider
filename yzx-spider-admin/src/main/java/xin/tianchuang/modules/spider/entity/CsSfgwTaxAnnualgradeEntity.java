package xin.tianchuang.modules.spider.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * 省发改委-年度纳税信用A级纳税人名单(省国税局)
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:19
 */
@TableName("cs_sfgw_tax_annualgrade")
public class CsSfgwTaxAnnualgradeEntity implements Serializable {
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
	 * 纳税人识别号
	 */
	private String nsrsbh;
	/**
	 * 纳税人名称
	 */
	private String nsrmc;
	/**
	 * 评价年度
	 */
	private String pjnd;
	/**
	 * 主管税务机关
	 */
	private String zgswjg;
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
	 * 设置：纳税人识别号
	 */
	public void setNsrsbh(String nsrsbh) {
		this.nsrsbh = nsrsbh;
	}
	/**
	 * 获取：纳税人识别号
	 */
	public String getNsrsbh() {
		return nsrsbh;
	}
	/**
	 * 设置：纳税人名称
	 */
	public void setNsrmc(String nsrmc) {
		this.nsrmc = nsrmc;
	}
	/**
	 * 获取：纳税人名称
	 */
	public String getNsrmc() {
		return nsrmc;
	}
	/**
	 * 设置：评价年度
	 */
	public void setPjnd(String pjnd) {
		this.pjnd = pjnd;
	}
	/**
	 * 获取：评价年度
	 */
	public String getPjnd() {
		return pjnd;
	}
	/**
	 * 设置：主管税务机关
	 */
	public void setZgswjg(String zgswjg) {
		this.zgswjg = zgswjg;
	}
	/**
	 * 获取：主管税务机关
	 */
	public String getZgswjg() {
		return zgswjg;
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
