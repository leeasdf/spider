package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntEnvironmentProtectDao;
import xin.tianchuang.modules.spider.entity.EntEnvironmentProtectEntity;
import xin.tianchuang.modules.spider.service.EntEnvironmentProtectService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("entEnvironmentProtectService")
public class EntEnvironmentProtectServiceImpl extends ServiceImpl<EntEnvironmentProtectDao, EntEnvironmentProtectEntity> implements EntEnvironmentProtectService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EntEnvironmentProtectEntity> page = this.selectPage(
                new Query<EntEnvironmentProtectEntity>(params).getPage(),
                new EntityWrapper<EntEnvironmentProtectEntity>()
        );

        return new PageUtils(page);
    }

}
