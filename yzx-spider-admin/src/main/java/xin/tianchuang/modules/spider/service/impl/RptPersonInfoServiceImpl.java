package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptPersonInfoDao;
import xin.tianchuang.modules.spider.entity.RptPersonInfoEntity;
import xin.tianchuang.modules.spider.service.RptPersonInfoService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("rptPersonInfoService")
public class RptPersonInfoServiceImpl extends ServiceImpl<RptPersonInfoDao, RptPersonInfoEntity> implements RptPersonInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RptPersonInfoEntity> page = this.selectPage(
                new Query<RptPersonInfoEntity>(params).getPage(),
                new EntityWrapper<RptPersonInfoEntity>()
        );

        return new PageUtils(page);
    }

}
