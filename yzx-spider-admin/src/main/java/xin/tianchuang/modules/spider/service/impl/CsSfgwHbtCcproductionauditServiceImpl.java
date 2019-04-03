package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.CsSfgwHbtCcproductionauditDao;
import xin.tianchuang.modules.spider.entity.CsSfgwHbtCcproductionauditEntity;
import xin.tianchuang.modules.spider.service.CsSfgwHbtCcproductionauditService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("csSfgwHbtCcproductionauditService")
public class CsSfgwHbtCcproductionauditServiceImpl extends ServiceImpl<CsSfgwHbtCcproductionauditDao, CsSfgwHbtCcproductionauditEntity> implements CsSfgwHbtCcproductionauditService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CsSfgwHbtCcproductionauditEntity> page = this.selectPage(
                new Query<CsSfgwHbtCcproductionauditEntity>(params).getPage(),
                new EntityWrapper<CsSfgwHbtCcproductionauditEntity>()
        );

        return new PageUtils(page);
    }

}
