package xin.tianchuang.modules.externalApi.qichacha.entity;

/**
 * Created by yp-tc-m-7179 on 2018/12/19.
 */
public class QichachaPaging {

    private Integer pageSize;

    private Integer pageIndex;

    private Integer totalRecords;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }
}
