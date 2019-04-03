package xin.tianchuang.modules.dataparser.entity;

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
 * 信用中国-信用类型中间表(路由表)
 * 
 * @author hui.deng
 * @email 
 * @date 2018-10-15 15:36:13
 */
@TableName("creditchina_credit_type")
public class CreditchinaCreditTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 类型 (2:honesty-守信红名单,4:focus-重点关注名单,8:black-黑名单)
	 */
	private String creditType;
	/**
	 * 数据来源 有不同的来源数据类型不一样,在不同的表中
	 */
	private String source;
	/**
	 * 对应的表名
	 */
	private String tableName;
	/**
	 * 对应的实体对象名称
	 */
	private String entityName;
	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;
	/**
	 * 更新时间
	 */
	@TableField(fill = FieldFill.UPDATE)
	private Date updateTime;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 数据状态
	 */
	@TableField(fill = FieldFill.INSERT)
	private Integer dataStatus;

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
	 * 设置：类型 (2:honesty-守信红名单,4:focus-重点关注名单,8:black-黑名单)
	 */
	public void setCreditType(String creditType) {
		this.creditType = creditType;
	}
	/**
	 * 获取：类型 (2:honesty-守信红名单,4:focus-重点关注名单,8:black-黑名单)
	 */
	public String getCreditType() {
		return creditType;
	}
	/**
	 * 设置：数据来源 有不同的来源数据类型不一样,在不同的表中
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * 获取：数据来源 有不同的来源数据类型不一样,在不同的表中
	 */
	public String getSource() {
		return source;
	}
	/**
	 * 设置：对应的表名
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	/**
	 * 获取：对应的表名
	 */
	public String getTableName() {
		return tableName;
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
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
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
	 * 设置：数据状态
	 */
	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}
	/**
	 * 获取：数据状态
	 */
	public Integer getDataStatus() {
		return dataStatus;
	}
	/**
	 * 设置：对应的实体名称
	 */
	public String getEntityName() {
		return entityName;
	}
	/**
	 * 获取：对应的实体名称
	 */
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
}
