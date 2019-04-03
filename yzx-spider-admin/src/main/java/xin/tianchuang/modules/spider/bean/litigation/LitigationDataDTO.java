package xin.tianchuang.modules.spider.bean.litigation;

import java.util.List;

public class LitigationDataDTO {
	private int totalCount; // 所有信息数量
	private int totalPageNum; // 所有信息总页码数
	private int pageNo; // 当前页码数
	private int range; // 每页数量
	private int cpwsCount; // 信息数量

	private int cpwsPageNum; // 信息总页码数
	private int ktggCount; // 开庭公告信息数量
	private int ktggPageNum; // 开庭公告信息总页码数
	private int zxggCount; // 执行公告信息数量
	private int zxggPageNum; // 执行公告信息总页码数

	private int sxggCount; // 失信公告信息数量
	private int sxggPageNum; // 失信公告信息总页码数
	private int fyggCount; // 法院公告信息数量
	private int fyggPageNum; // 法院公告信息总页码数
	private int wdhmdCount; // 网贷⿊名单信息数量

	private int wdhmdPageNum; // 网贷⿊名单信息总页码数
	private int ajlcCount; // 案件流程信息数量
	private int ajlcPageNum; // 案件流程信息总页码数
	private List<AllDTO> allList; // 所有涉诉信息概要（不传datatype返回）
	private List<CpwsDTO> cpwsList; // 裁判⽂书涉诉概要信息（datatype=‘cpws’时才返回）

	private List<KtggDTO> ktggList; // 开庭公告信息概要（datatype=‘ktgg’时才返回）
	private List<ZxggDTO> zxggList; // 执行公告信息概要（datatype=‘zxgg’时才返回）
	private List<SxggDTO> sxggList; // 失信公告信息概要（datatype=‘sxgg’时才返回）
	private List<FyggDTO> fyggList; // 法院公告信息概要（datatype=‘fygg’时才返回）
	private List<WdhmdDTO> wdhmdList; // 网贷⿊名单信息概要（datatype=‘wdhmd’时才返回）

	private List<AjlcDTO> ajlcList; // 案件流程信息概要（datatype=‘ajlc’时才返回）
	private List<BgtDTO> bgtList; // 曝光台信息概要（datatype=‘bgt’时才返回）

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPageNum() {
		return totalPageNum;
	}

	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getCpwsCount() {
		return cpwsCount;
	}

	public void setCpwsCount(int cpwsCount) {
		this.cpwsCount = cpwsCount;
	}

	public int getCpwsPageNum() {
		return cpwsPageNum;
	}

	public void setCpwsPageNum(int cpwsPageNum) {
		this.cpwsPageNum = cpwsPageNum;
	}

	public int getKtggCount() {
		return ktggCount;
	}

	public void setKtggCount(int ktggCount) {
		this.ktggCount = ktggCount;
	}

	public int getKtggPageNum() {
		return ktggPageNum;
	}

	public void setKtggPageNum(int ktggPageNum) {
		this.ktggPageNum = ktggPageNum;
	}

	public int getZxggCount() {
		return zxggCount;
	}

	public void setZxggCount(int zxggCount) {
		this.zxggCount = zxggCount;
	}

	public int getZxggPageNum() {
		return zxggPageNum;
	}

	public void setZxggPageNum(int zxggPageNum) {
		this.zxggPageNum = zxggPageNum;
	}

	public int getSxggCount() {
		return sxggCount;
	}

	public void setSxggCount(int sxggCount) {
		this.sxggCount = sxggCount;
	}

	public int getSxggPageNum() {
		return sxggPageNum;
	}

	public void setSxggPageNum(int sxggPageNum) {
		this.sxggPageNum = sxggPageNum;
	}

	public int getFyggCount() {
		return fyggCount;
	}

	public void setFyggCount(int fyggCount) {
		this.fyggCount = fyggCount;
	}

	public int getFyggPageNum() {
		return fyggPageNum;
	}

	public void setFyggPageNum(int fyggPageNum) {
		this.fyggPageNum = fyggPageNum;
	}

	public int getWdhmdCount() {
		return wdhmdCount;
	}

	public void setWdhmdCount(int wdhmdCount) {
		this.wdhmdCount = wdhmdCount;
	}

	public int getWdhmdPageNum() {
		return wdhmdPageNum;
	}

	public void setWdhmdPageNum(int wdhmdPageNum) {
		this.wdhmdPageNum = wdhmdPageNum;
	}

	public int getAjlcCount() {
		return ajlcCount;
	}

	public void setAjlcCount(int ajlcCount) {
		this.ajlcCount = ajlcCount;
	}

	public int getAjlcPageNum() {
		return ajlcPageNum;
	}

	public void setAjlcPageNum(int ajlcPageNum) {
		this.ajlcPageNum = ajlcPageNum;
	}

	public List<AllDTO> getAllList() {
		return allList;
	}

	public void setAllList(List<AllDTO> allList) {
		this.allList = allList;
	}

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
