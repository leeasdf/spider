package xin.tianchuang.modules.spider.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * 信用麓谷-企业工商信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:18
 */
@TableName("rpt_base_info")
public class RptBaseInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 会员ID
	 */
	private Integer memId;
	/**
	 * 企业ID
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long enterpriseId;
	/**
	 * 企业名称
	 */
	private String entname;
	/**
	 * 注册号
	 */
	private String regno;
	/**
	 * 原注册号
	 */
	private String oriregno;
	/**
	 * 法定代表人姓名
	 */
	private String frname;
	/**
	 * 
	 */
	private String regcap;
	/**
	 * 
	 */
	private String reccap;
	/**
	 * 币种
	 */
	private String regcapcur;
	/**
	 * 经营状态
	 */
	private String entstatus;
	/**
	 * 企业(机构)类型
	 */
	private String enttype;
	/**
	 * 开业日期
	 */
	private String esdate;
	/**
	 * 经营期限自
	 */
	private String opfrom;
	/**
	 * 经营期限至
	 */
	private String opto;
	/**
	 * 住址
	 */
	private String dom;
	/**
	 * 登记机关
	 */
	private String regorg;
	/**
	 * 
	 */
	private String abuitem;
	/**
	 * 
	 */
	private String cbuitem;
	/**
	 * 
	 */
	private String opscope;
	/**
	 * 
	 */
	private String opscoandform;
	/**
	 * 最后年检年度
	 */
	private String ancheyear;
	/**
	 * 变更日期
	 */
	private String changedate;
	/**
	 * 注销日期
	 */
	private String candate;
	/**
	 * 吊销日期
	 */
	private String revdate;
	/**
	 * 最后年检日期
	 */
	private String anchedate;
	/**
	 * 行业门类代码
	 */
	private String industryphycode;
	/**
	 * 行业门类名称
	 */
	private String industryphyname;
	/**
	 * 国民经济行业代码
	 */
	private String industrycocode;
	/**
	 * 国民经济行业名称
	 */
	private String industryconame;
	/**
	 * 创建时间
	 */
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;

	/**
	 * 设置：主键
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取：主键
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置：会员ID
	 */
	public void setMemId(Integer memId) {
		this.memId = memId;
	}

	/**
	 * 获取：会员ID
	 */
	public Integer getMemId() {
		return memId;
	}

	/**
	 * 设置：企业ID
	 */
	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	/**
	 * 获取：企业ID
	 */
	public Long getEnterpriseId() {
		return enterpriseId;
	}

	/**
	 * 设置：企业名称
	 */
	public void setEntname(String entname) {
		this.entname = entname;
	}

	/**
	 * 获取：企业名称
	 */
	public String getEntname() {
		return entname;
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
	 * 设置：法定代表人姓名
	 */
	public void setFrname(String frname) {
		this.frname = frname;
	}

	/**
	 * 获取：法定代表人姓名
	 */
	public String getFrname() {
		return frname;
	}

	/**
	 * 设置：
	 */
	public void setRegcap(String regcap) {
		this.regcap = regcap;
	}

	/**
	 * 获取：
	 */
	public String getRegcap() {
		return regcap;
	}

	/**
	 * 设置：
	 */
	public void setReccap(String reccap) {
		this.reccap = reccap;
	}

	/**
	 * 获取：
	 */
	public String getReccap() {
		return reccap;
	}

	/**
	 * 设置：币种
	 */
	public void setRegcapcur(String regcapcur) {
		this.regcapcur = regcapcur;
	}

	/**
	 * 获取：币种
	 */
	public String getRegcapcur() {
		return regcapcur;
	}

	/**
	 * 设置：经营状态
	 */
	public void setEntstatus(String entstatus) {
		this.entstatus = entstatus;
	}

	/**
	 * 获取：经营状态
	 */
	public String getEntstatus() {
		return entstatus;
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
	 * 设置：开业日期
	 */
	public void setEsdate(String esdate) {
		this.esdate = esdate;
	}

	/**
	 * 获取：开业日期
	 */
	public String getEsdate() {
		return esdate;
	}

	/**
	 * 设置：经营期限自
	 */
	public void setOpfrom(String opfrom) {
		this.opfrom = opfrom;
	}

	/**
	 * 获取：经营期限自
	 */
	public String getOpfrom() {
		return opfrom;
	}

	/**
	 * 设置：经营期限至
	 */
	public void setOpto(String opto) {
		this.opto = opto;
	}

	/**
	 * 获取：经营期限至
	 */
	public String getOpto() {
		return opto;
	}

	/**
	 * 设置：住址
	 */
	public void setDom(String dom) {
		this.dom = dom;
	}

	/**
	 * 获取：住址
	 */
	public String getDom() {
		return dom;
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
	 * 设置：
	 */
	public void setAbuitem(String abuitem) {
		this.abuitem = abuitem;
	}

	/**
	 * 获取：
	 */
	public String getAbuitem() {
		return abuitem;
	}

	/**
	 * 设置：
	 */
	public void setCbuitem(String cbuitem) {
		this.cbuitem = cbuitem;
	}

	/**
	 * 获取：
	 */
	public String getCbuitem() {
		return cbuitem;
	}

	/**
	 * 设置：
	 */
	public void setOpscope(String opscope) {
		this.opscope = opscope;
	}

	/**
	 * 获取：
	 */
	public String getOpscope() {
		return opscope;
	}

	/**
	 * 设置：
	 */
	public void setOpscoandform(String opscoandform) {
		this.opscoandform = opscoandform;
	}

	/**
	 * 获取：
	 */
	public String getOpscoandform() {
		return opscoandform;
	}

	/**
	 * 设置：最后年检年度
	 */
	public void setAncheyear(String ancheyear) {
		this.ancheyear = ancheyear;
	}

	/**
	 * 获取：最后年检年度
	 */
	public String getAncheyear() {
		return ancheyear;
	}

	/**
	 * 设置：变更日期
	 */
	public void setChangedate(String changedate) {
		this.changedate = changedate;
	}

	/**
	 * 获取：变更日期
	 */
	public String getChangedate() {
		return changedate;
	}

	/**
	 * 设置：注销日期
	 */
	public void setCandate(String candate) {
		this.candate = candate;
	}

	/**
	 * 获取：注销日期
	 */
	public String getCandate() {
		return candate;
	}

	/**
	 * 设置：吊销日期
	 */
	public void setRevdate(String revdate) {
		this.revdate = revdate;
	}

	/**
	 * 获取：吊销日期
	 */
	public String getRevdate() {
		return revdate;
	}

	/**
	 * 设置：最后年检日期
	 */
	public void setAnchedate(String anchedate) {
		this.anchedate = anchedate;
	}

	/**
	 * 获取：最后年检日期
	 */
	public String getAnchedate() {
		return anchedate;
	}

	/**
	 * 设置：行业门类代码
	 */
	public void setIndustryphycode(String industryphycode) {
		this.industryphycode = industryphycode;
	}

	/**
	 * 获取：行业门类代码
	 */
	public String getIndustryphycode() {
		return industryphycode;
	}

	/**
	 * 设置：行业门类名称
	 */
	public void setIndustryphyname(String industryphyname) {
		this.industryphyname = industryphyname;
	}

	/**
	 * 获取：行业门类名称
	 */
	public String getIndustryphyname() {
		return industryphyname;
	}

	/**
	 * 设置：国民经济行业代码
	 */
	public void setIndustrycocode(String industrycocode) {
		this.industrycocode = industrycocode;
	}

	/**
	 * 获取：国民经济行业代码
	 */
	public String getIndustrycocode() {
		return industrycocode;
	}

	/**
	 * 设置：国民经济行业名称
	 */
	public void setIndustryconame(String industryconame) {
		this.industryconame = industryconame;
	}

	/**
	 * 获取：国民经济行业名称
	 */
	public String getIndustryconame() {
		return industryconame;
	}

	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
