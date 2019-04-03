package xin.tianchuang.modules.spider.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.CcgpPurchaseIllegalDao;
import xin.tianchuang.modules.spider.entity.CcgpPurchaseIllegalEntity;
import xin.tianchuang.modules.spider.service.CcgpPurchaseIllegalService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("ccgpPurchaseIllegalService")
public class CcgpPurchaseIllegalServiceImpl extends ServiceImpl<CcgpPurchaseIllegalDao, CcgpPurchaseIllegalEntity> implements CcgpPurchaseIllegalService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String entName = params.get("ent_name").toString();
		Page<CcgpPurchaseIllegalEntity> page = this.selectPage(new Query<CcgpPurchaseIllegalEntity>(params).getPage(), new EntityWrapper<CcgpPurchaseIllegalEntity>()
				.eq(entName != null||!entName.equals(""),"ent_name", entName));

		return new PageUtils(page);
	}

	@Override
	public CcgpPurchaseIllegalEntity selectByCreditCodeDate(String creditCode, String punishDate) {
		CcgpPurchaseIllegalEntity entity = new CcgpPurchaseIllegalEntity();
		entity.setCreditCode(creditCode);
		entity.setPublishDate(punishDate);
		return this.baseMapper.selectOne(entity);
	}

}
