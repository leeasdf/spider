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
 * 信用麓谷-专利信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:17
 */
@TableName("rpt_patents_info")
public class RptPatentsInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 会员主键
	 */
	private Integer memId;
	/**
	 * 企业ID
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long enterpriseId;
	/**
	 * 专利名称
	 */
	private String title;
	/**
	 * 专利类型
	 */
	private String type;
	/**
	 * 申请号
	 */
	private String patentNumber;
	/**
	 * 公布号
	 */
	private String pubNum;
	/**
	 * 申请时间
	 */
	private String applyDate;
	/**
	 * 发布日期
	 */
	private String pubDate;
	/**
	 * 
	 */
	private String summary;
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
	 * 设置：会员主键
	 */
	public void setMemId(Integer memId) {
		this.memId = memId;
	}
	/**
	 * 获取：会员主键
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
	 * 设置：专利名称
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：专利名称
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：专利类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：专利类型
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：申请号
	 */
	public void setPatentNumber(String patentNumber) {
		this.patentNumber = patentNumber;
	}
	/**
	 * 获取：申请号
	 */
	public String getPatentNumber() {
		return patentNumber;
	}
	/**
	 * 设置：公布号
	 */
	public void setPubNum(String pubNum) {
		this.pubNum = pubNum;
	}
	/**
	 * 获取：公布号
	 */
	public String getPubNum() {
		return pubNum;
	}
	/**
	 * 设置：申请时间
	 */
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	/**
	 * 获取：申请时间
	 */
	public String getApplyDate() {
		return applyDate;
	}
	/**
	 * 设置：发布日期
	 */
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	/**
	 * 获取：发布日期
	 */
	public String getPubDate() {
		return pubDate;
	}
	/**
	 * 设置：
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}
	/**
	 * 获取：
	 */
	public String getSummary() {
		return summary;
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
