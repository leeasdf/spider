package xin.tianchuang.modules.api.controller;

import cn.hutool.http.HttpUtil;
import org.junit.Test;
import xin.tianchuang.common.utils.tcredit.ApiComponent;
import xin.tianchuang.common.utils.tcredit.MD5Util;

import java.text.Collator;
import java.util.*;

/**
 * 测试API接口调用
 *
 * @author idea
 * @version 1.0
 * @since 2018年10月31日 上午11:41
 **/
public class ApiCallTest {
    @Test
    public void apiComponentTest(){
        String s = ApiComponent.getCopyrightWorks("天创云征信有限公司");
        System.out.println(s);
    }

    @Test
    public void testGetCopyrightWorks(){
        String contextPath ="http://localhost:8083/yzx-spider-admin";
        String apiPath ="/api/v1/getCopyrightWorks";
        String urerToken = "a3e33b69c0bae57f3c46a33c27026104";
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name","天创云征信有限公司");
        String param = getParamStr(paramMap);
        paramMap.put("appId", "111111");
        String token = MD5Util.md5(contextPath+apiPath+urerToken+param);
        paramMap.put("tokenKey",token);
        String s = HttpUtil.get(contextPath+apiPath,paramMap);
        System.out.println(s);
    }

    // 请求参数 剔除 appId,tokenKey。拼接成字符串。
    public static String getParamStr(Map<String, Object> map) {
        if (null == map) {
            return "";
        }
        // 删除制定元素
        map.remove("appId");
        map.remove("tokenKey");

        if (map.size() == 0) {
            return "";
        }

        // 将Map-key拿出来放入数组并排序
        String[] arr = new String[map.size()];

        Iterator<String> iterator = map.keySet().iterator();
        int i = 0;
        while (iterator.hasNext()) {
            String key = iterator.next();
            arr[i] = key;
            i++;
        }
        getSortedArr(arr);

        StringBuffer paramStr = new StringBuffer();
        for (String s : arr) {
            String value = (String)map.get(s);
            paramStr.append(s).append("=").append(value).append(",");
        }
        String urlRet = paramStr.substring(0, paramStr.length() - 1);
        return urlRet;
    }

    public static String[] getSortedArr(String[] arr) {
        Comparator<Object> comparator = Collator.getInstance(java.util.Locale.US);
        Arrays.sort(arr, comparator);
        return arr;
    }
}
