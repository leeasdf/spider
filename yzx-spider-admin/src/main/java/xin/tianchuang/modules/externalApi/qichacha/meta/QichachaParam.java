package xin.tianchuang.modules.externalApi.qichacha.meta;

import org.springframework.beans.factory.annotation.Autowired;
import xin.tianchuang.modules.externalApi.Param;
import xin.tianchuang.modules.externalApi.qichacha.config.QichachaApiConfig;

/**
 * Created by yp-tc-m-7179 on 2018/12/19.
 * 企查查参数类，
 */
public abstract class QichachaParam implements Param{

    private String key;//应用APPKEY(应用详细页查询)
//    private String searchKey;//关键字(公司名或keyNo)，有些参数不是这个名字，比如商标查询，所以这个被注释掉了
    private String dtype;//返回数据格式：json或xml，默认json

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    /**
     * 转换为url参数字符串
     * @return
     */
    public abstract String toParamStr();

    /**
     * 由于接口关键字查询时名称不统一，有时候是searchKey，有时候是keyword（商标），自己实现吧
     * @return
     */
    public abstract String getSearchKey();

    /**
     * 由于接口关键字查询时名称不统一，有时候是searchKey，有时候是keyword（商标），自己实现吧
     * @param searchKey
     * @return
     */
    public abstract void setSearchKey(String searchKey);
}
