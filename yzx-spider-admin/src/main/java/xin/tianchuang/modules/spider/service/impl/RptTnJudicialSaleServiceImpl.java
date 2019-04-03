package xin.tianchuang.modules.spider.service.impl;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptTnJudicialSaleDao;
import xin.tianchuang.modules.spider.entity.RptTnJudicialSaleEntity;
import xin.tianchuang.modules.spider.service.RptTnJudicialSaleService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnJudicialSaleService")
public class RptTnJudicialSaleServiceImpl extends ServiceImpl<RptTnJudicialSaleDao, RptTnJudicialSaleEntity> implements RptTnJudicialSaleService {

	private static final Logger logger = LoggerFactory.getLogger(RptTnJudicialSaleService.class);

	@Override
	public PageUtils queryPage(Map<String, Object> params) {

		String entName = (String) params.get("entName");
		String enterpriseId = (String) params.get("enterpriseId");
		Page<RptTnJudicialSaleEntity> page = this.selectPage(
				new Query<RptTnJudicialSaleEntity>(params).getPage(),
				new EntityWrapper<RptTnJudicialSaleEntity>().like(StringUtils.isNotBlank(entName), "ent_name", entName).eq(StringUtils.isNotBlank(enterpriseId), "enterprise_id", enterpriseId)
						.orderBy("create_time", false));
		
		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnJudicialSaleEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnJudicialSaleEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.delete(ew);
	}

	@Override
	public RptTnJudicialSaleEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnJudicialSaleEntity entity = new RptTnJudicialSaleEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnJudicialSaleEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnJudicialSaleEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}
}
