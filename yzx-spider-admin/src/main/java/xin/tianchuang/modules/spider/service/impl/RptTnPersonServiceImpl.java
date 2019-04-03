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
import xin.tianchuang.modules.spider.dao.RptTnPersonDao;
import xin.tianchuang.modules.spider.entity.RptTnPersonEntity;
import xin.tianchuang.modules.spider.service.RptTnPersonService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnPersonService")
public class RptTnPersonServiceImpl extends ServiceImpl<RptTnPersonDao, RptTnPersonEntity> implements RptTnPersonService {
	private static final Logger logger = LoggerFactory.getLogger(RptTnPersonService.class);

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnPersonEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnPersonEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.delete(ew);
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String entName = (String) params.get("entName");
		String enterpriseId = (String) params.get("enterpriseId");
		String name = (String) params.get("name");
		Page<RptTnPersonEntity> page = this.selectPage(new Query<RptTnPersonEntity>(params).getPage(), new EntityWrapper<RptTnPersonEntity>()
				.like(StringUtils.isNotBlank(entName), "ent_name", entName).and(StringUtils.isNotBlank(name), "name", name).eq(StringUtils.isNotBlank(enterpriseId), "enterprise_id", enterpriseId)
				.orderBy("create_time", false));

		return new PageUtils(page);
	}

	@Override
	public List<RptTnPersonEntity> selectListByNameCode(String name, String creditCode) {
		EntityWrapper<RptTnPersonEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnPersonEntity());
		ew.eq("ent_name", name);
		ew.eq("data_state", TysDataStateEnum.FINISH.key());
		logger.info(ew.getSqlSegment());
		return this.baseMapper.selectList(ew);
	}

	@Override
	public RptTnPersonEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnPersonEntity entity = new RptTnPersonEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnPersonEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnPersonEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}

}
