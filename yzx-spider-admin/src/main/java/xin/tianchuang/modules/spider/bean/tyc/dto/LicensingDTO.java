package xin.tianchuang.modules.spider.bean.tyc.dto;

import java.io.Serializable;

public class LicensingDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5056982195398802417L;
	private String licenseNo;
	private String validateTo;
	private String authority;
	private String licenseName;
	private String validateFrom;
	private String content;

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setValidateTo(String validateTo) {
		this.validateTo = validateTo;
	}

	public String getValidateTo() {
		return validateTo;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getAuthority() {
		return authority;
	}

	public void setLicenseName(String licenseName) {
		this.licenseName = licenseName;
	}

	public String getLicenseName() {
		return licenseName;
	}

	public String getValidateFrom() {
		return validateFrom;
	}

	public void setValidateFrom(String validateFrom) {
		this.validateFrom = validateFrom;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}
}
