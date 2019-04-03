package xin.tianchuang.modules.dataparser.biz;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import xin.tianchuang.modules.dataparser.entity.CreditchinaHonestyTaxEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lee on 2018/10/15.
 *
 * 信用中国 红名单解析 数据来源是税务局的税务信息时
 */
@Component
public class CreditchinaHonestyTaxParser extends Parser<CreditchinaHonestyTaxEntity> {

    @Override
    public CreditchinaHonestyTaxEntity jsonParser(String jsonContent) throws Exception{
        SimpleDateFormat sdf=new SimpleDateFormat("yyy/MM/dd");

        CreditchinaHonestyTaxEntity entity=new CreditchinaHonestyTaxEntity();
        JSONObject json= JSONObject.parseObject(jsonContent);

        entity.setNo(json.getString("序号"));
        entity.setSource(json.getString("数据来源"));
        entity.setType(json.getString("数据类别"));
        entity.setFileName(json.getString("文件名"));

        String lastUpdateTime=json.getString("最新更新日期");
        if(StringUtils.isNotBlank(lastUpdateTime)) {
            entity.setLastUpdateTime(sdf.parse(lastUpdateTime));
        }

        entity.setTaxName(json.getString("纳税人名称"));
        entity.setYear(json.getString("评价年度"));

        entity.setCreateTime(new Date());
        //entity.setVersion(0);
        entity.setDataStatus(1);

        return entity;

    }


}
