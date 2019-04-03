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
import xin.tianchuang.modules.spider.dao.RptTnAbnormalDao;
import xin.tianchuang.modules.spider.entity.RptTnAbnormalEntity;
import xin.tianchuang.modules.spider.service.RptTnAbnormalService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnAbnormalService")
public class RptTnAbnormalServiceImpl extends ServiceImpl<RptTnAbnormalDao, RptTnAbnormalEntity> implements RptTnAbnormalService {
	private static final Logger logger = LoggerFactory.getLogger(RptTnAbnormalService.class);

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String entName = (String) params.get("entName");
		String enterpriseId = (String) params.get("enterpriseId");
		Page<RptTnAbnormalEntity> page = this.selectPage(
				new Query<RptTnAbnormalEntity>(params).getPage(),
				new EntityWrapper<RptTnAbnormalEntity>().like(StringUtils.isNotBlank(entName), "ent_name", entName).eq(StringUtils.isNotBlank(enterpriseId), "enterprise_id", enterpriseId)
						.orderBy("create_time", false));

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnAbnormalEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnAbnormalEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.delete(ew);
	}

	@Override
	public List<RptTnAbnormalEntity> selectListByNameCode(String name, String creditCode) {
		EntityWrapper<RptTnAbnormalEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnAbnormalEntity());
		ew.eq("ent_name", name);
		ew.eq("data_state", TysDataStateEnum.FINISH.key());
		logger.info(ew.getSqlSegment());
		return this.baseMapper.selectList(ew);
	}

	@Override
	public RptTnAbnormalEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnAbnormalEntity entity = new RptTnAbnormalEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnAbnormalEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnAbnormalEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}
}
