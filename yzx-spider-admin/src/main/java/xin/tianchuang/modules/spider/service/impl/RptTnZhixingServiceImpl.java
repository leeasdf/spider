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
import xin.tianchuang.modules.spider.dao.RptTnZhixingDao;
import xin.tianchuang.modules.spider.entity.RptTnZhixingEntity;
import xin.tianchuang.modules.spider.service.RptTnZhixingService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnZhixingService")
public class RptTnZhixingServiceImpl extends ServiceImpl<RptTnZhixingDao, RptTnZhixingEntity> implements RptTnZhixingService {
	private static final Logger logger = LoggerFactory.getLogger(RptTnZhixingService.class);

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnZhixingEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnZhixingEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.delete(ew);
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String entName = (String) params.get("entName");
		String enterpriseId = (String) params.get("enterpriseId");
		Page<RptTnZhixingEntity> page = this.selectPage(
				new Query<RptTnZhixingEntity>(params).getPage(),
				new EntityWrapper<RptTnZhixingEntity>().like(StringUtils.isNotBlank(entName), "ent_name", entName).eq(StringUtils.isNotBlank(enterpriseId), "enterprise_id", enterpriseId)
						.orderBy("create_time", false));

		return new PageUtils(page);
	}

	@Override
	public List<RptTnZhixingEntity> selectListByNameCode(String name, String creditCode) {
		EntityWrapper<RptTnZhixingEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnZhixingEntity());
		ew.eq("ent_name", name);
		ew.eq("data_state", TysDataStateEnum.FINISH.key());
		logger.info(ew.getSqlSegment());
		return this.baseMapper.selectList(ew);
	}

	@Override
	public RptTnZhixingEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnZhixingEntity entity = new RptTnZhixingEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnZhixingEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnZhixingEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}

}
