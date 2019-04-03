package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptCaseInfoDao;
import xin.tianchuang.modules.spider.entity.RptCaseInfoEntity;
import xin.tianchuang.modules.spider.service.RptCaseInfoService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("rptCaseInfoService")
public class RptCaseInfoServiceImpl extends ServiceImpl<RptCaseInfoDao, RptCaseInfoEntity> implements RptCaseInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RptCaseInfoEntity> page = this.selectPage(
                new Query<RptCaseInfoEntity>(params).getPage(),
                new EntityWrapper<RptCaseInfoEntity>()
        );

        return new PageUtils(page);
    }

}
