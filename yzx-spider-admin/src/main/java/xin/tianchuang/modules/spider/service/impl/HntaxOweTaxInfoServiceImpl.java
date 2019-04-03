package xin.tianchuang.modules.spider.service.impl;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.HntaxOweTaxInfoDao;
import xin.tianchuang.modules.spider.entity.HntaxOweTaxInfoEntity;
import xin.tianchuang.modules.spider.service.HntaxOweTaxInfoService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("hntaxOweTaxInfoService")
public class HntaxOweTaxInfoServiceImpl extends ServiceImpl<HntaxOweTaxInfoDao, HntaxOweTaxInfoEntity> implements HntaxOweTaxInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String entName = (String) params.get("entName");
		String taxName = (String) params.get("taxName");
		String taxNo = (String) params.get("taxNo");
		Page<HntaxOweTaxInfoEntity> page = this.selectPage(new Query<HntaxOweTaxInfoEntity>(params).getPage(), new EntityWrapper<HntaxOweTaxInfoEntity>() //
				.like(StringUtils.isNotBlank(entName), "ent_name", entName) //
				.like(StringUtils.isNotBlank(taxName), "tax_name", taxName) //
				.eq(StringUtils.isNotBlank(taxNo), "tax_no", taxNo) //
				.orderBy("publish_date", true) //
				.orderBy("create_time", false) //
				);

		return new PageUtils(page);
	}

	@Override
	public HntaxOweTaxInfoEntity selectByOne(HntaxOweTaxInfoEntity req) {
		return this.baseMapper.selectOne(req);
	}

}
