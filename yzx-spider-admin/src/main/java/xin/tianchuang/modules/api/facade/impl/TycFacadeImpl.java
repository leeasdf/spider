package xin.tianchuang.modules.api.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import xin.tianchuang.common.enums.TysDataStateEnum;
import xin.tianchuang.modules.api.bean.v1.RptTnAbnormalDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnAnnouncementcourtDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnBasicInfoDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnBidDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnBranchesDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnChangeDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnCheckDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnCourtNoticeDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnDishonestDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnEquityDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnIcpDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnIllegalDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnImportExportDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnInvestDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnLawsuitDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnOwingTaxDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnPatentDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnPenaltiesDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnPersonDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnShareholdersDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnSoftwareRightAuthorDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnTaxCreditDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnTrademarkDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnWorksRightDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnZhixingDTO;
import xin.tianchuang.modules.api.bean.v1.SpiderResult;
import xin.tianchuang.modules.api.bean.v1.result.RptTnAbnormalResultsDTO;
import xin.tianchuang.modules.api.bean.v1.result.RptTnAnnouncementcourtResultsDTO;
import xin.tianchuang.modules.api.bean.v1.result.RptTnBidResultsDTO;
import xin.tianchuang.modules.api.bean.v1.result.RptTnBranchesResultsDTO;
import xin.tianchuang.modules.api.bean.v1.result.RptTnChangeResultsDTO;
import xin.tianchuang.modules.api.bean.v1.result.RptTnCheckResultsDTO;
import xin.tianchuang.modules.api.bean.v1.result.RptTnCourtNoticeResultsDTO;
import xin.tianchuang.modules.api.bean.v1.result.RptTnDishonestResultsDTO;
import xin.tianchuang.modules.api.bean.v1.result.RptTnEquityResultsDTO;
import xin.tianchuang.modules.api.bean.v1.result.RptTnIcpResultsDTO;
import xin.tianchuang.modules.api.bean.v1.result.RptTnIllegalResultsDTO;
import xin.tianchuang.modules.api.bean.v1.result.RptTnImportExportResultsDTO;
import xin.tianchuang.modules.api.bean.v1.result.RptTnInvestResultsDTO;
import xin.tianchuang.modules.api.bean.v1.result.RptTnLawsuitResultsDTO;
import xin.tianchuang.modules.api.bean.v1.result.RptTnOwingTaxResultsDTO;
import xin.tianchuang.modules.api.bean.v1.result.RptTnPatentResultsDTO;
import xin.tianchuang.modules.api.bean.v1.result.RptTnPenaltiesResultsDTO;
import xin.tianchuang.modules.api.bean.v1.result.RptTnShareholdersResultsDTO;
import xin.tianchuang.modules.api.bean.v1.result.RptTnSoftwareRightResultsDTO;
import xin.tianchuang.modules.api.bean.v1.result.RptTnTaxCreditResultsDTO;
import xin.tianchuang.modules.api.bean.v1.result.RptTnTrademarkResultsDTO;
import xin.tianchuang.modules.api.bean.v1.result.RptTnWorksRightResultsDTO;
import xin.tianchuang.modules.api.bean.v1.result.RptTnZhixingResultsDTO;
import xin.tianchuang.modules.api.facade.tyc.TycBackgroundFacade;
import xin.tianchuang.modules.api.facade.tyc.TycFacade;
import xin.tianchuang.modules.api.facade.tyc.TycKnowledgePropertyFacade;
import xin.tianchuang.modules.api.facade.tyc.TycLawDangerousFacade;
import xin.tianchuang.modules.api.facade.tyc.TycManageDangerousFacade;
import xin.tianchuang.modules.api.facade.tyc.TycManageStatusFacade;
import xin.tianchuang.modules.spider.biz.TycSpiderBiz;
import xin.tianchuang.modules.spider.entity.HighTechZoneEnterpriseInfoEntity;
import xin.tianchuang.modules.spider.service.HighTechZoneEnterpriseInfoService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;

