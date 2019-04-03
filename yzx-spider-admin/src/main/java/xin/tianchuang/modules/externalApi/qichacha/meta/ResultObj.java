package xin.tianchuang.modules.externalApi.qichacha.meta;

/**
 * Created by yp-tc-m-7179 on 2018/12/19.
 *
 */
public interface ResultObj<T> {

    /**
     * 将result数据解析后，返回单个实体
     * @return
     */
    public abstract T getEntity(String data);
}
