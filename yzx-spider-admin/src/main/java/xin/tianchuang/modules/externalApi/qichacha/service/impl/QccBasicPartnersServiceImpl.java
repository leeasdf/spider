package xin.tianchuang.modules.externalApi.qichacha.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;

import xin.tianchuang.modules.externalApi.qichacha.dao.QccBasicPartnersDao;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccBasicPartnersEntity;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicPartnersService;


@Service("qccBasicPartnersService")
public class QccBasicPartnersServiceImpl extends ServiceImpl<QccBasicPartnersDao, QccBasicPartnersEntity> implements QccBasicPartnersService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QccBasicPartnersEntity> page = this.selectPage(
                new Query<QccBasicPartnersEntity>(params).getPage(),
                new EntityWrapper<QccBasicPartnersEntity>()
        );

        return new PageUtils(page);
    }

}
