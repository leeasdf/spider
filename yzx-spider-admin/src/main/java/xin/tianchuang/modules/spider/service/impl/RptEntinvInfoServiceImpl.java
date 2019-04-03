package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptEntinvInfoDao;
import xin.tianchuang.modules.spider.entity.RptEntinvInfoEntity;
import xin.tianchuang.modules.spider.service.RptEntinvInfoService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("rptEntinvInfoService")
public class RptEntinvInfoServiceImpl extends ServiceImpl<RptEntinvInfoDao, RptEntinvInfoEntity> implements RptEntinvInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RptEntinvInfoEntity> page = this.selectPage(
                new Query<RptEntinvInfoEntity>(params).getPage(),
                new EntityWrapper<RptEntinvInfoEntity>()
        );

        return new PageUtils(page);
    }

}
