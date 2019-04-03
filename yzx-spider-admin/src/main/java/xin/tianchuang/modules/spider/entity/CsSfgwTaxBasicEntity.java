package xin.tianchuang.modules.spider.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * 省发改委-国税基础信息(省国税局)
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:19
 */
@TableName("cs_sfgw_tax_basic")
public class CsSfgwTaxBasicEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 数据状态（0：正常 1：更新 2：删除）
	 */
	private Integer isinvalid;
	/**
	 * 数据最后修改时间
	 */
	private Date lastdate;
	/**
	 * 组织机构代码
	 */
	private String organizationcode;
	/**
	 * 企业名称
	 */
	private String corporationname;
	/**
	 * 工商营业执照注册号
	 */
	private String businesslicense;
	/**
	 * 税务登记证号（国）
	 */
	private String taxcode;
	/**
	 * 法定代表人（负责人）
	 */
	private String legalrepresentative;
	/**
	 * 法定代表人（负责人）身份证件号
	 */
	private String legalrepresentativeidcard;
	/**
	 * 注册地址
	 */
	private String registeraddress;
	/**
	 * 经营地址（国）
	 */
	private String businessaddress;
	/**
	 * 经营方式
	 */
	private String businessmode;
	/**
	 * 电话
	 */
	private String contactphone;
	/**
	 * 企业状态编码（国）
	 */
	private String taxstatecode;
	/**
	 * 税务部门编码（国）
	 */
	private String taxdeptcode;
	/**
	 * 发证日期
	 */
	private String issuedate;
	/**
	 * 税务登记日期（国）
	 */
	private String taxregisterdate;
	/**
	 * 登记注册类型
	 */
	private String registertype;
	/**
	 * 经营期限
	 */
	private String deadlineofbusiness;
	/**
	 * 注册资本
	 */
	private String capital;
	/**
	 * 注册资本币种编码
	 */
	private String capitalcode;
	/**
	 * 银行编码（国）
	 */
	private String taxbankcode;
	/**
	 * 银行网点编码（国）
	 */
	private String taxbanknodecode;
	/**
	 * 缴税银行帐号（国）
	 */
	private String taxbankcard;
	/**
	 * 主键
	 */
	@TableId(value = "zjid", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long zjid;

	/**
	 * 设置：数据状态（0：正常 1：更新 2：删除）
	 */
	public void setIsinvalid(Integer isinvalid) {
		this.isinvalid = isinvalid;
	}
	/**
	 * 获取：数据状态（0：正常 1：更新 2：删除）
	 */
	public Integer getIsinvalid() {
		return isinvalid;
	}
	/**
	 * 设置：数据最后修改时间
	 */
	public void setLastdate(Date lastdate) {
		this.lastdate = lastdate;
	}
	/**
	 * 获取：数据最后修改时间
	 */
	public Date getLastdate() {
		return lastdate;
	}
	/**
	 * 设置：组织机构代码
	 */
	public void setOrganizationcode(String organizationcode) {
		this.organizationcode = organizationcode;
	}
	/**
	 * 获取：组织机构代码
	 */
	public String getOrganizationcode() {
		return organizationcode;
	}
	/**
	 * 设置：企业名称
	 */
	public void setCorporationname(String corporationname) {
		this.corporationname = corporationname;
	}
	/**
	 * 获取：企业名称
	 */
	public String getCorporationname() {
		return corporationname;
	}
	/**
	 * 设置：工商营业执照注册号
	 */
	public void setBusinesslicense(String businesslicense) {
		this.businesslicense = businesslicense;
	}
	/**
	 * 获取：工商营业执照注册号
	 */
	public String getBusinesslicense() {
		return businesslicense;
	}
	/**
	 * 设置：税务登记证号（国）
	 */
	public void setTaxcode(String taxcode) {
		this.taxcode = taxcode;
	}
	/**
	 * 获取：税务登记证号（国）
	 */
	public String getTaxcode() {
		return taxcode;
	}
	/**
	 * 设置：法定代表人（负责人）
	 */
	public void setLegalrepresentative(String legalrepresentative) {
		this.legalrepresentative = legalrepresentative;
	}
	/**
	 * 获取：法定代表人（负责人）
	 */
	public String getLegalrepresentative() {
		return legalrepresentative;
	}
	/**
	 * 设置：法定代表人（负责人）身份证件号
	 */
	public void setLegalrepresentativeidcard(String legalrepresentativeidcard) {
		this.legalrepresentativeidcard = legalrepresentativeidcard;
	}
	/**
	 * 获取：法定代表人（负责人）身份证件号
	 */
	public String getLegalrepresentativeidcard() {
		return legalrepresentativeidcard;
	}
	/**
	 * 设置：注册地址
	 */
	public void setRegisteraddress(String registeraddress) {
		this.registeraddress = registeraddress;
	}
	/**
	 * 获取：注册地址
	 */
	public String getRegisteraddress() {
		return registeraddress;
	}
	/**
	 * 设置：经营地址（国）
	 */
	public void setBusinessaddress(String businessaddress) {
		this.businessaddress = businessaddress;
	}
	/**
	 * 获取：经营地址（国）
	 */
	public String getBusinessaddress() {
		return businessaddress;
	}
	/**
	 * 设置：经营方式
	 */
	public void setBusinessmode(String businessmode) {
		this.businessmode = businessmode;
	}
	/**
	 * 获取：经营方式
	 */
	public String getBusinessmode() {
		return businessmode;
	}
	/**
	 * 设置：电话
	 */
	public void setContactphone(String contactphone) {
		this.contactphone = contactphone;
	}
	/**
	 * 获取：电话
	 */
	public String getContactphone() {
		return contactphone;
	}
	/**
	 * 设置：企业状态编码（国）
	 */
	public void setTaxstatecode(String taxstatecode) {
		this.taxstatecode = taxstatecode;
	}
	/**
	 * 获取：企业状态编码（国）
	 */
	public String getTaxstatecode() {
		return taxstatecode;
	}
	/**
	 * 设置：税务部门编码（国）
	 */
	public void setTaxdeptcode(String taxdeptcode) {
		this.taxdeptcode = taxdeptcode;
	}
	/**
	 * 获取：税务部门编码（国）
	 */
	public String getTaxdeptcode() {
		return taxdeptcode;
	}
	/**
	 * 设置：发证日期
	 */
	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}
	/**
	 * 获取：发证日期
	 */
	public String getIssuedate() {
		return issuedate;
	}
	/**
	 * 设置：税务登记日期（国）
	 */
	public void setTaxregisterdate(String taxregisterdate) {
		this.taxregisterdate = taxregisterdate;
	}
	/**
	 * 获取：税务登记日期（国）
	 */
	public String getTaxregisterdate() {
		return taxregisterdate;
	}
	/**
	 * 设置：登记注册类型
	 */
	public void setRegistertype(String registertype) {
		this.registertype = registertype;
	}
	/**
	 * 获取：登记注册类型
	 */
	public String getRegistertype() {
		return registertype;
	}
	/**
	 * 设置：经营期限
	 */
	public void setDeadlineofbusiness(String deadlineofbusiness) {
		this.deadlineofbusiness = deadlineofbusiness;
	}
	/**
	 * 获取：经营期限
	 */
	public String getDeadlineofbusiness() {
		return deadlineofbusiness;
	}
	/**
	 * 设置：注册资本
	 */
	public void setCapital(String capital) {
		this.capital = capital;
	}
	/**
	 * 获取：注册资本
	 */
	public String getCapital() {
		return capital;
	}
	/**
	 * 设置：注册资本币种编码
	 */
	public void setCapitalcode(String capitalcode) {
		this.capitalcode = capitalcode;
	}
	/**
	 * 获取：注册资本币种编码
	 */
	public String getCapitalcode() {
		return capitalcode;
	}
	/**
	 * 设置：银行编码（国）
	 */
	public void setTaxbankcode(String taxbankcode) {
		this.taxbankcode = taxbankcode;
	}
	/**
	 * 获取：银行编码（国）
	 */
	public String getTaxbankcode() {
		return taxbankcode;
	}
	/**
	 * 设置：银行网点编码（国）
	 */
	public void setTaxbanknodecode(String taxbanknodecode) {
		this.taxbanknodecode = taxbanknodecode;
	}
	/**
	 * 获取：银行网点编码（国）
	 */
	public String getTaxbanknodecode() {
		return taxbanknodecode;
	}
	/**
	 * 设置：缴税银行帐号（国）
	 */
	public void setTaxbankcard(String taxbankcard) {
		this.taxbankcard = taxbankcard;
	}
	/**
	 * 获取：缴税银行帐号（国）
	 */
	public String getTaxbankcard() {
		return taxbankcard;
	}
	/**
	 * 设置：主键
	 */
	public void setZjid(Long zjid) {
		this.zjid = zjid;
	}
	/**
	 * 获取：主键
	 */
	public Long getZjid() {
		return zjid;
	}
}
