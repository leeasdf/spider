	package xin.tianchuang.modules.spider.bean.litigation;

/**
 * 法院公告信息概要
 * 
 * @author denghui
 * 
 */
public class FyggDTO {

	private String fyggId; // 法院公告ID
	private String sortTime; // 发布时间
	private String body; // 公告内容
	private String pname; // 当事⼈
	private String court; // 法院名称
	// 详情
	private String ggType; // 公告类型
	public String getFyggId() {
		return fyggId;
	}

	public void setFyggId(String fyggId) {
		this.fyggId = fyggId;
	}

	public String getSortTime() {
		return sortTime;
	}

	public void setSortTime(String sortTime) {
		this.sortTime = sortTime;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getCourt() {
		return court;
	}

	public void setCourt(String court) {
		this.court = court;
	}

	public String getGgType() {
		return ggType;
	}

	public void setGgType(String ggType) {
		this.ggType = ggType;
	}

	
}
