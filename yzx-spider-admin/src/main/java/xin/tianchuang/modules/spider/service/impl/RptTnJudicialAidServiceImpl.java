package xin.tianchuang.modules.spider.service.impl;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptTnJudicialAidDao;
import xin.tianchuang.modules.spider.entity.RptTnJudicialAidEntity;
import xin.tianchuang.modules.spider.service.RptTnJudicialAidService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnJudicialAidService")
public class RptTnJudicialAidServiceImpl extends ServiceImpl<RptTnJudicialAidDao, RptTnJudicialAidEntity> implements RptTnJudicialAidService {
	private static final Logger logger = LoggerFactory.getLogger(RptTnJudicialAidService.class);

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String entName = (String) params.get("entName");
		String enterpriseId = (String) params.get("enterpriseId");
		Page<RptTnJudicialAidEntity> page = this.selectPage(
				new Query<RptTnJudicialAidEntity>(params).getPage(),
				new EntityWrapper<RptTnJudicialAidEntity>().like(StringUtils.isNotBlank(entName), "ent_name", entName).eq(StringUtils.isNotBlank(enterpriseId), "enterprise_id", enterpriseId)
						.orderBy("create_time", false));

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnJudicialAidEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnJudicialAidEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.delete(ew);
	}

	@Override
	public RptTnJudicialAidEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnJudicialAidEntity entity = new RptTnJudicialAidEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnJudicialAidEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnJudicialAidEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}

}
