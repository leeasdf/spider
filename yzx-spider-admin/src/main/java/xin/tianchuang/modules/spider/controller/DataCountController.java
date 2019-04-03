package xin.tianchuang.modules.spider.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xin.tianchuang.common.utils.R;
import xin.tianchuang.modules.spider.form.EnterpriseSearchCountListForm;
import xin.tianchuang.modules.spider.service.RptTnAbnormalService;
import xin.tianchuang.modules.spider.service.RptTnAnnouncementcourtService;
import xin.tianchuang.modules.spider.service.RptTnBasicInfoService;
import xin.tianchuang.modules.spider.service.RptTnBidService;
import xin.tianchuang.modules.spider.service.RptTnBondService;
import xin.tianchuang.modules.spider.service.RptTnBranchesService;
import xin.tianchuang.modules.spider.service.RptTnBusroleService;
import xin.tianchuang.modules.spider.service.RptTnCertificateService;
import xin.tianchuang.modules.spider.service.RptTnChangeService;
import xin.tianchuang.modules.spider.service.RptTnCheckService;
import xin.tianchuang.modules.spider.service.RptTnCourtNoticeService;
import xin.tianchuang.modules.spider.service.RptTnDishonestService;
import xin.tianchuang.modules.spider.service.RptTnEntPersonCmpanyService;
import xin.tianchuang.modules.spider.service.RptTnEquityService;
import xin.tianchuang.modules.spider.service.RptTnIcpService;
import xin.tianchuang.modules.spider.service.RptTnIllegalService;
import xin.tianchuang.modules.spider.service.RptTnImportExportService;
import xin.tianchuang.modules.spider.service.RptTnInvestService;
import xin.tianchuang.modules.spider.service.RptTnJudicialAidService;
import xin.tianchuang.modules.spider.service.RptTnLawsuitService;
import xin.tianchuang.modules.spider.service.RptTnLicensingXyzgService;
import xin.tianchuang.modules.spider.service.RptTnMortgageService;
import xin.tianchuang.modules.spider.service.RptTnOwingTaxService;
import xin.tianchuang.modules.spider.service.RptTnPatentService;
import xin.tianchuang.modules.spider.service.RptTnPenaltiesService;
import xin.tianchuang.modules.spider.service.RptTnPersonService;
import xin.tianchuang.modules.spider.service.RptTnProductService;
import xin.tianchuang.modules.spider.service.RptTnPurchaselandService;
import xin.tianchuang.modules.spider.service.RptTnReportService;
import xin.tianchuang.modules.spider.service.RptTnShareholdersService;
import xin.tianchuang.modules.spider.service.RptTnSoftwareRightAuthorService;
import xin.tianchuang.modules.spider.service.RptTnSoftwareRightService;
import xin.tianchuang.modules.spider.service.RptTnTaxCreditService;
import xin.tianchuang.modules.spider.service.RptTnTrademarkService;
import xin.tianchuang.modules.spider.service.RptTnWorksRightService;
import xin.tianchuang.modules.spider.service.RptTnZhixingService;

