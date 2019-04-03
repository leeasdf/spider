//package xin.tianchuang.modules.spider.biz.impl;
//
//import java.util.List;
//
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Service;
//
//import xin.tianchuang.common.constant.PageConstant;
//import xin.tianchuang.modules.spider.biz.TycAsycBiz;
//import xin.tianchuang.modules.spider.entity.HighTechZoneEnterpriseInfoEntity;
//
//@Service
//public class TycAsycBizImpl implements TycAsycBiz {
//
//	@Override
//	@Async
//	public boolean getTycSpiderEnterpriseListData(Integer fetch, Integer status, String province, String city, String remark, Boolean isAsc) {
//		fetch = fetch <= 0 ? PageConstant.PAGE_FETCH : fetch;
//		status = status < 0 ? 0 : status; // 正常状态
//
//		List<HighTechZoneEnterpriseInfoEntity> enterpriseInfoLs = highTechZoneEnterpriseInfoService.querEnterpriseListByCondition(fetch, status, province, city, remark, isAsc);
//		if (null == enterpriseInfoLs || enterpriseInfoLs.size() <= 0) {
//			logger.info("无可爬取的状态为[{}]企业信息数据", status);
//			return false;
//		}
//		return spiderEnterpriseListData(enterpriseInfoLs);
//	}
//
//}
