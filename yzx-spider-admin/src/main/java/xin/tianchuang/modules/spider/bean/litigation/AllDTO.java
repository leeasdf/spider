package xin.tianchuang.modules.spider.bean.litigation;

import java.util.List;

/**
 * 
 * @author denghui
 * 
 */
public class AllDTO {

	private List<CpwsDTO> cpwsList; // 裁判⽂书涉诉概要信息（datatype=‘cpws’时才返回）

	private List<KtggDTO> ktggList; // 开庭公告信息概要（datatype=‘ktgg’时才返回）
	private List<ZxggDTO> zxggList; // 执⾏公告信息概要（datatype=‘zxgg’时才返回）
	private List<SxggDTO> sxggList; // 失信公告信息概要（datatype=‘sxgg’时才返回）
	private List<FyggDTO> fyggList; // 法院公告信息概要（datatype=‘fygg’时才返回）
	private List<WdhmdDTO> wdhmdList; // 网贷⿊名单信息概要（datatype=‘wdhmd’时才返回）

	private List<AjlcDTO> ajlcList; // 案件流程信息概要（datatype=‘ajlc’时才返回）
	private List<BgtDTO> bgtList; // 曝光台信息概要（datatype=‘bgt’时才返回）

	public List<CpwsDTO> getCpwsList() {
		return cpwsList;
	}

	public void setCpwsList(List<CpwsDTO> cpwsList) {
		this.cpwsList = cpwsList;
	}

	public List<KtggDTO> getKtggList() {
		return ktggList;
	}

	public void setKtggList(List<KtggDTO> ktggList) {
		this.ktggList = ktggList;
	}

	public List<ZxggDTO> getZxggList() {
		return zxggList;
	}

	public void setZxggList(List<ZxggDTO> zxggList) {
		this.zxggList = zxggList;
	}

	public List<SxggDTO> getSxggList() {
		return sxggList;
	}

	public void setSxggList(List<SxggDTO> sxggList) {
		this.sxggList = sxggList;
	}

	public List<FyggDTO> getFyggList() {
		return fyggList;
	}

	public void setFyggList(List<FyggDTO> fyggList) {
		this.fyggList = fyggList;
	}

	public List<WdhmdDTO> getWdhmdList() {
		return wdhmdList;
	}

	public void setWdhmdList(List<WdhmdDTO> wdhmdList) {
		this.wdhmdList = wdhmdList;
	}

	public List<AjlcDTO> getAjlcList() {
		return ajlcList;
	}

	public void setAjlcList(List<AjlcDTO> ajlcList) {
		this.ajlcList = ajlcList;
	}

	public List<BgtDTO> getBgtList() {
		return bgtList;
	}

	public void setBgtList(List<BgtDTO> bgtList) {
		this.bgtList = bgtList;
	}

}
