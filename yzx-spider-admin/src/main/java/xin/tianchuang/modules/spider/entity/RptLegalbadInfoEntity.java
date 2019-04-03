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
 * 信用麓谷-法人不良信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:17
 */
@TableName("rpt_legalbad_info")
public class RptLegalbadInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 会员ID
	 */
	private Integer memid;
	/**
	 * 企业ID
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long enterpriseId;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 身份证号码
	 */
	private String idcard;
	/**
	 * 案发来源
	 */
	private String casesource;
	/**
	 * 案发时间
	 */
	private String casetime;
	/**
	 * 案件类型
	 */
	private String casetype;
	/**
	 * 涉案类型
	 */
	private String crimetype;
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
	 * 设置：会员ID
	 */
	public void setMemid(Integer memid) {
		this.memid = memid;
	}
	/**
	 * 获取：会员ID
	 */
	public Integer getMemid() {
		return memid;
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
	 * 设置：姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：身份证号码
	 */
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	/**
	 * 获取：身份证号码
	 */
	public String getIdcard() {
		return idcard;
	}
	/**
	 * 设置：案发来源
	 */
	public void setCasesource(String casesource) {
		this.casesource = casesource;
	}
	/**
	 * 获取：案发来源
	 */
	public String getCasesource() {
		return casesource;
	}
	/**
	 * 设置：案发时间
	 */
	public void setCasetime(String casetime) {
		this.casetime = casetime;
	}
	/**
	 * 获取：案发时间
	 */
	public String getCasetime() {
		return casetime;
	}
	/**
	 * 设置：案件类型
	 */
	public void setCasetype(String casetype) {
		this.casetype = casetype;
	}
	/**
	 * 获取：案件类型
	 */
	public String getCasetype() {
		return casetype;
	}
	/**
	 * 设置：涉案类型
	 */
	public void setCrimetype(String crimetype) {
		this.crimetype = crimetype;
	}
	/**
	 * 获取：涉案类型
	 */
	public String getCrimetype() {
		return crimetype;
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
