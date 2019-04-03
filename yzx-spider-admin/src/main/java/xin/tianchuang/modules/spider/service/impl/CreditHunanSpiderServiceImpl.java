package xin.tianchuang.modules.spider.service.impl;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.HttpRequestBody;
import us.codecraft.webmagic.utils.HttpConstant;
import xin.tianchuang.modules.spider.processor.*;
import xin.tianchuang.modules.spider.service.CreditHunanSpiderService;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yp-tc-m-7179 on 2018/9/29.
 */
@Service
public class CreditHunanSpiderServiceImpl implements CreditHunanSpiderService {
    @Resource
    private AdministrativePunishListProcessor administrativePunishListProcessor;
    @Resource
    private MajorTaxOffencesListProcessor majorTaxOffencesListProcessor;
    @Resource
    private AdministrativeLicensingListProcessor administrativeLicensingListProcessor;
    @Resource
    private LevelATaxerListProcessor levelATaxerListProcessor;
    @Resource
    private AbnormalNoticeListProcessor abnormalNoticeListProcessor;
    @Resource
    private CreditATaxpayerListProcessor creditATaxpayerListProcessor;


    public void crawlAdministrativePunishment(Date date) throws Throwable{
//        if (date == null)
            crawlAll();
//        else crawlPart(date);
    }

    @Override
    public void crawlMajorTaxOffences(Date latestPublishDate) throws Throwable{
//        if (latestPublishDate == null)
        crawlAllMajorTaxOffences();
//        else crawlPartMajorTaxOffences(latestPublishDate);
    }

    private void crawlPartMajorTaxOffences(Date latestPublishDate) {
        for (int i = 0; i < MajorTaxOffencesListProcessor.OVER_PAGE_NUM; i++) {
            String[] dataArr;
            try {
                String result = Jsoup.connect(MajorTaxOffencesListProcessor.LIST_URL + "&startrecord=" + i * MajorTaxOffencesListProcessor.NUM_PER_PAGE + "&endrecord=" + (MajorTaxOffencesListProcessor.NUM_PER_PAGE + i * MajorTaxOffencesListProcessor.NUM_PER_PAGE)).timeout(60000).post().toString();
                dataArr = JSON.parseArray(result.substring(result.indexOf("["), result.indexOf("]") + 1)).toArray(new String[]{});
            } catch (IOException e) {
                e.printStackTrace();
                //如果数据数组为空，那么说明没有数据了，不再继续
                return;
            }
            //分析每条数据的发布日期
            for (int j = 0; j < dataArr.length; j++) {
                String[] fields = dataArr[j].split("\\$");
                Date date = null;
                try {
                    date = DateUtils.parseDate(fields[3].trim(), "yyyy-MM-dd", "yyyy/MM/dd");
                } catch (ParseException e) {
                    e.printStackTrace();
                    return;
                }
                if (latestPublishDate.compareTo(date) == 0) {
                    crawlPart(i * MajorTaxOffencesListProcessor.NUM_PER_PAGE + j - 1);//不包含本条目，所以-1
                    return;
                }
            }
        }
    }

    private void crawlAllMajorTaxOffences() throws Throwable{
        try {
            String data = Jsoup.connect(MajorTaxOffencesListProcessor.FIRST_PAGE_URL).timeout(60000).get()
                    .getElementsByTag("script").eq(12).first().data();
            //获取首页的数据
//            String entData = data.substring(data.indexOf("["), data.indexOf("]") + 1);
//            majorTaxOffencesListProcessor.spiderRun(entData);
            String pageInfo = data.substring(data.indexOf("({") + 1, data.indexOf("})") + 1);
//            int total = JSON.parseObject(data).getIntValue("totalRecord");//居然无法转换，神奇了
            int total = subTotalRecord(pageInfo);
            //由于"信用湖南"分页查询存在bug，暂时不通过分页爬取全部数据，分页bug修复后恢复此代码
            crawlPartMajorTaxOffences(total);//分页bug修复后恢复此代码
        } catch (Throwable e) {
            //todo 处理异常
            e.printStackTrace();
            throw e;
        }
    }

