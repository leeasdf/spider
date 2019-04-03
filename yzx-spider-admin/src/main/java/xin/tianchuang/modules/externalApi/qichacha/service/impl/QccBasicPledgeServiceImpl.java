package xin.tianchuang.modules.externalApi.qichacha.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;

import xin.tianchuang.modules.externalApi.qichacha.dao.QccBasicPledgeDao;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccBasicPledgeEntity;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicPledgeService;


@Service("qccBasicPledgeService")
public class QccBasicPledgeServiceImpl extends ServiceImpl<QccBasicPledgeDao, QccBasicPledgeEntity> implements QccBasicPledgeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QccBasicPledgeEntity> page = this.selectPage(
                new Query<QccBasicPledgeEntity>(params).getPage(),
                new EntityWrapper<QccBasicPledgeEntity>()
        );

        return new PageUtils(page);
    }

}
