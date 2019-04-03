package xin.tianchuang.modules.externalApi.qichacha.entity;

import xin.tianchuang.modules.externalApi.qichacha.QichachaUtils;
import xin.tianchuang.modules.externalApi.qichacha.meta.QichachaParam;

/**
 * Created by zhuzhengliang on 2019/1/2.
 */
public class SeriousViolationReqParam extends QichachaParam {

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
        return null;
    }

    @Override
    public void setSearchKey(String searchKey) {

    }
}
