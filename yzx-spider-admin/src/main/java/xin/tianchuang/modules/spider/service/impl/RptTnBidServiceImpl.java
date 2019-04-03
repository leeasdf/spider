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
import xin.tianchuang.modules.spider.dao.RptTnBidDao;
import xin.tianchuang.modules.spider.entity.RptTnBidEntity;
import xin.tianchuang.modules.spider.service.RptTnBidService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnBidService")
public class RptTnBidServiceImpl extends ServiceImpl<RptTnBidDao, RptTnBidEntity> implements RptTnBidService {

	private static final Logger logger = LoggerFactory.getLogger(RptTnBidService.class);

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnBidEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnBidEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.delete(ew);
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String entName = (String) params.get("entName");
		String enterpriseId = (String) params.get("enterpriseId");
		String title = (String) params.get("title");
		Page<RptTnBidEntity> page = this.selectPage(
				new Query<RptTnBidEntity>(params).getPage(),
				new EntityWrapper<RptTnBidEntity>().like(StringUtils.isNotBlank(entName), "ent_name", entName).like(StringUtils.isNotBlank(title), "title", title)
						.eq(StringUtils.isNotBlank(enterpriseId), "enterprise_id", enterpriseId).orderBy("create_time", false));

		return new PageUtils(page);
	}

	@Override
	public List<RptTnBidEntity> selectListByNameCode(String name, String creditCode) {
		EntityWrapper<RptTnBidEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnBidEntity());
		ew.eq("ent_name", name);
		ew.eq("data_state", TysDataStateEnum.FINISH.key());
		logger.info(ew.getSqlSegment());
		return this.baseMapper.selectList(ew);
	}

	@Override
	public RptTnBidEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnBidEntity entity = new RptTnBidEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnBidEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnBidEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}

}
