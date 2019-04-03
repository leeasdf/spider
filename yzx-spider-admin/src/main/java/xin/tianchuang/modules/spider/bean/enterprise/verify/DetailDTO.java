package xin.tianchuang.modules.spider.bean.enterprise.verify;

/**
 * 经营异常详细信息
 * @author denghui
 *
 */
public class DetailDTO {

	private String orgName; // 作出决定机关

	private String onDate;// 列⼊⽇期

	private String onReason;// 列⼊经营异常⽬录原因

	private String outDate;// 移出⽇期

	private String outReason;// 移出经营异常⽬录原因

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOnDate() {
		return onDate;
	}

	public void setOnDate(String onDate) {
		this.onDate = onDate;
	}

	public String getOnReason() {
		return onReason;
	}

	public void setOnReason(String onReason) {
		this.onReason = onReason;
	}

	public String getOutDate() {
		return outDate;
	}

	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}

	public String getOutReason() {
		return outReason;
	}

	public void setOutReason(String outReason) {
		this.outReason = outReason;
	}

}
