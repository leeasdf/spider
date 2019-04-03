package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.CsSfgwAicInfofinanceDao;
import xin.tianchuang.modules.spider.entity.CsSfgwAicInfofinanceEntity;
import xin.tianchuang.modules.spider.service.CsSfgwAicInfofinanceService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("csSfgwAicInfofinanceService")
public class CsSfgwAicInfofinanceServiceImpl extends ServiceImpl<CsSfgwAicInfofinanceDao, CsSfgwAicInfofinanceEntity> implements CsSfgwAicInfofinanceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CsSfgwAicInfofinanceEntity> page = this.selectPage(
                new Query<CsSfgwAicInfofinanceEntity>(params).getPage(),
                new EntityWrapper<CsSfgwAicInfofinanceEntity>()
        );

        return new PageUtils(page);
    }

}
