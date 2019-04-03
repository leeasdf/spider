package xin.tianchuang.modules.spider.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * 省发改委-企业经营异常详细信息(省工商局)
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:19
 */
@TableName("cs_sfgw_aic_e_jyycmlxx")
public class CsSfgwAicEJyycmlxxEntity implements Serializable {
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
	 * 经营异常名录ID
	 */
	private String busexclist;
	/**
	 * 主体身份代码
	 */
	private String pripid;
	/**
	 * 企业名称
	 */
	private String entname;
	/**
	 * 统一社会信用代码
	 */
	private String uniscid;
	/**
	 * 注册号
	 */
	private String regno;
	/**
	 * 法定代表人
	 */
	private String lerep;
	/**
	 * 证件类型
	 */
	private String certype;
	/**
	 * 证件号码
	 */
	private String cerno;
	/**
	 * 列入经营异常名录原因类型
	 */
	private String specause;
	/**
	 * 列入经营异常名录原因类型名称
	 */
	private String specausename;
	/**
	 * 列入日期
	 */
	private Date abntime;
	/**
	 * 列入决定机关
	 */
	private String decorg;
	/**
	 * 列入决定机关名称
	 */
	private String decorgname;
	/**
	 * 是否移出
	 */
	private String ismove;
	/**
	 * 移出经营异常名录原因
	 */
	private String remexcpres;
	/**
	 * 移出经营异常名录原因名称
	 */
	private String remexcpresname;
	/**
	 * 移出日期
	 */
	private Date remdate;
	/**
	 * 移出决定机关
	 */
	private String ycdecorg;
	/**
	 * 移出决定机关名称
	 */
	private String ycdecorgname;
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
	 * 设置：经营异常名录ID
	 */
	public void setBusexclist(String busexclist) {
		this.busexclist = busexclist;
	}
	/**
	 * 获取：经营异常名录ID
	 */
	public String getBusexclist() {
		return busexclist;
	}
	/**
	 * 设置：主体身份代码
	 */
	public void setPripid(String pripid) {
		this.pripid = pripid;
	}
	/**
	 * 获取：主体身份代码
	 */
	public String getPripid() {
		return pripid;
	}
	/**
	 * 设置：企业名称
	 */
	public void setEntname(String entname) {
		this.entname = entname;
	}
	/**
	 * 获取：企业名称
	 */
	public String getEntname() {
		return entname;
	}
	/**
	 * 设置：统一社会信用代码
	 */
	public void setUniscid(String uniscid) {
		this.uniscid = uniscid;
	}
	/**
	 * 获取：统一社会信用代码
	 */
	public String getUniscid() {
		return uniscid;
	}
	/**
	 * 设置：注册号
	 */
	public void setRegno(String regno) {
		this.regno = regno;
	}
	/**
	 * 获取：注册号
	 */
	public String getRegno() {
		return regno;
	}
	/**
	 * 设置：法定代表人
	 */
	public void setLerep(String lerep) {
		this.lerep = lerep;
	}
	/**
	 * 获取：法定代表人
	 */
	public String getLerep() {
		return lerep;
	}
	/**
	 * 设置：证件类型
	 */
	public void setCertype(String certype) {
		this.certype = certype;
	}
	/**
	 * 获取：证件类型
	 */
	public String getCertype() {
		return certype;
	}
	/**
	 * 设置：证件号码
	 */
	public void setCerno(String cerno) {
		this.cerno = cerno;
	}
	/**
	 * 获取：证件号码
	 */
	public String getCerno() {
		return cerno;
	}
	/**
	 * 设置：列入经营异常名录原因类型
	 */
	public void setSpecause(String specause) {
		this.specause = specause;
	}
	/**
	 * 获取：列入经营异常名录原因类型
	 */
	public String getSpecause() {
		return specause;
	}
	/**
	 * 设置：列入经营异常名录原因类型名称
	 */
	public void setSpecausename(String specausename) {
		this.specausename = specausename;
	}
	/**
	 * 获取：列入经营异常名录原因类型名称
	 */
	public String getSpecausename() {
		return specausename;
	}
	/**
	 * 设置：列入日期
	 */
	public void setAbntime(Date abntime) {
		this.abntime = abntime;
	}
	/**
	 * 获取：列入日期
	 */
	public Date getAbntime() {
		return abntime;
	}
	/**
	 * 设置：列入决定机关
	 */
	public void setDecorg(String decorg) {
		this.decorg = decorg;
	}
	/**
	 * 获取：列入决定机关
	 */
	public String getDecorg() {
		return decorg;
	}
	/**
	 * 设置：列入决定机关名称
	 */
	public void setDecorgname(String decorgname) {
		this.decorgname = decorgname;
	}
	/**
	 * 获取：列入决定机关名称
	 */
	public String getDecorgname() {
		return decorgname;
	}
	/**
	 * 设置：是否移出
	 */
	public void setIsmove(String ismove) {
		this.ismove = ismove;
	}
	/**
	 * 获取：是否移出
	 */
	public String getIsmove() {
		return ismove;
	}
	/**
	 * 设置：移出经营异常名录原因
	 */
	public void setRemexcpres(String remexcpres) {
		this.remexcpres = remexcpres;
	}
	/**
	 * 获取：移出经营异常名录原因
	 */
	public String getRemexcpres() {
		return remexcpres;
	}
	/**
	 * 设置：移出经营异常名录原因名称
	 */
	public void setRemexcpresname(String remexcpresname) {
		this.remexcpresname = remexcpresname;
	}
	/**
	 * 获取：移出经营异常名录原因名称
	 */
	public String getRemexcpresname() {
		return remexcpresname;
	}
	/**
	 * 设置：移出日期
	 */
	public void setRemdate(Date remdate) {
		this.remdate = remdate;
	}
	/**
	 * 获取：移出日期
	 */
	public Date getRemdate() {
		return remdate;
	}
	/**
	 * 设置：移出决定机关
	 */
	public void setYcdecorg(String ycdecorg) {
		this.ycdecorg = ycdecorg;
	}
	/**
	 * 获取：移出决定机关
	 */
	public String getYcdecorg() {
		return ycdecorg;
	}
	/**
	 * 设置：移出决定机关名称
	 */
	public void setYcdecorgname(String ycdecorgname) {
		this.ycdecorgname = ycdecorgname;
	}
	/**
	 * 获取：移出决定机关名称
	 */
	public String getYcdecorgname() {
		return ycdecorgname;
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
