package xin.tianchuang.modules.spider.service.impl;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptTnBondDao;
import xin.tianchuang.modules.spider.entity.RptTnBondEntity;
import xin.tianchuang.modules.spider.service.RptTnBidService;
import xin.tianchuang.modules.spider.service.RptTnBondService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnBondService")
public class RptTnBondServiceImpl extends ServiceImpl<RptTnBondDao, RptTnBondEntity> implements RptTnBondService {
	private static final Logger logger = LoggerFactory.getLogger(RptTnBidService.class);

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnBondEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnBondEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.delete(ew);
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String entName = (String) params.get("entName");
		String bondName = (String) params.get("bondName");
		String enterpriseId = (String) params.get("enterpriseId");
		Page<RptTnBondEntity> page = this.selectPage(
				new Query<RptTnBondEntity>(params).getPage(),
				new EntityWrapper<RptTnBondEntity>().like(StringUtils.isNotBlank(entName), "ent_name", entName) //
				.like(StringUtils.isNotBlank(bondName), "bond_name", bondName) //
				.eq(StringUtils.isNotBlank(enterpriseId), "enterprise_id", enterpriseId) //
						.orderBy("create_time", false));

		return new PageUtils(page);
	}

	@Override
	public RptTnBondEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnBondEntity entity = new RptTnBondEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnBondEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnBondEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}

}
