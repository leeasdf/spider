package xin.tianchuang.modules.spider.bean.enterprise.verify;

import java.math.BigDecimal;

/**
 * 股东信息
 * 
 * @author jinlong.chen
 * @since 2017年4月20日 下午7:47:59
 * @version 1.0
 */
public class ShareHolderDTO {
	private String shaName;// 股东名称
	private BigDecimal subConam;// 认缴出资额(万元)
	private String regCapCur;// 认缴出资币种
	private String fundedRatio;// 出资比例
	private String conDate;// 出资日期

	private String country;// 国别
	private String shaType;// 股东类型
	private String licenceType;// 证件类型
	private String licenceNumber;// 证件号码

	public String getShaName() {
		return shaName;
	}

	public void setShaName(String shaName) {
		this.shaName = shaName;
	}

	public BigDecimal getSubConam() {
		return subConam;
	}

	public void setSubConam(BigDecimal subConam) {
		this.subConam = subConam;
	}

	public String getRegCapCur() {
		return regCapCur;
	}

	public void setRegCapCur(String regCapCur) {
		this.regCapCur = regCapCur;
	}

	public String getFundedRatio() {
		return fundedRatio;
	}

	public void setFundedRatio(String fundedRatio) {
		this.fundedRatio = fundedRatio;
	}

	public String getConDate() {
		return conDate;
	}

	public void setConDate(String conDate) {
		this.conDate = conDate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getShaType() {
		return shaType;
	}

	public void setShaType(String shaType) {
		this.shaType = shaType;
	}

	public String getLicenceType() {
		return licenceType;
	}

	public void setLicenceType(String licenceType) {
		this.licenceType = licenceType;
	}

	public String getLicenceNumber() {
		return licenceNumber;
	}

	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}

}
