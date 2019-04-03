package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.CsSfgwAicInvestordocumentDao;
import xin.tianchuang.modules.spider.entity.CsSfgwAicInvestordocumentEntity;
import xin.tianchuang.modules.spider.service.CsSfgwAicInvestordocumentService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("csSfgwAicInvestordocumentService")
public class CsSfgwAicInvestordocumentServiceImpl extends ServiceImpl<CsSfgwAicInvestordocumentDao, CsSfgwAicInvestordocumentEntity> implements CsSfgwAicInvestordocumentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CsSfgwAicInvestordocumentEntity> page = this.selectPage(
                new Query<CsSfgwAicInvestordocumentEntity>(params).getPage(),
                new EntityWrapper<CsSfgwAicInvestordocumentEntity>()
        );

        return new PageUtils(page);
    }

}
