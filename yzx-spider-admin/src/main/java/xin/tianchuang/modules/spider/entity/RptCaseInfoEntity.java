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
 * 信用麓谷-行政处罚信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:18
 */
@TableName("rpt_case_info")
public class RptCaseInfoEntity implements Serializable {
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
	private Integer memid;
	/**
	 * 企业ID
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long enterpriseId;
	/**
	 * 案发时间
	 */
	private String casetime;
	/**
	 * 案由
	 */
	private String casereason;
	/**
	 * 案值
	 */
	private String caseval;
	/**
	 * 案件类型
	 */
	private String casetype;
	/**
	 * 执行类别
	 */
	private String exesort;
	/**
	 * 案件结果
	 */
	private String caseresult;
	/**
	 * 处罚决定文书
	 */
	private String pendecno;
	/**
	 * 处罚决定书签发日期
	 */
	private String pendecissdate;
	/**
	 * 作出行政处罚决定机关名称
	 */
	private String penauth;
	/**
	 * 主要违法事实
	 */
	private String illegfact;
	/**
	 * 处罚依据
	 */
	private String penbasis;
	/**
	 * 处罚种类
	 */
	private String pentype;
	/**
	 * 处罚结果
	 */
	private String penresult;
	/**
	 * 处罚金额
	 */
	private String penam;
	/**
	 * 处罚执行情况
	 */
	private String penexest;
	/**
	 * 创建人ID
	 */
	private Integer creator;
	/**
	 * 创建时间
	 */
	  @TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;
	/**
	 * 修改人ID
	 */
	private Integer updater;
	/**
	 * 修改时间
	 */
		 @TableField(value = "update_time", fill = FieldFill.UPDATE)
	private Date updateTime;
	/**
	 * 数据状态：1-正常 0-删除
	 */
	@TableField(value = "data_state", fill = FieldFill.INSERT)
private Integer dataState;

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
	public void setMemid(Integer memid) {
		this.memid = memid;
	}
	/**
	 * 获取：会员ID
	 */
	public Integer getMemid() {
		return memid;
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
	 * 设置：案发时间
	 */
	public void setCasetime(String casetime) {
		this.casetime = casetime;
	}
	/**
	 * 获取：案发时间
	 */
	public String getCasetime() {
		return casetime;
	}
	/**
	 * 设置：案由
	 */
	public void setCasereason(String casereason) {
		this.casereason = casereason;
	}
	/**
	 * 获取：案由
	 */
	public String getCasereason() {
		return casereason;
	}
	/**
	 * 设置：案值
	 */
	public void setCaseval(String caseval) {
		this.caseval = caseval;
	}
	/**
	 * 获取：案值
	 */
	public String getCaseval() {
		return caseval;
	}
	/**
	 * 设置：案件类型
	 */
	public void setCasetype(String casetype) {
		this.casetype = casetype;
	}
	/**
	 * 获取：案件类型
	 */
	public String getCasetype() {
		return casetype;
	}
	/**
	 * 设置：执行类别
	 */
	public void setExesort(String exesort) {
		this.exesort = exesort;
	}
	/**
	 * 获取：执行类别
	 */
	public String getExesort() {
		return exesort;
	}
	/**
	 * 设置：案件结果
	 */
	public void setCaseresult(String caseresult) {
		this.caseresult = caseresult;
	}
	/**
	 * 获取：案件结果
	 */
	public String getCaseresult() {
		return caseresult;
	}
	/**
	 * 设置：处罚决定文书
	 */
	public void setPendecno(String pendecno) {
		this.pendecno = pendecno;
	}
	/**
	 * 获取：处罚决定文书
	 */
	public String getPendecno() {
		return pendecno;
	}
	/**
	 * 设置：处罚决定书签发日期
	 */
	public void setPendecissdate(String pendecissdate) {
		this.pendecissdate = pendecissdate;
	}
	/**
	 * 获取：处罚决定书签发日期
	 */
	public String getPendecissdate() {
		return pendecissdate;
	}
	/**
	 * 设置：作出行政处罚决定机关名称
	 */
	public void setPenauth(String penauth) {
		this.penauth = penauth;
	}
	/**
	 * 获取：作出行政处罚决定机关名称
	 */
	public String getPenauth() {
		return penauth;
	}
	/**
	 * 设置：主要违法事实
	 */
	public void setIllegfact(String illegfact) {
		this.illegfact = illegfact;
	}
	/**
	 * 获取：主要违法事实
	 */
	public String getIllegfact() {
		return illegfact;
	}
	/**
	 * 设置：处罚依据
	 */
	public void setPenbasis(String penbasis) {
		this.penbasis = penbasis;
	}
	/**
	 * 获取：处罚依据
	 */
	public String getPenbasis() {
		return penbasis;
	}
	/**
	 * 设置：处罚种类
	 */
	public void setPentype(String pentype) {
		this.pentype = pentype;
	}
	/**
	 * 获取：处罚种类
	 */
	public String getPentype() {
		return pentype;
	}
	/**
	 * 设置：处罚结果
	 */
	public void setPenresult(String penresult) {
		this.penresult = penresult;
	}
	/**
	 * 获取：处罚结果
	 */
	public String getPenresult() {
		return penresult;
	}
	/**
	 * 设置：处罚金额
	 */
	public void setPenam(String penam) {
		this.penam = penam;
	}
	/**
	 * 获取：处罚金额
	 */
	public String getPenam() {
		return penam;
	}
	/**
	 * 设置：处罚执行情况
	 */
	public void setPenexest(String penexest) {
		this.penexest = penexest;
	}
	/**
	 * 获取：处罚执行情况
	 */
	public String getPenexest() {
		return penexest;
	}
	/**
	 * 设置：创建人ID
	 */
	public void setCreator(Integer creator) {
		this.creator = creator;
	}
	/**
	 * 获取：创建人ID
	 */
	public Integer getCreator() {
		return creator;
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
	/**
	 * 设置：修改人ID
	 */
	public void setUpdater(Integer updater) {
		this.updater = updater;
	}
	/**
	 * 获取：修改人ID
	 */
	public Integer getUpdater() {
		return updater;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：数据状态：1-正常 0-删除
	 */
	public void setDataState(Integer dataState) {
		this.dataState = dataState;
	}
	/**
	 * 获取：数据状态：1-正常 0-删除
	 */
	public Integer getDataState() {
		return dataState;
	}
}
