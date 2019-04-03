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
 * 欠税信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:20
 */
@TableName("rpt_tn_owing_tax")
public class RptTnOwingTaxEntity implements Serializable {
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
	 * 发布日期
	 */
	private String publicDate;
	/**
	 * 纳税人识别号(已加密)
	 */
	private String taxNo;
	/**
	 * 欠税税种
	 */
	private String oweTaxType;
	/**
	 * 当前发生的欠税额
	 */
	private String currentOweTaxAmount;
	/**
	 * 欠税余额
	 */
	private String ownTaxBalance;
	/**
	 * 税务机关
	 */
	private String taxDepart;
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
	 * 设置：发布日期
	 */
	public void setPublicDate(String publicDate) {
		this.publicDate = publicDate;
	}
	/**
	 * 获取：发布日期
	 */
	public String getPublicDate() {
		return publicDate;
	}
	/**
	 * 设置：纳税人识别号(已加密)
	 */
	public void setTaxNo(String taxNo) {
		this.taxNo = taxNo;
	}
	/**
	 * 获取：纳税人识别号(已加密)
	 */
	public String getTaxNo() {
		return taxNo;
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
	 * 设置：当前发生的欠税额
	 */
	public void setCurrentOweTaxAmount(String currentOweTaxAmount) {
		this.currentOweTaxAmount = currentOweTaxAmount;
	}
	/**
	 * 获取：当前发生的欠税额
	 */
	public String getCurrentOweTaxAmount() {
		return currentOweTaxAmount;
	}
	/**
	 * 设置：欠税余额
	 */
	public void setOwnTaxBalance(String ownTaxBalance) {
		this.ownTaxBalance = ownTaxBalance;
	}
	/**
	 * 获取：欠税余额
	 */
	public String getOwnTaxBalance() {
		return ownTaxBalance;
	}
	/**
	 * 设置：税务机关
	 */
	public void setTaxDepart(String taxDepart) {
		this.taxDepart = taxDepart;
	}
	/**
	 * 获取：税务机关
	 */
	public String getTaxDepart() {
		return taxDepart;
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
