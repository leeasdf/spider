package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntHighTechProjectApprovalDao;
import xin.tianchuang.modules.spider.entity.EntHighTechProjectApprovalEntity;
import xin.tianchuang.modules.spider.service.EntHighTechProjectApprovalService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("entHighTechProjectApprovalService")
public class EntHighTechProjectApprovalServiceImpl extends ServiceImpl<EntHighTechProjectApprovalDao, EntHighTechProjectApprovalEntity> implements EntHighTechProjectApprovalService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EntHighTechProjectApprovalEntity> page = this.selectPage(
                new Query<EntHighTechProjectApprovalEntity>(params).getPage(),
                new EntityWrapper<EntHighTechProjectApprovalEntity>()
        );

        return new PageUtils(page);
    }

}
