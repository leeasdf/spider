package xin.tianchuang.modules.externalApi.qichacha;

import cn.hutool.core.map.MapUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xin.tianchuang.common.component.spring.SpringContextUtils;
import xin.tianchuang.modules.externalApi.qichacha.config.QichachaApiConfig;
import xin.tianchuang.modules.externalApi.qichacha.config.QichachaSecurityConf;
import xin.tianchuang.modules.externalApi.qichacha.entity.DefaultParam;
import xin.tianchuang.modules.externalApi.qichacha.meta.PagingParam;
import xin.tianchuang.modules.externalApi.qichacha.meta.QichachaDefaultRq;
import xin.tianchuang.modules.externalApi.qichacha.meta.QichachaPagingRq;
import xin.tianchuang.modules.externalApi.qichacha.meta.QichachaParam;
import xin.tianchuang.modules.externalApi.qichacha.meta.*;

import java.lang.reflect.Field;
import java.util.*;


/**
 * Created by yp-tc-m-7179 on 2018/12/20.
 */
public class QichachaUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(QichachaUtils.class);

    public static String toParamStr(QichachaParam param) {
        StringBuilder sb = new StringBuilder("?");

        //循环获取所以父类属性上的值
        List<Field> fieldList = new ArrayList<>();
        Class tempClass = param.getClass();
        while (tempClass != null) {//当父类为null的时候说明到达了最上层的父类(Object类).
            fieldList.addAll(Arrays.asList(tempClass.getDeclaredFields()));
            tempClass = tempClass.getSuperclass(); //得到父类,然后赋给自己
        }
        //之所以写get  不写 getString 是当他是个对象的时候可以去获得对象 调用对象的tostring 方法获得属性值 这样只要重写toString方法即可
        for (Field field : fieldList) {
            field.setAccessible(true);
            try {
                if (null != field.get(param)) {//不为null
                    sb.append(field.getName()).append("=").append(field.get(param).toString()).append("&");
                }
            } catch (Exception e) {
                LOGGER.error("参数组装错误", e);
                e.printStackTrace();
            }
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    public static QichachaDefaultRq newDefaultRq() {
        QichachaDefaultRq rq = new QichachaDefaultRq();
        DefaultParam defaultParam = new DefaultParam();
        QichachaSecurityConf securityConf = SpringContextUtils.getBean("qichachaSecurityConf", QichachaSecurityConf.class);
        defaultParam.setKey(securityConf.getKey());
        rq.setParam(defaultParam);
        return rq;
    }

    public static QichachaPagingRq newPagingRq() {
        QichachaPagingRq rq = new QichachaPagingRq();
        PagingParam pagingParam = new PagingParam();
        QichachaApiConfig config = SpringContextUtils.getBean("qichachaApiConfig", QichachaApiConfig.class);
        QichachaSecurityConf securityConf = SpringContextUtils.getBean("qichachaSecurityConf", QichachaSecurityConf.class);
        pagingParam.setPageSize(config.getPageSize());
        pagingParam.setPageIndex(config.getPageIndex());
        pagingParam.setKey(securityConf.getKey());
        rq.setParam(pagingParam);
        return rq;
    }

    public static Wrapper createWrapperByEntName(String entName) {
        EntityWrapper wrapper = new EntityWrapper();
        wrapper.eq("ent_name", entName);
        return wrapper;
    }

    public static Map toDtoMap(Object entity) throws Exception {
        Map map = createMap(entity);
        if (map == null) return null;
        map.remove("id");
        map.remove("dataStatus");
        map.remove("createTime");
        map.remove("creator");
        map.remove("updateTime");
        map.remove("updater");
        return map;
    }

    public static List<Map> toListDtoMap(List entityList) throws Exception {
        List list = new ArrayList();
        for (Object entity : entityList) {
            list.add(toDtoMap(entity));
        }
        return list;
    }

    public static Map createMap(Object entity) throws Exception {
        if (entity == null) return null;
        Map map = new HashMap();
        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(entity));
        }
        return map;
    }

    /**
     * 讲jsonObject的数据转换为entity
     * 条件：entity数据字段均为String类型
     *
     * @param data
     * @param entityClass
     * @param <T>
     * @return
     */
    public static <T> T tranData(JSONObject data, Class<T> entityClass, String entName, String creditCode, boolean ifIgnoreCase) throws Exception {
        if (data == null || data.size() <= 0) return null;
        T t = entityClass.newInstance();
        Field[] fields = entityClass.getDeclaredFields();
        Set<String> keySet = data.getInnerMap().keySet();
        for (Field field : fields) {
            String fieldName = field.getName();
            if (fieldName.equalsIgnoreCase("entName")) {
                field.setAccessible(true);
                field.set(t, entName);
                continue;
            }
            if (fieldName.equalsIgnoreCase("creditCode")) {
                field.setAccessible(true);
                field.set(t, creditCode);
                continue;
            }
            for (String keyStr : keySet) {
                if (!isEntityCommonField(field.getName()) && (field.getName().equals(keyStr) || ifIgnoreCase && field.getName().equalsIgnoreCase(keyStr))) {
                    field.setAccessible(true);
                    field.set(t, data.getString(keyStr));
                    break;
                }
            }
        }
        return t;
    }

    /**
     * 讲jsonObject的数据转换为entity，忽略字段的大小写
     * 条件：entity数据字段均为String类型
     *
     * @param data
     * @param entityClass
     * @param <T>
     * @return
     */
    public static <T> List<T> tranData(JSONArray data, Class<T> entityClass, String entName, String creditCode, boolean ifIgnoreCase) throws Exception {
        if (data != null && data.size() > 0) {
            List<T> list = new ArrayList<>();
            for (int i = 0; i < data.size(); i++) {
                list.add(tranData(data.getJSONObject(i), entityClass, entName, creditCode, ifIgnoreCase));
            }
            return list;
        }
        return null;
    }

    private static boolean isEntityCommonField(String name) {
        String[] entityCommonFields = new String[]{"id", "dataStatus", "creator", "createTime", "updater", "updateTime"};
        return Arrays.asList(entityCommonFields).contains(name);
    }


    public static SeriousViolationReqParam newViolationRq() {
        SeriousViolationReqParam rq = new SeriousViolationReqParam();
        SeriousViolationParam seriousViolationParam = new SeriousViolationParam();
        QichachaSecurityConf securityConf = SpringContextUtils.getBean("qichachaSecurityConf", QichachaSecurityConf.class);
        seriousViolationParam.setKey(securityConf.getKey());
        rq.setParam(seriousViolationParam);
        return rq;
    }
}
