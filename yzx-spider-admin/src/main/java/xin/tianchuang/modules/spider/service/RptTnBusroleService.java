package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnBusroleEntity;

/**
 * 商业角色
 *
 * @author hui.deng
 * 
 * @date 2018-09-28 15:43:23
 */
public interface RptTnBusroleService extends IService<RptTnBusroleEntity> {

    PageUtils queryPage(Map<String, Object> params);

}

