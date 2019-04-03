package xin.tianchuang.modules.externalApi.qichacha.meta;

/**
 * Created by zhuzhengliang on 2019/1/2.
 */
public class SeriousViolationReqParam extends QichachaRq {

    private SeriousViolationParam param;//参数  默认 默认参数

    public SeriousViolationParam getParam() {
        return param;
    }

    private String url;//请求地址

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public void setUrl(String url) {
       this.url=url;
    }

    public void setParam(SeriousViolationParam param) {
        this.param = param;
    }

}
