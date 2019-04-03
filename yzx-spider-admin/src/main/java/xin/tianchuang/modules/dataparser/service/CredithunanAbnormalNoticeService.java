package xin.tianchuang.modules.dataparser.service;

import com.baomidou.mybatisplus.service.IService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.dataparser.entity.CredithunanAbnormalNoticeEntity;
import xin.tianchuang.modules.spider.entity.SpiderRawDataEntity;

import java.util.Map;

/**
 * 信用湖南-非正常户公告信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-10-12 17:55:57
 */
public interface CredithunanAbnormalNoticeService extends IService<CredithunanAbnormalNoticeEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存解析玩后的数据结果 并将原来原始数据设置为已解析
     * @param entity
     * @param spiderRawDataEntity
     * @throws Exception
     */
    void saveParserData(CredithunanAbnormalNoticeEntity entity, SpiderRawDataEntity spiderRawDataEntity);

    /**
     * 根据 纳税对象(企业名称) 查询 纳税非正常户 企业名称全匹配
     * @param
     * @return
     */
    CredithunanAbnormalNoticeEntity selectByTaxpayer(String taxpaper);
}

