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
 * 信用麓谷-企业税务信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:17
 */
@TableName("rpt_tax_info")
public class RptTaxInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 信用报告ID
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 会员主键
	 */
	private Integer memId;
	/**
	 * 企业ID
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long enterpriseId;
	/**
	 * 所属年度
	 */
	private String year;
	/**
	 * 机构代码
	 */
	private String orgCode;
	/**
	 * 机构代码
	 */
	private String ename;
	/**
	 * 营业收入
	 */
	private String operRevenue;
	/**
	 * 主营业务收入
	 */
	private String mainOperRevenue;
	/**
	 * 其他业务收入
	 */
	private String otherOperRevenue;
	/**
	 * 营业成本
	 */
	private String operCost;
	/**
	 * 主营业务成本
	 */
	private String mainOperCost;
	/**
	 * 其他业务成本
	 */
	private String otherOperCost;
	/**
	 * 营业税金及附加信息
	 */
	private String busiTaxSurcharges;
	/**
	 * 管理费用
	 */
	private String adminExpense;
	/**
	 * 销售费用
	 */
	private String operExpense;
	/**
	 * 财务费用
	 */
	private String financeExpense;
	/**
	 * 财产减值损失
	 */
	private String assetsLoss;
	/**
	 * 营业利润
	 */
	private String operProfit;
	/**
	 * 营业外收入
	 */
	private String nonBusiIncome;
	/**
	 * 营业外支出
	 */
	private String nonBusiExpense;
	/**
	 * 利润（亏损）总额
	 */
	private String totalProfitLoss;
	/**
	 * 所得税
	 */
	private String persIncomeTax;
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
	 * 设置：信用报告ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：信用报告ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：会员主键
	 */
	public void setMemId(Integer memId) {
		this.memId = memId;
	}
	/**
	 * 获取：会员主键
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
	 * 设置：所属年度
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * 获取：所属年度
	 */
	public String getYear() {
		return year;
	}
	/**
	 * 设置：机构代码
	 */
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	/**
	 * 获取：机构代码
	 */
	public String getOrgCode() {
		return orgCode;
	}
	/**
	 * 设置：机构代码
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}
	/**
	 * 获取：机构代码
	 */
	public String getEname() {
		return ename;
	}
	/**
	 * 设置：营业收入
	 */
	public void setOperRevenue(String operRevenue) {
		this.operRevenue = operRevenue;
	}
	/**
	 * 获取：营业收入
	 */
	public String getOperRevenue() {
		return operRevenue;
	}
	/**
	 * 设置：主营业务收入
	 */
	public void setMainOperRevenue(String mainOperRevenue) {
		this.mainOperRevenue = mainOperRevenue;
	}
	/**
	 * 获取：主营业务收入
	 */
	public String getMainOperRevenue() {
		return mainOperRevenue;
	}
	/**
	 * 设置：其他业务收入
	 */
	public void setOtherOperRevenue(String otherOperRevenue) {
		this.otherOperRevenue = otherOperRevenue;
	}
	/**
	 * 获取：其他业务收入
	 */
	public String getOtherOperRevenue() {
		return otherOperRevenue;
	}
	/**
	 * 设置：营业成本
	 */
	public void setOperCost(String operCost) {
		this.operCost = operCost;
	}
	/**
	 * 获取：营业成本
	 */
	public String getOperCost() {
		return operCost;
	}
	/**
	 * 设置：主营业务成本
	 */
	public void setMainOperCost(String mainOperCost) {
		this.mainOperCost = mainOperCost;
	}
	/**
	 * 获取：主营业务成本
	 */
	public String getMainOperCost() {
		return mainOperCost;
	}
	/**
	 * 设置：其他业务成本
	 */
	public void setOtherOperCost(String otherOperCost) {
		this.otherOperCost = otherOperCost;
	}
	/**
	 * 获取：其他业务成本
	 */
	public String getOtherOperCost() {
		return otherOperCost;
	}
	/**
	 * 设置：营业税金及附加信息
	 */
	public void setBusiTaxSurcharges(String busiTaxSurcharges) {
		this.busiTaxSurcharges = busiTaxSurcharges;
	}
	/**
	 * 获取：营业税金及附加信息
	 */
	public String getBusiTaxSurcharges() {
		return busiTaxSurcharges;
	}
	/**
	 * 设置：管理费用
	 */
	public void setAdminExpense(String adminExpense) {
		this.adminExpense = adminExpense;
	}
	/**
	 * 获取：管理费用
	 */
	public String getAdminExpense() {
		return adminExpense;
	}
	/**
	 * 设置：销售费用
	 */
	public void setOperExpense(String operExpense) {
		this.operExpense = operExpense;
	}
	/**
	 * 获取：销售费用
	 */
	public String getOperExpense() {
		return operExpense;
	}
	/**
	 * 设置：财务费用
	 */
	public void setFinanceExpense(String financeExpense) {
		this.financeExpense = financeExpense;
	}
	/**
	 * 获取：财务费用
	 */
	public String getFinanceExpense() {
		return financeExpense;
	}
	/**
	 * 设置：财产减值损失
	 */
	public void setAssetsLoss(String assetsLoss) {
		this.assetsLoss = assetsLoss;
	}
	/**
	 * 获取：财产减值损失
	 */
	public String getAssetsLoss() {
		return assetsLoss;
	}
	/**
	 * 设置：营业利润
	 */
	public void setOperProfit(String operProfit) {
		this.operProfit = operProfit;
	}
	/**
	 * 获取：营业利润
	 */
	public String getOperProfit() {
		return operProfit;
	}
	/**
	 * 设置：营业外收入
	 */
	public void setNonBusiIncome(String nonBusiIncome) {
		this.nonBusiIncome = nonBusiIncome;
	}
	/**
	 * 获取：营业外收入
	 */
	public String getNonBusiIncome() {
		return nonBusiIncome;
	}
	/**
	 * 设置：营业外支出
	 */
	public void setNonBusiExpense(String nonBusiExpense) {
		this.nonBusiExpense = nonBusiExpense;
	}
	/**
	 * 获取：营业外支出
	 */
	public String getNonBusiExpense() {
		return nonBusiExpense;
	}
	/**
	 * 设置：利润（亏损）总额
	 */
	public void setTotalProfitLoss(String totalProfitLoss) {
		this.totalProfitLoss = totalProfitLoss;
	}
	/**
	 * 获取：利润（亏损）总额
	 */
	public String getTotalProfitLoss() {
		return totalProfitLoss;
	}
	/**
	 * 设置：所得税
	 */
	public void setPersIncomeTax(String persIncomeTax) {
		this.persIncomeTax = persIncomeTax;
	}
	/**
	 * 获取：所得税
	 */
	public String getPersIncomeTax() {
		return persIncomeTax;
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
