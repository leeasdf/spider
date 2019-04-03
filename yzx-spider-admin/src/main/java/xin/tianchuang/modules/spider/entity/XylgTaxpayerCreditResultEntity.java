package xin.tianchuang.modules.spider.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 信用麓谷-纳税信用结果表
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 10:14:18
 */
@TableName("xylg_taxpayer_credit_result")
public class XylgTaxpayerCreditResultEntity implements Serializable {
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
	 * 税务登记码
	 */
	private String taxNo;
	/**
	 * 信用级别A
	 */
	private String creditRating;
	/**
	 * 评价税务机关
	 */
	private String taxAuthority;
	/**
	 * 评价年度
	 */
	private String evaluationYear;
	/**
	 * 评价日期
	 */
	private String evaluationDate;
	/**
	 * 数据状态（0：正常 1：更新 2：删除）
	 */
	 @TableField(value = "data_state", fill = FieldFill.INSERT)
	private Integer dataState;
	/**
	 * 最后修改时间
	 */
	 @TableField(value = "update_time", fill = FieldFill.UPDATE)
	private Date updateTime;
	/**
	 * 创建时间
	 */
	 @TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;

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
	 * 设置：税务登记码
	 */
	public void setTaxNo(String taxNo) {
		this.taxNo = taxNo;
	}
	/**
	 * 获取：税务登记码
	 */
	public String getTaxNo() {
		return taxNo;
	}
	/**
	 * 设置：信用级别A
	 */
	public void setCreditRating(String creditRating) {
		this.creditRating = creditRating;
	}
	/**
	 * 获取：信用级别A
	 */
	public String getCreditRating() {
		return creditRating;
	}
	/**
	 * 设置：评价税务机关
	 */
	public void setTaxAuthority(String taxAuthority) {
		this.taxAuthority = taxAuthority;
	}
	/**
	 * 获取：评价税务机关
	 */
	public String getTaxAuthority() {
		return taxAuthority;
	}
	/**
	 * 设置：评价年度
	 */
	public void setEvaluationYear(String evaluationYear) {
		this.evaluationYear = evaluationYear;
	}
	/**
	 * 获取：评价年度
	 */
	public String getEvaluationYear() {
		return evaluationYear;
	}
	/**
	 * 设置：评价日期
	 */
	public void setEvaluationDate(String evaluationDate) {
		this.evaluationDate = evaluationDate;
	}
	/**
	 * 获取：评价日期
	 */
	public String getEvaluationDate() {
		return evaluationDate;
	}
	/**
	 * 设置：数据状态（0：正常 1：更新 2：删除）
	 */
	public void setDataState(Integer dataState) {
		this.dataState = dataState;
	}
	/**
	 * 获取：数据状态（0：正常 1：更新 2：删除）
	 */
	public Integer getDataState() {
		return dataState;
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
}
