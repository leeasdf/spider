package xin.tianchuang.modules.spider.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptTnReportBaseDao;
import xin.tianchuang.modules.spider.entity.RptTnReportBaseEntity;
import xin.tianchuang.modules.spider.service.RptTnReportBaseService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnReportBaseService")
public class RptTnReportBaseServiceImpl extends ServiceImpl<RptTnReportBaseDao, RptTnReportBaseEntity> implements RptTnReportBaseService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<RptTnReportBaseEntity> page = this.selectPage(new Query<RptTnReportBaseEntity>(params).getPage(), new EntityWrapper<RptTnReportBaseEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnReportBaseEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnReportBaseEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		return this.baseMapper.delete(ew);
	}

	@Override
	public RptTnReportBaseEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnReportBaseEntity entity = new RptTnReportBaseEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnReportBaseEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnReportBaseEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}
}
