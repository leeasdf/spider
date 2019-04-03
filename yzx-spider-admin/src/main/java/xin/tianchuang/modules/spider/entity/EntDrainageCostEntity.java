package xin.tianchuang.modules.spider.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 企业-电费欠缴信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:16
 */
@TableName("ent_drainage_cost")
public class EntDrainageCostEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 企业名称
	 */
	private String companyName;
	/**
	 * 来源
	 */
	private String source;
	/**
	 * 是否排污企业
	 */
	private String drainageFlag;
	/**
	 * 序号
	 */
	private String serialNo;
	/**
	 * 征收机构
	 */
	private String levyInstitution;
	/**
	 * 开单金额(单位:元)
	 */
	private BigDecimal billingAmount;
	/**
	 * 入库金额(单位:元)
	 */
	private BigDecimal payinAmount;
	/**
	 * 上级机构
	 */
	private String parentInstitution;
	/**
	 * 企业状态类型：0-正常，1-政策性免征，2-停产，3-永久性停产，4-关闭，5-未正式投产，6-零排放，7-其他
	 */
	private String type;
	/**
	 * 年份
	 */
	private String year;
	/**
	 * 季度
	 */
	private String quarter;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：企业名称
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * 获取：企业名称
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * 设置：来源
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * 获取：来源
	 */
	public String getSource() {
		return source;
	}
	/**
	 * 设置：是否排污企业
	 */
	public void setDrainageFlag(String drainageFlag) {
		this.drainageFlag = drainageFlag;
	}
	/**
	 * 获取：是否排污企业
	 */
	public String getDrainageFlag() {
		return drainageFlag;
	}
	/**
	 * 设置：序号
	 */
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	/**
	 * 获取：序号
	 */
	public String getSerialNo() {
		return serialNo;
	}
	/**
	 * 设置：征收机构
	 */
	public void setLevyInstitution(String levyInstitution) {
		this.levyInstitution = levyInstitution;
	}
	/**
	 * 获取：征收机构
	 */
	public String getLevyInstitution() {
		return levyInstitution;
	}
	/**
	 * 设置：开单金额(单位:元)
	 */
	public void setBillingAmount(BigDecimal billingAmount) {
		this.billingAmount = billingAmount;
	}
	/**
	 * 获取：开单金额(单位:元)
	 */
	public BigDecimal getBillingAmount() {
		return billingAmount;
	}
	/**
	 * 设置：入库金额(单位:元)
	 */
	public void setPayinAmount(BigDecimal payinAmount) {
		this.payinAmount = payinAmount;
	}
	/**
	 * 获取：入库金额(单位:元)
	 */
	public BigDecimal getPayinAmount() {
		return payinAmount;
	}
	/**
	 * 设置：上级机构
	 */
	public void setParentInstitution(String parentInstitution) {
		this.parentInstitution = parentInstitution;
	}
	/**
	 * 获取：上级机构
	 */
	public String getParentInstitution() {
		return parentInstitution;
	}
	/**
	 * 设置：企业状态类型：0-正常，1-政策性免征，2-停产，3-永久性停产，4-关闭，5-未正式投产，6-零排放，7-其他
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：企业状态类型：0-正常，1-政策性免征，2-停产，3-永久性停产，4-关闭，5-未正式投产，6-零排放，7-其他
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：年份
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * 获取：年份
	 */
	public String getYear() {
		return year;
	}
	/**
	 * 设置：季度
	 */
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	/**
	 * 获取：季度
	 */
	public String getQuarter() {
		return quarter;
	}
}
