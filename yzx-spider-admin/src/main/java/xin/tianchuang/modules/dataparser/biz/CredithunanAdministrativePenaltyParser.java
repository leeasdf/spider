package xin.tianchuang.modules.dataparser.biz;



import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import xin.tianchuang.modules.dataparser.entity.CredithunanAdministrativePenaltyEntity;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 湖南信用 双公示 行政处罚
 * http://www.credithunan.gov.cn:30816/publicity_hn/webInfo/punishmentList.do
 *
 * @author lee
 * @date 2018/9/29
 */
public class CredithunanAdministrativePenaltyParser extends Parser<CredithunanAdministrativePenaltyEntity> {
    @Override
    public CredithunanAdministrativePenaltyEntity htmlParser(String htmlContent) throws Exception {

        if(StringUtils.isBlank(htmlContent)){
            return null;
        }
        htmlContent=htmlContent.replace("&nbsp;","");
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");

        CredithunanAdministrativePenaltyEntity entity=new CredithunanAdministrativePenaltyEntity();

        Document document= Jsoup.parse(htmlContent);
        Element caseNameE= document.selectFirst("td.listf2");
        entity.setCaseName(caseNameE.text().trim());

        Elements elements=document.select("table.xzcf_bg .xzcf_xx");
        entity.setCaseNo(elements.get(0).text().trim());

        Element element= elements.get(1);
        //获得html内容 删掉 span中的值:张星<span class="xzcf_mc">法定代表人（或单位负责人）：</span>======> 张星
        entity.setCaseObject(element.html().substring(0,element.html().indexOf("<span")));
        String[] temp=element.text().trim().split("：");
        if(temp.length>1){
            entity.setRepresentative(temp[1]);
        }

        entity.setLowDepartment(elements.get(2).text());
        String punishmentDate=elements.get(3).text();
        if(StringUtils.isNotBlank(punishmentDate)) {
            entity.setPunishmentDate(sdf.parse(punishmentDate));
        }

        entity.setContent(document.getElementsByClass("xzcf_jds").get(0).text());

        entity.setCreateTime(new Date());
        entity.setVersion(0);
        entity.setDataStatus(1);

        return entity;
    }
}
