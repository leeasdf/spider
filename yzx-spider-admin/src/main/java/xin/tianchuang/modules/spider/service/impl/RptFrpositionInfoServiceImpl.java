package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptFrpositionInfoDao;
import xin.tianchuang.modules.spider.entity.RptFrpositionInfoEntity;
import xin.tianchuang.modules.spider.service.RptFrpositionInfoService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("rptFrpositionInfoService")
public class RptFrpositionInfoServiceImpl extends ServiceImpl<RptFrpositionInfoDao, RptFrpositionInfoEntity> implements RptFrpositionInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RptFrpositionInfoEntity> page = this.selectPage(
                new Query<RptFrpositionInfoEntity>(params).getPage(),
                new EntityWrapper<RptFrpositionInfoEntity>()
        );

        return new PageUtils(page);
    }

}
