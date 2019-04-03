package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptTcxyCompanySoftwareCopyrightDao;
import xin.tianchuang.modules.spider.entity.RptTcxyCompanySoftwareCopyrightEntity;
import xin.tianchuang.modules.spider.service.RptTcxyCompanySoftwareCopyrightService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTcxyCompanySoftwareCopyrightService")
public class RptTcxyCompanySoftwareCopyrightServiceImpl extends ServiceImpl<RptTcxyCompanySoftwareCopyrightDao, RptTcxyCompanySoftwareCopyrightEntity> implements
		RptTcxyCompanySoftwareCopyrightService {
	private static final Logger logger = LoggerFactory.getLogger(RptTcxyCompanySoftwareCopyrightService.class);

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String entName = (String) params.get("entName");
		String enterpriseId = (String) params.get("enterpriseId");
		Page<RptTcxyCompanySoftwareCopyrightEntity> page = this.selectPage(new Query<RptTcxyCompanySoftwareCopyrightEntity>(params).getPage(),
				new EntityWrapper<RptTcxyCompanySoftwareCopyrightEntity>()
				.like(StringUtils.isNotBlank(entName), "owner_name", entName).eq(StringUtils.isNotBlank(enterpriseId), "company_id", enterpriseId)
				.orderBy("create_time", false)
				);

		return new PageUtils(page);
	}

	@Override
	public List<RptTcxyCompanySoftwareCopyrightEntity> selectListByNameCode(String name, String creditCode) {
		EntityWrapper<RptTcxyCompanySoftwareCopyrightEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTcxyCompanySoftwareCopyrightEntity());
		ew.eq("owner_name", name);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.selectList(ew);
	}

}
