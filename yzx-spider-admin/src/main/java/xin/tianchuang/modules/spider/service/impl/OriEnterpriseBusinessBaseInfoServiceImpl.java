package xin.tianchuang.modules.spider.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.OriEnterpriseBusinessBaseInfoDao;
import xin.tianchuang.modules.spider.entity.OriEnterpriseBusinessBaseInfoEntity;
import xin.tianchuang.modules.spider.service.OriEnterpriseBusinessBaseInfoService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("oriEnterpriseBusinessBaseInfoService")
public class OriEnterpriseBusinessBaseInfoServiceImpl extends ServiceImpl<OriEnterpriseBusinessBaseInfoDao, OriEnterpriseBusinessBaseInfoEntity> implements OriEnterpriseBusinessBaseInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
    	String enterprise_name = (String) params.get("enterprise_name");
        Page<OriEnterpriseBusinessBaseInfoEntity> page = this.selectPage(
                new Query<OriEnterpriseBusinessBaseInfoEntity>(params).getPage(),
                new EntityWrapper<OriEnterpriseBusinessBaseInfoEntity>()
                .like(StringUtils.isNotBlank(enterprise_name), "enterprise_name", enterprise_name)//
				.orderBy("create_time", false) //
        );

        return new PageUtils(page);
    }

}