@RestController
@RequestMapping("spider/datacount")
@Api("数据统计")
public class DataCountController {
	@Autowired
	private RptTnAbnormalService rptTnAbnormalService;
	@Autowired
	private RptTnAnnouncementcourtService rptTnAnnouncementcourtService;
	@Autowired
	private RptTnBasicInfoService rptTnBasicInfoService;
	@Autowired
	private RptTnBidService rptTnBidService;
	@Autowired
	private RptTnBondService rptTnBondService;
	@Autowired
	private RptTnBranchesService rptTnBranchesService;
	@Autowired
	private RptTnBusroleService rptTnBusroleService;
	@Autowired
	private RptTnCertificateService rptTnCertificateService;
	@Autowired
	private RptTnChangeService rptTnChangeService;
	@Autowired
	private RptTnCheckService rptTnCheckService;
	@Autowired
	private RptTnCourtNoticeService rptTnCourtNoticeService;
	@Autowired
	private RptTnDishonestService rptTnDishonestService;
	@Autowired
	private RptTnEntPersonCmpanyService rptTnEntPersonCmpanyService;
	@Autowired
	private RptTnEquityService rptTnEquityService;
	@Autowired
	private RptTnIcpService rptTnIcpService;
	@Autowired
	private RptTnIllegalService rptTnIllegalService;
	@Autowired
	private RptTnImportExportService rptTnImportExportService;
	@Autowired
	private RptTnInvestService rptTnInvestService;
	@Autowired
	private RptTnJudicialAidService rptTnJudicialAidService;
	@Autowired
	private RptTnLawsuitService rptTnLawsuitService;
	@Autowired
	private RptTnLicensingXyzgService rptTnLicensingXyzgService;
	@Autowired
	private RptTnMortgageService rptTnMortgageService;
	@Autowired
	private RptTnOwingTaxService rptTnOwingTaxService;
	@Autowired
	private RptTnPatentService rptTnPatentService;
	@Autowired
	private RptTnPenaltiesService rptTnPenaltiesService;
	@Autowired
	private RptTnPersonService rptTnPersonService;
	@Autowired
	private RptTnProductService rptTnProductService;
	@Autowired
	private RptTnPurchaselandService rptTnPurchaselandService;
	@Autowired
	private RptTnReportService rptTnReportService;
	@Autowired
	private RptTnShareholdersService rptTnShareholdersService;
	@Autowired
	private RptTnSoftwareRightService rptTnSoftwareRightService;
	@Autowired
	private RptTnSoftwareRightAuthorService rptTnSoftwareRightAuthorService;
	@Autowired
	private RptTnTaxCreditService rptTnTaxCreditService;
	@Autowired
	private RptTnTrademarkService rptTnTrademarkService;
	@Autowired
	private RptTnWorksRightService rptTnWorksRightService;
	@Autowired
	private RptTnZhixingService rptTnZhixingService;

