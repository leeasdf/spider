package xin.tianchuang.modules.spider.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.TycDataPageEnum;
import xin.tianchuang.modules.spider.bean.tyc.dto.IcpDTO;
import xin.tianchuang.modules.spider.bean.tyc.dto.PatentDTO;
import xin.tianchuang.modules.spider.bean.tyc.dto.SoftwareRightDTO;
import xin.tianchuang.modules.spider.bean.tyc.dto.TrademarkDTO;
import xin.tianchuang.modules.spider.bean.tyc.dto.WorksRightDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.IcpResultsDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.PatentResultsDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.SoftwareRightResultsDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.TrademarkResultsDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.TycApiDataResultRespDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.WorksRightResultsDTO;
import xin.tianchuang.modules.spider.biz.TycKnowledgePropertyBiz;
import xin.tianchuang.modules.spider.entity.RptTnIcpEntity;
import xin.tianchuang.modules.spider.entity.RptTnPatentEntity;
import xin.tianchuang.modules.spider.entity.RptTnSoftwareRightEntity;
import xin.tianchuang.modules.spider.entity.RptTnTrademarkEntity;
import xin.tianchuang.modules.spider.entity.RptTnWorksRightEntity;
import xin.tianchuang.modules.spider.service.RptTnIcpService;
import xin.tianchuang.modules.spider.service.RptTnPatentService;
import xin.tianchuang.modules.spider.service.RptTnSoftwareRightService;
import xin.tianchuang.modules.spider.service.RptTnTrademarkService;
import xin.tianchuang.modules.spider.service.RptTnWorksRightService;

@Service
public class TycKnowledgePropertyBizImpl extends TycAbstractImpl implements TycKnowledgePropertyBiz {
	private static final Logger logger = LoggerFactory.getLogger(TycKnowledgePropertyBiz.class);

	@Autowired
	private RptTnTrademarkService rptTnTrademarkService;
	@Autowired
	private RptTnPatentService rptTnPatentService;
	@Autowired
	private RptTnSoftwareRightService rptTnSoftwareRightService;
	@Autowired
	private RptTnWorksRightService rptTnWorksRightService;
	@Autowired
	private RptTnIcpService rptTnIcpService;

	@Override
	public boolean saveData(Long enterpriseId, String name, TycApiDataResultRespDTO result) {
		this.initTrademarkInfo(enterpriseId, name, result.getTrademark()); // 商标信息
		this.initPatentInfo(enterpriseId, name, result.getPatent()); // 专利信息
		this.initSoftwareRightInfo(enterpriseId, name, result.getSoftwareRight()); // 软件著作权
		this.initWorksRightInfo(enterpriseId, name, result.getWorksRight()); // 作品著作权
		this.initIcp(enterpriseId, name, result.getIcp()); // 网站备案信息

		return true;
	}

	/**
	 * 企业商标
	 * 
	 * @param enterpriseId
	 * @param name
	 * @param dtos
	 */
	private void initTrademarkInfo(Long enterpriseId, String name, TrademarkResultsDTO dtos) {
		try {
			if (null == dtos || dtos.getTrademarkResults() == null || dtos.getTrademarkResults().size() <= 0) {
				logger.error("企业商标信息为空");
				return;
			}

			savePageRecord(enterpriseId, name, TycDataPageEnum.TRADEMARK, dtos.getPageTotal(), dtos.getPageNum());

			rptTnTrademarkService.deleteByEnteprirseName(name);

			RptTnTrademarkEntity entity = null;
			List<RptTnTrademarkEntity> entityList = new ArrayList<RptTnTrademarkEntity>();
			for (TrademarkDTO dto : dtos.getTrademarkResults()) {
				entity = new RptTnTrademarkEntity();
				BeanUtils.copyProperties(dto, entity);
				
				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				entityList.add(entity);
			}
			rptTnTrademarkService.insertBatch(entityList);
		} catch (Exception e) {
			logger.error("企业商标信息异常", e);
		}
	}

