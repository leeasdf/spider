package xin.tianchuang.modules.externalApi.qichacha.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;

import xin.tianchuang.modules.externalApi.qichacha.dao.QccBasicSpotCheckDao;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccBasicSpotCheckEntity;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicSpotCheckService;


@Service("qccBasicSpotCheckService")
public class QccBasicSpotCheckServiceImpl extends ServiceImpl<QccBasicSpotCheckDao, QccBasicSpotCheckEntity> implements QccBasicSpotCheckService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QccBasicSpotCheckEntity> page = this.selectPage(
                new Query<QccBasicSpotCheckEntity>(params).getPage(),
                new EntityWrapper<QccBasicSpotCheckEntity>()
        );

        return new PageUtils(page);
    }

}
