package xin.tianchuang.modules.dataparser.service;

import com.baomidou.mybatisplus.service.IService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.dataparser.entity.CredithunanAdministrativePenaltyEntity;
import xin.tianchuang.modules.spider.entity.SpiderRawDataEntity;

import java.util.Map;

/**
 * 双公示-行政处罚列表
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-28 14:45:04
 */
public interface CredithunanAdministrativePenaltyService extends IService<CredithunanAdministrativePenaltyEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存解析玩后的数据结果 并将原来原始数据设置为已解析
     * @param entity
     * @param spiderRawDataEntity
     * @throws Exception
     */
    void saveParserData(CredithunanAdministrativePenaltyEntity entity, SpiderRawDataEntity spiderRawDataEntity) throws Exception;

    CredithunanAdministrativePenaltyEntity selectByCaseObject(String caseObject);

    /**
     * 根据 案件对象（企业名称）分页查询  企业名称全匹配
     * @param params
     * @return
     */
    PageUtils queryPageCaseObject(Map<String, Object> params);
}

