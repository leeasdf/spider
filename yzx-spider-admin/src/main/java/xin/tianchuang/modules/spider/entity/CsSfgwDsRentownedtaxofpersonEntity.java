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
 * 省发改委-企业欠税公告信息(省地税局)
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:18
 */
@TableName("cs_sfgw_ds_rentownedtaxofperson")
public class CsSfgwDsRentownedtaxofpersonEntity implements Serializable {
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
	 * 欠税人名称
	 */
	private String nsrmc;
	/**
	 * 欠税人识别号
	 */
	private String nsrsbh;
	/**
	 * 法定代表人（负责人）
	 */
	private String fddbrxm;
	/**
	 * 法定代表人（负责人）身份证件号
	 */
	private String fddbrsfzjhm;
	/**
	 * 欠税余额
	 */
	private BigDecimal qsye;
	/**
	 * 生产经营地址
	 */
	private String scjydz;
	/**
	 * 公告日期
	 */
	private String ggrq;
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
	 * 设置：欠税人名称
	 */
	public void setNsrmc(String nsrmc) {
		this.nsrmc = nsrmc;
	}
	/**
	 * 获取：欠税人名称
	 */
	public String getNsrmc() {
		return nsrmc;
	}
	/**
	 * 设置：欠税人识别号
	 */
	public void setNsrsbh(String nsrsbh) {
		this.nsrsbh = nsrsbh;
	}
	/**
	 * 获取：欠税人识别号
	 */
	public String getNsrsbh() {
		return nsrsbh;
	}
	/**
	 * 设置：法定代表人（负责人）
	 */
	public void setFddbrxm(String fddbrxm) {
		this.fddbrxm = fddbrxm;
	}
	/**
	 * 获取：法定代表人（负责人）
	 */
	public String getFddbrxm() {
		return fddbrxm;
	}
	/**
	 * 设置：法定代表人（负责人）身份证件号
	 */
	public void setFddbrsfzjhm(String fddbrsfzjhm) {
		this.fddbrsfzjhm = fddbrsfzjhm;
	}
	/**
	 * 获取：法定代表人（负责人）身份证件号
	 */
	public String getFddbrsfzjhm() {
		return fddbrsfzjhm;
	}
	/**
	 * 设置：欠税余额
	 */
	public void setQsye(BigDecimal qsye) {
		this.qsye = qsye;
	}
	/**
	 * 获取：欠税余额
	 */
	public BigDecimal getQsye() {
		return qsye;
	}
	/**
	 * 设置：生产经营地址
	 */
	public void setScjydz(String scjydz) {
		this.scjydz = scjydz;
	}
	/**
	 * 获取：生产经营地址
	 */
	public String getScjydz() {
		return scjydz;
	}
	/**
	 * 设置：公告日期
	 */
	public void setGgrq(String ggrq) {
		this.ggrq = ggrq;
	}
	/**
	 * 获取：公告日期
	 */
	public String getGgrq() {
		return ggrq;
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
