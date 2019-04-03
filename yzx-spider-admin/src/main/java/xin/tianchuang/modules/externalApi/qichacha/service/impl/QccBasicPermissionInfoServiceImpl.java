package xin.tianchuang.modules.externalApi.qichacha.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;

import xin.tianchuang.modules.externalApi.qichacha.dao.QccBasicPermissionInfoDao;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccBasicPermissionInfoEntity;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicPermissionInfoService;


@Service("qccBasicPermissionInfoService")
public class QccBasicPermissionInfoServiceImpl extends ServiceImpl<QccBasicPermissionInfoDao, QccBasicPermissionInfoEntity> implements QccBasicPermissionInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QccBasicPermissionInfoEntity> page = this.selectPage(
                new Query<QccBasicPermissionInfoEntity>(params).getPage(),
                new EntityWrapper<QccBasicPermissionInfoEntity>()
        );

        return new PageUtils(page);
    }

}
