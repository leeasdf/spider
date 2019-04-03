package xin.tianchuang.modules.spider.service;

import java.util.Date;

/**
 * Created by yp-tc-m-7179 on 2018/9/29.
 */
public interface CreditHunanSpiderService {
    /**
     * 爬取信用湖南行政处罚数据
     * @param date
     */
    void crawlAdministrativePunishment(Date date) throws Throwable;

    void crawlMajorTaxOffences(Date latestPublishDate) throws Throwable;

    void crawlLevelATaxer(Date latestPublishDate);

    void crawlMajorTaxOffences(String entName);

    void crawlLevelATaxer(String entName);

    void crawlAdministrativePunishment(String entName);
    /**
     * 爬取信用湖南-行政许可数据
     * @param entName
     */
    void crawAdministrativeLicensing(String entName);

    void crawAdministrativeLicensing(Date date);

    /**
     * 爬取信用湖南-非正常户公告数据
     * @param latestPublishDate
     */
    void crawAbnormalNotice(Date latestPublishDate);

    void crawAbnormalNotice(String entName);

    /**
     * 爬取信用湖南-信用A级纳税人数据
     * @param latestPublishDate
     */
    void crawCreditATaxpayer(Date latestPublishDate);

    void crawCreditATaxpayer(String entName);

//    void crawAbnormalNoticeFirstPage();

}
