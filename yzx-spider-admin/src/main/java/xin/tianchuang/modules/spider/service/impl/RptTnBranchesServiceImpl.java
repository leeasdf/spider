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
import xin.tianchuang.modules.spider.dao.RptTnBranchesDao;
import xin.tianchuang.modules.spider.entity.RptTnBranchesEntity;
import xin.tianchuang.modules.spider.service.RptTnBranchesService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnBranchesService")
public class RptTnBranchesServiceImpl extends ServiceImpl<RptTnBranchesDao, RptTnBranchesEntity> implements RptTnBranchesService {

	private static final Logger logger = LoggerFactory.getLogger(RptTnBranchesService.class);

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String entName = (String) params.get("entName");
		String enterpriseId = (String) params.get("enterpriseId");
		String legalPerson = (String) params.get("legal_person");
		String cmpName = (String) params.get("cmp_name");
		Page<RptTnBranchesEntity> page = this.selectPage(
				new Query<RptTnBranchesEntity>(params).getPage(),
				new EntityWrapper<RptTnBranchesEntity>().like(StringUtils.isNotBlank(entName), "ent_name", entName).and(StringUtils.isNotBlank(legalPerson), "legal_person", legalPerson)
						.and(StringUtils.isNotBlank(cmpName), "cmp_name", cmpName).eq(StringUtils.isNotBlank(enterpriseId), "enterprise_id", enterpriseId).orderBy("create_time", false));

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnBranchesEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnBranchesEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.delete(ew);
	}

	@Override
	public List<RptTnBranchesEntity> selectListByNameCode(String name, String creditCode) {
		EntityWrapper<RptTnBranchesEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnBranchesEntity());
		ew.eq("ent_name", name);
		ew.eq("data_state", TysDataStateEnum.FINISH.key());
		logger.info(ew.getSqlSegment());
		return this.baseMapper.selectList(ew);
	}

	@Override
	public RptTnBranchesEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnBranchesEntity entity = new RptTnBranchesEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnBranchesEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnBranchesEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}
}
