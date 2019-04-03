package xin.tianchuang.modules.externalApi.qichacha.service;

import xin.tianchuang.modules.externalApi.qichacha.meta.*;

/**
 * Created by yp-tc-m-7179 on 2018/12/19.Ø
 */
public interface QichachaService {

    <T extends ResultObj<T>> QichachaPagingRs getPagingData(QichachaPagingRq rq, Class<T> clazz)throws Exception;

    <T extends ResultObj<T>> QichachaPagingRs getPagingData(QichachaPagingRq rq, Class<T> clazz, String apiName)throws Exception;

    <T extends ResultObj<T>> QichachaDefaultRs getData(QichachaRq rq, Class<T> clazz, String apiName)throws Exception;

    <T extends ResultObj<T>> QichachaDefaultListRs getListData(QichachaRq rq, Class<T> clazz, String apiName)throws Exception;

}
