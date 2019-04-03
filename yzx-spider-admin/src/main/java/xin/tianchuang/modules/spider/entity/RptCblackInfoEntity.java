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
 * 信用麓谷-失信黑名单信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:18
 */
@TableName("rpt_cblack_info")
public class RptCblackInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 会员ID
	 */
	private Integer memId;
	/**
	 * 企业ID
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long enterpriseId;
	/**
	 * 作出决定机关
	 */
	private String organName;
	/**
	 * 类别
	 */
	private String type;
	/**
	 * 列入失信黑名单原因
	 */
	private String onReason;
	/**
	 * 列入日期
	 */
	private Date onDate;
	/**
	 * 移出失信黑名单原因
	 */
	private String outReason;
	/**
	 * 移出日期
	 */
	private Date outDate;
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
	 * 设置：会员ID
	 */
	public void setMemId(Integer memId) {
		this.memId = memId;
	}
	/**
	 * 获取：会员ID
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
	 * 设置：作出决定机关
	 */
	public void setOrganName(String organName) {
		this.organName = organName;
	}
	/**
	 * 获取：作出决定机关
	 */
	public String getOrganName() {
		return organName;
	}
	/**
	 * 设置：类别
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类别
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：列入失信黑名单原因
	 */
	public void setOnReason(String onReason) {
		this.onReason = onReason;
	}
	/**
	 * 获取：列入失信黑名单原因
	 */
	public String getOnReason() {
		return onReason;
	}
	/**
	 * 设置：列入日期
	 */
	public void setOnDate(Date onDate) {
		this.onDate = onDate;
	}
	/**
	 * 获取：列入日期
	 */
	public Date getOnDate() {
		return onDate;
	}
	/**
	 * 设置：移出失信黑名单原因
	 */
	public void setOutReason(String outReason) {
		this.outReason = outReason;
	}
	/**
	 * 获取：移出失信黑名单原因
	 */
	public String getOutReason() {
		return outReason;
	}
	/**
	 * 设置：移出日期
	 */
	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}
	/**
	 * 获取：移出日期
	 */
	public Date getOutDate() {
		return outDate;
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