@Component
public class TycFacadeImpl implements TycFacade {

	private static Logger logger = LoggerFactory.getLogger(TycFacade.class);

	public static final String KEY_SUCCESS = "success";
	public static final String KEY_RESULT = "result";
	public static final String KEY_MSG = "msg";

	@Autowired
	private TycBackgroundFacade tycBackgroundFacade;

	@Autowired
	private TycKnowledgePropertyFacade tycKnowledgePropertyFacade;

	@Autowired
	private TycLawDangerousFacade tycLawDangerousFacade;

	@Autowired
	private TycManageDangerousFacade tycManageDangerousFacade;

	@Autowired
	private TycManageStatusFacade tycManageStatusFacade;

	@Autowired
	private HighTechZoneEnterpriseInfoService highTechZoneEnterpriseInfoService;

	@Autowired
	private TycSpiderBiz tycSpiderBiz;

	/**
	 * 分页数
	 */
	private int pagesize = 5;

	@Override
	public JSONObject getBackGround(String name, String creditCode, JSONObject re) {
		RptTnBasicInfoDTO baseDTOs = new RptTnBasicInfoDTO();
		RptTnBranchesResultsDTO branchResultDTOs = new RptTnBranchesResultsDTO();
		RptTnChangeResultsDTO changeDTOs = new RptTnChangeResultsDTO();
		RptTnShareholdersResultsDTO holderDTOs = new RptTnShareholdersResultsDTO();
		RptTnInvestResultsDTO investDTOs = new RptTnInvestResultsDTO();

		RptTnBasicInfoDTO baseEntity = tycBackgroundFacade.getGxstBaseInfo(name, creditCode);
		BeanUtils.copyProperties(baseEntity, baseDTOs);

		List<RptTnShareholdersDTO> holderLs = tycBackgroundFacade.getHolder(name, creditCode);
		if (null != holderLs && holderLs.size() >= 1) {
			holderLs.forEach(entity -> {
				RptTnShareholdersDTO dto = new RptTnShareholdersDTO();
				BeanUtils.copyProperties(entity, dto);
				holderDTOs.setItems(new ArrayList<>());
				holderDTOs.getItems().add(dto);
			});
			holderDTOs.setPageTotal(holderLs.size());
			holderDTOs.setPageNum((holderLs.size() + pagesize - 1) / pagesize);
		}

		List<RptTnBranchesDTO> branchLs = tycBackgroundFacade.getBranch(name, creditCode);
		if (null != branchLs && branchLs.size() >= 1) {
			branchLs.forEach(entity -> {
				RptTnBranchesDTO dto = new RptTnBranchesDTO();
				BeanUtils.copyProperties(entity, dto);
				branchResultDTOs.setItems(new ArrayList<>());
				branchResultDTOs.getItems().add(dto);
			});
			branchResultDTOs.setPageTotal(branchLs.size());
			branchResultDTOs.setPageNum((branchLs.size() + pagesize - 1) / pagesize);
		}

		List<RptTnChangeDTO> changeLs = tycBackgroundFacade.getChange(name, creditCode);
		if (null != changeLs && changeLs.size() >= 1) {
			changeLs.forEach(entity -> {
				RptTnChangeDTO dto = new RptTnChangeDTO();
				BeanUtils.copyProperties(entity, dto);
				changeDTOs.setItems(new ArrayList<>());
				changeDTOs.getItems().add(dto);
			});
			changeDTOs.setPageTotal(changeLs.size());
			changeDTOs.setPageNum((changeLs.size() + pagesize - 1) / pagesize);
		}

		List<RptTnInvestDTO> investLs = tycBackgroundFacade.getInvest(name, creditCode);
		if (null != investLs && investLs.size() >= 1) {
			investLs.forEach(entity -> {
				RptTnInvestDTO dto = new RptTnInvestDTO();
				BeanUtils.copyProperties(entity, dto);
				investDTOs.setItems(new ArrayList<>());
				investDTOs.getItems().add(dto);
			});
			investDTOs.setPageTotal(investLs.size());
			investDTOs.setPageNum((investLs.size() + pagesize - 1) / pagesize);
		}

		List<RptTnPersonDTO> staffLs = tycBackgroundFacade.getStaff(name, creditCode);

		re.put("business", new Gson().toJson(baseDTOs));
		re.put("person", new Gson().toJson(staffLs));
		re.put("shareholder", new Gson().toJson(holderDTOs));
		re.put("invest", new Gson().toJson(investDTOs));
		re.put("change", new Gson().toJson(changeDTOs));
		re.put("branches", new Gson().toJson(branchResultDTOs));
		return re;
	}

