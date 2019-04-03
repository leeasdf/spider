package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.CsSfgwAicInfoetailDao;
import xin.tianchuang.modules.spider.entity.CsSfgwAicInfoetailEntity;
import xin.tianchuang.modules.spider.service.CsSfgwAicInfoetailService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("csSfgwAicInfoetailService")
public class CsSfgwAicInfoetailServiceImpl extends ServiceImpl<CsSfgwAicInfoetailDao, CsSfgwAicInfoetailEntity> implements CsSfgwAicInfoetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CsSfgwAicInfoetailEntity> page = this.selectPage(
                new Query<CsSfgwAicInfoetailEntity>(params).getPage(),
                new EntityWrapper<CsSfgwAicInfoetailEntity>()
        );

        return new PageUtils(page);
    }

}
