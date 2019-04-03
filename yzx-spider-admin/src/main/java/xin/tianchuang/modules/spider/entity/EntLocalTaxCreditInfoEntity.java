package xin.tianchuang.modules.spider.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 地方税务局税务评价表
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:23
 */
@TableName("ent_local_tax_credit_info")
public class EntLocalTaxCreditInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 税收主键
	 */
	@TableId(value = "local_tax_id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long localTaxId;
	/**
	 * 纳税人名称
	 */
	private String taxpayerName;
	/**
	 * 税务登记号
	 */
	private String taxRegistrationId;
	/**
	 * 信用级别
	 */
	private String creditLevel;
	/**
	 * 评价税务机关
	 */
	private String ratingTaxAuthority;
	/**
	 * 评价年度
	 */
	private String ratingYear;
	/**
	 * 评价日期
	 */
	private String ratingDate;
	/**
	 * 会员ID
	 */
	private Integer memId;
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
	 * 企业ID
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long enterpriseId;

	/**
	 * 设置：税收主键
	 */
	public void setLocalTaxId(Long localTaxId) {
		this.localTaxId = localTaxId;
	}
	/**
	 * 获取：税收主键
	 */
	public Long getLocalTaxId() {
		return localTaxId;
	}
	/**
	 * 设置：纳税人名称
	 */
	public void setTaxpayerName(String taxpayerName) {
		this.taxpayerName = taxpayerName;
	}
	/**
	 * 获取：纳税人名称
	 */
	public String getTaxpayerName() {
		return taxpayerName;
	}
	/**
	 * 设置：税务登记号
	 */
	public void setTaxRegistrationId(String taxRegistrationId) {
		this.taxRegistrationId = taxRegistrationId;
	}
	/**
	 * 获取：税务登记号
	 */
	public String getTaxRegistrationId() {
		return taxRegistrationId;
	}
	/**
	 * 设置：信用级别
	 */
	public void setCreditLevel(String creditLevel) {
		this.creditLevel = creditLevel;
	}
	/**
	 * 获取：信用级别
	 */
	public String getCreditLevel() {
		return creditLevel;
	}
	/**
	 * 设置：评价税务机关
	 */
	public void setRatingTaxAuthority(String ratingTaxAuthority) {
		this.ratingTaxAuthority = ratingTaxAuthority;
	}
	/**
	 * 获取：评价税务机关
	 */
	public String getRatingTaxAuthority() {
		return ratingTaxAuthority;
	}
	/**
	 * 设置：评价年度
	 */
	public void setRatingYear(String ratingYear) {
		this.ratingYear = ratingYear;
	}
	/**
	 * 获取：评价年度
	 */
	public String getRatingYear() {
		return ratingYear;
	}
	/**
	 * 设置：评价日期
	 */
	public void setRatingDate(String ratingDate) {
		this.ratingDate = ratingDate;
	}
	/**
	 * 获取：评价日期
	 */
	public String getRatingDate() {
		return ratingDate;
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
}
