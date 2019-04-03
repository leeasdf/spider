package xin.tianchuang.modules.externalApi.qichacha.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.tianchuang.modules.externalApi.qichacha.config.QichachaSecurityConf;
import xin.tianchuang.modules.externalApi.qichacha.entity.QichachaApiLogEntity;
import xin.tianchuang.modules.externalApi.qichacha.entity.QichachaPaging;
import xin.tianchuang.modules.externalApi.qichacha.meta.*;
import xin.tianchuang.modules.externalApi.qichacha.service.QichachaApiLogService;
import xin.tianchuang.modules.externalApi.qichacha.service.QichachaService;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * Created by yp-tc-m-7179 on 2018/12/19.
 */
@Service
public class QichachaServiceImpl implements QichachaService {

    @Resource
    private QichachaSecurityConf qichachaSecurityConf;

    @Resource
    private QichachaApiLogService qichachaApiLogService;

    @Autowired
    private ExecutorService executors;

    @Override
    public <T extends ResultObj<T>> QichachaPagingRs getPagingData(QichachaPagingRq rq, Class<T> clazz) throws Exception {
        String resStr = rqData(rq, "");
        return tranPagingRs(resStr, clazz);
    }

    @Override
    public <T extends ResultObj<T>> QichachaPagingRs getPagingData(QichachaPagingRq rq, Class<T> clazz, String apiName) throws Exception {
        String resStr = rqData(rq, apiName);
        return tranPagingRs(resStr, clazz);
    }

    @Override
    public <T extends ResultObj<T>> QichachaDefaultRs getData(QichachaRq rq, Class<T> clazz, String apiName) throws Exception {
        String resStr = rqData(rq, apiName);
        return tranRs(resStr, clazz);
    }

    @Override
    public <T extends ResultObj<T>> QichachaDefaultListRs getListData(QichachaRq rq, Class<T> clazz, String apiName) throws Exception {
        String resStr = rqData(rq, apiName);
        return tranListRs(resStr, clazz);
    }

    private <T extends ResultObj<T>> QichachaDefaultRs tranRs(String resStr, Class<T> clazz) throws Exception{
        QichachaDefaultRs rs = new QichachaDefaultRs();
        JSONObject entity = JSON.parseObject(resStr);
        rs.setStatus(entity.getString("Status"));
        rs.setMessage(entity.getString("Message"));
        rs.setResult(tranResult(entity.getString("Result"),clazz));
        return rs;
    }

    private <T extends ResultObj<T>> QichachaDefaultListRs tranListRs(String resStr, Class<T> clazz) throws Exception{
        QichachaDefaultListRs rs = new QichachaDefaultListRs();
        JSONObject entity = JSON.parseObject(resStr);
        rs.setStatus(entity.getString("Status"));
        rs.setMessage(entity.getString("Message"));
        rs.setResult(tranResult(entity.getJSONArray("Result"), clazz));
        return rs;
    }

    private String rqData(QichachaRq rq, String apiName) {
        String timespan = String.valueOf(System.currentTimeMillis() / 1000);
        Connection con = Jsoup.connect(rq.getFullUrl());
        con.header("Timespan", timespan);
        con.header("Token", calcToken(timespan));
        try {
            final String resStr = con.ignoreContentType(true).get().body().html();
            executors.execute(new Runnable() {
                @Override
                public void run() {
                    apiLog(rq.getUrl(), resStr, apiName, rq.getParam().getSearchKey());
                }
            });
            return resStr;
        } catch (IOException e) {
            e.printStackTrace();
            executors.execute(new Runnable() {
                @Override
                public void run() {
                    apiLogException(rq.getUrl(), e.getMessage(), apiName, rq.getParam().getSearchKey());
                }
            });
        }
        return null;
    }

    private void apiLogException(String url, String message, String apiName, String searchKey) {
        QichachaApiLogEntity qichachaApiLogEntity = new QichachaApiLogEntity();
        qichachaApiLogEntity.setRs(message);
        qichachaApiLogEntity.setName(apiName);
        qichachaApiLogEntity.setStatus("500");
        qichachaApiLogEntity.setCreateTime(new Date());
        qichachaApiLogEntity.setUrl(url);
        qichachaApiLogEntity.setSearchKey(searchKey);
        qichachaApiLogService.insert(qichachaApiLogEntity);
    }

    private void apiLog(String url, String resStr, String apiName, String searchKey) {
        QichachaApiLogEntity qichachaApiLogEntity = new QichachaApiLogEntity();
        qichachaApiLogEntity.setRs(resStr);
        qichachaApiLogEntity.setName(apiName);
        qichachaApiLogEntity.setStatus(JSON.parseObject(resStr).getString("Status"));
        qichachaApiLogEntity.setCreateTime(new Date());
        qichachaApiLogEntity.setUrl(url);
        qichachaApiLogEntity.setSearchKey(searchKey);
        qichachaApiLogService.insert(qichachaApiLogEntity);
    }

    private String calcToken(String timespan) {
        return DigestUtils.md5Hex(qichachaSecurityConf.getKey() + timespan + qichachaSecurityConf.getSecretKey()).toUpperCase();
    }

    private <T extends ResultObj<T>> QichachaPagingRs tranPagingRs(String resStr, Class<T> clazz) throws Exception {
        QichachaPagingRs rs = new QichachaPagingRs();
        JSONObject entity = JSON.parseObject(resStr);
        rs.setStatus(entity.getString("Status"));
        rs.setMessage(entity.getString("Message"));
        rs.setPaging(tranPaging(entity.getJSONObject("Paging")));
        rs.setResult(tranResult(entity.getJSONArray("Result"), clazz));
        return rs;
    }

    private <T extends ResultObj<T>> List<T> tranResult(JSONArray result, Class<T> clazz) throws Exception {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            list.add(clazz.newInstance().getEntity(result.getJSONObject(i).toJSONString()));
        }
        return list;
    }

    private <T extends ResultObj<T>> T tranResult(String result, Class<T> clazz) throws Exception {
        return clazz.newInstance().getEntity(result);
    }

    private QichachaPaging tranPaging(JSONObject paging) {
        QichachaPaging qichachaPaging = new QichachaPaging();
        qichachaPaging.setPageIndex(paging.getInteger("PageIndex"));
        qichachaPaging.setPageSize(paging.getInteger("PageSize"));
        qichachaPaging.setTotalRecords(paging.getInteger("TotalRecords"));
        return qichachaPaging;
    }


}
