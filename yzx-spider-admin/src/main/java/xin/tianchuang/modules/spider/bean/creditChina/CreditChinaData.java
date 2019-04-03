package xin.tianchuang.modules.spider.bean.creditChina;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by yp-tc-m-7179 on 2018/10/12.
 */
public class CreditChinaData {

    /**
     * 详情
     */
    private JSONObject creditInfoDetail;
    /**
     * 行政许可
     */
    private JSONArray pubPermissionsName;
    /**
     * 行政处罚
     */
    private JSONArray pubPenaltyName;
    /**
     * 守信红名单
     */
    private JSONArray recordParam2;
    /**
     * 重点关注名单
     */
    private JSONArray recordParam4;
    /**
     * 黑名单
     */
    private JSONArray recordParam8;

    public JSONObject getCreditInfoDetail() {
        return creditInfoDetail;
    }

    public void setCreditInfoDetail(JSONObject creditInfoDetail) {
        this.creditInfoDetail = creditInfoDetail;
    }

    public JSONArray getPubPermissionsName() {
        return pubPermissionsName;
    }

    public void setPubPermissionsName(JSONArray pubPermissionsName) {
        this.pubPermissionsName = pubPermissionsName;
    }

    public JSONArray getPubPenaltyName() {
        return pubPenaltyName;
    }

    public void setPubPenaltyName(JSONArray pubPenaltyName) {
        this.pubPenaltyName = pubPenaltyName;
    }

    public JSONArray getRecordParam2() {
        return recordParam2;
    }

    public void setRecordParam2(JSONArray recordParam2) {
        this.recordParam2 = recordParam2;
    }

    public JSONArray getRecordParam4() {
        return recordParam4;
    }

    public void setRecordParam4(JSONArray recordParam4) {
        this.recordParam4 = recordParam4;
    }

    public JSONArray getRecordParam8() {
        return recordParam8;
    }

    public void setRecordParam8(JSONArray recordParam8) {
        this.recordParam8 = recordParam8;
    }
}