    private void crawlPartMajorTaxOffences(int index) {
        if (index <= 0) return;
        Spider spider = Spider.create(majorTaxOffencesListProcessor).thread(5);
        for (int i = 0; i < index / MajorTaxOffencesListProcessor.NUM_PER_PAGE; i++) {
            Request request = new Request(MajorTaxOffencesListProcessor.LIST_URL + "&startrecord=" + (index - i * MajorTaxOffencesListProcessor.NUM_PER_PAGE - MajorTaxOffencesListProcessor.NUM_PER_PAGE + 1) + "&endrecord=" + (index - i * MajorTaxOffencesListProcessor.NUM_PER_PAGE));
            request.setMethod(HttpConstant.Method.POST);
            spider.addRequest(request);
        }
        Request request = new Request(MajorTaxOffencesListProcessor.LIST_URL + "&startrecord=1" + "&endrecord=" + index % MajorTaxOffencesListProcessor.NUM_PER_PAGE).setMethod(HttpConstant.Method.POST);
        spider.addRequest(request);
        spider.run();
    }

    @Override
    public void crawlLevelATaxer(Date latestPublishDate) {
//        if (latestPublishDate == null)
        crawlAllLevelATaxer();
//        else crawlPartLevelATaxer(latestPublishDate);
    }

    @Override
    public void crawlMajorTaxOffences(String entName) {
        Spider spider = Spider.create(majorTaxOffencesListProcessor).thread(1);
        Request request = new Request(MajorTaxOffencesListProcessor.SEARCH_URL)
                .setMethod(HttpConstant.Method.POST);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("nsrmc", entName);
        map.put("tid", "36BB388C42A2F9BBD16A1BA1E3A41200");
        request.setRequestBody(HttpRequestBody.form(map, "GBK"));
        spider.addRequest(request);
        spider.run();
    }

    @Override
    public void crawlLevelATaxer(String entName) {
        Spider spider = Spider.create(levelATaxerListProcessor).thread(1);
        Request request = new Request(LevelATaxerListProcessor.SEARCH_URL)
                .setMethod(HttpConstant.Method.POST);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("nsrmc", entName);
        map.put("tid", "70FC85017BB464A4EE20219D484A0716");
        request.setRequestBody(HttpRequestBody.form(map,"GBK"));
        spider.addRequest(request);
        spider.run();
    }

    @Override
    public void crawlAdministrativePunishment(String entName) {
        Spider spider = Spider.create(administrativePunishListProcessor).thread(1);
        Request request = new Request(AdministrativePunishListProcessor.SEARCH_URL)
                .setMethod(HttpConstant.Method.POST);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("bxzcf_name", entName);
        request.setRequestBody(HttpRequestBody.form(map, "GBK"));
        spider.addRequest(request);
        spider.run();
    }

    private void crawlPartLevelATaxer(Date latestPublishDate) {
        for (int i = 0; i < LevelATaxerListProcessor.OVER_PAGE_NUM; i++) {
            String[] dataArr;
            try {
                String result = Jsoup.connect(LevelATaxerListProcessor.LIST_URL + "&startrecord=" + i * LevelATaxerListProcessor.NUM_PER_PAGE + "&endrecord=" + (LevelATaxerListProcessor.NUM_PER_PAGE + i * LevelATaxerListProcessor.NUM_PER_PAGE)).timeout(60000).post().toString();
                dataArr = JSON.parseArray(result.substring(result.indexOf("["), result.indexOf("]") + 1)).toArray(new String[]{});
            } catch (IOException e) {
                e.printStackTrace();
                //如果数据数组为空，那么说明没有数据了，不再继续
                return;
            }
            //分析每条数据的发布日期
            for (int j = 0; j < dataArr.length; j++) {
                String[] fields = dataArr[j].split("\\$");
                Date date = null;
                try {
                    date = DateUtils.parseDate(fields[4].trim(), "yyyy", "yyyy-MM-dd", "yyyy/MM/dd");
                } catch (ParseException e) {
                    e.printStackTrace();
                    return;
                }
                if (latestPublishDate.compareTo(date) == 0) {
                    crawlPart(i * LevelATaxerListProcessor.NUM_PER_PAGE + j - 1);//不包含本条目，所以-1
                    return;
                }
            }
        }
    }

