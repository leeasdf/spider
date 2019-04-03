package xin.tianchuang.modules.spider.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.HndsTaxInfoDao;
import xin.tianchuang.modules.spider.entity.HndsCreditLevelEntity;
import xin.tianchuang.modules.spider.entity.HndsTaxInfoEntity;
import xin.tianchuang.modules.spider.service.HndsTaxInfoService;


@Service("hndsTaxInfoService")
public class HndsTaxInfoServiceImpl extends ServiceImpl<HndsTaxInfoDao, HndsTaxInfoEntity> implements HndsTaxInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
    	String taxper = (String) params.get("taxper");
		String taxNo = (String) params.get("taxNo");
        Page<HndsTaxInfoEntity> page = this.selectPage(
                new Query<HndsTaxInfoEntity>(params).getPage(),
                new EntityWrapper<HndsTaxInfoEntity>() //
                .like(StringUtils.isNotBlank(taxper), "taxper", taxper) //
				.eq(StringUtils.isNotBlank(taxNo), "tax_no", taxNo) //
				.orderBy("create_time", false) //
        );

        return new PageUtils(page);
    }

	@Override
	public HndsTaxInfoEntity selectByOne(String taxNo, String taxper, String legalName, String authority, String taxStatus) {
		HndsTaxInfoEntity entity = new HndsTaxInfoEntity();
		entity.setTaxper(taxper);
		entity.setTaxNo(taxNo);
		entity.setTaxStatus(taxStatus);
		entity.setAuthority(authority);
		entity.setLegalName(legalName);
		entity.setAuthority(authority);
		return this.baseMapper.selectOne(entity);
	}

}
