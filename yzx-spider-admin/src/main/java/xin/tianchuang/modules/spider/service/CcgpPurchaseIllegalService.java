package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.CcgpPurchaseIllegalEntity;

import java.util.Map;

/**
 * 中国政府采购网-采购严重违法失信行为记录
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-21 14:10:47
 */
public interface CcgpPurchaseIllegalService extends IService<CcgpPurchaseIllegalEntity> {

    PageUtils queryPage(Map<String, Object> params);

	CcgpPurchaseIllegalEntity selectByCreditCodeDate(String creditCode, String punishDate);
}

