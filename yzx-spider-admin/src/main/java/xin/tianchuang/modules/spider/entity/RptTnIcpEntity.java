package xin.tianchuang.modules.spider.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 网站备案信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:21
 */
@TableName("rpt_tn_icp")
public class RptTnIcpEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	 //将Long类型系列化成String避免精度丢失
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 企业主键
	 */
	 //将Long类型系列化成String避免精度丢失
	@JsonSerialize(using = ToStringSerializer.class)
	private Long enterpriseId;
	/**
	 * 企业名称
	 */
	private String entName;
	/**
	 * 单位性质
	 */
	private String unitProperties;
	/**
	 * 审核时间
	 */
	private String approveDate;
	/**
	 * 域名
	 */
	private String domainName;
	/**
	 * 网站名称
	 */
	private String regnum;
	/**
	 * 备案号
	 */
	private String recordNo;
	/**
	 * 网站首页
	 */
	private String homepage;
	/**
	 * 状态
	 */
	private String status;
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
	 * 网站名称
	 */
	private String siteName;

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
	 * 设置：单位性质
	 */
	public void setUnitProperties(String unitProperties) {
		this.unitProperties = unitProperties;
	}

	/**
	 * 获取：单位性质
	 */
	public String getUnitProperties() {
		return unitProperties;
	}

	/**
	 * 设置：审核时间
	 */
	public void setApproveDate(String approveDate) {
		this.approveDate = approveDate;
	}

	/**
	 * 获取：审核时间
	 */
	public String getApproveDate() {
		return approveDate;
	}

	/**
	 * 设置：域名
	 */
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	/**
	 * 获取：域名
	 */
	public String getDomainName() {
		return domainName;
	}

	/**
	 * 设置：网站名称
	 */
	public void setRegnum(String regnum) {
		this.regnum = regnum;
	}

	/**
	 * 获取：网站名称
	 */
	public String getRegnum() {
		return regnum;
	}

	/**
	 * 设置：备案号
	 */
	public void setRecordNo(String recordNo) {
		this.recordNo = recordNo;
	}

	/**
	 * 获取：备案号
	 */
	public String getRecordNo() {
		return recordNo;
	}

	/**
	 * 设置：网站首页
	 */
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	/**
	 * 获取：网站首页
	 */
	public String getHomepage() {
		return homepage;
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
	 * 设置：网站名称
	 */
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	/**
	 * 获取：网站名称
	 */
	public String getSiteName() {
		return siteName;
	}
}
