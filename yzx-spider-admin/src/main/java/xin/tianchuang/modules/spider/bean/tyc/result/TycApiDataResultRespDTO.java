package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;

import xin.tianchuang.modules.spider.bean.tyc.dto.ListResultsDTO;
import xin.tianchuang.modules.spider.bean.tyc.dto.PersonResultDTO;

public class TycApiDataResultRespDTO extends BaseTycResultsDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6985204404605039856L;
	private TaxCreditResultsDTO taxcredit;
	private OwingTaxResultsDTO owingTax;
	private ImportExportResultsDTO importAndExport;
	private JudicialAidResultsDTO judicialAid;
	private PatentResultsDTO patent;

	private PenaltiesResultsDTO penalties;
	private LawsuitResultsDTO lawsuit;
	private InvestResultsDTO invest;
	private CertificateResultsDTO certificate;
	private SoftwareRightResultsDTO softwareRight;

	private EquityResultsDTO equity;
	private MortgageResultsDTO mortgage;
	private ZhixingResultsDTO zhixing;
	private CourtNoticeResultsDTO courtNotice;
	private IcpResultsDTO icp;

	private LicensingXyzgResultsDTO licensingXyzg;
	private TrademarkResultsDTO trademark;
	private SimpleBackgroundResultDTO simpleBackground;
	private LicensingResultDTO licensing;
	private TouziResultDTO touzi;

	private JingpinResultDTO jingpin;
	private ProductResultsDTO product;
	private PunishCreditchinaResultDTO punishCreditchina;
	private BusinessResultDTO business;
	private DishonestResultsDTO dishonest;

	private ChangeResultsDTO change;
	private ShareholderResultsDTO shareholder;
	private CheckResultsDTO check;
	private BranchesResultsDTO branches;
	private IllegalResultsDTO illegal;

	private BondResultsDTO bond;
	private ClearingResultDTO clearing;
	private AbnormalResultsDTO abnormal;
	private PurchaselandResultDTO purchaseland;
	private List<PersonResultDTO> person;

	private ReportResultsDTO report;
	private WorksRightResultsDTO worksRight;
	private AnnouncementcourtResultsDTO announcementcourt;
	private List<ListResultsDTO> listResults;
	private BidResultsDTO bid;

	private RongziResultsDTO rongzi;
	private JudicialSaleResultsDTO judicialSale;

	public TaxCreditResultsDTO getTaxcredit() {
		return taxcredit;
	}

	public void setTaxcredit(TaxCreditResultsDTO taxcredit) {
		this.taxcredit = taxcredit;
	}

	public OwingTaxResultsDTO getOwingTax() {
		return owingTax;
	}

	public void setOwingTax(OwingTaxResultsDTO owingTax) {
		this.owingTax = owingTax;
	}

	public ImportExportResultsDTO getImportAndExport() {
		return importAndExport;
	}

	public void setImportAndExport(ImportExportResultsDTO importAndExport) {
		this.importAndExport = importAndExport;
	}

	public JudicialAidResultsDTO getJudicialAid() {
		return judicialAid;
	}

	public void setJudicialAid(JudicialAidResultsDTO judicialAid) {
		this.judicialAid = judicialAid;
	}

	public PatentResultsDTO getPatent() {
		return patent;
	}

	public void setPatent(PatentResultsDTO patent) {
		this.patent = patent;
	}

	public PenaltiesResultsDTO getPenalties() {
		return penalties;
	}

	public void setPenalties(PenaltiesResultsDTO penalties) {
		this.penalties = penalties;
	}

	public LawsuitResultsDTO getLawsuit() {
		return lawsuit;
	}

	public void setLawsuit(LawsuitResultsDTO lawsuit) {
		this.lawsuit = lawsuit;
	}

	public InvestResultsDTO getInvest() {
		return invest;
	}

	public void setInvest(InvestResultsDTO invest) {
		this.invest = invest;
	}

	public CertificateResultsDTO getCertificate() {
		return certificate;
	}

	public void setCertificate(CertificateResultsDTO certificate) {
		this.certificate = certificate;
	}

	public SoftwareRightResultsDTO getSoftwareRight() {
		return softwareRight;
	}

	public void setSoftwareRight(SoftwareRightResultsDTO softwareRight) {
		this.softwareRight = softwareRight;
	}

	public EquityResultsDTO getEquity() {
		return equity;
	}

	public void setEquity(EquityResultsDTO equity) {
		this.equity = equity;
	}

	public MortgageResultsDTO getMortgage() {
		return mortgage;
	}

	public void setMortgage(MortgageResultsDTO mortgage) {
		this.mortgage = mortgage;
	}

	public ZhixingResultsDTO getZhixing() {
		return zhixing;
	}

	public void setZhixing(ZhixingResultsDTO zhixing) {
		this.zhixing = zhixing;
	}

	public CourtNoticeResultsDTO getCourtNotice() {
		return courtNotice;
	}

	public void setCourtNotice(CourtNoticeResultsDTO courtNotice) {
		this.courtNotice = courtNotice;
	}

	public IcpResultsDTO getIcp() {
		return icp;
	}

	public void setIcp(IcpResultsDTO icp) {
		this.icp = icp;
	}

	public LicensingXyzgResultsDTO getLicensingXyzg() {
		return licensingXyzg;
	}

	public void setLicensingXyzg(LicensingXyzgResultsDTO licensingXyzg) {
		this.licensingXyzg = licensingXyzg;
	}

	public TrademarkResultsDTO getTrademark() {
		return trademark;
	}

	public void setTrademark(TrademarkResultsDTO trademark) {
		this.trademark = trademark;
	}

	public SimpleBackgroundResultDTO getSimpleBackground() {
		return simpleBackground;
	}

	public void setSimpleBackground(SimpleBackgroundResultDTO simpleBackground) {
		this.simpleBackground = simpleBackground;
	}

	public LicensingResultDTO getLicensing() {
		return licensing;
	}

	public void setLicensing(LicensingResultDTO licensing) {
		this.licensing = licensing;
	}

	public TouziResultDTO getTouzi() {
		return touzi;
	}

	public void setTouzi(TouziResultDTO touzi) {
		this.touzi = touzi;
	}

	public JingpinResultDTO getJingpin() {
		return jingpin;
	}

	public void setJingpin(JingpinResultDTO jingpin) {
		this.jingpin = jingpin;
	}

	public ProductResultsDTO getProduct() {
		return product;
	}

	public void setProduct(ProductResultsDTO product) {
		this.product = product;
	}

	public PunishCreditchinaResultDTO getPunishCreditchina() {
		return punishCreditchina;
	}

	public void setPunishCreditchina(PunishCreditchinaResultDTO punishCreditchina) {
		this.punishCreditchina = punishCreditchina;
	}

	public BusinessResultDTO getBusiness() {
		return business;
	}

	public void setBusiness(BusinessResultDTO business) {
		this.business = business;
	}

	public DishonestResultsDTO getDishonest() {
		return dishonest;
	}

	public void setDishonest(DishonestResultsDTO dishonest) {
		this.dishonest = dishonest;
	}

	public ChangeResultsDTO getChange() {
		return change;
	}

	public void setChange(ChangeResultsDTO change) {
		this.change = change;
	}

	public ShareholderResultsDTO getShareholder() {
		return shareholder;
	}

	public void setShareholder(ShareholderResultsDTO shareholder) {
		this.shareholder = shareholder;
	}

	public CheckResultsDTO getCheck() {
		return check;
	}

	public void setCheck(CheckResultsDTO check) {
		this.check = check;
	}

	public BranchesResultsDTO getBranches() {
		return branches;
	}

	public void setBranches(BranchesResultsDTO branches) {
		this.branches = branches;
	}

	public IllegalResultsDTO getIllegal() {
		return illegal;
	}

	public void setIllegal(IllegalResultsDTO illegal) {
		this.illegal = illegal;
	}

	public BondResultsDTO getBond() {
		return bond;
	}

	public void setBond(BondResultsDTO bond) {
		this.bond = bond;
	}

	public ClearingResultDTO getClearing() {
		return clearing;
	}

	public void setClearing(ClearingResultDTO clearing) {
		this.clearing = clearing;
	}

	public AbnormalResultsDTO getAbnormal() {
		return abnormal;
	}

	public void setAbnormal(AbnormalResultsDTO abnormal) {
		this.abnormal = abnormal;
	}

	public PurchaselandResultDTO getPurchaseland() {
		return purchaseland;
	}

	public void setPurchaseland(PurchaselandResultDTO purchaseland) {
		this.purchaseland = purchaseland;
	}

	public List<PersonResultDTO> getPerson() {
		return person;
	}

	public void setPerson(List<PersonResultDTO> person) {
		this.person = person;
	}

	public WorksRightResultsDTO getWorksRight() {
		return worksRight;
	}

	public void setWorksRight(WorksRightResultsDTO worksRight) {
		this.worksRight = worksRight;
	}

	public AnnouncementcourtResultsDTO getAnnouncementcourt() {
		return announcementcourt;
	}

	public void setAnnouncementcourt(AnnouncementcourtResultsDTO announcementcourt) {
		this.announcementcourt = announcementcourt;
	}

	public List<ListResultsDTO> getListResults() {
		return listResults;
	}

	public void setListResults(List<ListResultsDTO> listResults) {
		this.listResults = listResults;
	}

	public BidResultsDTO getBid() {
		return bid;
	}

	public void setBid(BidResultsDTO bid) {
		this.bid = bid;
	}

	public RongziResultsDTO getRongzi() {
		return rongzi;
	}

	public void setRongzi(RongziResultsDTO rongzi) {
		this.rongzi = rongzi;
	}

	public JudicialSaleResultsDTO getJudicialSale() {
		return judicialSale;
	}

	public void setJudicialSale(JudicialSaleResultsDTO judicialSale) {
		this.judicialSale = judicialSale;
	}

	public ReportResultsDTO getReport() {
		return report;
	}

	public void setReport(ReportResultsDTO report) {
		this.report = report;
	}

}
