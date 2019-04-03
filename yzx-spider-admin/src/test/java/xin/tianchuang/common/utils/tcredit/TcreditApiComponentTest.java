package xin.tianchuang.common.utils.tcredit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import xin.tianchuang.modules.spider.bean.industrycommerce.PersonDTO;
import xin.tianchuang.modules.spider.bean.litigation.BadDataDTO;
import xin.tianchuang.modules.spider.bean.litigation.CpwsDTO;
import xin.tianchuang.modules.spider.bean.litigation.LitigationDataDTO;
import xin.tianchuang.modules.spider.bean.tpc.TpcDataDTO;
import xin.tianchuang.modules.spider.entity.RptTaxInfoEntity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class TcreditApiComponentTest {

    @Test
    public void testApi() {
        // String s = ApiComponent.getIndustryCommerce("湖南省泰亨能源科技有限公司",
        // "91430100320666995B");
        String s = ApiComponent.getIndustryCommerce("湖南今朝纵横通信工程有限公司", "914301003528626753");
        System.out.println(s);
    }

    @Test
    public void testbadInfo() {

        Map<String, String> map = new HashMap<String, String>();
        // 20180111
        // map.put("周新农", "430103196810091031");
        // map.put("周双红", "430123197005180023");
        // map.put("周利华", "430303196301300561");
        // map.put("赵年芬", "430103195509212047");
        // map.put("张伟", "430102197009060545");
        //
        // map.put("袁新平", "430626195909090028");
        // map.put("肖叶舟", "432627196810150046");
        // map.put("向雄飞", "432501197102210031");
        // map.put("谭建容", "430123197210209681");
        // map.put("潘晓晗", "430181198802220014");
        //
        // map.put("欧明厅", "432623196912277018");
        // map.put("罗孟姣", "430123195108300041");
        // map.put("罗赤橙", "432802196210132614");
        // map.put("刘成雁", "430104195410144327");
        // map.put("雷良", "430123197006120321");
        //
        // map.put("赖明球", "362422197708110033");
        // map.put("黄应节", "430103196306012066");
        // map.put("黄英", "430111196308090447");
        // map.put("黄杏", "520103196603272843");
        // map.put("黄石龙", "43020219630510403X");
        //
        // map.put("龚爽", "43230119761117252X");
        // map.put("段润生", "15263219660608302X");
        // map.put("陈汉良", "420500196206250033");
        // map.put("张翅翔", "430181197807200018");
        // map.put("刘志东", "430681198111243230");
        //
        // map.put("禹雪中", "41020219710301001X");
        // map.put("张敏", "652522196101295027");

        // map.put("刘锋成", "430104198310085650");
        // map.put("陈桃珍", "110105196503197723");
        // map.put("吴百求", "430681198604093728");
        // map.put("谢冰", "430104196811282514");
        // map.put("谢金国", "430121197306078150");
        // map.put("张慧香", "452327198201072421");
        // map.put("蒋昕", "430105195602240053");
        // map.put("李庆九", "510102196904058471");
        // map.put("何凡", "430104197208241018");
        // map.put("王力", "43020419630531403X");
        // map.put("李铁俊", "230603197302192316");
        // map.put("刘琦", "110102196805032327");
        // map.put("郑宝成", "130203196911024211");
        // map.put("万黎妮", "432401196206193029");
        // map.put("王建平", "410105196710172212");
        // map.put("王帅", "430923198306153211");
        // map.put("涂跃飞", "430202196904301019");
        // map.put("吴湘梅", "431381198809110020");
        // map.put("梁见权", "432421196802073010");
        // map.put("彭四立", "430102197510042519");
        // map.put("耿明皓", "430104198609192514");

        // map.put("葛鲁", "440301197410076670");
        // map.put("郭磊明", "132332197403222514");
        // map.put("杨雄秀", "362429197502070077");
        // map.put("唐晋喆", "421002197902231830");

        // map.put("黄艺文", "430322197806194120");
        // map.put("李玉阳", "430122197211045213");
        // map.put("廖翠娥", "432421195411099825");
        // map.put("彭灿宇", "430122197809114914");
        // map.put("周洪", "43012219770822521X");
        // map.put("张金波", "430122197811295216");
        //
        // map.put("马可", "412826198703090017");
        // map.put("敖勇", "410104197203091635");
        // map.put("刘星宇", "430481198404150037");

        // map.put("刘飞", "310103197906262437");
        // map.put("谢自韬", "430103196806104530");
        // map.put("周洋洲", "433101198807220516");
        // map.put("陈彬", "430426198911269257");

        // map.put("唐起华", "430181197411064910");

        // map.put("谭彦", "430426198608310018");
        // map.put("李剑", "432427197708310019");

        // map.put("车军辉", "13020319680710422X");
        // map.put("刘琦", "110102196805032327");
        map.put("张旭东", "310108196506302011");

        for (String key : map.keySet()) {
            getbad(key, map.get(key));
        }
    }

    private void getbad(String name, String idcard) {

        String legalBadInfo = ApiComponent.getBadInfo(name, idcard);
        System.out.println("返回信息：" + legalBadInfo);
        JSONObject json = JSONObject.parseObject(legalBadInfo);
        if (json != null && json.getString("status").equals("0")) {
            String result = json.getJSONObject("data").get("result").toString();// 0-无不良记录1-有不良数据2-系统无记录
            if ("1".equals(result)) {
                // 这里因为文档与示例数据不符，只能自己判断一下了。
                String items = json.getJSONObject("data").get("items").toString();
                String details = json.getJSONObject("data").get("items").toString();
                details = StringUtils.isBlank(details) ? items : details;
                List<BadDataDTO> legalBadInfoList = JSONObject.parseArray(details, BadDataDTO.class);
                if (legalBadInfoList != null && legalBadInfoList.size() > 0) {
                    for (BadDataDTO badInfo : legalBadInfoList) {
                        System.out.println(JSON.toJSON(badInfo));
                    }
                }
            }
        }
    }

/*    @Test
    public void testPersonLitigation() {
        // String plitigation = ApiComponent.getPersonLitigation("李俊松",
        // "34252919800512363X", "1");
        String plitigation = ApiComponent.getPersonLitigation("李俊松", "34252919800512363X", "1");
        JSONObject json = JSONObject.parseObject(plitigation);
        String data = json.getString("data");
        Plitigation plitigationVO = JSONObject.parseObject(data, PlitigationVO.class);
        System.out.println(plitigationVO);
    }*/

    @Test
    public void testTaxInfo() {
        String s = ApiComponent.getTaxInfo("湖南鸿发石油化工有限公司");
        JSONObject json = JSONObject.parseObject(s);
        String data = json.getString("data");
        JSONObject dataJson = JSONObject.parseObject(data);
        String taxes = dataJson.getString("taxes");
        if (taxes != null && !taxes.equals("")) {
            List<RptTaxInfoEntity> taxInfos = JSONObject.parseArray(taxes, RptTaxInfoEntity.class);
            System.out.println(taxInfos.size());
        }
    }

    @Test
    public void testTCPAPI() {
        String result = ApiComponent.getTpcInfo("湖南科创信息技术股份有限公司");
        TpcDataDTO tpcInfo = JSONObject.parseObject(result, TpcDataDTO.class);
        System.out.println(result);
        System.out.println(tpcInfo);
    }


    @Test
    public void testLitigation() {
        String s = ApiComponent.getEnterpriseLitigation("湖南今朝纵横通信工程有限公司", null);
        JSONObject json = JSONObject.parseObject(s);
        String data = json.getString("data");
        JSONObject dataObject = JSONObject.parseObject(data);
        String ktggData = dataObject.getString("cpwsList");// 开庭公告
        List<CpwsDTO> ktggs = JSONObject.parseArray(ktggData, CpwsDTO.class);
        for (CpwsDTO ktgg : ktggs) {
            String litigationdata = ApiComponent.getLitigationDetail(ktgg.getCpwsId(), "cpws");
            JSONObject json1 = JSONObject.parseObject(litigationdata);
            String data1 = json1.getString("data");
            JSONObject dataObject1 = JSONObject.parseObject(data1);
            String litString = dataObject1.getString("cpws");// 开庭公告
            List<LitigationDataDTO> litigationVO = JSONObject.parseArray(litString, LitigationDataDTO.class);
            System.out.println(litigationVO);
        }
    }

    @Test
    public void testLItigation() {
        String s = ApiComponent.getEnterpriseLitigation("湖南声闻投资管理有限公司", null);
        String result = JSONObject.parseObject(s).getJSONObject("ktggList").toString();
    }

    @Test
    public void jsonToData() {
        String ss = "{\"seqNum\":\"0291492679125289\",\"message\":\"成功\",\"status\":0,\"data\":{\"person\":\"\"}}";
        String s = " {\"seqNum\":\"0291492679125289\",\"message\":\"成功\",\"status\":0,\"data\":{\"person\":[{\"position\":\"执行董事\",\"sex\":\"\",\"natdate\":\"\",\"personamount\":\"3\",\"pername\":\"唐彬\"}]}}";
        JSONObject json = JSONObject.parseObject(s);
        String data = json.getString("data");
        JSONObject data2 = JSONObject.parseObject(data);
        System.out.println(data2.getString("person").equals(""));
        List<PersonDTO> list = JSONObject.parseArray(data2.getString("person"), PersonDTO.class);
        System.out.println(list.size());
    }

    @Test
    public void parseIndustry() {
        String ss = "{\"seqNum\":\"0291492679125289\",\"message\":\"成功\",\"status\":0,\"data\":{\"person\":\"\"}}";
        String s = " {\"seqNum\":\"0291492679125289\",\"message\":\"成功\",\"status\":0,\"data\":{\"person\":[{\"position\":\"执行董事\",\"sex\":\"\",\"natdate\":\"\",\"personamount\":\"3\",\"pername\":\"唐彬\"}]}}";
        JSONObject json = JSONObject.parseObject(ss);
        String data = json.getString("data");
        JSONObject dataObject = JSONObject.parseObject(data);
        String shareholder = dataObject.getString("shareholder");// 股东组成
        String person = dataObject.getString("person");// 高管信息
        String alter = dataObject.getString("alter");// 注册信息变更
        String caseinfo = dataObject.getString("caseinfo");// 注册信息变更
        String entinv = dataObject.getString("entinv");// 对外投资情况
        String filiation = dataObject.getString("filiation");// 对外投资情况
        String frposition = dataObject.getString("frposition");// 法人其他任职情况
        String frinv = dataObject.getString("frinv");// 法人其他投资情况

    }


}
