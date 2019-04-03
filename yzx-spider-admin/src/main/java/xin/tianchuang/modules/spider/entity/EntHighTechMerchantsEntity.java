package xin.tianchuang.modules.spider.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 招商项目合同情况表
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:24
 */
@TableName("ent_high_tech_merchants")
public class EntHighTechMerchantsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * gsmc
	 */
	private String company;
	/**
	 * xmmc
	 */
	private String projectName;
	/**
	 * 备注bz
	 */
	private String note;
	/**
	 * 
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
	 * 设置：gsmc
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	/**
	 * 获取：gsmc
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * 设置：xmmc
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * 获取：xmmc
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * 设置：备注bz
	 */
	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * 获取：备注bz
	 */
	public String getNote() {
		return note;
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
