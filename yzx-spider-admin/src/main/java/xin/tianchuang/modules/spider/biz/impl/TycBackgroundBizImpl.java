package xin.tianchuang.modules.spider.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.TycDataPageEnum;
import xin.tianchuang.common.exception.SpiderException;
import xin.tianchuang.modules.api.bean.v1.RptTnChangeDTO;
import xin.tianchuang.modules.spider.bean.tyc.dto.BranchesDTO;
import xin.tianchuang.modules.spider.bean.tyc.dto.InvestDTO;
import xin.tianchuang.modules.spider.bean.tyc.dto.PersonResultDTO;
import xin.tianchuang.modules.spider.bean.tyc.dto.ReportDTO;
import xin.tianchuang.modules.spider.bean.tyc.dto.ShareholdersDTO;
import xin.tianchuang.modules.spider.bean.tyc.dto.report.ReportAmountInfoResult;
import xin.tianchuang.modules.spider.bean.tyc.dto.report.ReportBaseInfoResult;
import xin.tianchuang.modules.spider.bean.tyc.dto.report.ReportInvestResults;
import xin.tianchuang.modules.spider.bean.tyc.dto.report.ReportShareholderResults;
import xin.tianchuang.modules.spider.bean.tyc.dto.report.ReportSocialInfoResult;
import xin.tianchuang.modules.spider.bean.tyc.dto.report.ReportWebsiteResults;
import xin.tianchuang.modules.spider.bean.tyc.result.BranchesResultsDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.BusinessResultDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.ChangeResultsDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.InvestResultsDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.ReportResultsDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.ShareholderResultsDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.TycApiDataResultRespDTO;
import xin.tianchuang.modules.spider.biz.TycBackgroundBiz;
import xin.tianchuang.modules.spider.entity.RptTnBasicInfoEntity;
import xin.tianchuang.modules.spider.entity.RptTnBranchesEntity;
import xin.tianchuang.modules.spider.entity.RptTnChangeEntity;
import xin.tianchuang.modules.spider.entity.RptTnInvestEntity;
import xin.tianchuang.modules.spider.entity.RptTnPersonEntity;
import xin.tianchuang.modules.spider.entity.RptTnReportAmountEntity;
import xin.tianchuang.modules.spider.entity.RptTnReportBaseEntity;
import xin.tianchuang.modules.spider.entity.RptTnReportEntity;
import xin.tianchuang.modules.spider.entity.RptTnReportInvestEntity;
import xin.tianchuang.modules.spider.entity.RptTnReportShareholderEntity;
import xin.tianchuang.modules.spider.entity.RptTnReportSocialEntity;
import xin.tianchuang.modules.spider.entity.RptTnReportWebsiteEntity;
import xin.tianchuang.modules.spider.entity.RptTnShareholdersEntity;
import xin.tianchuang.modules.spider.service.RptTnBasicInfoService;
import xin.tianchuang.modules.spider.service.RptTnBranchesService;
import xin.tianchuang.modules.spider.service.RptTnChangeService;
import xin.tianchuang.modules.spider.service.RptTnInvestService;
import xin.tianchuang.modules.spider.service.RptTnPersonService;
import xin.tianchuang.modules.spider.service.RptTnReportAmountService;
import xin.tianchuang.modules.spider.service.RptTnReportBaseService;
import xin.tianchuang.modules.spider.service.RptTnReportInvestService;
import xin.tianchuang.modules.spider.service.RptTnReportService;
import xin.tianchuang.modules.spider.service.RptTnReportShareholderService;
import xin.tianchuang.modules.spider.service.RptTnReportSocialService;
import xin.tianchuang.modules.spider.service.RptTnReportWebsiteService;
import xin.tianchuang.modules.spider.service.RptTnShareholdersService;

@Service
public class TycBackgroundBizImpl extends TycAbstractImpl implements TycBackgroundBiz {
	private static final Logger logger = LoggerFactory.getLogger(TycBackgroundBiz.class);

