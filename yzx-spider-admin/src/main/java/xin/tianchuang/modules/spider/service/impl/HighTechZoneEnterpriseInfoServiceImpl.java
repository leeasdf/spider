package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.HighTechZoneEnterpriseInfoDao;
import xin.tianchuang.modules.spider.entity.HighTechZoneEnterpriseInfoEntity;
import xin.tianchuang.modules.spider.service.HighTechZoneEnterpriseInfoService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("highTechZoneEnterpriseInfoService")
public class HighTechZoneEnterpriseInfoServiceImpl extends ServiceImpl<HighTechZoneEnterpriseInfoDao, HighTechZoneEnterpriseInfoEntity> implements HighTechZoneEnterpriseInfoService {

	private static final Logger logger = LoggerFactory.getLogger(HighTechZoneEnterpriseInfoService.class);
	@Autowired
	private HighTechZoneEnterpriseInfoDao mapper;

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String enterpriseName = (String) params.get("enterpriseName");
		Page<HighTechZoneEnterpriseInfoEntity> page = this.selectPage(new Query<HighTechZoneEnterpriseInfoEntity>(params).getPage(), new EntityWrapper<HighTechZoneEnterpriseInfoEntity>() //
				.like(StringUtils.isNotBlank(enterpriseName), "enterprise_name", enterpriseName)//
				.orderBy("createtime", false) //
				);

		return new PageUtils(page);
	}

	@Override
	public List<HighTechZoneEnterpriseInfoEntity> querEnterpriseListByCondition(Integer fetch, Integer status, String province, String city, String remark, Boolean isAsc) {
		EntityWrapper<HighTechZoneEnterpriseInfoEntity> ew = new EntityWrapper<>();
		ew.setEntity(new HighTechZoneEnterpriseInfoEntity());
		ew.eq("data_state", status);

		if (StringUtils.isNotBlank(province)) {
			ew.and().eq("province", province);
		}

		if (StringUtils.isNotBlank(city)) {
			ew.and().eq("city", city);
		}

		if (StringUtils.isNotBlank(remark)) {
			ew.and().eq("remark", remark);
		}

		if (isAsc) {
			ew.orderBy("createtime", true);
		} else {
			ew.orderBy("createtime", false);
		}

		if (fetch > 0) {
			ew.last("LIMIT " + fetch);
		}

		logger.info(ew.getSqlSegment());
		return mapper.selectList(ew);
	}

	@Override
	public HighTechZoneEnterpriseInfoEntity selectByEnterpriseName(String enterpriseName) {
		HighTechZoneEnterpriseInfoEntity entity = new HighTechZoneEnterpriseInfoEntity();
		entity.setEnterpriseName(enterpriseName);
		return mapper.selectOne(entity);
	}

	@Override
	public HighTechZoneEnterpriseInfoEntity selectByNameCode(String enterpriseName, String creditCode) {
		HighTechZoneEnterpriseInfoEntity entity = new HighTechZoneEnterpriseInfoEntity();
		if (StringUtils.isNotBlank(enterpriseName)) {
			entity.setEnterpriseName(enterpriseName);
		}
		if (StringUtils.isNotBlank(creditCode)) {
			entity.setCreditCode(creditCode);
		}
		return mapper.selectOne(entity);
	}

	@Override
	public PageUtils queryMatchPage(Map<String, Object> params) {
		String key = (String) params.get("key");
		String sqlSelect = " MATCH(`enterprise_name`) AGAINST( '*" + key + "*' IN BOOLEAN MODE) ";
		Page<HighTechZoneEnterpriseInfoEntity> page = this.selectPage(new Query<HighTechZoneEnterpriseInfoEntity>(params).getPage(), new EntityWrapper<HighTechZoneEnterpriseInfoEntity>() //
				.and(sqlSelect).orderBy("createtime", false) //
				);

		return new PageUtils(page);
	}

	@Override
	public long selectMaxId() {
		return mapper.selectMaxId();
	}

}
