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
 * 湖南省税务局-欠税公告
 * 
 * @author hui.deng
 * @email
 * @date 2018-12-12 17:41:23
 */
@TableName("hntax_owe_tax_info")
public class HntaxOweTaxInfoEntity implements Serializable {
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
	 * 纳税人名称
	 */
	private String taxName;
	/**
	 * 纳税人识别号
	 */
	private String taxNo;
	/**
	 * 法定代表人(负责人)姓名
	 */
	private String legalName;
	/**
	 * 法定代表人(负责人)证件类型
	 */
	private String certType;
	/**
	 * 法定代表人(负责人)证件号码
	 */
	private String certNo;
	/**
	 * 经营地点
	 */
	private String address;
	/**
	 * 欠税税种
	 */
	private String oweTaxType;
	/**
	 * 欠税余额（元）
	 */
	private String oweTaxBalance;
	/**
	 * 当期新发生的欠税金额（元）
	 */
	private String currentOccurreAmount;
	/**
	 * 公示时间
	 */
	private String publishDate;

	/**
	 * 用户类型
	 */
	private String userType;
	/**
	 * 数据来源
	 */
	private String dataSource;
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
	 * 设置：纳税人名称
	 */
	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}

	/**
	 * 获取：纳税人名称
	 */
	public String getTaxName() {
		return taxName;
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
	 * 设置：法定代表人(负责人)姓名
	 */
	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	/**
	 * 获取：法定代表人(负责人)姓名
	 */
	public String getLegalName() {
		return legalName;
	}

	/**
	 * 设置：法定代表人(负责人)证件类型
	 */
	public void setCertType(String certType) {
		this.certType = certType;
	}

	/**
	 * 获取：法定代表人(负责人)证件类型
	 */
	public String getCertType() {
		return certType;
	}

	/**
	 * 设置：法定代表人(负责人)证件号码
	 */
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	/**
	 * 获取：法定代表人(负责人)证件号码
	 */
	public String getCertNo() {
		return certNo;
	}

	/**
	 * 设置：经营地点
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 获取：经营地点
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 设置：欠税税种
	 */
	public void setOweTaxType(String oweTaxType) {
		this.oweTaxType = oweTaxType;
	}

	/**
	 * 获取：欠税税种
	 */
	public String getOweTaxType() {
		return oweTaxType;
	}

	/**
	 * 设置：欠税余额（元）
	 */
	public void setOweTaxBalance(String oweTaxBalance) {
		this.oweTaxBalance = oweTaxBalance;
	}

	/**
	 * 获取：欠税余额（元）
	 */
	public String getOweTaxBalance() {
		return oweTaxBalance;
	}

	/**
	 * 设置：当期新发生的欠税金额（元）
	 */
	public void setCurrentOccurreAmount(String currentOccurreAmount) {
		this.currentOccurreAmount = currentOccurreAmount;
	}

	/**
	 * 获取：当期新发生的欠税金额（元）
	 */
	public String getCurrentOccurreAmount() {
		return currentOccurreAmount;
	}

	/**
	 * 设置：公示时间
	 */
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	/**
	 * 获取：公示时间
	 */
	public String getPublishDate() {
		return publishDate;
	}

	/**
	 * 设置：数据来源
	 */
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * 获取：数据来源
	 */
	public String getDataSource() {
		return dataSource;
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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
