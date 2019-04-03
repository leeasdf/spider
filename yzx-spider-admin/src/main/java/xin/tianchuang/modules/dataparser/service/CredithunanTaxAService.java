package xin.tianchuang.modules.dataparser.service;

import com.baomidou.mybatisplus.service.IService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.dataparser.entity.CredithunanTaxAEntity;
import xin.tianchuang.modules.spider.entity.SpiderRawDataEntity;

import java.util.Map;

/**
 * 年度纳税信用A级纳税人名单
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-28 14:45:04
 */
public interface CredithunanTaxAService extends IService<CredithunanTaxAEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存解析玩后的数据结果 并将原来原始数据设置为已解析
     * @param entity
     * @param spiderRawDataEntity
     * @throws Exception
     */
    void saveParserData(CredithunanTaxAEntity entity, SpiderRawDataEntity spiderRawDataEntity) throws Exception;

    CredithunanTaxAEntity selectByTaxpayer(String taxpayer, String source);
}

