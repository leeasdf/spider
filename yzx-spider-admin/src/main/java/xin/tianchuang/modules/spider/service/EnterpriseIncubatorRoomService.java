package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EnterpriseIncubatorRoomEntity;

/**
 * 企业-孵化器信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:17
 */
public interface EnterpriseIncubatorRoomService extends IService<EnterpriseIncubatorRoomEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

