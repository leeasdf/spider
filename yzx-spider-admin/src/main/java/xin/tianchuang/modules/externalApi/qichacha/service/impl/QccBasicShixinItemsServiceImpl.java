package xin.tianchuang.modules.externalApi.qichacha.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;

import xin.tianchuang.modules.externalApi.qichacha.dao.QccBasicShixinItemsDao;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccBasicShixinItemsEntity;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicShixinItemsService;


@Service("qccBasicShixinItemsService")
public class QccBasicShixinItemsServiceImpl extends ServiceImpl<QccBasicShixinItemsDao, QccBasicShixinItemsEntity> implements QccBasicShixinItemsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QccBasicShixinItemsEntity> page = this.selectPage(
                new Query<QccBasicShixinItemsEntity>(params).getPage(),
                new EntityWrapper<QccBasicShixinItemsEntity>()
        );

        return new PageUtils(page);
    }

}
