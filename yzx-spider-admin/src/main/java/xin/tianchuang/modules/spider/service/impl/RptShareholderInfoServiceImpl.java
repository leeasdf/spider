package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptShareholderInfoDao;
import xin.tianchuang.modules.spider.entity.RptShareholderInfoEntity;
import xin.tianchuang.modules.spider.service.RptShareholderInfoService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("rptShareholderInfoService")
public class RptShareholderInfoServiceImpl extends ServiceImpl<RptShareholderInfoDao, RptShareholderInfoEntity> implements RptShareholderInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RptShareholderInfoEntity> page = this.selectPage(
                new Query<RptShareholderInfoEntity>(params).getPage(),
                new EntityWrapper<RptShareholderInfoEntity>()
        );

        return new PageUtils(page);
    }

}
