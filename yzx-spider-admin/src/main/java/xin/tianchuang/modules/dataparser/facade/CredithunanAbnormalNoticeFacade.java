package xin.tianchuang.modules.dataparser.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import xin.tianchuang.modules.dataparser.biz.Parser;
import xin.tianchuang.modules.dataparser.biz.ParserFactory;
import xin.tianchuang.modules.dataparser.entity.CredithunanAbnormalNoticeEntity;
import xin.tianchuang.modules.dataparser.service.CredithunanAbnormalNoticeService;
import xin.tianchuang.modules.spider.entity.SpiderRawDataEntity;
import xin.tianchuang.modules.spider.enums.SpiderTypeEnum;
import xin.tianchuang.modules.spider.service.SpiderRawDataService;

import java.util.List;

/**
 * Created by zhuzhengliang on 2018/10/15.
 */
@Component
public class CredithunanAbnormalNoticeFacade {
    private static final Logger LOGGER= LoggerFactory.getLogger(CredithunanAbnormalNoticeFacade.class);
    @Autowired
    private SpiderRawDataService spiderRawDataService;

    @Autowired
    private CredithunanAbnormalNoticeService service;

    @Deprecated
    public void doBussiness(){
        doBussiness("");
    }

    /**
     * 可单独跑某个企业 也可不传企业 跑全部的
     * @param enterpriseName
     */
    @Deprecated
    public void doBussiness(String enterpriseName){
        //获取记录

        List<SpiderRawDataEntity> entityList= spiderRawDataService.selectListByEnterpriseNameAndType(enterpriseName, SpiderTypeEnum.ABNORMAL_NOTICE);
        //解析
        Parser<CredithunanAbnormalNoticeEntity> parser= ParserFactory.getInstance(SpiderTypeEnum.ABNORMAL_NOTICE);
        try {
            for (SpiderRawDataEntity entity : entityList) {
                CredithunanAbnormalNoticeEntity credithunanAbnormalNoticeEntity=parser.parser(entity.getContent());
                service.saveParserData(credithunanAbnormalNoticeEntity,entity);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void doBussiness(SpiderRawDataEntity dataEntity) throws Exception{
        //解析
        Parser<CredithunanAbnormalNoticeEntity> parser= ParserFactory.getInstance(SpiderTypeEnum.ABNORMAL_NOTICE);
        try {
            CredithunanAbnormalNoticeEntity credithunanAbnormalNoticeEntity=parser.parser(dataEntity.getContent());
            Assert.notNull(credithunanAbnormalNoticeEntity,"没有爬取到任何数据无法解析");
            credithunanAbnormalNoticeEntity.setSpiderId(dataEntity.getId());
            service.saveParserData(credithunanAbnormalNoticeEntity,dataEntity);
        } catch (Exception e) {
            LOGGER.error("解析数据是出错 spiderId="+dataEntity.getId()+"，"+e.getMessage(),e);
            throw e;
        }
    }

}
