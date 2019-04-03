package xin.tianchuang.modules.spider.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 企业-税收信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:17
 */
@TableName("ent_tax_info")
public class EntTaxInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 税收主键
	 */
	@TableId(value = "tax_info_id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long taxInfoId;
	/**
	 * 企业名称
	 */
	private String enterpriseName;
	/**
	 * 缴税年份
	 */
	private String taxYear;
	/**
	 * 地税
	 */
	private BigDecimal localTax;
	/**
	 * 国税
	 */
	private BigDecimal stateTax;
	/**
	 * 合计税收
	 */
	private BigDecimal totalTax;
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
	public void setTaxInfoId(Long taxInfoId) {
		this.taxInfoId = taxInfoId;
	}
	/**
	 * 获取：税收主键
	 */
	public Long getTaxInfoId() {
		return taxInfoId;
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
	 * 设置：缴税年份
	 */
	public void setTaxYear(String taxYear) {
		this.taxYear = taxYear;
	}
	/**
	 * 获取：缴税年份
	 */
	public String getTaxYear() {
		return taxYear;
	}
	/**
	 * 设置：地税
	 */
	public void setLocalTax(BigDecimal localTax) {
		this.localTax = localTax;
	}
	/**
	 * 获取：地税
	 */
	public BigDecimal getLocalTax() {
		return localTax;
	}
	/**
	 * 设置：国税
	 */
	public void setStateTax(BigDecimal stateTax) {
		this.stateTax = stateTax;
	}
	/**
	 * 获取：国税
	 */
	public BigDecimal getStateTax() {
		return stateTax;
	}
	/**
	 * 设置：合计税收
	 */
	public void setTotalTax(BigDecimal totalTax) {
		this.totalTax = totalTax;
	}
	/**
	 * 获取：合计税收
	 */
	public BigDecimal getTotalTax() {
		return totalTax;
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