	private void initPatentInfo(Long enterpriseId, String name, PatentResultsDTO dtos) {
		try {
			if (null == dtos || dtos.getPatentResults() == null || dtos.getPatentResults().size() <= 0) {
				logger.error("企业专利信息为空");
				return;
			}

			savePageRecord(enterpriseId, name, TycDataPageEnum.PATENT, dtos.getPageTotal(), dtos.getPageNum());

			rptTnPatentService.deleteByEnteprirseName(name);

			RptTnPatentEntity entity = null;
			List<RptTnPatentEntity> entityList = new ArrayList<RptTnPatentEntity>();

			for (PatentDTO dto : dtos.getPatentResults()) {
				entity = new RptTnPatentEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				entityList.add(entity);
			}
			rptTnPatentService.insertBatch(entityList);
		} catch (Exception e) {
			logger.error("企业专利信息异常", e);
		}
	}

	private void initSoftwareRightInfo(Long enterpriseId, String name, SoftwareRightResultsDTO dtos) {
		try {
			if (null == dtos || dtos.getSoftwareRightResults() == null || dtos.getSoftwareRightResults().size() <= 0) {
				logger.error("企业软件著作权信息为空");
				return;
			}
			savePageRecord(enterpriseId, name, TycDataPageEnum.SOFTWARE_RIGHT, dtos.getPageTotal(), dtos.getPageNum());
			rptTnSoftwareRightService.deleteByEnteprirseName(name);

			RptTnSoftwareRightEntity entity = null;
			List<RptTnSoftwareRightEntity> entityList = new ArrayList<RptTnSoftwareRightEntity>();

			for (SoftwareRightDTO dto : dtos.getSoftwareRightResults()) {
				entity = new RptTnSoftwareRightEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				entityList.add(entity);
			}
			rptTnSoftwareRightService.insertBatch(entityList);
		} catch (Exception e) {
			logger.error("企业软件著作权信息异常", e);
		}
	}

	private void initWorksRightInfo(Long enterpriseId, String name, WorksRightResultsDTO dtos) {
		try {
			if (null == dtos || dtos.getWorksRightResults() == null || dtos.getWorksRightResults().size() <= 0) {
				logger.error("企业作品著作权信息为空");
				return;
			}
			savePageRecord(enterpriseId, name, TycDataPageEnum.WORKS_RIGHT, dtos.getPageTotal(), dtos.getPageNum());
			rptTnWorksRightService.deleteByEnteprirseName(name);

			RptTnWorksRightEntity entity = null;
			List<RptTnWorksRightEntity> entityList = new ArrayList<RptTnWorksRightEntity>();

			for (WorksRightDTO dto : dtos.getWorksRightResults()) {
				entity = new RptTnWorksRightEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				entityList.add(entity);

			}
			rptTnWorksRightService.insertBatch(entityList);
		} catch (Exception e) {
			logger.error("企业作品著作权信息异常", e);
		}
	}

	private void initIcp(Long enterpriseId, String name, IcpResultsDTO dtos) {
		try {
			if (null == dtos || dtos.getIcpResults() == null || dtos.getIcpResults().size() <= 0) {
				logger.error("企业网站备案信息为空");
				return;
			}

			savePageRecord(enterpriseId, name, TycDataPageEnum.ICP, dtos.getPageTotal(), dtos.getPageNum());
			rptTnIcpService.deleteByEnteprirseName(name);

			RptTnIcpEntity entity = null;
			List<RptTnIcpEntity> entityList = new ArrayList<RptTnIcpEntity>();

			for (IcpDTO dto : dtos.getIcpResults()) {
				entity = new RptTnIcpEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setDataState(1);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				entityList.add(entity);
			}
			rptTnIcpService.insertBatch(entityList);
		} catch (Exception e) {
			logger.error("企业网站备案信息异常", e);
		}

	}
}
