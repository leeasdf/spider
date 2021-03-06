package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnCourtNoticeEntity;

/**
 * 法院公告信息
 *
 * @author hui.deng
 * @email ${email}
 * @date 2018-05-21 16:51:16
 */
public interface RptTnCourtNoticeService extends IService<RptTnCourtNoticeEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEnteprirseName(String entName);

	List<RptTnCourtNoticeEntity> selectListByNameCode(String name, String creditCode);

	RptTnCourtNoticeEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);
}

