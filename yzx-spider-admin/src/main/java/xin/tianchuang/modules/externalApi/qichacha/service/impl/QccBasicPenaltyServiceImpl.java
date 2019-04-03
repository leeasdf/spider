package xin.tianchuang.modules.externalApi.qichacha.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;

import xin.tianchuang.modules.externalApi.qichacha.dao.QccBasicPenaltyDao;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccBasicPenaltyEntity;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicPenaltyService;


@Service("qccBasicPenaltyService")
public class QccBasicPenaltyServiceImpl extends ServiceImpl<QccBasicPenaltyDao, QccBasicPenaltyEntity> implements QccBasicPenaltyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QccBasicPenaltyEntity> page = this.selectPage(
                new Query<QccBasicPenaltyEntity>(params).getPage(),
                new EntityWrapper<QccBasicPenaltyEntity>()
        );

        return new PageUtils(page);
    }

}
