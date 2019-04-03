package xin.tianchuang.modules.spider.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptTnReportWebsiteDao;
import xin.tianchuang.modules.spider.entity.RptTnReportWebsiteEntity;
import xin.tianchuang.modules.spider.service.RptTnReportWebsiteService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnReportWebsiteService")
public class RptTnReportWebsiteServiceImpl extends ServiceImpl<RptTnReportWebsiteDao, RptTnReportWebsiteEntity> implements RptTnReportWebsiteService {
	private static final Logger logger = LoggerFactory.getLogger(RptTnReportWebsiteService.class);

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<RptTnReportWebsiteEntity> page = this.selectPage(new Query<RptTnReportWebsiteEntity>(params).getPage(), new EntityWrapper<RptTnReportWebsiteEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnReportWebsiteEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnReportWebsiteEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.delete(ew);
	}

	@Override
	public RptTnReportWebsiteEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnReportWebsiteEntity entity = new RptTnReportWebsiteEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnReportWebsiteEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnReportWebsiteEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}
}
