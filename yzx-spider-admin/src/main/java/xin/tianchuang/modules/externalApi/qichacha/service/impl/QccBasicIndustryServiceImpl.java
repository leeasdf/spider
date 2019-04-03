package xin.tianchuang.modules.externalApi.qichacha.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;

import xin.tianchuang.modules.externalApi.qichacha.dao.QccBasicIndustryDao;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccBasicIndustryEntity;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicIndustryService;


@Service("qccBasicIndustryService")
public class QccBasicIndustryServiceImpl extends ServiceImpl<QccBasicIndustryDao, QccBasicIndustryEntity> implements QccBasicIndustryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QccBasicIndustryEntity> page = this.selectPage(
                new Query<QccBasicIndustryEntity>(params).getPage(),
                new EntityWrapper<QccBasicIndustryEntity>()
        );

        return new PageUtils(page);
    }

}
