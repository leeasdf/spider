package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnSoftwareRightAuthorEntity;

/**
 * 软件著作人详情信息
 *
 * @author hui.deng
 * 
 * @date 2018-09-28 15:43:22
 */
public interface RptTnSoftwareRightAuthorService extends IService<RptTnSoftwareRightAuthorEntity> {

    PageUtils queryPage(Map<String, Object> params);

	List<RptTnSoftwareRightAuthorEntity> selectListByNameCode(String name, String creditCode);

	RptTnSoftwareRightAuthorEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);
}

