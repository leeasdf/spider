package xin.tianchuang.modules.spider.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.TycPageRecordDao;
import xin.tianchuang.modules.spider.entity.TycPageRecordEntity;
import xin.tianchuang.modules.spider.service.TycPageRecordService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("tycPageRecordService")
public class TycPageRecordServiceImpl extends ServiceImpl<TycPageRecordDao, TycPageRecordEntity> implements TycPageRecordService {

	@Autowired
	private TycPageRecordDao mapper;

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<TycPageRecordEntity> page = this.selectPage(new Query<TycPageRecordEntity>(params).getPage(), new EntityWrapper<TycPageRecordEntity>());

		return new PageUtils(page);
	}

	@Override
	public TycPageRecordEntity selectByEnterpriseNameAndDataType(String name, int dataType) {
		TycPageRecordEntity entity = new TycPageRecordEntity();
		entity.setEntName(name);
		entity.setDataType(dataType);
		return mapper.selectOne(entity);
	}

}
