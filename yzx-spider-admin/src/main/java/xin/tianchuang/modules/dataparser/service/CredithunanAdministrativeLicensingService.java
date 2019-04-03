package xin.tianchuang.modules.dataparser.service;

import com.baomidou.mybatisplus.service.IService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.dataparser.entity.CredithunanAdministrativeLicensingEntity;
import xin.tianchuang.modules.spider.entity.SpiderRawDataEntity;

import java.util.Map;

/**
 * ???-??????
 *
 * @author hui.deng
 * @email 
 * @date 2018-10-12 17:55:57
 */
public interface CredithunanAdministrativeLicensingService extends IService<CredithunanAdministrativeLicensingEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存解析玩后的数据结果 并将原来原始数据设置为已解析
     * @param entity
     * @param spiderRawDataEntity
     * @throws Exception
     */
    void saveParserData(CredithunanAdministrativeLicensingEntity entity, SpiderRawDataEntity spiderRawDataEntity) throws Exception;

    CredithunanAdministrativeLicensingEntity selectByCaseObject(String caseObject);

    /**
     * 根据 案件对象（企业名称）分页查询  企业名称全匹配
     * @param params
     * @return
     */
    PageUtils queryPageByCaseObject(Map<String, Object> params);
}

