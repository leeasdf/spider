package xin.tianchuang.modules.externalApi.qichacha.entity;

import xin.tianchuang.modules.externalApi.qichacha.QichachaUtils;
import xin.tianchuang.modules.externalApi.qichacha.meta.PagingParam;
import xin.tianchuang.modules.externalApi.qichacha.meta.QichachaParam;

/**
 * Created by zhuzhengliang on 2018/12/21.
 */
public class TradeMarkQuery extends PagingParam {

    private String intCls;//商标类别号

    private String keyword;//申请人名称

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getIntCls() {
        return intCls;
    }

    public void setIntCls(String intCls) {
        this.intCls = intCls;
    }

    @Override
    public String toParamStr() {
        return QichachaUtils.toParamStr(this);
    }

    @Override
    public String getSearchKey() {
        return keyword;
    }

    @Override
    public void setSearchKey(String searchKey) {
        setKeyword(searchKey);
    }
}
