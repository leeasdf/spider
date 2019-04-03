package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.TysDataStateEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptTnSoftwareRightDao;
import xin.tianchuang.modules.spider.entity.RptTnSoftwareRightEntity;
import xin.tianchuang.modules.spider.service.RptTnSoftwareRightService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnSoftwareRightService")
public class RptTnSoftwareRightServiceImpl extends ServiceImpl<RptTnSoftwareRightDao, RptTnSoftwareRightEntity> implements RptTnSoftwareRightService {
	private static final Logger logger = LoggerFactory.getLogger(RptTnSoftwareRightService.class);

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnSoftwareRightEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnSoftwareRightEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.delete(ew);
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String entName = (String) params.get("entName");
		String enterpriseId = (String) params.get("enterpriseId");
		Page<RptTnSoftwareRightEntity> page = this.selectPage(new Query<RptTnSoftwareRightEntity>(params).getPage(),
				new EntityWrapper<RptTnSoftwareRightEntity>().like(StringUtils.isNotBlank(entName), "ent_name", entName).eq(StringUtils.isNotBlank(enterpriseId), "enterprise_id", enterpriseId)
						.orderBy("create_time", false));

		return new PageUtils(page);
	}

	@Override
	public List<RptTnSoftwareRightEntity> selectListByNameCode(String name, String creditCode) {
		EntityWrapper<RptTnSoftwareRightEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnSoftwareRightEntity());
		ew.eq("ent_name", name);
		ew.eq("data_state", TysDataStateEnum.FINISH.key());
		logger.info(ew.getSqlSegment());
		return this.baseMapper.selectList(ew);
	}

	@Override
	public RptTnSoftwareRightEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnSoftwareRightEntity entity = new RptTnSoftwareRightEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnSoftwareRightEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnSoftwareRightEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}
}
