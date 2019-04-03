package xin.tianchuang.modules.spider.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 省发改委-长沙地税-欠税公告信息表(导入)
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:23
 */
@TableName("ori_enterprise_tax_owing")
public class OriEnterpriseTaxOwingEntity implements Serializable {
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
	 * 欠税人名称
	 */
	private String owingName;
	/**
	 * 欠税人识别号
	 */
	private String taxRegistrationCode;
	/**
	 * 法定代表人
	 */
	private String legalRepresentative;
	/**
	 * 法定代表人（负责人）身份证件号
	 */
	private String certNo;
	/**
	 * 欠税余额
	 */
	private BigDecimal amount;
	/**
	 * 生产经营地址
	 */
	private String address;
	/**
	 * 公告日期
	 */
	private Date declarationDate;
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
	 * 设置：欠税人名称
	 */
	public void setOwingName(String owingName) {
		this.owingName = owingName;
	}
	/**
	 * 获取：欠税人名称
	 */
	public String getOwingName() {
		return owingName;
	}
	/**
	 * 设置：欠税人识别号
	 */
	public void setTaxRegistrationCode(String taxRegistrationCode) {
		this.taxRegistrationCode = taxRegistrationCode;
	}
	/**
	 * 获取：欠税人识别号
	 */
	public String getTaxRegistrationCode() {
		return taxRegistrationCode;
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
	 * 设置：法定代表人（负责人）身份证件号
	 */
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	/**
	 * 获取：法定代表人（负责人）身份证件号
	 */
	public String getCertNo() {
		return certNo;
	}
	/**
	 * 设置：欠税余额
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	/**
	 * 获取：欠税余额
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	/**
	 * 设置：生产经营地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：生产经营地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：公告日期
	 */
	public void setDeclarationDate(Date declarationDate) {
		this.declarationDate = declarationDate;
	}
	/**
	 * 获取：公告日期
	 */
	public Date getDeclarationDate() {
		return declarationDate;
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
