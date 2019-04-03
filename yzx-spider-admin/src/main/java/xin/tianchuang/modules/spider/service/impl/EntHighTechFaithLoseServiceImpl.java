package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntHighTechFaithLoseDao;
import xin.tianchuang.modules.spider.entity.EntHighTechFaithLoseEntity;
import xin.tianchuang.modules.spider.service.EntHighTechFaithLoseService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("entHighTechFaithLoseService")
public class EntHighTechFaithLoseServiceImpl extends ServiceImpl<EntHighTechFaithLoseDao, EntHighTechFaithLoseEntity> implements EntHighTechFaithLoseService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EntHighTechFaithLoseEntity> page = this.selectPage(
                new Query<EntHighTechFaithLoseEntity>(params).getPage(),
                new EntityWrapper<EntHighTechFaithLoseEntity>()
        );

        return new PageUtils(page);
    }

}
