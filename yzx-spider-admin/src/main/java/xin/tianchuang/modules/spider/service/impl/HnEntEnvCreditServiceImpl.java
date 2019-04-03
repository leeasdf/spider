package xin.tianchuang.modules.spider.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.HnEntEnvCreditDao;
import xin.tianchuang.modules.spider.entity.HnEntEnvCreditEntity;
import xin.tianchuang.modules.spider.service.HnEntEnvCreditService;

@Service("hnEntEnvCreditService")
public class HnEntEnvCreditServiceImpl extends ServiceImpl<HnEntEnvCreditDao, HnEntEnvCreditEntity> implements HnEntEnvCreditService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String entName = (String) params.get("entName");
		String comName = (String) params.get("comName");
		Page<HnEntEnvCreditEntity> page = this.selectPage(new Query<HnEntEnvCreditEntity>(params).getPage(), new EntityWrapper<HnEntEnvCreditEntity>()//
				.like(StringUtils.isNotBlank(entName), "enterprise_name", entName)//
				.like(StringUtils.isNotBlank(comName), "com_name", comName)//
				.orderBy("create_time", false) //
				.orderBy("years", true) //
				);

		return new PageUtils(page);
	}

	@Override
	public HnEntEnvCreditEntity selectByOne(HnEntEnvCreditEntity reqEntity, String years) {
		HnEntEnvCreditEntity entity = new HnEntEnvCreditEntity();
		entity.setComName(reqEntity.getComName());
		entity.setAreaId(reqEntity.getAreaId());
		entity.setComType(reqEntity.getComType());
		entity.setExt1(reqEntity.getExt1());
		entity.setYears(years);
		return this.baseMapper.selectOne(entity);
	}

}
