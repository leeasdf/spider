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
 * 企业-资格证书
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:17
 */
@TableName("enterprise_qualification")
public class EnterpriseQualificationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "enterprise_qualification_id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long enterpriseQualificationId;
	/**
	 * 会员ID
	 */
	private Integer memId;
	/**
	 * 资质名称
	 */
	private String qualificationName;
	/**
	 * 资质类型
	 */
	private String qualificationType;
	/**
	 * 发证机构
	 */
	private String certificateAuthority;
	/**
	 * 证书编号
	 */
	private String certificateId;
	/**
	 * 发证时间
	 */
	private Date certificateTime;
	/**
	 * 资质附件
	 */
	private String qualificationAccessory;
	/**
	 * 数据状态：1-正常 0-删除
	 */
	@TableField(value = "data_state", fill = FieldFill.INSERT)
	private Integer dataState;
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
	@TableField(value = "update_time", fill = FieldFill.INSERT)
	private Date updateTime;

	/**
	 * 设置：主键
	 */
	public void setEnterpriseQualificationId(Long enterpriseQualificationId) {
		this.enterpriseQualificationId = enterpriseQualificationId;
	}
	/**
	 * 获取：主键
	 */
	public Long getEnterpriseQualificationId() {
		return enterpriseQualificationId;
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
	 * 设置：资质名称
	 */
	public void setQualificationName(String qualificationName) {
		this.qualificationName = qualificationName;
	}
	/**
	 * 获取：资质名称
	 */
	public String getQualificationName() {
		return qualificationName;
	}
	/**
	 * 设置：资质类型
	 */
	public void setQualificationType(String qualificationType) {
		this.qualificationType = qualificationType;
	}
	/**
	 * 获取：资质类型
	 */
	public String getQualificationType() {
		return qualificationType;
	}
	/**
	 * 设置：发证机构
	 */
	public void setCertificateAuthority(String certificateAuthority) {
		this.certificateAuthority = certificateAuthority;
	}
	/**
	 * 获取：发证机构
	 */
	public String getCertificateAuthority() {
		return certificateAuthority;
	}
	/**
	 * 设置：证书编号
	 */
	public void setCertificateId(String certificateId) {
		this.certificateId = certificateId;
	}
	/**
	 * 获取：证书编号
	 */
	public String getCertificateId() {
		return certificateId;
	}
	/**
	 * 设置：发证时间
	 */
	public void setCertificateTime(Date certificateTime) {
		this.certificateTime = certificateTime;
	}
	/**
	 * 获取：发证时间
	 */
	public Date getCertificateTime() {
		return certificateTime;
	}
	/**
	 * 设置：资质附件
	 */
	public void setQualificationAccessory(String qualificationAccessory) {
		this.qualificationAccessory = qualificationAccessory;
	}
	/**
	 * 获取：资质附件
	 */
	public String getQualificationAccessory() {
		return qualificationAccessory;
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
}
