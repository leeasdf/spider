package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.CsSfgwHbtLicenseDao;
import xin.tianchuang.modules.spider.entity.CsSfgwHbtLicenseEntity;
import xin.tianchuang.modules.spider.service.CsSfgwHbtLicenseService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("csSfgwHbtLicenseService")
public class CsSfgwHbtLicenseServiceImpl extends ServiceImpl<CsSfgwHbtLicenseDao, CsSfgwHbtLicenseEntity> implements CsSfgwHbtLicenseService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CsSfgwHbtLicenseEntity> page = this.selectPage(
                new Query<CsSfgwHbtLicenseEntity>(params).getPage(),
                new EntityWrapper<CsSfgwHbtLicenseEntity>()
        );

        return new PageUtils(page);
    }

}
