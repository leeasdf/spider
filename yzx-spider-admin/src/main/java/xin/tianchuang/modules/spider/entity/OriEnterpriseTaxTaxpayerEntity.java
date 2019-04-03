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
 * 省发改委-长沙地税-纳税人信息表(导入)
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:23
 */
@TableName("ori_enterprise_tax_taxpayer")
public class OriEnterpriseTaxTaxpayerEntity implements Serializable {
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
	 * 纳税人名称
	 */
	private String taxpayerName;
	/**
	 * 统一社会信用代码
	 */
	private String uniformSocialCreditCode;
	/**
	 * 组织机构代码
	 */
	private String organizationCode;
	/**
	 * 工商登记码
	 */
	private String businessRegistrationCode;
	/**
	 * 税务登记码
	 */
	private String taxRegistrationCode;
	/**
	 * 居民身份证号
	 */
	private String certNo;
	/**
	 * 法定代表人
	 */
	private String legalRepresentative;
	/**
	 * 评价年度
	 */
	private String evaluationYear;
	/**
	 * 信用级别A
	 */
	private String creditRating;
	/**
	 * 主管税务机关
	 */
	private String taxAuthority;
	/**
	 * 数据更新时间戳
	 */
	private Date dataUpdateTime;
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
	 * 设置：纳税人名称
	 */
	public void setTaxpayerName(String taxpayerName) {
		this.taxpayerName = taxpayerName;
	}
	/**
	 * 获取：纳税人名称
	 */
	public String getTaxpayerName() {
		return taxpayerName;
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
	 * 设置：组织机构代码
	 */
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	/**
	 * 获取：组织机构代码
	 */
	public String getOrganizationCode() {
		return organizationCode;
	}
	/**
	 * 设置：工商登记码
	 */
	public void setBusinessRegistrationCode(String businessRegistrationCode) {
		this.businessRegistrationCode = businessRegistrationCode;
	}
	/**
	 * 获取：工商登记码
	 */
	public String getBusinessRegistrationCode() {
		return businessRegistrationCode;
	}
	/**
	 * 设置：税务登记码
	 */
	public void setTaxRegistrationCode(String taxRegistrationCode) {
		this.taxRegistrationCode = taxRegistrationCode;
	}
	/**
	 * 获取：税务登记码
	 */
	public String getTaxRegistrationCode() {
		return taxRegistrationCode;
	}
	/**
	 * 设置：居民身份证号
	 */
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	/**
	 * 获取：居民身份证号
	 */
	public String getCertNo() {
		return certNo;
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
	 * 设置：评价年度
	 */
	public void setEvaluationYear(String evaluationYear) {
		this.evaluationYear = evaluationYear;
	}
	/**
	 * 获取：评价年度
	 */
	public String getEvaluationYear() {
		return evaluationYear;
	}
	/**
	 * 设置：信用级别A
	 */
	public void setCreditRating(String creditRating) {
		this.creditRating = creditRating;
	}
	/**
	 * 获取：信用级别A
	 */
	public String getCreditRating() {
		return creditRating;
	}
	/**
	 * 设置：主管税务机关
	 */
	public void setTaxAuthority(String taxAuthority) {
		this.taxAuthority = taxAuthority;
	}
	/**
	 * 获取：主管税务机关
	 */
	public String getTaxAuthority() {
		return taxAuthority;
	}
	/**
	 * 设置：数据更新时间戳
	 */
	public void setDataUpdateTime(Date dataUpdateTime) {
		this.dataUpdateTime = dataUpdateTime;
	}
	/**
	 * 获取：数据更新时间戳
	 */
	public Date getDataUpdateTime() {
		return dataUpdateTime;
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
