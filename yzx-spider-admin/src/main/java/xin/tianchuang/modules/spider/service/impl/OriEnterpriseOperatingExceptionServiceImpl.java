package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.OriEnterpriseOperatingExceptionDao;
import xin.tianchuang.modules.spider.entity.OriEnterpriseOperatingExceptionEntity;
import xin.tianchuang.modules.spider.service.OriEnterpriseOperatingExceptionService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("oriEnterpriseOperatingExceptionService")
public class OriEnterpriseOperatingExceptionServiceImpl extends ServiceImpl<OriEnterpriseOperatingExceptionDao, OriEnterpriseOperatingExceptionEntity> implements OriEnterpriseOperatingExceptionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OriEnterpriseOperatingExceptionEntity> page = this.selectPage(
                new Query<OriEnterpriseOperatingExceptionEntity>(params).getPage(),
                new EntityWrapper<OriEnterpriseOperatingExceptionEntity>()
        );

        return new PageUtils(page);
    }

}
