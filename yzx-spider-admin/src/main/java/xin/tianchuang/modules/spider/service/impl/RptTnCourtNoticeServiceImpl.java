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
import xin.tianchuang.modules.spider.dao.RptTnCourtNoticeDao;
import xin.tianchuang.modules.spider.entity.RptTnCourtNoticeEntity;
import xin.tianchuang.modules.spider.service.RptTnCourtNoticeService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnCourtNoticeService")
public class RptTnCourtNoticeServiceImpl extends ServiceImpl<RptTnCourtNoticeDao, RptTnCourtNoticeEntity> implements RptTnCourtNoticeService {
	private static final Logger logger = LoggerFactory.getLogger(RptTnCourtNoticeService.class);

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String entName = (String) params.get("entName");
		String enterpriseId = (String) params.get("enterpriseId");
		Page<RptTnCourtNoticeEntity> page = this.selectPage(
				new Query<RptTnCourtNoticeEntity>(params).getPage(),
				new EntityWrapper<RptTnCourtNoticeEntity>().like(StringUtils.isNotBlank(entName), "ent_name", entName).eq(StringUtils.isNotBlank(enterpriseId), "enterprise_id", enterpriseId)
						.orderBy("create_time", false));

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnCourtNoticeEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnCourtNoticeEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.delete(ew);
	}

	@Override
	public List<RptTnCourtNoticeEntity> selectListByNameCode(String name, String creditCode) {
		EntityWrapper<RptTnCourtNoticeEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnCourtNoticeEntity());
		ew.eq("ent_name", name);
		ew.eq("data_state", TysDataStateEnum.FINISH.key());
		logger.info(ew.getSqlSegment());
		return this.baseMapper.selectList(ew);
	}

	@Override
	public RptTnCourtNoticeEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnCourtNoticeEntity entity = new RptTnCourtNoticeEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnCourtNoticeEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnCourtNoticeEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}

}
