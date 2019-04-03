package xin.tianchuang.modules.externalApi.qichacha.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;

import xin.tianchuang.modules.externalApi.qichacha.dao.QccBasicBranchesDao;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccBasicBranchesEntity;
import xin.tianchuang.modules.externalApi.qichacha.service.QccBasicBranchesService;


@Service("qccBasicBranchesService")
public class QccBasicBranchesServiceImpl extends ServiceImpl<QccBasicBranchesDao, QccBasicBranchesEntity> implements QccBasicBranchesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QccBasicBranchesEntity> page = this.selectPage(
                new Query<QccBasicBranchesEntity>(params).getPage(),
                new EntityWrapper<QccBasicBranchesEntity>()
        );

        return new PageUtils(page);
    }

}
