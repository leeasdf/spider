package xin.tianchuang.modules.spider.service;

import java.util.List;
import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTcxyCompanyCopyrightEntity;

import com.baomidou.mybatisplus.service.IService;

/**
 * 企业-作品著作权(天创信用)
 *
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:19
 */
public interface RptTcxyCompanyCopyrightService extends IService<RptTcxyCompanyCopyrightEntity> {

	PageUtils queryPage(Map<String, Object> params);

	List<RptTcxyCompanyCopyrightEntity> selectListByNameCode(String name, String creditCode);
}