	@Autowired
	private RptTnBasicInfoService rptTnBasicInfoService;
	@Autowired
	private RptTnBranchesService rptTnBranchesService;
	@Autowired
	private RptTnChangeService rptTnChangeService;
	@Autowired
	private RptTnInvestService rptTnInvestService;
	@Autowired
	private RptTnShareholdersService rptTnShareholdersService;
	@Autowired
	private RptTnPersonService rptTnPersonService;
	@Autowired
	private RptTnReportService rptTnReportService;
	@Autowired
	private RptTnReportBaseService rptTnReportBaseService;
	@Autowired
	private RptTnReportInvestService rptTnReportInvestService;
	@Autowired
	private RptTnReportSocialService rptTnReportSocialService;
	@Autowired
	private RptTnReportWebsiteService rptTnReportWebsiteService;
	@Autowired
	private RptTnReportAmountService rptTnReportAmountService;
	@Autowired
	private RptTnReportShareholderService rptTnReportShareholderService;

	@Override
	public boolean saveData(Long enterpriseId, String name, TycApiDataResultRespDTO result) {
		this.initBusinessInfo(enterpriseId, name, result.getBusiness()); // 工商基本信息
		this.initPersonInfo(enterpriseId, name, result.getPerson());// 主要⼈员/高管信息
		this.initInvestInfo(enterpriseId, name, result.getInvest());// 对外投资情况
		this.initShareholderInfo(enterpriseId, name, result.getShareholder());// 股东信息
		this.initChangeInfo(enterpriseId, name, result.getChange()); // 变更信息
		this.initReport(enterpriseId, name, result.getReport()); // 企业年报
		this.initBranchesInfo(enterpriseId, name, result.getBranches()); // 分支机构
		return true;
	}

	/**
	 * 工商信息
	 * 
	 * @param name
	 * @param businessResultDTO
	 */
	private void initBusinessInfo(Long enterpriseId, String name, BusinessResultDTO businessResultDTO) {
		try {
			if (null == businessResultDTO) {
				logger.error("工商基本信息为空");
				return;
			}

			rptTnBasicInfoService.deleteByEnteprirseName(name);

			RptTnBasicInfoEntity dto = new RptTnBasicInfoEntity();
			BeanUtils.copyProperties(businessResultDTO, dto);

			dto.setEnterpriseId(enterpriseId);
			dto.setEntName(name);
			dto.setCreator(9999);
			dto.setUpdater(9999);
			rptTnBasicInfoService.insert(dto);

		} catch (Exception e) {
			logger.error("工商基本信息异常", e);
			throw new SpiderException("工商基本信息异常");
		}
	}

	/**
	 * 初始化股东组成
	 */
	public void initShareholderInfo(Long enterpriseId, String name, ShareholderResultsDTO shareholderResultsDTO) {
		try {
			if (null == shareholderResultsDTO || null == shareholderResultsDTO.getShareholderResults() || shareholderResultsDTO.getShareholderResults().size() <= 0) {
				logger.error("股东信息为空");
				return;
			}

			rptTnShareholdersService.deleteByEnteprirseName(name);

			RptTnShareholdersEntity entity = null;
			List<RptTnShareholdersEntity> entityList = new ArrayList<RptTnShareholdersEntity>();
			for (ShareholdersDTO dto : shareholderResultsDTO.getShareholderResults()) {
				entity = new RptTnShareholdersEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				entityList.add(entity);
			}
			rptTnShareholdersService.insertBatch(entityList);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("股东信息异常", e);
		}
	}

