package xin.tianchuang.modules.spider.biz.impl;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.enums.TycDataPageEnum;
import xin.tianchuang.modules.spider.biz.TycAbstractBiz;
import xin.tianchuang.modules.spider.entity.TycPageRecordEntity;
import xin.tianchuang.modules.spider.service.TycPageRecordService;

/**
 * 天眼查
 * 
 * @author denghui
 *
 */
@Service
public class TycAbstractImpl implements TycAbstractBiz {

	@Autowired
	private TycPageRecordService tycPageRecordService;

	@Override
	public void savePageRecord(Long enterpriseId, String name, TycDataPageEnum dataPage, String pageTotal, Integer pageNum) {
		TycPageRecordEntity record = tycPageRecordService.selectByEnterpriseNameAndDataType(name, dataPage.key());
		Integer total = 0;
		if (StringUtils.isNotBlank(pageTotal)) {
			if (pageTotal.contains("\n")) {
				total = Integer.valueOf(pageTotal.substring(0, pageTotal.indexOf("\n")));
			} else {
				total = Integer.valueOf(pageTotal);
			}
		}
		if (null == record) {
			TycPageRecordEntity dto = new TycPageRecordEntity();
			dto.setBizId(UUID.randomUUID().toString().replace("-", ""));
			dto.setEnterpriseId(enterpriseId);
			dto.setEntName(name);
			dto.setDataType(dataPage.key());
			dto.setPageTotal(total);
			dto.setPageNum(pageNum);
			dto.setStatus(DataStatusEnum.ACTIVE.name());
			tycPageRecordService.insert(dto);
		} else {
			record.setPageTotal(total);
			record.setPageNum(pageNum);
			tycPageRecordService.updateById(record);
		}
	}
}