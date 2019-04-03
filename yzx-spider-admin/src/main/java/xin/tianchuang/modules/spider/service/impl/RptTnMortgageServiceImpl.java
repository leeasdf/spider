package xin.tianchuang.modules.spider.service.impl;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptTnMortgageDao;
import xin.tianchuang.modules.spider.entity.RptTnMortgageEntity;
import xin.tianchuang.modules.spider.service.RptTnBidService;
import xin.tianchuang.modules.spider.service.RptTnMortgageService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnMortgageService")
public class RptTnMortgageServiceImpl extends ServiceImpl<RptTnMortgageDao, RptTnMortgageEntity> implements RptTnMortgageService {
	private static final Logger logger = LoggerFactory.getLogger(RptTnBidService.class);

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnMortgageEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnMortgageEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.delete(ew);
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String entName = (String) params.get("entName");
		String enterpriseId = (String) params.get("enterpriseId");
		Page<RptTnMortgageEntity> page = this.selectPage(
				new Query<RptTnMortgageEntity>(params).getPage(),
				new EntityWrapper<RptTnMortgageEntity>().like(StringUtils.isNotBlank(entName), "ent_name", entName).eq(StringUtils.isNotBlank(enterpriseId), "enterprise_id", enterpriseId)
						.orderBy("create_time", false));

		return new PageUtils(page);
	}

	@Override
	public RptTnMortgageEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnMortgageEntity entity = new RptTnMortgageEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnMortgageEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnMortgageEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}

}
