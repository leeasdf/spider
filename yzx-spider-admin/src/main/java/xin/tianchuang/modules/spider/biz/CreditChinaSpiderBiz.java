package xin.tianchuang.modules.spider.biz;

/**
 * Created by yp-tc-m-7179 on 2018/10/10.
 */
public interface CreditChinaSpiderBiz {
    /**
     * 根据企业id爬取数据
     * @param enterpriseId
     */
    void crawlData() throws Throwable;

}
