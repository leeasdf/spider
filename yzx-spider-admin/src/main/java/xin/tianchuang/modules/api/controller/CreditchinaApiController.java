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
import xin.tianchuang.modules.api.bean.v1.CreditchinaBaseInfoDTO;
import xin.tianchuang.modules.api.facade.CreditchinaApiFacade;
import xin.tianchuang.modules.api.form.ApiQueryForm;

/**
 * Created by lee on 2018/10/23.
 */
@ApiModel(value = "api接口-v1版本")
@RestController
@RequestMapping("/api/v1")
public class CreditchinaApiController {

    @Autowired
    private CreditchinaApiFacade apiFacade;

    @ApiToken(desc = "信用中国-企业基本信息")
    @ApiModelProperty(value = "信用中国-企业基本信息")
    @GetMapping("/getbaseInfo")
    public ApiResultDTO getBaseInfo(@RequestBody ApiQueryForm api) {
        String name = api.getName();
        String creditCode = api.getCreditCode();
        validateInfo(name, creditCode);
        CreditchinaBaseInfoDTO dto = apiFacade.getBaseInfo(name, creditCode);
        return ApiResultDTO.ok().put("result", new Gson().toJson(dto));

    }


    @ApiToken(desc = "信用中国-行政许可信息")
    @ApiModelProperty(value = "信用中国-行政许可信息")
    @GetMapping("/getPermission")
    public ApiResultDTO getPermission(@RequestBody ApiQueryForm api) {
        String name = api.getName();
        String creditCode = api.getCreditCode();
        Integer currPage=api.getPageNum()==null?0:api.getPageNum();
        validateInfo(name, creditCode);
        PageUtils page = apiFacade.getPermissions(name, currPage);
        return ApiResultDTO.ok().put("result", new Gson().toJson(page));

    }



    @ApiToken(desc = "信用中国-行政处罚信息")
    @ApiModelProperty(value = "信用中国-行政处罚信息")
    @GetMapping("/getPenalty")
    public ApiResultDTO getPenalty(@RequestBody ApiQueryForm api) {
        String name = api.getName();
        String creditCode = api.getCreditCode();
        Integer currPage=api.getPageNum()==null?0:api.getPageNum();
        validateInfo(name, creditCode);
        PageUtils page  = apiFacade.getPenaltys(name, currPage);
        return ApiResultDTO.ok().put("result", new Gson().toJson(page));

    }

    @ApiToken(desc = "信用中国-守信红名单")
    @ApiModelProperty(value = "信用中国-守信红名单")
    @GetMapping("/getHonesty")
    public ApiResultDTO getHonesty(@RequestBody ApiQueryForm api) {
        String name = api.getName();
        String creditCode = api.getCreditCode();
        Integer currPage=api.getPageNum()==null?0:api.getPageNum();
        validateInfo(name, creditCode);
        PageUtils page  = apiFacade.getHonestys(name, currPage);
        return ApiResultDTO.ok().put("result", new Gson().toJson(page));

    }

    @ApiToken(desc = "信用中国-重点关注名单")
    @ApiModelProperty(value = "信用中国-重点关注名单")
    @GetMapping("/getFocus")
    public ApiResultDTO getFocus(@RequestBody ApiQueryForm api) {
        String name = api.getName();
        String creditCode = api.getCreditCode();
        Integer currPage=api.getPageNum()==null?0:api.getPageNum();
        validateInfo(name, creditCode);
        PageUtils page  = apiFacade.getFocuss(name, currPage);
        return ApiResultDTO.ok().put("result", new Gson().toJson(page));

    }

    @ApiToken(desc = "信用中国-黑名单")
    @ApiModelProperty(value = "信用中国-黑名单")
    @GetMapping("/getBlack")
    public ApiResultDTO getBlack(@RequestBody ApiQueryForm api) {
        String name = api.getName();
        String creditCode = api.getCreditCode();
        Integer currPage=api.getPageNum()==null?0:api.getPageNum();
        validateInfo(name, creditCode);
        PageUtils page  = apiFacade.getBlacks(name, currPage);
        return ApiResultDTO.ok().put("result", new Gson().toJson(page));

    }

    private ApiResultDTO validateInfo(String enterpriseName, String creditCode) {
        if (StringUtils.isBlank(enterpriseName) && StringUtils.isBlank(creditCode)) {
            return ApiResultDTO.error(9998, "企业名称和统一社会信用代码不能同时为空");
        }
        return null;
    }
}
