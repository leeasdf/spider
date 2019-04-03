package xin.tianchuang.modules.dataparser.biz;



import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import xin.tianchuang.modules.dataparser.entity.CredithunanAdministrativeLicensingEntity;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 湖南信用 双公示 行政许可
 * http://www.credithunan.gov.cn:30816/publicity_hn/webInfo/licenseList.do
 * Created by zhuzhengliang on 2018/10/12.
 */
public class CredithunanAdministrativeLicensingParser extends Parser<CredithunanAdministrativeLicensingEntity> {
    @Override
    public CredithunanAdministrativeLicensingEntity htmlParser(String htmlContent) throws Exception {

        if(StringUtils.isBlank(htmlContent)){
            return null;
        }
        htmlContent=htmlContent.replace("&nbsp;","");
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");

        CredithunanAdministrativeLicensingEntity entity=new CredithunanAdministrativeLicensingEntity();

        Document document= Jsoup.parse(htmlContent);
        Element caseName= document.selectFirst("td.listf2");
        entity.setCaseName(caseName.text().replace(" ",""));

        Elements elements=document.select("table.xzcf_bg .xzcf_xx");
        entity.setCaseNo(elements.get(0).text().replace(" ",""));

        Element element= elements.get(1);
        entity.setCaseObject(element.html().substring(0,element.html().indexOf("<span")));
        String[] temp=element.text().trim().split("：");
        if(temp.length>1){
            entity.setLegalRepresentative(temp[1]);
        }

        entity.setLawEnforcingDepartment(elements.get(2).text());
        String licensingDate=elements.get(3).text();
        if(StringUtils.isNotBlank(licensingDate)) {
            entity.setLicensingDate(sdf.parse(licensingDate.trim()));
        }

        entity.setContent(document.getElementsByClass("xzcf_jds").get(0).text());

        entity.setCreateTime(new Date());
        entity.setVersion(0);
        entity.setDataStatus(1);

        return entity;
    }
}
