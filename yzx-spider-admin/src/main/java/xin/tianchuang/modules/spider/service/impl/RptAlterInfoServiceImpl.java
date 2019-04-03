package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptAlterInfoDao;
import xin.tianchuang.modules.spider.entity.RptAlterInfoEntity;
import xin.tianchuang.modules.spider.service.RptAlterInfoService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("rptAlterInfoService")
public class RptAlterInfoServiceImpl extends ServiceImpl<RptAlterInfoDao, RptAlterInfoEntity> implements RptAlterInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RptAlterInfoEntity> page = this.selectPage(
                new Query<RptAlterInfoEntity>(params).getPage(),
                new EntityWrapper<RptAlterInfoEntity>()
        );

        return new PageUtils(page);
    }

}
