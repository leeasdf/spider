package xin.tianchuang.modules.spider.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * 省发改委-联络员信息(省工商局)
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:19
 */
@TableName("cs_sfgw_aic_contact")
public class CsSfgwAicContactEntity implements Serializable {
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
	 * 工商内置唯一码
	 */
	private String etpsId;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 证件类型
	 */
	private String certype;
	/**
	 * 证件号码
	 */
	private String cerno;
	/**
	 * 固定电话
	 */
	private String fixedtel;
	/**
	 * 移动电话
	 */
	private String mobilephone;
	/**
	 * 电子邮箱
	 */
	private String email;
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
	 * 设置：工商内置唯一码
	 */
	public void setEtpsId(String etpsId) {
		this.etpsId = etpsId;
	}
	/**
	 * 获取：工商内置唯一码
	 */
	public String getEtpsId() {
		return etpsId;
	}
	/**
	 * 设置：姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：姓名
	 */
	public String getName() {
		return name;
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
	 * 设置：固定电话
	 */
	public void setFixedtel(String fixedtel) {
		this.fixedtel = fixedtel;
	}
	/**
	 * 获取：固定电话
	 */
	public String getFixedtel() {
		return fixedtel;
	}
	/**
	 * 设置：移动电话
	 */
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}
	/**
	 * 获取：移动电话
	 */
	public String getMobilephone() {
		return mobilephone;
	}
	/**
	 * 设置：电子邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：电子邮箱
	 */
	public String getEmail() {
		return email;
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
