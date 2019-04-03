package xin.tianchuang.modules.spider.service.impl;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.HndsCreditLevelDao;
import xin.tianchuang.modules.spider.entity.HndsCreditLevelEntity;
import xin.tianchuang.modules.spider.service.HndsCreditLevelService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("hndsCreditLevelService")
public class HndsCreditLevelServiceImpl extends ServiceImpl<HndsCreditLevelDao, HndsCreditLevelEntity> implements HndsCreditLevelService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String taxper = (String) params.get("taxper");
		String taxNo = (String) params.get("taxNo");
		Page<HndsCreditLevelEntity> page = this.selectPage(new Query<HndsCreditLevelEntity>(params).getPage(), new EntityWrapper<HndsCreditLevelEntity>() //
				.like(StringUtils.isNotBlank(taxper), "taxper", taxper) //
				.eq(StringUtils.isNotBlank(taxNo), "tax_no", taxNo) //
				.orderBy("evaluate_date", true) //
				.orderBy("create_time", false) //
				
				);

		return new PageUtils(page);
	}

	@Override
	public HndsCreditLevelEntity selectByTaxNoYearsDate(String taxper, String taxNo, String years, String evaluateDate, String authority) {
		HndsCreditLevelEntity entity = new HndsCreditLevelEntity();
		entity.setTaxper(taxper);
		entity.setTaxNo(taxNo);
		entity.setYears(years);
		entity.setEvaluateDate(evaluateDate);
		entity.setAuthority(authority);
		return this.baseMapper.selectOne(entity);
	}

}
