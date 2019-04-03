package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntHunanStateTaxInfoDao;
import xin.tianchuang.modules.spider.entity.EntHunanStateTaxInfoEntity;
import xin.tianchuang.modules.spider.service.EntHunanStateTaxInfoService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("entHunanStateTaxInfoService")
public class EntHunanStateTaxInfoServiceImpl extends ServiceImpl<EntHunanStateTaxInfoDao, EntHunanStateTaxInfoEntity> implements EntHunanStateTaxInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EntHunanStateTaxInfoEntity> page = this.selectPage(
                new Query<EntHunanStateTaxInfoEntity>(params).getPage(),
                new EntityWrapper<EntHunanStateTaxInfoEntity>()
        );

        return new PageUtils(page);
    }

}
