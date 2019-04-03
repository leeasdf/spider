package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.SpiderRawDataEntity;
import xin.tianchuang.modules.spider.enums.SpiderTypeEnum;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 从页面爬取的数据，内容格式可能是html、js、json
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-29 16:51:37
 */
public interface SpiderRawDataService extends IService<SpiderRawDataEntity> {

    PageUtils queryPage(Map<String, Object> params);

    Date selectLatestDateByType(Integer type);

    Long selectLatestIdByType(int key);

    /**
     * 按照企业名称和网站类型获取爬取到同时未解析的数据记录
     * @param enterpriseName
     * @param levelATaxer
     * @return
     */
    List<SpiderRawDataEntity> selectListByEnterpriseNameAndType(String enterpriseName, SpiderTypeEnum levelATaxer);

}

