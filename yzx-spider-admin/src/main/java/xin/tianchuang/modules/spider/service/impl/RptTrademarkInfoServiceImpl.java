package xin.tianchuang.modules.spider.service.impl;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptTrademarkInfoDao;
import xin.tianchuang.modules.spider.entity.RptTrademarkInfoEntity;
import xin.tianchuang.modules.spider.service.RptTrademarkInfoService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTrademarkInfoService")
public class RptTrademarkInfoServiceImpl extends ServiceImpl<RptTrademarkInfoDao, RptTrademarkInfoEntity> implements RptTrademarkInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String entName = (String) params.get("ent_name");
		Page<RptTrademarkInfoEntity> page = this.selectPage(new Query<RptTrademarkInfoEntity>(params).getPage(),
				new EntityWrapper<RptTrademarkInfoEntity>().like(StringUtils.isNotBlank(entName), "ent_name", entName).orderBy("create_time", true));

		return new PageUtils(page);
	}
}
