package xin.tianchuang.modules.spider.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * 省发改委-逾期未办理税务登记信息(省地税局)
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:18
 */
@TableName("cs_sfgw_ds_overduenohandletax")
public class CsSfgwDsOverduenohandletaxEntity implements Serializable {
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
	 * 纳税人名称
	 */
	private String nsrmc;
	/**
	 * 行政相对人代码_1（统一社会信用代码）
	 */
	private String xkXdrShxym;
	/**
	 * 行政相对人代码_2（组织机构代码）
	 */
	private String xkXdrZdm;
	/**
	 * 行政相对人代码_3（工商登记码）
	 */
	private String xkXdrGsdj;
	/**
	 * 行政相对人代码_4（税务登记号）
	 */
	private String xkXdrSwdj;
	/**
	 * 行政相对人代码_5（居民身份证号）
	 */
	private String xkXdrSfz;
	/**
	 * 法定代表人
	 */
	private String fddbrxm;
	/**
	 * 法定代表人身份证件号
	 */
	private String fddbrsfzjhm;
	/**
	 * 责令限期改正日期
	 */
	private String gzrq;
	/**
	 * 数据更新时间戳
	 */
	private String sjc;
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
	 * 设置：行政相对人代码_1（统一社会信用代码）
	 */
	public void setXkXdrShxym(String xkXdrShxym) {
		this.xkXdrShxym = xkXdrShxym;
	}
	/**
	 * 获取：行政相对人代码_1（统一社会信用代码）
	 */
	public String getXkXdrShxym() {
		return xkXdrShxym;
	}
	/**
	 * 设置：行政相对人代码_2（组织机构代码）
	 */
	public void setXkXdrZdm(String xkXdrZdm) {
		this.xkXdrZdm = xkXdrZdm;
	}
	/**
	 * 获取：行政相对人代码_2（组织机构代码）
	 */
	public String getXkXdrZdm() {
		return xkXdrZdm;
	}
	/**
	 * 设置：行政相对人代码_3（工商登记码）
	 */
	public void setXkXdrGsdj(String xkXdrGsdj) {
		this.xkXdrGsdj = xkXdrGsdj;
	}
	/**
	 * 获取：行政相对人代码_3（工商登记码）
	 */
	public String getXkXdrGsdj() {
		return xkXdrGsdj;
	}
	/**
	 * 设置：行政相对人代码_4（税务登记号）
	 */
	public void setXkXdrSwdj(String xkXdrSwdj) {
		this.xkXdrSwdj = xkXdrSwdj;
	}
	/**
	 * 获取：行政相对人代码_4（税务登记号）
	 */
	public String getXkXdrSwdj() {
		return xkXdrSwdj;
	}
	/**
	 * 设置：行政相对人代码_5（居民身份证号）
	 */
	public void setXkXdrSfz(String xkXdrSfz) {
		this.xkXdrSfz = xkXdrSfz;
	}
	/**
	 * 获取：行政相对人代码_5（居民身份证号）
	 */
	public String getXkXdrSfz() {
		return xkXdrSfz;
	}
	/**
	 * 设置：法定代表人
	 */
	public void setFddbrxm(String fddbrxm) {
		this.fddbrxm = fddbrxm;
	}
	/**
	 * 获取：法定代表人
	 */
	public String getFddbrxm() {
		return fddbrxm;
	}
	/**
	 * 设置：法定代表人身份证件号
	 */
	public void setFddbrsfzjhm(String fddbrsfzjhm) {
		this.fddbrsfzjhm = fddbrsfzjhm;
	}
	/**
	 * 获取：法定代表人身份证件号
	 */
	public String getFddbrsfzjhm() {
		return fddbrsfzjhm;
	}
	/**
	 * 设置：责令限期改正日期
	 */
	public void setGzrq(String gzrq) {
		this.gzrq = gzrq;
	}
	/**
	 * 获取：责令限期改正日期
	 */
	public String getGzrq() {
		return gzrq;
	}
	/**
	 * 设置：数据更新时间戳
	 */
	public void setSjc(String sjc) {
		this.sjc = sjc;
	}
	/**
	 * 获取：数据更新时间戳
	 */
	public String getSjc() {
		return sjc;
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
