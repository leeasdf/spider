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
 * 湖南省地方税务局-纳税信用等级信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-12-21 17:13:05
 */
@TableName("hnds_credit_level")
public class HndsCreditLevelEntity implements Serializable {
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
	 * 纳税人名称
	 */
	private String taxper;
	/**
	 * 税务登记号
	 */
	private String taxNo;
	/**
	 * 信用级别
	 */
	private String level;
	/**
	 * 评价税务䩪
	 */
	private String authority;
	/**
	 * 评价年度
	 */
	private String years;
	/**
	 * 评价日期
	 */
	private String evaluateDate;
	/**
	 * 数据来源
	 */
	private String dataSource;
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
	 * 设置：纳税人名称
	 */
	public void setTaxper(String taxper) {
		this.taxper = taxper;
	}

	/**
	 * 获取：纳税人名称
	 */
	public String getTaxper() {
		return taxper;
	}

	/**
	 * 设置：税务登记号
	 */
	public void setTaxNo(String taxNo) {
		this.taxNo = taxNo;
	}

	/**
	 * 获取：税务登记号
	 */
	public String getTaxNo() {
		return taxNo;
	}

	/**
	 * 设置：信用级别
	 */
	public void setLevel(String level) {
		this.level = level;
	}

	/**
	 * 获取：信用级别
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * 设置：评价税务䩪
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}

	/**
	 * 获取：评价税务䩪
	 */
	public String getAuthority() {
		return authority;
	}

	/**
	 * 设置：评价年度
	 */
	public void setYears(String years) {
		this.years = years;
	}

	/**
	 * 获取：评价年度
	 */
	public String getYears() {
		return years;
	}

	/**
	 * 设置：评价日期
	 */
	public void setEvaluateDate(String evaluateDate) {
		this.evaluateDate = evaluateDate;
	}

	/**
	 * 获取：评价日期
	 */
	public String getEvaluateDate() {
		return evaluateDate;
	}

	/**
	 * 设置：数据来源
	 */
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * 获取：数据来源
	 */
	public String getDataSource() {
		return dataSource;
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
}
