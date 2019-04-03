package xin.tianchuang.modules.externalApi.qichacha.meta;

import xin.tianchuang.modules.externalApi.qichacha.entity.DefaultParam;

/**
 * Created by yp-tc-m-7179 on 2019/1/7.
 */
public class QichachaDefaultRq extends QichachaRq{
    private String url;//请求地址
    private DefaultParam param;//参数  默认 默认参数

    public void setParam(DefaultParam param) {
        this.param = param;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    @Override
    public QichachaParam getParam() {
        return param;
    }
}
