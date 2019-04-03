package xin.tianchuang.modules.spider.bean.enterprise.verify;

/**
 * 欠贷信息列表
 * 
 * @author denghui
 * 
 */
public class DebtDTO {
	private String name;// ⽋贷⼈姓名/名称
	private String sex;// 性别
	private String age;// 年龄
	private String cardNum;// ⾝份证号码/⼯商注册号
	private String ysfzd;// ⾝份证原始发证地
	private String areaName;// 省份
	private String qked;// ⽋款额度
	private String wyqk;// 违约情况
	private String dkdqsj;// 贷款到期时间
	private String tbzh;// 淘宝账户
	private String legalPerson;// 法定代表⼈
	private String dkqx;// 贷款期限

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

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getQked() {
		return qked;
	}

	public void setQked(String qked) {
		this.qked = qked;
	}

	public String getWyqk() {
		return wyqk;
	}

	public void setWyqk(String wyqk) {
		this.wyqk = wyqk;
	}

	public String getDkdqsj() {
		return dkdqsj;
	}

	public void setDkdqsj(String dkdqsj) {
		this.dkdqsj = dkdqsj;
	}

	public String getTbzh() {
		return tbzh;
	}

	public void setTbzh(String tbzh) {
		this.tbzh = tbzh;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public String getDkqx() {
		return dkqx;
	}

	public void setDkqx(String dkqx) {
		this.dkqx = dkqx;
	}

}
