package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.HnaicMarkInfoEntity;

import java.util.Map;

/**
 *  湖南省工商局-商标公告
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-18 09:09:38
 */
public interface HnaicMarkInfoService extends IService<HnaicMarkInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

	HnaicMarkInfoEntity selectByMarkId(String markId);
}

