package xin.tianchuang.modules.spider.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptTnCompetitiveDao;
import xin.tianchuang.modules.spider.entity.RptTnCompetitiveEntity;
import xin.tianchuang.modules.spider.service.RptTnCompetitiveService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnCompetitiveService")
public class RptTnCompetitiveServiceImpl extends ServiceImpl<RptTnCompetitiveDao, RptTnCompetitiveEntity> implements RptTnCompetitiveService {

	private static final Logger logger = LoggerFactory.getLogger(RptTnCompetitiveService.class);

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<RptTnCompetitiveEntity> page = this.selectPage(new Query<RptTnCompetitiveEntity>(params).getPage(), new EntityWrapper<RptTnCompetitiveEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnCompetitiveEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnCompetitiveEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.delete(ew);
	}

	@Override
	public RptTnCompetitiveEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnCompetitiveEntity entity = new RptTnCompetitiveEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnCompetitiveEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnCompetitiveEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}
}
