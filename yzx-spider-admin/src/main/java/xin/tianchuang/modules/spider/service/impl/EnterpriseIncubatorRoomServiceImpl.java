package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EnterpriseIncubatorRoomDao;
import xin.tianchuang.modules.spider.entity.EnterpriseIncubatorRoomEntity;
import xin.tianchuang.modules.spider.service.EnterpriseIncubatorRoomService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("enterpriseIncubatorRoomService")
public class EnterpriseIncubatorRoomServiceImpl extends ServiceImpl<EnterpriseIncubatorRoomDao, EnterpriseIncubatorRoomEntity> implements EnterpriseIncubatorRoomService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EnterpriseIncubatorRoomEntity> page = this.selectPage(
                new Query<EnterpriseIncubatorRoomEntity>(params).getPage(),
                new EntityWrapper<EnterpriseIncubatorRoomEntity>()
        );

        return new PageUtils(page);
    }

}
