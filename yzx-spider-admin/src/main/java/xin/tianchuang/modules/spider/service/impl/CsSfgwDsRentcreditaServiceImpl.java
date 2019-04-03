package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.CsSfgwDsRentcreditaDao;
import xin.tianchuang.modules.spider.entity.CsSfgwDsRentcreditaEntity;
import xin.tianchuang.modules.spider.service.CsSfgwDsRentcreditaService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("csSfgwDsRentcreditaService")
public class CsSfgwDsRentcreditaServiceImpl extends ServiceImpl<CsSfgwDsRentcreditaDao, CsSfgwDsRentcreditaEntity> implements CsSfgwDsRentcreditaService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CsSfgwDsRentcreditaEntity> page = this.selectPage(
                new Query<CsSfgwDsRentcreditaEntity>(params).getPage(),
                new EntityWrapper<CsSfgwDsRentcreditaEntity>()
        );

        return new PageUtils(page);
    }

}
