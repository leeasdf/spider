package xin.tianchuang.modules.spider.bean.tpc;

import java.util.Date;

/**
 * 专利信息
 * 
 * @author denghui
 * 
 */
public class PatentsDTO {
	private int id;//
	private String companyId;// 企业id
	private String title;// 专利名称
	private String mainClassCode; // 主分类号
	private String type;// 专利类型

	private String classCode; // 分类号
	private String designer; // 发明⼈
	private String address; // 地址
	private String summary;// 专利摘要
	private String applicant; // 申请者

	private String patentNumber;// 专利号
	private Date applyDate;// 申请⽇期
	private String agentOrg;// 专利代理机构
	private String pubNum;// 公开号
	private String agent;// agent

	private Date pubDate;// 公开⽇期
	private String intelPub;// 国际公布
	private String intelApply;// 国际申请
	private Date intoChinaDate;// 进⼊国家⽇期
	private Date createTime;// 创建⽇期

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMainClassCode() {
		return mainClassCode;
	}

	public void setMainClassCode(String mainClassCode) {
		this.mainClassCode = mainClassCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getDesigner() {
		return designer;
	}

	public void setDesigner(String designer) {
		this.designer = designer;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getPatentNumber() {
		return patentNumber;
	}

	public void setPatentNumber(String patentNumber) {
		this.patentNumber = patentNumber;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public String getAgentOrg() {
		return agentOrg;
	}

	public void setAgentOrg(String agentOrg) {
		this.agentOrg = agentOrg;
	}

	public String getPubNum() {
		return pubNum;
	}

	public void setPubNum(String pubNum) {
		this.pubNum = pubNum;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public String getIntelPub() {
		return intelPub;
	}

	public void setIntelPub(String intelPub) {
		this.intelPub = intelPub;
	}

	public String getIntelApply() {
		return intelApply;
	}

	public void setIntelApply(String intelApply) {
		this.intelApply = intelApply;
	}

	public Date getIntoChinaDate() {
		return intoChinaDate;
	}

	public void setIntoChinaDate(Date intoChinaDate) {
		this.intoChinaDate = intoChinaDate;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
