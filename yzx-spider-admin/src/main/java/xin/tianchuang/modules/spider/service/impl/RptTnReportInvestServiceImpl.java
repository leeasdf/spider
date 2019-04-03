package xin.tianchuang.modules.spider.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptTnReportInvestDao;
import xin.tianchuang.modules.spider.entity.RptTnReportInvestEntity;
import xin.tianchuang.modules.spider.service.RptTnReportInvestService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnReportInvestService")
public class RptTnReportInvestServiceImpl extends ServiceImpl<RptTnReportInvestDao, RptTnReportInvestEntity> implements RptTnReportInvestService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<RptTnReportInvestEntity> page = this.selectPage(new Query<RptTnReportInvestEntity>(params).getPage(), new EntityWrapper<RptTnReportInvestEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnReportInvestEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnReportInvestEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		return this.baseMapper.delete(ew);
	}

	@Override
	public RptTnReportInvestEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnReportInvestEntity entity = new RptTnReportInvestEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnReportInvestEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnReportInvestEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}
}
