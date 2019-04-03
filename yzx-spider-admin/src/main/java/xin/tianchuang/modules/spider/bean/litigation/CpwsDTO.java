package xin.tianchuang.modules.spider.bean.litigation;

import java.util.List;

/**
 * 裁判⽂书涉诉概要信息
 * 
 * @author denghui
 * 
 */
public class CpwsDTO {
	private String cpwsId;// 开庭公告ID
	private String sortTime;// 开庭时间
	private String body;// 内容
	private String title;// 标题
	private String court;// 法院名称

	private String caseNo;// 案号
	// 详细信息
	private String caseType;// ⽂书类型（案件类型）
	private String caseCause;// 案由
	private String judge;// 审判员
	private String judgeResult;// 判决结果

	private String trialProcedure;// 判决结果
	private List<PartysDTO> partys;

	public String getCpwsId() {
		return cpwsId;
	}

	public void setCpwsId(String cpwsId) {
		this.cpwsId = cpwsId;
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

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getCaseType() {
		return caseType;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
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

	public String getJudgeResult() {
		return judgeResult;
	}

	public void setJudgeResult(String judgeResult) {
		this.judgeResult = judgeResult;
	}

	public String getTrialProcedure() {
		return trialProcedure;
	}

	public void setTrialProcedure(String trialProcedure) {
		this.trialProcedure = trialProcedure;
	}

	public List<PartysDTO> getPartys() {
		return partys;
	}

	public void setPartys(List<PartysDTO> partys) {
		this.partys = partys;
	}

}
