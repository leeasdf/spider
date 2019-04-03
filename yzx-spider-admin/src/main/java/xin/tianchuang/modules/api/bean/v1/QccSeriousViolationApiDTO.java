package xin.tianchuang.modules.api.bean.v1;

/**
 * Created by zhuzhengliang on 2019/1/2.
 */
public class QccSeriousViolationApiDTO {

    /**
     * id
     */
    private Long id;
    /**
     * 企业名称
     */
    private String entName;
    /**
     * 信用代码
     */
    private String creditCode;
    /**
     * 类型
     */
    private String type;
    /**
     * 列入原因
     */
    private String addReason;
    /**
     * 列入时间
     */
    private String addDate;
    /**
     * 列入决定机关
     */
    private String addOffice;
    /**
     * 移除原因
     */
    private String removeReason;
    /**
     * 移除时间
     */
    private String removeDate;
    /**
     * 移除决定机关
     */
    private String removeOffice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddReason() {
        return addReason;
    }

    public void setAddReason(String addReason) {
        this.addReason = addReason;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public String getAddOffice() {
        return addOffice;
    }

    public void setAddOffice(String addOffice) {
        this.addOffice = addOffice;
    }

    public String getRemoveReason() {
        return removeReason;
    }

    public void setRemoveReason(String removeReason) {
        this.removeReason = removeReason;
    }

    public String getRemoveDate() {
        return removeDate;
    }

    public void setRemoveDate(String removeDate) {
        this.removeDate = removeDate;
    }

    public String getRemoveOffice() {
        return removeOffice;
    }

    public void setRemoveOffice(String removeOffice) {
        this.removeOffice = removeOffice;
    }
}
