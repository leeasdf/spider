package xin.tianchuang.modules.spider.service;

import java.util.List;
import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTcxyCompanySoftwareCopyrightEntity;

import com.baomidou.mybatisplus.service.IService;

/**
 * 企业-软件著作权(天创信用)
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:18
 */
public interface RptTcxyCompanySoftwareCopyrightService extends IService<RptTcxyCompanySoftwareCopyrightEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<RptTcxyCompanySoftwareCopyrightEntity> selectListByNameCode(String name, String creditCode);
}

