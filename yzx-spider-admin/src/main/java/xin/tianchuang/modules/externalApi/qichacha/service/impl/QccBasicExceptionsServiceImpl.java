package xin.tianchuang.modules.externalApi.qichacha.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;

import xin.tianchuang.modules.externalApi.qichacha.dao.QccBasicExceptionsDao;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccBasicExceptionsEntity;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicExceptionsService;


@Service("qccBasicExceptionsService")
public class QccBasicExceptionsServiceImpl extends ServiceImpl<QccBasicExceptionsDao, QccBasicExceptionsEntity> implements QccBasicExceptionsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QccBasicExceptionsEntity> page = this.selectPage(
                new Query<QccBasicExceptionsEntity>(params).getPage(),
                new EntityWrapper<QccBasicExceptionsEntity>()
        );

        return new PageUtils(page);
    }

}
