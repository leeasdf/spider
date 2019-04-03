package xin.tianchuang.modules.dataparser.biz;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import xin.tianchuang.modules.dataparser.entity.CreditchinaFocusPenaltyEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lee on 2018/10/16.
 */
@Component
public class CreditchinaFocusPenaltyParser extends Parser<CreditchinaFocusPenaltyEntity> {

    @Override
    public CreditchinaFocusPenaltyEntity jsonParser(String jsonContent) throws Exception {
        SimpleDateFormat sdf1=new SimpleDateFormat("yyy/MM/dd");
        SimpleDateFormat sdf2=new SimpleDateFormat("yyy/MM/dd HH:mm:ss.SSS");

        CreditchinaFocusPenaltyEntity entity=new CreditchinaFocusPenaltyEntity();
        JSONObject json= JSONObject.parseObject(jsonContent);


        String punishmentDate=json.getString("处罚处理日期");
        if(StringUtils.isNotBlank(punishmentDate)) {
            entity.setLastUpdateTime(sdf1.parse(punishmentDate));
        }

        entity.setPunishmentObject(json.getString("处罚对象名称"));
        entity.setPunishmentDepart(json.getString("实际处罚部门"));
        entity.setPunishmentOrgan(json.getString("处罚机关"));
        entity.setType(json.getString("数据类别"));
        entity.setPunishmentName(json.getString("处罚处理名称"));

        String lastUpdateTime=json.getString("最新更新日期");
        if(StringUtils.isNotBlank(lastUpdateTime)) {
            entity.setLastUpdateTime(sdf2.parse(lastUpdateTime));
        }

        entity.setPenaltyDecision(json.getString("处罚决定书ID"));
        entity.setSource(json.getString("数据来源"));
        entity.setInformationType(json.getString("信息类型"));
        entity.setPunishmentType(json.getString("处罚处理种类"));
        entity.setPunishmentContent(json.getString("处罚处理内容"));


        entity.setCreateTime(new Date());
        //entity.setVersion(0);
        entity.setDataStatus(1);


        return entity;
    }
}
