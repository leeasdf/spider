package xin.tianchuang.modules.externalApi.qichacha.config;

/**
 * Created by lee on 2018/12/20.
 */
public class QichachaStatusCode {

    /**
     * ====================
     * 服务级错误码参照(error_code)：
     * ====================
     */
    public static final String CODE_200 = "200";
    public static final String CODE_200_MESSAGE="查询成功";

    public static final String CODE_201 = "201";
    public static final String CODE_201_MESSAGE="查询无结果";

    public static final String CODE_202 = "202";
    public static final String CODE_202_MESSAGE="查询参数错误，请检查";

    public static final String CODE_203 = "203";
    public static final String CODE_203_MESSAGE="系统查询有异常，请联系技术人员";

    public static final String CODE_204 = "204";
    public static final String CODE_204_MESSAGE="请至少输入一个参数";

    public static final String CODE_205 = "205";
    public static final String CODE_205_MESSAGE="等待处理中";

    public static final String CODE_206 = "206";
    public static final String CODE_206_MESSAGE="无效的省份代码";

    public static final String CODE_207 = "207";
    public static final String CODE_207_MESSAGE="请求数据的条目数超过上限（5000）";

    public static final String CODE_208 = "208";
    public static final String CODE_208_MESSAGE="请求数据过旧";

    public static final String CODE_213 = "213";
    public static final String CODE_213_MESSAGE="参数长度不能小于2";

    public static final String CODE_214 = "214";
    public static final String CODE_214_MESSAGE="未申请该接口";

    public static final String CODE_215 = "215";
    public static final String CODE_215_MESSAGE="不支持的查询关键字";

    public static final String CODE_216 = "216";
    public static final String CODE_216_MESSAGE="国家代码不正确";

    public static final String CODE_221 = "221";
    public static final String CODE_221_MESSAGE="发票校验失败（参数与发票号码不对应）";

    public static final String CODE_222 = "222";
    public static final String CODE_222_MESSAGE="超过发票当日查验次数，请次日再试";

    public static final String CODE_299 = "299";
    public static final String CODE_299_MESSAGE="无效的请求";

    /**
     * ====================
     * 系统级错误码参照：
     * ====================
     */

    public static final String CODE_101 = "101";
    public static final String CODE_101_MESSAGE="当前的KEY无效或者还未生效中";

    public static final String CODE_102 = "102";
    public static final String CODE_102_MESSAGE="当前KEY已欠费";

    public static final String CODE_103 = "103";
    public static final String CODE_103_MESSAGE="当前Key被暂停使用";

    public static final String CODE_104 = "104";
    public static final String CODE_104_MESSAGE="接口正在维护中";

    public static final String CODE_105 = "105";
    public static final String CODE_105_MESSAGE="接口已下线停用";

    public static final String CODE_107 = "107";
    public static final String CODE_107_MESSAGE="被禁止的IP或者签名错误";

    public static final String CODE_108 = "108";
    public static final String CODE_108_MESSAGE="请求格式错误，请重试";

    public static final String CODE_109 = "109";
    public static final String CODE_109_MESSAGE="请求超过系统限制";

    public static final String CODE_110 = "110";
    public static final String CODE_110_MESSAGE="当前相同查询连续出错，请等2小时后重试";

    public static final String CODE_111 = "111";
    public static final String CODE_111_MESSAGE="接口权限未开通";

    public static final String CODE_112 = "112";
    public static final String CODE_112_MESSAGE="当前账户已欠费";

    public static final String CODE_199 = "199";
    public static final String CODE_199_MESSAGE="系统未知错误，请联系技术客服";

}