    private void crawlAllLevelATaxer() {
        try {
            String data = Jsoup.connect(LevelATaxerListProcessor.FIRST_PAGE_URL).timeout(60000).get()
                    .getElementsByTag("script").eq(12).first().data();
            //"信用湖南"翻页bug存在，暂时只获取首页数据
//            String entData = data.substring(data.indexOf("["), data.indexOf("]") + 1);
//            levelATaxerListProcessor.spiderRun(entData);
            String pageInfo = data.substring(data.indexOf("({") + 1, data.indexOf("})") + 1);
//            int total = JSON.parseObject(data).getIntValue("totalRecord");//居然无法转换，神奇了
            int total = subTotalRecord(pageInfo);
            //由于"信用湖南"分页查询存在bug，暂时不通过分页爬取全部数据，分页bug修复后恢复此代码
            crawlPartLevelATaxer(total);//分页bug修复后恢复此代码
        } catch (Exception e) {
            //todo 处理异常
            e.printStackTrace();
        }
    }

    private int subTotalRecord(String xinyongHunanData) {
        xinyongHunanData = StringUtils.deleteWhitespace(xinyongHunanData);
        return Integer.valueOf(xinyongHunanData.substring(xinyongHunanData.indexOf("totalRecord:") + "totalRecord:".length(), xinyongHunanData.indexOf(",dataStore:")));
    }

    private void crawlPartLevelATaxer(int index) {
        if (index == 0) return;
        Spider spider = Spider.create(levelATaxerListProcessor).thread(5);
        for (int i = 0; i < index / LevelATaxerListProcessor.NUM_PER_PAGE; i++) {
            Request request = new Request(LevelATaxerListProcessor.LIST_URL + "&startrecord=" + (index - i * LevelATaxerListProcessor.NUM_PER_PAGE - LevelATaxerListProcessor.NUM_PER_PAGE + 1) + "&endrecord=" + (index - i * LevelATaxerListProcessor.NUM_PER_PAGE));
            request.setMethod(HttpConstant.Method.POST);
            spider.addRequest(request);
        }
        Request request = new Request(LevelATaxerListProcessor.LIST_URL + "&startrecord=1" + "&endrecord=" + index % LevelATaxerListProcessor.NUM_PER_PAGE).setMethod(HttpConstant.Method.POST);
        spider.addRequest(request);
        spider.run();
    }

    private void crawlPart(Date publishDate) {
//        String publishDateStr = DateFormatUtils.format(publishDate, "yyyy-MM-dd");
        for (int i = 0; i < AdministrativePunishListProcessor.OVER_PAGE_NUM; i++) {
            String[] dataArr;
            try {
                String result = Jsoup.connect(AdministrativePunishListProcessor.PUNISH_LIST_URL + "&startrecord=" + i * AdministrativePunishListProcessor.NUM_PER_PAGE + "&endrecord=" + (AdministrativePunishListProcessor.NUM_PER_PAGE + i * AdministrativePunishListProcessor.NUM_PER_PAGE)).timeout(60000).post().toString();
                dataArr = JSON.parseArray(result.substring(result.indexOf("["), result.indexOf("]") + 1)).toArray(new String[]{});
            } catch (IOException e) {
                e.printStackTrace();
                //如果数据数组为空，那么说明没有数据了，不再继续
                return;
            }
            //分析每条数据的发布日期
            for (int j = 0; j < dataArr.length; j++) {
                String[] fields = dataArr[j].split("\\$");
                Date date = null;
                try {
                    date = DateUtils.parseDate(fields[5].trim(), "yyyy-MM-dd", "yyyy/MM/dd");
                } catch (ParseException e) {
                    e.printStackTrace();
                    return;
                }
                //如果在网站上查到的发布时间等于数据库保存的最早发布时间，那么将最新的数据保存到数据库
                if (publishDate.compareTo(date) == 0) {
                    crawlPart(i * AdministrativePunishListProcessor.NUM_PER_PAGE + j - 1);//不包含本条目，所以-1
                    return;
                }
            }
        }
    }

