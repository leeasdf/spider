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
import xin.tianchuang.modules.spider.dao.RptTnInvestDao;
import xin.tianchuang.modules.spider.entity.RptTnInvestEntity;
import xin.tianchuang.modules.spider.service.RptTnInvestService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnInvestService")
public class RptTnInvestServiceImpl extends ServiceImpl<RptTnInvestDao, RptTnInvestEntity> implements RptTnInvestService {
	private static final Logger logger = LoggerFactory.getLogger(RptTnInvestService.class);

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnInvestEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnInvestEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.delete(ew);
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String entName = (String) params.get("entName");
		String enterpriseId = (String) params.get("enterpriseId");
		Page<RptTnInvestEntity> page = this.selectPage(new Query<RptTnInvestEntity>(params).getPage(), new EntityWrapper<RptTnInvestEntity>()
				.like(StringUtils.isNotBlank(entName), "ent_name", entName).eq(StringUtils.isNotBlank(enterpriseId), "enterprise_id", enterpriseId).orderBy("create_time", false));

		return new PageUtils(page);
	}

	@Override
	public List<RptTnInvestEntity> selectListByNameCode(String name, String creditCode) {
		EntityWrapper<RptTnInvestEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnInvestEntity());
		ew.eq("ent_name", name);
		ew.eq("data_state", TysDataStateEnum.FINISH.key());
		logger.info(ew.getSqlSegment());
		return this.baseMapper.selectList(ew);
	}

	@Override
	public RptTnInvestEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnInvestEntity entity = new RptTnInvestEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnInvestEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnInvestEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}

}
