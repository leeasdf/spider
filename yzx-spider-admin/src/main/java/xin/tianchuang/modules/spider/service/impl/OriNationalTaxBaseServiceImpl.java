package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.OriNationalTaxBaseDao;
import xin.tianchuang.modules.spider.entity.OriNationalTaxBaseEntity;
import xin.tianchuang.modules.spider.service.OriNationalTaxBaseService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("oriNationalTaxBaseService")
public class OriNationalTaxBaseServiceImpl extends ServiceImpl<OriNationalTaxBaseDao, OriNationalTaxBaseEntity> implements OriNationalTaxBaseService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OriNationalTaxBaseEntity> page = this.selectPage(
                new Query<OriNationalTaxBaseEntity>(params).getPage(),
                new EntityWrapper<OriNationalTaxBaseEntity>()
        );

        return new PageUtils(page);
    }

}
