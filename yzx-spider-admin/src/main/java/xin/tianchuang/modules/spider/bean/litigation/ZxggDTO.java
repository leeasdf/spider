package xin.tianchuang.modules.spider.bean.litigation;

/**
 * 执⾏公告信息概要
 * 
 * @author denghui
 * 
 */
public class ZxggDTO {
	private String zxggId;// 开庭公告ID
	private String sortTime;// 开庭时间
	private String body;// 内容
	private String title;// 标题
	private String court;// 法院名称

	private String pname;// 被执行人姓名
	// 详情信息
	private String status; // 执⾏状态
	private String proposer; // 申请⼈
	private String caseNo; // 案号
	private String caseState; // 案件状态
	private String idcardNo; // ⾝份证/组织机构代码
	private String execMoney; // 执⾏标的

	public String getZxggId() {
		return zxggId;
	}

	public void setZxggId(String zxggId) {
		this.zxggId = zxggId;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCourt() {
		return court;
	}

	public void setCourt(String court) {
		this.court = court;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProposer() {
		return proposer;
	}

	public void setProposer(String proposer) {
		this.proposer = proposer;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getCaseState() {
		return caseState;
	}

	public void setCaseState(String caseState) {
		this.caseState = caseState;
	}

	public String getIdcardNo() {
		return idcardNo;
	}

	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}

	public String getExecMoney() {
		return execMoney;
	}

	public void setExecMoney(String execMoney) {
		this.execMoney = execMoney;
	}

}
