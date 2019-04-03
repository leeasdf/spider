package xin.tianchuang.modules.spider.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.TycDataPageEnum;
import xin.tianchuang.modules.spider.bean.tyc.dto.JingpinDTO;
import xin.tianchuang.modules.spider.bean.tyc.dto.RongziDTO;
import xin.tianchuang.modules.spider.bean.tyc.dto.TouziDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.JingpinResultDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.RongziResultsDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.TouziResultDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.TycApiDataResultRespDTO;
import xin.tianchuang.modules.spider.biz.TycCompanyGrowthBiz;
import xin.tianchuang.modules.spider.entity.RptTnCompetitiveEntity;
import xin.tianchuang.modules.spider.entity.RptTnFinanceEntity;
import xin.tianchuang.modules.spider.entity.RptTnInvestEventEntity;
import xin.tianchuang.modules.spider.service.RptTnCompetitiveService;
import xin.tianchuang.modules.spider.service.RptTnFinanceService;
import xin.tianchuang.modules.spider.service.RptTnInvestEventService;

@Service
public class TycCompanyGrowthBizImpl extends TycAbstractImpl implements TycCompanyGrowthBiz {
	private static final Logger logger = LoggerFactory.getLogger(TycCompanyGrowthBiz.class);

	@Autowired
	private RptTnFinanceService rptTnFinanceService;
	@Autowired
	private RptTnInvestEventService rptTnInvestEventService;
	@Autowired
	private RptTnCompetitiveService rptTnCompetitiveService;

	@Override
	public boolean saveData(Long enterpriseId, String name, TycApiDataResultRespDTO result) {
		this.initFinance(enterpriseId, name, result.getRongzi());// 融资历史
		this.initInvestEvent(enterpriseId, name, result.getTouzi());// 投资事件
		this.initCompetitive(enterpriseId, name, result.getJingpin());// 竞品信息
		return true;
	}

	public void initFinance(Long enterpriseId, String name, RongziResultsDTO dtos) {
		try {
			if (null == dtos || null == dtos.getRongziResults() || dtos.getRongziResults().size() <= 0) {
				logger.error("融资历史信息为空");
				return;
			}

			rptTnFinanceService.deleteByEnteprirseName(name);

			RptTnFinanceEntity entity = null;
			List<RptTnFinanceEntity> entityList = new ArrayList<RptTnFinanceEntity>();
			for (RongziDTO dto : dtos.getRongziResults()) {
				entity = new RptTnFinanceEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				entityList.add(entity);
			}
			rptTnFinanceService.insertBatch(entityList);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("融资历史信息异常", e);
		}
	}

	public void initInvestEvent(Long enterpriseId, String name, TouziResultDTO dtos) {
		try {
			if (null == dtos || null == dtos.getTouziResults() || dtos.getTouziResults().size() <= 0) {
				logger.error("投资事件信息为空");
				return;
			}

			rptTnInvestEventService.deleteByEnteprirseName(name);

			RptTnInvestEventEntity entity = null;
			List<RptTnInvestEventEntity> entityList = new ArrayList<RptTnInvestEventEntity>();
			for (TouziDTO dto : dtos.getTouziResults()) {
				entity = new RptTnInvestEventEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setDataState(1);
				entity.setCreator(9999);

				entityList.add(entity);
			}
			rptTnInvestEventService.insertBatch(entityList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("投资事件插入失败", e);
		}
	}

	private void initCompetitive(Long enterpriseId, String name, JingpinResultDTO dtos) {
		try {
			if (null == dtos || null == dtos.getJingpinResults() || dtos.getJingpinResults().size() <= 0) {
				logger.error("企业竞品信息为空");
				return;
			}
			savePageRecord(enterpriseId, name, TycDataPageEnum.INVEST, dtos.getPageTotal(), dtos.getPageNum());

			rptTnCompetitiveService.deleteByEnteprirseName(name);

			RptTnCompetitiveEntity entity = null;
			List<RptTnCompetitiveEntity> entityList = new ArrayList<RptTnCompetitiveEntity>();
			for (JingpinDTO dto : dtos.getJingpinResults()) {
				entity = new RptTnCompetitiveEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setDataState(1);
				entity.setCreator(9999);

				entityList.add(entity);
			}
			rptTnCompetitiveService.insertBatch(entityList);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("企业竞品信息异常", e);
		}
	}

}
