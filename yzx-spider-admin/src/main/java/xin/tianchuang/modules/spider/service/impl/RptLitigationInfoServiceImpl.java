package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptLitigationInfoDao;
import xin.tianchuang.modules.spider.entity.RptLitigationInfoEntity;
import xin.tianchuang.modules.spider.service.RptLitigationInfoService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("rptLitigationInfoService")
public class RptLitigationInfoServiceImpl extends ServiceImpl<RptLitigationInfoDao, RptLitigationInfoEntity> implements RptLitigationInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RptLitigationInfoEntity> page = this.selectPage(
                new Query<RptLitigationInfoEntity>(params).getPage(),
                new EntityWrapper<RptLitigationInfoEntity>()
        );

        return new PageUtils(page);
    }

}
