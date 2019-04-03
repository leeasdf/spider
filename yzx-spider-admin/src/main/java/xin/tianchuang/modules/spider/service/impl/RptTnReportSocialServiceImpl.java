package xin.tianchuang.modules.spider.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptTnReportSocialDao;
import xin.tianchuang.modules.spider.entity.RptTnReportSocialEntity;
import xin.tianchuang.modules.spider.service.RptTnReportSocialService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnReportSocialService")
public class RptTnReportSocialServiceImpl extends ServiceImpl<RptTnReportSocialDao, RptTnReportSocialEntity> implements RptTnReportSocialService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<RptTnReportSocialEntity> page = this.selectPage(new Query<RptTnReportSocialEntity>(params).getPage(), new EntityWrapper<RptTnReportSocialEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnReportSocialEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnReportSocialEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		return this.baseMapper.delete(ew);
	}

	@Override
	public RptTnReportSocialEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnReportSocialEntity entity = new RptTnReportSocialEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnReportSocialEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnReportSocialEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}
}
