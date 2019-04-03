package xin.tianchuang.modules.spider.service;

import java.util.List;
import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTcxyPatentBaseEntity;

import com.baomidou.mybatisplus.service.IService;

/**
 * 企业-专利信息（天创信用)
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:18
 */
public interface RptTcxyPatentBaseService extends IService<RptTcxyPatentBaseEntity> {

    PageUtils queryPage(Map<String, Object> params);

	List<RptTcxyPatentBaseEntity> selectListByNameCode(String name, String creditCode);
}

