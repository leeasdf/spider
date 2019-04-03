package xin.tianchuang.modules.dataparser.service;

import com.baomidou.mybatisplus.service.IService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.dataparser.entity.CreditchinaFocusGszjEntity;

import java.util.Map;

/**
 * 信用中国-重点关注名单-工商总局
 *
 * @author hui.deng
 * @email 
 * @date 2018-10-17 11:01:12
 */
public interface CreditchinaFocusGszjService extends IService<CreditchinaFocusGszjEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 根据企业名称分页查询 重点关注名单-工商总局信息 企业名称全匹配
     * @param params
     * @return
     */
    PageUtils queryPageByEnterpriseName(Map<String, Object> params);
}

