package xin.tianchuang.modules.spider.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;
import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.modules.spider.bean.creditChina.CreditChinaData;
import xin.tianchuang.modules.spider.dao.SpiderRawDataDao;
import xin.tianchuang.modules.spider.entity.HighTechZoneEnterpriseInfoEntity;
import xin.tianchuang.modules.spider.entity.SpiderRawDataEntity;
import xin.tianchuang.modules.spider.enums.SpiderTypeEnum;
import xin.tianchuang.modules.spider.rabbit.MsgSender;
import xin.tianchuang.modules.spider.service.CreditChinaService;
import xin.tianchuang.modules.spider.service.SpiderRawDataService;

import javax.annotation.Resource;

/**
 * Created by yp-tc-m-7179 on 2018/10/11.
 */
@Service
public class CreditChinaServiceImpl implements CreditChinaService {
    @Resource
    private SpiderRawDataService spiderRawDataService;
    @Resource
    private SpiderRawDataDao spiderRawDataDao;
    @Resource(name = "creditChinaSender")
    private MsgSender msgSender;

    private static final int PAGE_SIZE = 100;
    //企业列表
    private static final String LIST_URL = "https://www.creditchina.gov.cn/api/credit_info_search?templateId=&page=1&pageSize=10&keyword=";
    //详细信息
    private static final String CREDIT_INFO_DETAIL_URL = "https://www.creditchina.gov.cn/api/credit_info_detail?encryStr=";
    //行政许可
    private static final String PUB_PERMISSIONS_NAME = "https://www.creditchina.gov.cn/api/pub_permissions_name?page=%s&pageSize=%s&name=%s";
    //行政处罚
    private static final String PUB_PENALTY_NAME = "https://www.creditchina.gov.cn/api/pub_penalty_name?page=%s&pageSize=%s&name=%s";
    //守信红名单
    private static final String RECORD_PARAM2 = "https://www.creditchina.gov.cn/api/record_param?creditType=2&dataSource=0&pageNum=%s&pageSize=%s&encryStr=%s";
    //重点关注名单
    private static final String RECORD_PARAM4 = "https://www.creditchina.gov.cn/api/record_param?creditType=4&dataSource=0&pageNum=%s&pageSize=%s&encryStr=%s";
    //黑名单
    private static final String RECORD_PARAM8 = "https://www.creditchina.gov.cn/api/record_param?creditType=8&dataSource=0&pageNum=%s&pageSize=%s&encryStr=%s";

