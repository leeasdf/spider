package xin.tianchuang.modules.spider.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.TycDataPageEnum;
import xin.tianchuang.modules.spider.bean.tyc.dto.AnnouncementcourtDTO;
import xin.tianchuang.modules.spider.bean.tyc.dto.CourtNoticeDTO;
import xin.tianchuang.modules.spider.bean.tyc.dto.DishonestDTO;
import xin.tianchuang.modules.spider.bean.tyc.dto.JudicialAidDTO;
import xin.tianchuang.modules.spider.bean.tyc.dto.LawsuitDTO;
import xin.tianchuang.modules.spider.bean.tyc.dto.ZhixingDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.AnnouncementcourtResultsDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.CourtNoticeResultsDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.DishonestResultsDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.JudicialAidResultsDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.LawsuitResultsDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.TycApiDataResultRespDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.ZhixingResultsDTO;
import xin.tianchuang.modules.spider.biz.TycLawDangerBiz;
import xin.tianchuang.modules.spider.entity.RptTnAnnouncementcourtEntity;
import xin.tianchuang.modules.spider.entity.RptTnCourtNoticeEntity;
import xin.tianchuang.modules.spider.entity.RptTnDishonestEntity;
import xin.tianchuang.modules.spider.entity.RptTnJudicialAidEntity;
import xin.tianchuang.modules.spider.entity.RptTnLawsuitEntity;
import xin.tianchuang.modules.spider.entity.RptTnZhixingEntity;
import xin.tianchuang.modules.spider.service.RptTnAnnouncementcourtService;
import xin.tianchuang.modules.spider.service.RptTnCourtNoticeService;
import xin.tianchuang.modules.spider.service.RptTnDishonestService;
import xin.tianchuang.modules.spider.service.RptTnJudicialAidService;
import xin.tianchuang.modules.spider.service.RptTnLawsuitService;
import xin.tianchuang.modules.spider.service.RptTnZhixingService;

@Service
public class TycLawDangerBizImpl extends TycAbstractImpl implements TycLawDangerBiz {
	private static final Logger logger = LoggerFactory.getLogger(TycLawDangerBiz.class);

	@Autowired
	private RptTnAnnouncementcourtService rptTnAnnouncementcourtService;
	@Autowired
	private RptTnLawsuitService rptTnLawsuitService;
	@Autowired
	private RptTnCourtNoticeService rptTnCourtNoticeService;
	@Autowired
	private RptTnDishonestService rptTnDishonestService;
	@Autowired
	private RptTnZhixingService rptTnZhixingService;
	@Autowired
	private RptTnJudicialAidService rptTnJudicialAidService;

	@Override
	public boolean saveData(Long enterpriseId, String name, TycApiDataResultRespDTO result) {
		// TODO 待完成
		this.initAnnouncementcourtInfo(enterpriseId, name, result.getAnnouncementcourt()); // 开庭公告
		this.initLawsuitInfo(enterpriseId, name, result.getLawsuit()); // 法律诉讼
		this.initCourtNotice(enterpriseId, name, result.getCourtNotice());// 法院公告
		this.initDishonestInfo(enterpriseId, name, result.getDishonest());// 失信人
		this.initZhixingInfo(enterpriseId, name, result.getZhixing());// 被执行人
		this.initJudicialAid(enterpriseId, name, result.getJudicialAid());// 司法协助

		return true;
	}

	private void initAnnouncementcourtInfo(Long enterpriseId, String name, AnnouncementcourtResultsDTO dtos) {
		try {
			if (null == dtos || dtos.getAnnouncementcourtResults() == null || dtos.getAnnouncementcourtResults().size() <= 0) {
				logger.error("企业开庭公告信息为空");
				return;
			}

			savePageRecord(enterpriseId, name, TycDataPageEnum.ANNOUNCEMENT_COURT, dtos.getPageTotal(), dtos.getPageNum());
			rptTnAnnouncementcourtService.deleteByEnteprirseName(name);

			RptTnAnnouncementcourtEntity entity = null;
			List<RptTnAnnouncementcourtEntity> entityList = new ArrayList<RptTnAnnouncementcourtEntity>();

			for (AnnouncementcourtDTO dto : dtos.getAnnouncementcourtResults()) {
				entity = new RptTnAnnouncementcourtEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				entityList.add(entity);
			}
			rptTnAnnouncementcourtService.insertBatch(entityList);
		} catch (Exception e) {
			logger.error("企业开庭公告信息异常", e);
		}
	}

