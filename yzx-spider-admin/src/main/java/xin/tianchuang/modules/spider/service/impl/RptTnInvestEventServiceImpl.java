package xin.tianchuang.modules.spider.service.impl;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptTnInvestEventDao;
import xin.tianchuang.modules.spider.entity.RptTnInvestEventEntity;
import xin.tianchuang.modules.spider.service.RptTnInvestEventService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnInvestEventService")
public class RptTnInvestEventServiceImpl extends ServiceImpl<RptTnInvestEventDao, RptTnInvestEventEntity> implements RptTnInvestEventService {

	private static final Logger logger = LoggerFactory.getLogger(RptTnInvestEventService.class);

	@Override
	public PageUtils queryPage(Map<String, Object> params) {

		String entName = (String) params.get("entName");
		String enterpriseId = (String) params.get("enterpriseId");
		Page<RptTnInvestEventEntity> page = this.selectPage(
				new Query<RptTnInvestEventEntity>(params).getPage(),
				new EntityWrapper<RptTnInvestEventEntity>().like(StringUtils.isNotBlank(entName), "ent_name", entName).eq(StringUtils.isNotBlank(enterpriseId), "enterprise_id", enterpriseId)
						.orderBy("create_time", false));

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnInvestEventEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnInvestEventEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.delete(ew);
	}

	@Override
	public RptTnInvestEventEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnInvestEventEntity entity = new RptTnInvestEventEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnInvestEventEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnInvestEventEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}
}
