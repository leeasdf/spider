package xin.tianchuang.modules.spider.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * 双公示-行政处罚
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:23
 */
@TableName("ent_high_tech_punish_info")
public class EntHighTechPunishInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 
	 */
	private Integer memId;
	/**
	 * 执法部门
	 */
	private String lawEnforcement;
	/**
	 * 行政处罚决定书文号
	 */
	private String punishNum;
	/**
	 * 公司名称
	 */
	private String company;
	/**
	 * 企业法人
	 */
	private String companyLegalPerson;
	/**
	 * 作出行政处罚的日期
	 */
	private Date publishDate;
	/**
	 * 案例名称
	 */
	private String caseName;
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
	 * 设置：
	 */
	public void setMemId(Integer memId) {
		this.memId = memId;
	}
	/**
	 * 获取：
	 */
	public Integer getMemId() {
		return memId;
	}
	/**
	 * 设置：执法部门
	 */
	public void setLawEnforcement(String lawEnforcement) {
		this.lawEnforcement = lawEnforcement;
	}
	/**
	 * 获取：执法部门
	 */
	public String getLawEnforcement() {
		return lawEnforcement;
	}
	/**
	 * 设置：行政处罚决定书文号
	 */
	public void setPunishNum(String punishNum) {
		this.punishNum = punishNum;
	}
	/**
	 * 获取：行政处罚决定书文号
	 */
	public String getPunishNum() {
		return punishNum;
	}
	/**
	 * 设置：公司名称
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	/**
	 * 获取：公司名称
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * 设置：企业法人
	 */
	public void setCompanyLegalPerson(String companyLegalPerson) {
		this.companyLegalPerson = companyLegalPerson;
	}
	/**
	 * 获取：企业法人
	 */
	public String getCompanyLegalPerson() {
		return companyLegalPerson;
	}
	/**
	 * 设置：作出行政处罚的日期
	 */
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	/**
	 * 获取：作出行政处罚的日期
	 */
	public Date getPublishDate() {
		return publishDate;
	}
	/**
	 * 设置：案例名称
	 */
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	/**
	 * 获取：案例名称
	 */
	public String getCaseName() {
		return caseName;
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
