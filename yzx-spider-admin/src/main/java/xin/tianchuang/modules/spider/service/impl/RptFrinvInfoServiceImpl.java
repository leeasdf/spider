package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptFrinvInfoDao;
import xin.tianchuang.modules.spider.entity.RptFrinvInfoEntity;
import xin.tianchuang.modules.spider.service.RptFrinvInfoService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("rptFrinvInfoService")
public class RptFrinvInfoServiceImpl extends ServiceImpl<RptFrinvInfoDao, RptFrinvInfoEntity> implements RptFrinvInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RptFrinvInfoEntity> page = this.selectPage(
                new Query<RptFrinvInfoEntity>(params).getPage(),
                new EntityWrapper<RptFrinvInfoEntity>()
        );

        return new PageUtils(page);
    }

}
