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
 * 信用麓谷-企业涉诉信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:17
 */
@TableName("rpt_litigation_info")
public class RptLitigationInfoEntity implements Serializable {
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
	 * 信息ID
	 */
	private String dataId;
	/**
	 * 类型
	 */
	private String type;
	/**
	 * 文书类型
	 */
	private String caseType;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 内容
	 */
	private String body;
	/**
	 * 时间
	 */
	private String sortTime;
	/**
	 * 法院名称
	 */
	private String court;
	/**
	 * 案号
	 */
	private String caseNo;
	/**
	 * 被诉人
	 */
	private String party;
	/**
	 * 案由
	 */
	private String caseCause;
	/**
	 * 执行状态
	 */
	private String status;
	/**
	 * 执行标的
	 */
	private String execMoney;
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
	 * 设置：信息ID
	 */
	public void setDataId(String dataId) {
		this.dataId = dataId;
	}
	/**
	 * 获取：信息ID
	 */
	public String getDataId() {
		return dataId;
	}
	/**
	 * 设置：类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：文书类型
	 */
	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}
	/**
	 * 获取：文书类型
	 */
	public String getCaseType() {
		return caseType;
	}
	/**
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：内容
	 */
	public void setBody(String body) {
		this.body = body;
	}
	/**
	 * 获取：内容
	 */
	public String getBody() {
		return body;
	}
	/**
	 * 设置：时间
	 */
	public void setSortTime(String sortTime) {
		this.sortTime = sortTime;
	}
	/**
	 * 获取：时间
	 */
	public String getSortTime() {
		return sortTime;
	}
	/**
	 * 设置：法院名称
	 */
	public void setCourt(String court) {
		this.court = court;
	}
	/**
	 * 获取：法院名称
	 */
	public String getCourt() {
		return court;
	}
	/**
	 * 设置：案号
	 */
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}
	/**
	 * 获取：案号
	 */
	public String getCaseNo() {
		return caseNo;
	}
	/**
	 * 设置：被诉人
	 */
	public void setParty(String party) {
		this.party = party;
	}
	/**
	 * 获取：被诉人
	 */
	public String getParty() {
		return party;
	}
	/**
	 * 设置：案由
	 */
	public void setCaseCause(String caseCause) {
		this.caseCause = caseCause;
	}
	/**
	 * 获取：案由
	 */
	public String getCaseCause() {
		return caseCause;
	}
	/**
	 * 设置：执行状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：执行状态
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：执行标的
	 */
	public void setExecMoney(String execMoney) {
		this.execMoney = execMoney;
	}
	/**
	 * 获取：执行标的
	 */
	public String getExecMoney() {
		return execMoney;
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
