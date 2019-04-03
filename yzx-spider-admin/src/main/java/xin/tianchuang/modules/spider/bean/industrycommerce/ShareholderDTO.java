package xin.tianchuang.modules.spider.bean.industrycommerce;

import java.math.BigDecimal;

/**
 * 股东信息
 * @author jinlong.chen
 * @since 2017年4月20日 下午7:47:59
 * @version 1.0
 */
public class ShareholderDTO {
	private String shaname;//股东名称
	private BigDecimal subconam;//认缴出资额(万元)
	private String regcapcur;//认缴出资币种
	private String conform;//出资方式
	private String fundedratio;//出资比例

	private String condate;//出资日期
	private String country;//国别
	private String invamount;//股东总数量
	private String invsumfundedratio;//股东出资比例总和
	private String sumconam;

	public String getShaname() {
		return shaname;
	}
	public void setShaname(String shaname) {
		this.shaname = shaname;
	}
	public BigDecimal getSubconam() {
		return subconam;
	}
	public void setSubconam(BigDecimal subconam) {
		this.subconam = subconam;
	}
	public String getRegcapcur() {
		return regcapcur;
	}
	public void setRegcapcur(String regcapcur) {
		this.regcapcur = regcapcur;
	}
	public String getConform() {
		return conform;
	}
	public void setConform(String conform) {
		this.conform = conform;
	}
	public String getFundedratio() {
		return fundedratio;
	}
	public void setFundedratio(String fundedratio) {
		this.fundedratio = fundedratio;
	}
	public String getCondate() {
		return condate;
	}
	public void setCondate(String condate) {
		this.condate = condate;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getInvamount() {
		return invamount;
	}
	public void setInvamount(String invamount) {
		this.invamount = invamount;
	}
	public String getInvsumfundedratio() {
		return invsumfundedratio;
	}
	public void setInvsumfundedratio(String invsumfundedratio) {
		this.invsumfundedratio = invsumfundedratio;
	}
	public String getSumconam() {
		return sumconam;
	}
	public void setSumconam(String sumconam) {
		this.sumconam = sumconam;
	}

}
