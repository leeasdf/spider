package xin.tianchuang.modules.api.facade;

import xin.tianchuang.common.utils.PageUtils;

/**
 * Created by zhuzhengliang on 2018/10/23.
 */
public interface CredithunanApiFacade {
    /**
     * 获取年度信用A级纳税人信息
     * @param name
     * @return
     */
    PageUtils getLevelATaxpayer(String name,Integer currPage);

    /**
     * 获取重大税收违法案件公告信息
     * @param name
     * @return
     */
    PageUtils getTaxIllegal(String name, Integer currPage);

    /**
     * 获取非正常户公告信息
     * @param name
     * @return
     */
    PageUtils getAbnormalNotice(String name,Integer currPage);

    /**
     * 获取双公示-行政处罚信息
     * @param name
     * @return
     */
    PageUtils getAdministrativePenalty(String name,Integer currPage);

    /**
     * 获取双公示-行政许可信息
     * @param name
     * @return
     */
    PageUtils getAdministrativeLicensing(String name,Integer currPage);
}
