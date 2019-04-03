package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptOpexInfoDao;
import xin.tianchuang.modules.spider.entity.RptOpexInfoEntity;
import xin.tianchuang.modules.spider.service.RptOpexInfoService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("rptOpexInfoService")
public class RptOpexInfoServiceImpl extends ServiceImpl<RptOpexInfoDao, RptOpexInfoEntity> implements RptOpexInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RptOpexInfoEntity> page = this.selectPage(
                new Query<RptOpexInfoEntity>(params).getPage(),
                new EntityWrapper<RptOpexInfoEntity>()
        );

        return new PageUtils(page);
    }

}
