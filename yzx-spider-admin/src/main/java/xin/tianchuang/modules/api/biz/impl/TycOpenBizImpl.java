package xin.tianchuang.modules.api.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import xin.tianchuang.common.constant.OpenTycConstant;
import xin.tianchuang.modules.api.bean.api.tyc.biz.BizRequestHeadParamDTO;
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
import xin.tianchuang.modules.api.service.TycApiService;

@Component
public class TycOpenBizImpl implements TycOpenBiz {
	@Autowired
	private TycApiService<Object> tycApiService;

	@Override
	public Open365BaseinfoV3DTO getBaseinfoV3(BizRequestParamDTO param) throws Exception {
		BizRequestHeadParamDTO head = new BizRequestHeadParamDTO();
		head.setToken("tyc_token");
		head.setUrl(OpenTycConstant.URL_OPEN_365_BASE_INFO_V3);
		return tycApiService.queryApi(param, head, Open365BaseinfoV3DTO.class);
	}

	@Override
	public Open368HolderDTO getHolder(BizRequestParamDTO param) throws Exception {
		BizRequestHeadParamDTO head = new BizRequestHeadParamDTO();
		head.setToken("tyc_token");
		head.setUrl(OpenTycConstant.URL_OPEN_368_HOLDER);
		return tycApiService.queryApi(param, head, Open368HolderDTO.class);
	}

	@Override
	public Open369InverstDTO getInvest(BizRequestParamDTO param) throws Exception {
		BizRequestHeadParamDTO head = new BizRequestHeadParamDTO();
		head.setToken("tyc_token");
		head.setUrl(OpenTycConstant.URL_OPEN_369_INVEST);
		return tycApiService.queryApi(param, head, Open369InverstDTO.class);
	}

	@Override
	public Open370ChangeinfoDTO getChangeinfo(BizRequestParamDTO param) throws Exception {
		BizRequestHeadParamDTO head = new BizRequestHeadParamDTO();
		head.setToken("tyc_token");
		head.setUrl(OpenTycConstant.URL_OPEN_370_CHANGEINFO);
		return tycApiService.queryApi(param, head, Open370ChangeinfoDTO.class);
	}

	// @Override
	// public R getAnnualreport(BizRequestParamDTO param) throws Exception {
	// // OpenTycConstant.URL_OPEN_371_ANNUALREPORT
	// return tycApiService.queryApi(param, open3);
	// }

	@Override
	public Open372BranchDTO getBranch(BizRequestParamDTO param) throws Exception {
		BizRequestHeadParamDTO head = new BizRequestHeadParamDTO();
		head.setToken("tyc_token");
		head.setUrl(OpenTycConstant.URL_OPEN_372_BRANCH);
		return tycApiService.queryApi(param, head, Open372BranchDTO.class);
	}

	@Override
	public Open384LawSuitDTO getLawSuit(BizRequestParamDTO param) throws Exception {
		BizRequestHeadParamDTO head = new BizRequestHeadParamDTO();
		head.setToken("tyc_token");
		head.setUrl(OpenTycConstant.URL_OPEN_384_LAW_SUIT);
		return tycApiService.queryApi(param, head, Open384LawSuitDTO.class);
	}

	@Override
	public Open385CourtAnnouncementDTO getCourtAnnouncement(BizRequestParamDTO param) throws Exception {
		BizRequestHeadParamDTO head = new BizRequestHeadParamDTO();
		head.setToken("tyc_token");
		head.setUrl(OpenTycConstant.URL_OPEN_385_COURT_ANNOUNCEMENT);
		return tycApiService.queryApi(param, head, Open385CourtAnnouncementDTO.class);
	}

	// 被执行人
	@Override
	public Open389ZhixinginfoDTO getZhixinginfo(BizRequestParamDTO param) throws Exception {
		BizRequestHeadParamDTO head = new BizRequestHeadParamDTO();
		head.setToken("tyc_token");
		head.setUrl(OpenTycConstant.URL_OPEN_389_ZHIXINGINFO);
		return tycApiService.queryApi(param, head, Open389ZhixinginfoDTO.class);
	}

	// 开庭公告
	@Override
	public Open386KtannouncementDTO getKtannouncement(BizRequestParamDTO param) throws Exception {
		BizRequestHeadParamDTO head = new BizRequestHeadParamDTO();
		head.setToken("tyc_token");
		head.setUrl(OpenTycConstant.URL_OPEN_386_KTANNOUNCEMENT);
		return tycApiService.queryApi(param, head, Open386KtannouncementDTO.class);
	}

	// 经营异常

	@Override
	public Open391AbnormalDTO getAbnormal(BizRequestParamDTO param) throws Exception {
		BizRequestHeadParamDTO head = new BizRequestHeadParamDTO();
		head.setToken("tyc_token");
		head.setUrl(OpenTycConstant.URL_OPEN_391_ABNORMAL);
		return tycApiService.queryApi(param, head, Open391AbnormalDTO.class);
	}

