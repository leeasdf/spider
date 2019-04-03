package xin.tianchuang.modules.spider.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 省发改委-工商基础信息(省工商局)
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:19
 */
@TableName("cs_sfgw_aic_infoetail")
public class CsSfgwAicInfoetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 数据状态（0：正常 1：更新 2：删除）
	 */
	private Integer isinvalid;
	/**
	 * 数据最后修改时间
	 */
	private Date lastdate;
	/**
	 * 企业(机构)名称
	 */
	private String entname;
	/**
	 * 原注册号
	 */
	private String oriregno;
	/**
	 * 注册号
	 */
	private String regno;
	/**
	 * 企业(机构)类型
	 */
	private String enttype;
	/**
	 * 隶属企业主体身份代码
	 */
	private String ppripid;
	/**
	 * 隶属企业机构名称
	 */
	private String pentname;
	/**
	 * 隶属企业注册号
	 */
	private String pregno;
	/**
	 * 隶属关系
	 */
	private String hypotaxis;
	/**
	 * 行业门类
	 */
	private String industryphy;
	/**
	 * 行业代码
	 */
	private String industryco;
	/**
	 * 许可经营项目
	 */
	private String abuitem;
	/**
	 * 一般经营项目
	 */
	private String cbuitem;
	/**
	 * 经营(驻在)期限自
	 */
	private Date opfrom;
	/**
	 * 经营(驻在)期限至
	 */
	private Date opto;
	/**
	 * 邮政编码
	 */
	private String postalcode;
	/**
	 * 联系电话
	 */
	private String tel;
	/**
	 * 电子邮箱
	 */
	private String email;
	/**
	 * 属地监管工商所
	 */
	private String localadm;
	/**
	 * 信用等级
	 */
	private String credlevel;
	/**
	 * 分类日期
	 */
	private Date assdate;
	/**
	 * 成立日期
	 */
	private Date estdate;
	/**
	 * 核准日期
	 */
	private Date issblicdate;
	/**
	 * 登记机关
	 */
	private String regorg;
	/**
	 * 企业分类码
	 */
	private String entcat;
	/**
	 * 企业状态
	 */
	private String opstate;
	/**
	 * 注册资金
	 */
	private BigDecimal regcap;
	/**
	 * 经营(业务)范围
	 */
	private String opscope;
	/**
	 * 经营方式
	 */
	private String opform;
	/**
	 * 经营范围及方式
	 */
	private String opscoandform;
	/**
	 * 兼营范围
	 */
	private String ptbusscope;
	/**
	 * 住所所在行政区划
	 */
	private String domdistrict;
	/**
	 * 住所
	 */
	private String dom;
	/**
	 * 住所所在经济开发区
	 */
	private String ecotecdevzone;
	/**
	 * 住所产权
	 */
	private String domproright;
	/**
	 * 经营场所所在行政区划
	 */
	private String oplocdistrict;
	/**
	 * 经营场所
	 */
	private String promana;
	/**
	 * 实收资本
	 */
	private BigDecimal reccap;
	/**
	 * 设立方式
	 */
	private String insform;
	/**
	 * 合伙人数
	 */
	private Integer parnum;
	/**
	 * 有限合伙人数
	 */
	private String limparnum;
	/**
	 * 合伙方式
	 */
	private Integer parform;
	/**
	 * 执行人数
	 */
	private Integer exenum;
	/**
	 * 从业人数
	 */
	private String empnum;
	/**
	 * 出资方式(个独)或组成形式（个体）
	 */
	private String sconform;
	/**
	 * 外资产业代码
	 */
	private String forcapindcode;
	/**
	 * 中西部优势产业代码
	 */
	private String midpreindcode;
	/**
	 * 项目类型
	 */
	private String protype;
	/**
	 * 投资总额
	 */
	private BigDecimal congro;
	/**
	 * 投资总额币种
	 */
	private String congrocur;
	/**
	 * 投资总额折万美元
	 */
	private BigDecimal congrousd;
	/**
	 * 注册资本(金)折万美元
	 */
	private BigDecimal regcapusd;
	/**
	 * 注册资本(金)币种
	 */
	private String regcapcur;
	/**
	 * 注册资本(金)折万人民币
	 */
	private BigDecimal regcaprmb;
	/**
	 * 外方注册资本(金)币种
	 */
	private String forregcapcur;
	/**
	 * 外方注册资本(金)折万美元
	 */
	private BigDecimal forregcapusd;
	/**
	 * 外方实收资本折万美元
	 */
	private BigDecimal forreccapusd;
	/**
	 * 营运资金
	 */
	private BigDecimal worcap;
	/**
	 * 转型日期
	 */
	private Date chamecdate;
	/**
	 * 经营活动类型
	 */
	private String opracttype;
	/**
	 * 外国(地区)企业名称
	 */
	private String forentname;
	/**
	 * 主管部门
	 */
	private String depincha;
	/**
	 * 国别(地区)
	 */
	private String country;
	/**
	 * 承包工程或经营管理项目
	 */
	private String itemofoporcpro;
	/**
	 * 承包工程或经营管理内容
	 */
	private String conofcontrpro;
	/**
	 * 境外住所
	 */
	private String fordom;
	/**
	 * 境外注册资本
	 */
	private BigDecimal forregecap;
	/**
	 * 境外经营范围
	 */
	private String foropscope;
	/**
	 * 企业性质
	 */
	private String sExtEntproperty;
	/**
	 * 境外主体类型
	 */
	private Integer foreignbodytype;
	/**
	 * 经营类别
	 */
	private String manacate;
	/**
	 * 统一社会信用代码
	 */
	private String uscc;
	/**
	 * 
	 */
	private String puniscid;
	/**
	 * 主体身份代码
	 */
	private String etpsId;
	/**
	 * 主键
	 */
	@TableId(value = "zjid", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long zjid;

	/**
	 * 设置：数据状态（0：正常 1：更新 2：删除）
	 */
	public void setIsinvalid(Integer isinvalid) {
		this.isinvalid = isinvalid;
	}
	/**
	 * 获取：数据状态（0：正常 1：更新 2：删除）
	 */
	public Integer getIsinvalid() {
		return isinvalid;
	}
	/**
	 * 设置：数据最后修改时间
	 */
	public void setLastdate(Date lastdate) {
		this.lastdate = lastdate;
	}
	/**
	 * 获取：数据最后修改时间
	 */
	public Date getLastdate() {
		return lastdate;
	}
	/**
	 * 设置：企业(机构)名称
	 */
	public void setEntname(String entname) {
		this.entname = entname;
	}
	/**
	 * 获取：企业(机构)名称
	 */
	public String getEntname() {
		return entname;
	}
	/**
	 * 设置：原注册号
	 */
	public void setOriregno(String oriregno) {
		this.oriregno = oriregno;
	}
	/**
	 * 获取：原注册号
	 */
	public String getOriregno() {
		return oriregno;
	}
	/**
	 * 设置：注册号
	 */
	public void setRegno(String regno) {
		this.regno = regno;
	}
	/**
	 * 获取：注册号
	 */
	public String getRegno() {
		return regno;
	}
	/**
	 * 设置：企业(机构)类型
	 */
	public void setEnttype(String enttype) {
		this.enttype = enttype;
	}
	/**
	 * 获取：企业(机构)类型
	 */
	public String getEnttype() {
		return enttype;
	}
	/**
	 * 设置：隶属企业主体身份代码
	 */
	public void setPpripid(String ppripid) {
		this.ppripid = ppripid;
	}
	/**
	 * 获取：隶属企业主体身份代码
	 */
	public String getPpripid() {
		return ppripid;
	}
	/**
	 * 设置：隶属企业机构名称
	 */
	public void setPentname(String pentname) {
		this.pentname = pentname;
	}
	/**
	 * 获取：隶属企业机构名称
	 */
	public String getPentname() {
		return pentname;
	}
	/**
	 * 设置：隶属企业注册号
	 */
	public void setPregno(String pregno) {
		this.pregno = pregno;
	}
	/**
	 * 获取：隶属企业注册号
	 */
	public String getPregno() {
		return pregno;
	}
	/**
	 * 设置：隶属关系
	 */
	public void setHypotaxis(String hypotaxis) {
		this.hypotaxis = hypotaxis;
	}
	/**
	 * 获取：隶属关系
	 */
	public String getHypotaxis() {
		return hypotaxis;
	}
	/**
	 * 设置：行业门类
	 */
	public void setIndustryphy(String industryphy) {
		this.industryphy = industryphy;
	}
	/**
	 * 获取：行业门类
	 */
	public String getIndustryphy() {
		return industryphy;
	}
	/**
	 * 设置：行业代码
	 */
	public void setIndustryco(String industryco) {
		this.industryco = industryco;
	}
	/**
	 * 获取：行业代码
	 */
	public String getIndustryco() {
		return industryco;
	}
	/**
	 * 设置：许可经营项目
	 */
	public void setAbuitem(String abuitem) {
		this.abuitem = abuitem;
	}
	/**
	 * 获取：许可经营项目
	 */
	public String getAbuitem() {
		return abuitem;
	}
	/**
	 * 设置：一般经营项目
	 */
	public void setCbuitem(String cbuitem) {
		this.cbuitem = cbuitem;
	}
	/**
	 * 获取：一般经营项目
	 */
	public String getCbuitem() {
		return cbuitem;
	}
	/**
	 * 设置：经营(驻在)期限自
	 */
	public void setOpfrom(Date opfrom) {
		this.opfrom = opfrom;
	}
	/**
	 * 获取：经营(驻在)期限自
	 */
	public Date getOpfrom() {
		return opfrom;
	}
	/**
	 * 设置：经营(驻在)期限至
	 */
	public void setOpto(Date opto) {
		this.opto = opto;
	}
	/**
	 * 获取：经营(驻在)期限至
	 */
	public Date getOpto() {
		return opto;
	}
	/**
	 * 设置：邮政编码
	 */
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	/**
	 * 获取：邮政编码
	 */
	public String getPostalcode() {
		return postalcode;
	}
	/**
	 * 设置：联系电话
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * 获取：联系电话
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * 设置：电子邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：电子邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：属地监管工商所
	 */
	public void setLocaladm(String localadm) {
		this.localadm = localadm;
	}
	/**
	 * 获取：属地监管工商所
	 */
	public String getLocaladm() {
		return localadm;
	}
	/**
	 * 设置：信用等级
	 */
	public void setCredlevel(String credlevel) {
		this.credlevel = credlevel;
	}
	/**
	 * 获取：信用等级
	 */
	public String getCredlevel() {
		return credlevel;
	}
	/**
	 * 设置：分类日期
	 */
	public void setAssdate(Date assdate) {
		this.assdate = assdate;
	}
	/**
	 * 获取：分类日期
	 */
	public Date getAssdate() {
		return assdate;
	}
	/**
	 * 设置：成立日期
	 */
	public void setEstdate(Date estdate) {
		this.estdate = estdate;
	}
	/**
	 * 获取：成立日期
	 */
	public Date getEstdate() {
		return estdate;
	}
	/**
	 * 设置：核准日期
	 */
	public void setIssblicdate(Date issblicdate) {
		this.issblicdate = issblicdate;
	}
	/**
	 * 获取：核准日期
	 */
	public Date getIssblicdate() {
		return issblicdate;
	}
	/**
	 * 设置：登记机关
	 */
	public void setRegorg(String regorg) {
		this.regorg = regorg;
	}
	/**
	 * 获取：登记机关
	 */
	public String getRegorg() {
		return regorg;
	}
	/**
	 * 设置：企业分类码
	 */
	public void setEntcat(String entcat) {
		this.entcat = entcat;
	}
	/**
	 * 获取：企业分类码
	 */
	public String getEntcat() {
		return entcat;
	}
	/**
	 * 设置：企业状态
	 */
	public void setOpstate(String opstate) {
		this.opstate = opstate;
	}
	/**
	 * 获取：企业状态
	 */
	public String getOpstate() {
		return opstate;
	}
	/**
	 * 设置：注册资金
	 */
	public void setRegcap(BigDecimal regcap) {
		this.regcap = regcap;
	}
	/**
	 * 获取：注册资金
	 */
	public BigDecimal getRegcap() {
		return regcap;
	}
	/**
	 * 设置：经营(业务)范围
	 */
	public void setOpscope(String opscope) {
		this.opscope = opscope;
	}
	/**
	 * 获取：经营(业务)范围
	 */
	public String getOpscope() {
		return opscope;
	}
	/**
	 * 设置：经营方式
	 */
	public void setOpform(String opform) {
		this.opform = opform;
	}
	/**
	 * 获取：经营方式
	 */
	public String getOpform() {
		return opform;
	}
	/**
	 * 设置：经营范围及方式
	 */
	public void setOpscoandform(String opscoandform) {
		this.opscoandform = opscoandform;
	}
	/**
	 * 获取：经营范围及方式
	 */
	public String getOpscoandform() {
		return opscoandform;
	}
	/**
	 * 设置：兼营范围
	 */
	public void setPtbusscope(String ptbusscope) {
		this.ptbusscope = ptbusscope;
	}
	/**
	 * 获取：兼营范围
	 */
	public String getPtbusscope() {
		return ptbusscope;
	}
	/**
	 * 设置：住所所在行政区划
	 */
	public void setDomdistrict(String domdistrict) {
		this.domdistrict = domdistrict;
	}
	/**
	 * 获取：住所所在行政区划
	 */
	public String getDomdistrict() {
		return domdistrict;
	}
	/**
	 * 设置：住所
	 */
	public void setDom(String dom) {
		this.dom = dom;
	}
	/**
	 * 获取：住所
	 */
	public String getDom() {
		return dom;
	}
	/**
	 * 设置：住所所在经济开发区
	 */
	public void setEcotecdevzone(String ecotecdevzone) {
		this.ecotecdevzone = ecotecdevzone;
	}
	/**
	 * 获取：住所所在经济开发区
	 */
	public String getEcotecdevzone() {
		return ecotecdevzone;
	}
	/**
	 * 设置：住所产权
	 */
	public void setDomproright(String domproright) {
		this.domproright = domproright;
	}
	/**
	 * 获取：住所产权
	 */
	public String getDomproright() {
		return domproright;
	}
	/**
	 * 设置：经营场所所在行政区划
	 */
	public void setOplocdistrict(String oplocdistrict) {
		this.oplocdistrict = oplocdistrict;
	}
	/**
	 * 获取：经营场所所在行政区划
	 */
	public String getOplocdistrict() {
		return oplocdistrict;
	}
	/**
	 * 设置：经营场所
	 */
	public void setPromana(String promana) {
		this.promana = promana;
	}
	/**
	 * 获取：经营场所
	 */
	public String getPromana() {
		return promana;
	}
	/**
	 * 设置：实收资本
	 */
	public void setReccap(BigDecimal reccap) {
		this.reccap = reccap;
	}
	/**
	 * 获取：实收资本
	 */
	public BigDecimal getReccap() {
		return reccap;
	}
	/**
	 * 设置：设立方式
	 */
	public void setInsform(String insform) {
		this.insform = insform;
	}
	/**
	 * 获取：设立方式
	 */
	public String getInsform() {
		return insform;
	}
	/**
	 * 设置：合伙人数
	 */
	public void setParnum(Integer parnum) {
		this.parnum = parnum;
	}
	/**
	 * 获取：合伙人数
	 */
	public Integer getParnum() {
		return parnum;
	}
	/**
	 * 设置：有限合伙人数
	 */
	public void setLimparnum(String limparnum) {
		this.limparnum = limparnum;
	}
	/**
	 * 获取：有限合伙人数
	 */
	public String getLimparnum() {
		return limparnum;
	}
	/**
	 * 设置：合伙方式
	 */
	public void setParform(Integer parform) {
		this.parform = parform;
	}
	/**
	 * 获取：合伙方式
	 */
	public Integer getParform() {
		return parform;
	}
	/**
	 * 设置：执行人数
	 */
	public void setExenum(Integer exenum) {
		this.exenum = exenum;
	}
	/**
	 * 获取：执行人数
	 */
	public Integer getExenum() {
		return exenum;
	}
	/**
	 * 设置：从业人数
	 */
	public void setEmpnum(String empnum) {
		this.empnum = empnum;
	}
	/**
	 * 获取：从业人数
	 */
	public String getEmpnum() {
		return empnum;
	}
	/**
	 * 设置：出资方式(个独)或组成形式（个体）
	 */
	public void setSconform(String sconform) {
		this.sconform = sconform;
	}
	/**
	 * 获取：出资方式(个独)或组成形式（个体）
	 */
	public String getSconform() {
		return sconform;
	}
	/**
	 * 设置：外资产业代码
	 */
	public void setForcapindcode(String forcapindcode) {
		this.forcapindcode = forcapindcode;
	}
	/**
	 * 获取：外资产业代码
	 */
	public String getForcapindcode() {
		return forcapindcode;
	}
	/**
	 * 设置：中西部优势产业代码
	 */
	public void setMidpreindcode(String midpreindcode) {
		this.midpreindcode = midpreindcode;
	}
	/**
	 * 获取：中西部优势产业代码
	 */
	public String getMidpreindcode() {
		return midpreindcode;
	}
	/**
	 * 设置：项目类型
	 */
	public void setProtype(String protype) {
		this.protype = protype;
	}
	/**
	 * 获取：项目类型
	 */
	public String getProtype() {
		return protype;
	}
	/**
	 * 设置：投资总额
	 */
	public void setCongro(BigDecimal congro) {
		this.congro = congro;
	}
	/**
	 * 获取：投资总额
	 */
	public BigDecimal getCongro() {
		return congro;
	}
	/**
	 * 设置：投资总额币种
	 */
	public void setCongrocur(String congrocur) {
		this.congrocur = congrocur;
	}
	/**
	 * 获取：投资总额币种
	 */
	public String getCongrocur() {
		return congrocur;
	}
	/**
	 * 设置：投资总额折万美元
	 */
	public void setCongrousd(BigDecimal congrousd) {
		this.congrousd = congrousd;
	}
	/**
	 * 获取：投资总额折万美元
	 */
	public BigDecimal getCongrousd() {
		return congrousd;
	}
	/**
	 * 设置：注册资本(金)折万美元
	 */
	public void setRegcapusd(BigDecimal regcapusd) {
		this.regcapusd = regcapusd;
	}
	/**
	 * 获取：注册资本(金)折万美元
	 */
	public BigDecimal getRegcapusd() {
		return regcapusd;
	}
	/**
	 * 设置：注册资本(金)币种
	 */
	public void setRegcapcur(String regcapcur) {
		this.regcapcur = regcapcur;
	}
	/**
	 * 获取：注册资本(金)币种
	 */
	public String getRegcapcur() {
		return regcapcur;
	}
	/**
	 * 设置：注册资本(金)折万人民币
	 */
	public void setRegcaprmb(BigDecimal regcaprmb) {
		this.regcaprmb = regcaprmb;
	}
	/**
	 * 获取：注册资本(金)折万人民币
	 */
	public BigDecimal getRegcaprmb() {
		return regcaprmb;
	}
	/**
	 * 设置：外方注册资本(金)币种
	 */
	public void setForregcapcur(String forregcapcur) {
		this.forregcapcur = forregcapcur;
	}
	/**
	 * 获取：外方注册资本(金)币种
	 */
	public String getForregcapcur() {
		return forregcapcur;
	}
	/**
	 * 设置：外方注册资本(金)折万美元
	 */
	public void setForregcapusd(BigDecimal forregcapusd) {
		this.forregcapusd = forregcapusd;
	}
	/**
	 * 获取：外方注册资本(金)折万美元
	 */
	public BigDecimal getForregcapusd() {
		return forregcapusd;
	}
	/**
	 * 设置：外方实收资本折万美元
	 */
	public void setForreccapusd(BigDecimal forreccapusd) {
		this.forreccapusd = forreccapusd;
	}
	/**
	 * 获取：外方实收资本折万美元
	 */
	public BigDecimal getForreccapusd() {
		return forreccapusd;
	}
	/**
	 * 设置：营运资金
	 */
	public void setWorcap(BigDecimal worcap) {
		this.worcap = worcap;
	}
	/**
	 * 获取：营运资金
	 */
	public BigDecimal getWorcap() {
		return worcap;
	}
	/**
	 * 设置：转型日期
	 */
	public void setChamecdate(Date chamecdate) {
		this.chamecdate = chamecdate;
	}
	/**
	 * 获取：转型日期
	 */
	public Date getChamecdate() {
		return chamecdate;
	}
	/**
	 * 设置：经营活动类型
	 */
	public void setOpracttype(String opracttype) {
		this.opracttype = opracttype;
	}
	/**
	 * 获取：经营活动类型
	 */
	public String getOpracttype() {
		return opracttype;
	}
	/**
	 * 设置：外国(地区)企业名称
	 */
	public void setForentname(String forentname) {
		this.forentname = forentname;
	}
	/**
	 * 获取：外国(地区)企业名称
	 */
	public String getForentname() {
		return forentname;
	}
	/**
	 * 设置：主管部门
	 */
	public void setDepincha(String depincha) {
		this.depincha = depincha;
	}
	/**
	 * 获取：主管部门
	 */
	public String getDepincha() {
		return depincha;
	}
	/**
	 * 设置：国别(地区)
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * 获取：国别(地区)
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * 设置：承包工程或经营管理项目
	 */
	public void setItemofoporcpro(String itemofoporcpro) {
		this.itemofoporcpro = itemofoporcpro;
	}
	/**
	 * 获取：承包工程或经营管理项目
	 */
	public String getItemofoporcpro() {
		return itemofoporcpro;
	}
	/**
	 * 设置：承包工程或经营管理内容
	 */
	public void setConofcontrpro(String conofcontrpro) {
		this.conofcontrpro = conofcontrpro;
	}
	/**
	 * 获取：承包工程或经营管理内容
	 */
	public String getConofcontrpro() {
		return conofcontrpro;
	}
	/**
	 * 设置：境外住所
	 */
	public void setFordom(String fordom) {
		this.fordom = fordom;
	}
	/**
	 * 获取：境外住所
	 */
	public String getFordom() {
		return fordom;
	}
	/**
	 * 设置：境外注册资本
	 */
	public void setForregecap(BigDecimal forregecap) {
		this.forregecap = forregecap;
	}
	/**
	 * 获取：境外注册资本
	 */
	public BigDecimal getForregecap() {
		return forregecap;
	}
	/**
	 * 设置：境外经营范围
	 */
	public void setForopscope(String foropscope) {
		this.foropscope = foropscope;
	}
	/**
	 * 获取：境外经营范围
	 */
	public String getForopscope() {
		return foropscope;
	}
	/**
	 * 设置：企业性质
	 */
	public void setSExtEntproperty(String sExtEntproperty) {
		this.sExtEntproperty = sExtEntproperty;
	}
	/**
	 * 获取：企业性质
	 */
	public String getSExtEntproperty() {
		return sExtEntproperty;
	}
	/**
	 * 设置：境外主体类型
	 */
	public void setForeignbodytype(Integer foreignbodytype) {
		this.foreignbodytype = foreignbodytype;
	}
	/**
	 * 获取：境外主体类型
	 */
	public Integer getForeignbodytype() {
		return foreignbodytype;
	}
	/**
	 * 设置：经营类别
	 */
	public void setManacate(String manacate) {
		this.manacate = manacate;
	}
	/**
	 * 获取：经营类别
	 */
	public String getManacate() {
		return manacate;
	}
	/**
	 * 设置：统一社会信用代码
	 */
	public void setUscc(String uscc) {
		this.uscc = uscc;
	}
	/**
	 * 获取：统一社会信用代码
	 */
	public String getUscc() {
		return uscc;
	}
	/**
	 * 设置：
	 */
	public void setPuniscid(String puniscid) {
		this.puniscid = puniscid;
	}
	/**
	 * 获取：
	 */
	public String getPuniscid() {
		return puniscid;
	}
	/**
	 * 设置：主体身份代码
	 */
	public void setEtpsId(String etpsId) {
		this.etpsId = etpsId;
	}
	/**
	 * 获取：主体身份代码
	 */
	public String getEtpsId() {
		return etpsId;
	}
	/**
	 * 设置：主键
	 */
	public void setZjid(Long zjid) {
		this.zjid = zjid;
	}
	/**
	 * 获取：主键
	 */
	public Long getZjid() {
		return zjid;
	}
}
