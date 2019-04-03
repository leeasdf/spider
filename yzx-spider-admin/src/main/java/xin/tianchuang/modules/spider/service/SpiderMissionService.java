package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.SpiderMissionEntity;

import java.util.Map;

/**
 * 爬虫任务
 *
 * @author hui.deng
 * @email 
 * @date 2018-10-17 17:04:27
 */
public interface SpiderMissionService extends IService<SpiderMissionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

