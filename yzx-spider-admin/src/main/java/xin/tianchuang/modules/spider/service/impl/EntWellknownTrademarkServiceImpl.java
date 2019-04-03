package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntWellknownTrademarkDao;
import xin.tianchuang.modules.spider.entity.EntWellknownTrademarkEntity;
import xin.tianchuang.modules.spider.service.EntWellknownTrademarkService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("entWellknownTrademarkService")
public class EntWellknownTrademarkServiceImpl extends ServiceImpl<EntWellknownTrademarkDao, EntWellknownTrademarkEntity> implements EntWellknownTrademarkService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EntWellknownTrademarkEntity> page = this.selectPage(
                new Query<EntWellknownTrademarkEntity>(params).getPage(),
                new EntityWrapper<EntWellknownTrademarkEntity>()
        );

        return new PageUtils(page);
    }

}
