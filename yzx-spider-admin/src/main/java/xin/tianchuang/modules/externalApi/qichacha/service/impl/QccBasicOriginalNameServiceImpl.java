package xin.tianchuang.modules.externalApi.qichacha.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;

import xin.tianchuang.modules.externalApi.qichacha.dao.QccBasicOriginalNameDao;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccBasicOriginalNameEntity;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicOriginalNameService;


@Service("qccBasicOriginalNameService")
public class QccBasicOriginalNameServiceImpl extends ServiceImpl<QccBasicOriginalNameDao, QccBasicOriginalNameEntity> implements QccBasicOriginalNameService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QccBasicOriginalNameEntity> page = this.selectPage(
                new Query<QccBasicOriginalNameEntity>(params).getPage(),
                new EntityWrapper<QccBasicOriginalNameEntity>()
        );

        return new PageUtils(page);
    }

}
