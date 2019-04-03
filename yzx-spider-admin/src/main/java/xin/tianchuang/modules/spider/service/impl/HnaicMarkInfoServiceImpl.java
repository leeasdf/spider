package xin.tianchuang.modules.spider.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.HnaicMarkInfoDao;
import xin.tianchuang.modules.spider.entity.HnaicMarkInfoEntity;
import xin.tianchuang.modules.spider.service.HnaicMarkInfoService;

@Service("hnaicMarkInfoService")
public class HnaicMarkInfoServiceImpl extends ServiceImpl<HnaicMarkInfoDao, HnaicMarkInfoEntity> implements HnaicMarkInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String entName = (String) params.get("entName");
		Page<HnaicMarkInfoEntity> page = this.selectPage(new Query<HnaicMarkInfoEntity>(params).getPage(), new EntityWrapper<HnaicMarkInfoEntity>() //
				.like(StringUtils.isNotBlank(entName), "ent_name", entName) //
				.orderBy("create_time", false) //
				);

		return new PageUtils(page);
	}

	@Override
	public HnaicMarkInfoEntity selectByMarkId(String markId) {
		HnaicMarkInfoEntity entity = new HnaicMarkInfoEntity();
		entity.setMarkId(markId);
		return this.baseMapper.selectOne(entity);
	}

}
