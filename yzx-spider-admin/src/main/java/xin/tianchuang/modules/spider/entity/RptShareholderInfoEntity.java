package xin.tianchuang.modules.spider.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * 信用麓谷-企业股东信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:17
 */
@TableName("rpt_shareholder_info")
public class RptShareholderInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 会员ID
	 */
	private Integer memId;
	/**
	 * 企业ID
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long enterpriseId;
	/**
	 * 股东名称
	 */
	private String shaname;
	/**
	 * 实缴资本
	 */
	private String subconam;
	/**
	 * 认缴出资币种
	 */
	private String regcapcur;
	/**
	 * 出资方式
	 */
	private String conform;
	/**
	 * 出资比例
	 */
	private String fundedratio;
	/**
	 * 出资日期
	 */
	private String condate;
	/**
	 * 国别
	 */
	private String country;
	/**
	 * 股东总数量
	 */
	private String invamount;
	/**
	 * 股东出资比例总和
	 */
	private String invsumfundedratio;
	/**
	 * 创建人ID
	 */
	private Integer creator;
	/**
	 * 创建时间
	 */
	  @TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;
	/**
	 * 修改人ID
	 */
	private Integer updater;
	/**
	 * 修改时间
	 */
		 @TableField(value = "update_time", fill = FieldFill.UPDATE)
	private Date updateTime;
	/**
	 * 数据状态：1-正常 0-删除
	 */
	@TableField(value = "data_state", fill = FieldFill.INSERT)
private Integer dataState;

	/**
	 * 设置：主键
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：会员ID
	 */
	public void setMemId(Integer memId) {
		this.memId = memId;
	}
	/**
	 * 获取：会员ID
	 */
	public Integer getMemId() {
		return memId;
	}
	/**
	 * 设置：企业ID
	 */
	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	/**
	 * 获取：企业ID
	 */
	public Long getEnterpriseId() {
		return enterpriseId;
	}
	/**
	 * 设置：股东名称
	 */
	public void setShaname(String shaname) {
		this.shaname = shaname;
	}
	/**
	 * 获取：股东名称
	 */
	public String getShaname() {
		return shaname;
	}
	/**
	 * 设置：实缴资本
	 */
	public void setSubconam(String subconam) {
		this.subconam = subconam;
	}
	/**
	 * 获取：实缴资本
	 */
	public String getSubconam() {
		return subconam;
	}
	/**
	 * 设置：认缴出资币种
	 */
	public void setRegcapcur(String regcapcur) {
		this.regcapcur = regcapcur;
	}
	/**
	 * 获取：认缴出资币种
	 */
	public String getRegcapcur() {
		return regcapcur;
	}
	/**
	 * 设置：出资方式
	 */
	public void setConform(String conform) {
		this.conform = conform;
	}
	/**
	 * 获取：出资方式
	 */
	public String getConform() {
		return conform;
	}
	/**
	 * 设置：出资比例
	 */
	public void setFundedratio(String fundedratio) {
		this.fundedratio = fundedratio;
	}
	/**
	 * 获取：出资比例
	 */
	public String getFundedratio() {
		return fundedratio;
	}
	/**
	 * 设置：出资日期
	 */
	public void setCondate(String condate) {
		this.condate = condate;
	}
	/**
	 * 获取：出资日期
	 */
	public String getCondate() {
		return condate;
	}
	/**
	 * 设置：国别
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * 获取：国别
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * 设置：股东总数量
	 */
	public void setInvamount(String invamount) {
		this.invamount = invamount;
	}
	/**
	 * 获取：股东总数量
	 */
	public String getInvamount() {
		return invamount;
	}
	/**
	 * 设置：股东出资比例总和
	 */
	public void setInvsumfundedratio(String invsumfundedratio) {
		this.invsumfundedratio = invsumfundedratio;
	}
	/**
	 * 获取：股东出资比例总和
	 */
	public String getInvsumfundedratio() {
		return invsumfundedratio;
	}
	/**
	 * 设置：创建人ID
	 */
	public void setCreator(Integer creator) {
		this.creator = creator;
	}
	/**
	 * 获取：创建人ID
	 */
	public Integer getCreator() {
		return creator;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：修改人ID
	 */
	public void setUpdater(Integer updater) {
		this.updater = updater;
	}
	/**
	 * 获取：修改人ID
	 */
	public Integer getUpdater() {
		return updater;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：数据状态：1-正常 0-删除
	 */
	public void setDataState(Integer dataState) {
		this.dataState = dataState;
	}
	/**
	 * 获取：数据状态：1-正常 0-删除
	 */
	public Integer getDataState() {
		return dataState;
	}
}
