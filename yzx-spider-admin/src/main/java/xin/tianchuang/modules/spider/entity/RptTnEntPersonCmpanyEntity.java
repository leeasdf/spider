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
 * 所有公司
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:22
 */
@TableName("rpt_tn_ent_person_cmpany")
public class RptTnEntPersonCmpanyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 个人ID
	 */
	private String personid;
	/**
	 * 姓名
	 */
	private String personname;
	/**
	 * 角色
	 */
	private String role;
	/**
	 * 省份地址
	 */
	private String province;
	/**
	 * 公司名
	 */
	private String cmpname;
	/**
	 * 开业日期
	 */
	private String opendate;
	/**
	 * 经营状态
	 */
	private String status;
	/**
	 * 注册资本
	 */
	private String regcap;
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
	 * 设置：个人ID
	 */
	public void setPersonid(String personid) {
		this.personid = personid;
	}
	/**
	 * 获取：个人ID
	 */
	public String getPersonid() {
		return personid;
	}
	/**
	 * 设置：姓名
	 */
	public void setPersonname(String personname) {
		this.personname = personname;
	}
	/**
	 * 获取：姓名
	 */
	public String getPersonname() {
		return personname;
	}
	/**
	 * 设置：角色
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * 获取：角色
	 */
	public String getRole() {
		return role;
	}
	/**
	 * 设置：省份地址
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取：省份地址
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 设置：公司名
	 */
	public void setCmpname(String cmpname) {
		this.cmpname = cmpname;
	}
	/**
	 * 获取：公司名
	 */
	public String getCmpname() {
		return cmpname;
	}
	/**
	 * 设置：开业日期
	 */
	public void setOpendate(String opendate) {
		this.opendate = opendate;
	}
	/**
	 * 获取：开业日期
	 */
	public String getOpendate() {
		return opendate;
	}
	/**
	 * 设置：经营状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：经营状态
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：注册资本
	 */
	public void setRegcap(String regcap) {
		this.regcap = regcap;
	}
	/**
	 * 获取：注册资本
	 */
	public String getRegcap() {
		return regcap;
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
