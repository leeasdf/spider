package xin.tianchuang.modules.dataparser.biz;

import xin.tianchuang.modules.spider.enums.SpiderTypeEnum;

/**
 * Created by lee on 2018/10/10.
 * 解析工厂类 解析子类对象必须通过工厂方法调用 不允许注入 ,
 * 注入实现的时候 纳税人A 构造方法有参数通过Autoriwed注入不行的，
 */
public class ParserFactory {

    public static Parser getInstance(SpiderTypeEnum spiderTypeEnum){
        if(spiderTypeEnum == null) {
            return null;
        }
        if(SpiderTypeEnum.LEVEL_A_TAXER==spiderTypeEnum){
            return new CredithunanTaxAParser(SpiderTypeEnum.LEVEL_A_TAXER);
        }else if(SpiderTypeEnum.CREDIT_A_TAXPAYER==spiderTypeEnum){
            return new CredithunanTaxAParser(SpiderTypeEnum.CREDIT_A_TAXPAYER);
        }else if(SpiderTypeEnum.MAJOR_TAX_OFFENCES==spiderTypeEnum){
            return new CredutHunanTaxContraventionParser();
        }else if(SpiderTypeEnum.ADMINISTRATIVE_PUNISHMENT==spiderTypeEnum){
            return new CredithunanAdministrativePenaltyParser();
        }else if(SpiderTypeEnum.ABNORMAL_NOTICE==spiderTypeEnum){
            return new CredithunanAbnormalNoticeParser();
        }else if(SpiderTypeEnum.ADMINISTRATIVE_LICENSING==spiderTypeEnum){
            return new CredithunanAdministrativeLicensingParser();
        }else if(SpiderTypeEnum.CREDIT_CHINA == spiderTypeEnum){
            return  new CreditChinaParser();
        }

        return  null;
    }
}
