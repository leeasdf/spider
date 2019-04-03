package xin.tianchuang.modules.dataparser.service;

import com.baomidou.mybatisplus.service.IService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.dataparser.entity.CredithunanTaxContraventionEntity;
import xin.tianchuang.modules.spider.entity.SpiderRawDataEntity;

import java.util.Map;

/**
 * 重大税收违法案件公告信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-28 14:45:04
 */
public interface CredithunanTaxContraventionService extends IService<CredithunanTaxContraventionEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存解析玩后的数据结果 并将原来原始数据设置为已解析
     * @param entity
     * @param spiderRawDataEntity
     * @throws Exception
     */
    void saveParserData(CredithunanTaxContraventionEntity entity, SpiderRawDataEntity spiderRawDataEntity);

    CredithunanTaxContraventionEntity selectByTaxpayer(String taxpayer, String source);
}

