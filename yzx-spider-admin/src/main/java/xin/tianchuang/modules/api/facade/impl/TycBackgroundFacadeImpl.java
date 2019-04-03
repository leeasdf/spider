package xin.tianchuang.modules.api.facade.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import xin.tianchuang.common.component.dozer.EjbDozerGenerator;
import xin.tianchuang.modules.api.bean.v1.RptTnBasicInfoDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnBranchesDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnChangeDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnInvestDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnPersonDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnShareholdersDTO;
import xin.tianchuang.modules.api.facade.tyc.TycBackgroundFacade;
import xin.tianchuang.modules.spider.entity.RptTnBasicInfoEntity;
import xin.tianchuang.modules.spider.service.RptTnBasicInfoService;
import xin.tianchuang.modules.spider.service.RptTnBranchesService;
import xin.tianchuang.modules.spider.service.RptTnChangeService;
import xin.tianchuang.modules.spider.service.RptTnInvestService;
import xin.tianchuang.modules.spider.service.RptTnPersonService;
import xin.tianchuang.modules.spider.service.RptTnShareholdersService;

/**
 * 天眼查对外-公司背景接口
 * 
 * @author denghui
 *
 */
@Service
public class TycBackgroundFacadeImpl extends BaseFacadeImpl implements TycBackgroundFacade {

	@Autowired
	private RptTnBasicInfoService rptTnBasicInfoService;
	@Autowired
	private RptTnShareholdersService rptTnShareholdersService;
	@Autowired
	private RptTnPersonService rptTnPersonService;
	@Autowired
	private RptTnInvestService rptTnInvestService;
	@Autowired
	private RptTnChangeService rptTnChangeService;
	@Autowired
	private RptTnBranchesService rptTnBranchesService;
	@Autowired
	private EjbDozerGenerator ejbGenerator;

	@Override
	public RptTnBasicInfoDTO getGxstBaseInfo(String name, String creditCode) {
		RptTnBasicInfoDTO dto = new RptTnBasicInfoDTO();
		RptTnBasicInfoEntity entity = rptTnBasicInfoService.selectListByNameCode(name, creditCode);
		Assert.notNull(entity, "工商基本信息数据为空");
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public List<RptTnPersonDTO> getStaff(String name, String creditCode) {
		return ejbGenerator.convert(rptTnPersonService.selectListByNameCode(name, creditCode), RptTnPersonDTO.class);
	}

	@Override
	public List<RptTnShareholdersDTO> getHolder(String name, String creditCode) {
		return ejbGenerator.convert(rptTnShareholdersService.selectListByNameCode(name, creditCode), RptTnShareholdersDTO.class);
	}

	@Override
	public List<RptTnInvestDTO> getInvest(String name, String creditCode) {
		return ejbGenerator.convert(rptTnInvestService.selectListByNameCode(name, creditCode), RptTnInvestDTO.class);
	}

	@Override
	public List<RptTnChangeDTO> getChange(String name, String creditCode) {
		return ejbGenerator.convert(rptTnChangeService.selectListByNameCode(name, creditCode), RptTnChangeDTO.class);
	}

	@Override
	public List<RptTnBranchesDTO> getBranch(String name, String creditCode) {
		return ejbGenerator.convert(rptTnBranchesService.selectListByNameCode(name, creditCode), RptTnBranchesDTO.class);
	}

}
