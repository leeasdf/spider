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
 * 行政处罚信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:21
 */
@TableName("rpt_tn_penalties")
public class RptTnPenaltiesEntity implements Serializable {
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
	 * 决定日期
	 */
	private String decisionDate;
	/**
	 * 决定书文号
	 */
	private String punishNumber;
	/**
	 * 类型
	 */
	private String type;
	/**
	 * 决定机关
	 */
	private String departmentName;
	/**
	 * 处罚内容
	 */
	private String content;
	/**
	 * 地域
	 */
	private String areaName;
	/**
	 * 处罚名称
	 */
	private String punishmentName;
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
	 * 注册号
	 */
	private String regNum;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 发布日期
	 */
	private String publishDate;
	/**
	 * 地点
	 */
	private String base;
	/**
	 * 法人
	 */
	private String legalPersonName;

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
	 * 设置：决定日期
	 */
	public void setDecisionDate(String decisionDate) {
		this.decisionDate = decisionDate;
	}
	/**
	 * 获取：决定日期
	 */
	public String getDecisionDate() {
		return decisionDate;
	}
	/**
	 * 设置：决定书文号
	 */
	public void setPunishNumber(String punishNumber) {
		this.punishNumber = punishNumber;
	}
	/**
	 * 获取：决定书文号
	 */
	public String getPunishNumber() {
		return punishNumber;
	}
	/**
	 * 设置：类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：决定机关
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	/**
	 * 获取：决定机关
	 */
	public String getDepartmentName() {
		return departmentName;
	}
	/**
	 * 设置：处罚内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：处罚内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：地域
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	/**
	 * 获取：地域
	 */
	public String getAreaName() {
		return areaName;
	}
	/**
	 * 设置：处罚名称
	 */
	public void setPunishmentName(String punishmentName) {
		this.punishmentName = punishmentName;
	}
	/**
	 * 获取：处罚名称
	 */
	public String getPunishmentName() {
		return punishmentName;
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
	/**
	 * 设置：注册号
	 */
	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}
	/**
	 * 获取：注册号
	 */
	public String getRegNum() {
		return regNum;
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
	 * 设置：发布日期
	 */
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	/**
	 * 获取：发布日期
	 */
	public String getPublishDate() {
		return publishDate;
	}
	/**
	 * 设置：地点
	 */
	public void setBase(String base) {
		this.base = base;
	}
	/**
	 * 获取：地点
	 */
	public String getBase() {
		return base;
	}
	/**
	 * 设置：法人
	 */
	public void setLegalPersonName(String legalPersonName) {
		this.legalPersonName = legalPersonName;
	}
	/**
	 * 获取：法人
	 */
	public String getLegalPersonName() {
		return legalPersonName;
	}
}
