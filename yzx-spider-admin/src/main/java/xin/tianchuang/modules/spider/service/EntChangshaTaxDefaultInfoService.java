package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntChangshaTaxDefaultInfoEntity;

/**
 * 湖南省长沙税务局欠税信息表
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:24
 */
public interface EntChangshaTaxDefaultInfoService extends IService<EntChangshaTaxDefaultInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

