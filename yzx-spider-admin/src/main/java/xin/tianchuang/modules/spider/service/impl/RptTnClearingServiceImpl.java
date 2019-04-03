package xin.tianchuang.modules.spider.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptTnClearingDao;
import xin.tianchuang.modules.spider.entity.RptTnClearingEntity;
import xin.tianchuang.modules.spider.service.RptTnClearingService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnClearingService")
public class RptTnClearingServiceImpl extends ServiceImpl<RptTnClearingDao, RptTnClearingEntity> implements RptTnClearingService {

	private static final Logger logger = LoggerFactory.getLogger(RptTnClearingService.class);

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<RptTnClearingEntity> page = this.selectPage(new Query<RptTnClearingEntity>(params).getPage(), new EntityWrapper<RptTnClearingEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnClearingEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnClearingEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.delete(ew);
	}

	@Override
	public RptTnClearingEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnClearingEntity entity = new RptTnClearingEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnClearingEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnClearingEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}
}
