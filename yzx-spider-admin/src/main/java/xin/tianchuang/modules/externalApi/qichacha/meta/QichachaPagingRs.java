package xin.tianchuang.modules.externalApi.qichacha.meta;

import xin.tianchuang.modules.externalApi.qichacha.entity.QichachaPaging;

import java.util.List;

/**
 * Created by yp-tc-m-7179 on 2019/1/3.
 *
 */
public class QichachaPagingRs<T extends ResultObj<T>> extends QichachaRs {

    private QichachaPaging paging;

    private List<T> result;

    public QichachaPaging getPaging() {
        return paging;
    }

    public void setPaging(QichachaPaging paging) {
        this.paging = paging;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    @Override
    public List<T> getResult() {
        return result;
    }

}
