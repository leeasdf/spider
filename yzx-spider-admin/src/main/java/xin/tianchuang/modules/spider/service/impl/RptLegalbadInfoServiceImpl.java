package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptLegalbadInfoDao;
import xin.tianchuang.modules.spider.entity.RptLegalbadInfoEntity;
import xin.tianchuang.modules.spider.service.RptLegalbadInfoService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("rptLegalbadInfoService")
public class RptLegalbadInfoServiceImpl extends ServiceImpl<RptLegalbadInfoDao, RptLegalbadInfoEntity> implements RptLegalbadInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RptLegalbadInfoEntity> page = this.selectPage(
                new Query<RptLegalbadInfoEntity>(params).getPage(),
                new EntityWrapper<RptLegalbadInfoEntity>()
        );

        return new PageUtils(page);
    }

}
