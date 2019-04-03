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
import xin.tianchuang.modules.spider.dao.RptTnPenaltiesDao;
import xin.tianchuang.modules.spider.entity.RptTnPenaltiesEntity;
import xin.tianchuang.modules.spider.service.RptTnPenaltiesService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnPenaltiesService")
public class RptTnPenaltiesServiceImpl extends ServiceImpl<RptTnPenaltiesDao, RptTnPenaltiesEntity> implements RptTnPenaltiesService {
	private static final Logger logger = LoggerFactory.getLogger(RptTnPenaltiesService.class);

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnPenaltiesEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnPenaltiesEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.delete(ew);
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String entName = (String) params.get("entName");
		String enterpriseId = (String) params.get("enterpriseId");
		Page<RptTnPenaltiesEntity> page = this.selectPage(
				new Query<RptTnPenaltiesEntity>(params).getPage(),
				new EntityWrapper<RptTnPenaltiesEntity>().like(StringUtils.isNotBlank(entName), "ent_name", entName).eq(StringUtils.isNotBlank(enterpriseId), "enterprise_id", enterpriseId)
						.orderBy("create_time", false));

		return new PageUtils(page);
	}

	@Override
	public List<RptTnPenaltiesEntity> selectListByNameCode(String name, String creditCode) {
		EntityWrapper<RptTnPenaltiesEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnPenaltiesEntity());
		ew.eq("ent_name", name);
		ew.eq("data_state", TysDataStateEnum.FINISH.key());
		logger.info(ew.getSqlSegment());
		return this.baseMapper.selectList(ew);
	}

	@Override
	public RptTnPenaltiesEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnPenaltiesEntity entity = new RptTnPenaltiesEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnPenaltiesEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnPenaltiesEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}

}
