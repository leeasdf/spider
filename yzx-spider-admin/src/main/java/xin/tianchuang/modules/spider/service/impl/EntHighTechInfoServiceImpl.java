package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntHighTechInfoDao;
import xin.tianchuang.modules.spider.entity.EntHighTechInfoEntity;
import xin.tianchuang.modules.spider.service.EntHighTechInfoService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("entHighTechInfoService")
public class EntHighTechInfoServiceImpl extends ServiceImpl<EntHighTechInfoDao, EntHighTechInfoEntity> implements EntHighTechInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EntHighTechInfoEntity> page = this.selectPage(
                new Query<EntHighTechInfoEntity>(params).getPage(),
                new EntityWrapper<EntHighTechInfoEntity>()
        );

        return new PageUtils(page);
    }

}
