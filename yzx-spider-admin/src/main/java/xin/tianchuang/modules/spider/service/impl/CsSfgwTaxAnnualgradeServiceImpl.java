package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.CsSfgwTaxAnnualgradeDao;
import xin.tianchuang.modules.spider.entity.CsSfgwTaxAnnualgradeEntity;
import xin.tianchuang.modules.spider.service.CsSfgwTaxAnnualgradeService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("csSfgwTaxAnnualgradeService")
public class CsSfgwTaxAnnualgradeServiceImpl extends ServiceImpl<CsSfgwTaxAnnualgradeDao, CsSfgwTaxAnnualgradeEntity> implements CsSfgwTaxAnnualgradeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CsSfgwTaxAnnualgradeEntity> page = this.selectPage(
                new Query<CsSfgwTaxAnnualgradeEntity>(params).getPage(),
                new EntityWrapper<CsSfgwTaxAnnualgradeEntity>()
        );

        return new PageUtils(page);
    }

}
