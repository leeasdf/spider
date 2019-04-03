package xin.tianchuang.modules.spider.bean.hnds;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

public class HndsTaxDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -773060100129978298L;

	/**
	 * 纳税人识别号/统一社会信用代码
	 */
	@JSONField(name = "NSRSBH")
	private String taxNo;

	/**
	 * 纳税人名称
	 */
	@JSONField(name = "NSRMC")
	private String taxper;

	/**
	 * 法人代表
	 */
	@JSONField(name = "FDDBRXM")
	private String legalName;

	/**
	 * 纳税状态
	 */
	@JSONField(name = "NSRZTMC")
	private String taxStatus;

	/**
	 * 序号
	 */
	@JSONField(name = "RN")
	private Integer rn;

	/**
	 * 机关
	 */
	@JSONField(name = "SWJGMC")
	private String authority;

	public String getTaxNo() {
		return taxNo;
	}

	public void setTaxNo(String taxNo) {
		this.taxNo = taxNo;
	}

	public String getTaxper() {
		return taxper;
	}

	public void setTaxper(String taxper) {
		this.taxper = taxper;
	}

	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public String getTaxStatus() {
		return taxStatus;
	}

	public void setTaxStatus(String taxStatus) {
		this.taxStatus = taxStatus;
	}

	public Integer getRn() {
		return rn;
	}

	public void setRn(Integer rn) {
		this.rn = rn;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
