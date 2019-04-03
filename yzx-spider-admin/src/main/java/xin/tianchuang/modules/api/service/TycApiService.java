package xin.tianchuang.modules.api.service;

import xin.tianchuang.modules.api.bean.api.tyc.biz.BizRequestHeadParamDTO;
import xin.tianchuang.modules.api.bean.api.tyc.biz.BizRequestParamDTO;

public interface TycApiService<T> {

	<T> T queryApi(BizRequestParamDTO param, BizRequestHeadParamDTO head, Class<T> cls) throws Exception;

}
