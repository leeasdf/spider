package xin.tianchuang.modules.spider.service.impl;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptTnBusroleDao;
import xin.tianchuang.modules.spider.entity.RptTnBusroleEntity;
import xin.tianchuang.modules.spider.service.RptTnBusroleService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnBusroleService")
public class RptTnBusroleServiceImpl extends ServiceImpl<RptTnBusroleDao, RptTnBusroleEntity> implements RptTnBusroleService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String entName = (String) params.get("entName");
		 // String enterpriseId = (String) params.get("enterpriseId");
		Page<RptTnBusroleEntity> page = this.selectPage(
				new Query<RptTnBusroleEntity>(params).getPage(),
				new EntityWrapper<RptTnBusroleEntity>().like(StringUtils.isNotBlank(entName), "entName", entName)
				// .eq(StringUtils.isNotBlank(enterpriseId), "enterprise_id", enterpriseId)
						.orderBy("create_time", false));

		return new PageUtils(page);
	}

}
