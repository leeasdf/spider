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
 * 股东信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:22
 */
@TableName("rpt_tn_shareholders")
public class RptTnShareholdersEntity implements Serializable {
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
	 * 股东(发起人)
	 */
	private String name;
	/**
	 * 出资比例
	 */
	private String funRatio;
	/**
	 * 认缴出资
	 */
	private String subFunding;
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
	 * 出资时间
	 */
	private String amountDate;
	/**
	 * 天眼查地址
	 */
	private String url;
	/**
	 * 是否大股东
	 */
	private String isMax;

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
	 * 设置：股东(发起人)
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：股东(发起人)
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：出资比例
	 */
	public void setFunRatio(String funRatio) {
		this.funRatio = funRatio;
	}
	/**
	 * 获取：出资比例
	 */
	public String getFunRatio() {
		return funRatio;
	}
	/**
	 * 设置：认缴出资
	 */
	public void setSubFunding(String subFunding) {
		this.subFunding = subFunding;
	}
	/**
	 * 获取：认缴出资
	 */
	public String getSubFunding() {
		return subFunding;
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
	/**
	 * 设置：出资时间
	 */
	public void setAmountDate(String amountDate) {
		this.amountDate = amountDate;
	}
	/**
	 * 获取：出资时间
	 */
	public String getAmountDate() {
		return amountDate;
	}
	/**
	 * 设置：天眼查地址
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：天眼查地址
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：是否大股东
	 */
	public void setIsMax(String isMax) {
		this.isMax = isMax;
	}
	/**
	 * 获取：是否大股东
	 */
	public String getIsMax() {
		return isMax;
	}
}
