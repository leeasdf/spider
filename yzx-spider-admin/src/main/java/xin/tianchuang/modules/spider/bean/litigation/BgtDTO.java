package xin.tianchuang.modules.spider.bean.litigation;

/**
 * 曝光台信息概要
 * 
 * @author denghui
 * 
 */
public class BgtDTO {

	private String bgtId; // 曝光台ID
	private String sortTime; // 时间
	private String body; // 内容
	private String court; // 法院名称
	private String pname; // 姓名
	// 详细
	private String bgDate; // 曝光时间
	private String partyType; // 当事⼈类型
	private String proposer; // 申请⼈
	private String idcardNo; // ⾝份证/组织机构代码
	private String caseCause; // 案由
	private String unnexeMoney; // 未执⾏⾦额
	private String address; // 地址
	private String caseNo; // 案号
	private String yiju; // 依据
	private String execMoney; // 标的⾦额

	public String getBgtId() {
		return bgtId;
	}

	public void setBgtId(String bgtId) {
		this.bgtId = bgtId;
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

	public String getBgDate() {
		return bgDate;
	}

	public void setBgDate(String bgDate) {
		this.bgDate = bgDate;
	}

	public String getPartyType() {
		return partyType;
	}

	public void setPartyType(String partyType) {
		this.partyType = partyType;
	}

	public String getProposer() {
		return proposer;
	}

	public void setProposer(String proposer) {
		this.proposer = proposer;
	}

	public String getIdcardNo() {
		return idcardNo;
	}

	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}

	public String getCaseCause() {
		return caseCause;
	}

	public void setCaseCause(String caseCause) {
		this.caseCause = caseCause;
	}

	public String getUnnexeMoney() {
		return unnexeMoney;
	}

	public void setUnnexeMoney(String unnexeMoney) {
		this.unnexeMoney = unnexeMoney;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getYiju() {
		return yiju;
	}

	public void setYiju(String yiju) {
		this.yiju = yiju;
	}

	public String getExecMoney() {
		return execMoney;
	}

	public void setExecMoney(String execMoney) {
		this.execMoney = execMoney;
	}

}
