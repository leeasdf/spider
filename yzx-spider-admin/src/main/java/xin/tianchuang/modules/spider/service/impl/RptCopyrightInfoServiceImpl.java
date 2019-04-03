package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptCopyrightInfoDao;
import xin.tianchuang.modules.spider.entity.RptCopyrightInfoEntity;
import xin.tianchuang.modules.spider.service.RptCopyrightInfoService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("rptCopyrightInfoService")
public class RptCopyrightInfoServiceImpl extends ServiceImpl<RptCopyrightInfoDao, RptCopyrightInfoEntity> implements RptCopyrightInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RptCopyrightInfoEntity> page = this.selectPage(
                new Query<RptCopyrightInfoEntity>(params).getPage(),
                new EntityWrapper<RptCopyrightInfoEntity>()
        );

        return new PageUtils(page);
    }

}
