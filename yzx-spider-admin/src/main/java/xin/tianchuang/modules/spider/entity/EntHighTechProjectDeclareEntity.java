package xin.tianchuang.modules.spider.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 项目申报情况表
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:23
 */
@TableName("ent_high_tech_project_declare")
public class EntHighTechProjectDeclareEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 项目名称
	 */
	private String projectName;
	/**
	 * 承担单位
	 */
	private String company;
	/**
	 * 项目类型
	 */
	private String projectType;
	/**
	 * 
	 */
	private BigDecimal amount;
	/**
	 * 备注
	 */
	private String note;
	/**
	 * 来源excel表名
	 */
	private String excelSource;
	/**
	 * 统计年份
	 */
	private Integer statisticsYear;
	/**
	 * 文件号
	 */
	private String fileNumber;
	/**
	 * 绑定会员id
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
	 * 设置：项目类型
	 */
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	/**
	 * 获取：项目类型
	 */
	public String getProjectType() {
		return projectType;
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
	 * 设置：备注
	 */
	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * 获取：备注
	 */
	public String getNote() {
		return note;
	}
	/**
	 * 设置：来源excel表名
	 */
	public void setExcelSource(String excelSource) {
		this.excelSource = excelSource;
	}
	/**
	 * 获取：来源excel表名
	 */
	public String getExcelSource() {
		return excelSource;
	}
	/**
	 * 设置：统计年份
	 */
	public void setStatisticsYear(Integer statisticsYear) {
		this.statisticsYear = statisticsYear;
	}
	/**
	 * 获取：统计年份
	 */
	public Integer getStatisticsYear() {
		return statisticsYear;
	}
	/**
	 * 设置：文件号
	 */
	public void setFileNumber(String fileNumber) {
		this.fileNumber = fileNumber;
	}
	/**
	 * 获取：文件号
	 */
	public String getFileNumber() {
		return fileNumber;
	}
	/**
	 * 设置：绑定会员id
	 */
	public void setMemId(Integer memId) {
		this.memId = memId;
	}
	/**
	 * 获取：绑定会员id
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
