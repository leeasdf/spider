package xin.tianchuang.modules.spider.service.impl;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptTnPunishCreditchinaDao;
import xin.tianchuang.modules.spider.entity.RptTnPunishCreditchinaEntity;
import xin.tianchuang.modules.spider.service.RptTnPunishCreditchinaService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnPunishCreditchinaService")
public class RptTnPunishCreditchinaServiceImpl extends ServiceImpl<RptTnPunishCreditchinaDao, RptTnPunishCreditchinaEntity> implements RptTnPunishCreditchinaService {

	private static final Logger logger = LoggerFactory.getLogger(RptTnPunishCreditchinaService.class);

	@Override
	public PageUtils queryPage(Map<String, Object> params) {

		String entName = (String) params.get("entName");
		String enterpriseId = (String) params.get("enterpriseId");
		Page<RptTnPunishCreditchinaEntity> page = this.selectPage(new Query<RptTnPunishCreditchinaEntity>(params).getPage(),
				new EntityWrapper<RptTnPunishCreditchinaEntity>().like(StringUtils.isNotBlank(entName), "ent_name", entName).eq(StringUtils.isNotBlank(enterpriseId), "enterprise_id", enterpriseId)
						.orderBy("create_time", false));

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEnteprirseName(String entName) {
		EntityWrapper<RptTnPunishCreditchinaEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnPunishCreditchinaEntity());
		ew.where("1=1").and();
		ew.eq("ent_name", entName);
		logger.info(ew.getSqlSegment());
		return this.baseMapper.delete(ew);
	}

	@Override
	public RptTnPunishCreditchinaEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnPunishCreditchinaEntity entity = new RptTnPunishCreditchinaEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnPunishCreditchinaEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnPunishCreditchinaEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}
}
