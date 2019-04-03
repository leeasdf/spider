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
 * 企业-工业产值信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:16
 */
@TableName("ent_industrial_output")
public class EntIndustrialOutputEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 工业产值主键
	 */
	@TableId(value = "industrial_output_id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long industrialOutputId;
	/**
	 * 企业名称
	 */
	private String enterpriseName;
	/**
	 * 行业分类
	 */
	private String industryClassification;
	/**
	 * 产值年份
	 */
	private String year;
	/**
	 * 产值
	 */
	private BigDecimal output;
	/**
	 * 会员ID
	 */
	private Integer memId;
	/**
	 * 修改时间
	 */
	 @TableField(value = "update_time", fill = FieldFill.UPDATE)
	private Date updateTime;
	/**
	 * 创建人ID
	 */
	private Integer creator;
	/**
	 * 修改人ID
	 */
	private Integer updater;
	/**
	 * 创建时间
	 */
	 @TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;
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
	 * 设置：工业产值主键
	 */
	public void setIndustrialOutputId(Long industrialOutputId) {
		this.industrialOutputId = industrialOutputId;
	}
	/**
	 * 获取：工业产值主键
	 */
	public Long getIndustrialOutputId() {
		return industrialOutputId;
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
	 * 设置：行业分类
	 */
	public void setIndustryClassification(String industryClassification) {
		this.industryClassification = industryClassification;
	}
	/**
	 * 获取：行业分类
	 */
	public String getIndustryClassification() {
		return industryClassification;
	}
	/**
	 * 设置：产值年份
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * 获取：产值年份
	 */
	public String getYear() {
		return year;
	}
	/**
	 * 设置：产值
	 */
	public void setOutput(BigDecimal output) {
		this.output = output;
	}
	/**
	 * 获取：产值
	 */
	public BigDecimal getOutput() {
		return output;
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
