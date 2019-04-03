package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.CsSfgwDsOverduenohandletaxDao;
import xin.tianchuang.modules.spider.entity.CsSfgwDsOverduenohandletaxEntity;
import xin.tianchuang.modules.spider.service.CsSfgwDsOverduenohandletaxService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("csSfgwDsOverduenohandletaxService")
public class CsSfgwDsOverduenohandletaxServiceImpl extends ServiceImpl<CsSfgwDsOverduenohandletaxDao, CsSfgwDsOverduenohandletaxEntity> implements CsSfgwDsOverduenohandletaxService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CsSfgwDsOverduenohandletaxEntity> page = this.selectPage(
                new Query<CsSfgwDsOverduenohandletaxEntity>(params).getPage(),
                new EntityWrapper<CsSfgwDsOverduenohandletaxEntity>()
        );

        return new PageUtils(page);
    }

}
