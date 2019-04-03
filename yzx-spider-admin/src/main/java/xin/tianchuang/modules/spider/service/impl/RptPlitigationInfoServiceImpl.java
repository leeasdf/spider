package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptPlitigationInfoDao;
import xin.tianchuang.modules.spider.entity.RptPlitigationInfoEntity;
import xin.tianchuang.modules.spider.service.RptPlitigationInfoService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("rptPlitigationInfoService")
public class RptPlitigationInfoServiceImpl extends ServiceImpl<RptPlitigationInfoDao, RptPlitigationInfoEntity> implements RptPlitigationInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RptPlitigationInfoEntity> page = this.selectPage(
                new Query<RptPlitigationInfoEntity>(params).getPage(),
                new EntityWrapper<RptPlitigationInfoEntity>()
        );

        return new PageUtils(page);
    }

}
