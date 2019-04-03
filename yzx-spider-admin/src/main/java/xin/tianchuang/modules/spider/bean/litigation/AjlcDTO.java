package xin.tianchuang.modules.spider.bean.litigation;

/**
 * 案件流程信息概要
 * 
 * @author denghui
 * 
 */
public class AjlcDTO {

	private String ajlcId; // 案件流程ID
	private String sortTime; // ⽴案时间
	private String body; // 内容
	private String pname; // 姓名
	private String court; // 法院名称
	// 详细信息
	private String member; // 法庭成员
	private String caseType; // 案件类别
	private String trialProcedure; // 审理程序
	private String caseCause; // 案由
	private String clerk; // 书记员
	private String judge; // 主审法官
	private String actionObject; // 诉讼标的
	private String caseNo; // 案号

	public String getAjlcId() {
		return ajlcId;
	}

	public void setAjlcId(String ajlcId) {
		this.ajlcId = ajlcId;
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

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public String getCaseType() {
		return caseType;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	public String getTrialProcedure() {
		return trialProcedure;
	}

	public void setTrialProcedure(String trialProcedure) {
		this.trialProcedure = trialProcedure;
	}

	public String getCaseCause() {
		return caseCause;
	}

	public void setCaseCause(String caseCause) {
		this.caseCause = caseCause;
	}

	public String getClerk() {
		return clerk;
	}

	public void setClerk(String clerk) {
		this.clerk = clerk;
	}

	public String getJudge() {
		return judge;
	}

	public void setJudge(String judge) {
		this.judge = judge;
	}

	public String getActionObject() {
		return actionObject;
	}

	public void setActionObject(String actionObject) {
		this.actionObject = actionObject;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	
}