	// 行政处罚-信用中国（新版）
	@Override
	public Open767CreditChinaV2DTO getCreditChinaV2(BizRequestParamDTO param) throws Exception {
		BizRequestHeadParamDTO head = new BizRequestHeadParamDTO();
		head.setToken("tyc_token");
		head.setUrl(OpenTycConstant.URL_OPEN_767_CREDIT_CHINA_V2);
		return tycApiService.queryApi(param, head, Open767CreditChinaV2DTO.class);
	}

	// 股权出质

	@Override
	public Open404EquityInfoDTO getEquityInfo(BizRequestParamDTO param) throws Exception {
		BizRequestHeadParamDTO head = new BizRequestHeadParamDTO();
		head.setToken("tyc_token");
		head.setUrl(OpenTycConstant.URL_OPEN_404_EQUITY_INFO);
		return tycApiService.queryApi(param, head, Open404EquityInfoDTO.class);
	}

	// 动产抵押

	@Override
	public Open421MortgageInfoDTO getMortgageInfo(BizRequestParamDTO param) throws Exception {
		BizRequestHeadParamDTO head = new BizRequestHeadParamDTO();
		head.setToken("tyc_token");
		head.setUrl(OpenTycConstant.URL_OPEN_421_MORTGAGE_INFO);
		return tycApiService.queryApi(param, head, Open421MortgageInfoDTO.class);
	}

	// 欠税公告

	@Override
	public Open422OwnTaxDTO getOweTax(BizRequestParamDTO param) throws Exception {
		BizRequestHeadParamDTO head = new BizRequestHeadParamDTO();
		head.setToken("tyc_token");
		head.setUrl(OpenTycConstant.URL_OPEN_422_OWN_TAX);
		return tycApiService.queryApi(param, head, Open422OwnTaxDTO.class);
	}

	// 招投标

	@Override
	public Open429BidsDTO getBids(BizRequestParamDTO param) throws Exception {
		BizRequestHeadParamDTO head = new BizRequestHeadParamDTO();
		head.setToken("tyc_token");
		head.setUrl(OpenTycConstant.URL_OPEN_429_BIDS);
		return tycApiService.queryApi(param, head, Open429BidsDTO.class);
	}

	// 招聘

	@Override
	public Open782EmploymentsV2DTO getEmploymentsV2(BizRequestParamDTO param) throws Exception {
		BizRequestHeadParamDTO head = new BizRequestHeadParamDTO();
		head.setToken("tyc_token");
		head.setUrl(OpenTycConstant.URL_OPEN_782_EMPLOYMENTS_V2);
		return tycApiService.queryApi(param, head, Open782EmploymentsV2DTO.class);
	}

	// 商标信息

	@Override
	public Open767CreditChinaV2DTO getTm(BizRequestParamDTO param) throws Exception {
		BizRequestHeadParamDTO head = new BizRequestHeadParamDTO();
		head.setToken("tyc_token");
		head.setUrl(OpenTycConstant.URL_OPEN_767_CREDIT_CHINA_V2);
		return tycApiService.queryApi(param, head, Open767CreditChinaV2DTO.class);
	}

	// 专利

	@Override
	public Open440PatentsDTO getPatents(BizRequestParamDTO param) throws Exception {
		BizRequestHeadParamDTO head = new BizRequestHeadParamDTO();
		head.setToken("tyc_token");
		head.setUrl(OpenTycConstant.URL_OPEN_440_PATENTS);
		return tycApiService.queryApi(param, head, Open440PatentsDTO.class);
	}

	// 作品著作权

	@Override
	public Open773CopyRegWorksDTO getCopyRegWorks(BizRequestParamDTO param) throws Exception {
		BizRequestHeadParamDTO head = new BizRequestHeadParamDTO();
		head.setToken("tyc_token");
		head.setUrl(OpenTycConstant.URL_OPEN_773_COPY_REG_WORKS);
		return tycApiService.queryApi(param, head, Open773CopyRegWorksDTO.class);
	}

	// 著作权

	@Override
	public Open441CopyRegDTO getCopyReg(BizRequestParamDTO param) throws Exception {
		BizRequestHeadParamDTO head = new BizRequestHeadParamDTO();
		head.setToken("tyc_token");
		head.setUrl(OpenTycConstant.URL_OPEN_441_COPY_REG);
		return tycApiService.queryApi(param, head, Open441CopyRegDTO.class);
	}

	// 网站备案

	@Override
	public Open442IcpDTO getIcp(BizRequestParamDTO param) throws Exception {
		BizRequestHeadParamDTO head = new BizRequestHeadParamDTO();
		head.setToken("tyc_token");
		head.setUrl(OpenTycConstant.URL_OPEN_442_ICP);
		return tycApiService.queryApi(param, head, Open442IcpDTO.class);
	}

	// 获取公司新闻列表

	@Override
	public Open446NewsDTO getNews(BizRequestParamDTO param) throws Exception {
		BizRequestHeadParamDTO head = new BizRequestHeadParamDTO();
		head.setToken("tyc_token");
		head.setUrl(OpenTycConstant.URL_OPEN_446_NEWS);
		return tycApiService.queryApi(param, head, Open446NewsDTO.class);
	}
}
