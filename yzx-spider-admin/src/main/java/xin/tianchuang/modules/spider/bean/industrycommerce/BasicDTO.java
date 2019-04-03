package xin.tianchuang.modules.spider.bean.industrycommerce;

import java.math.BigDecimal;

/**
 * 基本信息
 * 
 * @author jinlong.chen
 * @since 2017年4月20日 下午7:47:15
 * @version 1.0
 */
public class BasicDTO {
	private String entname;// 企业名称
	private String regno;// 注册号
	private String oriregno;// 原注册号
	private String frname;// 法定代表人姓名
	private BigDecimal regcap;// 注册资本

	private BigDecimal reccap;// 实收资本(万元)
	private String regcapcur;// 币种
	private String entstatus;// 经营状态
	private String enttype;// 企业(机构)类型
	private String esdate;// 开业日期

	private String opfrom;// 经营期限自
	private String opto;// 经营期限至
	private String dom;// 住址
	private String regorg;// 登记机关
	private String abuitem;// 许可经营项目

	private String cbuitem;// 一般经营项目
	private String opscope;// 经营(业务)范围
	private String opscoandform;// 经营(业务)范围及方式
	private String ancheyear;// 最后年检年度
	private String changedate;// 变更日期

	private String candate;// 注销日期
	private String revdate;// 吊销日期
	private String anchedate;// 最后年检日期
	private String industryphycode;// 行业门类代码
	private String industryphyname;// 行业门类名称

	private String industrycocode;// 国民经济行业代码
	private String industryconame;// 国民经济行业名称
	// new add
	private String creditcode; // 信用代码
	private String regorgprovince; // 注册机构省份
	private String tel; //联系电话

	private String empnum; //员工人数
	private String industryphyall; // I信息传输、软件和信息技术服务业
	private String industrycoall; // 653信息技术咨询服务
	private String entnameeng; // 湖南福米信息科技有限责任公司
	private String regorgcode;

	private String zsopscope;
	private String domdistrict;

	public String getEntname() {
		return entname;
	}

	public void setEntname(String entname) {
		this.entname = entname;
	}

	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}

	public String getOriregno() {
		return oriregno;
	}

	public void setOriregno(String oriregno) {
		this.oriregno = oriregno;
	}

	public String getFrname() {
		return frname;
	}

	public void setFrname(String frname) {
		this.frname = frname;
	}

	public BigDecimal getRegcap() {
		return regcap;
	}

	public void setRegcap(BigDecimal regcap) {
		this.regcap = regcap;
	}

	public BigDecimal getReccap() {
		return reccap;
	}

	public void setReccap(BigDecimal reccap) {
		this.reccap = reccap;
	}

	public String getRegcapcur() {
		return regcapcur;
	}

	public void setRegcapcur(String regcapcur) {
		this.regcapcur = regcapcur;
	}

	public String getEntstatus() {
		return entstatus;
	}

	public void setEntstatus(String entstatus) {
		this.entstatus = entstatus;
	}

	public String getEnttype() {
		return enttype;
	}

	public void setEnttype(String enttype) {
		this.enttype = enttype;
	}

	public String getEsdate() {
		return esdate;
	}

	public void setEsdate(String esdate) {
		this.esdate = esdate;
	}

	public String getOpfrom() {
		return opfrom;
	}

	public void setOpfrom(String opfrom) {
		this.opfrom = opfrom;
	}

	public String getOpto() {
		return opto;
	}

	public void setOpto(String opto) {
		this.opto = opto;
	}

	public String getDom() {
		return dom;
	}

	public void setDom(String dom) {
		this.dom = dom;
	}

	public String getRegorg() {
		return regorg;
	}

	public void setRegorg(String regorg) {
		this.regorg = regorg;
	}

	public String getAbuitem() {
		return abuitem;
	}

	public void setAbuitem(String abuitem) {
		this.abuitem = abuitem;
	}

	public String getCbuitem() {
		return cbuitem;
	}

	public void setCbuitem(String cbuitem) {
		this.cbuitem = cbuitem;
	}

	public String getOpscope() {
		return opscope;
	}

	public void setOpscope(String opscope) {
		this.opscope = opscope;
	}

	public String getOpscoandform() {
		return opscoandform;
	}

	public void setOpscoandform(String opscoandform) {
		this.opscoandform = opscoandform;
	}

	public String getAncheyear() {
		return ancheyear;
	}

	public void setAncheyear(String ancheyear) {
		this.ancheyear = ancheyear;
	}

	public String getChangedate() {
		return changedate;
	}

	public void setChangedate(String changedate) {
		this.changedate = changedate;
	}

	public String getCandate() {
		return candate;
	}

	public void setCandate(String candate) {
		this.candate = candate;
	}

	public String getRevdate() {
		return revdate;
	}

	public void setRevdate(String revdate) {
		this.revdate = revdate;
	}

	public String getAnchedate() {
		return anchedate;
	}

	public void setAnchedate(String anchedate) {
		this.anchedate = anchedate;
	}

	public String getIndustryphycode() {
		return industryphycode;
	}

	public void setIndustryphycode(String industryphycode) {
		this.industryphycode = industryphycode;
	}

	public String getIndustryphyname() {
		return industryphyname;
	}

	public void setIndustryphyname(String industryphyname) {
		this.industryphyname = industryphyname;
	}

	public String getIndustrycocode() {
		return industrycocode;
	}

	public void setIndustrycocode(String industrycocode) {
		this.industrycocode = industrycocode;
	}

	public String getIndustryconame() {
		return industryconame;
	}

	public void setIndustryconame(String industryconame) {
		this.industryconame = industryconame;
	}

	public String getCreditcode() {
		return creditcode;
	}

	public void setCreditcode(String creditcode) {
		this.creditcode = creditcode;
	}

	public String getRegorgprovince() {
		return regorgprovince;
	}

	public void setRegorgprovince(String regorgprovince) {
		this.regorgprovince = regorgprovince;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmpnum() {
		return empnum;
	}

	public void setEmpnum(String empnum) {
		this.empnum = empnum;
	}

	public String getIndustryphyall() {
		return industryphyall;
	}

	public void setIndustryphyall(String industryphyall) {
		this.industryphyall = industryphyall;
	}

	public String getIndustrycoall() {
		return industrycoall;
	}

	public void setIndustrycoall(String industrycoall) {
		this.industrycoall = industrycoall;
	}

	public String getEntnameeng() {
		return entnameeng;
	}

	public void setEntnameeng(String entnameeng) {
		this.entnameeng = entnameeng;
	}

	public String getRegorgcode() {
		return regorgcode;
	}

	public void setRegorgcode(String regorgcode) {
		this.regorgcode = regorgcode;
	}

	public String getZsopscope() {
		return zsopscope;
	}

	public void setZsopscope(String zsopscope) {
		this.zsopscope = zsopscope;
	}

	public String getDomdistrict() {
		return domdistrict;
	}

	public void setDomdistrict(String domdistrict) {
		this.domdistrict = domdistrict;
	}

}
