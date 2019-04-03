package xin.tianchuang.modules.dataparser.facade;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import xin.tianchuang.modules.dataparser.biz.*;
import xin.tianchuang.modules.dataparser.dto.CreditChinaDTO;
import xin.tianchuang.modules.dataparser.enums.DataTypeEnum;
import xin.tianchuang.modules.spider.entity.SpiderRawDataEntity;
import xin.tianchuang.modules.spider.enums.SpiderTypeEnum;

/**
 * Created by lee on 2018/10/25.
 */
@Component
public class CreditHunanFacade {

    private static final Logger LOGGER= LoggerFactory.getLogger(CreditChinaFacade.class);
    @Autowired
    private CredithunanAbnormalNoticeFacade abnormalNoticeFacade;
    @Autowired
    private CredithunanAdministrativeLicensingFacade administrativeLicensingFacade;
    @Autowired
    private CredithunanAdministrativePenaltyFacade administrativePenaltyFacade;
    @Autowired
    private CredutHunanLandTaxAFacade landTaxAFacade;
    @Autowired
    private CredutHunanNationalTaxAFacade nationalTaxAFacade;
    @Autowired
    private CredutHunanTaxContraventionFacade taxContraventionFacade;

    public boolean doBussiness(SpiderRawDataEntity dataEntity){
        Integer type = dataEntity.getType();
        SpiderTypeEnum typeEnum=SpiderTypeEnum.transfar(type);
        try {
            if (SpiderTypeEnum.LEVEL_A_TAXER == typeEnum) {
                nationalTaxAFacade.doBussiness(dataEntity);
            } else if (SpiderTypeEnum.CREDIT_A_TAXPAYER == typeEnum) {
                landTaxAFacade.doBussiness(dataEntity);
            } else if (SpiderTypeEnum.MAJOR_TAX_OFFENCES == typeEnum) {
                taxContraventionFacade.doBussiness(dataEntity);
            } else if (SpiderTypeEnum.ADMINISTRATIVE_PUNISHMENT == typeEnum) {
                administrativePenaltyFacade.doBussiness(dataEntity);
            } else if (SpiderTypeEnum.ABNORMAL_NOTICE == typeEnum) {
                abnormalNoticeFacade.doBussiness(dataEntity);
            } else if (SpiderTypeEnum.ADMINISTRATIVE_LICENSING == typeEnum) {
                administrativeLicensingFacade.doBussiness(dataEntity);
            }
            return true;
        }catch (Exception e){
            LOGGER.error("解析出错",e);
            return false;
        }

    }
}
