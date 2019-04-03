package xin.tianchuang.modules.spider.bean.industrycommerce;

import java.math.BigDecimal;

/**
 * 法人对外投资信息
 * 
 * @author denghui
 * 
 */
public class FrinvDTO {
	private String name;// 法定代表人姓名
	private String entname;// 企业(机构)名称
	private String regno;// 注册号
	private String enttype;// 企业(机构)类型
	private BigDecimal regcap;// 注册资本(万元)

	private String regcapcur;// 注册资本币种
	private String entstatus;// 企业状态
	private String candate;// 注销日期
	private String revdate;// 吊销日期
	private String regorg;// 登记机关

	private BigDecimal subconam;// 认缴出资额(万元)
	private String currency;// 认缴出资币种
	private String conform;// 出资方式
	private String fundedratio;// 出资比例
	private String esdate;// 开业日期

	private String regorgcode;
	private String pinvamount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEntname() {
		return entname;
	}

	public void setEntname(String entname) {
		this.entname = entname;
	}

	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}

	public String getEnttype() {
		return enttype;
	}

	public void setEnttype(String enttype) {
		this.enttype = enttype;
	}

	public BigDecimal getRegcap() {
		return regcap;
	}

	public void setRegcap(BigDecimal regcap) {
		this.regcap = regcap;
	}

	public String getRegcapcur() {
		return regcapcur;
	}

	public void setRegcapcur(String regcapcur) {
		this.regcapcur = regcapcur;
	}

	public String getEntstatus() {
		return entstatus;
	}

	public void setEntstatus(String entstatus) {
		this.entstatus = entstatus;
	}

	public String getCandate() {
		return candate;
	}

	public void setCandate(String candate) {
		this.candate = candate;
	}

	public String getRevdate() {
		return revdate;
	}

	public void setRevdate(String revdate) {
		this.revdate = revdate;
	}

	public String getRegorg() {
		return regorg;
	}

	public void setRegorg(String regorg) {
		this.regorg = regorg;
	}

	public BigDecimal getSubconam() {
		return subconam;
	}

	public void setSubconam(BigDecimal subconam) {
		this.subconam = subconam;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
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

	public String getEsdate() {
		return esdate;
	}

	public void setEsdate(String esdate) {
		this.esdate = esdate;
	}

	public String getRegorgcode() {
		return regorgcode;
	}

	public void setRegorgcode(String regorgcode) {
		this.regorgcode = regorgcode;
	}

	public String getPinvamount() {
		return pinvamount;
	}

	public void setPinvamount(String pinvamount) {
		this.pinvamount = pinvamount;
	}

}
