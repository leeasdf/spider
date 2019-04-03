package xin.tianchuang.modules.api.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import xin.tianchuang.common.validator.ValidatorUtils;
import xin.tianchuang.modules.api.annotation.ApiToken;
import xin.tianchuang.modules.api.bean.v1.ApiResultDTO;
import xin.tianchuang.modules.api.bean.v1.RptTcxyCompanyCopyrightDTO;
import xin.tianchuang.modules.api.bean.v1.RptTcxyCompanySoftwareCopyrightDTO;
import xin.tianchuang.modules.api.bean.v1.RptTcxyIPRDTO;
import xin.tianchuang.modules.api.bean.v1.RptTcxyPatentBaseDTO;
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
import xin.tianchuang.modules.api.bean.v1.result.RptTnPersonResultsDTO;
import xin.tianchuang.modules.api.bean.v1.result.RptTnShareholdersResultsDTO;
import xin.tianchuang.modules.api.bean.v1.result.RptTnSoftwareRightResultsDTO;
import xin.tianchuang.modules.api.bean.v1.result.RptTnTaxCreditResultsDTO;
import xin.tianchuang.modules.api.bean.v1.result.RptTnTrademarkResultsDTO;
import xin.tianchuang.modules.api.bean.v1.result.RptTnWorksRightResultsDTO;
import xin.tianchuang.modules.api.bean.v1.result.RptTnZhixingResultsDTO;
import xin.tianchuang.modules.api.facade.tcxy.TcxyKnowledgePropertyFacade;
import xin.tianchuang.modules.api.facade.tyc.TycBackgroundFacade;
import xin.tianchuang.modules.api.facade.tyc.TycFacade;
import xin.tianchuang.modules.api.facade.tyc.TycKnowledgePropertyFacade;
import xin.tianchuang.modules.api.facade.tyc.TycLawDangerousFacade;
import xin.tianchuang.modules.api.facade.tyc.TycManageDangerousFacade;
import xin.tianchuang.modules.api.facade.tyc.TycManageStatusFacade;
import xin.tianchuang.modules.api.form.ApiQueryForm;
import xin.tianchuang.modules.api.form.ApiSearchForm;
import xin.tianchuang.modules.spider.service.HighTechZoneEnterpriseInfoService;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;

@ApiModel(value = "api接口-v1版本")
@RestController
@RequestMapping("/api/v1")
public class TycApiFacadeController {

	private static Logger logger = LoggerFactory.getLogger(TycApiFacadeController.class);

	@Autowired
	private TycFacade tycFacade;
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
	private TcxyKnowledgePropertyFacade tcxyKnowledgePropertyFacade;
	@Autowired
	private HighTechZoneEnterpriseInfoService highTechZoneEnterpriseInfoService;

