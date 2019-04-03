package xin.tianchuang.modules.dataparser.biz;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import xin.tianchuang.modules.dataparser.entity.CreditchinaBlackLawEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lee on 2018/10/16.
 */
@Component
public class CreditchinaBlackLawParser  extends  Parser<CreditchinaBlackLawEntity>{

    @Override
    public CreditchinaBlackLawEntity jsonParser(String jsonContent) throws Exception {
        SimpleDateFormat sdf=new SimpleDateFormat("yyy/MM/dd");

        CreditchinaBlackLawEntity entity= new CreditchinaBlackLawEntity();
        JSONObject json= JSONObject.parseObject(jsonContent);

        entity.setType(json.getString("数据类别"));
        entity.setSource(json.getString("数据来源"));
        entity.setCaseNo(json.getString("案号"));
        entity.setDishonestName(json.getString("失信被执行人名称"));
        entity.setEnterpriseLegal(json.getString("企业法人姓名"));
        entity.setCourt(json.getString("执行法院"));
        entity.setArea(json.getString("地域名称"));
        entity.setBasisNumber(json.getString("执行依据文号"));
        entity.setExecutionBasis(json.getString("作出执行依据单位"));
        entity.setLawDuty(json.getString("法律生效文书确定的义务"));
        entity.setPerformance(json.getString("被执行人的履行情况"));
        entity.setSituation(json.getString("失信被执行人具体情形"));

        String published=json.getString("发布时间");
        if(StringUtils.isNotBlank(published)) {
            entity.setPublished(sdf.parse(published));
        }
        String filingTime=json.getString("立案时间");
        if(StringUtils.isNotBlank(filingTime)) {
            entity.setFilingTime(sdf.parse(filingTime));
        }
        entity.setFulfilledPart(json.getString("已履行部分"));
        entity.setUnfulfilledPart(json.getString("未履行部分"));
        String lastUpdateTime=json.getString("最新更新日期");
        if(StringUtils.isNotBlank(lastUpdateTime)) {
            entity.setLastUpdateTime(sdf.parse(lastUpdateTime));
        }

        entity.setCreateTime(new Date());
        //entity.setVersion(0);
        entity.setDataStatus(1);

        return entity;
    }
}
