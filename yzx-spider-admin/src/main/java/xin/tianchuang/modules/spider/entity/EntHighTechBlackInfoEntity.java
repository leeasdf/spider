package xin.tianchuang.modules.spider.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 失信黑榜
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:24
 */
@TableName("ent_high_tech_black_info")
public class EntHighTechBlackInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 绑定成员
	 */
	private Integer memId;
	/**
	 * 企业ID
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long enterpriseId;
	/**
	 * 上榜事由
	 */
	private String reason;
	/**
	 * 来源部门
	 */
	private String sourceDepartment;
	/**
	 * 备注
	 */
	private String remarks;
	/**
	 * 榜单名称
	 */
	private String blackRollName;
	/**
	 * 公司名称
	 */
	private String company;
	/**
	 * 发布日期
	 */
	private String date;

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
	 * 设置：绑定成员
	 */
	public void setMemId(Integer memId) {
		this.memId = memId;
	}
	/**
	 * 获取：绑定成员
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
	 * 设置：上榜事由
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	 * 获取：上榜事由
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * 设置：来源部门
	 */
	public void setSourceDepartment(String sourceDepartment) {
		this.sourceDepartment = sourceDepartment;
	}
	/**
	 * 获取：来源部门
	 */
	public String getSourceDepartment() {
		return sourceDepartment;
	}
	/**
	 * 设置：备注
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * 获取：备注
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * 设置：榜单名称
	 */
	public void setBlackRollName(String blackRollName) {
		this.blackRollName = blackRollName;
	}
	/**
	 * 获取：榜单名称
	 */
	public String getBlackRollName() {
		return blackRollName;
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
	 * 设置：发布日期
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * 获取：发布日期
	 */
	public String getDate() {
		return date;
	}
}
