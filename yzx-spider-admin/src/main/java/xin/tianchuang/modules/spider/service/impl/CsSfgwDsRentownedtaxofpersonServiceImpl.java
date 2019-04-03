package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.CsSfgwDsRentownedtaxofpersonDao;
import xin.tianchuang.modules.spider.entity.CsSfgwDsRentownedtaxofpersonEntity;
import xin.tianchuang.modules.spider.service.CsSfgwDsRentownedtaxofpersonService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("csSfgwDsRentownedtaxofpersonService")
public class CsSfgwDsRentownedtaxofpersonServiceImpl extends ServiceImpl<CsSfgwDsRentownedtaxofpersonDao, CsSfgwDsRentownedtaxofpersonEntity> implements CsSfgwDsRentownedtaxofpersonService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CsSfgwDsRentownedtaxofpersonEntity> page = this.selectPage(
                new Query<CsSfgwDsRentownedtaxofpersonEntity>(params).getPage(),
                new EntityWrapper<CsSfgwDsRentownedtaxofpersonEntity>()
        );

        return new PageUtils(page);
    }

}
