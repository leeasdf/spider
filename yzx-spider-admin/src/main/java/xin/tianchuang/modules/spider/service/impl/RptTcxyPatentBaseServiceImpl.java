package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptTcxyPatentBaseDao;
import xin.tianchuang.modules.spider.entity.RptTcxyPatentBaseEntity;
import xin.tianchuang.modules.spider.service.RptTcxyPatentBaseService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTcxyPatentBaseService")
public class RptTcxyPatentBaseServiceImpl extends ServiceImpl<RptTcxyPatentBaseDao, RptTcxyPatentBaseEntity> implements RptTcxyPatentBaseService {

	private static final Logger logger = LoggerFactory.getLogger(RptTcxyPatentBaseService.class);

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String entName = (String) params.get("entName");
		String enterpriseId = (String) params.get("enterpriseId");
		Page<RptTcxyPatentBaseEntity> page = this.selectPage(new Query<RptTcxyPatentBaseEntity>(params).getPage(), new EntityWrapper<RptTcxyPatentBaseEntity>()
				.like(StringUtils.isNotBlank(entName), "applicant", entName).eq(StringUtils.isNotBlank(enterpriseId), "company_id", enterpriseId)
				.orderBy("create_time", false)
				);

		return new PageUtils(page);
	}

	@Override
	public List<RptTcxyPatentBaseEntity> selectListByNameCode(String name, String creditCode) {
		EntityWrapper<RptTcxyPatentBaseEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTcxyPatentBaseEntity());
		ew.eq("applicant", name);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.selectList(ew);
	}

}