	@Override
	public JSONObject getLawDangerous(String name, String creditCode, JSONObject re) {
		RptTnAnnouncementcourtResultsDTO announcementDTOs = new RptTnAnnouncementcourtResultsDTO();
		RptTnCourtNoticeResultsDTO courtDTOs = new RptTnCourtNoticeResultsDTO();
		RptTnDishonestResultsDTO dishonestDTOs = new RptTnDishonestResultsDTO();
		RptTnLawsuitResultsDTO lawsuitDTOs = new RptTnLawsuitResultsDTO();
		RptTnZhixingResultsDTO zhixingDTOs = new RptTnZhixingResultsDTO();

		List<RptTnAnnouncementcourtDTO> announcementLs = tycLawDangerousFacade.getAnnouncement(name, creditCode);
		if (null != announcementLs && announcementLs.size() >= 1) {
			announcementLs.forEach(entity -> {
				RptTnAnnouncementcourtDTO dto = new RptTnAnnouncementcourtDTO();
				BeanUtils.copyProperties(entity, dto);
				announcementDTOs.setItems(new ArrayList<>());
				announcementDTOs.getItems().add(dto);
			});
			announcementDTOs.setPageTotal(announcementLs.size());
			announcementDTOs.setPageNum((announcementLs.size() + pagesize - 1) / pagesize);
		}

		List<RptTnCourtNoticeDTO> courtLs = tycLawDangerousFacade.getCourt(name, creditCode);
		if (null != courtLs && courtLs.size() >= 1) {
			courtLs.forEach(entity -> {
				RptTnCourtNoticeDTO dto = new RptTnCourtNoticeDTO();
				BeanUtils.copyProperties(entity, dto);
				courtDTOs.setItems(new ArrayList<>());
				courtDTOs.getItems().add(dto);
			});
			courtDTOs.setPageTotal(courtLs.size());
			courtDTOs.setPageNum((courtLs.size() + pagesize - 1) / pagesize);
		}

		List<RptTnDishonestDTO> dishonestLs = tycLawDangerousFacade.getDishonest(name, creditCode);
		if (null != dishonestLs && dishonestLs.size() >= 1) {
			dishonestLs.forEach(entity -> {
				RptTnDishonestDTO dto = new RptTnDishonestDTO();
				BeanUtils.copyProperties(entity, dto);
				dishonestDTOs.setItems(new ArrayList<>());
				dishonestDTOs.getItems().add(dto);
			});
			dishonestDTOs.setPageTotal(dishonestLs.size());
			dishonestDTOs.setPageNum((dishonestLs.size() + pagesize - 1) / pagesize);
		}

		List<RptTnLawsuitDTO> lawsuitLs = tycLawDangerousFacade.getLawsuit(name, creditCode);
		if (null != lawsuitLs && lawsuitLs.size() >= 1) {
			lawsuitLs.forEach(entity -> {
				RptTnLawsuitDTO dto = new RptTnLawsuitDTO();
				BeanUtils.copyProperties(entity, dto);
				lawsuitDTOs.setItems(new ArrayList<>());
				lawsuitDTOs.getItems().add(dto);
			});
			lawsuitDTOs.setPageTotal(lawsuitLs.size());
			lawsuitDTOs.setPageNum((lawsuitLs.size() + pagesize - 1) / pagesize);
		}

		List<RptTnZhixingDTO> zhixingLs = tycLawDangerousFacade.getZhixing(name, creditCode);
		if (null != zhixingLs && zhixingLs.size() >= 1) {
			zhixingLs.forEach(entity -> {
				RptTnZhixingDTO dto = new RptTnZhixingDTO();
				BeanUtils.copyProperties(entity, dto);
				zhixingDTOs.setItems(new ArrayList<>());
				zhixingDTOs.getItems().add(dto);
			});
			zhixingDTOs.setPageTotal(zhixingLs.size());
			zhixingDTOs.setPageNum((zhixingLs.size() + pagesize - 1) / pagesize);
		}

		re.put("announcement", new Gson().toJson(announcementDTOs));
		re.put("lawsuit", new Gson().toJson(lawsuitDTOs));
		re.put("courtNotice", new Gson().toJson(courtDTOs));
		re.put("dishonest", new Gson().toJson(dishonestDTOs));
		re.put("zhixing", new Gson().toJson(zhixingDTOs));
		return re;
	}

