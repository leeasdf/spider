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
 * 企业-专利信息（天创信用)
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:18
 */
@TableName("rpt_tcxy_patent_base")
public class RptTcxyPatentBaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 公司ID
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long companyId;
	/**
	 * 专利名称
	 */
	private String title;
	/**
	 * 主分类号
	 */
	private String mainClassCode;
	/**
	 * 专利类型
	 */
	private String type;
	/**
	 * 分类号
	 */
	private String classCode;
	/**
	 * 发明人
	 */
	private String designer;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 专利摘要
	 */
	private String summary;
	/**
	 * 申请者
	 */
	private String applicant;
	/**
	 * 专利号
	 */
	private String patentNumber;
	/**
	 * 申请日期
	 */
	private Date applyDate;
	/**
	 * 专利代理机构
	 */
	private String agentOrg;
	/**
	 * 公开号
	 */
	private String pubNum;
	/**
	 * 代理人
	 */
	private String agent;
	/**
	 * 公开日期
	 */
	private Date pubDate;
	/**
	 * 国际公布
	 */
	private String intelPub;
	/**
	 * 国际申请
	 */
	private String intelApply;
	/**
	 * 进入国家日期
	 */
	private Date intoChinaDate;
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
	 * 设置：公司ID
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	/**
	 * 获取：公司ID
	 */
	public Long getCompanyId() {
		return companyId;
	}
	/**
	 * 设置：专利名称
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：专利名称
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：主分类号
	 */
	public void setMainClassCode(String mainClassCode) {
		this.mainClassCode = mainClassCode;
	}
	/**
	 * 获取：主分类号
	 */
	public String getMainClassCode() {
		return mainClassCode;
	}
	/**
	 * 设置：专利类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：专利类型
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：分类号
	 */
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}
	/**
	 * 获取：分类号
	 */
	public String getClassCode() {
		return classCode;
	}
	/**
	 * 设置：发明人
	 */
	public void setDesigner(String designer) {
		this.designer = designer;
	}
	/**
	 * 获取：发明人
	 */
	public String getDesigner() {
		return designer;
	}
	/**
	 * 设置：地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：专利摘要
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}
	/**
	 * 获取：专利摘要
	 */
	public String getSummary() {
		return summary;
	}
	/**
	 * 设置：申请者
	 */
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	/**
	 * 获取：申请者
	 */
	public String getApplicant() {
		return applicant;
	}
	/**
	 * 设置：专利号
	 */
	public void setPatentNumber(String patentNumber) {
		this.patentNumber = patentNumber;
	}
	/**
	 * 获取：专利号
	 */
	public String getPatentNumber() {
		return patentNumber;
	}
	/**
	 * 设置：申请日期
	 */
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	/**
	 * 获取：申请日期
	 */
	public Date getApplyDate() {
		return applyDate;
	}
	/**
	 * 设置：专利代理机构
	 */
	public void setAgentOrg(String agentOrg) {
		this.agentOrg = agentOrg;
	}
	/**
	 * 获取：专利代理机构
	 */
	public String getAgentOrg() {
		return agentOrg;
	}
	/**
	 * 设置：公开号
	 */
	public void setPubNum(String pubNum) {
		this.pubNum = pubNum;
	}
	/**
	 * 获取：公开号
	 */
	public String getPubNum() {
		return pubNum;
	}
	/**
	 * 设置：代理人
	 */
	public void setAgent(String agent) {
		this.agent = agent;
	}
	/**
	 * 获取：代理人
	 */
	public String getAgent() {
		return agent;
	}
	/**
	 * 设置：公开日期
	 */
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	/**
	 * 获取：公开日期
	 */
	public Date getPubDate() {
		return pubDate;
	}
	/**
	 * 设置：国际公布
	 */
	public void setIntelPub(String intelPub) {
		this.intelPub = intelPub;
	}
	/**
	 * 获取：国际公布
	 */
	public String getIntelPub() {
		return intelPub;
	}
	/**
	 * 设置：国际申请
	 */
	public void setIntelApply(String intelApply) {
		this.intelApply = intelApply;
	}
	/**
	 * 获取：国际申请
	 */
	public String getIntelApply() {
		return intelApply;
	}
	/**
	 * 设置：进入国家日期
	 */
	public void setIntoChinaDate(Date intoChinaDate) {
		this.intoChinaDate = intoChinaDate;
	}
	/**
	 * 获取：进入国家日期
	 */
	public Date getIntoChinaDate() {
		return intoChinaDate;
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
