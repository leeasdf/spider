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
 * 软件著作人详情信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:20
 */
@TableName("rpt_tn_software_right_author")
public class RptTnSoftwareRightAuthorEntity implements Serializable {
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
	private String entAme;
	/**
	 * 软件全称
	 */
	private String fullname;
	/**
	 * 软件简称
	 */
	private String simplename;
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
	 * 著作权人(国籍)
	 */
	private String authorNationality;
	/**
	 * 首次发表日期
	 */
	private String publishtime;
	/**
	 * 登记日期
	 */
	private String regtime;
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
	public void setEntAme(String entAme) {
		this.entAme = entAme;
	}
	/**
	 * 获取：企业名称
	 */
	public String getEntAme() {
		return entAme;
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
	public void setSimplename(String simplename) {
		this.simplename = simplename;
	}
	/**
	 * 获取：软件简称
	 */
	public String getSimplename() {
		return simplename;
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
	 * 设置：著作权人(国籍)
	 */
	public void setAuthorNationality(String authorNationality) {
		this.authorNationality = authorNationality;
	}
	/**
	 * 获取：著作权人(国籍)
	 */
	public String getAuthorNationality() {
		return authorNationality;
	}
	/**
	 * 设置：首次发表日期
	 */
	public void setPublishtime(String publishtime) {
		this.publishtime = publishtime;
	}
	/**
	 * 获取：首次发表日期
	 */
	public String getPublishtime() {
		return publishtime;
	}
	/**
	 * 设置：登记日期
	 */
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	/**
	 * 获取：登记日期
	 */
	public String getRegtime() {
		return regtime;
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
