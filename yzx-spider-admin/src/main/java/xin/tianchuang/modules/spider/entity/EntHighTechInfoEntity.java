package xin.tianchuang.modules.spider.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * 湖南高新企业情况表
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:24
 */
@TableName("ent_high_tech_info")
public class EntHighTechInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 年份
	 */
	private Integer year;
	/**
	 * 批次
	 */
	private Integer batch;
	/**
	 * 类型（更名、复审、认定等）
	 */
	private String type;
	/**
	 * 原企业名称
	 */
	private String entOldName;
	/**
	 * 企业名称
	 */
	private String company;
	/**
	 * 认定证书编号
	 */
	private String qualificateNo;
	/**
	 * 认定批文
	 */
	private String qualificateLicence;
	/**
	 * 公示日期
	 */
	private Date publicityDate;
	/**
	 * 发证日期
	 */
	private Date issuingDate;
	/**
	 * 是否高新区企业
	 */
	private Integer isInZone;
	/**
	 * 变更类型
	 */
	private String changeType;
	/**
	 * 变更原因
	 */
	private String changeReason;
	/**
	 * 备注
	 */
	private String note;
	/**
	 * 对应mem_base_info的mem_id
	 */
	private Integer memId;
	/**
	 * 企业ID
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long enterpriseId;

	/**
	 * 设置：id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：年份
	 */
	public void setYear(Integer year) {
		this.year = year;
	}
	/**
	 * 获取：年份
	 */
	public Integer getYear() {
		return year;
	}
	/**
	 * 设置：批次
	 */
	public void setBatch(Integer batch) {
		this.batch = batch;
	}
	/**
	 * 获取：批次
	 */
	public Integer getBatch() {
		return batch;
	}
	/**
	 * 设置：类型（更名、复审、认定等）
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型（更名、复审、认定等）
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：原企业名称
	 */
	public void setEntOldName(String entOldName) {
		this.entOldName = entOldName;
	}
	/**
	 * 获取：原企业名称
	 */
	public String getEntOldName() {
		return entOldName;
	}
	/**
	 * 设置：企业名称
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	/**
	 * 获取：企业名称
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * 设置：认定证书编号
	 */
	public void setQualificateNo(String qualificateNo) {
		this.qualificateNo = qualificateNo;
	}
	/**
	 * 获取：认定证书编号
	 */
	public String getQualificateNo() {
		return qualificateNo;
	}
	/**
	 * 设置：认定批文
	 */
	public void setQualificateLicence(String qualificateLicence) {
		this.qualificateLicence = qualificateLicence;
	}
	/**
	 * 获取：认定批文
	 */
	public String getQualificateLicence() {
		return qualificateLicence;
	}
	/**
	 * 设置：公示日期
	 */
	public void setPublicityDate(Date publicityDate) {
		this.publicityDate = publicityDate;
	}
	/**
	 * 获取：公示日期
	 */
	public Date getPublicityDate() {
		return publicityDate;
	}
	/**
	 * 设置：发证日期
	 */
	public void setIssuingDate(Date issuingDate) {
		this.issuingDate = issuingDate;
	}
	/**
	 * 获取：发证日期
	 */
	public Date getIssuingDate() {
		return issuingDate;
	}
	/**
	 * 设置：是否高新区企业
	 */
	public void setIsInZone(Integer isInZone) {
		this.isInZone = isInZone;
	}
	/**
	 * 获取：是否高新区企业
	 */
	public Integer getIsInZone() {
		return isInZone;
	}
	/**
	 * 设置：变更类型
	 */
	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}
	/**
	 * 获取：变更类型
	 */
	public String getChangeType() {
		return changeType;
	}
	/**
	 * 设置：变更原因
	 */
	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason;
	}
	/**
	 * 获取：变更原因
	 */
	public String getChangeReason() {
		return changeReason;
	}
	/**
	 * 设置：备注
	 */
	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * 获取：备注
	 */
	public String getNote() {
		return note;
	}
	/**
	 * 设置：对应mem_base_info的mem_id
	 */
	public void setMemId(Integer memId) {
		this.memId = memId;
	}
	/**
	 * 获取：对应mem_base_info的mem_id
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
}
