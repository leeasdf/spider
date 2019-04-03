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
import xin.tianchuang.modules.spider.dao.RptTnChangeDao;
import xin.tianchuang.modules.spider.entity.RptTnChangeEntity;
import xin.tianchuang.modules.spider.service.RptTnChangeService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnChangeService")
public class RptTnChangeServiceImpl extends ServiceImpl<RptTnChangeDao, RptTnChangeEntity> implements RptTnChangeService {

	private static final Logger logger = LoggerFactory.getLogger(RptTnChangeService.class);

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String entName = (String) params.get("name");
		String enterpriseId = (String) params.get("enterpriseId");
		Page<RptTnChangeEntity> page = this.selectPage(new Query<RptTnChangeEntity>(params).getPage(), new EntityWrapper<RptTnChangeEntity>() //
				.like(StringUtils.isNotBlank(entName), "name", entName) //
				.eq(StringUtils.isNotBlank(enterpriseId), "enterprise_id", enterpriseId) //
				.orderBy("create_time", false) //
				);

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnChangeEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnChangeEntity());
		ew.where("1=1").and();
		ew.eq("name", entName);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.delete(ew);
	}

	@Override
	public List<RptTnChangeEntity> selectListByNameCode(String name, String creditCode) {
		EntityWrapper<RptTnChangeEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnChangeEntity());
		ew.eq("name", name);
		ew.eq("data_state", TysDataStateEnum.FINISH.key());
		logger.info(ew.getSqlSegment());
		return this.baseMapper.selectList(ew);
	}

	@Override
	public RptTnChangeEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnChangeEntity entity = new RptTnChangeEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnChangeEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnChangeEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}
}
