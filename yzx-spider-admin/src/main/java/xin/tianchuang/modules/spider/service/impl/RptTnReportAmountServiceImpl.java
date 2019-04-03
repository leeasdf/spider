package xin.tianchuang.modules.spider.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptTnReportAmountDao;
import xin.tianchuang.modules.spider.entity.RptTnReportAmountEntity;
import xin.tianchuang.modules.spider.service.RptTnReportAmountService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnReportAmountService")
public class RptTnReportAmountServiceImpl extends ServiceImpl<RptTnReportAmountDao, RptTnReportAmountEntity> implements RptTnReportAmountService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<RptTnReportAmountEntity> page = this.selectPage(new Query<RptTnReportAmountEntity>(params).getPage(), new EntityWrapper<RptTnReportAmountEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnReportAmountEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnReportAmountEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		return this.baseMapper.delete(ew);
	}

	@Override
	public RptTnReportAmountEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnReportAmountEntity entity = new RptTnReportAmountEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnReportAmountEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnReportAmountEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}

}