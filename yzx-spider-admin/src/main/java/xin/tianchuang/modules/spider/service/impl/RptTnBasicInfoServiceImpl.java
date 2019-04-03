package xin.tianchuang.modules.spider.service.impl;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.TysDataStateEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptTnBasicInfoDao;
import xin.tianchuang.modules.spider.entity.RptTnBasicInfoEntity;
import xin.tianchuang.modules.spider.service.RptTnBasicInfoService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnBasicInfoService")
public class RptTnBasicInfoServiceImpl extends ServiceImpl<RptTnBasicInfoDao, RptTnBasicInfoEntity> implements RptTnBasicInfoService {

	private static final Logger logger = LoggerFactory.getLogger(RptTnBasicInfoService.class);

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String entName = (String) params.get("entName");
		String enterpriseId = (String) params.get("enterpriseId");
		String creditCode = (String) params.get("creCode");
		String regNo = (String) params.get("regNo");
		String orgNo = (String) params.get("orgCode");
		String ideNum = (String) params.get("ideNum");
		EntityWrapper<RptTnBasicInfoEntity> ew = new EntityWrapper<RptTnBasicInfoEntity>();
		Page<RptTnBasicInfoEntity> page = this.selectPage(new Query<RptTnBasicInfoEntity>(params).getPage(), ew.like(StringUtils.isNotBlank(entName), "ent_name", entName) //
				.eq(StringUtils.isNotBlank(creditCode), "cre_code", creditCode) //
				.eq(StringUtils.isNotBlank(regNo), "reg_no", regNo) //
				.eq(StringUtils.isNotBlank(orgNo), "org_code", orgNo) //
				.eq(StringUtils.isNotBlank(ideNum), "ide_num", ideNum) //
				.eq(StringUtils.isNotBlank(enterpriseId), "enterprise_id", enterpriseId).orderBy("create_time", false));

		return new PageUtils(page);
	}

	@Override
	public RptTnBasicInfoEntity selectByEnterpriseNameAndRegNo(String enterpriseName, String regNo) {
		RptTnBasicInfoEntity entity = new RptTnBasicInfoEntity();
		entity.setEntName(enterpriseName);
		entity.setRegNo(regNo);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public int countByEnterpriseNameAndRegNo(String enterpriseName, String regNo) {
		EntityWrapper<RptTnBasicInfoEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnBasicInfoEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", enterpriseName).and().eq("reg_no", regNo);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.selectCount(ew);
	}

	@Override
	public RptTnBasicInfoEntity selectListByNameCode(String name, String creditCode) {
		RptTnBasicInfoEntity ew = new RptTnBasicInfoEntity();
		ew.setEntName(name);
		ew.setDataState(TysDataStateEnum.FINISH.key());
		return this.baseMapper.selectOne(ew);
	}

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnBasicInfoEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnBasicInfoEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.delete(ew);
	}

	@Override
	public RptTnBasicInfoEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnBasicInfoEntity entity = new RptTnBasicInfoEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnBasicInfoEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnBasicInfoEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}

}
