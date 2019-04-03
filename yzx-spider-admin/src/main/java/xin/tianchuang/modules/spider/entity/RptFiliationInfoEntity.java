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
 * 信用麓谷-分支机构
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:18
 */
@TableName("rpt_filiation_info")
public class RptFiliationInfoEntity implements Serializable {
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
	 * 分支机构名称
	 */
	private String brname;
	/**
	 * 分支机构企业注册号
	 */
	private String brregno;
	/**
	 * 分支机构负责人
	 */
	private String brprincipal;
	/**
	 * 一般经营项目
	 */
	private String cbuitem;
	/**
	 * 分支机构地址
	 */
	private String braddr;
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
	 * 设置：分支机构名称
	 */
	public void setBrname(String brname) {
		this.brname = brname;
	}
	/**
	 * 获取：分支机构名称
	 */
	public String getBrname() {
		return brname;
	}
	/**
	 * 设置：分支机构企业注册号
	 */
	public void setBrregno(String brregno) {
		this.brregno = brregno;
	}
	/**
	 * 获取：分支机构企业注册号
	 */
	public String getBrregno() {
		return brregno;
	}
	/**
	 * 设置：分支机构负责人
	 */
	public void setBrprincipal(String brprincipal) {
		this.brprincipal = brprincipal;
	}
	/**
	 * 获取：分支机构负责人
	 */
	public String getBrprincipal() {
		return brprincipal;
	}
	/**
	 * 设置：一般经营项目
	 */
	public void setCbuitem(String cbuitem) {
		this.cbuitem = cbuitem;
	}
	/**
	 * 获取：一般经营项目
	 */
	public String getCbuitem() {
		return cbuitem;
	}
	/**
	 * 设置：分支机构地址
	 */
	public void setBraddr(String braddr) {
		this.braddr = braddr;
	}
	/**
	 * 获取：分支机构地址
	 */
	public String getBraddr() {
		return braddr;
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
