package xin.tianchuang.modules.api.facade;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.api.bean.v1.result.QccFullDetailsDTO;
import xin.tianchuang.modules.api.form.ApiQueryForm;

/**
 * Created by lee on 2018/12/20.
 */
public interface QichachaApiFacade {

    /**
     * 获取著作权信息
     * @param name
     * @return
     */
    PageUtils getCopyright(String name, Integer currPage ,Integer pageSize,Integer updatePeriod);

    /**
     * 专利信息
     * @param name
     * @param currPage
     * @param pageSize
     * @return
     */
    PageUtils getPatent(String name, Integer currPage ,Integer pageSize,Integer updatePeriod);

    /**
     * 获取商标信息
     * @param name
     * @return
     */
    PageUtils getTradeMark(String name, Integer currPage ,Integer pageSize,Integer updatePeriod);

    /**
     * 获取企业招投标信息
     * @param name
     * @param currPage
     * @param pageSize
     * @return
     */
    PageUtils getTender(String name, Integer currPage, Integer pageSize,Integer updatePeriod);
    /**
     * 获取严重违法信息
     * @param name
     * @return
     */
    PageUtils getViolation(String name, Integer currPage ,Integer pageSize,Integer updatePeriod);

    QccFullDetailsDTO getFullDetailsByName(ApiQueryForm api);
}
