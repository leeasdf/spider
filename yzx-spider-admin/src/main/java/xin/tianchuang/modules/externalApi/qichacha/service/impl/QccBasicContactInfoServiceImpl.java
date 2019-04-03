package xin.tianchuang.modules.externalApi.qichacha.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;

import xin.tianchuang.modules.externalApi.qichacha.dao.QccBasicContactInfoDao;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccBasicContactInfoEntity;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicContactInfoService;


@Service("qccBasicContactInfoService")
public class QccBasicContactInfoServiceImpl extends ServiceImpl<QccBasicContactInfoDao, QccBasicContactInfoEntity> implements QccBasicContactInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QccBasicContactInfoEntity> page = this.selectPage(
                new Query<QccBasicContactInfoEntity>(params).getPage(),
                new EntityWrapper<QccBasicContactInfoEntity>()
        );

        return new PageUtils(page);
    }

}
