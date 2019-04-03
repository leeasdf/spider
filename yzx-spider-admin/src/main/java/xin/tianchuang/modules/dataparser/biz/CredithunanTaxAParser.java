package xin.tianchuang.modules.dataparser.biz;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import xin.tianchuang.modules.dataparser.entity.CredithunanTaxAEntity;
import xin.tianchuang.modules.dataparser.enums.CredithunanTaxATypeEnum;
import xin.tianchuang.modules.spider.enums.SpiderTypeEnum;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 湖南信用 纳税信用A级纳税人信息
 * 地税   http://www.credithunan.gov.cn/page/info/sincerityList.jsp?id=1CBF63C2806A3AEEFFDAE00989DA4353
 * 国税   http://www.credithunan.gov.cn/page/info/sincerityList.jsp?id=70FC85017BB464A4EE20219D484A0716
 * Created by lee on 2018/9/29.
 */
public class CredithunanTaxAParser extends Parser<CredithunanTaxAEntity> {

    private static final String INFORMATION= "信息名称：";
    private static final String SOURCE= "数据来源：";
    private static final String TYPE= "信息类型：";
    private static final String TIME= "更新时间：";


    private SpiderTypeEnum typeEnum;

    public CredithunanTaxAParser(SpiderTypeEnum typeEnum){
        this.typeEnum=typeEnum;
    }

    @Override
    public CredithunanTaxAEntity htmlParser(String htmlContent) throws Exception {
        if(StringUtils.isBlank(htmlContent)){
            return null;
        }
        htmlContent=htmlContent.replace("&nbsp;","");
        Document document= Jsoup.parse(htmlContent);

        if(SpiderTypeEnum.CREDIT_A_TAXPAYER.equals(typeEnum)){
            return  htmlParserLandTax(document);
        }else if(SpiderTypeEnum.LEVEL_A_TAXER.equals(typeEnum)){
            return  htmlParserNationalTax(document);
        }
        return null;
    }

    /**
     * 解析地税A
     * @param document
     * @return
     */
    private CredithunanTaxAEntity htmlParserLandTax(Document document)throws Exception {
        CredithunanTaxAEntity entity = parserCommon(document);
        entity.setTaxType(CredithunanTaxATypeEnum.LAND_TAX.getValue());

        SimpleDateFormat sdf = new SimpleDateFormat("yy.MM.dd");


        Elements elements = document.select("td.tinttd");
        entity.setTaxpayer(elements.get(0).text());
        entity.setOrgCode(elements.get(1).text());
        entity.setResponsiblePerson(elements.get(2).text());
        entity.setYear(elements.get(3).text().substring(0,4));
        entity.setCreditLevel(elements.get(4).text());
        entity.setTaxAuthorities(elements.get(5).text());
        String taxUpdateTime=elements.get(6).text();
        if(StringUtils.isNotBlank(taxUpdateTime)){
            entity.setTaxUpdateTime(sdf.parse(taxUpdateTime.trim()));
        }


        return  entity;
    }

    /**
     * 解析国税A
     * @param document
     * @return
     */
    private CredithunanTaxAEntity htmlParserNationalTax(Document document)throws Exception {

        CredithunanTaxAEntity entity = parserCommon(document);
        entity.setTaxType(CredithunanTaxATypeEnum.NATIONAL_TAX.getValue());

        Elements elements = document.select("td.tinttd");
        entity.setTaxpayer(elements.get(0).text());
        entity.setTaxpayerNo(elements.get(1).text());
        entity.setCreditLevel("A");
        entity.setTaxAuthorities(elements.get(2).text());
        entity.setYear(elements.get(3).text().substring(0,4));

        return  entity;
    }

    /**
     * 解析地税国税 相同的地方
     * @param document
     * @return
     * @throws Exception
     */
    private CredithunanTaxAEntity parserCommon(Document document) throws Exception{

        CredithunanTaxAEntity entity = new CredithunanTaxAEntity();
        entity.setCreateTime(new Date());
        entity.setVersion(0);
        entity.setDataStatus(1);


        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");

//        Element element= document.getElementById("sourceId");
//        String aboutInfo = element.text().trim();
//        //替换 换行中文空格和中文冒号
//        aboutInfo = aboutInfo.replaceAll("[\n　]+", " ").replaceAll("：",":");
//
//        String[] ary = aboutInfo.split(" ");
//
//        String informationName = ary[0].split(":")[1];
//        String source = ary[1].split(":")[1];
//        String informationType = ary[2].split(":")[1];
//        String sourceTime = ary[3].split(":")[1];


        Element js=document.getElementsByTag("script").last();
        String aboutInfo=js.data();
        String informationName = aboutInfo.substring(
                aboutInfo.indexOf(INFORMATION)+INFORMATION.length(),
                aboutInfo.indexOf("'+'　"));

        String source = aboutInfo.substring(
                aboutInfo.indexOf(SOURCE)+SOURCE.length(),
                aboutInfo.indexOf("'+'<br/><br/>"));

        String informationType = aboutInfo.substring(
                aboutInfo.indexOf(TYPE)+TYPE.length(),
                aboutInfo.indexOf("'+'　更新"));

        String sourceTime = aboutInfo.substring(
                aboutInfo.indexOf(TIME)+TIME.length(),
                aboutInfo.indexOf("');"));


        entity.setInfomationName(informationName);
        entity.setSource(source);
        entity.setInfomationType(informationType);
        if(StringUtils.isNotBlank(sourceTime)) {
            entity.setSourceTime(sdf.parse(sourceTime.trim()));
        }

        return entity;
    }
}

