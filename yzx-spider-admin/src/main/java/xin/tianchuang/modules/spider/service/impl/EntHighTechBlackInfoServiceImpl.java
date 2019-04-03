package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntHighTechBlackInfoDao;
import xin.tianchuang.modules.spider.entity.EntHighTechBlackInfoEntity;
import xin.tianchuang.modules.spider.service.EntHighTechBlackInfoService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("entHighTechBlackInfoService")
public class EntHighTechBlackInfoServiceImpl extends ServiceImpl<EntHighTechBlackInfoDao, EntHighTechBlackInfoEntity> implements EntHighTechBlackInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EntHighTechBlackInfoEntity> page = this.selectPage(
                new Query<EntHighTechBlackInfoEntity>(params).getPage(),
                new EntityWrapper<EntHighTechBlackInfoEntity>()
        );

        return new PageUtils(page);
    }

}
