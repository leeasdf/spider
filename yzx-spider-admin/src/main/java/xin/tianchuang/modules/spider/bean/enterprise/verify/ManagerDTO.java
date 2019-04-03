package xin.tianchuang.modules.spider.bean.enterprise.verify;

/**
 * 企业高管信息
 * 
 * @author denghui
 * 
 */
public class ManagerDTO {

	private String perName; // 姓名

	private String position; // 职务
	private String sex; // 性别

	public String getPerName() {
		return perName;
	}

	public void setPerName(String perName) {
		this.perName = perName;
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

}
