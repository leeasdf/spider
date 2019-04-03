package xin.tianchuang.modules.spider.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.TycDataPageEnum;
import xin.tianchuang.modules.spider.bean.tyc.dto.BidDTO;
import xin.tianchuang.modules.spider.bean.tyc.dto.BondDTO;
import xin.tianchuang.modules.spider.bean.tyc.dto.CertificateDTO;
import xin.tianchuang.modules.spider.bean.tyc.dto.CheckDTO;
import xin.tianchuang.modules.spider.bean.tyc.dto.ImportExportDTO;
import xin.tianchuang.modules.spider.bean.tyc.dto.LicensingDTO;
import xin.tianchuang.modules.spider.bean.tyc.dto.LicensingXyzgDTO;
import xin.tianchuang.modules.spider.bean.tyc.dto.ProductDTO;
import xin.tianchuang.modules.spider.bean.tyc.dto.PurchaselandDTO;
import xin.tianchuang.modules.spider.bean.tyc.dto.TaxCreditDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.BidResultsDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.BondResultsDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.CertificateResultsDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.CheckResultsDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.ImportExportResultsDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.LicensingResultDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.LicensingXyzgResultsDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.ProductResultsDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.PurchaselandResultDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.TaxCreditResultsDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.TycApiDataResultRespDTO;
import xin.tianchuang.modules.spider.biz.TycManageStatusBiz;
import xin.tianchuang.modules.spider.entity.RptTnBidEntity;
import xin.tianchuang.modules.spider.entity.RptTnBondEntity;
import xin.tianchuang.modules.spider.entity.RptTnCertificateEntity;
import xin.tianchuang.modules.spider.entity.RptTnCheckEntity;
import xin.tianchuang.modules.spider.entity.RptTnImportExportEntity;
import xin.tianchuang.modules.spider.entity.RptTnLicensingEntity;
import xin.tianchuang.modules.spider.entity.RptTnLicensingXyzgEntity;
import xin.tianchuang.modules.spider.entity.RptTnProductEntity;
import xin.tianchuang.modules.spider.entity.RptTnPurchaselandEntity;
import xin.tianchuang.modules.spider.entity.RptTnTaxCreditEntity;
import xin.tianchuang.modules.spider.service.RptTnBidService;
import xin.tianchuang.modules.spider.service.RptTnBondService;
import xin.tianchuang.modules.spider.service.RptTnCertificateService;
import xin.tianchuang.modules.spider.service.RptTnCheckService;
import xin.tianchuang.modules.spider.service.RptTnImportExportService;
import xin.tianchuang.modules.spider.service.RptTnLicensingService;
import xin.tianchuang.modules.spider.service.RptTnLicensingXyzgService;
import xin.tianchuang.modules.spider.service.RptTnProductService;
import xin.tianchuang.modules.spider.service.RptTnPurchaselandService;
import xin.tianchuang.modules.spider.service.RptTnTaxCreditService;

@Service
public class TycManageStatusBizImpl extends TycAbstractImpl implements TycManageStatusBiz {
	private static final Logger logger = LoggerFactory.getLogger(TycManageStatusBiz.class);

	@Autowired
	private RptTnCheckService rptTnCheckService;
	@Autowired
	private RptTnTaxCreditService rptTnTaxCreditService;
	@Autowired
	private RptTnBidService rptTnBidService;
	@Autowired
	private RptTnImportExportService rptTnImportExportService;
	@Autowired
	private RptTnLicensingXyzgService rptTnLicensingXyzgService;
	@Autowired
	private RptTnProductService rptTnProductService;
	@Autowired
	private RptTnCertificateService rptTnCertificateService;
	@Autowired
	private RptTnBondService rptTnBondService;
	@Autowired
	private RptTnPurchaselandService rptTnPurchaselandService;
	@Autowired
	private RptTnLicensingService rptTnLicensingService;

	@Override
	public boolean saveData(Long enterpriseId, String name, TycApiDataResultRespDTO result) {
		// 招聘信息
		this.initLicensing(enterpriseId, name, result.getLicensing()); // 行政许可[工商局]
		this.initLicensingXyzg(enterpriseId, name, result.getLicensingXyzg()); // 行政许可[信用中国]
		this.initTaxCredit(enterpriseId, name, result.getTaxcredit()); // 税务评级
		this.initCheck(enterpriseId, name, result.getCheck()); // 抽查检查
		this.initCertificate(enterpriseId, name, result.getCertificate()); // 资质证书
		this.initBid(enterpriseId, name, result.getBid()); // 招投标信息
		// 微信公众号
		this.initProduct(enterpriseId, name, result.getProduct());// 产品信息
		this.initImportAndExport(enterpriseId, name, result.getImportAndExport()); // 进出口信用
		this.initBond(enterpriseId, name, result.getBond()); // 债券信息
		this.initPurchaseland(enterpriseId, name, result.getPurchaseland()); // 购地信息

		return true;
	}

