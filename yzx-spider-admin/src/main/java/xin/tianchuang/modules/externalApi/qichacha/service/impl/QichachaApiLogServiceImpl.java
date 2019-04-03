package xin.tianchuang.modules.externalApi.qichacha.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.externalApi.qichacha.dao.QichachaApiLogDao;
import xin.tianchuang.modules.externalApi.qichacha.entity.QichachaApiLogEntity;
import xin.tianchuang.modules.externalApi.qichacha.service.QichachaApiLogService;


@Service("qichachaApiLogService")
public class QichachaApiLogServiceImpl extends ServiceImpl<QichachaApiLogDao, QichachaApiLogEntity> implements QichachaApiLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QichachaApiLogEntity> page = this.selectPage(
                new Query<QichachaApiLogEntity>(params).getPage(),
                new EntityWrapper<QichachaApiLogEntity>()
        );

        return new PageUtils(page);
    }

}
