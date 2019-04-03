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
 * 省发改委-长沙工商-企业经营异常详细信息(导入)
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:23
 */
@TableName("ori_enterprise_operating_exception")
public class OriEnterpriseOperatingExceptionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 企业ID
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long enterpriseId;
	/**
	 * 经营异常名录ID
	 */
	private String operatingExceptionListId;
	/**
	 * 主体身份代码
	 */
	private String subjectIdentityCode;
	/**
	 * 企业名称
	 */
	private String enterpriseName;
	/**
	 * 统一社会信用代码
	 */
	private String uniformSocialCreditCode;
	/**
	 * 注册码
	 */
	private String registerCode;
	/**
	 * 法定代表人
	 */
	private String legalRepresentative;
	/**
	 * 证件类型
	 */
	private String certType;
	/**
	 * 证件号码
	 */
	private String certNo;
	/**
	 * 列入经营异常名录原因类型
	 */
	private String includedReasonType;
	/**
	 * 列入经营异常名录原因类型名称
	 */
	private String includedReasonName;
	/**
	 * 列入日期
	 */
	private String includedDatetime;
	/**
	 * 列入决定机关
	 */
	private String includedOrganizationCode;
	/**
	 * 列入决定机关名称
	 */
	private String includedOrganizationName;
	/**
	 * 是否移出
	 */
	private String outFlag;
	/**
	 * 移出经营异常名录原因
	 */
	private String outReason;
	/**
	 * 移出经营异常名录原因名称
	 */
	private String outReasonName;
	/**
	 * 移出日期
	 */
	private String outDatetime;
	/**
	 * 移出决定机关
	 */
	private String outOrganizationCode;
	/**
	 * 移出决定机关名称
	 */
	private String outOrganizationName;
	/**
	 * 创建时间
	 */
	 @TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;

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
	 * 设置：经营异常名录ID
	 */
	public void setOperatingExceptionListId(String operatingExceptionListId) {
		this.operatingExceptionListId = operatingExceptionListId;
	}
	/**
	 * 获取：经营异常名录ID
	 */
	public String getOperatingExceptionListId() {
		return operatingExceptionListId;
	}
	/**
	 * 设置：主体身份代码
	 */
	public void setSubjectIdentityCode(String subjectIdentityCode) {
		this.subjectIdentityCode = subjectIdentityCode;
	}
	/**
	 * 获取：主体身份代码
	 */
	public String getSubjectIdentityCode() {
		return subjectIdentityCode;
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
	 * 设置：统一社会信用代码
	 */
	public void setUniformSocialCreditCode(String uniformSocialCreditCode) {
		this.uniformSocialCreditCode = uniformSocialCreditCode;
	}
	/**
	 * 获取：统一社会信用代码
	 */
	public String getUniformSocialCreditCode() {
		return uniformSocialCreditCode;
	}
	/**
	 * 设置：注册码
	 */
	public void setRegisterCode(String registerCode) {
		this.registerCode = registerCode;
	}
	/**
	 * 获取：注册码
	 */
	public String getRegisterCode() {
		return registerCode;
	}
	/**
	 * 设置：法定代表人
	 */
	public void setLegalRepresentative(String legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}
	/**
	 * 获取：法定代表人
	 */
	public String getLegalRepresentative() {
		return legalRepresentative;
	}
	/**
	 * 设置：证件类型
	 */
	public void setCertType(String certType) {
		this.certType = certType;
	}
	/**
	 * 获取：证件类型
	 */
	public String getCertType() {
		return certType;
	}
	/**
	 * 设置：证件号码
	 */
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	/**
	 * 获取：证件号码
	 */
	public String getCertNo() {
		return certNo;
	}
	/**
	 * 设置：列入经营异常名录原因类型
	 */
	public void setIncludedReasonType(String includedReasonType) {
		this.includedReasonType = includedReasonType;
	}
	/**
	 * 获取：列入经营异常名录原因类型
	 */
	public String getIncludedReasonType() {
		return includedReasonType;
	}
	/**
	 * 设置：列入经营异常名录原因类型名称
	 */
	public void setIncludedReasonName(String includedReasonName) {
		this.includedReasonName = includedReasonName;
	}
	/**
	 * 获取：列入经营异常名录原因类型名称
	 */
	public String getIncludedReasonName() {
		return includedReasonName;
	}
	/**
	 * 设置：列入日期
	 */
	public void setIncludedDatetime(String includedDatetime) {
		this.includedDatetime = includedDatetime;
	}
	/**
	 * 获取：列入日期
	 */
	public String getIncludedDatetime() {
		return includedDatetime;
	}
	/**
	 * 设置：列入决定机关
	 */
	public void setIncludedOrganizationCode(String includedOrganizationCode) {
		this.includedOrganizationCode = includedOrganizationCode;
	}
	/**
	 * 获取：列入决定机关
	 */
	public String getIncludedOrganizationCode() {
		return includedOrganizationCode;
	}
	/**
	 * 设置：列入决定机关名称
	 */
	public void setIncludedOrganizationName(String includedOrganizationName) {
		this.includedOrganizationName = includedOrganizationName;
	}
	/**
	 * 获取：列入决定机关名称
	 */
	public String getIncludedOrganizationName() {
		return includedOrganizationName;
	}
	/**
	 * 设置：是否移出
	 */
	public void setOutFlag(String outFlag) {
		this.outFlag = outFlag;
	}
	/**
	 * 获取：是否移出
	 */
	public String getOutFlag() {
		return outFlag;
	}
	/**
	 * 设置：移出经营异常名录原因
	 */
	public void setOutReason(String outReason) {
		this.outReason = outReason;
	}
	/**
	 * 获取：移出经营异常名录原因
	 */
	public String getOutReason() {
		return outReason;
	}
	/**
	 * 设置：移出经营异常名录原因名称
	 */
	public void setOutReasonName(String outReasonName) {
		this.outReasonName = outReasonName;
	}
	/**
	 * 获取：移出经营异常名录原因名称
	 */
	public String getOutReasonName() {
		return outReasonName;
	}
	/**
	 * 设置：移出日期
	 */
	public void setOutDatetime(String outDatetime) {
		this.outDatetime = outDatetime;
	}
	/**
	 * 获取：移出日期
	 */
	public String getOutDatetime() {
		return outDatetime;
	}
	/**
	 * 设置：移出决定机关
	 */
	public void setOutOrganizationCode(String outOrganizationCode) {
		this.outOrganizationCode = outOrganizationCode;
	}
	/**
	 * 获取：移出决定机关
	 */
	public String getOutOrganizationCode() {
		return outOrganizationCode;
	}
	/**
	 * 设置：移出决定机关名称
	 */
	public void setOutOrganizationName(String outOrganizationName) {
		this.outOrganizationName = outOrganizationName;
	}
	/**
	 * 获取：移出决定机关名称
	 */
	public String getOutOrganizationName() {
		return outOrganizationName;
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
}
