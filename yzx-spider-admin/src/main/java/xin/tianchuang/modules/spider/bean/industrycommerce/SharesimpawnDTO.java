package xin.tianchuang.modules.spider.bean.industrycommerce;

import java.math.BigDecimal;

/**
 * 股权出质历史信息
 * 
 * @author jinlong.chen
 * @since 2017年4月20日 下午7:58:33
 * @version 1.0
 */
public class SharesimpawnDTO {
	private String imporg;// 质权人姓名
	private String imporgtype;// 出质人类别
	private BigDecimal impam;// 出质金额（万元）
	private String imponrecdate;// 出质备案日期
	private String impexaeep;// 出质审批部门

	private String impsandate;// 出质批准日期
	private String impto;// 出质截至日期

	public String getImporg() {
		return imporg;
	}

	public void setImporg(String imporg) {
		this.imporg = imporg;
	}

	public String getImporgtype() {
		return imporgtype;
	}

	public void setImporgtype(String imporgtype) {
		this.imporgtype = imporgtype;
	}

	public BigDecimal getImpam() {
		return impam;
	}

	public void setImpam(BigDecimal impam) {
		this.impam = impam;
	}

	public String getImponrecdate() {
		return imponrecdate;
	}

	public void setImponrecdate(String imponrecdate) {
		this.imponrecdate = imponrecdate;
	}

	public String getImpexaeep() {
		return impexaeep;
	}

	public void setImpexaeep(String impexaeep) {
		this.impexaeep = impexaeep;
	}

	public String getImpsandate() {
		return impsandate;
	}

	public void setImpsandate(String impsandate) {
		this.impsandate = impsandate;
	}

	public String getImpto() {
		return impto;
	}

	public void setImpto(String impto) {
		this.impto = impto;
	}

}
