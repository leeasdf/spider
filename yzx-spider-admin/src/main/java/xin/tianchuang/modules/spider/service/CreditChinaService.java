package xin.tianchuang.modules.spider.service;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import xin.tianchuang.modules.spider.entity.HighTechZoneEnterpriseInfoEntity;

/**
 * Created by yp-tc-m-7179 on 2018/10/11.
 */
public interface CreditChinaService {

    void crawlData(HighTechZoneEnterpriseInfoEntity enterpriseInfo) throws Throwable;

    void crawlData(String entName) throws Throwable;

    Long selectLatestIdByType(Integer type);

    String getEncryStr(String entName) throws Exception;

    JSONObject getCreditInfoDetail(String encryStr)throws Exception;
    /**
     * 行政许可
     */
    JSONArray getPubPermissionsName(String entName)throws Throwable;
    /**
     * 行政处罚
     */
    JSONArray getPubPenaltyName(String entName)throws Throwable;
    /**
     * 守信红名单
     */
    JSONArray getRecordParam2(String encryStr)throws Throwable;
    /**
     * 重点关注名单
     */
    JSONArray getRecordParam4(String encryStr)throws Throwable;
    /**
     * 黑名单
     */
    JSONArray getRecordParam8(String encryStr)throws Throwable;

}
