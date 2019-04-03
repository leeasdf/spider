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
import xin.tianchuang.modules.spider.dao.RptTnOwingTaxDao;
import xin.tianchuang.modules.spider.entity.RptTnOwingTaxEntity;
import xin.tianchuang.modules.spider.service.RptTnOwingTaxService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnOwingTaxService")
public class RptTnOwingTaxServiceImpl extends ServiceImpl<RptTnOwingTaxDao, RptTnOwingTaxEntity> implements RptTnOwingTaxService {
	private static final Logger logger = LoggerFactory.getLogger(RptTnOwingTaxService.class);

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnOwingTaxEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnOwingTaxEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.delete(ew);
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String entName = (String) params.get("entName");
		String enterpriseId = (String) params.get("enterpriseId");
		Page<RptTnOwingTaxEntity> page = this.selectPage(
				new Query<RptTnOwingTaxEntity>(params).getPage(),
				new EntityWrapper<RptTnOwingTaxEntity>().like(StringUtils.isNotBlank(entName), "ent_name", entName).eq(StringUtils.isNotBlank(enterpriseId), "enterprise_id", enterpriseId)
						.orderBy("create_time", false));

		return new PageUtils(page);
	}

	@Override
	public List<RptTnOwingTaxEntity> selectListByNameCode(String name, String creditCode) {
		EntityWrapper<RptTnOwingTaxEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnOwingTaxEntity());
		ew.eq("ent_name", name);
		ew.eq("data_state", TysDataStateEnum.FINISH.key());
		logger.info(ew.getSqlSegment());
		return this.baseMapper.selectList(ew);
	}

	@Override
	public RptTnOwingTaxEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnOwingTaxEntity entity = new RptTnOwingTaxEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnOwingTaxEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnOwingTaxEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}

}
