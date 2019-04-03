package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntIllegalPunishInfoDao;
import xin.tianchuang.modules.spider.entity.EntIllegalPunishInfoEntity;
import xin.tianchuang.modules.spider.service.EntIllegalPunishInfoService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("entIllegalPunishInfoService")
public class EntIllegalPunishInfoServiceImpl extends ServiceImpl<EntIllegalPunishInfoDao, EntIllegalPunishInfoEntity> implements EntIllegalPunishInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EntIllegalPunishInfoEntity> page = this.selectPage(
                new Query<EntIllegalPunishInfoEntity>(params).getPage(),
                new EntityWrapper<EntIllegalPunishInfoEntity>()
        );

        return new PageUtils(page);
    }

}
