package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.OriAdministrativePenaltyEntity;

/**
 * 行政处罚信息(导入)
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:23
 */
public interface OriAdministrativePenaltyService extends IService<OriAdministrativePenaltyEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

