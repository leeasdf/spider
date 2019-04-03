package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntHighTechProjectDeclareDao;
import xin.tianchuang.modules.spider.entity.EntHighTechProjectDeclareEntity;
import xin.tianchuang.modules.spider.service.EntHighTechProjectDeclareService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("entHighTechProjectDeclareService")
public class EntHighTechProjectDeclareServiceImpl extends ServiceImpl<EntHighTechProjectDeclareDao, EntHighTechProjectDeclareEntity> implements EntHighTechProjectDeclareService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EntHighTechProjectDeclareEntity> page = this.selectPage(
                new Query<EntHighTechProjectDeclareEntity>(params).getPage(),
                new EntityWrapper<EntHighTechProjectDeclareEntity>()
        );

        return new PageUtils(page);
    }

}
