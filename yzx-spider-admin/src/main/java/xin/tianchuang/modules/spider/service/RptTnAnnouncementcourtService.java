package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnAnnouncementcourtEntity;

/**
 * 作品著作权信息
 *
 * @author hui.deng
 * @email ${email}
 * @date 2018-05-21 16:51:15
 */
public interface RptTnAnnouncementcourtService extends IService<RptTnAnnouncementcourtEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEnteprirseName(String entName);

	List<RptTnAnnouncementcourtEntity> selectListByNameCode(String name, String creditCode);

	RptTnAnnouncementcourtEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);
}

