package xin.tianchuang.modules.dataparser.biz;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import xin.tianchuang.modules.dataparser.entity.CredithunanTaxContraventionEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 湖南信用
 * 重大税收违法案件公告信息
 * http://www.credithunan.gov.cn/page/info/sincerityList.jsp?id=36BB388C42A2F9BBD16A1BA1E3A41200
 * Created by lee on 2018/9/28.
 */
public class CredutHunanTaxContraventionParser extends Parser<CredithunanTaxContraventionEntity> {
    private static final String INFORMATION= "信息名称：";
    private static final String SOURCE= "数据来源：";
    private static final String TYPE= "信息类型：";
    private static final String TIME= "更新时间：";


    @Override
    public CredithunanTaxContraventionEntity htmlParser(String htmlContent) throws Exception{

        CredithunanTaxContraventionEntity entity = new CredithunanTaxContraventionEntity();

        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");

        htmlContent=htmlContent.replaceAll("&nbsp;", "").trim();
        Document doc = Jsoup.parse(htmlContent);


//        Element aboutElement = doc.getElementById("sourceId");
//        //信息名称：重大税收违法案件公告信息　数据来源：省地税局<br><br>信息类型：失信信息　更新时间：2017-11-16
//        String aboutInfo = aboutElement.text().trim();
//        //替换 换行中文空格和中文冒号
//        aboutInfo = aboutInfo.replaceAll("[\n　]+", " ").replaceAll("：",":");
//
//        String[] ary = aboutInfo.split(" ");
//
//        String informationName = ary[0].split(":")[1];
//        String source = ary[1].split(":")[1];
//        String informationType = ary[2].split(":")[1];
//        String sourceTime = ary[3].split(":")[1];

        Element js=doc.getElementsByTag("script").last();
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
        entity.setSourceTime(sdf.parse(sourceTime));

        Elements contentElement = doc.select("td.tinttd");
        entity.setTaxpayer(contentElement.get(0).text().trim());
        entity.setTaxpayerNo(contentElement.get(1).text().trim());
        entity.setCreditCode(contentElement.get(2).text().trim());
        entity.setRegisterAddress(contentElement.get(3).text().trim());
        entity.setLegal(contentElement.get(4).text().trim());
        entity.setCertificationNo(contentElement.get(5).text().trim());
        entity.setCheckUnit(contentElement.get(6).text().trim());
        String declarationDate=contentElement.get(7).text();
        if(StringUtils.isNotBlank(declarationDate)){
            entity.setDeclarationDate(sdf.parse(declarationDate.trim()));
        }


        entity.setCreateTime(new Date());
        entity.setVersion(0);
        entity.setDataStatus(1);

        return entity;

    }
}
