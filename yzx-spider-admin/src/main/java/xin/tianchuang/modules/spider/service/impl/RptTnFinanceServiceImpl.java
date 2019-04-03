package xin.tianchuang.modules.spider.service.impl;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptTnFinanceDao;
import xin.tianchuang.modules.spider.entity.RptTnFinanceEntity;
import xin.tianchuang.modules.spider.service.RptTnFinanceService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnFinanceService")
public class RptTnFinanceServiceImpl extends ServiceImpl<RptTnFinanceDao, RptTnFinanceEntity> implements RptTnFinanceService {

	private static final Logger logger = LoggerFactory.getLogger(RptTnFinanceService.class);

	@Override
	public PageUtils queryPage(Map<String, Object> params) {

		String entName = (String) params.get("entName");
		String enterpriseId = (String) params.get("enterpriseId");
		Page<RptTnFinanceEntity> page = this.selectPage(
				new Query<RptTnFinanceEntity>(params).getPage(),
				new EntityWrapper<RptTnFinanceEntity>().like(StringUtils.isNotBlank(entName), "ent_name", entName).eq(StringUtils.isNotBlank(enterpriseId), "enterprise_id", enterpriseId)
						.orderBy("create_time", false));

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnFinanceEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnFinanceEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.delete(ew);
	}

	@Override
	public RptTnFinanceEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnFinanceEntity entity = new RptTnFinanceEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnFinanceEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnFinanceEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}
}
