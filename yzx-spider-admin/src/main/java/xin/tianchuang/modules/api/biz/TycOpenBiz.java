package xin.tianchuang.modules.api.biz;

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

public interface TycOpenBiz {

	Open365BaseinfoV3DTO getBaseinfoV3(BizRequestParamDTO param) throws Exception;

	Open368HolderDTO getHolder(BizRequestParamDTO BizRequestParamDTO) throws Exception;

	Open369InverstDTO getInvest(BizRequestParamDTO BizRequestParamDTO) throws Exception;

	Open370ChangeinfoDTO getChangeinfo(BizRequestParamDTO BizRequestParamDTO) throws Exception;

	Open372BranchDTO getBranch(BizRequestParamDTO BizRequestParamDTO) throws Exception;

	Open384LawSuitDTO getLawSuit(BizRequestParamDTO param) throws Exception;

	Open385CourtAnnouncementDTO getCourtAnnouncement(BizRequestParamDTO param) throws Exception;

	Open389ZhixinginfoDTO getZhixinginfo(BizRequestParamDTO param) throws Exception;

	Open386KtannouncementDTO getKtannouncement(BizRequestParamDTO param) throws Exception;

	Open391AbnormalDTO getAbnormal(BizRequestParamDTO param) throws Exception;

	Open767CreditChinaV2DTO getCreditChinaV2(BizRequestParamDTO param) throws Exception;

	Open404EquityInfoDTO getEquityInfo(BizRequestParamDTO param) throws Exception;

	Open421MortgageInfoDTO getMortgageInfo(BizRequestParamDTO param) throws Exception;

	Open422OwnTaxDTO getOweTax(BizRequestParamDTO param) throws Exception;

	Open429BidsDTO getBids(BizRequestParamDTO param) throws Exception;

	Open782EmploymentsV2DTO getEmploymentsV2(BizRequestParamDTO param) throws Exception;

	Open767CreditChinaV2DTO getTm(BizRequestParamDTO param) throws Exception;

	Open440PatentsDTO getPatents(BizRequestParamDTO param) throws Exception;

	Open773CopyRegWorksDTO getCopyRegWorks(BizRequestParamDTO param) throws Exception;

	Open441CopyRegDTO getCopyReg(BizRequestParamDTO param) throws Exception;

	Open442IcpDTO getIcp(BizRequestParamDTO param) throws Exception;

	Open446NewsDTO getNews(BizRequestParamDTO param) throws Exception;

}
