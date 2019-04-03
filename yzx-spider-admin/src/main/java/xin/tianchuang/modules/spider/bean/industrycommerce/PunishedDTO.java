package xin.tianchuang.modules.spider.bean.industrycommerce;

/**
 * 被执行人信息
 * 
 * @author jinlong.chen
 * @since 2017年4月20日 下午8:03:02
 * @version 1.0
 */
public class PunishedDTO {
	private String casecode;// 案号
	private String inameclean;// 被执行人姓名/名称
	private String cardnumclean;// 身份证号码/企业注册号
	private String sexyclean;// 性别
	private String ageclean;// 年龄

	private String areanameclean;// 省份
	private String ysfzd;// 身份证原始发证地
	private String courtname;// 执行法院
	private String regdateclean;// 立案时间
	private String casestate;// 案件状态

	private String execmoney;// 执行标的（元）

	public String getCasecode() {
		return casecode;
	}

	public void setCasecode(String casecode) {
		this.casecode = casecode;
	}

	public String getInameclean() {
		return inameclean;
	}

	public void setInameclean(String inameclean) {
		this.inameclean = inameclean;
	}

	public String getCardnumclean() {
		return cardnumclean;
	}

	public void setCardnumclean(String cardnumclean) {
		this.cardnumclean = cardnumclean;
	}

	public String getSexyclean() {
		return sexyclean;
	}

	public void setSexyclean(String sexyclean) {
		this.sexyclean = sexyclean;
	}

	public String getAgeclean() {
		return ageclean;
	}

	public void setAgeclean(String ageclean) {
		this.ageclean = ageclean;
	}

	public String getAreanameclean() {
		return areanameclean;
	}

	public void setAreanameclean(String areanameclean) {
		this.areanameclean = areanameclean;
	}

	public String getYsfzd() {
		return ysfzd;
	}

	public void setYsfzd(String ysfzd) {
		this.ysfzd = ysfzd;
	}

	public String getCourtname() {
		return courtname;
	}

	public void setCourtname(String courtname) {
		this.courtname = courtname;
	}

	public String getRegdateclean() {
		return regdateclean;
	}

	public void setRegdateclean(String regdateclean) {
		this.regdateclean = regdateclean;
	}

	public String getCasestate() {
		return casestate;
	}

	public void setCasestate(String casestate) {
		this.casestate = casestate;
	}

	public String getExecmoney() {
		return execmoney;
	}

	public void setExecmoney(String execmoney) {
		this.execmoney = execmoney;
	}

}
