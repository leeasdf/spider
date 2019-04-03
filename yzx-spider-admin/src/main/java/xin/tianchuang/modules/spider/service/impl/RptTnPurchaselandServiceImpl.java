package xin.tianchuang.modules.spider.service.impl;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptTnPurchaselandDao;
import xin.tianchuang.modules.spider.entity.RptTnPurchaselandEntity;
import xin.tianchuang.modules.spider.service.RptTnPurchaselandService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnPurchaselandService")
public class RptTnPurchaselandServiceImpl extends ServiceImpl<RptTnPurchaselandDao, RptTnPurchaselandEntity> implements RptTnPurchaselandService {
	private static final Logger logger = LoggerFactory.getLogger(RptTnPurchaselandService.class);

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnPurchaselandEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnPurchaselandEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.delete(ew);
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String entName = (String) params.get("entName");
		String enterpriseId = (String) params.get("enterpriseId");
		Page<RptTnPurchaselandEntity> page = this.selectPage(new Query<RptTnPurchaselandEntity>(params).getPage(),
				new EntityWrapper<RptTnPurchaselandEntity>().like(StringUtils.isNotBlank(entName), "ent_name", entName).eq(StringUtils.isNotBlank(enterpriseId), "enterprise_id", enterpriseId)
						.orderBy("create_time", false));

		return new PageUtils(page);
	}

	@Override
	public RptTnPurchaselandEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnPurchaselandEntity entity = new RptTnPurchaselandEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnPurchaselandEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnPurchaselandEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}

}
