package xin.tianchuang.modules.externalApi.qichacha.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;

import xin.tianchuang.modules.externalApi.qichacha.dao.QccBasicPermissionEciinfoDao;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccBasicPermissionEciinfoEntity;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicPermissionEciinfoService;


@Service("qccBasicPermissionEciinfoService")
public class QccBasicPermissionEciinfoServiceImpl extends ServiceImpl<QccBasicPermissionEciinfoDao, QccBasicPermissionEciinfoEntity> implements QccBasicPermissionEciinfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QccBasicPermissionEciinfoEntity> page = this.selectPage(
                new Query<QccBasicPermissionEciinfoEntity>(params).getPage(),
                new EntityWrapper<QccBasicPermissionEciinfoEntity>()
        );

        return new PageUtils(page);
    }

}
