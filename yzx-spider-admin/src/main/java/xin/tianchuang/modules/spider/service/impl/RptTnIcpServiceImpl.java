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
import xin.tianchuang.modules.spider.dao.RptTnIcpDao;
import xin.tianchuang.modules.spider.entity.RptTnIcpEntity;
import xin.tianchuang.modules.spider.service.RptTnIcpService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnIcpService")
public class RptTnIcpServiceImpl extends ServiceImpl<RptTnIcpDao, RptTnIcpEntity> implements RptTnIcpService {

	private static final Logger logger = LoggerFactory.getLogger(RptTnIcpService.class);

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnIcpEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnIcpEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.delete(ew);
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String entName = (String) params.get("entName");
		String enterpriseId = (String) params.get("enterpriseId");
		Page<RptTnIcpEntity> page = this.selectPage(
				new Query<RptTnIcpEntity>(params).getPage(),
				new EntityWrapper<RptTnIcpEntity>().like(StringUtils.isNotBlank(entName), "ent_name", entName).eq(StringUtils.isNotBlank(enterpriseId), "enterprise_id", enterpriseId)
						.orderBy("create_time", false));

		return new PageUtils(page);
	}

	@Override
	public List<RptTnIcpEntity> selectListByNameCode(String name, String creditCode) {
		EntityWrapper<RptTnIcpEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnIcpEntity());
		ew.eq("ent_name", name);
		ew.eq("data_state", TysDataStateEnum.FINISH.key());
		logger.info(ew.getSqlSegment());
		return this.baseMapper.selectList(ew);
	}

	@Override
	public RptTnIcpEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnIcpEntity entity = new RptTnIcpEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnIcpEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnIcpEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}

}
