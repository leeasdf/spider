package xin.tianchuang.modules.spider.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * tyc企业年报-企业资产状况
 * 
 * @author hui.deng
 * @email 
 * @date 2018-12-05 17:21:32
 */
@TableName("rpt_tn_report_amount")
public class RptTnReportAmountEntity implements Serializable {
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
	 * 年报主键
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long reportId;
	/**
	 * 资产总额
	 */
	private String totalAmount;
	/**
	 * 所有者权益合计
	 */
	private String ownerAmount;
	/**
	 * 销售总额
	 */
	private String saleAmount;
	/**
	 * 利润总额
	 */
	private String profitAmount;
	/**
	 * 营业总收入中主营业务收入
	 */
	private String mainBusinessIncome;
	/**
	 * 净利润
	 */
	private String netProfitAmount;
	/**
	 * 纳税总额
	 */
	private String taxAmount;
	/**
	 *  负债总额
	 */
	private String indebtAmount;
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
	 * 设置：主键
	 */
	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	/**
	 * 获取：主键
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
	 * 设置：年报主键
	 */
	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}
	/**
	 * 获取：年报主键
	 */
	public Long getReportId() {
		return reportId;
	}
	/**
	 * 设置：资产总额
	 */
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	/**
	 * 获取：资产总额
	 */
	public String getTotalAmount() {
		return totalAmount;
	}
	/**
	 * 设置：所有者权益合计
	 */
	public void setOwnerAmount(String ownerAmount) {
		this.ownerAmount = ownerAmount;
	}
	/**
	 * 获取：所有者权益合计
	 */
	public String getOwnerAmount() {
		return ownerAmount;
	}
	/**
	 * 设置：销售总额
	 */
	public void setSaleAmount(String saleAmount) {
		this.saleAmount = saleAmount;
	}
	/**
	 * 获取：销售总额
	 */
	public String getSaleAmount() {
		return saleAmount;
	}
	/**
	 * 设置：利润总额
	 */
	public void setProfitAmount(String profitAmount) {
		this.profitAmount = profitAmount;
	}
	/**
	 * 获取：利润总额
	 */
	public String getProfitAmount() {
		return profitAmount;
	}
	/**
	 * 设置：营业总收入中主营业务收入
	 */
	public void setMainBusinessIncome(String mainBusinessIncome) {
		this.mainBusinessIncome = mainBusinessIncome;
	}
	/**
	 * 获取：营业总收入中主营业务收入
	 */
	public String getMainBusinessIncome() {
		return mainBusinessIncome;
	}
	/**
	 * 设置：净利润
	 */
	public void setNetProfitAmount(String netProfitAmount) {
		this.netProfitAmount = netProfitAmount;
	}
	/**
	 * 获取：净利润
	 */
	public String getNetProfitAmount() {
		return netProfitAmount;
	}
	/**
	 * 设置：纳税总额
	 */
	public void setTaxAmount(String taxAmount) {
		this.taxAmount = taxAmount;
	}
	/**
	 * 获取：纳税总额
	 */
	public String getTaxAmount() {
		return taxAmount;
	}
	/**
	 * 设置： 负债总额
	 */
	public void setIndebtAmount(String indebtAmount) {
		this.indebtAmount = indebtAmount;
	}
	/**
	 * 获取： 负债总额
	 */
	public String getIndebtAmount() {
		return indebtAmount;
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
