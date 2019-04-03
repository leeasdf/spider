package xin.tianchuang.modules.spider.service.impl;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptTnEntPersonCmpanyDao;
import xin.tianchuang.modules.spider.entity.RptTnEntPersonCmpanyEntity;
import xin.tianchuang.modules.spider.service.RptTnEntPersonCmpanyService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnEntPersonCmpanyService")
public class RptTnEntPersonCmpanyServiceImpl extends ServiceImpl<RptTnEntPersonCmpanyDao, RptTnEntPersonCmpanyEntity> implements RptTnEntPersonCmpanyService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String entName = (String) params.get("entName");
		// String enterpriseId = (String) params.get("enterpriseId");
		Page<RptTnEntPersonCmpanyEntity> page = this.selectPage(new Query<RptTnEntPersonCmpanyEntity>(params).getPage(),
				new EntityWrapper<RptTnEntPersonCmpanyEntity>().like(StringUtils.isNotBlank(entName), "entName", entName)
				// .eq(StringUtils.isNotBlank(enterpriseId),"enterprise_id", enterpriseId)
						.orderBy("create_time", false));

		return new PageUtils(page);
	}

}
