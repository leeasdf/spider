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
import xin.tianchuang.modules.spider.dao.RptTnLawsuitDao;
import xin.tianchuang.modules.spider.entity.RptTnLawsuitEntity;
import xin.tianchuang.modules.spider.service.RptTnLawsuitService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnLawsuitService")
public class RptTnLawsuitServiceImpl extends ServiceImpl<RptTnLawsuitDao, RptTnLawsuitEntity> implements RptTnLawsuitService {
	private static final Logger logger = LoggerFactory.getLogger(RptTnLawsuitService.class);

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnLawsuitEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnLawsuitEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.delete(ew);
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String entName = (String) params.get("entName");
		String enterpriseId = (String) params.get("enterpriseId");
		Page<RptTnLawsuitEntity> page = this.selectPage(
				new Query<RptTnLawsuitEntity>(params).getPage(),
				new EntityWrapper<RptTnLawsuitEntity>().like(StringUtils.isNotBlank(entName), "ent_name", entName).eq(StringUtils.isNotBlank(enterpriseId), "enterprise_id", enterpriseId)
						.orderBy("create_time", false));

		return new PageUtils(page);
	}

	@Override
	public List<RptTnLawsuitEntity> selectListByNameCode(String name, String creditCode) {
		EntityWrapper<RptTnLawsuitEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnLawsuitEntity());
		ew.eq("ent_name", name);
		ew.eq("data_state", TysDataStateEnum.FINISH.key());
		logger.info(ew.getSqlSegment());
		return this.baseMapper.selectList(ew);
	}

	@Override
	public RptTnLawsuitEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnLawsuitEntity entity = new RptTnLawsuitEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnLawsuitEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnLawsuitEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}

}
