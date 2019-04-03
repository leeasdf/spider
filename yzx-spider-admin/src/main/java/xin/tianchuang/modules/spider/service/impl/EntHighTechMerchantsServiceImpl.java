package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntHighTechMerchantsDao;
import xin.tianchuang.modules.spider.entity.EntHighTechMerchantsEntity;
import xin.tianchuang.modules.spider.service.EntHighTechMerchantsService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("entHighTechMerchantsService")
public class EntHighTechMerchantsServiceImpl extends ServiceImpl<EntHighTechMerchantsDao, EntHighTechMerchantsEntity> implements EntHighTechMerchantsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EntHighTechMerchantsEntity> page = this.selectPage(
                new Query<EntHighTechMerchantsEntity>(params).getPage(),
                new EntityWrapper<EntHighTechMerchantsEntity>()
        );

        return new PageUtils(page);
    }

}
