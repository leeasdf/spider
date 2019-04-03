package xin.tianchuang.modules.dataparser.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import xin.tianchuang.modules.dataparser.annotation.EntName;

import java.io.Serializable;
import java.util.Date;

/**
 * 信用中国-重点关注名单-工商总局
 * 
 * @author hui.deng
 * @email 
 * @date 2018-10-17 11:01:12
 */
@TableName("creditchina_focus_gszj")
public class CreditchinaFocusGszjEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(type = IdType.ID_WORKER)
    @JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 数据类别
	 */
	private String type;
	/**
	 * 数据来源
	 */
	private String source;
	/**
	 * 注册号
	 */
	private String regNo;
	/**
	 * 法定代表人
	 */
	private String legal;
	/**
	 * 列入经营异常名录原因类型名称
	 */
	private String reason;
	/**
	 * 企业名称
	 */
	@EntName
	private String enterpriseName;
	/**
	 * 设立日期
	 */
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date establishDate;
	/**
	 * 列入决定机关名称
	 */
	private String decisionOrgan;
	/**
	 * 最新更新日期
	 */
	private Date lastUpdateTime;
	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;
	/**
	 * 更新时间
	 */
	@TableField(fill = FieldFill.UPDATE)
	private Date updateTime;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 数据状态
	 */
	@TableField(fill = FieldFill.INSERT)
	private Integer dataStatus;

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
	 * 设置：数据类别
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：数据类别
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：数据来源
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * 获取：数据来源
	 */
	public String getSource() {
		return source;
	}
	/**
	 * 设置：注册号
	 */
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	/**
	 * 获取：注册号
	 */
	public String getRegNo() {
		return regNo;
	}
	/**
	 * 设置：法定代表人
	 */
	public void setLegal(String legal) {
		this.legal = legal;
	}
	/**
	 * 获取：法定代表人
	 */
	public String getLegal() {
		return legal;
	}
	/**
	 * 设置：列入经营异常名录原因类型名称
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	 * 获取：列入经营异常名录原因类型名称
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * 设置：企业名称
	 */
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	/**
	 * 获取：企业名称
	 */
	public String getEnterpriseName() {
		return enterpriseName;
	}
	/**
	 * 设置：设立日期
	 */
	public void setEstablishDate(Date establishDate) {
		this.establishDate = establishDate;
	}
	/**
	 * 获取：设立日期
	 */
	public Date getEstablishDate() {
		return establishDate;
	}
	/**
	 * 设置：列入决定机关名称
	 */
	public void setDecisionOrgan(String decisionOrgan) {
		this.decisionOrgan = decisionOrgan;
	}
	/**
	 * 获取：列入决定机关名称
	 */
	public String getDecisionOrgan() {
		return decisionOrgan;
	}
	/**
	 * 设置：最新更新日期
	 */
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	/**
	 * 获取：最新更新日期
	 */
	public Date getLastUpdateTime() {
		return lastUpdateTime;
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
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：数据状态
	 */
	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}
	/**
	 * 获取：数据状态
	 */
	public Integer getDataStatus() {
		return dataStatus;
	}
}
