package xin.tianchuang.modules.spider.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.CsSfgwTaxTaxofnopayedDao;
import xin.tianchuang.modules.spider.entity.CsSfgwTaxTaxofnopayedEntity;
import xin.tianchuang.modules.spider.service.CsSfgwTaxTaxofnopayedService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("csSfgwTaxTaxofnopayedService")
public class CsSfgwTaxTaxofnopayedServiceImpl extends ServiceImpl<CsSfgwTaxTaxofnopayedDao, CsSfgwTaxTaxofnopayedEntity> implements CsSfgwTaxTaxofnopayedService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
    	String corporationname = (String) params.get("corporationname");
        Page<CsSfgwTaxTaxofnopayedEntity> page = this.selectPage(
                new Query<CsSfgwTaxTaxofnopayedEntity>(params).getPage(),
                new EntityWrapper<CsSfgwTaxTaxofnopayedEntity>() //
                .like(StringUtils.isNotBlank(corporationname), "corporationname", corporationname) //
				.orderBy("create_time", false)
        );

        return new PageUtils(page);
    }

}
