package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.CsSfgwDsAbnormalusernoticeDao;
import xin.tianchuang.modules.spider.entity.CsSfgwDsAbnormalusernoticeEntity;
import xin.tianchuang.modules.spider.service.CsSfgwDsAbnormalusernoticeService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("csSfgwDsAbnormalusernoticeService")
public class CsSfgwDsAbnormalusernoticeServiceImpl extends ServiceImpl<CsSfgwDsAbnormalusernoticeDao, CsSfgwDsAbnormalusernoticeEntity> implements CsSfgwDsAbnormalusernoticeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CsSfgwDsAbnormalusernoticeEntity> page = this.selectPage(
                new Query<CsSfgwDsAbnormalusernoticeEntity>(params).getPage(),
                new EntityWrapper<CsSfgwDsAbnormalusernoticeEntity>()
        );

        return new PageUtils(page);
    }

}
