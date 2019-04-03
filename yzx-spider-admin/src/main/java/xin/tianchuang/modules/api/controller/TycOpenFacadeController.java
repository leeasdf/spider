package xin.tianchuang.modules.api.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import xin.tianchuang.common.utils.R;
import xin.tianchuang.modules.api.bean.api.tyc.biz.BizRequestParamDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open365BaseinfoV3DTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open368HolderDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open369InverstDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open370ChangeinfoDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open372BranchDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open384LawSuitDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open385CourtAnnouncementDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open386KtannouncementDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open389ZhixinginfoDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open391AbnormalDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open404EquityInfoDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open421MortgageInfoDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open422OwnTaxDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open429BidsDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open440PatentsDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open441CopyRegDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open442IcpDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open446NewsDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open767CreditChinaV2DTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open773CopyRegWorksDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open782EmploymentsV2DTO;
import xin.tianchuang.modules.api.biz.TycOpenBiz;

@RestController
@RequestMapping("/api/open/tyc")
public class TycOpenFacadeController {

	private static Logger logger = LoggerFactory.getLogger(TycOpenFacadeController.class);

	@Resource
	private TycOpenBiz tycOpenBiz;

	@ResponseBody
	@RequestMapping("/baseinfoV3")
	@ApiOperation(value = "获取企业基本信息（含主要人员）", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", paramType = "query"), //
	})
	public R getBaseinfoV3(@RequestParam BizRequestParamDTO param) throws Exception {
		Open365BaseinfoV3DTO dto = tycOpenBiz.getBaseinfoV3(param);
		return R.ok().put("data", dto);
	}

	@ResponseBody
	@RequestMapping("/holder")
	@ApiOperation(value = "股东信息", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getHolder(@RequestParam BizRequestParamDTO BizRequestParamDTO) throws Exception {
		Open368HolderDTO dto = tycOpenBiz.getHolder(BizRequestParamDTO);
		return R.ok().put("data", dto);
	}

	@ResponseBody
	@RequestMapping("/invest")
	@ApiOperation(value = "对外投资", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getInvest(@RequestParam BizRequestParamDTO BizRequestParamDTO) throws Exception {
		Open369InverstDTO dto = tycOpenBiz.getInvest(BizRequestParamDTO);
		return R.ok().put("data", dto);
	}

	@ResponseBody
	@RequestMapping("/changeinfo")
	@ApiOperation(value = "变更记录", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getChangeinfo(@RequestParam BizRequestParamDTO BizRequestParamDTO) throws Exception {
		Open370ChangeinfoDTO dto = tycOpenBiz.getChangeinfo(BizRequestParamDTO);
		return R.ok().put("data", dto);
	}

	// @ResponseBody
	// @RequestMapping("/annualreport")
	// @ApiOperation(value = "企业年报", notes = "")
	// @ApiImplicitParams({ @ApiImplicitParam(name = "id", dataType = "int", paramType = "query"), //
	// @ApiImplicitParam(name = "name", dataType = "String", paramType = "query"), //
	// })
	// public R getAnnualreport(@RequestParam BizRequestParamDTO param) throws Exception {
	// tycOpenBiz.getAnnualReport(param);
	// return R.ok().put("data", dto);
	// }

	@ResponseBody
	@RequestMapping("/branch")
	@ApiOperation(value = "分支机构", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getBranch(@RequestParam BizRequestParamDTO BizRequestParamDTO) throws Exception {
		Open372BranchDTO dto = tycOpenBiz.getBranch(BizRequestParamDTO);
		return R.ok().put("data", dto);
	}

	@ResponseBody
	@RequestMapping("/lawSuit")
	@ApiOperation(value = "法律诉讼", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "name", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getLawSuit(@RequestParam BizRequestParamDTO param) throws Exception {
		Open384LawSuitDTO dto = tycOpenBiz.getLawSuit(param);
		return R.ok().put("data", dto);
	}

	@ResponseBody
	@RequestMapping("/courtAnnouncement")
	@ApiOperation(value = "法院公告", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "name", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getCourtAnnouncement(@RequestParam BizRequestParamDTO param) throws Exception {
		Open385CourtAnnouncementDTO dto = tycOpenBiz.getCourtAnnouncement(param);
		return R.ok().put("data", dto);
	}

//	// 失信人
//	@ResponseBody
//	@RequestMapping("/dishonest")
//	@ApiOperation(value = "失信人", notes = "")
//	@ApiImplicitParams({ @ApiImplicitParam(name = "name", dataType = "String", paramType = "query"), //
//			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
//	})
//	public R getDishonest(@RequestParam BizRequestParamDTO param) throws Exception {
//		Open387DishonestDTO dto = tycOpenBiz.getDishonest(param);
//		return R.ok().put("data", dto);
//	}

	// 被执行人
	@ResponseBody
	@RequestMapping("/zhixinginfo")
	@ApiOperation(value = "被执信人", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "name", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getZhixinginfo(@RequestParam BizRequestParamDTO param) throws Exception {
		Open389ZhixinginfoDTO dto = tycOpenBiz.getZhixinginfo(param);
		return R.ok().put("data", dto);
	}

	// 开庭公告
	@ResponseBody
	@RequestMapping("/ktannouncement")
	@ApiOperation(value = "开庭公告", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getKtannouncement(@RequestParam BizRequestParamDTO param) throws Exception {
		Open386KtannouncementDTO dto = tycOpenBiz.getKtannouncement(param);
		return R.ok().put("data", dto);
	}

	// 经营异常
	@ResponseBody
	@RequestMapping("/abnormal")
	@ApiOperation(value = "开庭公告", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getAbnormal(@RequestParam BizRequestParamDTO param) throws Exception {
		Open391AbnormalDTO dto = tycOpenBiz.getAbnormal(param);
		return R.ok().put("data", dto);
	}

	// 行政处罚-信用中国（新版）
	@ResponseBody
	@RequestMapping("/creditChinaV2")
	@ApiOperation(value = "行政处罚-信用中国（新版）", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getCreditChinaV2(@RequestParam BizRequestParamDTO param) throws Exception {
		Open767CreditChinaV2DTO dto = tycOpenBiz.getCreditChinaV2(param);
		return R.ok().put("data", dto);
	}

	// 股权出质
	@ResponseBody
	@RequestMapping("/equityInfo")
	@ApiOperation(value = "行政处罚-信用中国（新版）", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getEquityInfo(@RequestParam BizRequestParamDTO param) throws Exception {
		Open404EquityInfoDTO dto = tycOpenBiz.getEquityInfo(param);
		return R.ok().put("data", dto);
	}

	// 动产抵押
	@ResponseBody
	@RequestMapping("/mortgageInfo")
	@ApiOperation(value = "动产抵押", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getMortgageInfo(@RequestParam BizRequestParamDTO param) throws Exception {
		Open421MortgageInfoDTO dto = tycOpenBiz.getMortgageInfo(param);
		return R.ok().put("data", dto);
	}

	// 欠税公告
	@ResponseBody
	@RequestMapping("/oweTax")
	@ApiOperation(value = "欠税公告", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getOweTax(@RequestParam BizRequestParamDTO param) throws Exception {
		Open422OwnTaxDTO dto = tycOpenBiz.getOweTax(param);
		return R.ok().put("data", dto);
	}

	// 招投标
	@ResponseBody
	@RequestMapping("/bids")
	@ApiOperation(value = "行政处罚-信用中国（新版）", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getBids(@RequestParam BizRequestParamDTO param) throws Exception {
		Open429BidsDTO dto = tycOpenBiz.getBids(param);
		return R.ok().put("data", dto);
	}

	// 招聘
	@ResponseBody
	@RequestMapping("/employmentsV2")
	@ApiOperation(value = "招聘（新版）", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getEmploymentsV2(@RequestParam BizRequestParamDTO param) throws Exception {
		Open782EmploymentsV2DTO dto = tycOpenBiz.getEmploymentsV2(param);
		return R.ok().put("data", dto);
	}

	// 商标信息
	@ResponseBody
	@RequestMapping("/tm")
	@ApiOperation(value = "商标信息", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getTm(@RequestParam BizRequestParamDTO param) throws Exception {
		Open767CreditChinaV2DTO dto = tycOpenBiz.getTm(param);
		return R.ok().put("data", dto);
	}

	// 专利
	@ResponseBody
	@RequestMapping("/patents")
	@ApiOperation(value = "专利", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getPatents(@RequestParam BizRequestParamDTO param) throws Exception {
		Open440PatentsDTO dto = tycOpenBiz.getPatents(param);
		return R.ok().put("data", dto);
	}

	// 作品著作权
	@ResponseBody
	@RequestMapping("/copyRegWorks")
	@ApiOperation(value = "作品著作权", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getCopyRegWorks(@RequestParam BizRequestParamDTO param) throws Exception {
		Open773CopyRegWorksDTO dto = tycOpenBiz.getCopyRegWorks(param);
		return R.ok().put("data", dto);
	}

	// 著作权
	@ResponseBody
	@RequestMapping("/copyReg")
	@ApiOperation(value = "著作权", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getCopyReg(@RequestParam BizRequestParamDTO param) throws Exception {
		Open441CopyRegDTO dto = tycOpenBiz.getCopyReg(param);
		return R.ok().put("data", dto);
	}

	// 网站备案
	@ResponseBody
	@RequestMapping("/icp")
	@ApiOperation(value = " 网站备案", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getIcp(@RequestParam BizRequestParamDTO param) throws Exception {
		Open442IcpDTO dto = tycOpenBiz.getIcp(param);
		return R.ok().put("data", dto);
	}

	// 获取公司新闻列表
	@ResponseBody
	@RequestMapping("/news")
	@ApiOperation(value = "获取公司新闻列表", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getNews(@RequestParam BizRequestParamDTO param) throws Exception {
		Open446NewsDTO dto = tycOpenBiz.getNews(param);
		return R.ok().put("data", dto);
	}
}