    private void crawlAll() throws Throwable{
        try {
            String data = Jsoup.connect(AdministrativePunishListProcessor.PUNISH_FIRST_PAGE_URL).timeout(60000).get()
                    .getElementsByTag("script").eq(6).first().data();
            data = data.substring(data.indexOf("({") + 1, data.indexOf("})") + 1);
//            int total = JSON.parseObject(data).getIntValue("totalRecord");//居然无法转换，神奇了
            int total = subTotalRecord(data);
            crawlPart(total);
        } catch (Exception e) {
            //todo 处理异常
            e.printStackTrace();
            throw e;
        }
    }

    private void crawlPart(int index) {
        if (index <= 0) return;
//        index = 8700;//网页有bug，从页面读取的数据来看根本没有20000+的数据
        Spider spider = Spider.create(administrativePunishListProcessor).thread(1);
//        Map<String, Object> extras = new HashMap<String, Object>();
        for (int i = 0; i < index / AdministrativePunishListProcessor.NUM_PER_PAGE; i++) {
            Request request = new Request(AdministrativePunishListProcessor.PUNISH_LIST_URL + "&startrecord=" + (index - i * AdministrativePunishListProcessor.NUM_PER_PAGE - AdministrativePunishListProcessor.NUM_PER_PAGE + 1) + "&endrecord=" + (index - i * AdministrativePunishListProcessor.NUM_PER_PAGE));
            request.setMethod(HttpConstant.Method.POST);
            spider.addRequest(request);
        }
        Request request = new Request(AdministrativePunishListProcessor.PUNISH_LIST_URL + "&startrecord=1" + "&endrecord=" + index % AdministrativePunishListProcessor.NUM_PER_PAGE).setMethod(HttpConstant.Method.POST);
        spider.addRequest(request);
        spider.run();
    }

    /****************************************************************************************************/

    @Override
    public void crawAdministrativeLicensing(Date date) {
        if (date == null)
            crawlLicensingAll();
        else crawlLicensingPart(date);
    }

    private void crawlLicensingPart(Date publishDate) {
        for (int i = 0; i < AdministrativeLicensingListProcessor.OVER_PAGE_NUM; i++) {
            String[] dataArr = null;
            try {
                String result = Jsoup.connect(AdministrativeLicensingListProcessor.LICENSING_LIST_URL + "&startrecord=" + i * AdministrativeLicensingListProcessor.NUM_PER_PAGE + "&endrecord=" + (AdministrativeLicensingListProcessor.NUM_PER_PAGE + i * AdministrativeLicensingListProcessor.NUM_PER_PAGE)).timeout(600000).post().toString();
                dataArr = JSON.parseArray(result.substring(result.indexOf("["), result.indexOf("]") + 1)).toArray(new String[]{});
            } catch (IOException e) {
                e.printStackTrace();
                //如果数据数组为空，那么说明没有数据了，不再继续
                return;
            }
            //分析每条数据的发布日期
            for (int j = 0; j < dataArr.length; j++) {
                String[] fields = dataArr[j].split("\\$");
                Date date = null;
                try {
                    date = DateUtils.parseDate(fields[5].trim(), "yyyy-MM-dd", "yyyy/MM/dd");
                } catch (ParseException e) {
                    e.printStackTrace();
                    return;
                }
                if (publishDate.compareTo(date) == 0) {
                    crawlLicensingPart(i * AdministrativeLicensingListProcessor.NUM_PER_PAGE + j - 1);//不包含本条目，所以-1
                    return;
                }
            }
        }
    }