	private void initCheck(Long enterpriseId, String name, CheckResultsDTO dtos) {
		try {
			if (null == dtos || null == dtos.getCheckResults() || dtos.getCheckResults().size() <= 0) {
				logger.error("企业抽查检查信息为空");
				return;
			}

			savePageRecord(enterpriseId, name, TycDataPageEnum.CHECK, dtos.getPageTotal(), dtos.getPageNum());
			rptTnCheckService.deleteByEnteprirseName(name);

			RptTnCheckEntity entity = null;
			List<RptTnCheckEntity> entityList = new ArrayList<RptTnCheckEntity>();
			for (CheckDTO dto : dtos.getCheckResults()) {
				entity = new RptTnCheckEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				entityList.add(entity);
			}
			rptTnCheckService.insertBatch(entityList);
		} catch (Exception e) {
			logger.error("企业抽查检查信息异常", e);
		}

	}

	private void initTaxCredit(Long enterpriseId, String name, TaxCreditResultsDTO dtos) {
		try {
			if (null == dtos || null == dtos.getTaxCreditResults() || dtos.getTaxCreditResults().size() <= 0) {
				logger.error("企业税务评级信息为空");
				return;
			}

			savePageRecord(enterpriseId, name, TycDataPageEnum.TAX_CREDIT, dtos.getPageTotal(), dtos.getPageNum());
			rptTnTaxCreditService.deleteByEnteprirseName(name);

			RptTnTaxCreditEntity entity = null;
			List<RptTnTaxCreditEntity> entityList = new ArrayList<RptTnTaxCreditEntity>();
			for (TaxCreditDTO dto : dtos.getTaxCreditResults()) {
				entity = new RptTnTaxCreditEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				entityList.add(entity);
			}
			rptTnTaxCreditService.insertBatch(entityList);
		} catch (Exception e) {
			logger.error("企业税务评级异常", e);
		}

	}

	private void initBid(Long enterpriseId, String name, BidResultsDTO dtos) {
		try {
			if (null == dtos || null == dtos.getBidResults() || dtos.getBidResults().size() <= 0) {
				logger.error("企业招投标信息为空");
				return;
			}

			savePageRecord(enterpriseId, name, TycDataPageEnum.BID, dtos.getPageTotal(), dtos.getPageNum());
			rptTnBidService.deleteByEnteprirseName(name);

			RptTnBidEntity entity = null;
			List<RptTnBidEntity> entityList = new ArrayList<RptTnBidEntity>();
			for (BidDTO dto : dtos.getBidResults()) {
				entity = new RptTnBidEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				entityList.add(entity);
			}
			rptTnBidService.insertBatch(entityList);
		} catch (Exception e) {
			logger.error("企业投标信息异常", e);
		}
	}

	/**
	 * 进出口信息用
	 * 
	 * @param enterpriseId
	 * @param name
	 * @param importExportResultsDTO
	 */
	private void initImportAndExport(Long enterpriseId, String name, ImportExportResultsDTO dtos) {
		try {
			if (null == dtos || null == dtos.getImportAndExportResults() || dtos.getImportAndExportResults().size() <= 0) {
				logger.error("企业进出口信用信息为空");
				return;
			}

			savePageRecord(enterpriseId, name, TycDataPageEnum.IMPORT_EXPORT, dtos.getPageTotal(), dtos.getPageNum());
			rptTnImportExportService.deleteByEnteprirseName(name);

			RptTnImportExportEntity entity = null;
			List<RptTnImportExportEntity> entityList = new ArrayList<RptTnImportExportEntity>();
			for (ImportExportDTO dto : dtos.getImportAndExportResults()) {
				entity = new RptTnImportExportEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				entityList.add(entity);
			}
			rptTnImportExportService.insertBatch(entityList);
		} catch (Exception e) {
			logger.error("企业进出口信用信息异常", e);
		}

	}

	private void initLicensing(Long enterpriseId, String name, LicensingResultDTO dtos) {
		try {
			if (null == dtos || null == dtos.getLicensingResults() || dtos.getLicensingResults().size() <= 0) {
				logger.error("企业行政许可[工商局]为空");
				return;
			}
			
			savePageRecord(enterpriseId, name, TycDataPageEnum.LICENSING_XYZG, dtos.getPageTotal(), dtos.getPageNum());
			rptTnLicensingService.deleteByEnteprirseName(name);
			
			RptTnLicensingEntity entity = null;
			List<RptTnLicensingEntity> entityList = new ArrayList<RptTnLicensingEntity>();
			for (LicensingDTO dto : dtos.getLicensingResults()) {
				entity = new RptTnLicensingEntity();
				BeanUtils.copyProperties(dto, entity);
				
				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setCreator(9999);
				entity.setUpdater(9999);
				
				entityList.add(entity);
			}
			rptTnLicensingService.insertBatch(entityList);
		} catch (Exception e) {
			logger.error("企业行政许可[工商局]异常", e);
		}
	}

