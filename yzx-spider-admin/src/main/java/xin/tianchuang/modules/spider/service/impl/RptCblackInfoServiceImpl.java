package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptCblackInfoDao;
import xin.tianchuang.modules.spider.entity.RptCblackInfoEntity;
import xin.tianchuang.modules.spider.service.RptCblackInfoService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("rptCblackInfoService")
public class RptCblackInfoServiceImpl extends ServiceImpl<RptCblackInfoDao, RptCblackInfoEntity> implements RptCblackInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RptCblackInfoEntity> page = this.selectPage(
                new Query<RptCblackInfoEntity>(params).getPage(),
                new EntityWrapper<RptCblackInfoEntity>()
        );

        return new PageUtils(page);
    }

}
