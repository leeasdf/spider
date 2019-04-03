package xin.tianchuang.modules.spider.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 环境行政处罚(导入)
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:23
 */
@TableName("ori_environmental_penalty")
public class OriEnvironmentalPenaltyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 所属地区
	 */
	private String area;
	/**
	 * 执法部门
	 */
	private String lawDepartment;
	/**
	 * 处罚书文号
	 */
	private String docNumber;
	/**
	 * 被处罚单位及法人姓名
	 */
	private String enterpriseName;
	/**
	 * 处罚日期
	 */
	private String dealDate;
	/**
	 * 处罚类别
	 */
	private String result;
	/**
	 * 处罚事由
	 */
	private String reason;
	/**
	 * 整改情况
	 */
	private String situation;

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
	 * 设置：所属地区
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * 获取：所属地区
	 */
	public String getArea() {
		return area;
	}
	/**
	 * 设置：执法部门
	 */
	public void setLawDepartment(String lawDepartment) {
		this.lawDepartment = lawDepartment;
	}
	/**
	 * 获取：执法部门
	 */
	public String getLawDepartment() {
		return lawDepartment;
	}
	/**
	 * 设置：处罚书文号
	 */
	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}
	/**
	 * 获取：处罚书文号
	 */
	public String getDocNumber() {
		return docNumber;
	}
	/**
	 * 设置：被处罚单位及法人姓名
	 */
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	/**
	 * 获取：被处罚单位及法人姓名
	 */
	public String getEnterpriseName() {
		return enterpriseName;
	}
	/**
	 * 设置：处罚日期
	 */
	public void setDealDate(String dealDate) {
		this.dealDate = dealDate;
	}
	/**
	 * 获取：处罚日期
	 */
	public String getDealDate() {
		return dealDate;
	}
	/**
	 * 设置：处罚类别
	 */
	public void setResult(String result) {
		this.result = result;
	}
	/**
	 * 获取：处罚类别
	 */
	public String getResult() {
		return result;
	}
	/**
	 * 设置：处罚事由
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	 * 获取：处罚事由
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * 设置：整改情况
	 */
	public void setSituation(String situation) {
		this.situation = situation;
	}
	/**
	 * 获取：整改情况
	 */
	public String getSituation() {
		return situation;
	}
}
