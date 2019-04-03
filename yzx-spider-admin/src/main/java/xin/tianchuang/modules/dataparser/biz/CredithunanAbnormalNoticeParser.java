package xin.tianchuang.modules.dataparser.biz;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.modules.dataparser.entity.CredithunanAbnormalNoticeEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhuzhengliang on 2018/10/15.
 */
public class CredithunanAbnormalNoticeParser extends Parser<CredithunanAbnormalNoticeEntity> {

    private static final String INFORMATION= "信息名称：";
    private static final String SOURCE= "数据来源：";
    private static final String TYPE= "信息类型：";
    private static final String TIME= "更新时间：";

    @Override
    public CredithunanAbnormalNoticeEntity htmlParser(String htmlContent) throws Exception{

        CredithunanAbnormalNoticeEntity entity = new CredithunanAbnormalNoticeEntity();

        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");

        htmlContent=htmlContent.replaceAll("&nbsp;", "").trim();
        Document doc = Jsoup.parse(htmlContent);

//        Element aboutElement = doc.getElementById("sourceId");
//        //信息名称：非正常户公告信息　数据来源：省地税局<br><br>信息类型：失信信息　更新时间：2017-01-04
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
        entity.setTaxpayer(contentElement.get(0).text().replace(" ",""));
        entity.setOrganizeCode(contentElement.get(1).text().replace(" ",""));
        entity.setLegalRepresentative(contentElement.get(2).text().replace(" ",""));
        entity.setIdentityCard(contentElement.get(3).text().replace(" ",""));
        entity.setTaxAuthority(contentElement.get(4).text().replace(" ",""));
        entity.setDeclarationDate(contentElement.get(5).text().replace(" ",""));
        entity.setAffirmDate(contentElement.get(6).text().replace(" ",""));
//        try {
//            entity.setDeclarationDate(sdf.parse(contentElement.get(5).text().trim()));
//        }catch(ParseException e){
//            e.printStackTrace();
//        }
//        try {
//            entity.setAffirmDate(sdf.parse(contentElement.get(6).text().trim()));
//        }catch(ParseException e){
//            e.printStackTrace();
//        }
        entity.setBusinessAddress(contentElement.get(7).text().replace(" ",""));

        entity.setCreateTime(new Date());
        entity.setVersion(0);
        entity.setDataStatus(DataStatusEnum.ACTIVE.key());

        return entity;

    }
}

