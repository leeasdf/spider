package xin.tianchuang.modules.externalApi.qichacha.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;

import xin.tianchuang.modules.externalApi.qichacha.dao.QccBasicEmployeesDao;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccBasicEmployeesEntity;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicEmployeesService;


@Service("qccBasicEmployeesService")
public class QccBasicEmployeesServiceImpl extends ServiceImpl<QccBasicEmployeesDao, QccBasicEmployeesEntity> implements QccBasicEmployeesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QccBasicEmployeesEntity> page = this.selectPage(
                new Query<QccBasicEmployeesEntity>(params).getPage(),
                new EntityWrapper<QccBasicEmployeesEntity>()
        );

        return new PageUtils(page);
    }

}
