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
 * tyc企业年报-企业基本信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-12-05 17:21:31
 */
@TableName("rpt_tn_report_base")
public class RptTnReportBaseEntity implements Serializable {
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
	 * 统一社会信息代码
	 */
	private String creditCode;
	/**
	 * 企业名称
	 */
	private String name;
	/**
	 * 企业联系电话
	 */
	private String phone;
	/**
	 * 邮政编码
	 */
	private String postalcode;
	/**
	 * 企业经营状况
	 */
	private String status;
	/**
	 * 从业人数
	 */
	private String employeeCount;
	/**
	 * 电子邮箱
	 */
	private String email;
	/**
	 *  是否有网站或网点
	 */
	private String websiteFlag;
	/**
	 * 企业通信地址
	 */
	private String address;
	/**
	 * 企业是否有投资信息或购买其他公司股权
	 */
	private String investFlag;
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
	 * 设置：统一社会信息代码
	 */
	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}
	/**
	 * 获取：统一社会信息代码
	 */
	public String getCreditCode() {
		return creditCode;
	}
	/**
	 * 设置：企业名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：企业名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：企业联系电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：企业联系电话
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：邮政编码
	 */
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	/**
	 * 获取：邮政编码
	 */
	public String getPostalcode() {
		return postalcode;
	}
	/**
	 * 设置：企业经营状况
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：企业经营状况
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：从业人数
	 */
	public void setEmployeeCount(String employeeCount) {
		this.employeeCount = employeeCount;
	}
	/**
	 * 获取：从业人数
	 */
	public String getEmployeeCount() {
		return employeeCount;
	}
	/**
	 * 设置：电子邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：电子邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置： 是否有网站或网点
	 */
	public void setWebsiteFlag(String websiteFlag) {
		this.websiteFlag = websiteFlag;
	}
	/**
	 * 获取： 是否有网站或网点
	 */
	public String getWebsiteFlag() {
		return websiteFlag;
	}
	/**
	 * 设置：企业通信地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：企业通信地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：企业是否有投资信息或购买其他公司股权
	 */
	public void setInvestFlag(String investFlag) {
		this.investFlag = investFlag;
	}
	/**
	 * 获取：企业是否有投资信息或购买其他公司股权
	 */
	public String getInvestFlag() {
		return investFlag;
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
