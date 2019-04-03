package xin.tianchuang.modules.api.facade;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.api.bean.v1.CreditchinaBaseInfoDTO;

/**
 * Created by lee on 2018/10/23.
 * 信用中国 数据对外对接接口
 */
public interface CreditchinaApiFacade {
    /**
     * 获取基本信息
     * @param name
     * @param creditCode
     * @return
     */
    CreditchinaBaseInfoDTO  getBaseInfo(String name, String creditCode);

    /**
     * 获取行政许可信息
     * @param name
     * @return
     */
    PageUtils getPermissions(String name,Integer currPage);


    PageUtils getPenaltys(String name,Integer currPage);

    /**
     * 获取守信红名单信息
     * @param name
     * @return
     */
    PageUtils getHonestys(String name,Integer currPage);

    /**
     * 获取重点关注名单信息
     * @param name
     * @return
     */
    PageUtils getFocuss(String name,Integer currPage);

    /**
     * 获取黑名单信息
     * @param name
     * @return
     */
    PageUtils getBlacks(String name,Integer currPage);








}
