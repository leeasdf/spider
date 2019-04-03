package xin.tianchuang.modules.dataparser.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import xin.tianchuang.modules.dataparser.biz.Parser;
import xin.tianchuang.modules.dataparser.biz.ParserFactory;
import xin.tianchuang.modules.dataparser.entity.CredithunanAdministrativePenaltyEntity;
import xin.tianchuang.modules.dataparser.service.CredithunanAdministrativePenaltyService;
import xin.tianchuang.modules.spider.entity.SpiderRawDataEntity;
import xin.tianchuang.modules.spider.enums.SpiderTypeEnum;
import xin.tianchuang.modules.spider.service.SpiderRawDataService;

import java.util.List;

/**
 * Created by lee on 2018/10/10.
 */
@Component
public class CredithunanAdministrativePenaltyFacade {
    private static final Logger LOGGER= LoggerFactory.getLogger(CredithunanAdministrativePenaltyFacade.class);

    @Autowired
    private SpiderRawDataService spiderRawDataService;

    @Autowired
    private CredithunanAdministrativePenaltyService service;

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

        List<SpiderRawDataEntity> entityList= spiderRawDataService.selectListByEnterpriseNameAndType(enterpriseName, SpiderTypeEnum.ADMINISTRATIVE_PUNISHMENT);
        //解析
        Parser<CredithunanAdministrativePenaltyEntity> parser= ParserFactory.getInstance(SpiderTypeEnum.ADMINISTRATIVE_PUNISHMENT);
        try {
            for (SpiderRawDataEntity entity : entityList) {
                CredithunanAdministrativePenaltyEntity taxa=parser.parser(entity.getContent());

                service.saveParserData(taxa,entity);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void doBussiness(SpiderRawDataEntity dataEntity) throws Exception{
        //解析
        Parser<CredithunanAdministrativePenaltyEntity> parser= ParserFactory.getInstance(SpiderTypeEnum.ADMINISTRATIVE_PUNISHMENT);
        try {
            CredithunanAdministrativePenaltyEntity entity=parser.parser(dataEntity.getContent());
            Assert.notNull(entity,"没有爬取到任何数据无法解析");
            entity.setSpiderId(dataEntity.getId());
            service.saveParserData(entity,dataEntity);
        } catch (Exception e) {
            LOGGER.error("解析数据是出错 spiderId="+dataEntity.getId()+"，"+e.getMessage(),e);
            throw e;
        }
    }
}
