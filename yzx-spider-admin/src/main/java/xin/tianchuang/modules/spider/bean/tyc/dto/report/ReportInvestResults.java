package xin.tianchuang.modules.spider.bean.tyc.dto.report;

import java.io.Serializable;

public class ReportInvestResults implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5768499759923361829L;
	/**
	 * 注册号/统一社会信用代码
	 */
	private String creditCode;
	/**
	 * 对外投资企业名称
	 */
	private String inverstName;

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

	public String getCreditCode() {
		return creditCode;
	}

	public void setInverstName(String inverstName) {
		this.inverstName = inverstName;
	}

	public String getInverstName() {
		return inverstName;
	}
}
