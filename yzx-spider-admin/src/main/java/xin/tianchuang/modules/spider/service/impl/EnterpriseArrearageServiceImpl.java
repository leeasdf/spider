package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EnterpriseArrearageDao;
import xin.tianchuang.modules.spider.entity.EnterpriseArrearageEntity;
import xin.tianchuang.modules.spider.service.EnterpriseArrearageService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("enterpriseArrearageService")
public class EnterpriseArrearageServiceImpl extends ServiceImpl<EnterpriseArrearageDao, EnterpriseArrearageEntity> implements EnterpriseArrearageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EnterpriseArrearageEntity> page = this.selectPage(
                new Query<EnterpriseArrearageEntity>(params).getPage(),
                new EntityWrapper<EnterpriseArrearageEntity>()
        );

        return new PageUtils(page);
    }

}