	private void initLicensingXyzg(Long enterpriseId, String name, LicensingXyzgResultsDTO dtos) {
		try {
			if (null == dtos || null == dtos.getLicensingXyzgResults() || dtos.getLicensingXyzgResults().size() <= 0) {
				logger.error("企业行政许可[信用中国]为空");
				return;
			}

			savePageRecord(enterpriseId, name, TycDataPageEnum.LICENSING_XYZG, dtos.getPageTotal(), dtos.getPageNum());
			rptTnLicensingXyzgService.deleteByEnteprirseName(name);

			RptTnLicensingXyzgEntity entity = null;
			List<RptTnLicensingXyzgEntity> entityList = new ArrayList<RptTnLicensingXyzgEntity>();
			for (LicensingXyzgDTO dto : dtos.getLicensingXyzgResults()) {
				entity = new RptTnLicensingXyzgEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				entityList.add(entity);
			}
			rptTnLicensingXyzgService.insertBatch(entityList);
		} catch (Exception e) {
			logger.error("企业行政许可[信用中国]异常", e);
		}
	}

	private void initCertificate(Long enterpriseId, String name, CertificateResultsDTO dtos) {
		try {
			if (null == dtos || null == dtos.getCertificateResults() || dtos.getCertificateResults().size() <= 0) {
				logger.error("企业资质证书信息为空");
				return;
			}

			savePageRecord(enterpriseId, name, TycDataPageEnum.CERTIFICATE, dtos.getPageTotal(), dtos.getPageNum());
			rptTnCertificateService.deleteByEnteprirseName(name);

			RptTnCertificateEntity entity = null;
			List<RptTnCertificateEntity> entityList = new ArrayList<RptTnCertificateEntity>();
			for (CertificateDTO dto : dtos.getCertificateResults()) {
				entity = new RptTnCertificateEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				entityList.add(entity);
			}
			rptTnCertificateService.insertBatch(entityList);
		} catch (Exception e) {
			logger.error("企业资质证书信息异常", e);
		}
	}

	private void initProduct(Long enterpriseId, String name, ProductResultsDTO dtos) {
		try {
			if (null == dtos || null == dtos.getProductResults() || dtos.getProductResults().size() <= 0) {
				logger.error("企业产品信息为空");
				return;
			}

			savePageRecord(enterpriseId, name, TycDataPageEnum.PRODUCT, dtos.getPageTotal(), dtos.getPageNum());
			rptTnProductService.deleteByEnteprirseName(name);

			RptTnProductEntity entity = null;
			List<RptTnProductEntity> entityList = new ArrayList<RptTnProductEntity>();
			for (ProductDTO dto : dtos.getProductResults()) {
				entity = new RptTnProductEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				entityList.add(entity);
			}
			rptTnProductService.insertBatch(entityList);
		} catch (Exception e) {
			logger.error("企业产品信息异常", e);
		}
	}

	private void initBond(Long enterpriseId, String name, BondResultsDTO dtos) {
		try {
			if (null == dtos || null == dtos.getBondResults() || dtos.getBondResults().size() <= 0) {
				logger.error("企业债券信息为空");
				return;
			}

			savePageRecord(enterpriseId, name, TycDataPageEnum.BOND, dtos.getPageTotal(), dtos.getPageNum());
			rptTnBondService.deleteByEnteprirseName(name);

			RptTnBondEntity entity = null;
			List<RptTnBondEntity> entityList = new ArrayList<RptTnBondEntity>();
			for (BondDTO dto : dtos.getBondResults()) {
				entity = new RptTnBondEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				entityList.add(entity);
			}
			rptTnBondService.insertBatch(entityList);
		} catch (Exception e) {
			logger.error("企业债券信息异常", e);
		}
	}

	private void initPurchaseland(Long enterpriseId, String name, PurchaselandResultDTO dtos) {
		try {
			if (null == dtos || null == dtos.getPurchaselandResults() || dtos.getPurchaselandResults().size() <= 0) {
				logger.error("企业购地信息为空");
				return;
			}

			savePageRecord(enterpriseId, name, TycDataPageEnum.PURCHASELAND, dtos.getPageTotal(), dtos.getPageNum());
			rptTnPurchaselandService.deleteByEnteprirseName(name);

			RptTnPurchaselandEntity entity = null;
			List<RptTnPurchaselandEntity> entityList = new ArrayList<RptTnPurchaselandEntity>();
			for (PurchaselandDTO dto : dtos.getPurchaselandResults()) {
				entity = new RptTnPurchaselandEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setEnterpriseId(enterpriseId);
				entity.setEntName(name);
				entity.setCreator(9999);
				entity.setUpdater(9999);

				entityList.add(entity);
			}
			rptTnPurchaselandService.insertBatch(entityList);
		} catch (Exception e) {
			logger.error("企业购地信息异常", e);
		}
	}

}
