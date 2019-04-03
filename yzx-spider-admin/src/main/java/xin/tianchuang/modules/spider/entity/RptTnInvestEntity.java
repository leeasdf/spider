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
 * 对外投资
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:21
 */
@TableName("rpt_tn_invest")
public class RptTnInvestEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 企业主键
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long enterpriseId;
	/**
	 * 企业（机构）名称
	 */
	private String entName;
	/**
	 * 注册时间
	 */
	private String regTime;
	/**
	 * 被投资法定代表人
	 */
	private String legalPerson;
	/**
	 * 注册资本
	 */
	@Deprecated
	private String invAmount;
	/**
	 * 被投资公司名称
	 */
	private String cmpName;
	/**
	 * 投资占比
	 */
	private String invRatio;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 注册资本
	 */
	private String regCap;
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
	 * 天眼查地址
	 */
	private String url;

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
	 * 设置：企业主键
	 */
	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	/**
	 * 获取：企业主键
	 */
	public Long getEnterpriseId() {
		return enterpriseId;
	}
	/**
	 * 设置：企业（机构）名称
	 */
	public void setEntName(String entName) {
		this.entName = entName;
	}
	/**
	 * 获取：企业（机构）名称
	 */
	public String getEntName() {
		return entName;
	}
	/**
	 * 设置：注册时间
	 */
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	/**
	 * 获取：注册时间
	 */
	public String getRegTime() {
		return regTime;
	}
	/**
	 * 设置：被投资法定代表人
	 */
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}
	/**
	 * 获取：被投资法定代表人
	 */
	public String getLegalPerson() {
		return legalPerson;
	}
	/**
	 * 设置：注册资本
	 */
	public void setInvAmount(String invAmount) {
		this.invAmount = invAmount;
	}
	/**
	 * 获取：注册资本
	 */
	public String getInvAmount() {
		return invAmount;
	}
	/**
	 * 设置：被投资公司名称
	 */
	public void setCmpName(String cmpName) {
		this.cmpName = cmpName;
	}
	/**
	 * 获取：被投资公司名称
	 */
	public String getCmpName() {
		return cmpName;
	}
	/**
	 * 设置：投资占比
	 */
	public void setInvRatio(String invRatio) {
		this.invRatio = invRatio;
	}
	/**
	 * 获取：投资占比
	 */
	public String getInvRatio() {
		return invRatio;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：（已废弃）
	 */
	public void setRegCap(String regCap) {
		this.regCap = regCap;
	}
	/**
	 * 获取：（已废弃）
	 */
	public String getRegCap() {
		return regCap;
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
	/**
	 * 设置：天眼查地址
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：天眼查地址
	 */
	public String getUrl() {
		return url;
	}
}
