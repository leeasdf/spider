package xin.tianchuang.modules.dataparser.biz;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import xin.tianchuang.modules.dataparser.entity.CreditchinaFocusGszjEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lee on 2018/10/17.
 */
@Component
public class CreditchinaFocusGszjParser extends Parser<CreditchinaFocusGszjEntity> {

    @Override
    public CreditchinaFocusGszjEntity jsonParser(String jsonContent) throws Exception {
        SimpleDateFormat sdf1=new SimpleDateFormat("yyy/MM/dd");

        CreditchinaFocusGszjEntity entity = new CreditchinaFocusGszjEntity();
        JSONObject json= JSONObject.parseObject(jsonContent);

        entity.setRegNo(json.getString("注册号"));
        entity.setLegal(json.getString("法定代表人"));
        entity.setReason(json.getString("列入经营异常名录原因类型名称"));

        String lastUpdateTime=json.getString("最新更新日期");
        if(StringUtils.isNotBlank(lastUpdateTime)) {
            entity.setLastUpdateTime(sdf1.parse(lastUpdateTime));
        }

        entity.setEnterpriseName(json.getString("企业名称"));

        String establishDate=json.getString("设立日期");
        if(StringUtils.isNotBlank(establishDate)) {
            entity.setLastUpdateTime(sdf1.parse(establishDate));
        }

        entity.setSource(json.getString("数据来源"));
        entity.setDecisionOrgan(json.getString("列入决定机关名称"));
        entity.setType(json.getString("数据类别"));

        entity.setCreateTime(new Date());
        //entity.setVersion(0);
        entity.setDataStatus(1);
        return entity;
    }
}
