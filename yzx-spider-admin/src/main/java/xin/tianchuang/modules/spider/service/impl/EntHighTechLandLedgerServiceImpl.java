package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntHighTechLandLedgerDao;
import xin.tianchuang.modules.spider.entity.EntHighTechLandLedgerEntity;
import xin.tianchuang.modules.spider.service.EntHighTechLandLedgerService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("entHighTechLandLedgerService")
public class EntHighTechLandLedgerServiceImpl extends ServiceImpl<EntHighTechLandLedgerDao, EntHighTechLandLedgerEntity> implements EntHighTechLandLedgerService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EntHighTechLandLedgerEntity> page = this.selectPage(
                new Query<EntHighTechLandLedgerEntity>(params).getPage(),
                new EntityWrapper<EntHighTechLandLedgerEntity>()
        );

        return new PageUtils(page);
    }

}
