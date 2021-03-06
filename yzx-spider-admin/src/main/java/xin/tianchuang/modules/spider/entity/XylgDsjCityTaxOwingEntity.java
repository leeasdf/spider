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
 * 信用麓谷-欠税信息表
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:20
 */
@TableName("xylg_dsj_city_tax_owing")
public class XylgDsjCityTaxOwingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 纳税人名称
	 */
	private String taxpayerName;
	/**
	 * 纳税人识别号
	 */
	private String taxNo;
	/**
	 * 法人（业主）姓名
	 */
	private String legalPersonName;
	/**
	 * 法人（业主）身份证号
	 */
	private String legalPersonCertNo;
	/**
	 * 经营地址
	 */
	private String businessAddress;
	/**
	 * 营业税-欠税余额
	 */
	private BigDecimal businessTaxOwing;
	/**
	 * 营业税-其中本年新欠
	 */
	private BigDecimal businessTaxOwingNew;
	/**
	 * 房产税-欠税余额
	 */
	private BigDecimal propertyTaxOwing;
	/**
	 * 房产税-其中本年新欠
	 */
	private BigDecimal propertyTaxOwingNew;
	/**
	 * 城市维护建设税-欠税余额
	 */
	private BigDecimal cityBuildTax;
	/**
	 * 城市维护建设税-其中本年新欠
	 */
	private BigDecimal cityBuildTaxNew;
	/**
	 * 教育费附加-欠税余额
	 */
	private BigDecimal educationTax;
	/**
	 * 教育费附加-其中本年新欠
	 */
	private BigDecimal educationTaxNew;
	/**
	 * 耕地占用税-欠税余额
	 */
	private BigDecimal farmLandOccupyTax;
	/**
	 * 耕地占用税-其中本年新欠
	 */
	private BigDecimal farmLandOccupyTaxNew;
	/**
	 * 土地使用税-欠税余额
	 */
	private BigDecimal landUseTax;
	/**
	 * 土地使用税-其中本年新欠
	 */
	private BigDecimal landUseTaxNew;
	/**
	 * 土地增值税-欠税余额
	 */
	private BigDecimal landValueAddTax;
	/**
	 * 土地增值税-其中本年新欠
	 */
	private BigDecimal landValueAddTaxNew;
	/**
	 * 个人所得税-欠税余额
	 */
	private BigDecimal personalIncomeTax;
	/**
	 * 个人所得税-其中本年新欠
	 */
	private BigDecimal personalIncomeTaxNew;
	/**
	 * 企业所得税-欠税余额
	 */
	private BigDecimal companyIncomeTax;
	/**
	 * 企业所得税-其中本年新欠
	 */
	private BigDecimal companyIncomeTaxNew;
	/**
	 * 印花税-欠税余额
	 */
	private BigDecimal printTax;
	/**
	 * 印花税-其中本年新欠
	 */
	private BigDecimal printTaxNew;
	/**
	 * 车船税-欠税余额
	 */
	private BigDecimal carShipTax;
	/**
	 * 车船税-其中本年新欠
	 */
	private BigDecimal carShipTaxNew;
	/**
	 * 契税-欠税余额
	 */
	private BigDecimal contractTax;
	/**
	 * 契税-其中本年新欠
	 */
	private BigDecimal contractTaxNew;
	/**
	 * 资源税-欠税余额
	 */
	private BigDecimal resourceTax;
	/**
	 * 资源税-其中本年新欠
	 */
	private BigDecimal resourceTaxNew;
	/**
	 * 合计-欠税余额
	 */
	private BigDecimal totalTax;
	/**
	 * 合计-其中本年新欠
	 */
	private BigDecimal totalTaxNew;
	/**
	 * 数据更新时间戳
	 */
	private Date dataUpdateTime;
	/**
	 * 创建时间
	 */
	 @TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;
	/**
	 * 最后修改时间
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
	 * 设置：法人（业主）姓名
	 */
	public void setLegalPersonName(String legalPersonName) {
		this.legalPersonName = legalPersonName;
	}
	/**
	 * 获取：法人（业主）姓名
	 */
	public String getLegalPersonName() {
		return legalPersonName;
	}
	/**
	 * 设置：法人（业主）身份证号
	 */
	public void setLegalPersonCertNo(String legalPersonCertNo) {
		this.legalPersonCertNo = legalPersonCertNo;
	}
	/**
	 * 获取：法人（业主）身份证号
	 */
	public String getLegalPersonCertNo() {
		return legalPersonCertNo;
	}
	/**
	 * 设置：经营地址
	 */
	public void setBusinessAddress(String businessAddress) {
		this.businessAddress = businessAddress;
	}
	/**
	 * 获取：经营地址
	 */
	public String getBusinessAddress() {
		return businessAddress;
	}
	/**
	 * 设置：营业税-欠税余额
	 */
	public void setBusinessTaxOwing(BigDecimal businessTaxOwing) {
		this.businessTaxOwing = businessTaxOwing;
	}
	/**
	 * 获取：营业税-欠税余额
	 */
	public BigDecimal getBusinessTaxOwing() {
		return businessTaxOwing;
	}
	/**
	 * 设置：营业税-其中本年新欠
	 */
	public void setBusinessTaxOwingNew(BigDecimal businessTaxOwingNew) {
		this.businessTaxOwingNew = businessTaxOwingNew;
	}
	/**
	 * 获取：营业税-其中本年新欠
	 */
	public BigDecimal getBusinessTaxOwingNew() {
		return businessTaxOwingNew;
	}
	/**
	 * 设置：房产税-欠税余额
	 */
	public void setPropertyTaxOwing(BigDecimal propertyTaxOwing) {
		this.propertyTaxOwing = propertyTaxOwing;
	}
	/**
	 * 获取：房产税-欠税余额
	 */
	public BigDecimal getPropertyTaxOwing() {
		return propertyTaxOwing;
	}
	/**
	 * 设置：房产税-其中本年新欠
	 */
	public void setPropertyTaxOwingNew(BigDecimal propertyTaxOwingNew) {
		this.propertyTaxOwingNew = propertyTaxOwingNew;
	}
	/**
	 * 获取：房产税-其中本年新欠
	 */
	public BigDecimal getPropertyTaxOwingNew() {
		return propertyTaxOwingNew;
	}
	/**
	 * 设置：城市维护建设税-欠税余额
	 */
	public void setCityBuildTax(BigDecimal cityBuildTax) {
		this.cityBuildTax = cityBuildTax;
	}
	/**
	 * 获取：城市维护建设税-欠税余额
	 */
	public BigDecimal getCityBuildTax() {
		return cityBuildTax;
	}
	/**
	 * 设置：城市维护建设税-其中本年新欠
	 */
	public void setCityBuildTaxNew(BigDecimal cityBuildTaxNew) {
		this.cityBuildTaxNew = cityBuildTaxNew;
	}
	/**
	 * 获取：城市维护建设税-其中本年新欠
	 */
	public BigDecimal getCityBuildTaxNew() {
		return cityBuildTaxNew;
	}
	/**
	 * 设置：教育费附加-欠税余额
	 */
	public void setEducationTax(BigDecimal educationTax) {
		this.educationTax = educationTax;
	}
	/**
	 * 获取：教育费附加-欠税余额
	 */
	public BigDecimal getEducationTax() {
		return educationTax;
	}
	/**
	 * 设置：教育费附加-其中本年新欠
	 */
	public void setEducationTaxNew(BigDecimal educationTaxNew) {
		this.educationTaxNew = educationTaxNew;
	}
	/**
	 * 获取：教育费附加-其中本年新欠
	 */
	public BigDecimal getEducationTaxNew() {
		return educationTaxNew;
	}
	/**
	 * 设置：耕地占用税-欠税余额
	 */
	public void setFarmLandOccupyTax(BigDecimal farmLandOccupyTax) {
		this.farmLandOccupyTax = farmLandOccupyTax;
	}
	/**
	 * 获取：耕地占用税-欠税余额
	 */
	public BigDecimal getFarmLandOccupyTax() {
		return farmLandOccupyTax;
	}
	/**
	 * 设置：耕地占用税-其中本年新欠
	 */
	public void setFarmLandOccupyTaxNew(BigDecimal farmLandOccupyTaxNew) {
		this.farmLandOccupyTaxNew = farmLandOccupyTaxNew;
	}
	/**
	 * 获取：耕地占用税-其中本年新欠
	 */
	public BigDecimal getFarmLandOccupyTaxNew() {
		return farmLandOccupyTaxNew;
	}
	/**
	 * 设置：土地使用税-欠税余额
	 */
	public void setLandUseTax(BigDecimal landUseTax) {
		this.landUseTax = landUseTax;
	}
	/**
	 * 获取：土地使用税-欠税余额
	 */
	public BigDecimal getLandUseTax() {
		return landUseTax;
	}
	/**
	 * 设置：土地使用税-其中本年新欠
	 */
	public void setLandUseTaxNew(BigDecimal landUseTaxNew) {
		this.landUseTaxNew = landUseTaxNew;
	}
	/**
	 * 获取：土地使用税-其中本年新欠
	 */
	public BigDecimal getLandUseTaxNew() {
		return landUseTaxNew;
	}
	/**
	 * 设置：土地增值税-欠税余额
	 */
	public void setLandValueAddTax(BigDecimal landValueAddTax) {
		this.landValueAddTax = landValueAddTax;
	}
	/**
	 * 获取：土地增值税-欠税余额
	 */
	public BigDecimal getLandValueAddTax() {
		return landValueAddTax;
	}
	/**
	 * 设置：土地增值税-其中本年新欠
	 */
	public void setLandValueAddTaxNew(BigDecimal landValueAddTaxNew) {
		this.landValueAddTaxNew = landValueAddTaxNew;
	}
	/**
	 * 获取：土地增值税-其中本年新欠
	 */
	public BigDecimal getLandValueAddTaxNew() {
		return landValueAddTaxNew;
	}
	/**
	 * 设置：个人所得税-欠税余额
	 */
	public void setPersonalIncomeTax(BigDecimal personalIncomeTax) {
		this.personalIncomeTax = personalIncomeTax;
	}
	/**
	 * 获取：个人所得税-欠税余额
	 */
	public BigDecimal getPersonalIncomeTax() {
		return personalIncomeTax;
	}
	/**
	 * 设置：个人所得税-其中本年新欠
	 */
	public void setPersonalIncomeTaxNew(BigDecimal personalIncomeTaxNew) {
		this.personalIncomeTaxNew = personalIncomeTaxNew;
	}
	/**
	 * 获取：个人所得税-其中本年新欠
	 */
	public BigDecimal getPersonalIncomeTaxNew() {
		return personalIncomeTaxNew;
	}
	/**
	 * 设置：企业所得税-欠税余额
	 */
	public void setCompanyIncomeTax(BigDecimal companyIncomeTax) {
		this.companyIncomeTax = companyIncomeTax;
	}
	/**
	 * 获取：企业所得税-欠税余额
	 */
	public BigDecimal getCompanyIncomeTax() {
		return companyIncomeTax;
	}
	/**
	 * 设置：企业所得税-其中本年新欠
	 */
	public void setCompanyIncomeTaxNew(BigDecimal companyIncomeTaxNew) {
		this.companyIncomeTaxNew = companyIncomeTaxNew;
	}
	/**
	 * 获取：企业所得税-其中本年新欠
	 */
	public BigDecimal getCompanyIncomeTaxNew() {
		return companyIncomeTaxNew;
	}
	/**
	 * 设置：印花税-欠税余额
	 */
	public void setPrintTax(BigDecimal printTax) {
		this.printTax = printTax;
	}
	/**
	 * 获取：印花税-欠税余额
	 */
	public BigDecimal getPrintTax() {
		return printTax;
	}
	/**
	 * 设置：印花税-其中本年新欠
	 */
	public void setPrintTaxNew(BigDecimal printTaxNew) {
		this.printTaxNew = printTaxNew;
	}
	/**
	 * 获取：印花税-其中本年新欠
	 */
	public BigDecimal getPrintTaxNew() {
		return printTaxNew;
	}
	/**
	 * 设置：车船税-欠税余额
	 */
	public void setCarShipTax(BigDecimal carShipTax) {
		this.carShipTax = carShipTax;
	}
	/**
	 * 获取：车船税-欠税余额
	 */
	public BigDecimal getCarShipTax() {
		return carShipTax;
	}
	/**
	 * 设置：车船税-其中本年新欠
	 */
	public void setCarShipTaxNew(BigDecimal carShipTaxNew) {
		this.carShipTaxNew = carShipTaxNew;
	}
	/**
	 * 获取：车船税-其中本年新欠
	 */
	public BigDecimal getCarShipTaxNew() {
		return carShipTaxNew;
	}
	/**
	 * 设置：契税-欠税余额
	 */
	public void setContractTax(BigDecimal contractTax) {
		this.contractTax = contractTax;
	}
	/**
	 * 获取：契税-欠税余额
	 */
	public BigDecimal getContractTax() {
		return contractTax;
	}
	/**
	 * 设置：契税-其中本年新欠
	 */
	public void setContractTaxNew(BigDecimal contractTaxNew) {
		this.contractTaxNew = contractTaxNew;
	}
	/**
	 * 获取：契税-其中本年新欠
	 */
	public BigDecimal getContractTaxNew() {
		return contractTaxNew;
	}
	/**
	 * 设置：资源税-欠税余额
	 */
	public void setResourceTax(BigDecimal resourceTax) {
		this.resourceTax = resourceTax;
	}
	/**
	 * 获取：资源税-欠税余额
	 */
	public BigDecimal getResourceTax() {
		return resourceTax;
	}
	/**
	 * 设置：资源税-其中本年新欠
	 */
	public void setResourceTaxNew(BigDecimal resourceTaxNew) {
		this.resourceTaxNew = resourceTaxNew;
	}
	/**
	 * 获取：资源税-其中本年新欠
	 */
	public BigDecimal getResourceTaxNew() {
		return resourceTaxNew;
	}
	/**
	 * 设置：合计-欠税余额
	 */
	public void setTotalTax(BigDecimal totalTax) {
		this.totalTax = totalTax;
	}
	/**
	 * 获取：合计-欠税余额
	 */
	public BigDecimal getTotalTax() {
		return totalTax;
	}
	/**
	 * 设置：合计-其中本年新欠
	 */
	public void setTotalTaxNew(BigDecimal totalTaxNew) {
		this.totalTaxNew = totalTaxNew;
	}
	/**
	 * 获取：合计-其中本年新欠
	 */
	public BigDecimal getTotalTaxNew() {
		return totalTaxNew;
	}
	/**
	 * 设置：数据更新时间戳
	 */
	public void setDataUpdateTime(Date dataUpdateTime) {
		this.dataUpdateTime = dataUpdateTime;
	}
	/**
	 * 获取：数据更新时间戳
	 */
	public Date getDataUpdateTime() {
		return dataUpdateTime;
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
	 * 设置：最后修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：最后修改时间
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
