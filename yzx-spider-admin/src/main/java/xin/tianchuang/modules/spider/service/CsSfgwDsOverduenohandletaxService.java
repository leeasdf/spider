package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.CsSfgwDsOverduenohandletaxEntity;

/**
 * 省发改委-逾期未办理税务登记信息(省地税局)
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:18
 */
public interface CsSfgwDsOverduenohandletaxService extends IService<CsSfgwDsOverduenohandletaxEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