    public void crawlData(HighTechZoneEnterpriseInfoEntity enterpriseInfo) throws Throwable {
        try {
            JSONArray jsonArray = JSON.parseObject(Jsoup.connect(LIST_URL + enterpriseInfo.getEnterpriseName()).timeout(5000)
                    .validateTLSCertificates(false)
                    .ignoreContentType(true)
                    .execute().body()).getJSONObject("data").getJSONArray("results");
            //如果队列为空，或者排第一的企业名称没有完全匹配，那么不做任何处理
            if (jsonArray.size() == 0
                    || !jsonArray.getJSONObject(0).getString("name").equalsIgnoreCase(enterpriseInfo.getEnterpriseName()))
                return;
            //爬取数据
            String encryStr = jsonArray.getJSONObject(0).getString("encryStr");
            CreditChinaData creditChinaData = new CreditChinaData();
            //基本信息
            creditChinaData.setCreditInfoDetail(JSON.parseObject(Jsoup.connect(CREDIT_INFO_DETAIL_URL + encryStr).timeout(5000)
                    .validateTLSCertificates(false)
                    .ignoreContentType(true)
                    .execute().body())
                    .getJSONObject("result"));
            //行政许可
            creditChinaData.setPubPermissionsName(webGetPubPermissionsName(enterpriseInfo.getEnterpriseName()));
            //行政处罚
            creditChinaData.setPubPenaltyName(webGetPubPenaltyName(enterpriseInfo.getEnterpriseName()));
            //红名单
            creditChinaData.setRecordParam2(webGetRecordParam(RECORD_PARAM2,encryStr));
            //关注名单
            creditChinaData.setRecordParam4(webGetRecordParam(RECORD_PARAM4,encryStr));
            //黑名单
            creditChinaData.setRecordParam8(webGetRecordParam(RECORD_PARAM8,encryStr));
            SpiderRawDataEntity spiderRawData = new SpiderRawDataEntity();
            spiderRawData.setEntName(enterpriseInfo.getEnterpriseName());
            spiderRawData.setCursorIndex(String.valueOf(enterpriseInfo.getId()));
            spiderRawData.setDataState(DataStatusEnum.ACTIVE.key());
            spiderRawData.setType(SpiderTypeEnum.CREDIT_CHINA.key());
            spiderRawData.setTypeDesc(SpiderTypeEnum.CREDIT_CHINA.desc());
            spiderRawData.setContent(JSON.toJSONString(creditChinaData));
            spiderRawDataService.insert(spiderRawData);
            msgSender.send(spiderRawData);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void crawlData(String entName) throws Throwable {
        try {
            JSONArray jsonArray = JSON.parseObject(Jsoup.connect(LIST_URL + entName).timeout(5000)
                    .validateTLSCertificates(false)
                    .ignoreContentType(true)
                    .execute().body()).getJSONObject("data").getJSONArray("results");
            //如果队列为空，或者排第一的企业名称没有完全匹配，那么不做任何处理
            if (jsonArray.size() == 0
                    || !jsonArray.getJSONObject(0).getString("name").equalsIgnoreCase(entName))
                return;
            //爬取数据
            String encryStr = getEncryStr(entName);
            CreditChinaData creditChinaData = new CreditChinaData();
            //基本信息
            creditChinaData.setCreditInfoDetail(JSON.parseObject(Jsoup.connect(CREDIT_INFO_DETAIL_URL + encryStr).timeout(5000)
                    .validateTLSCertificates(false)
                    .ignoreContentType(true)
                    .execute().body())
                    .getJSONObject("result"));
            //行政许可
            creditChinaData.setPubPermissionsName(webGetPubPermissionsName(entName));
            //行政处罚
            creditChinaData.setPubPenaltyName(webGetPubPenaltyName(entName));
            //红名单
            creditChinaData.setRecordParam2(webGetRecordParam(RECORD_PARAM2,encryStr));
            //关注名单
            creditChinaData.setRecordParam4(webGetRecordParam(RECORD_PARAM4,encryStr));
            //黑名单
            creditChinaData.setRecordParam8(webGetRecordParam(RECORD_PARAM8,encryStr));
            SpiderRawDataEntity spiderRawData = new SpiderRawDataEntity();
            spiderRawData.setEntName(entName);
            spiderRawData.setCursorIndex(String.valueOf(entName));
            spiderRawData.setDataState(DataStatusEnum.ACTIVE.key());
            spiderRawData.setType(SpiderTypeEnum.CREDIT_CHINA.key());
            spiderRawData.setTypeDesc(SpiderTypeEnum.CREDIT_CHINA.desc());
            spiderRawData.setContent(JSON.toJSONString(creditChinaData));
            spiderRawDataService.insert(spiderRawData);
            msgSender.send(spiderRawData);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private JSONArray webGetRecordParam(String url,String encryStr) throws Throwable{
        JSONObject page1 = JSON.parseObject(Jsoup.connect(String.format(url, 1, PAGE_SIZE, encryStr)).timeout(5000)
                .validateTLSCertificates(false)
                .ignoreContentType(true)
                .execute().body());
        JSONArray results = page1.getJSONArray("result");
        int pageNum = page1.getIntValue("totalCount") / page1.getIntValue("pageSize");
        if (pageNum > 0) {
            pageNum++;
            for (int i = 2; i <= pageNum; i++) {
                results.addAll(JSON.parseObject(Jsoup.connect(String.format(url, i, PAGE_SIZE, encryStr)).timeout(5000)
                        .validateTLSCertificates(false)
                        .ignoreContentType(true)
                        .execute().body())
                        .getJSONArray("result"));
            }
        }
        return results;
    }

    private JSONArray webGetPubPenaltyName(String entName) throws Throwable {
        JSONObject page1 = JSON.parseObject(Jsoup.connect(String.format(PUB_PENALTY_NAME, 1, PAGE_SIZE, entName)).timeout(5000)
                .validateTLSCertificates(false)
                .ignoreContentType(true)
                .execute().body())
                .getJSONObject("result");
        JSONArray results = page1.getJSONArray("results");
        int pageNum = page1.getIntValue("totalCount") / page1.getIntValue("pageSize");
        if (pageNum > 0) {
            pageNum++;
            for (int i = 2; i <= pageNum; i++) {
                results.addAll(JSON.parseObject(Jsoup.connect(String.format(PUB_PENALTY_NAME, i, PAGE_SIZE, entName)).timeout(5000)
                        .validateTLSCertificates(false)
                        .ignoreContentType(true)
                        .execute().body())
                        .getJSONObject("result").getJSONArray("results"));
            }
        }
        return results;
    }

    private JSONArray webGetPubPermissionsName(String entName) throws Throwable {
        JSONObject page1 = JSON.parseObject(Jsoup.connect(String.format(PUB_PERMISSIONS_NAME, 1, PAGE_SIZE, entName)).timeout(5000)
                .validateTLSCertificates(false)
                .ignoreContentType(true)
                .execute().body())
                .getJSONObject("result");
        JSONArray results = page1.getJSONArray("results");
        int pageNum = page1.getIntValue("totalCount") / page1.getIntValue("pageSize");
        if (pageNum > 0) {
            pageNum++;
            for (int i = 2; i <= pageNum; i++) {
                results.addAll(JSON.parseObject(Jsoup.connect(String.format(PUB_PERMISSIONS_NAME, i, PAGE_SIZE, entName)).timeout(5000)
                        .validateTLSCertificates(false)
                        .ignoreContentType(true)
                        .execute().body())
                        .getJSONObject("result").getJSONArray("results"));
            }
        }
        return results;

    }


    public Long selectLatestIdByType(Integer type) {
        SpiderRawDataEntity spiderRawDataEntity = spiderRawDataDao.selectLatestCreditChinaData(type);
        if (spiderRawDataEntity == null) return -1L;
        return Long.valueOf(spiderRawDataEntity.getCursorIndex());
    }

    @Override
    public String getEncryStr(String entName) throws Exception {
        JSONArray jsonArray = JSON.parseObject(Jsoup.connect(LIST_URL + entName).timeout(5000)
                .validateTLSCertificates(false)
                .ignoreContentType(true)
                .execute().body()).getJSONObject("data").getJSONArray("results");
        //如果队列为空，或者排第一的企业名称没有完全匹配，那么不做任何处理
        if (jsonArray.size() == 0
                || !jsonArray.getJSONObject(0).getString("name").equalsIgnoreCase(entName))
            return null;
        //爬取数据
        return jsonArray.getJSONObject(0).getString("encryStr");
    }

    @Override
    public JSONObject getCreditInfoDetail(String encryStr) throws Exception {
        return JSON.parseObject(Jsoup.connect(CREDIT_INFO_DETAIL_URL + encryStr).timeout(5000)
                .validateTLSCertificates(false)
                .ignoreContentType(true)
                .execute().body())
                .getJSONObject("result");
    }

    @Override
    public JSONArray getPubPermissionsName(String entName) throws Throwable {
        return webGetPubPermissionsName(entName);
    }

    @Override
    public JSONArray getPubPenaltyName(String entName) throws Throwable {
        return webGetPubPenaltyName(entName);
    }

    @Override
    public JSONArray getRecordParam2(String encryStr) throws Throwable {
        return webGetRecordParam(RECORD_PARAM2,encryStr);
    }

    @Override
    public JSONArray getRecordParam4(String encryStr) throws Throwable {
        return webGetRecordParam(RECORD_PARAM4,encryStr);
    }

    @Override
    public JSONArray getRecordParam8(String encryStr) throws Throwable {
        return webGetRecordParam(RECORD_PARAM8,encryStr);
    }


}
