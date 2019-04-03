package xin.tianchuang.modules.dataparser.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import xin.tianchuang.modules.dataparser.biz.Parser;
import xin.tianchuang.modules.dataparser.biz.ParserFactory;
import xin.tianchuang.modules.dataparser.dto.CreditChinaDTO;
import xin.tianchuang.modules.dataparser.enums.DataTypeEnum;
import xin.tianchuang.modules.dataparser.service.CreditchinaService;
import xin.tianchuang.modules.spider.entity.SpiderRawDataEntity;
import xin.tianchuang.modules.spider.enums.SpiderTypeEnum;
import xin.tianchuang.modules.spider.service.SpiderRawDataService;

import java.util.List;

/**
 *
 * @author lee
 * @date 2018/10/16
 */
@Component
public class CreditChinaFacade {

    private static final Logger LOGGER= LoggerFactory.getLogger(CreditChinaFacade.class);

    @Autowired
    private SpiderRawDataService spiderRawDataService;

    @Autowired
    private CreditchinaService service;

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

        List<SpiderRawDataEntity> entityList= spiderRawDataService.selectListByEnterpriseNameAndType(enterpriseName, SpiderTypeEnum.CREDIT_CHINA);
        //解析
        Parser<CreditChinaDTO> parser= ParserFactory.getInstance(SpiderTypeEnum.CREDIT_CHINA);
        for (SpiderRawDataEntity entity : entityList) {
            try {
                CreditChinaDTO dto = parser.parser(entity.getContent(), DataTypeEnum.JSON);
                service.saveParserData(dto, entity);
            } catch (Exception e) {
                LOGGER.error("解析数据是出错 spiderId="+entity.getId(),e);
                e.printStackTrace();
            }
        }


    }

    public boolean doBussiness(SpiderRawDataEntity dataEntity){
        //解析
        Parser<CreditChinaDTO> parser= ParserFactory.getInstance(SpiderTypeEnum.CREDIT_CHINA);
        try {
            CreditChinaDTO dto = parser.parser(dataEntity.getContent(), DataTypeEnum.JSON);
            Assert.notNull(dto,"没有爬取到任何数据无法解析");
            service.saveParserData(dto, dataEntity);
            return true;
        } catch (Exception e) {
            LOGGER.error("解析数据是出错 spiderId="+dataEntity.getId()+"，"+e.getMessage(),e);
            return false;
        }
    }

}
