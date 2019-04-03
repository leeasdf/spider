package xin.tianchuang.modules.spider.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptTnReportDao;
import xin.tianchuang.modules.spider.entity.RptTnReportEntity;
import xin.tianchuang.modules.spider.service.RptTnBidService;
import xin.tianchuang.modules.spider.service.RptTnReportService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnReportService")
public class RptTnReportServiceImpl extends ServiceImpl<RptTnReportDao, RptTnReportEntity> implements RptTnReportService {

	private static final Logger logger = LoggerFactory.getLogger(RptTnBidService.class);
	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<RptTnReportEntity> page = this.selectPage(new Query<RptTnReportEntity>(params).getPage(), new EntityWrapper<RptTnReportEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnReportEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnReportEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.delete(ew);
	}

	@Override
	public RptTnReportEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnReportEntity entity = new RptTnReportEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnReportEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnReportEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}

}
