package xin.tianchuang.modules.spider.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.TycDataPageEnum;
import xin.tianchuang.modules.spider.bean.tyc.dto.AbnormalDTO;
import xin.tianchuang.modules.spider.bean.tyc.dto.ClearingDTO;
import xin.tianchuang.modules.spider.bean.tyc.dto.EquityDTO;
import xin.tianchuang.modules.spider.bean.tyc.dto.IllegalDTO;
import xin.tianchuang.modules.spider.bean.tyc.dto.JudicialSaleDTO;
import xin.tianchuang.modules.spider.bean.tyc.dto.MortgageDTO;
import xin.tianchuang.modules.spider.bean.tyc.dto.OwingTaxDTO;
import xin.tianchuang.modules.spider.bean.tyc.dto.PenaltiesDTO;
import xin.tianchuang.modules.spider.bean.tyc.dto.PunishCreditchinaDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.AbnormalResultsDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.ClearingResultDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.EquityResultsDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.IllegalResultsDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.JudicialSaleResultsDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.MortgageResultsDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.OwingTaxResultsDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.PenaltiesResultsDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.PunishCreditchinaResultDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.TycApiDataResultRespDTO;
import xin.tianchuang.modules.spider.biz.TycManageDangerousBiz;
import xin.tianchuang.modules.spider.entity.RptTnAbnormalEntity;
import xin.tianchuang.modules.spider.entity.RptTnClearingEntity;
import xin.tianchuang.modules.spider.entity.RptTnEquityEntity;
import xin.tianchuang.modules.spider.entity.RptTnIllegalEntity;
import xin.tianchuang.modules.spider.entity.RptTnJudicialSaleEntity;
import xin.tianchuang.modules.spider.entity.RptTnMortgageEntity;
import xin.tianchuang.modules.spider.entity.RptTnOwingTaxEntity;
import xin.tianchuang.modules.spider.entity.RptTnPenaltiesEntity;
import xin.tianchuang.modules.spider.entity.RptTnPunishCreditchinaEntity;
import xin.tianchuang.modules.spider.service.RptTnAbnormalService;
import xin.tianchuang.modules.spider.service.RptTnClearingService;
import xin.tianchuang.modules.spider.service.RptTnEquityService;
import xin.tianchuang.modules.spider.service.RptTnIllegalService;
import xin.tianchuang.modules.spider.service.RptTnJudicialSaleService;
import xin.tianchuang.modules.spider.service.RptTnMortgageService;
import xin.tianchuang.modules.spider.service.RptTnOwingTaxService;
import xin.tianchuang.modules.spider.service.RptTnPenaltiesService;
import xin.tianchuang.modules.spider.service.RptTnPunishCreditchinaService;

@Service
public class TycManageDangerousBizImpl extends TycAbstractImpl implements TycManageDangerousBiz {
	private static final Logger logger = LoggerFactory.getLogger(TycManageDangerousBiz.class);

	@Autowired
	private RptTnPenaltiesService rptTnPenaltiesService;
	@Autowired
	private RptTnPunishCreditchinaService rptTnPunishCreditchinaService;
	@Autowired
	private RptTnAbnormalService rptTnAbnormalService;
	@Autowired
	private RptTnIllegalService rptTnIllegalService;
	@Autowired
	private RptTnOwingTaxService rptTnOwingTaxService;
	@Autowired
	private RptTnEquityService rptTnEquityService;
	@Autowired
	private RptTnMortgageService rptTnMortgageService;
	@Autowired
	private RptTnJudicialSaleService rptTnJudicialSaleService;
	@Autowired
	private RptTnClearingService rptTnClearingService;

	@Override
	public boolean saveData(Long enterpriseId, String name, TycApiDataResultRespDTO result) {
		this.initAbnormalInfo(enterpriseId, name, result.getAbnormal()); // 经营异常
		this.initPunishCreditchina(enterpriseId, name, result.getPunishCreditchina()); // 行政处罚 [工商局]
		this.initPenaltiesInfo(enterpriseId, name, result.getPenalties()); // 行政处罚 [信用中国]
		this.initIllegalInfo(enterpriseId, name, result.getIllegal()); // 严重违法
		this.initEquity(enterpriseId, name, result.getEquity()); // 股权出质

		this.initMortgage(enterpriseId, name, result.getMortgage()); // 动产抵押
		this.initOwingTax(enterpriseId, name, result.getOwingTax()); // 欠税信息
		this.initJudicialSale(enterpriseId, name, result.getJudicialSale());// 司法拍卖
		this.initClearing(enterpriseId, name, result.getClearing());// 清算信息
		// 知识产权出质
		return true;
	}

