package xin.tianchuang.modules.externalApi.qichacha.meta;

/**
 * Created by yp-tc-m-7179 on 2019/1/3.
 *
 */
public class QichachaPagingRq extends QichachaRq {

    private PagingParam param;//参数  默认 默认参数

    private String url;//请求地址

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    public PagingParam getParam() {
        return param;
    }

    public void setParam(PagingParam param) {
        this.param = param;
    }

}
