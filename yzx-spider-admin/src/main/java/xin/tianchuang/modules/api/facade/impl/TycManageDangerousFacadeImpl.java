package xin.tianchuang.modules.api.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xin.tianchuang.modules.api.bean.v1.RptTnAbnormalDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnEquityDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnIllegalDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnOwingTaxDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnPenaltiesDTO;
import xin.tianchuang.modules.api.facade.tyc.TycManageDangerousFacade;
import xin.tianchuang.modules.spider.service.RptTnAbnormalService;
import xin.tianchuang.modules.spider.service.RptTnEquityService;
import xin.tianchuang.modules.spider.service.RptTnIllegalService;
import xin.tianchuang.modules.spider.service.RptTnOwingTaxService;
import xin.tianchuang.modules.spider.service.RptTnPenaltiesService;

/**
 * 天眼查对外-经营风险接口
 * 
 * @author denghui
 *
 */
@Service
public class TycManageDangerousFacadeImpl extends BaseFacadeImpl implements TycManageDangerousFacade {

	@Autowired
	private RptTnAbnormalService rptTnAbnormalService;
	@Autowired
	private RptTnPenaltiesService rptTnPenaltiesService;
	@Autowired
	private RptTnIllegalService rptTnIllegalService;
	@Autowired
	private RptTnEquityService rptTnEquityService;
	@Autowired
	private RptTnOwingTaxService rptTnOwingTaxService;

	@Override
	public List<RptTnAbnormalDTO> getAbnormal(String name, String creditCode) {
		return ejbGenerator.convert(rptTnAbnormalService.selectListByNameCode(name, creditCode), RptTnAbnormalDTO.class);
	}

	@Override
	public List<RptTnPenaltiesDTO> getPunish(String name, String creditCode) {
		return ejbGenerator.convert(rptTnPenaltiesService.selectListByNameCode(name, creditCode), RptTnPenaltiesDTO.class);
	}

	@Override
	public List<RptTnIllegalDTO> getIllegal(String name, String creditCode) {
		return ejbGenerator.convert(rptTnIllegalService.selectListByNameCode(name, creditCode), RptTnIllegalDTO.class);
	}

	@Override
	public List<RptTnEquityDTO> getEquity(String name, String creditCode) {
		return ejbGenerator.convert(rptTnEquityService.selectListByNameCode(name, creditCode), RptTnEquityDTO.class);
	}

	@Override
	public List<RptTnOwingTaxDTO> getOwntax(String name, String creditCode) {
		return ejbGenerator.convert(rptTnOwingTaxService.selectListByNameCode(name, creditCode), RptTnOwingTaxDTO.class);
	}

}
