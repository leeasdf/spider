package xin.tianchuang.modules.spider.bean.industrycommerce;

import java.math.BigDecimal;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 动产抵押物信息
 * 
 * @author jinlong.chen
 * @since 2017年4月20日 下午7:59:48
 * @version 1.0
 */
public class MordetailDTO {

	@JSONField(name = "morreg_id")
	private String morregId;// 抵押ID
	private String mortgagor;// 抵押人
	private String more;// 抵押权人
	private String regorg;// 登记机关
	private String regidate;// 登记日期

	private String mortype;// 状态标识
	private String morregcno;// 登记证号
	private String appregrea;// 申请抵押原因
	private String priclaseckind;// 被担保主债权种类
	private BigDecimal priclasecam;// 被担保主债权数额(万元)

	private String pefperform;// 履约起始日期
	private String pefperto;// 履约截止日期
	private String candate;// 注销日期

	public String getMorregId() {
		return morregId;
	}

	public void setMorregId(String morregId) {
		this.morregId = morregId;
	}

	public String getMortgagor() {
		return mortgagor;
	}

	public void setMortgagor(String mortgagor) {
		this.mortgagor = mortgagor;
	}

	public String getMore() {
		return more;
	}

	public void setMore(String more) {
		this.more = more;
	}

	public String getRegorg() {
		return regorg;
	}

	public void setRegorg(String regorg) {
		this.regorg = regorg;
	}

	public String getRegidate() {
		return regidate;
	}

	public void setRegidate(String regidate) {
		this.regidate = regidate;
	}

	public String getMortype() {
		return mortype;
	}

	public void setMortype(String mortype) {
		this.mortype = mortype;
	}

	public String getMorregcno() {
		return morregcno;
	}

	public void setMorregcno(String morregcno) {
		this.morregcno = morregcno;
	}

	public String getAppregrea() {
		return appregrea;
	}

	public void setAppregrea(String appregrea) {
		this.appregrea = appregrea;
	}

	public String getPriclaseckind() {
		return priclaseckind;
	}

	public void setPriclaseckind(String priclaseckind) {
		this.priclaseckind = priclaseckind;
	}

	public BigDecimal getPriclasecam() {
		return priclasecam;
	}

	public void setPriclasecam(BigDecimal priclasecam) {
		this.priclasecam = priclasecam;
	}

	public String getPefperform() {
		return pefperform;
	}

	public void setPefperform(String pefperform) {
		this.pefperform = pefperform;
	}

	public String getPefperto() {
		return pefperto;
	}

	public void setPefperto(String pefperto) {
		this.pefperto = pefperto;
	}

	public String getCandate() {
		return candate;
	}

	public void setCandate(String candate) {
		this.candate = candate;
	}

}
