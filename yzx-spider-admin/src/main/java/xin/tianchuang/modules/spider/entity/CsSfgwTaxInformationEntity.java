package xin.tianchuang.modules.spider.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * 省发改委-欠缴税信息(省国税局)
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:19
 */
@TableName("cs_sfgw_tax_information")
public class CsSfgwTaxInformationEntity implements Serializable {
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
	 * 标题
	 */
	private String bt;
	/**
	 * 纳税人名称
	 */
	private String nsrmc;
	/**
	 * 纳税识别号
	 */
	private String nssbh;
	/**
	 * 法定代表人
	 */
	private String fddbr;
	/**
	 * 身份证号码
	 */
	private String sfzhm;
	/**
	 * 经营地址
	 */
	private String jydz;
	/**
	 * 欠税税种
	 */
	private String qssz;
	/**
	 * 欠税余额
	 */
	private String qsye;
	/**
	 * 本年新发生欠款
	 */
	private String bnxfsqk;
	/**
	 * 内容
	 */
	private String nr;
	/**
	 * 时间
	 */
	private String sj;
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
	 * 设置：标题
	 */
	public void setBt(String bt) {
		this.bt = bt;
	}
	/**
	 * 获取：标题
	 */
	public String getBt() {
		return bt;
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
	 * 设置：纳税识别号
	 */
	public void setNssbh(String nssbh) {
		this.nssbh = nssbh;
	}
	/**
	 * 获取：纳税识别号
	 */
	public String getNssbh() {
		return nssbh;
	}
	/**
	 * 设置：法定代表人
	 */
	public void setFddbr(String fddbr) {
		this.fddbr = fddbr;
	}
	/**
	 * 获取：法定代表人
	 */
	public String getFddbr() {
		return fddbr;
	}
	/**
	 * 设置：身份证号码
	 */
	public void setSfzhm(String sfzhm) {
		this.sfzhm = sfzhm;
	}
	/**
	 * 获取：身份证号码
	 */
	public String getSfzhm() {
		return sfzhm;
	}
	/**
	 * 设置：经营地址
	 */
	public void setJydz(String jydz) {
		this.jydz = jydz;
	}
	/**
	 * 获取：经营地址
	 */
	public String getJydz() {
		return jydz;
	}
	/**
	 * 设置：欠税税种
	 */
	public void setQssz(String qssz) {
		this.qssz = qssz;
	}
	/**
	 * 获取：欠税税种
	 */
	public String getQssz() {
		return qssz;
	}
	/**
	 * 设置：欠税余额
	 */
	public void setQsye(String qsye) {
		this.qsye = qsye;
	}
	/**
	 * 获取：欠税余额
	 */
	public String getQsye() {
		return qsye;
	}
	/**
	 * 设置：本年新发生欠款
	 */
	public void setBnxfsqk(String bnxfsqk) {
		this.bnxfsqk = bnxfsqk;
	}
	/**
	 * 获取：本年新发生欠款
	 */
	public String getBnxfsqk() {
		return bnxfsqk;
	}
	/**
	 * 设置：内容
	 */
	public void setNr(String nr) {
		this.nr = nr;
	}
	/**
	 * 获取：内容
	 */
	public String getNr() {
		return nr;
	}
	/**
	 * 设置：时间
	 */
	public void setSj(String sj) {
		this.sj = sj;
	}
	/**
	 * 获取：时间
	 */
	public String getSj() {
		return sj;
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