	/**
	 * 主要人员信息
	 */
	public void initPersonInfo(Long enterpriseId, String name, List<PersonResultDTO> list) {
		try {
			if (null == list || list.size() <= 0) {
				logger.error("主要人员信息为空");
				return;
			}

			rptTnPersonService.deleteByEnteprirseName(name);

			RptTnPersonEntity entity = null;
			List<RptTnPersonEntity> entityList = new ArrayList<RptTnPersonEntity>();
			for (PersonResultDTO dto : list) {
				entity = new RptTnPersonEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setDataState(1);
				entity.setCreator(9999);

				entityList.add(entity);
			}
			rptTnPersonService.insertBatch(entityList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("主要人员信息插入失败", e);
		}
	}

	/**
	 * 对外投资
	 * 
	 * @param name
	 * @param investResultsDTO
	 */
	private void initInvestInfo(Long enterpriseId, String name, InvestResultsDTO investResultsDTO) {
		try {
			if (null == investResultsDTO || null == investResultsDTO.getInvestResults() || investResultsDTO.getInvestResults().size() <= 0) {
				logger.error("企业对外投资信息为空");
				return;
			}
			savePageRecord(enterpriseId, name, TycDataPageEnum.INVEST, investResultsDTO.getPageTotal(), investResultsDTO.getPageNum());

			rptTnInvestService.deleteByEnteprirseName(name);

			RptTnInvestEntity entity = null;
			List<RptTnInvestEntity> entityList = new ArrayList<RptTnInvestEntity>();
			for (InvestDTO dto : investResultsDTO.getInvestResults()) {
				entity = new RptTnInvestEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setDataState(1);
				entity.setCreator(9999);

				entityList.add(entity);
			}
			rptTnInvestService.insertBatch(entityList);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("企业对外投资信息异常", e);
		}
	}

	/**
	 * 变更信息
	 * 
	 * @param name
	 * @param dtos
	 */
	private void initChangeInfo(Long enterpriseId, String name, ChangeResultsDTO dtos) {
		try {
			if (null == dtos || null == dtos.getChangeResults() || dtos.getChangeResults().size() <= 0) {
				logger.error("企业变更信息为空");
				return;
			}

			savePageRecord(enterpriseId, name, TycDataPageEnum.CHANGE, dtos.getPageTotal(), dtos.getPageNum());
			rptTnChangeService.deleteByEnteprirseName(name);

			RptTnChangeEntity entity = null;
			List<RptTnChangeEntity> entityList = new ArrayList<RptTnChangeEntity>();
			for (RptTnChangeDTO dto : dtos.getChangeResults()) {
				entity = new RptTnChangeEntity();
				BeanUtils.copyProperties(dto, entity);
				entity.setEnterpriseId(enterpriseId);
				entity.setName(name);
				entity.setDataState(1);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				entityList.add(entity);
			}
			rptTnChangeService.insertBatch(entityList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("企业对外投资信息异常", e);
		}
	}

	/**
	 * 初始化年报信息
	 * 
	 * @param enterpriseId
	 * @param name
	 * @param dtos
	 */
	private void initReport(Long enterpriseId, String name, ReportResultsDTO dtos) {
		try {
			List<ReportDTO> reportResults = dtos.getReportResults();
			if (null == dtos || null == reportResults || reportResults.size() <= 0) {
				logger.error("企业年报信息为空");
				return;
			}

			savePageRecord(enterpriseId, name, TycDataPageEnum.REPORT, null, null);

			rptTnReportService.deleteByEnteprirseName(name);

			RptTnReportEntity entity = null;
			for (ReportDTO dto : reportResults) {
				// 初始化总数据
				entity = new RptTnReportEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setDataState(1);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				rptTnReportService.insert(entity);

				// 初始化明细数据
				this.initReportBase(entity, dto.getReportBaseInfoResult());// 企业基本信息
				this.initReportWebsiteResult(entity, dto.getWebsiteResults()); // 网站或网点信息
				this.initReportInvest(entity, dto.getInvestResults()); // 对外投资信息
				this.initReportAmount(entity, dto.getReportAmountInfoResult());// 企业资产状况信息
				this.initReportSocial(entity, dto.getReportSocialInfoResult());// 社保信息
				this.initReportShareholder(entity, dto.getShareholderResults()); // 股东及出质信息
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("企业年报信息异常", e);
		}
	}

	private void initReportShareholder(RptTnReportEntity report, List<ReportShareholderResults> dtos) {
		try {
			if (null == dtos) {
				logger.error("企业年报-股东信息为空");
				return;
			}

			rptTnReportShareholderService.deleteByEnteprirseName(report.getEntName());

			RptTnReportShareholderEntity entity = null;
			List<RptTnReportShareholderEntity> entityList = new ArrayList<RptTnReportShareholderEntity>();
			for (ReportShareholderResults dto : dtos) {
				entity = new RptTnReportShareholderEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(report.getEnterpriseId());
				entity.setEntName(report.getEntName());
				entity.setReportId(report.getId());
				entity.setDataState(1);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				entityList.add(entity);
			}
			rptTnReportShareholderService.insertBatch(entityList);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("企业年报-股东信息异常", e);
		}

	}

	private void initReportSocial(RptTnReportEntity report, ReportSocialInfoResult dto) {
		try {
			if (null == dto) {
				logger.error("企业年报-社保信息为空");
				return;
			}

			rptTnReportSocialService.deleteByEnteprirseName(report.getEntName());

			RptTnReportSocialEntity entity = new RptTnReportSocialEntity();
			BeanUtils.copyProperties(dto, entity);

			entity.setEnterpriseId(report.getEnterpriseId());
			entity.setEntName(report.getEntName());
			entity.setReportId(report.getId());
			entity.setDataState(1);
			entity.setCreator(9999);
			entity.setUpdater(9999);

			rptTnReportSocialService.insert(entity);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("企业年报-社保信息异常", e);
		}

	}

	private void initReportAmount(RptTnReportEntity report, ReportAmountInfoResult dto) {
		try {
			if (null == dto) {
				logger.error("企业年报-资本信息为空");
				return;
			}

			rptTnReportAmountService.deleteByEnteprirseName(report.getEntName());

			RptTnReportAmountEntity entity = new RptTnReportAmountEntity();
			BeanUtils.copyProperties(dto, entity);

			entity.setEnterpriseId(report.getEnterpriseId());
			entity.setEntName(report.getEntName());
			entity.setReportId(report.getId());
			entity.setDataState(1);
			entity.setCreator(9999);
			entity.setUpdater(9999);

			rptTnReportAmountService.insert(entity);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("企业年报-资本信息异常", e);
		}

	}

	private void initReportInvest(RptTnReportEntity report, List<ReportInvestResults> dtos) {
		try {
			if (null == dtos) {
				logger.error("企业年报信息为空");
				return;
			}

			rptTnReportInvestService.deleteByEnteprirseName(report.getEntName());

			RptTnReportInvestEntity entity = null;
			List<RptTnReportInvestEntity> entityList = new ArrayList<RptTnReportInvestEntity>();
			for (ReportInvestResults dto : dtos) {
				entity = new RptTnReportInvestEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(report.getEnterpriseId());
				entity.setEntName(report.getEntName());
				entity.setReportId(report.getId());
				entity.setDataState(1);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				entityList.add(entity);
			}
			rptTnReportInvestService.insertBatch(entityList);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("企业年报信息异常", e);
		}

	}

	private void initReportWebsiteResult(RptTnReportEntity report, List<ReportWebsiteResults> dtos) {
		try {
			if (null == dtos) {
				logger.error("企业年报-网站信息为空");
				return;
			}

			rptTnReportWebsiteService.deleteByEnteprirseName(report.getEntName());

			RptTnReportWebsiteEntity entity = null;
			List<RptTnReportWebsiteEntity> entityList = new ArrayList<RptTnReportWebsiteEntity>();
			for (ReportWebsiteResults dto : dtos) {
				entity = new RptTnReportWebsiteEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(report.getEnterpriseId());
				entity.setEntName(report.getEntName());
				entity.setReportId(report.getId());
				entity.setDataState(1);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				entityList.add(entity);

			}
			rptTnReportWebsiteService.insertBatch(entityList);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("企业年报-网站信息异常", e);
		}

	}

	private void initReportBase(RptTnReportEntity report, ReportBaseInfoResult dto) {
		try {
			if (null == dto) {
				logger.error("企业年报-基本信息为空");
				return;
			}

			rptTnReportBaseService.deleteByEnteprirseName(report.getEntName());

			RptTnReportBaseEntity entity = new RptTnReportBaseEntity();
			BeanUtils.copyProperties(dto, entity);

			entity.setEnterpriseId(report.getEnterpriseId());
			entity.setEntName(report.getEntName());
			entity.setReportId(report.getId());
			entity.setDataState(1);
			entity.setCreator(9999);
			entity.setUpdater(9999);

			rptTnReportBaseService.insert(entity);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("企业年报-基本信息异常", e);
		}

	}

	private void initBranchesInfo(Long enterpriseId, String name, BranchesResultsDTO dtos) {
		try {
			if (null == dtos || null == dtos.getBranchesResults() || dtos.getBranchesResults().size() <= 0) {
				logger.error("企业分支机构信息为空");
				return;
			}

			savePageRecord(enterpriseId, name, TycDataPageEnum.BRANCHES, dtos.getPageTotal(), dtos.getPageNum());
			rptTnBranchesService.deleteByEnteprirseName(name);

			RptTnBranchesEntity entity = null;
			List<RptTnBranchesEntity> entityList = new ArrayList<RptTnBranchesEntity>();
			for (BranchesDTO dto : dtos.getBranchesResults()) {
				entity = new RptTnBranchesEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setDataState(1);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				entityList.add(entity);
			}
			rptTnBranchesService.insertBatch(entityList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("企业分支机构信息异常", e);
		}
	}

}
