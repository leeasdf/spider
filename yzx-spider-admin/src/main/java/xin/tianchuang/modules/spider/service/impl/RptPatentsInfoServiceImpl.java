package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptPatentsInfoDao;
import xin.tianchuang.modules.spider.entity.RptPatentsInfoEntity;
import xin.tianchuang.modules.spider.service.RptPatentsInfoService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("rptPatentsInfoService")
public class RptPatentsInfoServiceImpl extends ServiceImpl<RptPatentsInfoDao, RptPatentsInfoEntity> implements RptPatentsInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RptPatentsInfoEntity> page = this.selectPage(
                new Query<RptPatentsInfoEntity>(params).getPage(),
                new EntityWrapper<RptPatentsInfoEntity>()
        );

        return new PageUtils(page);
    }

}
