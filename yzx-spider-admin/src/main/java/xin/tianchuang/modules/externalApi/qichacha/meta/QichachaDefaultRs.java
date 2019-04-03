package xin.tianchuang.modules.externalApi.qichacha.meta;

/**
 * Created by yp-tc-m-7179 on 2019/1/3.
 */
public class QichachaDefaultRs<T extends ResultObj> extends QichachaRs{
    private T result;

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public T getResult() {
        return result;
    }
}
