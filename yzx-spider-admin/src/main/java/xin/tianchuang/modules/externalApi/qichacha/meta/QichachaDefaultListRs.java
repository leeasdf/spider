package xin.tianchuang.modules.externalApi.qichacha.meta;

import java.util.List;

/**
 * Created by zhuzhengliang on 2019/2/18.
 */
public class QichachaDefaultListRs<T extends ResultObj<T>> extends QichachaRs {

    private List<T> result;

    public void setResult(List<T> result) {
        this.result = result;
    }

    @Override
    public List<T> getResult() {
        return result;
    }

}
