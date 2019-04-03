package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntHighTechPunishInfoDao;
import xin.tianchuang.modules.spider.entity.EntHighTechPunishInfoEntity;
import xin.tianchuang.modules.spider.service.EntHighTechPunishInfoService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("entHighTechPunishInfoService")
public class EntHighTechPunishInfoServiceImpl extends ServiceImpl<EntHighTechPunishInfoDao, EntHighTechPunishInfoEntity> implements EntHighTechPunishInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EntHighTechPunishInfoEntity> page = this.selectPage(
                new Query<EntHighTechPunishInfoEntity>(params).getPage(),
                new EntityWrapper<EntHighTechPunishInfoEntity>()
        );

        return new PageUtils(page);
    }

}
