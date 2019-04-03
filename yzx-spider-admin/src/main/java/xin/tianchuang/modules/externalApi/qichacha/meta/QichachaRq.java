package xin.tianchuang.modules.externalApi.qichacha.meta;

import xin.tianchuang.modules.externalApi.Rq;

/**
 * Created by yp-tc-m-7179 on 2018/12/19.
 */
public abstract class QichachaRq implements Rq {


    public abstract QichachaParam getParam();

    public abstract String getUrl() ;

    public abstract void setUrl(String url) ;

    public String getFullUrl() {
        return getUrl() + (getParam() != null ? getParam().toParamStr() : "");
    }
}
