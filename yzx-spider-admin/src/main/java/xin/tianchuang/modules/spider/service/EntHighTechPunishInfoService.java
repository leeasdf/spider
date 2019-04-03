package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntHighTechPunishInfoEntity;

/**
 * 双公示-行政处罚
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:23
 */
public interface EntHighTechPunishInfoService extends IService<EntHighTechPunishInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

