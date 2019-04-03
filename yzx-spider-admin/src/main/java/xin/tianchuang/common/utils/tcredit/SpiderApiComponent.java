package xin.tianchuang.common.utils.tcredit;

import org.jsoup.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 企信平台接口
 *
 * @author idea
 * @version 1.0
 * @since 2018年11月02日 上午10:07
 **/
public class SpiderApiComponent {
    private static Logger logger = LoggerFactory.getLogger(ApiComponent.class);

    private static String appId = "111111";
    private static String tokenId = "a3e33b69c0bae57f3c46a33c27026104";
    private static String baseUrl = "http://localhost:8080/yzx-spider-admin";


    private static String getApiRespInfo(String key, String url, Map<String, String> param, Connection.Method method) {
        param.put("tokenKey", ParamUtil.getTokenKey(url, tokenId, param));
        param.put("appId", appId);
        Connection.Response content = SpiderJsoupUtil.getContent(url, param, null, method);
        logger.info("{}API查询结果：\n", key, content.body());
        return content.body();
    }

    private static String getApiRespInfo(String key, String url, Map<String, String> param, Connection.Method method, String tokenId, String appId) {
        param.put("tokenKey", ParamUtil.getTokenKey(url, tokenId, param));
        param.put("appId", appId);
        Connection.Response content = SpiderJsoupUtil.getContent(url, param, null, method);
        logger.info("{}API查询结果：\n", key, content.body());
        return content.body();
    }

    /**
     * 搜索
     * @param enterpriseName
     * @return
     */

    public static String search(String enterpriseName,String creditcode) {
        String url = baseUrl + "/api/v1/search";
        Map<String, String> param = new HashMap<String, String>();
        param.put("name", enterpriseName);
        return getApiRespInfo(enterpriseName, url, param, Connection.Method.GET);
    }
    /**
     * 查询知识产权
     * @param enterpriseName
     * @return
     */

    public static String getCopyrightWorks(String enterpriseName,String creditcode) {
        String url = baseUrl + "/api/v1/getCopyrightWorks";
        Map<String, String> param = new HashMap<String, String>();
        param.put("name", enterpriseName);
        param.put("creditcode",creditcode);
        return getApiRespInfo(enterpriseName, url, param, Connection.Method.GET);
    }

    /**
     * 查询企业基本信息
     * @param enterpriseName
     * @return
     */
    public static String getGxstBaseInfo(String enterpriseName,String creditcode) {
        String url = baseUrl + "/api/v1/getGxstBaseInfo";
        Map<String, String> param = new HashMap<String, String>();
        param.put("name", enterpriseName);
        param.put("creditcode",creditcode);
        return getApiRespInfo(enterpriseName, url, param, Connection.Method.GET);
    }

    /**
     * 查询主要人员信息
     * @param enterpriseName
     * @return
     */
    public static String getStaff(String enterpriseName,String creditcode) {
        String url = baseUrl + "/api/v1/getStaff";
        Map<String, String> param = new HashMap<String, String>();
        param.put("name", enterpriseName);
        param.put("creditcode",creditcode);
        return getApiRespInfo(enterpriseName, url, param, Connection.Method.GET);
    }

    /**
     * 查询股东信息
     * @param enterpriseName
     * @return
     */
    public static String getHolder(String enterpriseName,String creditcode) {
        String url = baseUrl + "/api/v1/getGxstBaseInfo";
        Map<String, String> param = new HashMap<String, String>();
        param.put("name", enterpriseName);
        param.put("creditcode",creditcode);
        return getApiRespInfo(enterpriseName, url, param, Connection.Method.GET);
    }

    /**
     * 查询对外投资信息
     * @param enterpriseName
     * @return
     */
    public static String getInvest(String enterpriseName,String creditcode) {
        String url = baseUrl + "/api/v1/getInvest";
        Map<String, String> param = new HashMap<String, String>();
        param.put("name", enterpriseName);
        param.put("creditcode",creditcode);
        return getApiRespInfo(enterpriseName, url, param, Connection.Method.GET);
    }

