package xin.tianchuang.modules.spider.bean.litigation;

/**
 * 当事⼈信息
 * 
 * @author denghui
 * 
 */
public class PartysDTO {
	private String birthday;// 当事⼈⽣⽇
	private String title;// 当事⼈称号
	private String partytype;// 当事⼈类型
	private String lawOffice;// 律师事务所
	private String status;// 当事⼈⽴场

	private String pname;// 当事⼈名称
	private String idcardNo;// 当事⼈⾝份证号码
	private String lawyer;// 委托辩护⼈

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPartytype() {
		return partytype;
	}

	public void setPartytype(String partytype) {
		this.partytype = partytype;
	}

	public String getLawOffice() {
		return lawOffice;
	}

	public void setLawOffice(String lawOffice) {
		this.lawOffice = lawOffice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getIdcardNo() {
		return idcardNo;
	}

	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}

	public String getLawyer() {
		return lawyer;
	}

	public void setLawyer(String lawyer) {
		this.lawyer = lawyer;
	}

}
