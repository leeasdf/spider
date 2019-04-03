package xin.tianchuang.modules.spider.bean.industrycommerce;

/**
 * 清算信息
 * @author denghui
 *
 */
public class LiquidationDTO {
	private String ligentity;// 清算责任人
	private String ligprincipal;// 清算负责人
	private String liqmen;// 清算组成员
	private String ligst;// 清算完结情况
	private String ligenddate;// 清算完结日期

	private String debttranee;// 债务承接人
	private String claimtranee;// 债权承接人

	public String getLigentity() {
		return ligentity;
	}

	public void setLigentity(String ligentity) {
		this.ligentity = ligentity;
	}

	public String getLigprincipal() {
		return ligprincipal;
	}

	public void setLigprincipal(String ligprincipal) {
		this.ligprincipal = ligprincipal;
	}

	public String getLiqmen() {
		return liqmen;
	}

	public void setLiqmen(String liqmen) {
		this.liqmen = liqmen;
	}

	public String getLigst() {
		return ligst;
	}

	public void setLigst(String ligst) {
		this.ligst = ligst;
	}

	public String getLigenddate() {
		return ligenddate;
	}

	public void setLigenddate(String ligenddate) {
		this.ligenddate = ligenddate;
	}

	public String getDebttranee() {
		return debttranee;
	}

	public void setDebttranee(String debttranee) {
		this.debttranee = debttranee;
	}

	public String getClaimtranee() {
		return claimtranee;
	}

	public void setClaimtranee(String claimtranee) {
		this.claimtranee = claimtranee;
	}

}
