package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnImportExportEntity;

/**
 * 进出口信息
 *
 * @author hui.deng
 * @email ${email}
 * @date 2018-05-25 15:21:15
 */
public interface RptTnImportExportService extends IService<RptTnImportExportEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEnteprirseName(String name);

	List<RptTnImportExportEntity> selectListByNameCode(String name, String creditCode);

	RptTnImportExportEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);
}

