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
 * 企业水电数据
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:17
 */
@TableName("enterprise_water_electricity")
public class EnterpriseWaterElectricityEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 企业ID
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long enterpriseId;
	/**
	 * 孵化器企业ID
	 */
	private Integer incubatorEnterpriseId;
	/**
	 * 孵化器名称
	 */
	private String incubatorName;
	/**
	 * 企业名称
	 */
	private String enterpriseName;
	/**
	 * 楼栋房号
	 */
	private String buildingRoomNo;
	/**
	 * 费用类型
	 */
	private String costType;
	/**
	 * 年月份
	 */
	private String yearMonth;
	/**
	 * 额度类型
	 */
	private String costLimitType;
	/**
	 * 数量
	 */
	private BigDecimal quantity;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 创建时间
	 */
	 @TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createtime;

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
	 * 设置：孵化器企业ID
	 */
	public void setIncubatorEnterpriseId(Integer incubatorEnterpriseId) {
		this.incubatorEnterpriseId = incubatorEnterpriseId;
	}
	/**
	 * 获取：孵化器企业ID
	 */
	public Integer getIncubatorEnterpriseId() {
		return incubatorEnterpriseId;
	}
	/**
	 * 设置：孵化器名称
	 */
	public void setIncubatorName(String incubatorName) {
		this.incubatorName = incubatorName;
	}
	/**
	 * 获取：孵化器名称
	 */
	public String getIncubatorName() {
		return incubatorName;
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
	 * 设置：楼栋房号
	 */
	public void setBuildingRoomNo(String buildingRoomNo) {
		this.buildingRoomNo = buildingRoomNo;
	}
	/**
	 * 获取：楼栋房号
	 */
	public String getBuildingRoomNo() {
		return buildingRoomNo;
	}
	/**
	 * 设置：费用类型
	 */
	public void setCostType(String costType) {
		this.costType = costType;
	}
	/**
	 * 获取：费用类型
	 */
	public String getCostType() {
		return costType;
	}
	/**
	 * 设置：年月份
	 */
	public void setYearMonth(String yearMonth) {
		this.yearMonth = yearMonth;
	}
	/**
	 * 获取：年月份
	 */
	public String getYearMonth() {
		return yearMonth;
	}
	/**
	 * 设置：额度类型
	 */
	public void setCostLimitType(String costLimitType) {
		this.costLimitType = costLimitType;
	}
	/**
	 * 获取：额度类型
	 */
	public String getCostLimitType() {
		return costLimitType;
	}
	/**
	 * 设置：数量
	 */
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	/**
	 * 获取：数量
	 */
	public BigDecimal getQuantity() {
		return quantity;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreatetime() {
		return createtime;
	}
}
