package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntIllegalPunishInfoEntity;

/**
 * 市场主体违法行为记录信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:23
 */
public interface EntIllegalPunishInfoService extends IService<EntIllegalPunishInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

