package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntTaxInfoDao;
import xin.tianchuang.modules.spider.entity.EntTaxInfoEntity;
import xin.tianchuang.modules.spider.service.EntTaxInfoService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("entTaxInfoService")
public class EntTaxInfoServiceImpl extends ServiceImpl<EntTaxInfoDao, EntTaxInfoEntity> implements EntTaxInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EntTaxInfoEntity> page = this.selectPage(
                new Query<EntTaxInfoEntity>(params).getPage(),
                new EntityWrapper<EntTaxInfoEntity>()
        );

        return new PageUtils(page);
    }

}
