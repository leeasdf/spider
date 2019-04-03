package xin.tianchuang.modules.spider.bean.litigation;

import java.util.List;

public class LitigationDetailDataDTO {
	private List<CpwsDTO> cpws; // 裁判⽂书涉诉概要信息（datatype=‘cpws’时才返回）
	private List<KtggDTO> ktgg; // 开庭公告信息概要（datatype=‘ktgg’时才返回）
	private List<ZxggDTO> zxgg; // 执⾏公告信息概要（datatype=‘zxgg’时才返回）
	private List<SxggDTO> sxgg; // 失信公告信息概要（datatype=‘sxgg’时才返回）
	private List<FyggDTO> fygg; // 法院公告信息概要（datatype=‘fygg’时才返回）
	
	private List<WdhmdDTO> wdhmd; // 网贷⿊名单信息概要（datatype=‘wdhmd’时才返回）
	private List<AjlcDTO> ajlc; // 案件流程信息概要（datatype=‘ajlc’时才返回）
	private List<BgtDTO> bgt; // 曝光台信息概要（datatype=‘bgt’时才返回）

	public List<CpwsDTO> getCpws() {
		return cpws;
	}

	public void setCpws(List<CpwsDTO> cpws) {
		this.cpws = cpws;
	}

	public List<KtggDTO> getKtgg() {
		return ktgg;
	}

	public void setKtgg(List<KtggDTO> ktgg) {
		this.ktgg = ktgg;
	}

	public List<ZxggDTO> getZxgg() {
		return zxgg;
	}

	public void setZxgg(List<ZxggDTO> zxgg) {
		this.zxgg = zxgg;
	}

	public List<SxggDTO> getSxgg() {
		return sxgg;
	}

	public void setSxgg(List<SxggDTO> sxgg) {
		this.sxgg = sxgg;
	}

	public List<FyggDTO> getFygg() {
		return fygg;
	}

	public void setFygg(List<FyggDTO> fygg) {
		this.fygg = fygg;
	}

	public List<WdhmdDTO> getWdhmd() {
		return wdhmd;
	}

	public void setWdhmd(List<WdhmdDTO> wdhmd) {
		this.wdhmd = wdhmd;
	}

	public List<AjlcDTO> getAjlc() {
		return ajlc;
	}

	public void setAjlc(List<AjlcDTO> ajlc) {
		this.ajlc = ajlc;
	}

	public List<BgtDTO> getBgt() {
		return bgt;
	}

	public void setBgt(List<BgtDTO> bgt) {
		this.bgt = bgt;
	}

}
