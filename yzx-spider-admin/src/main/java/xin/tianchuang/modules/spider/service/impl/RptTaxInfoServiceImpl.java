package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptTaxInfoDao;
import xin.tianchuang.modules.spider.entity.RptTaxInfoEntity;
import xin.tianchuang.modules.spider.service.RptTaxInfoService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("rptTaxInfoService")
public class RptTaxInfoServiceImpl extends ServiceImpl<RptTaxInfoDao, RptTaxInfoEntity> implements RptTaxInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RptTaxInfoEntity> page = this.selectPage(
                new Query<RptTaxInfoEntity>(params).getPage(),
                new EntityWrapper<RptTaxInfoEntity>()
        );

        return new PageUtils(page);
    }

}