	@RequestMapping("/search/{enterpriseId}")
	// @RequiresPermissions("spider:hightechzoneenterpriseinfo:info")
	@ApiOperation("统计信息")
	public R count(@PathVariable("enterpriseId") Long enterpriseId) {
		Integer rptTnAbnormalCount = rptTnAbnormalService.selectCountByEnterpriseId(enterpriseId);
		Integer rptTnAnnouncementcourtCount = rptTnAnnouncementcourtService.selectCountByEnterpriseId(enterpriseId);
		Integer rptTnBasicInfoCount = rptTnBasicInfoService.selectCountByEnterpriseId(enterpriseId);
		Integer rptTnBidCount = rptTnBidService.selectCountByEnterpriseId(enterpriseId);
		Integer rptTnBondCount = rptTnBondService.selectCountByEnterpriseId(enterpriseId);
		Integer rptTnBranchesCount = rptTnBranchesService.selectCountByEnterpriseId(enterpriseId);
		Integer rptTnCertificateCount = rptTnCertificateService.selectCountByEnterpriseId(enterpriseId);
		Integer rptTnChangeCount = rptTnChangeService.selectCountByEnterpriseId(enterpriseId);
		Integer rptTnCheckCount = rptTnCheckService.selectCountByEnterpriseId(enterpriseId);
		Integer rptTnCourtNoticeCount = rptTnCourtNoticeService.selectCountByEnterpriseId(enterpriseId);
		Integer rptTnDishonestCount = rptTnDishonestService.selectCountByEnterpriseId(enterpriseId);
		Integer rptTnEquityCount = rptTnEquityService.selectCountByEnterpriseId(enterpriseId);
		Integer rptTnIcpCount = rptTnIcpService.selectCountByEnterpriseId(enterpriseId);
		Integer rptTnIllegalCount = rptTnIllegalService.selectCountByEnterpriseId(enterpriseId);
		Integer rptTnImportExportCount = rptTnImportExportService.selectCountByEnterpriseId(enterpriseId);
		Integer rptTnInvestCount = rptTnInvestService.selectCountByEnterpriseId(enterpriseId);
		Integer rptTnJudicialAidCount = rptTnJudicialAidService.selectCountByEnterpriseId(enterpriseId);
		Integer rptTnLawsuitCount = rptTnLawsuitService.selectCountByEnterpriseId(enterpriseId);
		Integer rptTnLicensingXyzgCount = rptTnLicensingXyzgService.selectCountByEnterpriseId(enterpriseId);
		Integer rptTnMortgageCount = rptTnMortgageService.selectCountByEnterpriseId(enterpriseId);
		Integer rptTnOwingTaxCount = rptTnOwingTaxService.selectCountByEnterpriseId(enterpriseId);
		Integer rptTnPatentCount = rptTnPatentService.selectCountByEnterpriseId(enterpriseId);
		Integer rptTnPenaltiesCount = rptTnPenaltiesService.selectCountByEnterpriseId(enterpriseId);
		Integer rptTnPersonCount = rptTnPersonService.selectCountByEnterpriseId(enterpriseId);
		Integer rptTnProductCount = rptTnProductService.selectCountByEnterpriseId(enterpriseId);
		Integer rptTnPurchaselandCount = rptTnPurchaselandService.selectCountByEnterpriseId(enterpriseId);
		Integer rptTnReportCount = rptTnReportService.selectCountByEnterpriseId(enterpriseId);
		Integer rptTnShareholdersCount = rptTnShareholdersService.selectCountByEnterpriseId(enterpriseId);
		Integer rptTnSoftwareRightCount = rptTnSoftwareRightService.selectCountByEnterpriseId(enterpriseId);
		Integer rptTnSoftwareRightAuthorCount = rptTnSoftwareRightAuthorService.selectCountByEnterpriseId(enterpriseId);
		Integer rptTnTaxCreditCount = rptTnTaxCreditService.selectCountByEnterpriseId(enterpriseId);
		Integer rptTnTrademarkCount = rptTnTrademarkService.selectCountByEnterpriseId(enterpriseId);
		Integer rptTnWorksRightCount = rptTnWorksRightService.selectCountByEnterpriseId(enterpriseId);
		Integer rptTnZhixingCount = rptTnZhixingService.selectCountByEnterpriseId(enterpriseId);

		EnterpriseSearchCountListForm countList = new EnterpriseSearchCountListForm();
		countList.setAbnormalCount(rptTnAbnormalCount);
		countList.setAnnouncementcourtCount(rptTnAnnouncementcourtCount);
		countList.setBasicInfoCount(rptTnBasicInfoCount);
		countList.setBidCount(rptTnBidCount);
		countList.setBondCount(rptTnBondCount);
		countList.setBranchesCount(rptTnBranchesCount);
		countList.setCertificateCount(rptTnCertificateCount);
		countList.setChangeCount(rptTnChangeCount);
		countList.setCheckCount(rptTnCheckCount);
		countList.setCourtNoticeCount(rptTnCourtNoticeCount);
		countList.setDishonestCount(rptTnDishonestCount);
		countList.setEquityCount(rptTnEquityCount);
		countList.setIcpCount(rptTnIcpCount);
		countList.setIllegalCount(rptTnIllegalCount);
		countList.setImportExportCount(rptTnImportExportCount);
		countList.setInvestCount(rptTnInvestCount);
		countList.setJudicialAidCount(rptTnJudicialAidCount);
		countList.setLawsuitCount(rptTnLawsuitCount);
		countList.setLicensingXyzgCount(rptTnLicensingXyzgCount);
		countList.setMortgageCount(rptTnMortgageCount);
		countList.setOwingTaxCount(rptTnOwingTaxCount);
		countList.setPatentCount(rptTnPatentCount);
		countList.setPenaltiesCount(rptTnPenaltiesCount);
		countList.setPersonCount(rptTnPersonCount);
		countList.setProductCount(rptTnProductCount);
		countList.setPurchaselandCount(rptTnPurchaselandCount);
		countList.setReportCount(rptTnReportCount);
		countList.setShareholdersCount(rptTnShareholdersCount);
		countList.setSoftwareRightCount(rptTnSoftwareRightCount);
		countList.setSoftwareRightAuthorCount(rptTnSoftwareRightAuthorCount);
		countList.setTaxCreditCount(rptTnTaxCreditCount);
		countList.setTrademarkCount(rptTnTrademarkCount);
		countList.setWorksRightCount(rptTnWorksRightCount);
		countList.setZhixingCount(rptTnZhixingCount);
		return R.ok().put("enterpriseCountList", countList);
	}
}
