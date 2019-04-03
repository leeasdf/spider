package xin.tianchuang.modules.spider.service;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnEntPersonCmpanyEntity;

import com.baomidou.mybatisplus.service.IService;

/**
 * 所有公司
 *
 * @author hui.deng
 * 
 * @date 2018-09-28 15:43:23
 */
public interface RptTnEntPersonCmpanyService extends IService<RptTnEntPersonCmpanyEntity> {

    PageUtils queryPage(Map<String, Object> params);

}