	@Override
	public JSONObject getManageDangerous(String name, String creditCode, JSONObject re) {
		RptTnAbnormalResultsDTO abnormalDTOs = new RptTnAbnormalResultsDTO();
		RptTnEquityResultsDTO equityDTOs = new RptTnEquityResultsDTO();
		RptTnIllegalResultsDTO illegalDTOs = new RptTnIllegalResultsDTO();
		RptTnOwingTaxResultsDTO owntaxDTOs = new RptTnOwingTaxResultsDTO();
		RptTnPenaltiesResultsDTO punishDTOs = new RptTnPenaltiesResultsDTO();

		List<RptTnAbnormalDTO> abnormalLs = tycManageDangerousFacade.getAbnormal(name, creditCode);
		if (null != abnormalLs && abnormalLs.size() >= 1) {
			abnormalLs.forEach(entity -> {
				RptTnAbnormalDTO dto = new RptTnAbnormalDTO();
				BeanUtils.copyProperties(entity, dto);
				abnormalDTOs.setItems(new ArrayList<>());
				abnormalDTOs.getItems().add(dto);
			});
			abnormalDTOs.setPageTotal(abnormalLs.size());
			abnormalDTOs.setPageNum((abnormalLs.size() + pagesize - 1) / pagesize);
		}

		List<RptTnEquityDTO> equityLs = tycManageDangerousFacade.getEquity(name, creditCode);
		if (null != equityLs && equityLs.size() >= 1) {
			equityLs.forEach(entity -> {
				RptTnEquityDTO dto = new RptTnEquityDTO();
				BeanUtils.copyProperties(entity, dto);
				equityDTOs.setItems(new ArrayList<>());
				equityDTOs.getItems().add(dto);
			});
			equityDTOs.setPageTotal(equityLs.size());
			equityDTOs.setPageNum((equityLs.size() + pagesize - 1) / pagesize);
		}

		List<RptTnIllegalDTO> illegalLs = tycManageDangerousFacade.getIllegal(name, creditCode);
		if (null != illegalLs && illegalLs.size() >= 1) {
			illegalLs.forEach(entity -> {
				RptTnIllegalDTO dto = new RptTnIllegalDTO();
				BeanUtils.copyProperties(entity, dto);
				illegalDTOs.setItems(new ArrayList<>());
				illegalDTOs.getItems().add(dto);
			});
			illegalDTOs.setPageTotal(illegalLs.size());
			illegalDTOs.setPageNum((illegalLs.size() + pagesize - 1) / pagesize);
		}

		List<RptTnOwingTaxDTO> owntaxLs = tycManageDangerousFacade.getOwntax(name, creditCode);
		if (null != owntaxLs && owntaxLs.size() >= 1) {
			owntaxLs.forEach(entity -> {
				RptTnOwingTaxDTO dto = new RptTnOwingTaxDTO();
				BeanUtils.copyProperties(entity, dto);
				owntaxDTOs.setItems(new ArrayList<>());
				owntaxDTOs.getItems().add(dto);
			});

			owntaxDTOs.setPageTotal(owntaxLs.size());
			owntaxDTOs.setPageNum((owntaxLs.size() + pagesize - 1) / pagesize);
		}

		List<RptTnPenaltiesDTO> punishLs = tycManageDangerousFacade.getPunish(name, creditCode);
		if (null != punishLs && punishLs.size() >= 1) {
			punishLs.forEach(entity -> {
				RptTnPenaltiesDTO dto = new RptTnPenaltiesDTO();
				BeanUtils.copyProperties(entity, dto);
				punishDTOs.setItems(new ArrayList<>());
				punishDTOs.getItems().add(dto);
			});
			punishDTOs.setPageTotal(punishLs.size());
			punishDTOs.setPageNum((punishLs.size() + pagesize - 1) / pagesize);
		}

		re.put("abnormal", new Gson().toJson(abnormalDTOs));
		re.put("equity", new Gson().toJson(equityDTOs));
		re.put("owntax", new Gson().toJson(owntaxDTOs));
		re.put("penalties", new Gson().toJson(punishDTOs));

		return re;
	}

