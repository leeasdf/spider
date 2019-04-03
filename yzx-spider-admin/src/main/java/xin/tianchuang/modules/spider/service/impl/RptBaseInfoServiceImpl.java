package xin.tianchuang.modules.spider.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.RptBaseInfoDao;
import xin.tianchuang.modules.spider.entity.RptBaseInfoEntity;
import xin.tianchuang.modules.spider.service.RptBaseInfoService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("rptBaseInfoService")
public class RptBaseInfoServiceImpl extends ServiceImpl<RptBaseInfoDao, RptBaseInfoEntity> implements RptBaseInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
    	String entName = (String)params.get("entName");
        Page<RptBaseInfoEntity> page = this.selectPage(
                new Query<RptBaseInfoEntity>(params).getPage(),
                new EntityWrapper<RptBaseInfoEntity>()
                .like(StringUtils.isNotBlank(entName),"ent_name", entName)
        );

        return new PageUtils(page);
    }

}
