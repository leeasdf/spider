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
import xin.tianchuang.modules.spider.dao.RptTnIllegalDao;
import xin.tianchuang.modules.spider.entity.RptTnIllegalEntity;
import xin.tianchuang.modules.spider.service.RptTnIllegalService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnIllegalService")
public class RptTnIllegalServiceImpl extends ServiceImpl<RptTnIllegalDao, RptTnIllegalEntity> implements RptTnIllegalService {
	private static final Logger logger = LoggerFactory.getLogger(RptTnIllegalService.class);

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String entName = (String) params.get("entName");
		String enterpriseId = (String) params.get("enterpriseId");
		Page<RptTnIllegalEntity> page = this.selectPage(
				new Query<RptTnIllegalEntity>(params).getPage(),
				new EntityWrapper<RptTnIllegalEntity>() //
				.eq(StringUtils.isNotBlank(enterpriseId), "enterprise_id", enterpriseId) //
				.like(StringUtils.isNotBlank(entName), "ent_name", entName) //
						.orderBy("create_time", false));

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnIllegalEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnIllegalEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.delete(ew);
	}

	@Override
	public List<RptTnIllegalEntity> selectListByNameCode(String name, String creditCode) {
		EntityWrapper<RptTnIllegalEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnIllegalEntity());
		ew.eq("ent_name", name);
		ew.eq("data_state", TysDataStateEnum.FINISH.key());
		logger.info(ew.getSqlSegment());
		return this.baseMapper.selectList(ew);
	}

	@Override
	public RptTnIllegalEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnIllegalEntity entity = new RptTnIllegalEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnIllegalEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnIllegalEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}
}
