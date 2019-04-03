package xin.tianchuang.modules.spider.bean.enterprise.verify;

import java.util.List;

import xin.tianchuang.modules.spider.bean.industrycommerce.PunishbreakDTO;

public class ContentDTO {

	private EnterpriseBasicInfoDTO enterpriseBasicInfo; // 照面信息

	private List<ShareHolderDTO> shareHolders; // 股东信息列表

	private List<ManagerDTO> managers;// 企业⾼管信息

	private List<PunishbreakDTO> punishbreaks;// 失信情况

	private List<PunishDTO> punishes;// 企业被判决信息列表

	private List<DebtDTO> debts;// 网贷信息列表

	private List<ChangeDTO> changes;// 变更信息

	private List<AnnualReportDTO> annualReports;// 企业年报

	private OperatingAnomalyDTO operatingAnomaly;// 经营异常信息

	public EnterpriseBasicInfoDTO getEnterpriseBasicInfo() {
		return enterpriseBasicInfo;
	}

	public void setEnterpriseBasicInfo(EnterpriseBasicInfoDTO enterpriseBasicInfo) {
		this.enterpriseBasicInfo = enterpriseBasicInfo;
	}

	public List<ShareHolderDTO> getShareHolders() {
		return shareHolders;
	}

	public void setShareHolders(List<ShareHolderDTO> shareHolders) {
		this.shareHolders = shareHolders;
	}

	public List<ManagerDTO> getManagers() {
		return managers;
	}

	public void setManagers(List<ManagerDTO> managers) {
		this.managers = managers;
	}

	public List<PunishbreakDTO> getPunishbreaks() {
		return punishbreaks;
	}

	public void setPunishbreaks(List<PunishbreakDTO> punishbreaks) {
		this.punishbreaks = punishbreaks;
	}

	public List<PunishDTO> getPunishes() {
		return punishes;
	}

	public void setPunishes(List<PunishDTO> punishes) {
		this.punishes = punishes;
	}

	public List<DebtDTO> getDebts() {
		return debts;
	}

	public void setDebts(List<DebtDTO> debts) {
		this.debts = debts;
	}

	public List<ChangeDTO> getChanges() {
		return changes;
	}

	public void setChanges(List<ChangeDTO> changes) {
		this.changes = changes;
	}

	public List<AnnualReportDTO> getAnnualReports() {
		return annualReports;
	}

	public void setAnnualReports(List<AnnualReportDTO> annualReports) {
		this.annualReports = annualReports;
	}

	public OperatingAnomalyDTO getOperatingAnomaly() {
		return operatingAnomaly;
	}

	public void setOperatingAnomaly(OperatingAnomalyDTO operatingAnomaly) {
		this.operatingAnomaly = operatingAnomaly;
	}

}
