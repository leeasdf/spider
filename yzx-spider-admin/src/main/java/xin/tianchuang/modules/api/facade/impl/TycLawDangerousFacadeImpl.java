package xin.tianchuang.modules.api.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xin.tianchuang.modules.api.bean.v1.RptTnAnnouncementcourtDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnCourtNoticeDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnDishonestDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnLawsuitDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnZhixingDTO;
import xin.tianchuang.modules.api.facade.tyc.TycLawDangerousFacade;
import xin.tianchuang.modules.spider.service.RptTnAnnouncementcourtService;
import xin.tianchuang.modules.spider.service.RptTnCourtNoticeService;
import xin.tianchuang.modules.spider.service.RptTnDishonestService;
import xin.tianchuang.modules.spider.service.RptTnLawsuitService;
import xin.tianchuang.modules.spider.service.RptTnZhixingService;

/**
 * 天眼查对外-司法风险接口
 * 
 * @author denghui
 *
 */
@Service
public class TycLawDangerousFacadeImpl extends BaseFacadeImpl implements TycLawDangerousFacade {

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

	@Override
	public List<RptTnAnnouncementcourtDTO> getAnnouncement(String name, String creditCode) {
		return ejbGenerator.convert(rptTnAnnouncementcourtService.selectListByNameCode(name, creditCode), RptTnAnnouncementcourtDTO.class);
	}

	@Override
	public List<RptTnLawsuitDTO> getLawsuit(String name, String creditCode) {
		return ejbGenerator.convert(rptTnLawsuitService.selectListByNameCode(name, creditCode), RptTnLawsuitDTO.class);
	}

	@Override
	public List<RptTnCourtNoticeDTO> getCourt(String name, String creditCode) {
		return ejbGenerator.convert(rptTnCourtNoticeService.selectListByNameCode(name, creditCode), RptTnCourtNoticeDTO.class);
	}

	@Override
	public List<RptTnDishonestDTO> getDishonest(String name, String creditCode) {
		return ejbGenerator.convert(rptTnDishonestService.selectListByNameCode(name, creditCode), RptTnDishonestDTO.class);
	}

	@Override
	public List<RptTnZhixingDTO> getZhixing(String name, String creditCode) {
		return ejbGenerator.convert(rptTnZhixingService.selectListByNameCode(name, creditCode), RptTnZhixingDTO.class);
	}

}