	/**
	 * 搜索接口
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@GetMapping("/search")
	// @RequiresPermissions("api:v1:search")
	public ApiResultDTO search(ApiSearchForm form) {
		// 表单校验
		ValidatorUtils.validateEntity(form);
		String name = form.getName();
		try {
			logger.info("[{}]API开始获取企业信息: {}", form.getUuid(), name);
			String cnd = JSONObject.toJSONString(form);
			JSONObject re = tycFacade.getEnterpriseData(cnd);
			return ApiResultDTO.ok().put("result", re.getJSONObject("result").getJSONObject("result"));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ApiResultDTO.error(9999, "系统错误");
		}

	}

	private ApiResultDTO validateInfo(String enterpriseName, String creditCode) {
		if (StringUtils.isBlank(enterpriseName) && StringUtils.isBlank(creditCode)) {
			return ApiResultDTO.error(9998, "企业名称和统一社会信用代码不能同时为空");
		}
		return null;
	}

	@ApiToken(desc = "企业基本信息")
	@ApiModelProperty(value = "企业基本信息")
	// background
	@GetMapping("/getGxstBaseInfo")
	// @RequiresPermissions("api:v1:getGxstBaseInfo")
	public ApiResultDTO getGxstBaseInfo(ApiQueryForm api) {
		String name = api.getName();
		String creditCode = api.getCreditCode();
		validateInfo(name, creditCode);
		RptTnBasicInfoDTO dto = tycBackgroundFacade.getGxstBaseInfo(name, creditCode);
		return ApiResultDTO.ok().put("result", new Gson().toJson(dto));

	}

	@ApiToken(desc = "主要人员信息")
	@ApiModelProperty(value = "主要人员信息")
	@ResponseBody
	@GetMapping("/getStaff")
	// @RequiresPermissions("api:v1:getStaff")
	public ApiResultDTO getStaff(ApiQueryForm api) {
		String name = api.getName();
		String creditCode = api.getCreditCode();
		validateInfo(name, creditCode);
		List<RptTnPersonDTO> staffLs = tycBackgroundFacade.getStaff(name, creditCode);
		RptTnPersonResultsDTO staffDTOs = new RptTnPersonResultsDTO();
		if (null != staffLs && staffLs.size() >= 1) {
			staffDTOs.setItems(staffLs);
			staffDTOs.setPageTotal(staffLs.size());
		}
		return ApiResultDTO.ok().put("result", new Gson().toJson(staffLs));

	}

	@ApiToken(desc = "股东信息")
	@ApiModelProperty(value = "股东信息")
	@ResponseBody
	@GetMapping("/getHolder")
	// @RequiresPermissions("api:v1:getHolder")
	public ApiResultDTO getHolder(ApiQueryForm api) {
		String name = api.getName();
		String creditCode = api.getCreditCode();
		validateInfo(name, creditCode);
		List<RptTnShareholdersDTO> holderLs = tycBackgroundFacade.getHolder(name, creditCode);
		RptTnShareholdersResultsDTO holderDTOs = new RptTnShareholdersResultsDTO();
		if (null != holderLs && holderLs.size() >= 1) {
			holderDTOs.setItems(holderLs);
			holderDTOs.setPageTotal(holderLs.size());
		}
		return ApiResultDTO.ok().put("result", new Gson().toJson(holderDTOs));

	}

	@ApiToken(desc = "对外投资信息")
	@ApiModelProperty(value = "对外投资信息")
	@ResponseBody
	@GetMapping("/getInvest")
	// @RequiresPermissions("api:v1:getInvest")
	public ApiResultDTO getInvest(ApiQueryForm api) {
		String name = api.getName();
		String creditCode = api.getCreditCode();
		validateInfo(name, creditCode);
		List<RptTnInvestDTO> investLs = tycBackgroundFacade.getInvest(name, creditCode);
		RptTnInvestResultsDTO investDTOs = new RptTnInvestResultsDTO();
		if (null != investLs && investLs.size() >= 1) {
			investDTOs.setItems(investLs);
			investDTOs.setPageTotal(investLs.size());
		}
		return ApiResultDTO.ok().put("result", new Gson().toJson(investDTOs));

	}

	@ApiToken(desc = "变更记录信息")
	@ApiModelProperty(value = "变更记录信息")
	@ResponseBody
	@GetMapping("/getChange")
	// @RequiresPermissions("api:v1:getChange")
	public ApiResultDTO getChange(ApiQueryForm api) {
		String name = api.getName();
		String creditCode = api.getCreditCode();
		validateInfo(name, creditCode);
		List<RptTnChangeDTO> changeLs = tycBackgroundFacade.getChange(name, creditCode);
		RptTnChangeResultsDTO changeDTOs = new RptTnChangeResultsDTO();
		if (null != changeLs && changeLs.size() >= 1) {
			changeDTOs.setItems(changeLs);
			changeDTOs.setPageTotal(changeLs.size());
		}
		return ApiResultDTO.ok().put("result", new Gson().toJson(changeDTOs));

	}

	@ApiToken(desc = "分支机构信息")
	@ResponseBody
	@GetMapping("/getBranch")
	@ApiModelProperty(value = "分支机构信息")
	// @RequiresPermissions("api:v1:getBranch")
	public ApiResultDTO getBranch(ApiQueryForm api) {
		String name = api.getName();
		String creditCode = api.getCreditCode();
		validateInfo(name, creditCode);
		List<RptTnBranchesDTO> branchLs = tycBackgroundFacade.getBranch(name, creditCode);
		RptTnBranchesResultsDTO branchResultDTOs = new RptTnBranchesResultsDTO();
		if (null != branchLs && branchLs.size() >= 1) {
			branchResultDTOs.setItems(branchLs);
			branchResultDTOs.setPageTotal(branchLs.size());
		}
		return ApiResultDTO.ok().put("result", new Gson().toJson(branchResultDTOs));
	}

	// background

	// Knowledge
	@ApiToken(desc = "商标信息")
	@ApiModelProperty(value = "商标信息")
	@ResponseBody
	@GetMapping("/getTmInfo")
	// @RequiresPermissions("api:v1:getTmInfo")
	public ApiResultDTO getTmInfo(ApiQueryForm api) {
		String name = api.getName();
		String creditCode = api.getCreditCode();
		validateInfo(name, creditCode);
		List<RptTnTrademarkDTO> tmInfoLs = tycKnowledgePropertyFacade.getTmInfo(name, creditCode);
		RptTnTrademarkResultsDTO tmInfoDTOs = new RptTnTrademarkResultsDTO();
		if (null != tmInfoLs && tmInfoLs.size() >= 1) {
			tmInfoDTOs.setItems(tmInfoLs);
			tmInfoDTOs.setPageTotal(tmInfoLs.size());
		}

		return ApiResultDTO.ok().put("result", new Gson().toJson(tmInfoDTOs));

	}

	@ApiToken(desc = "专利信息")
	@ApiModelProperty(value = "专利信息")
	@ResponseBody
	@GetMapping("/getPatent")
	// @RequiresPermissions("api:v1:getPatent")
	public ApiResultDTO getPatent(ApiQueryForm api) {
		String name = api.getName();
		String creditCode = api.getCreditCode();
		validateInfo(name, creditCode);
		List<RptTnPatentDTO> patentLs = tycKnowledgePropertyFacade.getPatent(name, creditCode);
		RptTnPatentResultsDTO patentDTOs = new RptTnPatentResultsDTO();
		if (null != patentLs && patentLs.size() >= 1) {
			patentDTOs.setItems(patentLs);
			patentDTOs.setPageTotal(patentLs.size());
		}
		return ApiResultDTO.ok().put("result", new Gson().toJson(patentDTOs));

	}

	@ApiToken(desc = "软件著作权信息")
	@ApiModelProperty(value = "软件著作权信息")
	@ResponseBody
	@GetMapping("/getCopyright")
	// @RequiresPermissions("api:v1:getCopyright")
	public ApiResultDTO getCopyright(ApiQueryForm api) {
		String name = api.getName();
		String creditCode = api.getCreditCode();
		validateInfo(name, creditCode);
		List<RptTnSoftwareRightAuthorDTO> copyrightLs = tycKnowledgePropertyFacade.getCopyright(name, creditCode);
		RptTnSoftwareRightResultsDTO copyrightDTOs = new RptTnSoftwareRightResultsDTO();
		if (null != copyrightLs && copyrightLs.size() >= 1) {
			copyrightDTOs.setItems(copyrightLs);
			copyrightDTOs.setPageTotal(copyrightLs.size());
		}
		return ApiResultDTO.ok().put("result", new Gson().toJson(copyrightDTOs));
	}

	@ApiToken(desc = "作品著作权信息")
	@ApiModelProperty(value = "作品著作权信息")
	@ResponseBody
	@RequestMapping("/getCopyrightWorks")
	// @RequiresPermissions("api:v1:getCopyrightWorks")
	public ApiResultDTO getCopyrightWorks(ApiQueryForm api) {
		String name = api.getName();
		String creditCode = api.getCreditCode();
		validateInfo(name, creditCode);
		List<RptTnWorksRightDTO> copyrightWorksLs = tycKnowledgePropertyFacade.getCopyrightWorks(name, creditCode);
		RptTnWorksRightResultsDTO copyrightWorksDTOs = new RptTnWorksRightResultsDTO();
		if (null != copyrightWorksLs && copyrightWorksLs.size() >= 1) {
			copyrightWorksLs.forEach(dto -> {
				copyrightWorksDTOs.getItems().add(dto);
			});
			copyrightWorksDTOs.setPageTotal(copyrightWorksLs.size());
		}
		return ApiResultDTO.ok().put("result", new Gson().toJson(copyrightWorksLs));

	}

	@ApiToken(desc = "网站备案信息")
	@ApiModelProperty(value = "网站备案信息")
	@ResponseBody
	@GetMapping("/getIcp")
	// @RequiresPermissions("api:v1:getIcp")
	public ApiResultDTO getIcp(ApiQueryForm api) {
		String name = api.getName();
		String creditCode = api.getCreditCode();
		validateInfo(name, creditCode);
		List<RptTnIcpDTO> icpLs = tycKnowledgePropertyFacade.getIcp(name, creditCode);
		RptTnIcpResultsDTO icpDTOs = new RptTnIcpResultsDTO();
		if (null != icpLs && icpLs.size() >= 1) {
			icpLs.forEach(dto -> {
				icpDTOs.getItems().add(dto);
			});
			icpDTOs.setPageTotal(icpLs.size());
		}
		return ApiResultDTO.ok().put("result", new Gson().toJson(icpDTOs));

	}

	// Knowledge
	@ApiToken(desc = "作品著作权信息")
	// LawDangerous
	@ApiModelProperty(value = "作品著作权信息")
	@ResponseBody
	@GetMapping("/getAnnouncement")
	// @RequiresPermissions("api:v1:getAnnouncement")
	public ApiResultDTO getAnnouncement(ApiQueryForm api) {
		String name = api.getName();
		String creditCode = api.getCreditCode();
		validateInfo(name, creditCode);
		List<RptTnAnnouncementcourtDTO> announcementLs = tycLawDangerousFacade.getAnnouncement(name, creditCode);
		RptTnAnnouncementcourtResultsDTO announcementDTOs = new RptTnAnnouncementcourtResultsDTO();
		if (null != announcementLs && announcementLs.size() >= 1) {
			announcementDTOs.setItems(announcementLs);
			announcementDTOs.setPageTotal(announcementLs.size());
		}
		return ApiResultDTO.ok().put("result", new Gson().toJson(announcementDTOs));

	}

	@ApiToken(desc = "法律诉讼信息")
	@ApiModelProperty(value = "法律诉讼信息")
	@ResponseBody
	@GetMapping("/getLawsuit")
	// @RequiresPermissions("api:v1:getLawsuit")
	public ApiResultDTO getLawsuit(ApiQueryForm api) {
		String name = api.getName();
		String creditCode = api.getCreditCode();
		validateInfo(name, creditCode);
		List<RptTnLawsuitDTO> lawsuitLs = tycLawDangerousFacade.getLawsuit(name, creditCode);
		RptTnLawsuitResultsDTO lawsuitDTOs = new RptTnLawsuitResultsDTO();
		if (null != lawsuitLs && lawsuitLs.size() >= 1) {
			lawsuitDTOs.setItems(lawsuitLs);
			lawsuitDTOs.setPageTotal(lawsuitLs.size());
		}
		return ApiResultDTO.ok().put("result", new Gson().toJson(lawsuitDTOs));

	}

	@ApiToken(desc = "开庭公告信息")
	@ApiModelProperty(value = "开庭公告信息")
	@ResponseBody
	@GetMapping("/getCourt")
	// @RequiresPermissions("api:v1:getCourt")
	public ApiResultDTO getCourt(ApiQueryForm api) {
		String name = api.getName();
		String creditCode = api.getCreditCode();
		validateInfo(name, creditCode);
		List<RptTnCourtNoticeDTO> courtLs = tycLawDangerousFacade.getCourt(name, creditCode);
		RptTnCourtNoticeResultsDTO courtDTOs = new RptTnCourtNoticeResultsDTO();
		if (null != courtLs && courtLs.size() >= 1) {
			courtLs.forEach(dto -> {
				courtDTOs.getItems().add(dto);
			});
			courtDTOs.setPageTotal(courtLs.size());
		}
		return ApiResultDTO.ok().put("result", new Gson().toJson(courtDTOs));

	}

	@ApiToken(desc = "失信人信息")
	@ApiModelProperty(value = "失信人信息")
	@ResponseBody
	@GetMapping("/getDishonest")
	// @RequiresPermissions("api:v1:getDishonest")
	public ApiResultDTO getDishonest(ApiQueryForm api) {
		String name = api.getName();
		String creditCode = api.getCreditCode();
		validateInfo(name, creditCode);
		List<RptTnDishonestDTO> dishonestLs = tycLawDangerousFacade.getDishonest(name, creditCode);
		RptTnDishonestResultsDTO dishonestDTOs = new RptTnDishonestResultsDTO();
		if (null != dishonestLs && dishonestLs.size() >= 1) {
			dishonestLs.forEach(dto -> {
				dishonestDTOs.getItems().add(dto);
			});
			dishonestDTOs.setPageTotal(dishonestLs.size());
		}
		return ApiResultDTO.ok().put("result", new Gson().toJson(dishonestDTOs));

	}

	@ApiToken(desc = "被执行人信息")
	@ApiModelProperty(value = "被执行人信息")
	@ResponseBody
	@GetMapping("/getZhixing")
	// @RequiresPermissions("api:v1:getZhixing")
	public ApiResultDTO getZhixing(ApiQueryForm api) {
		String name = api.getName();
		String creditCode = api.getCreditCode();
		validateInfo(name, creditCode);
		List<RptTnZhixingDTO> zhixingLs = tycLawDangerousFacade.getZhixing(name, creditCode);
		RptTnZhixingResultsDTO zhixingDTOs = new RptTnZhixingResultsDTO();
		if (null != zhixingLs && zhixingLs.size() >= 1) {
			zhixingLs.forEach(dto -> {
				zhixingDTOs.getItems().add(dto);
			});
			zhixingDTOs.setPageTotal(zhixingLs.size());
		}
		return ApiResultDTO.ok().put("result", new Gson().toJson(zhixingDTOs));

	}

	// LawDangerous
	// Manage
	@ApiToken(desc = "经营异常信息")
	@ApiModelProperty(value = "经营异常信息")
	@ResponseBody
	@GetMapping("/getAbnormal")
	// @RequiresPermissions("api:v1:getAbnormal")
	public ApiResultDTO getAbnormal(ApiQueryForm api) {
		String name = api.getName();
		String creditCode = api.getCreditCode();
		validateInfo(name, creditCode);
		List<RptTnAbnormalDTO> abnormalLs = tycManageDangerousFacade.getAbnormal(name, creditCode);

		RptTnAbnormalResultsDTO abnormalDTOs = new RptTnAbnormalResultsDTO();
		if (null != abnormalLs && abnormalLs.size() >= 1) {
			abnormalLs.forEach(dto -> {
				abnormalDTOs.getItems().add(dto);
			});
			abnormalDTOs.setPageTotal(abnormalLs.size());
		}

		return ApiResultDTO.ok().put("result", new Gson().toJson(abnormalLs));

	}

	@ApiToken(desc = "行政处罚信息")
	@ApiModelProperty(value = "行政处罚信息")
	@ResponseBody
	@GetMapping("/getPunish")
	// @RequiresPermissions("api:v1:getPunish")
	public ApiResultDTO getPunish(ApiQueryForm api) {
		String name = api.getName();
		String creditCode = api.getCreditCode();
		validateInfo(name, creditCode);
		List<RptTnPenaltiesDTO> punishLs = tycManageDangerousFacade.getPunish(name, creditCode);

		RptTnPenaltiesResultsDTO punishDTOs = new RptTnPenaltiesResultsDTO();
		if (null != punishLs && punishLs.size() >= 1) {
			punishDTOs.setItems(punishLs);
			punishDTOs.setPageTotal(punishLs.size());
		}

		return ApiResultDTO.ok().put("result", new Gson().toJson(punishDTOs));

	}

	@ApiToken(desc = "严重违法信息")
	@ApiModelProperty(value = "严重违法信息")
	@ResponseBody
	@GetMapping("/getIllegal")
	// @RequiresPermissions("api:v1:getIllegal")
	public ApiResultDTO getIllegal(ApiQueryForm api) {
		String name = api.getName();
		String creditCode = api.getCreditCode();
		validateInfo(name, creditCode);
		List<RptTnIllegalDTO> illegalLs = tycManageDangerousFacade.getIllegal(name, creditCode);

		RptTnIllegalResultsDTO illegalDTOs = new RptTnIllegalResultsDTO();
		if (null != illegalLs && illegalLs.size() >= 1) {
			illegalLs.forEach(dto -> {
				illegalDTOs.getItems().add(dto);
			});
			illegalDTOs.setPageTotal(illegalLs.size());
		}
		return ApiResultDTO.ok().put("result", new Gson().toJson(illegalDTOs));

	}

	@ApiToken(desc = "股权质押信息")
	@ApiModelProperty(value = "股权质押信息")
	@ResponseBody
	@GetMapping("/getEquity")
	// @RequiresPermissions("api:v1:getEquity")
	public ApiResultDTO getEquity(ApiQueryForm api) {
		String name = api.getName();
		String creditCode = api.getCreditCode();
		validateInfo(name, creditCode);
		List<RptTnEquityDTO> equityLs = tycManageDangerousFacade.getEquity(name, creditCode);
		RptTnEquityResultsDTO equityDTOs = new RptTnEquityResultsDTO();
		if (null != equityLs && equityLs.size() >= 1) {
			equityLs.forEach(dto -> {
				equityDTOs.getItems().add(dto);
			});
			equityDTOs.setPageTotal(equityLs.size());
		}
		return ApiResultDTO.ok().put("result", new Gson().toJson(equityDTOs));

	}

	@ApiToken(desc = "欠税信息")
	@ApiModelProperty(value = "欠税信息")
	@ResponseBody
	@GetMapping("/getOwntax")
	// @RequiresPermissions("api:v1:getOwntax")
	public ApiResultDTO getOwntax(ApiQueryForm api) {
		String name = api.getName();
		String creditCode = api.getCreditCode();
		validateInfo(name, creditCode);
		List<RptTnOwingTaxDTO> owntaxLs = tycManageDangerousFacade.getOwntax(name, creditCode);
		RptTnOwingTaxResultsDTO owntaxDTOs = new RptTnOwingTaxResultsDTO();
		if (null != owntaxLs && owntaxLs.size() >= 1) {
			owntaxLs.forEach(dto -> {
				owntaxDTOs.getItems().add(dto);
			});

			owntaxDTOs.setPageTotal(owntaxLs.size());
		}
		return ApiResultDTO.ok().put("result", new Gson().toJson(owntaxLs));

	}

	// Status
	@ApiToken(desc = "招投标信息")
	@ApiModelProperty(value = "招投标信息")
	@ResponseBody
	@GetMapping("/getBid")
	// @RequiresPermissions("api:v1:getBid")
	public ApiResultDTO getBid(ApiQueryForm api) {
		String name = api.getName();
		String creditCode = api.getCreditCode();
		validateInfo(name, creditCode);
		List<RptTnBidDTO> bidLs = tycManageStatusFacade.getBid(name, creditCode);
		RptTnBidResultsDTO bidDTOs = new RptTnBidResultsDTO();
		if (null != bidLs && bidLs.size() >= 1) {
			bidLs.forEach(dto -> {
				bidDTOs.getItems().add(dto);
			});
			bidDTOs.setPageTotal(bidLs.size());
		}
		return ApiResultDTO.ok().put("result", new Gson().toJson(bidDTOs));

	}

	@ApiToken(desc = "税务评级信息")
	@ApiModelProperty(value = "税务评级信息")
	@ResponseBody
	@GetMapping("/getTaxCredit")
	// @RequiresPermissions("api:v1:getTaxCredit")
	public ApiResultDTO getTaxCredit(ApiQueryForm api) {
		String name = api.getName();
		String creditCode = api.getCreditCode();
		validateInfo(name, creditCode);
		List<RptTnTaxCreditDTO> taxCreditLs = tycManageStatusFacade.getTaxCredit(name, creditCode);
		RptTnTaxCreditResultsDTO taxCreditDTOs = new RptTnTaxCreditResultsDTO();
		if (null != taxCreditLs && taxCreditLs.size() >= 1) {
			taxCreditLs.forEach(dto -> {
				taxCreditDTOs.getItems().add(dto);
			});
			taxCreditDTOs.setPageTotal(taxCreditLs.size());
		}
		return ApiResultDTO.ok().put("result", new Gson().toJson(taxCreditDTOs));

	}

	@ApiToken(desc = "抽查检查信息")
	@ApiModelProperty(value = "抽查检查信息")
	@ResponseBody
	@GetMapping("/getCheck")
	// @RequiresPermissions("api:v1:getCheck")
	public ApiResultDTO getCheck(ApiQueryForm api) {
		String name = api.getName();
		String creditCode = api.getCreditCode();
		validateInfo(name, creditCode);
		List<RptTnCheckDTO> checkLs = tycManageStatusFacade.getCheck(name, creditCode);

		RptTnCheckResultsDTO checkDTOs = new RptTnCheckResultsDTO();
		if (null != checkLs && checkLs.size() >= 1) {
			checkLs.forEach(dto -> {
				checkDTOs.getItems().add(dto);
			});
			checkDTOs.setPageTotal(checkLs.size());
		}
		return ApiResultDTO.ok().put("result", new Gson().toJson(checkDTOs));

	}

	@ApiToken(desc = "进出口信用信息")
	@ApiModelProperty(value = "进出口信用信息")
	@ResponseBody
	@GetMapping("/getImportAndExport")
	public ApiResultDTO getImportAndExport(ApiQueryForm api) {
		String name = api.getName();
		String creditCode = api.getCreditCode();
		validateInfo(name, creditCode);
		List<RptTnImportExportDTO> importExportLs = tycManageStatusFacade.getImportAndExport(name, creditCode);
		RptTnImportExportResultsDTO importExportDTOs = new RptTnImportExportResultsDTO();
		if (null != importExportLs && importExportLs.size() >= 1) {
			importExportDTOs.setItems(importExportLs);
			importExportDTOs.setPageTotal(importExportLs.size());
		}
		return ApiResultDTO.ok().put("result", new Gson().toJson(importExportDTOs));

	}

	@ApiToken(desc = "天创信用-知识产权信息")
	@ApiModelProperty(value = "天创信用-知识产权信息")
	@ResponseBody
	@GetMapping("/getTcxyIpr")
	public ApiResultDTO getTcxyIpr(ApiQueryForm api) {
		String name = api.getName();
		String creditCode = api.getCreditCode();
		validateInfo(name, creditCode);

		List<RptTcxyCompanyCopyrightDTO> rptTcxyCompanyCopyrightDTOs = tcxyKnowledgePropertyFacade.getCopyrightWorks(name, creditCode);
		List<RptTcxyCompanySoftwareCopyrightDTO> rptTcxyCompanySoftwareCopyrightDTOs = tcxyKnowledgePropertyFacade.getCopyright(name, creditCode);
		List<RptTcxyPatentBaseDTO> rptTcxyPatentBaseDTOs = tcxyKnowledgePropertyFacade.getPatent(name, creditCode);
		RptTcxyIPRDTO iprDTO = new RptTcxyIPRDTO();
		iprDTO.setCopyRight(rptTcxyCompanyCopyrightDTOs);
		iprDTO.setPatent(rptTcxyPatentBaseDTOs);
		iprDTO.setSoftwareCopyRight(rptTcxyCompanySoftwareCopyrightDTOs);
		return ApiResultDTO.ok().put("result", new Gson().toJson(iprDTO));

	}

	// @ApiToken(desc = "天创信用-作品著作权信息")
	@ApiModelProperty(value = "天创信用-作品著作权信息")
	@ResponseBody
	@GetMapping("/getTcxyCompanyCopyright")
	public ApiResultDTO getTcxyCompanyCopyright(ApiQueryForm api) {
		String name = api.getName();
		String creditCode = api.getCreditCode();
		validateInfo(name, creditCode);
		List<RptTcxyCompanyCopyrightDTO> list = tcxyKnowledgePropertyFacade.getCopyrightWorks(name, creditCode);
		return ApiResultDTO.ok().put("result", new Gson().toJson(list));

	}

	@ApiToken(desc = "天创信用-软件著作权信息")
	@ApiModelProperty(value = "天创信用-软件著作权信息")
	@ResponseBody
	@GetMapping("/getTcxyCopyright")
	public ApiResultDTO getTcxyCopyright(ApiQueryForm api) {
		String name = api.getName();
		String creditCode = api.getCreditCode();
		validateInfo(name, creditCode);
		List<RptTcxyCompanySoftwareCopyrightDTO> importExportLs = tcxyKnowledgePropertyFacade.getCopyright(name, creditCode);
		return ApiResultDTO.ok().put("result", new Gson().toJson(importExportLs));

	}

	@ApiToken(desc = "天创信用-专利信息")
	@ApiModelProperty(value = "天创信用-专利信息")
	@ResponseBody
	@GetMapping("/getTcxyPatent")
	public ApiResultDTO getTcxyPatent(ApiQueryForm api) {
		String name = api.getName();
		String creditCode = api.getCreditCode();
		validateInfo(name, creditCode);
		List<RptTcxyPatentBaseDTO> list = tcxyKnowledgePropertyFacade.getPatent(name, creditCode);
		return ApiResultDTO.ok().put("result", new Gson().toJson(list));

	}
}