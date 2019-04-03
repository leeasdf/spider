package xin.tianchuang.modules.externalApi.qichacha.vo;

import com.alibaba.fastjson.JSONObject;
import xin.tianchuang.modules.externalApi.qichacha.meta.ResultObj;

import java.util.ArrayList;

/**
 * Created by zhuzhengliang on 2019/1/7.
 */
public class SeriousViolationResultVO extends ArrayList implements ResultObj  {

    @Override
    public SeriousViolationResultVO getEntity(String data) {
        return JSONObject.parseObject(data,this.getClass());
    }

}
