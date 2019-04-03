package xin.tianchuang.modules.spider.bean.industrycommerce;

/**
 * 企业股东信息
 * 
 * @author denghui
 * 
 */
public class RyposshaDTO {
	private String ryname; // 查询⼈姓名
	private String entname; // 企业(机构)名称
	private String regno; // 注册号
	private String enttype; // 企业(机构)类型
	private String regcap; // 注册资本(万元)

	private String regcapcur; // 注册资本币种
	private String entstatus; // 企业状态
	private String subconam; // 认缴出资额(万元)
	private String currency; // 认缴出资币种

	public String getRyname() {
		return ryname;
	}

	public void setRyname(String ryname) {
		this.ryname = ryname;
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

	public String getRegcap() {
		return regcap;
	}

	public void setRegcap(String regcap) {
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

	public String getSubconam() {
		return subconam;
	}

	public void setSubconam(String subconam) {
		this.subconam = subconam;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
