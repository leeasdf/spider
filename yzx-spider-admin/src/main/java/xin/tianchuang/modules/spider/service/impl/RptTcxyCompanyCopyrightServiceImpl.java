package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptTcxyCompanyCopyrightDao;
import xin.tianchuang.modules.spider.entity.RptTcxyCompanyCopyrightEntity;
import xin.tianchuang.modules.spider.service.RptTcxyCompanyCopyrightService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTcxyCompanyCopyrightService")
public class RptTcxyCompanyCopyrightServiceImpl extends ServiceImpl<RptTcxyCompanyCopyrightDao, RptTcxyCompanyCopyrightEntity> implements RptTcxyCompanyCopyrightService {

	private static final Logger logger = LoggerFactory.getLogger(RptTcxyCompanyCopyrightService.class);

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String entName = (String) params.get("entName");
		String enterpriseId = (String) params.get("enterpriseId");
		Page<RptTcxyCompanyCopyrightEntity> page = this.selectPage(new Query<RptTcxyCompanyCopyrightEntity>(params).getPage(), new EntityWrapper<RptTcxyCompanyCopyrightEntity>()
				.like(StringUtils.isNotBlank(entName), "owner_name", entName).eq(StringUtils.isNotBlank(enterpriseId), "company_id", enterpriseId)
				.orderBy("create_time", false)
				);

		return new PageUtils(page);
	}

	@Override
	public List<RptTcxyCompanyCopyrightEntity> selectListByNameCode(String name, String creditCode) {
		EntityWrapper<RptTcxyCompanyCopyrightEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTcxyCompanyCopyrightEntity());
		ew.eq("owner_name", name);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.selectList(ew);
	}

}
