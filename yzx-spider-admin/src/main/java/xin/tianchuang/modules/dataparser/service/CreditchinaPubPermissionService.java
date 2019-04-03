package xin.tianchuang.modules.dataparser.service;

import com.baomidou.mybatisplus.service.IService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.dataparser.entity.CreditchinaPubPermissionEntity;

import java.util.Map;

/**
 * 信用中国-行政许可
 *
 * @author hui.deng
 * @email 
 * @date 2018-10-15 15:36:13
 */
public interface CreditchinaPubPermissionService extends IService<CreditchinaPubPermissionEntity> {

    PageUtils queryPage(Map<String, Object> params);

    int deleteByEntName(String entName);

    /**
     * 根据 许可对象(企业名称)分页查询 行政许可 企业名称全匹配
     * @param params
     * @return
     */
    PageUtils queryPageByXkXdr(Map<String, Object> params);
}

