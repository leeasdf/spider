package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntHighTechIndustrialEstateDao;
import xin.tianchuang.modules.spider.entity.EntHighTechIndustrialEstateEntity;
import xin.tianchuang.modules.spider.service.EntHighTechIndustrialEstateService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("entHighTechIndustrialEstateService")
public class EntHighTechIndustrialEstateServiceImpl extends ServiceImpl<EntHighTechIndustrialEstateDao, EntHighTechIndustrialEstateEntity> implements EntHighTechIndustrialEstateService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EntHighTechIndustrialEstateEntity> page = this.selectPage(
                new Query<EntHighTechIndustrialEstateEntity>(params).getPage(),
                new EntityWrapper<EntHighTechIndustrialEstateEntity>()
        );

        return new PageUtils(page);
    }

}
