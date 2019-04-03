package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EnterpriseQualificationDao;
import xin.tianchuang.modules.spider.entity.EnterpriseQualificationEntity;
import xin.tianchuang.modules.spider.service.EnterpriseQualificationService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("enterpriseQualificationService")
public class EnterpriseQualificationServiceImpl extends ServiceImpl<EnterpriseQualificationDao, EnterpriseQualificationEntity> implements EnterpriseQualificationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EnterpriseQualificationEntity> page = this.selectPage(
                new Query<EnterpriseQualificationEntity>(params).getPage(),
                new EntityWrapper<EnterpriseQualificationEntity>()
        );

        return new PageUtils(page);
    }

}
