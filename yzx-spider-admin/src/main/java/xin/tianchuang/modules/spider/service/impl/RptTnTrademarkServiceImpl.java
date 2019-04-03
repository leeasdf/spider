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
import xin.tianchuang.modules.spider.dao.RptTnTrademarkDao;
import xin.tianchuang.modules.spider.entity.RptTnTrademarkEntity;
import xin.tianchuang.modules.spider.service.RptTnTrademarkService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnTrademarkService")
public class RptTnTrademarkServiceImpl extends ServiceImpl<RptTnTrademarkDao, RptTnTrademarkEntity> implements RptTnTrademarkService {
	private static final Logger logger = LoggerFactory.getLogger(RptTnTrademarkService.class);

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnTrademarkEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnTrademarkEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.delete(ew);
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String entName = (String) params.get("entName");
		String enterpriseId = (String) params.get("enterpriseId");
		Page<RptTnTrademarkEntity> page = this.selectPage(
				new Query<RptTnTrademarkEntity>(params).getPage(),
				new EntityWrapper<RptTnTrademarkEntity>().like(StringUtils.isNotBlank(entName), "ent_name", entName).eq(StringUtils.isNotBlank(enterpriseId), "enterprise_id", enterpriseId)
						.orderBy("create_time", false));

		return new PageUtils(page);
	}

	@Override
	public List<RptTnTrademarkEntity> selectListByNameCode(String name, String creditCode) {
		EntityWrapper<RptTnTrademarkEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnTrademarkEntity());
		ew.eq("ent_name", name);
		ew.eq("data_state", TysDataStateEnum.FINISH.key());
		logger.info(ew.getSqlSegment());
		return this.baseMapper.selectList(ew);
	}

	@Override
	public RptTnTrademarkEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnTrademarkEntity entity = new RptTnTrademarkEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnTrademarkEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnTrademarkEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}

}
