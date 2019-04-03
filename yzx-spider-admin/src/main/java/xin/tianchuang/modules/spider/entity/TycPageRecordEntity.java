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
 * 天眼查分页记录表
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 10:14:18
 */
@TableName("tyc_page_record")
public class TycPageRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 业务ID
	 */
	private String bizId;
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
	 * 翻页类型
	 */
	private Integer dataType;
	/**
	 * 翻页总条数
	 */
	private Integer pageTotal;
	/**
	 * 
	 */
	private Integer pageNum;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 创建时间
	 */
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;
	/**
	 * 更新时间
	 */
	@TableField(value = "update_time", fill = FieldFill.UPDATE)
	private Date updateTime;

	/**
	 * 设置：主键ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主键ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：业务ID
	 */
	public void setBizId(String bizId) {
		this.bizId = bizId;
	}
	/**
	 * 获取：业务ID
	 */
	public String getBizId() {
		return bizId;
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
	 * 设置：翻页类型
	 */
	public void setDataType(Integer dataType) {
		this.dataType = dataType;
	}
	/**
	 * 获取：翻页类型
	 */
	public Integer getDataType() {
		return dataType;
	}
	/**
	 * 设置：翻页总条数
	 */
	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}
	/**
	 * 获取：翻页总条数
	 */
	public Integer getPageTotal() {
		return pageTotal;
	}
	/**
	 * 设置：
	 */
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	/**
	 * 获取：
	 */
	public Integer getPageNum() {
		return pageNum;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public String getStatus() {
		return status;
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
}
