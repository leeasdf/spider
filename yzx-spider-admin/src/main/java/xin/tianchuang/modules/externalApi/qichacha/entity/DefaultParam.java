package xin.tianchuang.modules.externalApi.qichacha.entity;

import xin.tianchuang.modules.externalApi.qichacha.QichachaUtils;
import xin.tianchuang.modules.externalApi.qichacha.meta.PagingParam;
import xin.tianchuang.modules.externalApi.qichacha.meta.QichachaParam;

/**
 * Created by yp-tc-m-7179 on 2018/12/20.
 *
 */
public class DefaultParam extends QichachaParam{

    private String keyWord;//关键字(公司名或keyNo)

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    @Override
    public String toParamStr() {
        return QichachaUtils.toParamStr(this);
    }

    @Override
    public String getSearchKey() {
        return keyWord;
    }

    @Override
    public void setSearchKey(String searchKey) {
        keyWord = searchKey;
    }
}
