package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptFiliationInfoDao;
import xin.tianchuang.modules.spider.entity.RptFiliationInfoEntity;
import xin.tianchuang.modules.spider.service.RptFiliationInfoService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("rptFiliationInfoService")
public class RptFiliationInfoServiceImpl extends ServiceImpl<RptFiliationInfoDao, RptFiliationInfoEntity> implements RptFiliationInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RptFiliationInfoEntity> page = this.selectPage(
                new Query<RptFiliationInfoEntity>(params).getPage(),
                new EntityWrapper<RptFiliationInfoEntity>()
        );

        return new PageUtils(page);
    }

}
