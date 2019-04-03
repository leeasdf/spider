package xin.tianchuang.modules.spider.bean.industrycommerce;

/**
 * 失信被执行人信息
 * 
 * @author jinlong.chen
 * @since 2017年4月20日 下午8:02:10
 * @version 1.0
 */
public class PunishbreakDTO {
	private String casecode;// 案号
	private String inameclean;// 被执行人姓名/名称
	private String type;// 失信人类型
	private String sexyclean;// 性别
	private String ageclean;// 年龄

	private String cardnum;// 身份证号码/工商注册号
	private String ysfzd;// 身份证原始发证地
	private String businessentity;// 法定代表人/负责人姓名
	private String regdateclean;// 立案时间
	private String publishdateclean;// 公布时间

	private String courtname;// 执行法院
	private String areanameclean;// 省份
	private String gistid;// 执行依据文号
	private String gistunit;// 做出执行依据单位
	private String duty;// 生效法律文书确定的义务

	private String disrupttypename;// 失信被执行人行为具体情形
	private String performance;// 被执行人的履行情况
	private String performedpart;// 已履行
	private String unperformpart;// 未履行

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getCardnum() {
		return cardnum;
	}

	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}

	public String getYsfzd() {
		return ysfzd;
	}

	public void setYsfzd(String ysfzd) {
		this.ysfzd = ysfzd;
	}

	public String getBusinessentity() {
		return businessentity;
	}

	public void setBusinessentity(String businessentity) {
		this.businessentity = businessentity;
	}

	public String getRegdateclean() {
		return regdateclean;
	}

	public void setRegdateclean(String regdateclean) {
		this.regdateclean = regdateclean;
	}

	public String getPublishdateclean() {
		return publishdateclean;
	}

	public void setPublishdateclean(String publishdateclean) {
		this.publishdateclean = publishdateclean;
	}

	public String getCourtname() {
		return courtname;
	}

	public void setCourtname(String courtname) {
		this.courtname = courtname;
	}

	public String getAreanameclean() {
		return areanameclean;
	}

	public void setAreanameclean(String areanameclean) {
		this.areanameclean = areanameclean;
	}

	public String getGistid() {
		return gistid;
	}

	public void setGistid(String gistid) {
		this.gistid = gistid;
	}

	public String getGistunit() {
		return gistunit;
	}

	public void setGistunit(String gistunit) {
		this.gistunit = gistunit;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getDisrupttypename() {
		return disrupttypename;
	}

	public void setDisrupttypename(String disrupttypename) {
		this.disrupttypename = disrupttypename;
	}

	public String getPerformance() {
		return performance;
	}

	public void setPerformance(String performance) {
		this.performance = performance;
	}

	public String getPerformedpart() {
		return performedpart;
	}

	public void setPerformedpart(String performedpart) {
		this.performedpart = performedpart;
	}

	public String getUnperformpart() {
		return unperformpart;
	}

	public void setUnperformpart(String unperformpart) {
		this.unperformpart = unperformpart;
	}

}
