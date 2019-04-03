package xin.tianchuang.modules.externalApi.qichacha.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;

import xin.tianchuang.modules.externalApi.qichacha.dao.QccBasicChangeRecordsDao;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccBasicChangeRecordsEntity;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicChangeRecordsService;


@Service("qccBasicChangeRecordsService")
public class QccBasicChangeRecordsServiceImpl extends ServiceImpl<QccBasicChangeRecordsDao, QccBasicChangeRecordsEntity> implements QccBasicChangeRecordsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QccBasicChangeRecordsEntity> page = this.selectPage(
                new Query<QccBasicChangeRecordsEntity>(params).getPage(),
                new EntityWrapper<QccBasicChangeRecordsEntity>()
        );

        return new PageUtils(page);
    }

}
