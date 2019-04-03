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
 * 进出口信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:20
 */
@TableName("rpt_tn_import_export")
public class RptTnImportExportEntity implements Serializable {
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
	 * 行业种类
	 */
	private String industryCategory;
	/**
	 * 年报情况
	 */
	private String annualReport;
	/**
	 * 海关注销标识
	 */
	private String status;
	/**
	 * 行政区划
	 */
	private String administrativeDivision;
	/**
	 * 经营类别
	 */
	private String managementCategory;
	/**
	 * 注册海关
	 */
	private String customsRegisteredAddress;
	/**
	 * 报关有效期
	 */
	private String validityDate;
	/**
	 * 经济区划
	 */
	private String economicDivision;
	/**
	 * 注册日期
	 */
	private String recordDate;
	/**
	 * 海关注册号
	 */
	private String crCode;
	/**
	 * 特殊贸易区域
	 */
	private String specialTradeArea;
	/**
	 * 跨境贸易电子商务类型
	 */
	private String types;
	/**
	 * 信用登记
	 */
	private String creditRating;
	/**
	 * sanction
	 */
	private String sanction;
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
	 * 设置：行业种类
	 */
	public void setIndustryCategory(String industryCategory) {
		this.industryCategory = industryCategory;
	}
	/**
	 * 获取：行业种类
	 */
	public String getIndustryCategory() {
		return industryCategory;
	}
	/**
	 * 设置：年报情况
	 */
	public void setAnnualReport(String annualReport) {
		this.annualReport = annualReport;
	}
	/**
	 * 获取：年报情况
	 */
	public String getAnnualReport() {
		return annualReport;
	}
	/**
	 * 设置：海关注销标识
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：海关注销标识
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：行政区划
	 */
	public void setAdministrativeDivision(String administrativeDivision) {
		this.administrativeDivision = administrativeDivision;
	}
	/**
	 * 获取：行政区划
	 */
	public String getAdministrativeDivision() {
		return administrativeDivision;
	}
	/**
	 * 设置：经营类别
	 */
	public void setManagementCategory(String managementCategory) {
		this.managementCategory = managementCategory;
	}
	/**
	 * 获取：经营类别
	 */
	public String getManagementCategory() {
		return managementCategory;
	}
	/**
	 * 设置：注册海关
	 */
	public void setCustomsRegisteredAddress(String customsRegisteredAddress) {
		this.customsRegisteredAddress = customsRegisteredAddress;
	}
	/**
	 * 获取：注册海关
	 */
	public String getCustomsRegisteredAddress() {
		return customsRegisteredAddress;
	}
	/**
	 * 设置：报关有效期
	 */
	public void setValidityDate(String validityDate) {
		this.validityDate = validityDate;
	}
	/**
	 * 获取：报关有效期
	 */
	public String getValidityDate() {
		return validityDate;
	}
	/**
	 * 设置：经济区划
	 */
	public void setEconomicDivision(String economicDivision) {
		this.economicDivision = economicDivision;
	}
	/**
	 * 获取：经济区划
	 */
	public String getEconomicDivision() {
		return economicDivision;
	}
	/**
	 * 设置：注册日期
	 */
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	/**
	 * 获取：注册日期
	 */
	public String getRecordDate() {
		return recordDate;
	}
	/**
	 * 设置：海关注册号
	 */
	public void setCrCode(String crCode) {
		this.crCode = crCode;
	}
	/**
	 * 获取：海关注册号
	 */
	public String getCrCode() {
		return crCode;
	}
	/**
	 * 设置：特殊贸易区域
	 */
	public void setSpecialTradeArea(String specialTradeArea) {
		this.specialTradeArea = specialTradeArea;
	}
	/**
	 * 获取：特殊贸易区域
	 */
	public String getSpecialTradeArea() {
		return specialTradeArea;
	}
	/**
	 * 设置：跨境贸易电子商务类型
	 */
	public void setTypes(String types) {
		this.types = types;
	}
	/**
	 * 获取：跨境贸易电子商务类型
	 */
	public String getTypes() {
		return types;
	}
	/**
	 * 设置：信用登记
	 */
	public void setCreditRating(String creditRating) {
		this.creditRating = creditRating;
	}
	/**
	 * 获取：信用登记
	 */
	public String getCreditRating() {
		return creditRating;
	}
	/**
	 * 设置：sanction
	 */
	public void setSanction(String sanction) {
		this.sanction = sanction;
	}
	/**
	 * 获取：sanction
	 */
	public String getSanction() {
		return sanction;
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
