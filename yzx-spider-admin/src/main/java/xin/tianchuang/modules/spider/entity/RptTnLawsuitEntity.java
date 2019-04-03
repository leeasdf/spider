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
 * 法律诉讼信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:20
 */
@TableName("rpt_tn_lawsuit")
public class RptTnLawsuitEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 企业主键
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long enterpriseId;
	/**
	 * 企业名称
	 */
	private String entName;
	/**
	 * 日期
	 */
	private String date;
	/**
	 * 裁判文书
	 */
	private String referee;
	/**
	 * 案由
	 */
	private String reason;
	/**
	 * 案件身份
	 */
	private String identity;
	/**
	 * 案号
	 */
	private String caseNum;
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
	 * 待定
	 */
	private String plaintiff;
	/**
	 * 待定
	 */
	private String defendant;

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
	 * 设置：企业主键
	 */
	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	/**
	 * 获取：企业主键
	 */
	public Long getEnterpriseId() {
		return enterpriseId;
	}
	/**
	 * 设置：企业名称
	 */
	public void setEntName(String entName) {
		this.entName = entName;
	}
	/**
	 * 获取：企业名称
	 */
	public String getEntName() {
		return entName;
	}
	/**
	 * 设置：日期
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * 获取：日期
	 */
	public String getDate() {
		return date;
	}
	/**
	 * 设置：裁判文书
	 */
	public void setReferee(String referee) {
		this.referee = referee;
	}
	/**
	 * 获取：裁判文书
	 */
	public String getReferee() {
		return referee;
	}
	/**
	 * 设置：案由
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	 * 获取：案由
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * 设置：案件身份
	 */
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	/**
	 * 获取：案件身份
	 */
	public String getIdentity() {
		return identity;
	}
	/**
	 * 设置：案号
	 */
	public void setCaseNum(String caseNum) {
		this.caseNum = caseNum;
	}
	/**
	 * 获取：案号
	 */
	public String getCaseNum() {
		return caseNum;
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
	/**
	 * 设置：待定
	 */
	public void setPlaintiff(String plaintiff) {
		this.plaintiff = plaintiff;
	}
	/**
	 * 获取：待定
	 */
	public String getPlaintiff() {
		return plaintiff;
	}
	/**
	 * 设置：待定
	 */
	public void setDefendant(String defendant) {
		this.defendant = defendant;
	}
	/**
	 * 获取：待定
	 */
	public String getDefendant() {
		return defendant;
	}
}
