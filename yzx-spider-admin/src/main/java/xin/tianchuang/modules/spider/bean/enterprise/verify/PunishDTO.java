package xin.tianchuang.modules.spider.bean.enterprise.verify;

/**
 * 企业被判决信息列表
 * 
 * @author denghui
 * 
 */
public class PunishDTO {

	private String caseCode; // 案号
	private String name; // 被执⾏⼈姓名/名称
	private String sex; // 性别
	private String age; // 年龄
	private String cardNum; // ⾝份证号码/⼯商注册号
	private String ysfzd; // ⾝份证原始发证地
	private String regDate; // ⽴案时间
	private String caseState; // 案件状态
	private String courtName; // 执⾏法院
	private String areaName; // 省份
	private String execMoney; // 执⾏标的
	private String focusNumber; // 关注次数

	public String getCaseCode() {
		return caseCode;
	}

	public void setCaseCode(String caseCode) {
		this.caseCode = caseCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getYsfzd() {
		return ysfzd;
	}

	public void setYsfzd(String ysfzd) {
		this.ysfzd = ysfzd;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getCaseState() {
		return caseState;
	}

	public void setCaseState(String caseState) {
		this.caseState = caseState;
	}

	public String getCourtName() {
		return courtName;
	}

	public void setCourtName(String courtName) {
		this.courtName = courtName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getExecMoney() {
		return execMoney;
	}

	public void setExecMoney(String execMoney) {
		this.execMoney = execMoney;
	}

	public String getFocusNumber() {
		return focusNumber;
	}

	public void setFocusNumber(String focusNumber) {
		this.focusNumber = focusNumber;
	}

}