	@Override
	public JSONObject getManageStatus(String name, String creditCode, JSONObject re) {

		RptTnBidResultsDTO bidDTOs = new RptTnBidResultsDTO();
		RptTnCheckResultsDTO checkDTOs = new RptTnCheckResultsDTO();
		RptTnImportExportResultsDTO importExportDTOs = new RptTnImportExportResultsDTO();
		RptTnTaxCreditResultsDTO taxCreditDTOs = new RptTnTaxCreditResultsDTO();

		List<RptTnBidDTO> bidLs = tycManageStatusFacade.getBid(name, creditCode);
		if (null != bidLs && bidLs.size() >= 1) {
			bidLs.forEach(entity -> {
				RptTnBidDTO dto = new RptTnBidDTO();
				BeanUtils.copyProperties(entity, dto);
				bidDTOs.setItems(new ArrayList<>());
				bidDTOs.getItems().add(dto);
			});
			bidDTOs.setPageTotal(bidLs.size());
			bidDTOs.setPageNum((bidLs.size() + pagesize - 1) / pagesize);
		}

		List<RptTnCheckDTO> checkLs = tycManageStatusFacade.getCheck(name, creditCode);
		if (null != checkLs && checkLs.size() >= 1) {
			checkLs.forEach(entity -> {
				RptTnCheckDTO dto = new RptTnCheckDTO();
				BeanUtils.copyProperties(entity, dto);
				checkDTOs.setItems(new ArrayList<>());
				checkDTOs.getItems().add(dto);
			});
			checkDTOs.setPageTotal(checkLs.size());
			checkDTOs.setPageNum((checkLs.size() + pagesize - 1) / pagesize);
		}

		List<RptTnImportExportDTO> importExportLs = tycManageStatusFacade.getImportAndExport(name, creditCode);
		if (null != importExportLs && importExportLs.size() >= 1) {
			importExportLs.forEach(entity -> {
				RptTnImportExportDTO dto = new RptTnImportExportDTO();
				BeanUtils.copyProperties(entity, dto);
				importExportDTOs.setItems(new ArrayList<>());
				importExportDTOs.getItems().add(dto);
			});
			importExportDTOs.setPageTotal(importExportLs.size());
			importExportDTOs.setPageNum((importExportLs.size() + pagesize - 1) / pagesize);
		}

		List<RptTnTaxCreditDTO> taxCreditLs = tycManageStatusFacade.getTaxCredit(name, creditCode);
		if (null != taxCreditLs && taxCreditLs.size() >= 1) {
			taxCreditLs.forEach(entity -> {
				RptTnTaxCreditDTO dto = new RptTnTaxCreditDTO();
				BeanUtils.copyProperties(entity, dto);
				taxCreditDTOs.setItems(new ArrayList<>());
				taxCreditDTOs.getItems().add(dto);
			});
			taxCreditDTOs.setPageTotal(taxCreditLs.size());
			taxCreditDTOs.setPageNum((taxCreditLs.size() + pagesize - 1) / pagesize);
		}

		re.put("bid", new Gson().toJson(bidDTOs));
		re.put("check", new Gson().toJson(checkDTOs));
		re.put("importAndExport", new Gson().toJson(importExportDTOs));
		re.put("taxcredit", new Gson().toJson(taxCreditDTOs));
		return re;
	}

