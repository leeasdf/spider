package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.HnEntEnvCreditEntity;

import java.util.Map;

/**
 *  湖南省企业环境信用评价信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-12 12:12:48
 */
public interface HnEntEnvCreditService extends IService<HnEntEnvCreditEntity> {

    PageUtils queryPage(Map<String, Object> params);

	HnEntEnvCreditEntity selectByOne(HnEntEnvCreditEntity entity, String years);
}

