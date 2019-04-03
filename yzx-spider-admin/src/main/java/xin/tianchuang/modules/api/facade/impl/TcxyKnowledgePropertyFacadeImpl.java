package xin.tianchuang.modules.api.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xin.tianchuang.modules.api.bean.v1.RptTcxyCompanyCopyrightDTO;
import xin.tianchuang.modules.api.bean.v1.RptTcxyCompanySoftwareCopyrightDTO;
import xin.tianchuang.modules.api.bean.v1.RptTcxyPatentBaseDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnIcpDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnPatentDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnSoftwareRightAuthorDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnTrademarkDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnWorksRightDTO;
import xin.tianchuang.modules.api.facade.tcxy.TcxyKnowledgePropertyFacade;
import xin.tianchuang.modules.spider.service.RptTcxyCompanyCopyrightService;
import xin.tianchuang.modules.spider.service.RptTcxyCompanySoftwareCopyrightService;
import xin.tianchuang.modules.spider.service.RptTcxyPatentBaseService;
import xin.tianchuang.modules.spider.service.RptTnIcpService;
import xin.tianchuang.modules.spider.service.RptTnPatentService;
import xin.tianchuang.modules.spider.service.RptTnSoftwareRightAuthorService;
import xin.tianchuang.modules.spider.service.RptTnTrademarkService;
import xin.tianchuang.modules.spider.service.RptTnWorksRightService;

/**
 * 天创信用-知识产权
 * 
 * @author denghui
 *
 */
@Service
public class TcxyKnowledgePropertyFacadeImpl extends BaseFacadeImpl implements TcxyKnowledgePropertyFacade {

	@Autowired
	private RptTcxyPatentBaseService rptTcxyPatentBaseService;
	@Autowired
	private RptTcxyCompanySoftwareCopyrightService rptTcxyCompanySoftwareCopyrightService;
	@Autowired
	private RptTcxyCompanyCopyrightService rptTcxyCompanyCopyrightService;

	@Override
	public List<RptTcxyPatentBaseDTO> getPatent(String name, String creditCode) {
		return ejbGenerator.convert(rptTcxyPatentBaseService.selectListByNameCode(name, creditCode), RptTcxyPatentBaseDTO.class);
	}

	@Override
	public List<RptTcxyCompanySoftwareCopyrightDTO> getCopyright(String name, String creditCode) {
		return ejbGenerator.convert(rptTcxyCompanySoftwareCopyrightService.selectListByNameCode(name, creditCode), RptTcxyCompanySoftwareCopyrightDTO.class);
	}

	@Override
	public List<RptTcxyCompanyCopyrightDTO> getCopyrightWorks(String name, String creditCode) {
		return ejbGenerator.convert(rptTcxyCompanyCopyrightService.selectListByNameCode(name, creditCode), RptTcxyCompanyCopyrightDTO.class);
	}

}