    /**
     * 查询变更信息
     * @param enterpriseName
     * @return
     */
    public static String getChange(String enterpriseName,String creditcode) {
        String url = baseUrl + "/api/v1/getChange";
        Map<String, String> param = new HashMap<String, String>();
        param.put("name", enterpriseName);
        param.put("creditcode",creditcode);
        return getApiRespInfo(enterpriseName, url, param, Connection.Method.GET);
    }

    /**
     * 查询变更信息
     * @param enterpriseName
     * @return
     */
    public static String getBranch(String enterpriseName,String creditcode) {
        String url = baseUrl + "/api/v1/getBranch";
        Map<String, String> param = new HashMap<String, String>();
        param.put("name", enterpriseName);
        param.put("creditcode",creditcode);
        return getApiRespInfo(enterpriseName, url, param, Connection.Method.GET);
    }
    /**
     * 查询商标信息
     * @param enterpriseName
     * @return
     */
    public static String getTmInfo(String enterpriseName,String creditcode) {
        String url = baseUrl + "/api/v1/getTmInfo";
        Map<String, String> param = new HashMap<String, String>();
        param.put("name", enterpriseName);
        param.put("creditcode",creditcode);
        return getApiRespInfo(enterpriseName, url, param, Connection.Method.GET);
    } /**
     * 查询专利
     * @param enterpriseName
     * @return
     */
    public static String getPatent(String enterpriseName,String creditcode) {
        String url = baseUrl + "/api/v1/getPatent";
        Map<String, String> param = new HashMap<String, String>();
        param.put("name", enterpriseName);
        param.put("creditcode",creditcode);
        return getApiRespInfo(enterpriseName, url, param, Connection.Method.GET);
    } /**
     * 查询软件著作信息
     * @param enterpriseName
     * @return
     */
    public static String getCopyright(String enterpriseName,String creditcode) {
        String url = baseUrl + "/api/v1/getCopyright";
        Map<String, String> param = new HashMap<String, String>();
        param.put("name", enterpriseName);
        param.put("creditcode",creditcode);
        return getApiRespInfo(enterpriseName, url, param, Connection.Method.GET);
    }
    /**
     * 查询网络备案
     * @param enterpriseName
     * @return
     */
    public static String getIcp(String enterpriseName,String creditcode) {
        String url = baseUrl + "/api/v1/getIcp";
        Map<String, String> param = new HashMap<String, String>();
        param.put("name", enterpriseName);
        param.put("creditcode",creditcode);
        return getApiRespInfo(enterpriseName, url, param, Connection.Method.GET);
    } /**
     * 查询变更信息
     * @param enterpriseName
     * @return
     */
    public static String getAnnouncement(String enterpriseName,String creditcode) {
        String url = baseUrl + "/api/v1/getAnnouncement";
        Map<String, String> param = new HashMap<String, String>();
        param.put("name", enterpriseName);
        param.put("creditcode",creditcode);
        return getApiRespInfo(enterpriseName, url, param, Connection.Method.GET);
    }
    /**
     * 法律诉讼
     * @param enterpriseName
     * @return
     */
    public static String getLawsuit(String enterpriseName,String creditcode) {
        String url = baseUrl + "/api/v1/getLawsuit";
        Map<String, String> param = new HashMap<String, String>();
        param.put("name", enterpriseName);
        param.put("creditcode",creditcode);
        return getApiRespInfo(enterpriseName, url, param, Connection.Method.GET);
    }
    /**
     * 查询开庭公告信息
     * @param enterpriseName
     * @return
     */
    public static String getCourt(String enterpriseName,String creditcode) {
        String url = baseUrl + "/api/v1/getCourt";
        Map<String, String> param = new HashMap<String, String>();
        param.put("name", enterpriseName);
        param.put("creditcode",creditcode);
        return getApiRespInfo(enterpriseName, url, param, Connection.Method.GET);
    }
}
