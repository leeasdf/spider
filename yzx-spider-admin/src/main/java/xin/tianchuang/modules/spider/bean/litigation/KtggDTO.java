package xin.tianchuang.modules.spider.bean.litigation;

/**
 * 开庭公告信息概要
 * 
 * @author denghui
 * 
 */
public class KtggDTO {
	private String ktggId;// 开庭公告ID
	private String sortTime;// 开庭时间
	private String body;// 内容
	private String title;// 标题
	private String court;// 法院名称

	// 详情信息
	private String plaintiff; // 原告
	private String party; // 当事⼈
	private String caseCause; // 案由
	private String judge; // 法官
	private String caseNo; // 案号(⽂书字号)

	private String defendant; // 被告

	public String getKtggId() {
		return ktggId;
	}

	public void setKtggId(String ktggId) {
		this.ktggId = ktggId;
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

	public String getPlaintiff() {
		return plaintiff;
	}

	public void setPlaintiff(String plaintiff) {
		this.plaintiff = plaintiff;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public String getCaseCause() {
		return caseCause;
	}

	public void setCaseCause(String caseCause) {
		this.caseCause = caseCause;
	}

	public String getJudge() {
		return judge;
	}

	public void setJudge(String judge) {
		this.judge = judge;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getDefendant() {
		return defendant;
	}

	public void setDefendant(String defendant) {
		this.defendant = defendant;
	}

}
