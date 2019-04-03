package xin.tianchuang.modules.externalApi.qichacha.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;

import xin.tianchuang.modules.externalApi.qichacha.dao.QccBasicZhixingItemsDao;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccBasicZhixingItemsEntity;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicZhixingItemsService;


@Service("qccBasicZhixingItemsService")
public class QccBasicZhixingItemsServiceImpl extends ServiceImpl<QccBasicZhixingItemsDao, QccBasicZhixingItemsEntity> implements QccBasicZhixingItemsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QccBasicZhixingItemsEntity> page = this.selectPage(
                new Query<QccBasicZhixingItemsEntity>(params).getPage(),
                new EntityWrapper<QccBasicZhixingItemsEntity>()
        );

        return new PageUtils(page);
    }

}
