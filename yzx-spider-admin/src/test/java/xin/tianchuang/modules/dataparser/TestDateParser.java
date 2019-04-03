package xin.tianchuang.modules.dataparser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import xin.tianchuang.modules.dataparser.biz.CreditChinaParser;
import xin.tianchuang.modules.dataparser.biz.Parser;
import xin.tianchuang.modules.dataparser.biz.ParserFactory;
import xin.tianchuang.modules.dataparser.entity.*;
import xin.tianchuang.modules.dataparser.enums.DataTypeEnum;
import xin.tianchuang.modules.dataparser.facade.*;
import xin.tianchuang.modules.dataparser.service.CredithunanTaxContraventionService;
import xin.tianchuang.modules.spider.entity.SpiderRawDataEntity;
import xin.tianchuang.modules.spider.enums.SpiderTypeEnum;
import xin.tianchuang.modules.spider.service.SpiderRawDataService;

import java.util.List;

/**
 * Created by lee on 2018/9/28.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
public class TestDateParser {

    @Autowired
    private CredithunanAdministrativeLicensingFacade administrativeLicensingFacade;
    @Autowired
    private CredithunanAbnormalNoticeFacade credithunanAbnormalNoticeFacade;

    @Autowired
    private CreditChinaParser creditChinaParser;

    @Autowired
    private CreditChinaFacade creditChinaFacade;

    @Test
    public void testCreditChinaParser() throws Exception {
        List<SpiderRawDataEntity> entityList=  spiderRawDataService.selectListByEnterpriseNameAndType(null,SpiderTypeEnum.CREDIT_CHINA);
        creditChinaParser.parser(entityList.get(0).getContent(),DataTypeEnum.JSON);
    }

    @Test
    public void testCreditChinaFacade() throws Exception{
        String entname="中国建筑第二工程局有限公司";
        creditChinaFacade.doBussiness(entname);
//        creditChinaFacade.doBussiness();
    }


    @Autowired
    private CredutHunanTaxContraventionFacade taxContraventionFacade;
    @Autowired
    private CredutHunanNationalTaxAFacade nationalTaxAFacade;
    @Autowired
    private CredutHunanLandTaxAFacade landTaxAFacade;
    @Autowired
    private CredithunanAdministrativePenaltyFacade penaltyFacade;

    @Autowired
    private SpiderRawDataService spiderRawDataService;

    @Test
    public void testLicensingFacade() throws Exception{
        administrativeLicensingFacade.doBussiness();
    }

    @Test
    public void testAbnormalNoticeFacade() throws Exception{
        credithunanAbnormalNoticeFacade.doBussiness();
    }

    @Test
    public  void testTaxContraventionFacade() throws Exception{
       // taxContraventionFacade.doBussiness();
        String name="衡阳鸿菱石油管材有限责任公司";
        taxContraventionFacade.doBussiness(name);

    }

    @Test
    public void testAdministrativePenanltyFacade() throws Exception{
        penaltyFacade.doBussiness();

    }

    @Test
    public  void testNationalTaxAFacade() throws Exception{

        String name="衡阳鸿菱石油管材有限责任公司";
        nationalTaxAFacade.doBussiness(name);
    }

    @Test
    public  void testLandTaxAFacade() throws Exception{

        String name="衡阳鸿菱石油管材有限责任公司";
        landTaxAFacade.doBussiness(name);
    }

    @Test
    public void testTaxContraventionParser() throws Exception{
        String enterpriseName=null;
        List<SpiderRawDataEntity> entityList= spiderRawDataService.selectListByEnterpriseNameAndType(enterpriseName, SpiderTypeEnum.MAJOR_TAX_OFFENCES);
        //解析
        Parser<CredithunanTaxContraventionEntity> parser= ParserFactory.getInstance(SpiderTypeEnum.MAJOR_TAX_OFFENCES);
        CredithunanTaxContraventionEntity taxa=parser.parser(entityList.get(0).getContent());
        Assert.assertNotNull(taxa);
        System.out.println(taxa);

    }

    @Test
    public void testAdministrativePenanltyParser() throws Exception{
        String enterpriseName=null;
        List<SpiderRawDataEntity> entityList= spiderRawDataService.selectListByEnterpriseNameAndType(enterpriseName, SpiderTypeEnum.ADMINISTRATIVE_PUNISHMENT);
        //解析
        Parser<CredithunanAdministrativePenaltyEntity> parser= ParserFactory.getInstance(SpiderTypeEnum.ADMINISTRATIVE_PUNISHMENT);
        CredithunanAdministrativePenaltyEntity taxa=parser.parser(entityList.get(0).getContent());
        Assert.assertNotNull(taxa);
        System.out.println(taxa);

    }

    @Test
    public void testNationalTaxAParser() throws Exception{
        String enterpriseName=null;
        List<SpiderRawDataEntity> entityList= spiderRawDataService.selectListByEnterpriseNameAndType(enterpriseName, SpiderTypeEnum.LEVEL_A_TAXER);
        //解析
        Parser<CredithunanTaxAEntity> parser= ParserFactory.getInstance(SpiderTypeEnum.LEVEL_A_TAXER);
        CredithunanTaxAEntity taxa=parser.parser(entityList.get(0).getContent());
        Assert.assertNotNull(taxa);
        System.out.println(taxa);

    }

    @Test
    public void testLandTaxAParser() throws Exception{
        String enterpriseName=null;
        List<SpiderRawDataEntity> entityList= spiderRawDataService.selectListByEnterpriseNameAndType(enterpriseName, SpiderTypeEnum.CREDIT_A_TAXPAYER);
        //解析
        Parser<CredithunanTaxAEntity> parser= ParserFactory.getInstance(SpiderTypeEnum.CREDIT_A_TAXPAYER);
        CredithunanTaxAEntity taxa=parser.parser(entityList.get(0).getContent());
        Assert.assertNotNull(taxa);
        System.out.println(taxa);

    }

    @Test
    public void testAdministrativeLisencingParser() throws Exception{
        String enterpriseName=null;
        List<SpiderRawDataEntity> entityList= spiderRawDataService.selectListByEnterpriseNameAndType(enterpriseName, SpiderTypeEnum.ADMINISTRATIVE_LICENSING);
        //解析
        Parser<CredithunanAdministrativeLicensingEntity> parser= ParserFactory.getInstance(SpiderTypeEnum.ADMINISTRATIVE_LICENSING);
        CredithunanAdministrativeLicensingEntity credithunanAdministrativeLicensingEntity=parser.parser(entityList.get(0).getContent());
        Assert.assertNotNull(credithunanAdministrativeLicensingEntity);
        System.out.println(credithunanAdministrativeLicensingEntity);
    }

    @Test
    public void testAbnormalNotice() throws Exception{
        String enterpriseName=null;
        List<SpiderRawDataEntity> entityList= spiderRawDataService.selectListByEnterpriseNameAndType(enterpriseName, SpiderTypeEnum.ABNORMAL_NOTICE);
        //解析
        Parser<CredithunanAbnormalNoticeEntity> parser= ParserFactory.getInstance(SpiderTypeEnum.ABNORMAL_NOTICE);
        CredithunanAbnormalNoticeEntity credithunanAbnormalNoticeEntity=parser.parser(entityList.get(0).getContent());
        Assert.assertNotNull(credithunanAbnormalNoticeEntity);
        System.out.println(credithunanAbnormalNoticeEntity);
    }

}