    private void crawlLicensingAll() {
        try {
            String data = Jsoup.connect(AdministrativeLicensingListProcessor.LICENSING_FIRST_PAGE_URL).timeout(600000).get()
                    .getElementsByTag("script").eq(6).first().data();
            data = data.substring(data.indexOf("({") + 1, data.indexOf("})") + 1);
            int total = Integer.valueOf(data.substring(data.indexOf("totalRecord:") + "totalRecord:".length(), data.indexOf(",dataStore:")));
            crawlLicensingPart(total);
        } catch (Exception e) {
            //todo 处理异常
            e.printStackTrace();
        }
    }

    private void crawlLicensingPart(int index) {
        if (index <= 0) return;
        Spider spider = Spider.create(administrativeLicensingListProcessor).thread(5);
        for (int i = 0; i < index / AdministrativeLicensingListProcessor.NUM_PER_PAGE; i++) {
            Request request = new Request(AdministrativeLicensingListProcessor.LICENSING_LIST_URL + "&startrecord=" + (index - i * AdministrativeLicensingListProcessor.NUM_PER_PAGE - AdministrativeLicensingListProcessor.NUM_PER_PAGE + 1) + "&endrecord=" + (index - i * AdministrativeLicensingListProcessor.NUM_PER_PAGE));
            request.setMethod(HttpConstant.Method.POST);
            spider.addRequest(request);
        }
        Request request = new Request(AdministrativeLicensingListProcessor.LICENSING_LIST_URL + "&startrecord=1" + "&endrecord=" + index % AdministrativeLicensingListProcessor.NUM_PER_PAGE).setMethod(HttpConstant.Method.POST);
        spider.addRequest(request);
        spider.run();
    }

    @Override
    public void crawAbnormalNotice(Date latestPublishDate) {
//        if (latestPublishDate == null)
            crawAbnormalNoticeAll();
//        else crawAbnormalNoticePart(latestPublishDate);
    }

    private void crawAbnormalNoticeAll() {
        try {
//            String data = Jsoup.connect(AbnormalNoticeListProcessor.NOTICE_FIRST_PAGE_URL).timeout(60000).get()
//                    .getElementsByTag("script").eq(12).first().data();
//            String entData = data.substring(data.indexOf("["), data.indexOf("]") + 1);
//            abnormalNoticeListProcessor.spiderRun(entData);
//            String pageInfo = data.substring(data.indexOf("({") + 1, data.indexOf("})") + 1);
//            int total = subTotalRecord(pageInfo);

            String data = Jsoup.connect(AbnormalNoticeListProcessor.NOTICE_FIRST_PAGE_URL).timeout(60000).get()
                    .getElementsByTag("script").eq(12).first().data();
            String pageInfo = data.substring(data.indexOf("({") + 1, data.indexOf("})") + 1);
            int total = subTotalRecord(pageInfo);
            crawAbnormalNoticePart(total);
        } catch (Exception e) {
            //todo 处理异常
            e.printStackTrace();
        }
    }

