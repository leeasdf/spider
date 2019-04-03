package xin.tianchuang.modules.externalApi.qichacha.entity;

import com.alibaba.fastjson.JSONObject;
import xin.tianchuang.modules.externalApi.qichacha.meta.ResultObj;

/**
 * Created by zhuzhengliang on 2019/1/2.
 */
public class SeriousViolation implements ResultObj{

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

    @Override
    public Object getEntity(String data) {
        return JSONObject.parseObject(data,this.getClass());
    }
}
