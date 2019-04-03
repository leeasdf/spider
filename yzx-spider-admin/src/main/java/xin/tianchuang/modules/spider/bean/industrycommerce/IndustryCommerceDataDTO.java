package xin.tianchuang.modules.spider.bean.industrycommerce;

import java.util.List;

public class IndustryCommerceDataDTO {

	// 企业名称/工商注册号
	/**
	 * 企业-工商信息
	 */
	private List<BasicDTO> basic;
	/**
	 * 股东信息
	 */
	private List<ShareholderDTO> shareholder;
	/**
	 * 高管信息（收费）
	 */
	private List<PersonDTO> person;
	/**
	 * 法人对外投资信息
	 */
	private List<FrinvDTO> frinv;
	/**
	 * 法人其他任职信息
	 */
	private List<FrpositionDTO> frposition;
	/**
	 * 企业对外投资信息
	 */
	private List<EntinvDTO> entinv;
	/**
	 * 工商变更信息
	 */
	private List<AlterDTO> alter;
	/**
	 * 分支机构
	 */
	private List<FiliationDTO> filiation;
	/**
	 * 股权出质历史信息
	 */
	private List<SharesimpawnDTO> sharesimpawn;
	/**
	 * 动产抵押物信息()
	 */
	private List<MordetailDTO> mordetail;
	/**
	 * 动产担保信息
	 */
	private List<MorguainfoDTO> morguainfo;
	/**
	 * 失信被执行人信息
	 */
	private List<PunishbreakDTO> punishbreak;
	/**
	 * 被执行人信息
	 */
	private List<PunishedDTO> punished;
	/**
	 * 清算信息
	 */
	private List<LiquidationDTO> liquidation;
	/**
	 * 行政处罚信息
	 */
	private List<CaseinfoDTO> caseinfo;
	/**
	 * 股权冻结历史信息
	 */
	private List<SharesfrostDTO> sharesfrost;
	// 法人身份证号码
	/**
	 * 企业法⼈信息
	 */
	private List<ReposerDTO> reposer;
	/**
	 * 企业股东信息
	 */
	private List<RyposshaDTO> rypossha;
	/**
	 * 主要管理⼈员信息
	 */
	private List<RyposperDTO> ryposper;

	// 行政处罚历史信息
	// 失信人信息
	// 被执行人信息

	public List<BasicDTO> getBasic() {
		return basic;
	}

	public void setBasic(List<BasicDTO> basic) {
		this.basic = basic;
	}

	public List<ShareholderDTO> getShareholder() {
		return shareholder;
	}

	public void setShareholder(List<ShareholderDTO> shareholder) {
		this.shareholder = shareholder;
	}

	public List<PersonDTO> getPerson() {
		return person;
	}

	public void setPerson(List<PersonDTO> person) {
		this.person = person;
	}

	public List<FrinvDTO> getFrinv() {
		return frinv;
	}

	public void setFrinv(List<FrinvDTO> frinv) {
		this.frinv = frinv;
	}

	public List<FrpositionDTO> getFrposition() {
		return frposition;
	}

	public void setFrposition(List<FrpositionDTO> frposition) {
		this.frposition = frposition;
	}

	public List<EntinvDTO> getEntinv() {
		return entinv;
	}

	public void setEntinv(List<EntinvDTO> entinv) {
		this.entinv = entinv;
	}

	public List<AlterDTO> getAlter() {
		return alter;
	}

	public void setAlter(List<AlterDTO> alter) {
		this.alter = alter;
	}

	public List<FiliationDTO> getFiliation() {
		return filiation;
	}

	public void setFiliation(List<FiliationDTO> filiation) {
		this.filiation = filiation;
	}

	public List<SharesimpawnDTO> getSharesimpawn() {
		return sharesimpawn;
	}

	public void setSharesimpawn(List<SharesimpawnDTO> sharesimpawn) {
		this.sharesimpawn = sharesimpawn;
	}

	public List<MordetailDTO> getMordetail() {
		return mordetail;
	}

	public void setMordetail(List<MordetailDTO> mordetail) {
		this.mordetail = mordetail;
	}

	public List<PunishbreakDTO> getPunishbreak() {
		return punishbreak;
	}

	public void setPunishbreak(List<PunishbreakDTO> punishbreak) {
		this.punishbreak = punishbreak;
	}

	public List<PunishedDTO> getPunished() {
		return punished;
	}

	public void setPunished(List<PunishedDTO> punished) {
		this.punished = punished;
	}

	public List<SharesfrostDTO> getSharesfrost() {
		return sharesfrost;
	}

	public void setSharesfrost(List<SharesfrostDTO> sharesfrost) {
		this.sharesfrost = sharesfrost;
	}

	public List<LiquidationDTO> getLiquidation() {
		return liquidation;
	}

	public void setLiquidation(List<LiquidationDTO> liquidation) {
		this.liquidation = liquidation;
	}

	public List<CaseinfoDTO> getCaseinfo() {
		return caseinfo;
	}

	public void setCaseinfo(List<CaseinfoDTO> caseinfo) {
		this.caseinfo = caseinfo;
	}

	public List<MorguainfoDTO> getMorguainfo() {
		return morguainfo;
	}

	public void setMorguainfo(List<MorguainfoDTO> morguainfo) {
		this.morguainfo = morguainfo;
	}

	public List<ReposerDTO> getReposer() {
		return reposer;
	}

	public void setReposer(List<ReposerDTO> reposer) {
		this.reposer = reposer;
	}

	public List<RyposshaDTO> getRypossha() {
		return rypossha;
	}

	public void setRypossha(List<RyposshaDTO> rypossha) {
		this.rypossha = rypossha;
	}

	public List<RyposperDTO> getRyposper() {
		return ryposper;
	}

	public void setRyposper(List<RyposperDTO> ryposper) {
		this.ryposper = ryposper;
	}

}
