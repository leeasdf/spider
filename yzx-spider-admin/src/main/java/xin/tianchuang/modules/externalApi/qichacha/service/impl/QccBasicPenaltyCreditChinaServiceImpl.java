package xin.tianchuang.modules.externalApi.qichacha.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;

import xin.tianchuang.modules.externalApi.qichacha.dao.QccBasicPenaltyCreditChinaDao;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccBasicPenaltyCreditChinaEntity;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicPenaltyCreditChinaService;


@Service("qccBasicPenaltyCreditChinaService")
public class QccBasicPenaltyCreditChinaServiceImpl extends ServiceImpl<QccBasicPenaltyCreditChinaDao, QccBasicPenaltyCreditChinaEntity> implements QccBasicPenaltyCreditChinaService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QccBasicPenaltyCreditChinaEntity> page = this.selectPage(
                new Query<QccBasicPenaltyCreditChinaEntity>(params).getPage(),
                new EntityWrapper<QccBasicPenaltyCreditChinaEntity>()
        );

        return new PageUtils(page);
    }

}