    private void crawAbnormalNoticePart(Date latestPublishDate) {
        for (int i = 0; i < AbnormalNoticeListProcessor.OVER_PAGE_NUM; i++) {
            String[] dataArr;
            try {
                String result = Jsoup.connect(AbnormalNoticeListProcessor.NOTICE_LIST_URL + "&startrecord=" + i * AbnormalNoticeListProcessor.NUM_PER_PAGE + "&endrecord=" + (AbnormalNoticeListProcessor.NUM_PER_PAGE + i * AbnormalNoticeListProcessor.NUM_PER_PAGE)).timeout(60000).post().toString();
                dataArr = JSON.parseArray(result.substring(result.indexOf("["), result.indexOf("]") + 1)).toArray(new String[]{});
            } catch (IOException e) {
                e.printStackTrace();
                //如果数据数组为空，那么说明没有数据了，不再继续
                return;
            }
            //分析每条数据的发布日期
            for (int j = 0; j < dataArr.length; j++) {
                String[] fields = dataArr[j].split("\\$");
                Date date = null;
                try {
                    date = DateUtils.parseDate(fields[3].trim(), "yyyy-MM-dd", "yyyy/MM/dd");
                } catch (ParseException e) {
                    e.printStackTrace();
                    return;
                }
                if (latestPublishDate.compareTo(date) == 0) {
                    crawAbnormalNoticePart(i * AbnormalNoticeListProcessor.NUM_PER_PAGE + j - 1);//不包含本条目，所以-1
                    return;
                }
            }
        }

    }

    private void crawAbnormalNoticePart(int index) {
        if (index <= 0) return;
        Spider spider = Spider.create(abnormalNoticeListProcessor).thread(5);
        for (int i = 0; i < index / AbnormalNoticeListProcessor.NUM_PER_PAGE; i++) {
            Request request = new Request(AbnormalNoticeListProcessor.NOTICE_LIST_URL + "&startrecord=" + (index - i * AbnormalNoticeListProcessor.NUM_PER_PAGE - AbnormalNoticeListProcessor.NUM_PER_PAGE + 1) + "&endrecord=" + (index - i * AbnormalNoticeListProcessor.NUM_PER_PAGE));
            request.setMethod(HttpConstant.Method.POST);
            spider.addRequest(request);
        }
        Request request = new Request(AbnormalNoticeListProcessor.NOTICE_LIST_URL + "&startrecord=1" + "&endrecord=" + index % AbnormalNoticeListProcessor.NUM_PER_PAGE).setMethod(HttpConstant.Method.POST);
        spider.addRequest(request);
        spider.run();
    }

    @Override
    public void crawCreditATaxpayer(Date latestPublishDate) {
//        if (latestPublishDate == null)
            crawlAllCreditATaxpayer();
//        else crawlCreditATaxpayerPart(latestPublishDate);
    }

    private void crawlCreditATaxpayerPart(Date latestPublishDate) {
        for (int i = 0; i < CreditATaxpayerListProcessor.OVER_PAGE_NUM; i++) {
            String[] dataArr;
            try {
                String result = Jsoup.connect(CreditATaxpayerListProcessor.LIST_URL + "&startrecord=" + i * CreditATaxpayerListProcessor.NUM_PER_PAGE + "&endrecord=" + (CreditATaxpayerListProcessor.NUM_PER_PAGE + i * CreditATaxpayerListProcessor.NUM_PER_PAGE)).timeout(60000).post().toString();
                dataArr = JSON.parseArray(result.substring(result.indexOf("["), result.indexOf("]") + 1)).toArray(new String[]{});
            } catch (IOException e) {
                e.printStackTrace();
                //如果数据数组为空，那么说明没有数据了，不再继续
                return;
            }
            //分析每条数据的发布日期
            for (int j = 0; j < dataArr.length; j++) {
                String[] fields = dataArr[j].split("\\$");
                Date date = null;
                try {
                    date = DateUtils.parseDate(fields[4].trim(), "yyyy", "yyyy-MM-dd", "yyyy/MM/dd");
                } catch (ParseException e) {
                    e.printStackTrace();
                    return;
                }
                if (latestPublishDate.compareTo(date) == 0) {
                    crawlPart(i * CreditATaxpayerListProcessor.NUM_PER_PAGE + j - 1);//不包含本条目，所以-1
                    return;
                }
            }
        }
    }