	@Override
	public JSONObject getKnowledgeProperty(String name, String creditCode, JSONObject re) {
		RptTnSoftwareRightResultsDTO copyrightDTOs = new RptTnSoftwareRightResultsDTO();
		RptTnWorksRightResultsDTO copyrightWorksDTOs = new RptTnWorksRightResultsDTO();
		RptTnIcpResultsDTO icpDTOs = new RptTnIcpResultsDTO();
		RptTnPatentResultsDTO patentDTOs = new RptTnPatentResultsDTO();
		RptTnTrademarkResultsDTO tmInfoDTOs = new RptTnTrademarkResultsDTO();

		List<RptTnSoftwareRightAuthorDTO> copyrightLs = tycKnowledgePropertyFacade.getCopyright(name, creditCode);
		if (null != copyrightLs && copyrightLs.size() >= 1) {
			copyrightLs.forEach(entity -> {
				RptTnSoftwareRightAuthorDTO dto = new RptTnSoftwareRightAuthorDTO();
				BeanUtils.copyProperties(entity, dto);
				copyrightDTOs.setItems(new ArrayList<>());
				copyrightDTOs.getItems().add(dto);
			});

			copyrightDTOs.setPageTotal(copyrightLs.size());
			copyrightDTOs.setPageNum((copyrightLs.size() + pagesize - 1) / pagesize);
		}

		List<RptTnWorksRightDTO> copyrightWorksLs = tycKnowledgePropertyFacade.getCopyrightWorks(name, creditCode);
		if (null != copyrightWorksLs && copyrightWorksLs.size() >= 1) {
			copyrightWorksLs.forEach(entity -> {
				RptTnWorksRightDTO dto = new RptTnWorksRightDTO();
				BeanUtils.copyProperties(entity, dto);
				copyrightWorksDTOs.setItems(new ArrayList<>());
				copyrightWorksDTOs.getItems().add(dto);
			});
			copyrightWorksDTOs.setPageTotal(copyrightWorksLs.size());
			copyrightWorksDTOs.setPageNum((copyrightWorksLs.size() + pagesize - 1) / pagesize);
		}

		List<RptTnIcpDTO> icpLs = tycKnowledgePropertyFacade.getIcp(name, creditCode);
		if (null != icpLs && icpLs.size() >= 1) {
			icpLs.forEach(entity -> {
				RptTnIcpDTO dto = new RptTnIcpDTO();
				BeanUtils.copyProperties(entity, dto);
				icpDTOs.setItems(new ArrayList<>());
				icpDTOs.getItems().add(dto);
			});
			icpDTOs.setPageTotal(icpLs.size());
			icpDTOs.setPageNum((icpLs.size() + pagesize - 1) / pagesize);
		}

		List<RptTnPatentDTO> patentLs = tycKnowledgePropertyFacade.getPatent(name, creditCode);
		if (null != patentLs && patentLs.size() >= 1) {
			patentLs.forEach(entity -> {
				RptTnPatentDTO dto = new RptTnPatentDTO();
				BeanUtils.copyProperties(entity, dto);
				patentDTOs.setItems(new ArrayList<>());
				patentDTOs.getItems().add(dto);
			});
			patentDTOs.setPageTotal(patentLs.size());
			patentDTOs.setPageNum((patentLs.size() + pagesize - 1) / pagesize);
		}

		List<RptTnTrademarkDTO> tmInfoLs = tycKnowledgePropertyFacade.getTmInfo(name, creditCode);
		if (null != tmInfoLs && tmInfoLs.size() >= 1) {
			tmInfoLs.forEach(entity -> {
				RptTnTrademarkDTO dto = new RptTnTrademarkDTO();
				BeanUtils.copyProperties(entity, dto);
				tmInfoDTOs.setItems(new ArrayList<>());
				tmInfoDTOs.getItems().add(dto);
			});

			tmInfoDTOs.setPageTotal(tmInfoLs.size());
			tmInfoDTOs.setPageNum((tmInfoLs.size() + pagesize - 1) / pagesize);
		}

		re.put("softwareRight", new Gson().toJson(copyrightDTOs)); // 软件著作权
		re.put("worksRight", new Gson().toJson(copyrightWorksDTOs)); // 作品著作权
		re.put("patent", new Gson().toJson(patentDTOs)); // 专利信息
		re.put("trademark", new Gson().toJson(tmInfoDTOs));
		re.put("icp", new Gson().toJson(icpDTOs));
		return re;
	}

