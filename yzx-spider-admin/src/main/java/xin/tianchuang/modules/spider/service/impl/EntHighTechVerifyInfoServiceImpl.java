package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntHighTechVerifyInfoDao;
import xin.tianchuang.modules.spider.entity.EntHighTechVerifyInfoEntity;
import xin.tianchuang.modules.spider.service.EntHighTechVerifyInfoService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("entHighTechVerifyInfoService")
public class EntHighTechVerifyInfoServiceImpl extends ServiceImpl<EntHighTechVerifyInfoDao, EntHighTechVerifyInfoEntity> implements EntHighTechVerifyInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EntHighTechVerifyInfoEntity> page = this.selectPage(
                new Query<EntHighTechVerifyInfoEntity>(params).getPage(),
                new EntityWrapper<EntHighTechVerifyInfoEntity>()
        );

        return new PageUtils(page);
    }

}
