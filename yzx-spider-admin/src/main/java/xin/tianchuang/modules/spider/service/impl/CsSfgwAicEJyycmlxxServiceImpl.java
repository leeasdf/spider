package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.CsSfgwAicEJyycmlxxDao;
import xin.tianchuang.modules.spider.entity.CsSfgwAicEJyycmlxxEntity;
import xin.tianchuang.modules.spider.service.CsSfgwAicEJyycmlxxService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("csSfgwAicEJyycmlxxService")
public class CsSfgwAicEJyycmlxxServiceImpl extends ServiceImpl<CsSfgwAicEJyycmlxxDao, CsSfgwAicEJyycmlxxEntity> implements CsSfgwAicEJyycmlxxService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CsSfgwAicEJyycmlxxEntity> page = this.selectPage(
                new Query<CsSfgwAicEJyycmlxxEntity>(params).getPage(),
                new EntityWrapper<CsSfgwAicEJyycmlxxEntity>()
        );

        return new PageUtils(page);
    }

}
