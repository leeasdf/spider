package xin.tianchuang.modules.externalApi.qichacha.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;

import xin.tianchuang.modules.externalApi.qichacha.dao.QccBasicLiquidationDao;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccBasicLiquidationEntity;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicLiquidationService;


@Service("qccBasicLiquidationService")
public class QccBasicLiquidationServiceImpl extends ServiceImpl<QccBasicLiquidationDao, QccBasicLiquidationEntity> implements QccBasicLiquidationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QccBasicLiquidationEntity> page = this.selectPage(
                new Query<QccBasicLiquidationEntity>(params).getPage(),
                new EntityWrapper<QccBasicLiquidationEntity>()
        );

        return new PageUtils(page);
    }

}
