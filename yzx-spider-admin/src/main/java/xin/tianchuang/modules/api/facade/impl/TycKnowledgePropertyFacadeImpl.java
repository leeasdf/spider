package xin.tianchuang.modules.api.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xin.tianchuang.modules.api.bean.v1.RptTnIcpDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnPatentDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnSoftwareRightAuthorDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnTrademarkDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnWorksRightDTO;
import xin.tianchuang.modules.api.facade.tyc.TycKnowledgePropertyFacade;
import xin.tianchuang.modules.spider.service.RptTnIcpService;
import xin.tianchuang.modules.spider.service.RptTnPatentService;
import xin.tianchuang.modules.spider.service.RptTnSoftwareRightAuthorService;
import xin.tianchuang.modules.spider.service.RptTnTrademarkService;
import xin.tianchuang.modules.spider.service.RptTnWorksRightService;

/**
 * 天眼查-知识产权
 * 
 * @author denghui
 *
 */
@Service
public class TycKnowledgePropertyFacadeImpl extends BaseFacadeImpl implements TycKnowledgePropertyFacade {

	@Autowired
	private RptTnTrademarkService rptTnTrademarkService;
	@Autowired
	private RptTnPatentService rptTnPatentService;
	@Autowired
	private RptTnSoftwareRightAuthorService rptTnSoftwareRightAuthorService;
	@Autowired
	private RptTnWorksRightService rptTnWorksRightService;
	@Autowired
	private RptTnIcpService rptTnIcpService;

	@Override
	public List<RptTnTrademarkDTO> getTmInfo(String name, String creditCode) {
		return ejbGenerator.convert(rptTnTrademarkService.selectListByNameCode(name, creditCode), RptTnTrademarkDTO.class);
	}

	@Override
	public List<RptTnPatentDTO> getPatent(String name, String creditCode) {
		return ejbGenerator.convert(rptTnPatentService.selectListByNameCode(name, creditCode), RptTnPatentDTO.class);
	}

	@Override
	public List<RptTnSoftwareRightAuthorDTO> getCopyright(String name, String creditCode) {
		return ejbGenerator.convert(rptTnSoftwareRightAuthorService.selectListByNameCode(name, creditCode), RptTnSoftwareRightAuthorDTO.class);
	}

	@Override
	public List<RptTnWorksRightDTO> getCopyrightWorks(String name, String creditCode) {
		return ejbGenerator.convert(rptTnWorksRightService.selectListByNameCode(name, creditCode), RptTnWorksRightDTO.class);
	}

	@Override
	public List<RptTnIcpDTO> getIcp(String name, String creditCode) {
		return ejbGenerator.convert(rptTnIcpService.selectListByNameCode(name, creditCode), RptTnIcpDTO.class);
	}

}
