package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.CsSfgwHbtEpinformationDao;
import xin.tianchuang.modules.spider.entity.CsSfgwHbtEpinformationEntity;
import xin.tianchuang.modules.spider.service.CsSfgwHbtEpinformationService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("csSfgwHbtEpinformationService")
public class CsSfgwHbtEpinformationServiceImpl extends ServiceImpl<CsSfgwHbtEpinformationDao, CsSfgwHbtEpinformationEntity> implements CsSfgwHbtEpinformationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CsSfgwHbtEpinformationEntity> page = this.selectPage(
                new Query<CsSfgwHbtEpinformationEntity>(params).getPage(),
                new EntityWrapper<CsSfgwHbtEpinformationEntity>()
        );

        return new PageUtils(page);
    }

}
