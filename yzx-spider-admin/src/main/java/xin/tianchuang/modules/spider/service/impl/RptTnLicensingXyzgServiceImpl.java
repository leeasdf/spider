package xin.tianchuang.modules.spider.service.impl;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptTnLicensingXyzgDao;
import xin.tianchuang.modules.spider.entity.RptTnLicensingXyzgEntity;
import xin.tianchuang.modules.spider.service.RptTnBidService;
import xin.tianchuang.modules.spider.service.RptTnLicensingXyzgService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnLicensingXyzgService")
public class RptTnLicensingXyzgServiceImpl extends ServiceImpl<RptTnLicensingXyzgDao, RptTnLicensingXyzgEntity> implements RptTnLicensingXyzgService {
	private static final Logger logger = LoggerFactory.getLogger(RptTnBidService.class);

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnLicensingXyzgEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnLicensingXyzgEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.delete(ew);
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String entName = (String) params.get("entName");
		String enterpriseId = (String) params.get("enterpriseId");
		Page<RptTnLicensingXyzgEntity> page = this.selectPage(new Query<RptTnLicensingXyzgEntity>(params).getPage(),
				new EntityWrapper<RptTnLicensingXyzgEntity>().like(StringUtils.isNotBlank(entName), "ent_name", entName).eq(StringUtils.isNotBlank(enterpriseId), "enterprise_id", enterpriseId)
						.orderBy("create_time", false));

		return new PageUtils(page);
	}

	@Override
	public RptTnLicensingXyzgEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnLicensingXyzgEntity entity = new RptTnLicensingXyzgEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnLicensingXyzgEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnLicensingXyzgEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}

}