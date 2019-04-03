package xin.tianchuang.modules.spider.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptTnReportShareholderDao;
import xin.tianchuang.modules.spider.entity.RptTnReportShareholderEntity;
import xin.tianchuang.modules.spider.service.RptTnReportShareholderService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnReportShareholderService")
public class RptTnReportShareholderServiceImpl extends ServiceImpl<RptTnReportShareholderDao, RptTnReportShareholderEntity> implements RptTnReportShareholderService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<RptTnReportShareholderEntity> page = this.selectPage(new Query<RptTnReportShareholderEntity>(params).getPage(), new EntityWrapper<RptTnReportShareholderEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnReportShareholderEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnReportShareholderEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		return this.baseMapper.delete(ew);
	}

	@Override
	public RptTnReportShareholderEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnReportShareholderEntity entity = new RptTnReportShareholderEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnReportShareholderEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnReportShareholderEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}
}