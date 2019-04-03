package xin.tianchuang.modules.externalApi.qichacha.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;

import xin.tianchuang.modules.externalApi.qichacha.dao.QccBasicMPledgeDao;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccBasicMPledgeEntity;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicMPledgeService;


@Service("qccBasicMPledgeService")
public class QccBasicMPledgeServiceImpl extends ServiceImpl<QccBasicMPledgeDao, QccBasicMPledgeEntity> implements QccBasicMPledgeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QccBasicMPledgeEntity> page = this.selectPage(
                new Query<QccBasicMPledgeEntity>(params).getPage(),
                new EntityWrapper<QccBasicMPledgeEntity>()
        );

        return new PageUtils(page);
    }

}
