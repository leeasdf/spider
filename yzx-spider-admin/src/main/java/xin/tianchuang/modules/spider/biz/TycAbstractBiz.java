package xin.tianchuang.modules.spider.biz;

import xin.tianchuang.common.enums.TycDataPageEnum;

public interface TycAbstractBiz {

	void savePageRecord(Long enterpriseId, String name, TycDataPageEnum dataPage, String pageTotal, Integer pageNum);
}