	@Override
	public JSONObject getEnterpriseData(String requestJsonParam) {

		JSONObject crawl = new JSONObject();
		crawl.put(KEY_SUCCESS, false);

		long startTime = System.currentTimeMillis();
		logger.info("调用开始：{}", startTime);

		try {
			String result = spider(requestJsonParam);

			crawl.put(KEY_RESULT, result);
			logger.info("获取参数[{}]数据结束：总耗时:{}", requestJsonParam, (System.currentTimeMillis() - startTime));
			logger.info(result);
			crawl.put(KEY_SUCCESS, true);
		} catch (Exception e) {
			logger.info("调用异常[{}]: ", requestJsonParam, e.getMessage());
			e.printStackTrace();
			crawl.put(KEY_MSG, e.getMessage());
		}

		return crawl;
	}

	private String spider(String task) {
		final SpiderResult result = new SpiderResult();
		final JSONObject returnJson = new JSONObject();
		JSONObject param = JSONObject.parseObject(task);

		final String uuid = param.getString("uuid");
		final String enterpriseName = param.getString("enterpriseName");
		final String creditCode = param.getString("creditCode");
		final String pageFlag = param.getString("pageFlag");
		final String type = param.getString("type");

		HighTechZoneEnterpriseInfoEntity entity = highTechZoneEnterpriseInfoService.selectByNameCode(enterpriseName, creditCode);
		if (null == entity) {
			entity = new HighTechZoneEnterpriseInfoEntity();
			entity.setEnterpriseName(enterpriseName);
			entity.setCreditCode(creditCode);
			boolean successFlag = tycSpiderBiz.spiderEnterpriseData(entity);
			if (!successFlag) {
				returnJson.put("code", "500");
				returnJson.put("msg", "爬取失败");
				result.setResult(returnJson.toJSONString());
				return JSON.toJSONString(result);
			}
		}
		JSONObject json = searchList(enterpriseName, creditCode, param);

		returnJson.put("result", json);
		returnJson.put("code", "200");
		returnJson.put("msg", "成功");

		result.setResult(returnJson.toJSONString());
		logger.info("[{}]爬取成功", task);
		return JSON.toJSONString(result);
	}

	private JSONObject searchList(String enterpriseName, String creditCode, JSONObject param) {
		JSONObject re = new JSONObject();
		try {

			HighTechZoneEnterpriseInfoEntity entity = highTechZoneEnterpriseInfoService.selectByNameCode(enterpriseName, creditCode);
			if (null != entity) {
				Integer dataState = entity.getDataState();
				if (null != dataState && TysDataStateEnum.FINISH.key() == dataState) {
					this.getBackGround(enterpriseName, creditCode, re);
					this.getKnowledgeProperty(enterpriseName, creditCode, re);
					this.getLawDangerous(enterpriseName, creditCode, re);
					this.getManageDangerous(enterpriseName, creditCode, re);
					this.getManageStatus(enterpriseName, creditCode, re);
					return re;
				}
				// 入库查询失败
				re.put("ex", true);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询公司{}异常", param, e);
			re.put("ex", true);
		}

		return re;
	}

}
