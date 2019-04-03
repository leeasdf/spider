package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.CsSfgwAicContactDao;
import xin.tianchuang.modules.spider.entity.CsSfgwAicContactEntity;
import xin.tianchuang.modules.spider.service.CsSfgwAicContactService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("csSfgwAicContactService")
public class CsSfgwAicContactServiceImpl extends ServiceImpl<CsSfgwAicContactDao, CsSfgwAicContactEntity> implements CsSfgwAicContactService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CsSfgwAicContactEntity> page = this.selectPage(
                new Query<CsSfgwAicContactEntity>(params).getPage(),
                new EntityWrapper<CsSfgwAicContactEntity>()
        );

        return new PageUtils(page);
    }

}
