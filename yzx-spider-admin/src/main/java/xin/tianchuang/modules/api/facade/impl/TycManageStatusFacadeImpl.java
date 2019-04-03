package xin.tianchuang.modules.api.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xin.tianchuang.modules.api.bean.v1.RptTnBidDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnCheckDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnImportExportDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnTaxCreditDTO;
import xin.tianchuang.modules.api.facade.tyc.TycManageStatusFacade;
import xin.tianchuang.modules.spider.service.RptTnBidService;
import xin.tianchuang.modules.spider.service.RptTnCheckService;
import xin.tianchuang.modules.spider.service.RptTnImportExportService;
import xin.tianchuang.modules.spider.service.RptTnTaxCreditService;

/**
 * 天眼查-经营状况
 * 
 * @author denghui
 *
 */
@Service
public class TycManageStatusFacadeImpl extends BaseFacadeImpl implements TycManageStatusFacade {

	@Autowired
	private RptTnBidService rptTnBidService;
	@Autowired
	private RptTnTaxCreditService rptTnTaxCreditService;
	@Autowired
	private RptTnCheckService rptTnCheckService;
	@Autowired
	private RptTnImportExportService rptTnImportExportService;

	@Override
	public List<RptTnBidDTO> getBid(String name, String creditCode) {
		return ejbGenerator.convert(rptTnBidService.selectListByNameCode(name, creditCode), RptTnBidDTO.class);
	}

	@Override
	public List<RptTnTaxCreditDTO> getTaxCredit(String name, String creditCode) {
		return ejbGenerator.convert(rptTnTaxCreditService.selectListByNameCode(name, creditCode), RptTnTaxCreditDTO.class);
	}

	@Override
	public List<RptTnCheckDTO> getCheck(String name, String creditCode) {
		return ejbGenerator.convert(rptTnCheckService.selectListByNameCode(name, creditCode), RptTnCheckDTO.class);
	}

	@Override
	public List<RptTnImportExportDTO> getImportAndExport(String name, String creditCode) {
		return ejbGenerator.convert(rptTnImportExportService.selectListByNameCode(name, creditCode), RptTnImportExportDTO.class);
	}

}
