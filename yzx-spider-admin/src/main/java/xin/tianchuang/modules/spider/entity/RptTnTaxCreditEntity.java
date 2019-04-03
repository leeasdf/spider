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
 * 税务评级信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:20
 */
@TableName("rpt_tn_tax_credit")
public class RptTnTaxCreditEntity implements Serializable {
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
	 * 纳税评级
	 */
	private String taxLevel;
	/**
	 * 纳税人识别号
	 */
	private String taxNo;
	/**
	 * 评价单位
	 */
	private String agency;
	/**
	 * 类别
	 */
	private String type;
	/**
	 * 年份
	 */
	private String years;
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
	 * 设置：纳税评级
	 */
	public void setTaxLevel(String taxLevel) {
		this.taxLevel = taxLevel;
	}
	/**
	 * 获取：纳税评级
	 */
	public String getTaxLevel() {
		return taxLevel;
	}
	/**
	 * 设置：纳税人识别号
	 */
	public void setTaxNo(String taxNo) {
		this.taxNo = taxNo;
	}
	/**
	 * 获取：纳税人识别号
	 */
	public String getTaxNo() {
		return taxNo;
	}
	/**
	 * 设置：评价单位
	 */
	public void setAgency(String agency) {
		this.agency = agency;
	}
	/**
	 * 获取：评价单位
	 */
	public String getAgency() {
		return agency;
	}
	/**
	 * 设置：类别
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类别
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：年份
	 */
	public void setYears(String years) {
		this.years = years;
	}
	/**
	 * 获取：年份
	 */
	public String getYears() {
		return years;
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
