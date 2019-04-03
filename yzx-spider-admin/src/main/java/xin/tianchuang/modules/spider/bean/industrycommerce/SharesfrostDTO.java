package xin.tianchuang.modules.spider.bean.industrycommerce;

import java.math.BigDecimal;

/**
 * 股权冻结历史信息
 * 
 * @author denghui
 * 
 */
public class SharesfrostDTO {
	private String frodocno;// 冻结文号
	private String froauth;// 冻结机关
	private String frofrom;// 冻结起始日期
	private String froto;// 冻结截至日期
	private BigDecimal froam;// 冻结金额（万元）

	private String thawauth;// 解冻机关
	private String thawdocno;// 解冻文号
	private String thawdate;// 解冻日期
	private String thawcomment;// 解冻说明

	public String getFrodocno() {
		return frodocno;
	}

	public void setFrodocno(String frodocno) {
		this.frodocno = frodocno;
	}

	public String getFroauth() {
		return froauth;
	}

	public void setFroauth(String froauth) {
		this.froauth = froauth;
	}

	public String getFrofrom() {
		return frofrom;
	}

	public void setFrofrom(String frofrom) {
		this.frofrom = frofrom;
	}

	public String getFroto() {
		return froto;
	}

	public void setFroto(String froto) {
		this.froto = froto;
	}

	public BigDecimal getFroam() {
		return froam;
	}

	public void setFroam(BigDecimal froam) {
		this.froam = froam;
	}

	public String getThawauth() {
		return thawauth;
	}

	public void setThawauth(String thawauth) {
		this.thawauth = thawauth;
	}

	public String getThawdocno() {
		return thawdocno;
	}

	public void setThawdocno(String thawdocno) {
		this.thawdocno = thawdocno;
	}

	public String getThawdate() {
		return thawdate;
	}

	public void setThawdate(String thawdate) {
		this.thawdate = thawdate;
	}

	public String getThawcomment() {
		return thawcomment;
	}

	public void setThawcomment(String thawcomment) {
		this.thawcomment = thawcomment;
	}

}
