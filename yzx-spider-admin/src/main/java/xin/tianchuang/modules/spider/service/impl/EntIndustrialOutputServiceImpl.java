package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntIndustrialOutputDao;
import xin.tianchuang.modules.spider.entity.EntIndustrialOutputEntity;
import xin.tianchuang.modules.spider.service.EntIndustrialOutputService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("entIndustrialOutputService")
public class EntIndustrialOutputServiceImpl extends ServiceImpl<EntIndustrialOutputDao, EntIndustrialOutputEntity> implements EntIndustrialOutputService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EntIndustrialOutputEntity> page = this.selectPage(
                new Query<EntIndustrialOutputEntity>(params).getPage(),
                new EntityWrapper<EntIndustrialOutputEntity>()
        );

        return new PageUtils(page);
    }

}
