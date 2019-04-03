package xin.tianchuang.modules.spider.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * tyc企业行政许可[工商局]信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-12-04 14:24:47
 */
@TableName("rpt_tn_licensing")
public class RptTnLicensingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 主键
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long enterpriseId;
	/**
	 * 企业名称
	 */
	private String entName;
	/**
	 * 许可书文编号
	 */
	private String licenseNo;
	/**
	 * 许可文件名称
	 */
	private String licenseName;
	/**
	 * 有效期自
	 */
	private String validateFrom;
	/**
	 * 有限期至
	 */
	private String validateTo;
	/**
	 * 许可机关
	 */
	private String authority;
	/**
	 * 许可内容
	 */
	private String content;
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
	 * 设置：主键
	 */
	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	/**
	 * 获取：主键
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
	 * 设置：许可书文编号
	 */
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	/**
	 * 获取：许可书文编号
	 */
	public String getLicenseNo() {
		return licenseNo;
	}
	/**
	 * 设置：许可文件名称
	 */
	public void setLicenseName(String licenseName) {
		this.licenseName = licenseName;
	}
	/**
	 * 获取：许可文件名称
	 */
	public String getLicenseName() {
		return licenseName;
	}
	/**
	 * 设置：有效期自
	 */
	public void setValidateFrom(String validateFrom) {
		this.validateFrom = validateFrom;
	}
	/**
	 * 获取：有效期自
	 */
	public String getValidateFrom() {
		return validateFrom;
	}
	/**
	 * 设置：有限期至
	 */
	public void setValidateTo(String validateTo) {
		this.validateTo = validateTo;
	}
	/**
	 * 获取：有限期至
	 */
	public String getValidateTo() {
		return validateTo;
	}
	/**
	 * 设置：许可机关
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	/**
	 * 获取：许可机关
	 */
	public String getAuthority() {
		return authority;
	}
	/**
	 * 设置：许可内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：许可内容
	 */
	public String getContent() {
		return content;
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
