package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.ApiLogDao;
import xin.tianchuang.modules.spider.entity.ApiLogEntity;
import xin.tianchuang.modules.spider.service.ApiLogService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("apiLogService")
public class ApiLogServiceImpl extends ServiceImpl<ApiLogDao, ApiLogEntity> implements ApiLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ApiLogEntity> page = this.selectPage(
                new Query<ApiLogEntity>(params).getPage(),
                new EntityWrapper<ApiLogEntity>()
        );

        return new PageUtils(page);
    }

}
