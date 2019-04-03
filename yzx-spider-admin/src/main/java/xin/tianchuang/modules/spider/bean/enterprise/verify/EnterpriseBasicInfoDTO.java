package xin.tianchuang.modules.spider.bean.enterprise.verify;

/**
 * 照面信息
 * 
 * @author denghui
 * 
 */
public class EnterpriseBasicInfoDTO {
	// -1 吊销
	// 0 未知
	// 1 开业
	// 2 其他
	// 3 迁出
	// 4 存续
	private String status;// 经营状态
	private String address;// 地址
	private String abuItem;// 许可经营项⽬
	private String cbuItem;// 一般经营项⽬
	private String opScoAndForm;// 经营（业务）范围及⽅式

	private String orgCode;// 组织机构代码
	private String opScope;// 经营业务范围
	private String regOrg;// 登记机关
	private String ancheYear;// 最后年检年度
	private String frName;// 法定代表⼈／负责⼈／执⾏事务合伙⼈

	private String regNo;// 注册号
	private String canDate;// 注销⽇
	private String regCap;// 注册资本（万元）
	private String revDate;// 吊销⽇期
	private String industryPhyCode;// ⾏业门类代码

	private String industryPhyName;// ⾏业门类名
	private String industryCoCode;// 国民经济⾏业代码
	private String industryCoName;// 国民经济⾏业名称
	private String recCap;// 实收资本（万元）
	private String regCapCur;// 注册资本币种

	private String oriRegNo;// 原注册号
	private String esDate;// 开业⽇期
	private String opFrom;// 经营期限⾃
	private String opTo;// 经营期限⾄
	// 0 未知
	// 1 有限责任公司
	// 2 其他有限责任公司
	// 3 全民所有制
	// 4 个体
	// 5 常驻代表机构
	// 6 分公司
	// 7 特殊普通合伙企业分?机构
	// 8 其他股份有限公司
	// 9 有限责任公司分公司
	// 10 个?独资企业分?机构
	// 11 有限合伙企业
	// 12 国有事业单位营业
	// 13 办事处
	// 14 其他
	// 15 个?独资企业
	// 16 集体社团法?营业
	// 17 集体分?机构
	// 18 股份有限公司分公司
	// 19 普通合伙企业分?机构
	// 20 股份有限公司
	// 21 普通合伙企业
	// 22 有限责公司分公司
	// 23 集体事业单位营业
	// 24 内资
	// 25 全民所有制分?机构
	// 26 其他有限责任公司分公司
	// 27 集体所有制
	// 28 联营
	// 29 ?公司外商投资企业分?机构
	// 30 农民专业合作经济组织
	// 31 其他股份有限公司分公司
	// 32 股份合作制
	// 40 个?经营
	// 41 股份制企业
	// 42 合伙企业
	// 43 家庭经营
	// 44 国有经营单位
	// 45 股份制
	// 46 集体经营单位
	// 47 股份制分?机构
	// 48 农民专业合作社
	// 49 农民专业合作社分?机构
	// 50 外商投资合伙企业分?机构
	// 51 外商投资企业分?机构
	// 52 集体企业
	// 53 合作社
	// 54 私营独资企业分?机构
	// 55 股份合作企业分?机构
	// 56 集体企业经营单位
	// 57 股份合作企业经营单位
	// 58 国有企业经营单位
	// 59 外商独资经营企业分?机构
	// 60 中外合资经营企业分?机构
	// 61 事业单位营业
	// 62 外商投资企业
	// 63 国有社团法?营业
	// 64 台、港、澳投资企业分?机构
	// 65 个?合伙
	// 66 ?公司私营企业
	// 69 企业在中国境内从事经营活动
	// 70 ?公司
	// 71 事业法?单位营业
	// 75 国有经济
	// 76 集体经济
	// 77 经营单位
	// 80 社团法?营业
	// 81 ?政事业单位
	// 98 私营独资
	// 99 国有企业
	private String entType;// 企业（机构）类型

	private String companyName;// 公司名称
	// 0 未知
	// 1 [0, 30)
	// 2 [30, 50)
	// 3 [50, 100)
	// 4 [100, 500)
	// 5 [500, 1000)
	// 6 [1000, 10000)
	// 7 [10000, +)
	private String companyScale;// 公司规模
	private String regBureau;// 注册公安分局⽇期
	private String phone;// 电话号码
	private String website;// 公司⽹站

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAbuItem() {
		return abuItem;
	}

	public void setAbuItem(String abuItem) {
		this.abuItem = abuItem;
	}

	public String getCbuItem() {
		return cbuItem;
	}

	public void setCbuItem(String cbuItem) {
		this.cbuItem = cbuItem;
	}

	public String getOpScoAndForm() {
		return opScoAndForm;
	}

	public void setOpScoAndForm(String opScoAndForm) {
		this.opScoAndForm = opScoAndForm;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOpScope() {
		return opScope;
	}

	public void setOpScope(String opScope) {
		this.opScope = opScope;
	}

	public String getRegOrg() {
		return regOrg;
	}

	public void setRegOrg(String regOrg) {
		this.regOrg = regOrg;
	}

	public String getAncheYear() {
		return ancheYear;
	}

	public void setAncheYear(String ancheYear) {
		this.ancheYear = ancheYear;
	}

	public String getFrName() {
		return frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getCanDate() {
		return canDate;
	}

	public void setCanDate(String canDate) {
		this.canDate = canDate;
	}

	public String getRegCap() {
		return regCap;
	}

	public void setRegCap(String regCap) {
		this.regCap = regCap;
	}

	public String getRevDate() {
		return revDate;
	}

	public void setRevDate(String revDate) {
		this.revDate = revDate;
	}

	public String getIndustryPhyCode() {
		return industryPhyCode;
	}

	public void setIndustryPhyCode(String industryPhyCode) {
		this.industryPhyCode = industryPhyCode;
	}

	public String getIndustryPhyName() {
		return industryPhyName;
	}

	public void setIndustryPhyName(String industryPhyName) {
		this.industryPhyName = industryPhyName;
	}

	public String getIndustryCoCode() {
		return industryCoCode;
	}

	public void setIndustryCoCode(String industryCoCode) {
		this.industryCoCode = industryCoCode;
	}

	public String getIndustryCoName() {
		return industryCoName;
	}

	public void setIndustryCoName(String industryCoName) {
		this.industryCoName = industryCoName;
	}

	public String getRecCap() {
		return recCap;
	}

	public void setRecCap(String recCap) {
		this.recCap = recCap;
	}

	public String getRegCapCur() {
		return regCapCur;
	}

	public void setRegCapCur(String regCapCur) {
		this.regCapCur = regCapCur;
	}

	public String getOriRegNo() {
		return oriRegNo;
	}

	public void setOriRegNo(String oriRegNo) {
		this.oriRegNo = oriRegNo;
	}

	public String getEsDate() {
		return esDate;
	}

	public void setEsDate(String esDate) {
		this.esDate = esDate;
	}

	public String getOpFrom() {
		return opFrom;
	}

	public void setOpFrom(String opFrom) {
		this.opFrom = opFrom;
	}

	public String getOpTo() {
		return opTo;
	}

	public void setOpTo(String opTo) {
		this.opTo = opTo;
	}

	public String getEntType() {
		return entType;
	}

	public void setEntType(String entType) {
		this.entType = entType;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyScale() {
		return companyScale;
	}

	public void setCompanyScale(String companyScale) {
		this.companyScale = companyScale;
	}

	public String getRegBureau() {
		return regBureau;
	}

	public void setRegBureau(String regBureau) {
		this.regBureau = regBureau;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

}
