package xin.tianchuang.modules.spider.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 项目立项情况表
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:24
 */
@TableName("ent_high_tech_project_approval")
public class EntHighTechProjectApprovalEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 年度
	 */
	private Integer year;
	/**
	 * 归口部门
	 */
	private String belongTo;
	/**
	 * 项目类别
	 */
	private String projectType;
	/**
	 * 项目名称
	 */
	private String projectName;
	/**
	 * 承担单位
	 */
	private String company;
	/**
	 * 
	 */
	private BigDecimal amount;
	/**
	 * 会员id
	 */
	private Integer memId;
	/**
	 * 企业ID
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long enterpriseId;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：年度
	 */
	public void setYear(Integer year) {
		this.year = year;
	}
	/**
	 * 获取：年度
	 */
	public Integer getYear() {
		return year;
	}
	/**
	 * 设置：归口部门
	 */
	public void setBelongTo(String belongTo) {
		this.belongTo = belongTo;
	}
	/**
	 * 获取：归口部门
	 */
	public String getBelongTo() {
		return belongTo;
	}
	/**
	 * 设置：项目类别
	 */
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	/**
	 * 获取：项目类别
	 */
	public String getProjectType() {
		return projectType;
	}
	/**
	 * 设置：项目名称
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * 获取：项目名称
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * 设置：承担单位
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	/**
	 * 获取：承担单位
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * 设置：
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	/**
	 * 设置：会员id
	 */
	public void setMemId(Integer memId) {
		this.memId = memId;
	}
	/**
	 * 获取：会员id
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
}