    private void crawlAllCreditATaxpayer() {
        try {
//            String data = Jsoup.connect(CreditATaxpayerListProcessor.FIRST_PAGE_URL).timeout(60000).get()
//                    .getElementsByTag("script").eq(12).first().data();
//            String entData = data.substring(data.indexOf("["), data.indexOf("]") + 1);
//            levelATaxerListProcessor.spiderRun(entData);
//            String pageInfo = data.substring(data.indexOf("({") + 1, data.indexOf("})") + 1);

            //分页bug解决后执行
            String data = Jsoup.connect(CreditATaxpayerListProcessor.FIRST_PAGE_URL).timeout(60000).get()
                    .getElementsByTag("script").eq(12).first().data();
//            data = data.substring(data.indexOf("({") + 1, data.indexOf("})") + 1);
//            int total = Integer.valueOf(data.substring(data.indexOf("totalRecord:") + "totalRecord:".length(), data.indexOf(",dataStore:")));
            String pageInfo = data.substring(data.indexOf("({") + 1, data.indexOf("})") + 1);
            int total = subTotalRecord(pageInfo);
            crawlCreditATaxpayerPart(total);
        } catch (Exception e) {
            //todo 处理异常
            e.printStackTrace();
        }
    }

    private void crawlCreditATaxpayerPart(int index) {
        if (index <= 0) return;
        Spider spider = Spider.create(creditATaxpayerListProcessor).thread(5);
        for (int i = 0; i < index / CreditATaxpayerListProcessor.NUM_PER_PAGE; i++) {
            Request request = new Request(CreditATaxpayerListProcessor.LIST_URL + "&startrecord=" + (index - i * CreditATaxpayerListProcessor.NUM_PER_PAGE - CreditATaxpayerListProcessor.NUM_PER_PAGE + 1) + "&endrecord=" + (index - i * CreditATaxpayerListProcessor.NUM_PER_PAGE));
            request.setMethod(HttpConstant.Method.POST);
            spider.addRequest(request);
        }
        Request request = new Request(CreditATaxpayerListProcessor.LIST_URL + "&startrecord=1" + "&endrecord=" + index % CreditATaxpayerListProcessor.NUM_PER_PAGE).setMethod(HttpConstant.Method.POST);
        spider.addRequest(request);
        spider.run();
    }

    public void crawAbnormalNoticeFirstPage(){
        Spider spider = Spider.create(abnormalNoticeListProcessor).thread(5);
        Request request = new Request(AbnormalNoticeListProcessor.NOTICE_FIRST_PAGE_URL);
        request.setMethod(HttpConstant.Method.POST);
        spider.addRequest(request);
        spider.run();
    }

    @Override
    public void crawAbnormalNotice(String entName) {
        Spider spider = Spider.create(abnormalNoticeListProcessor).thread(1);
        Request request = new Request(AbnormalNoticeListProcessor.SEARCH_URL)
                .setMethod(HttpConstant.Method.POST);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("nsrmc", entName);
        map.put("tid", "9FEBBC60E2B677A9856C6D384C6E39C74C4C2B28B963A80D");
        request.setRequestBody(HttpRequestBody.form(map, "GBK"));
        spider.addRequest(request);
        spider.run();
    }

    @Override
    public void crawCreditATaxpayer(String entName) {
        Spider spider = Spider.create(creditATaxpayerListProcessor).thread(1);
        Request request = new Request(creditATaxpayerListProcessor.SEARCH_URL)
                .setMethod(HttpConstant.Method.POST);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("nsrmc", entName);
        map.put("tid", "1CBF63C2806A3AEEFFDAE00989DA4353");
        request.setRequestBody(HttpRequestBody.form(map,"GBK"));
        spider.addRequest(request);
        spider.run();
    }

    @Override
    public void crawAdministrativeLicensing(String entName) {
        Spider spider = Spider.create(administrativeLicensingListProcessor).thread(1);
        Request request = new Request(administrativeLicensingListProcessor.LICENSING_FIRST_PAGE_URL)
                .setMethod(HttpConstant.Method.POST);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("bxzxk_name", entName);
        request.setRequestBody(HttpRequestBody.form(map, "GBK"));
        spider.addRequest(request);
        spider.run();
    }


}
