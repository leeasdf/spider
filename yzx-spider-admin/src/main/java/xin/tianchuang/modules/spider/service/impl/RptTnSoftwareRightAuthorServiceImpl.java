package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.TysDataStateEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptTnSoftwareRightAuthorDao;
import xin.tianchuang.modules.spider.entity.RptTnSoftwareRightAuthorEntity;
import xin.tianchuang.modules.spider.service.RptTnShareholdersService;
import xin.tianchuang.modules.spider.service.RptTnSoftwareRightAuthorService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("rptTnSoftwareRightAuthorService")
public class RptTnSoftwareRightAuthorServiceImpl extends ServiceImpl<RptTnSoftwareRightAuthorDao, RptTnSoftwareRightAuthorEntity> implements RptTnSoftwareRightAuthorService {

	private static final Logger logger = LoggerFactory.getLogger(RptTnShareholdersService.class);

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String entName = (String) params.get("entName");
		String enterpriseId = (String) params.get("enterpriseId");
		Page<RptTnSoftwareRightAuthorEntity> page = this.selectPage(new Query<RptTnSoftwareRightAuthorEntity>(params).getPage(),
				new EntityWrapper<RptTnSoftwareRightAuthorEntity>().like(StringUtils.isNotBlank(entName), "ent_name", entName).eq(StringUtils.isNotBlank(enterpriseId), "enterprise_id", enterpriseId)
						.orderBy("create_time", false));

		return new PageUtils(page);
	}

	@Override
	public List<RptTnSoftwareRightAuthorEntity> selectListByNameCode(String name, String creditCode) {
		EntityWrapper<RptTnSoftwareRightAuthorEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnSoftwareRightAuthorEntity());
		ew.eq("ent_ame", name);
		ew.eq("data_state", TysDataStateEnum.FINISH.key());
		logger.info(ew.getSqlSegment());
		return this.baseMapper.selectList(ew);
	}

	@Override
	public RptTnSoftwareRightAuthorEntity selectByEnterpriseId(Long enterpriseId) {
		RptTnSoftwareRightAuthorEntity entity = new RptTnSoftwareRightAuthorEntity();
		entity.setEnterpriseId(enterpriseId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer selectCountByEnterpriseId(Long enterpriseId) {
		EntityWrapper<RptTnSoftwareRightAuthorEntity> ew = new EntityWrapper<>();
		ew.setEntity(new RptTnSoftwareRightAuthorEntity());
		ew.eq("enterprise_id", enterpriseId);
		return this.baseMapper.selectCount(ew);
	}

}
