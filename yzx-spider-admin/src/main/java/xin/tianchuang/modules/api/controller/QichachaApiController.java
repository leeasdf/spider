package xin.tianchuang.modules.api.controller;

import com.google.gson.Gson;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.api.annotation.ApiToken;
import xin.tianchuang.modules.api.bean.v1.ApiResultDTO;
import xin.tianchuang.modules.api.bean.v1.result.QccFullDetailsDTO;
import xin.tianchuang.modules.api.facade.QichachaApiFacade;
import xin.tianchuang.modules.api.form.ApiQueryForm;
import xin.tianchuang.modules.externalApi.qichacha.QichachaUtils;
import xin.tianchuang.modules.spider.service.CcgpPurchaseIllegalService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lee on 2018/12/20.
 */
@ApiModel(value = "api接口-v1版本")
@RestController
@RequestMapping("/api/v1")
public class QichachaApiController {
    private static Logger logger = LoggerFactory.getLogger(QichachaApiController.class);

    @Autowired
    private QichachaApiFacade  qichachaApiFacade;
    @Autowired
    private CcgpPurchaseIllegalService ccgpPurchaseIllegalService;

    @ApiToken(desc = "企查查-著作权信息")
    @ApiModelProperty(value = "企查查-著作权信息")
    @GetMapping("/qcc/copyright")
    public ApiResultDTO getCopyRight( ApiQueryForm api) {
        String name = api.getName();

        Integer currPage=api.getPageNum()==null?0:api.getPageNum();
        Integer pageSize=api.getPageSize()==null?20:api.getPageSize();
        validateInfo(name, null);
        PageUtils page  = qichachaApiFacade.getCopyright(name, currPage, pageSize,api.getUpdatePeriod());
        return ApiResultDTO.ok().put("result", new Gson().toJson(page));
    }

    private ApiResultDTO validateInfo(String enterpriseName, String creditCode) {
        if (StringUtils.isBlank(enterpriseName) && StringUtils.isBlank(creditCode)) {
            return ApiResultDTO.error(9998, "企业名称和统一社会信用代码不能同时为空");
        }
        return null;
    }

    @ApiToken(desc = "企查查-专利信息")
    @ApiModelProperty(value = "企查查-专利信息")
    @GetMapping("/qcc/patent")
    @PostMapping("/qcc/patent")
    public ApiResultDTO getPatent( ApiQueryForm api) {
        String name = api.getName();
        Integer currPage=api.getPageNum()==null?0:api.getPageNum();
        Integer pageSize=api.getPageSize()==null?20:api.getPageSize();
        validateInfo(name, null);
        PageUtils page  = qichachaApiFacade.getPatent(name, currPage, pageSize,api.getUpdatePeriod());
        return ApiResultDTO.ok().put("result", new Gson().toJson(page));
    }

    @ApiToken(desc = "企查查-商标信息")
    @ApiModelProperty(value = "企查查-商标信息")
    @GetMapping("/qcc/trademark")
    public ApiResultDTO getTradeMark( ApiQueryForm api) {
        String name = api.getName();
        Integer currPage=api.getPageNum()==null?0:api.getPageNum();
        Integer pageSize=api.getPageSize()==null?20:api.getPageSize();
        validateInfo(name, null);
        PageUtils page  = qichachaApiFacade.getTradeMark(name, currPage, pageSize,api.getUpdatePeriod());
        return ApiResultDTO.ok().put("result", new Gson().toJson(page));
    }


    @ApiToken(desc = "企查查-著作权信息")
    @ApiModelProperty(value = "企查查-著作权信息")
    @GetMapping("/qcc/tender")
    public ApiResultDTO getTender( ApiQueryForm api) {
        String name = api.getName();

        Integer currPage=api.getPageNum()==null?0:api.getPageNum();
        Integer pageSize=api.getPageSize()==null?20:api.getPageSize();
        validateInfo(name, null);
        PageUtils page  = qichachaApiFacade.getTender(name, currPage, pageSize,api.getUpdatePeriod());
        return ApiResultDTO.ok().put("result", new Gson().toJson(page));
    }


    @ApiToken(desc = "企查查-严重违法信息")
    @ApiModelProperty(value = "企查查-严重违法信息")
    @GetMapping("/qcc/violation")
    public ApiResultDTO getViolation( ApiQueryForm api) {
        String name = api.getName();
        Integer currPage=api.getPageNum()==null?0:api.getPageNum();
        Integer pageSize=api.getPageSize()==null?20:api.getPageSize();
        validateInfo(name, null);
        PageUtils page  = qichachaApiFacade.getViolation(name, currPage, pageSize, api.getUpdatePeriod());
        return ApiResultDTO.ok().put("result", new Gson().toJson(page));
    }

    @ApiToken(desc = "企查查-企业关键字精确获取详细信息(Full)")
    @ApiModelProperty(value = "企查查-企业关键字精确获取详细信息(Full)")
    @GetMapping("/qcc/getFullDetails")
    public ApiResultDTO getFullDetailsByName( ApiQueryForm api) {
        validateInfo(api.getName(), api.getCreditCode());
        QccFullDetailsDTO details  = qichachaApiFacade.getFullDetailsByName(api);
        return ApiResultDTO.ok().put("result", new Gson().toJson(details));
    }
    /**
     * 政府采购严重违法失信，该数据来自中国政府采购网。
     * 写在这里是因为报告平台的数据都在这个类中，也就不另外新建一个类了
     *
     */
    @ApiToken(desc = "中国政府采购网-政府采购严重违法失信")
    @ApiModelProperty(value = "中国政府采购网-政府采购严重违法失信")
    @GetMapping("/qcc/getPurchaseIllegal")
    public ApiResultDTO getPurchaseIllegal(ApiQueryForm api){
        validateInfo(api.getName(), api.getCreditCode());
        String name = api.getName();
        Integer currPage=api.getPageNum()==null?0:api.getPageNum();
        Integer pageSize=api.getPageSize()==null?20:api.getPageSize();
        validateInfo(name, null);
        //1.先查询 没有 请求
        Map map = new HashMap<String, Object>();
        map.put("page", currPage);
        map.put("limit", pageSize);
        map.put("ent_name", name);
        PageUtils page = ccgpPurchaseIllegalService.queryPage(map);
        try {
            page.setList(QichachaUtils.toListDtoMap(page.getList()));
        } catch (Exception e) {
            logger.error("政府采购严重违法失信数据转换异常",e);
        }
        return ApiResultDTO.ok().put("result", new Gson().toJson(page));
    }
}
