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
 * 企业变更记录
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:21
 */
@TableName("rpt_tn_change")
public class RptTnChangeEntity implements Serializable {
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
	private String name;
	/**
	 * 变更时间
	 */
	private String changeDate;
	/**
	 * 变更后
	 */
	private String changeAfter;

	/**
	 * 变更项
	 */
	private String changeItem;
	/**
	 * 变更前
	 */
	private String changeBefore;

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
	 * 设置：变更时间
	 */
	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
	}

	/**
	 * 获取：变更时间
	 */
	public String getChangeDate() {
		return changeDate;
	}

	/**
	 * 设置：变更后
	 */
	public void setChangeAfter(String changeAfter) {
		this.changeAfter = changeAfter;
	}

	/**
	 * 获取：变更后
	 */
	public String getChangeAfter() {
		return changeAfter;
	}

	/**
	 * 设置：变更项
	 */
	public void setChangeItem(String changeItem) {
		this.changeItem = changeItem;
	}

	/**
	 * 获取：变更项
	 */
	public String getChangeItem() {
		return changeItem;
	}

	/**
	 * 设置：变更前
	 */
	public void setChangeBefore(String changeBefore) {
		this.changeBefore = changeBefore;
	}

	/**
	 * 获取：变更前
	 */
	public String getChangeBefore() {
		return changeBefore;
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
