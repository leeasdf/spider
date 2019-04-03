package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntHighTechFaithLoseEntity;

/**
 * 失信信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:24
 */
public interface EntHighTechFaithLoseService extends IService<EntHighTechFaithLoseEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

