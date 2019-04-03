package xin.tianchuang.modules.externalApi.qichacha.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;

import xin.tianchuang.modules.externalApi.qichacha.dao.QccBasicCompanyProductsDao;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccBasicCompanyProductsEntity;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicCompanyProductsService;


@Service("qccBasicCompanyProductsService")
public class QccBasicCompanyProductsServiceImpl extends ServiceImpl<QccBasicCompanyProductsDao, QccBasicCompanyProductsEntity> implements QccBasicCompanyProductsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QccBasicCompanyProductsEntity> page = this.selectPage(
                new Query<QccBasicCompanyProductsEntity>(params).getPage(),
                new EntityWrapper<QccBasicCompanyProductsEntity>()
        );

        return new PageUtils(page);
    }

}
