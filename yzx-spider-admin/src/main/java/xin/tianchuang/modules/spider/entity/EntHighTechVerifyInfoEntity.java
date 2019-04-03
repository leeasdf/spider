package xin.tianchuang.modules.spider.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 企业-资质认定
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:16
 */
@TableName("ent_high_tech_verify_info")
public class EntHighTechVerifyInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 企业名称
	 */
	private String enterpriseName;
	/**
	 * 企业名称
	 */
	private String originEnterpriseName;
	/**
	 * 批次
	 */
	private String batch;
	/**
	 * 认定年份
	 */
	private String verifyYear;
	/**
	 * 类型
	 */
	private String type;
	/**
	 * 证书编号
	 */
	private String certno;
	/**
	 * 认定批文号
	 */
	private String approvalNo;
	/**
	 * 公示日期
	 */
	private String publicDate;
	/**
	 * 发证日期
	 */
	private String issueDate;
	/**
	 * 变更类型
	 */
	private String changeType;
	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：企业名称
	 */
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	/**
	 * 获取：企业名称
	 */
	public String getEnterpriseName() {
		return enterpriseName;
	}
	/**
	 * 设置：企业名称
	 */
	public void setOriginEnterpriseName(String originEnterpriseName) {
		this.originEnterpriseName = originEnterpriseName;
	}
	/**
	 * 获取：企业名称
	 */
	public String getOriginEnterpriseName() {
		return originEnterpriseName;
	}
	/**
	 * 设置：批次
	 */
	public void setBatch(String batch) {
		this.batch = batch;
	}
	/**
	 * 获取：批次
	 */
	public String getBatch() {
		return batch;
	}
	/**
	 * 设置：认定年份
	 */
	public void setVerifyYear(String verifyYear) {
		this.verifyYear = verifyYear;
	}
	/**
	 * 获取：认定年份
	 */
	public String getVerifyYear() {
		return verifyYear;
	}
	/**
	 * 设置：类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：证书编号
	 */
	public void setCertno(String certno) {
		this.certno = certno;
	}
	/**
	 * 获取：证书编号
	 */
	public String getCertno() {
		return certno;
	}
	/**
	 * 设置：认定批文号
	 */
	public void setApprovalNo(String approvalNo) {
		this.approvalNo = approvalNo;
	}
	/**
	 * 获取：认定批文号
	 */
	public String getApprovalNo() {
		return approvalNo;
	}
	/**
	 * 设置：公示日期
	 */
	public void setPublicDate(String publicDate) {
		this.publicDate = publicDate;
	}
	/**
	 * 获取：公示日期
	 */
	public String getPublicDate() {
		return publicDate;
	}
	/**
	 * 设置：发证日期
	 */
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	/**
	 * 获取：发证日期
	 */
	public String getIssueDate() {
		return issueDate;
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
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
}
