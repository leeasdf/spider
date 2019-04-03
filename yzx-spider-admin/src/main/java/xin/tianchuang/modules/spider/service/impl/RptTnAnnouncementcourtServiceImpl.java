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
import xin.tianchuang.modules.spider.dao.RptTnAnnouncementcourtDao;
import xin.tianchuang.modules.spider.entity.RptTnAnnouncementcourtEntity;
import xin.tianchuang.modules.spider.service.RptTnAnnouncementcourtService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnAnnouncementcourtService")
public class RptTnAnnouncementcourtServiceImpl extends ServiceImpl<RptTnAnnouncementcourtDao, RptTnAnnouncementcourtEntity> implements RptTnAnnouncementcourtService {

	private static final Logger logger = LoggerFactory.getLogger(RptTnAnnouncementcourtService.class);

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String entName = (String) params.get("entName");
		String enterpriseId = (String) params.get("enterpriseId");
		Page<RptTnAnnouncementcourtEntity> page = this.selectPage(new Query<RptTnAnnouncementcourtEntity>(params).getPage(),
				new EntityWrapper<RptTnAnnouncementcourtEntity>().like(StringUtils.isNotBlank(entName), "ent_name", entName).eq(StringUtils.isNotBlank(enterpriseId), "enterprise_id", enterpriseId)
						.orderBy("create_time", false));

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnAnnouncementcourtEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnAnnouncementcourtEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.delete(ew);
	}

	@Override
	public List<RptTnAnnouncementcourtEntity> selectListByNameCode(String name, String creditCode) {
		EntityWrapper<RptTnAnnouncementcourtEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnAnnouncementcourtEntity());
		ew.eq("ent_name", name);
		ew.eq("data_state", TysDataStateEnum.FINISH.key());
		logger.info(ew.getSqlSegment());
		return this.baseMapper.selectList(ew);
	}

	@Override
	public RptTnAnnouncementcourtEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnAnnouncementcourtEntity entity = new RptTnAnnouncementcourtEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnAnnouncementcourtEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnAnnouncementcourtEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}
}