	private void initLawsuitInfo(Long enterpriseId, String name, LawsuitResultsDTO dtos) {
		try {
			if (null == dtos || dtos.getLawsuitResults() == null || dtos.getLawsuitResults().size() <= 0) {
				logger.error("企业法律诉讼信息为空");
				return;
			}

			savePageRecord(enterpriseId, name, TycDataPageEnum.LAWSUIT, dtos.getPageTotal(), dtos.getPageNum());
			rptTnLawsuitService.deleteByEnteprirseName(name);

			RptTnLawsuitEntity entity = null;
			List<RptTnLawsuitEntity> entityList = new ArrayList<RptTnLawsuitEntity>();
			for (LawsuitDTO dto : dtos.getLawsuitResults()) {

				entity = new RptTnLawsuitEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				entityList.add(entity);
			}
			rptTnLawsuitService.insertBatch(entityList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("企业法律诉讼信息异常", e);
		}
	}

	private void initCourtNotice(Long enterpriseId, String name, CourtNoticeResultsDTO dtos) {
		try {
			if (null == dtos || dtos.getCourtNoticeResults() == null || dtos.getCourtNoticeResults().size() <= 0) {
				logger.error("企业法院公告信息为空");
				return;
			}

			savePageRecord(enterpriseId, name, TycDataPageEnum.COURT_NOTICE, dtos.getPageTotal(), dtos.getPageNum());
			rptTnCourtNoticeService.deleteByEnteprirseName(name);

			RptTnCourtNoticeEntity entity = null;
			List<RptTnCourtNoticeEntity> entityList = new ArrayList<RptTnCourtNoticeEntity>();
			for (CourtNoticeDTO dto : dtos.getCourtNoticeResults()) {
				entity = new RptTnCourtNoticeEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				entityList.add(entity);
			}
			rptTnCourtNoticeService.insertBatch(entityList);
		} catch (Exception e) {
			logger.error("企业法院公告信息异常", e);
		}
	}

	private void initDishonestInfo(Long enterpriseId, String name, DishonestResultsDTO dtos) {
		try {
			if (null == dtos || dtos.getDishonestResults() == null || dtos.getDishonestResults().size() <= 0) {
				logger.error("企业失信人信息为空");
				return;
			}

			savePageRecord(enterpriseId, name, TycDataPageEnum.DISHONEST, dtos.getPageTotal(), dtos.getPageNum());
			rptTnDishonestService.deleteByEnteprirseName(name);

			RptTnDishonestEntity entity = null;
			List<RptTnDishonestEntity> entityList = new ArrayList<RptTnDishonestEntity>();
			for (DishonestDTO dto : dtos.getDishonestResults()) {
				entity = new RptTnDishonestEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setCreator(9999);
				entity.setUpdater(9999);
				entityList.add(entity);
			}
			rptTnDishonestService.insertBatch(entityList);
		} catch (Exception e) {
			logger.error("企业失信人信息异常", e);
		}
	}

	private void initZhixingInfo(Long enterpriseId, String name, ZhixingResultsDTO dtos) {
		try {
			if (null == dtos || dtos.getZhixingResults() == null || dtos.getZhixingResults().size() <= 0) {
				logger.error("企业被执行人信息为空");
				return;
			}

			savePageRecord(enterpriseId, name, TycDataPageEnum.ZHI_XING, dtos.getPageTotal(), dtos.getPageNum());
			rptTnZhixingService.deleteByEnteprirseName(name);

			RptTnZhixingEntity entity = null;
			List<RptTnZhixingEntity> entityList = new ArrayList<RptTnZhixingEntity>();
			for (ZhixingDTO dto : dtos.getZhixingResults()) {
				entity = new RptTnZhixingEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				entityList.add(entity);
			}
			rptTnZhixingService.insertBatch(entityList);
		} catch (Exception e) {
			logger.error("企业-被执行人信息异常", e);
		}
	}

	private void initJudicialAid(Long enterpriseId, String name, JudicialAidResultsDTO dtos) {
		try {
			if (null == dtos || dtos.getJudicialAidResults() == null || dtos.getJudicialAidResults().size() <= 0) {
				logger.error("企业司法协助信息为空");
				return;
			}

			savePageRecord(enterpriseId, name, TycDataPageEnum.JUDICIAL_AID, dtos.getPageTotal(), dtos.getPageNum());
			rptTnJudicialAidService.deleteByEnteprirseName(name);

			RptTnJudicialAidEntity entity = null;
			List<RptTnJudicialAidEntity> entityList = new ArrayList<RptTnJudicialAidEntity>();
			for (JudicialAidDTO dto : dtos.getJudicialAidResults()) {
				entity = new RptTnJudicialAidEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				entityList.add(entity);

			}
			rptTnJudicialAidService.insertBatch(entityList);
		} catch (Exception e) {
			logger.error("企业-司法协助信息异常", e);
		}

	}

}
