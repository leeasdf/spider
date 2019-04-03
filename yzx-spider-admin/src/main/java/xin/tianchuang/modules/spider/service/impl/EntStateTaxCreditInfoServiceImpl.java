package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntStateTaxCreditInfoDao;
import xin.tianchuang.modules.spider.entity.EntStateTaxCreditInfoEntity;
import xin.tianchuang.modules.spider.service.EntStateTaxCreditInfoService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("entStateTaxCreditInfoService")
public class EntStateTaxCreditInfoServiceImpl extends ServiceImpl<EntStateTaxCreditInfoDao, EntStateTaxCreditInfoEntity> implements EntStateTaxCreditInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EntStateTaxCreditInfoEntity> page = this.selectPage(
                new Query<EntStateTaxCreditInfoEntity>(params).getPage(),
                new EntityWrapper<EntStateTaxCreditInfoEntity>()
        );

        return new PageUtils(page);
    }

}
