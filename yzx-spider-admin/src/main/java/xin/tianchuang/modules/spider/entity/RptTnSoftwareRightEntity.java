package xin.tianchuang.modules.spider.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 软件著作权信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:20
 */
@TableName("rpt_tn_software_right")
public class RptTnSoftwareRightEntity implements Serializable {
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
	 * 企业名称
	 */
	private String entName;
	/**
	 * 批准日期
	 */
	private String appDate;
	/**
	 * 软件全称
	 */
	private String fullname;
	/**
	 * 软件简称
	 */
	private String simpleName;
	/**
	 * 登记号
	 */
	private String regnum;
	/**
	 * 分类号
	 */
	private String catnum;
	/**
	 * 版本号
	 */
	private String version;
	/**
	 * 著作详情信息
	 */
	private String author;
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
	 * 设置：企业名称
	 */
	public void setEntName(String entName) {
		this.entName = entName;
	}
	/**
	 * 获取：企业名称
	 */
	public String getEntName() {
		return entName;
	}
	/**
	 * 设置：批准日期
	 */
	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}
	/**
	 * 获取：批准日期
	 */
	public String getAppDate() {
		return appDate;
	}
	/**
	 * 设置：软件全称
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	/**
	 * 获取：软件全称
	 */
	public String getFullname() {
		return fullname;
	}
	/**
	 * 设置：软件简称
	 */
	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}
	/**
	 * 获取：软件简称
	 */
	public String getSimpleName() {
		return simpleName;
	}
	/**
	 * 设置：登记号
	 */
	public void setRegnum(String regnum) {
		this.regnum = regnum;
	}
	/**
	 * 获取：登记号
	 */
	public String getRegnum() {
		return regnum;
	}
	/**
	 * 设置：分类号
	 */
	public void setCatnum(String catnum) {
		this.catnum = catnum;
	}
	/**
	 * 获取：分类号
	 */
	public String getCatnum() {
		return catnum;
	}
	/**
	 * 设置：版本号
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * 获取：版本号
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * 设置：著作详情信息
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * 获取：著作详情信息
	 */
	public String getAuthor() {
		return author;
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
