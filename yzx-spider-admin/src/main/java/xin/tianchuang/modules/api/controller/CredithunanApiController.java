package xin.tianchuang.modules.api.controller;

import com.google.gson.Gson;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.api.annotation.ApiToken;
import xin.tianchuang.modules.api.bean.v1.ApiResultDTO;
import xin.tianchuang.modules.api.facade.CredithunanApiFacade;
import xin.tianchuang.modules.api.form.ApiQueryForm;

/**
 * Created by zhuzhengliang on 2018/11/1.
 */
@ApiModel(value = "api接口-v1版本")
@RestController
@RequestMapping("/api/v1/hunan")
public class CredithunanApiController {

    @Autowired
    private CredithunanApiFacade apiFacade;

    @ApiToken(desc = "信用湖南-非正常户公告信息")
    @ApiModelProperty(value = "信用湖南-非正常户公告信息")
    @GetMapping("/getAbnormal")
    public ApiResultDTO getAbnormal(@RequestBody ApiQueryForm api) {
        String name = api.getName();
        String creditCode = api.getCreditCode();
        Integer currPage=api.getPageNum()==null?0:api.getPageNum();
        validateInfo(name, creditCode);
        PageUtils page  = apiFacade.getAbnormalNotice(name, currPage);
        return ApiResultDTO.ok().put("result", new Gson().toJson(page));
    }

    @ApiToken(desc = "信用湖南-A级纳税人")
    @ApiModelProperty(value = "信用湖南-A级纳税人")
    @GetMapping("/getLevelATaxpayer")
    public ApiResultDTO getLevelATaxpayer(@RequestBody ApiQueryForm api) {
        String name = api.getName();
        String creditCode = api.getCreditCode();
        Integer currPage=api.getPageNum()==null?0:api.getPageNum();
        validateInfo(name, creditCode);
        PageUtils page  = apiFacade.getLevelATaxpayer(name, currPage);
        return ApiResultDTO.ok().put("result", new Gson().toJson(page));
    }

    @ApiToken(desc = "信用湖南-重大税收违法案件公告信息")
    @ApiModelProperty(value = "信用湖南-重大税收违法案件公告信息")
    @GetMapping("/getTaxIllegal")
    public ApiResultDTO getTaxIllegal(@RequestBody ApiQueryForm api) {
        String name = api.getName();
        String creditCode = api.getCreditCode();
        Integer currPage=api.getPageNum()==null?0:api.getPageNum();
        validateInfo(name, creditCode);
        PageUtils page  = apiFacade.getTaxIllegal(name, currPage);
        return ApiResultDTO.ok().put("result", new Gson().toJson(page));
    }

    @ApiToken(desc = "信用湖南-行政处罚")
    @ApiModelProperty(value = "信用湖南-行政处罚")
    @GetMapping("/getPenalty")
    public ApiResultDTO getPenalty(@RequestBody ApiQueryForm api) {
        String name = api.getName();
        String creditCode = api.getCreditCode();
        Integer currPage=api.getPageNum()==null?0:api.getPageNum();
        validateInfo(name, creditCode);
        PageUtils page  = apiFacade.getAdministrativePenalty(name, currPage);
        return ApiResultDTO.ok().put("result", new Gson().toJson(page));
    }

    @ApiToken(desc = "信用湖南-行政许可")
    @ApiModelProperty(value = "信用湖南-行政许可")
    @GetMapping("/getLicensing")
    public ApiResultDTO getLicensing(@RequestBody ApiQueryForm api) {
        String name = api.getName();
        String creditCode = api.getCreditCode();
        Integer currPage=api.getPageNum()==null?0:api.getPageNum();
        validateInfo(name, creditCode);
        PageUtils page  = apiFacade.getAdministrativeLicensing(name, currPage);
        return ApiResultDTO.ok().put("result", new Gson().toJson(page));
    }

    private ApiResultDTO validateInfo(String enterpriseName, String creditCode) {
        if (StringUtils.isBlank(enterpriseName) && StringUtils.isBlank(creditCode)) {
            return ApiResultDTO.error(9998, "企业名称和统一社会信用代码不能同时为空");
        }
        return null;
    }
}
