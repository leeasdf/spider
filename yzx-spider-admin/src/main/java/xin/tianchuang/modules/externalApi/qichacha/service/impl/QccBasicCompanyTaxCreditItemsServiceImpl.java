package xin.tianchuang.modules.externalApi.qichacha.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;

import xin.tianchuang.modules.externalApi.qichacha.dao.QccBasicCompanyTaxCreditItemsDao;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccBasicCompanyTaxCreditItemsEntity;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicCompanyTaxCreditItemsService;


@Service("qccBasicCompanyTaxCreditItemsService")
public class QccBasicCompanyTaxCreditItemsServiceImpl extends ServiceImpl<QccBasicCompanyTaxCreditItemsDao, QccBasicCompanyTaxCreditItemsEntity> implements QccBasicCompanyTaxCreditItemsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QccBasicCompanyTaxCreditItemsEntity> page = this.selectPage(
                new Query<QccBasicCompanyTaxCreditItemsEntity>(params).getPage(),
                new EntityWrapper<QccBasicCompanyTaxCreditItemsEntity>()
        );

        return new PageUtils(page);
    }

}