	/**
	 * 经营异常
	 * 
	 * @param enterpriseId
	 * @param name
	 * @param abnormalResultsDTO
	 */
	private void initAbnormalInfo(Long enterpriseId, String name, AbnormalResultsDTO dtos) {
		try {
			if (null == dtos || null == dtos.getAbnormalResults() || dtos.getAbnormalResults().size() <= 0) {
				logger.error("企业经营异常信息为空");
				return;
			}

			savePageRecord(enterpriseId, name, TycDataPageEnum.ABNORMAL, dtos.getPageTotal(), dtos.getPageNum());
			rptTnAbnormalService.deleteByEnteprirseName(name);

			RptTnAbnormalEntity entity = null;
			List<RptTnAbnormalEntity> entityList = new ArrayList<RptTnAbnormalEntity>();
			for (AbnormalDTO dto : dtos.getAbnormalResults()) {
				entity = new RptTnAbnormalEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				entityList.add(entity);
			}
			rptTnAbnormalService.insertBatch(entityList);
		} catch (Exception e) {
			logger.error("企业经营异常信息异常", e);
		}
	}

	/**
	 * 行政处罚[信用中国]
	 * 
	 * @param enterpriseId
	 * @param name
	 * @param punishCreditchina
	 */
	private void initPunishCreditchina(Long enterpriseId, String name, PunishCreditchinaResultDTO dtos) {
		try {
			if (null == dtos || null == dtos.getPunishCreditchinaResults() || dtos.getPunishCreditchinaResults().size() <= 0) {
				logger.error("企业⾏政处罚信息[信用中国]为空");
				return;
			}

			savePageRecord(enterpriseId, name, TycDataPageEnum.PUNISH, dtos.getPageTotal(), dtos.getPageNum());
			rptTnPunishCreditchinaService.deleteByEnteprirseName(name);
			RptTnPunishCreditchinaEntity entity = null;
			List<RptTnPunishCreditchinaEntity> entityList = new ArrayList<RptTnPunishCreditchinaEntity>();
			for (PunishCreditchinaDTO dto : dtos.getPunishCreditchinaResults()) {
				entity = new RptTnPunishCreditchinaEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				entityList.add(entity);
			}
			rptTnPunishCreditchinaService.insertBatch(entityList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("企业⾏政处罚信息[信用中国]异常", e);
		}

	}

	/**
	 * 行政处罚[工商局]
	 * 
	 * @param enterpriseId
	 * @param name
	 * @param penaltiesResultsDTO
	 */
	private void initPenaltiesInfo(Long enterpriseId, String name, PenaltiesResultsDTO dtos) {
		try {
			if (null == dtos || null == dtos.getPenaltiesResults() || dtos.getPenaltiesResults().size() <= 0) {
				logger.error("企业⾏政处罚信息[工商局]为空");
				return;
			}

			savePageRecord(enterpriseId, name, TycDataPageEnum.PENALTIES, dtos.getPageTotal(), dtos.getPageNum());
			rptTnPenaltiesService.deleteByEnteprirseName(name);
			RptTnPenaltiesEntity entity = null;
			List<RptTnPenaltiesEntity> entityList = new ArrayList<RptTnPenaltiesEntity>();
			for (PenaltiesDTO dto : dtos.getPenaltiesResults()) {
				entity = new RptTnPenaltiesEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				entityList.add(entity);
			}
			rptTnPenaltiesService.insertBatch(entityList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("企业⾏政处罚信息[工商局]异常", e);
		}
	}

	/**
	 * 严重违法
	 * 
	 * @param enterpriseId
	 * @param name
	 * @param illegalResultsDTO
	 */
	private void initIllegalInfo(Long enterpriseId, String name, IllegalResultsDTO dtos) {
		try {
			if (null == dtos || null == dtos.getIllegalResults() || dtos.getIllegalResults().size() <= 0) {
				logger.error("企业严重违法为空");
				return;
			}

			savePageRecord(enterpriseId, name, TycDataPageEnum.ILLEGAL, dtos.getPageTotal(), dtos.getPageNum());
			rptTnIllegalService.deleteByEnteprirseName(name);

			RptTnIllegalEntity entity = null;
			List<RptTnIllegalEntity> entityList = new ArrayList<RptTnIllegalEntity>();
			for (IllegalDTO dto : dtos.getIllegalResults()) {
				entity = new RptTnIllegalEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setDataState(1);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				entityList.add(entity);
			}
			rptTnIllegalService.insertBatch(entityList);
		} catch (Exception e) {
			logger.error("企业严重违法信息异常", e);
		}
	}

	/**
	 * 股权质押
	 * 
	 * @param enterpriseId
	 * @param name
	 * @param equityResultsDTO
	 */
	private void initEquity(Long enterpriseId, String name, EquityResultsDTO dtos) {
		try {
			if (null == dtos || null == dtos.getEquityResults() || dtos.getEquityResults().size() <= 0) {
				logger.error("企业股权质押信息为空");
				return;
			}

			savePageRecord(enterpriseId, name, TycDataPageEnum.EQUITY, dtos.getPageTotal(), dtos.getPageNum());
			rptTnEquityService.deleteByEnteprirseName(name);

			RptTnEquityEntity entity = null;
			List<RptTnEquityEntity> entityList = new ArrayList<RptTnEquityEntity>();
			for (EquityDTO dto : dtos.getEquityResults()) {
				entity = new RptTnEquityEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				entityList.add(entity);
			}
			rptTnEquityService.insertBatch(entityList);
		} catch (Exception e) {
			logger.error("企业股权质押异常", e);
		}
	}

	/**
	 * 欠税信息
	 * 
	 * @param enterpriseId
	 * @param name
	 * @param owingTaxResultsDTO
	 */
	private void initOwingTax(Long enterpriseId, String name, OwingTaxResultsDTO dtos) {
		try {
			if (null == dtos || null == dtos.getOwingTaxResults() || dtos.getOwingTaxResults().size() <= 0) {
				logger.error("企业欠税信息为空");
				return;
			}

			savePageRecord(enterpriseId, name, TycDataPageEnum.OWING_TAX, dtos.getPageTotal(), dtos.getPageNum());
			rptTnOwingTaxService.deleteByEnteprirseName(name);
			RptTnOwingTaxEntity entity = null;
			List<RptTnOwingTaxEntity> entityList = new ArrayList<RptTnOwingTaxEntity>();
			for (OwingTaxDTO dto : dtos.getOwingTaxResults()) {
				entity = new RptTnOwingTaxEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setDataState(1);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				entityList.add(entity);
			}
			rptTnOwingTaxService.insertBatch(entityList);
		} catch (Exception e) {
			logger.error("企业欠税信息异常", e);
		}
	}

	private void initMortgage(Long enterpriseId, String name, MortgageResultsDTO dtos) {
		try {
			if (null == dtos || null == dtos.getMortgageResults() || dtos.getMortgageResults().size() <= 0) {
				logger.error("企业动产抵押信息为空");
				return;
			}

			savePageRecord(enterpriseId, name, TycDataPageEnum.MORTGAGE, dtos.getPageTotal(), dtos.getPageNum());
			rptTnMortgageService.deleteByEnteprirseName(name);

			RptTnMortgageEntity entity = null;
			List<RptTnMortgageEntity> entityList = new ArrayList<RptTnMortgageEntity>();
			for (MortgageDTO dto : dtos.getMortgageResults()) {
				entity = new RptTnMortgageEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				entityList.add(entity);
			}
			rptTnMortgageService.insertBatch(entityList);
		} catch (Exception e) {
			logger.error("企业动产抵押信息异常", e);
		}
	}

	private void initJudicialSale(Long enterpriseId, String name, JudicialSaleResultsDTO dtos) {
		try {
			if (null == dtos || null == dtos.getJudicialSaleResults() || dtos.getJudicialSaleResults().size() <= 0) {
				logger.error("企业司法拍卖信息为空");
				return;
			}

			savePageRecord(enterpriseId, name, TycDataPageEnum.JUDICIAL_SALE, dtos.getPageTotal(), dtos.getPageNum());
			rptTnJudicialSaleService.deleteByEnteprirseName(name);

			RptTnJudicialSaleEntity entity = null;
			List<RptTnJudicialSaleEntity> entityList = new ArrayList<RptTnJudicialSaleEntity>();
			for (JudicialSaleDTO dto : dtos.getJudicialSaleResults()) {
				entity = new RptTnJudicialSaleEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setDataState(1);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				entityList.add(entity);
			}
			rptTnJudicialSaleService.insertBatch(entityList);
		} catch (Exception e) {
			logger.error("企业司法拍卖信息异常", e);
		}
	}

	private void initClearing(Long enterpriseId, String name, ClearingResultDTO dtos) {
		try {
			if (null == dtos || null == dtos.getClearingResults() || dtos.getClearingResults().size() <= 0) {
				logger.error("企业清算信息为空");
				return;
			}

			savePageRecord(enterpriseId, name, TycDataPageEnum.CLEAR, dtos.getPageTotal(), dtos.getPageNum());
			rptTnClearingService.deleteByEnteprirseName(name);

			RptTnClearingEntity entity = null;
			List<RptTnClearingEntity> entityList = new ArrayList<RptTnClearingEntity>();
			for (ClearingDTO dto : dtos.getClearingResults()) {
				entity = new RptTnClearingEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setDataState(1);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				entityList.add(entity);
			}
			rptTnClearingService.insertBatch(entityList);
		} catch (Exception e) {
			logger.error("企业司法拍卖信息异常", e);
		}
	}

}
