package xin.tianchuang.modules.spider.bean.industrycommerce;

import java.math.BigDecimal;

/**
 * 法人其他任职信息
 * 
 * @author jinlong.chen
 * @since 2017年4月20日 下午7:55:01
 * @version 1.0
 */
public class FrpositionDTO {
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

	private String position;// 职务
	private String lerepsign;// 是否法定代表人
	private String esdate;// 开业日期

	// new add
	private String regorgcode; // 注册机构编码
	private String ppvamount;

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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getLerepsign() {
		return lerepsign;
	}

	public void setLerepsign(String lerepsign) {
		this.lerepsign = lerepsign;
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

	public String getPpvamount() {
		return ppvamount;
	}

	public void setPpvamount(String ppvamount) {
		this.ppvamount = ppvamount;
	}

}
