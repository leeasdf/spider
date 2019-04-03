package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.HnEnterpriseInfoDao;
import xin.tianchuang.modules.spider.entity.HnEnterpriseInfoEntity;
import xin.tianchuang.modules.spider.service.HnEnterpriseInfoService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("hnEnterpriseInfoService")
public class HnEnterpriseInfoServiceImpl extends ServiceImpl<HnEnterpriseInfoDao, HnEnterpriseInfoEntity> implements HnEnterpriseInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HnEnterpriseInfoEntity> page = this.selectPage(
                new Query<HnEnterpriseInfoEntity>(params).getPage(),
                new EntityWrapper<HnEnterpriseInfoEntity>()
        );

        return new PageUtils(page);
    }

}
