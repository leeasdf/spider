package xin.tianchuang.modules.externalApi.qichacha.meta;

import xin.tianchuang.modules.externalApi.qichacha.QichachaUtils;

/**
 * Created by zhuzhengliang on 2019/1/2.
 */
public class SeriousViolationParam extends QichachaParam {

    private String keyword;//申请人名称

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
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
