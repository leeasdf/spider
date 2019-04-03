package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntChangshaTaxDefaultInfoDao;
import xin.tianchuang.modules.spider.entity.EntChangshaTaxDefaultInfoEntity;
import xin.tianchuang.modules.spider.service.EntChangshaTaxDefaultInfoService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("entChangshaTaxDefaultInfoService")
public class EntChangshaTaxDefaultInfoServiceImpl extends ServiceImpl<EntChangshaTaxDefaultInfoDao, EntChangshaTaxDefaultInfoEntity> implements EntChangshaTaxDefaultInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EntChangshaTaxDefaultInfoEntity> page = this.selectPage(
                new Query<EntChangshaTaxDefaultInfoEntity>(params).getPage(),
                new EntityWrapper<EntChangshaTaxDefaultInfoEntity>()
        );

        return new PageUtils(page);
    }

}
