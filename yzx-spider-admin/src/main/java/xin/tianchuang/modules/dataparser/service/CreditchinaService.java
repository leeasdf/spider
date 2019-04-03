package xin.tianchuang.modules.dataparser.service;

import xin.tianchuang.modules.dataparser.dto.CreditChinaDTO;
import xin.tianchuang.modules.spider.entity.SpiderRawDataEntity;

/**
 * Created by lee on 2018/10/16.
 */

public interface CreditchinaService {
    void saveParserData(CreditChinaDTO dto, SpiderRawDataEntity entity) throws Exception;
}
