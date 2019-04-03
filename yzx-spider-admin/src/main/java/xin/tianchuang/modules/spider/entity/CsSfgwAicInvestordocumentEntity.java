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
 * 省发改委-企业股东信息(省工商局)
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:19
 */
@TableName("cs_sfgw_aic_investordocument")
public class CsSfgwAicInvestordocumentEntity implements Serializable {
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
	private Integer invtNo;
	/**
	 * 企业信息外键
	 */
	private String etpsId;
	/**
	 * 投资者类型
	 */
	private String invtype;
	/**
	 * 自然人姓名
	 */
	private String name;
	/**
	 * 自然人证件类型
	 */
	private String certype;
	/**
	 * 自然人证件号码
	 */
	private String cerno;
	/**
	 * 企业名称
	 */
	private String entname;
	/**
	 * 证照类型
	 */
	private String blictype;
	/**
	 * 证照号码
	 */
	private String blicno;
	/**
	 * 认缴出资金额
	 */
	private BigDecimal subconam;
	/**
	 * 认缴出资时间
	 */
	private Date condate;
	/**
	 * 认缴出资方式
	 */
	private String conform;
	/**
	 * 认缴出资比例
	 */
	private BigDecimal subconprop;
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
	public void setInvtNo(Integer invtNo) {
		this.invtNo = invtNo;
	}
	/**
	 * 获取：工商内置唯一码
	 */
	public Integer getInvtNo() {
		return invtNo;
	}
	/**
	 * 设置：企业信息外键
	 */
	public void setEtpsId(String etpsId) {
		this.etpsId = etpsId;
	}
	/**
	 * 获取：企业信息外键
	 */
	public String getEtpsId() {
		return etpsId;
	}
	/**
	 * 设置：投资者类型
	 */
	public void setInvtype(String invtype) {
		this.invtype = invtype;
	}
	/**
	 * 获取：投资者类型
	 */
	public String getInvtype() {
		return invtype;
	}
	/**
	 * 设置：自然人姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：自然人姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：自然人证件类型
	 */
	public void setCertype(String certype) {
		this.certype = certype;
	}
	/**
	 * 获取：自然人证件类型
	 */
	public String getCertype() {
		return certype;
	}
	/**
	 * 设置：自然人证件号码
	 */
	public void setCerno(String cerno) {
		this.cerno = cerno;
	}
	/**
	 * 获取：自然人证件号码
	 */
	public String getCerno() {
		return cerno;
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
	 * 设置：证照类型
	 */
	public void setBlictype(String blictype) {
		this.blictype = blictype;
	}
	/**
	 * 获取：证照类型
	 */
	public String getBlictype() {
		return blictype;
	}
	/**
	 * 设置：证照号码
	 */
	public void setBlicno(String blicno) {
		this.blicno = blicno;
	}
	/**
	 * 获取：证照号码
	 */
	public String getBlicno() {
		return blicno;
	}
	/**
	 * 设置：认缴出资金额
	 */
	public void setSubconam(BigDecimal subconam) {
		this.subconam = subconam;
	}
	/**
	 * 获取：认缴出资金额
	 */
	public BigDecimal getSubconam() {
		return subconam;
	}
	/**
	 * 设置：认缴出资时间
	 */
	public void setCondate(Date condate) {
		this.condate = condate;
	}
	/**
	 * 获取：认缴出资时间
	 */
	public Date getCondate() {
		return condate;
	}
	/**
	 * 设置：认缴出资方式
	 */
	public void setConform(String conform) {
		this.conform = conform;
	}
	/**
	 * 获取：认缴出资方式
	 */
	public String getConform() {
		return conform;
	}
	/**
	 * 设置：认缴出资比例
	 */
	public void setSubconprop(BigDecimal subconprop) {
		this.subconprop = subconprop;
	}
	/**
	 * 获取：认缴出资比例
	 */
	public BigDecimal getSubconprop() {
		return subconprop;
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
