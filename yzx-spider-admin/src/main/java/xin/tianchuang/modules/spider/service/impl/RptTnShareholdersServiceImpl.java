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
import xin.tianchuang.modules.spider.dao.RptTnShareholdersDao;
import xin.tianchuang.modules.spider.entity.RptTnShareholdersEntity;
import xin.tianchuang.modules.spider.service.RptTnShareholdersService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnShareholdersService")
public class RptTnShareholdersServiceImpl extends ServiceImpl<RptTnShareholdersDao, RptTnShareholdersEntity> implements RptTnShareholdersService {
	private static final Logger logger = LoggerFactory.getLogger(RptTnShareholdersService.class);

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnShareholdersEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnShareholdersEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.delete(ew);
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String entName = (String) params.get("entName");
		String enterpriseId = (String) params.get("enterpriseId");
		String name = (String) params.get("name");
		Page<RptTnShareholdersEntity> page = this.selectPage(
				new Query<RptTnShareholdersEntity>(params).getPage(),
				new EntityWrapper<RptTnShareholdersEntity>().like(StringUtils.isNotBlank(entName), "ent_name", entName).and(StringUtils.isNotBlank(name), "name", name)
						.eq(StringUtils.isNotBlank(enterpriseId), "enterprise_id", enterpriseId).orderBy("create_time", false));

		return new PageUtils(page);
	}

	@Override
	public List<RptTnShareholdersEntity> selectListByNameCode(String name, String creditCode) {
		EntityWrapper<RptTnShareholdersEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnShareholdersEntity());
		ew.eq("ent_name", name);
		ew.eq("data_state", TysDataStateEnum.FINISH.key());
		logger.info(ew.getSqlSegment());
		return this.baseMapper.selectList(ew);
	}

	@Override
	public RptTnShareholdersEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnShareholdersEntity entity = new RptTnShareholdersEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnShareholdersEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnShareholdersEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}

}
