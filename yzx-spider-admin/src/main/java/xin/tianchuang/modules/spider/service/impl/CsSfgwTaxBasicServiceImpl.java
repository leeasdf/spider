package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.CsSfgwTaxBasicDao;
import xin.tianchuang.modules.spider.entity.CsSfgwTaxBasicEntity;
import xin.tianchuang.modules.spider.service.CsSfgwTaxBasicService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("csSfgwTaxBasicService")
public class CsSfgwTaxBasicServiceImpl extends ServiceImpl<CsSfgwTaxBasicDao, CsSfgwTaxBasicEntity> implements CsSfgwTaxBasicService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CsSfgwTaxBasicEntity> page = this.selectPage(
                new Query<CsSfgwTaxBasicEntity>(params).getPage(),
                new EntityWrapper<CsSfgwTaxBasicEntity>()
        );

        return new PageUtils(page);
    }

}
