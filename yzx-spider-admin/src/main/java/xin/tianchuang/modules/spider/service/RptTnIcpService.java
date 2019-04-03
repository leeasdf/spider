package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnIcpEntity;

/**
 * 网站备案信息
 *
 * @author hui.deng
 * @email ${email}
 * @date 2018-05-21 16:51:15
 */
public interface RptTnIcpService extends IService<RptTnIcpEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEnteprirseName(String name);

	List<RptTnIcpEntity> selectListByNameCode(String name, String creditCode);

	RptTnIcpEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);
}

