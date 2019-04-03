package xin.tianchuang.modules.spider.bean.industrycommerce;

/**
 * 高管信息
 * 
 * @author jinlong.chen
 * @since 2017年4月20日 下午7:49:07
 * @version 1.0
 */
public class PersonDTO {
	private String pername;// 姓名
	private String position;// 职位
	private String sex;// 性别
	private String personamount;// 总人数
	private String natdate;
	
	public String getPername() {
		return pername;
	}

	public void setPername(String pername) {
		this.pername = pername;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPersonamount() {
		return personamount;
	}

	public void setPersonamount(String personamount) {
		this.personamount = personamount;
	}

	public String getNatdate() {
		return natdate;
	}

	public void setNatdate(String natdate) {
		this.natdate = natdate;
	}

}
