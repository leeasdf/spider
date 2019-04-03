package xin.tianchuang.modules.externalApi.qichacha.meta;

import xin.tianchuang.modules.externalApi.qichacha.QichachaUtils;

/**
 * Created by yp-tc-m-7179 on 2019/1/3.
 */
public class PagingParam extends QichachaParam{

    private String searchKey;//关键字(公司名或keyNo)
    private Integer pageIndex=1;//页码，默认第1页
    private Integer pageSize = 50;//每页条数，默认10条，最大不超过50条

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    @Override
    public String toParamStr() {
        return QichachaUtils.toParamStr(this);
    }
}
