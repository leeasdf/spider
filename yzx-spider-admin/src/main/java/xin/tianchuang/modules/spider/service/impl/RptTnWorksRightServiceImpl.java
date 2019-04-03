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
import xin.tianchuang.modules.spider.dao.RptTnWorksRightDao;
import xin.tianchuang.modules.spider.entity.RptTnWorksRightEntity;
import xin.tianchuang.modules.spider.service.RptTnWorksRightService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnWorksRightService")
public class RptTnWorksRightServiceImpl extends ServiceImpl<RptTnWorksRightDao, RptTnWorksRightEntity> implements RptTnWorksRightService {
	private static final Logger logger = LoggerFactory.getLogger(RptTnWorksRightService.class);

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnWorksRightEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnWorksRightEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.delete(ew);
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String entName = (String) params.get("entName");
		String enterpriseId = (String) params.get("enterpriseId");
		Page<RptTnWorksRightEntity> page = this.selectPage(
				new Query<RptTnWorksRightEntity>(params).getPage(),
				new EntityWrapper<RptTnWorksRightEntity>().like(StringUtils.isNotBlank(entName), "ent_name", entName).eq(StringUtils.isNotBlank(enterpriseId), "enterprise_id", enterpriseId)
						.orderBy("create_time", false));

		return new PageUtils(page);
	}

	@Override
	public List<RptTnWorksRightEntity> selectListByNameCode(String name, String creditCode) {
		EntityWrapper<RptTnWorksRightEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnWorksRightEntity());
		ew.eq("ent_name", name);
		ew.eq("data_state", TysDataStateEnum.FINISH.key());
		logger.info(ew.getSqlSegment());
		return this.baseMapper.selectList(ew);
	}

	@Override
	public RptTnWorksRightEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnWorksRightEntity entity = new RptTnWorksRightEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnWorksRightEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnWorksRightEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}

}
