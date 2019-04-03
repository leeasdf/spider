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
 * 失信人信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:21
 */
@TableName("rpt_tn_dishonest")
public class RptTnDishonestEntity implements Serializable {
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
	 * 
	 */
	private String regdate;
	/**
	 * 
	 */
	private String casecode;
	/**
	 * 
	 */
	private String courtname;
	/**
	 * 
	 */
	private String performance;
	/**
	 * 
	 */
	private String gistid;
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
	 * 
	 */
	private String date;
	/**
	 * 
	 */
	private String type;
	/**
	 * 执行法院结果
	 */
	private String result;
	/**
	 * 
	 */
	private String iname;
	/**
	 * 
	 */
	private String businessentity;
	/**
	 * 
	 */
	private String areaname;
	/**
	 * 
	 */
	private String cardnum;
	/**
	 * 
	 */
	private String publishdate;
	/**
	 * 
	 */
	private String gistunit;
	/**
	 * 
	 */
	private String duty;
	/**
	 * 
	 */
	private String disrupttypename;

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
	 * 设置：
	 */
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	/**
	 * 获取：
	 */
	public String getRegdate() {
		return regdate;
	}
	/**
	 * 设置：
	 */
	public void setCasecode(String casecode) {
		this.casecode = casecode;
	}
	/**
	 * 获取：
	 */
	public String getCasecode() {
		return casecode;
	}
	/**
	 * 设置：
	 */
	public void setCourtname(String courtname) {
		this.courtname = courtname;
	}
	/**
	 * 获取：
	 */
	public String getCourtname() {
		return courtname;
	}
	/**
	 * 设置：
	 */
	public void setPerformance(String performance) {
		this.performance = performance;
	}
	/**
	 * 获取：
	 */
	public String getPerformance() {
		return performance;
	}
	/**
	 * 设置：
	 */
	public void setGistid(String gistid) {
		this.gistid = gistid;
	}
	/**
	 * 获取：
	 */
	public String getGistid() {
		return gistid;
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
	 * 设置：
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * 获取：
	 */
	public String getDate() {
		return date;
	}
	/**
	 * 设置：
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：执行法院结果
	 */
	public void setResult(String result) {
		this.result = result;
	}
	/**
	 * 获取：执行法院结果
	 */
	public String getResult() {
		return result;
	}
	/**
	 * 设置：
	 */
	public void setIname(String iname) {
		this.iname = iname;
	}
	/**
	 * 获取：
	 */
	public String getIname() {
		return iname;
	}
	/**
	 * 设置：
	 */
	public void setBusinessentity(String businessentity) {
		this.businessentity = businessentity;
	}
	/**
	 * 获取：
	 */
	public String getBusinessentity() {
		return businessentity;
	}
	/**
	 * 设置：
	 */
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	/**
	 * 获取：
	 */
	public String getAreaname() {
		return areaname;
	}
	/**
	 * 设置：
	 */
	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}
	/**
	 * 获取：
	 */
	public String getCardnum() {
		return cardnum;
	}
	/**
	 * 设置：
	 */
	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}
	/**
	 * 获取：
	 */
	public String getPublishdate() {
		return publishdate;
	}
	/**
	 * 设置：
	 */
	public void setGistunit(String gistunit) {
		this.gistunit = gistunit;
	}
	/**
	 * 获取：
	 */
	public String getGistunit() {
		return gistunit;
	}
	/**
	 * 设置：
	 */
	public void setDuty(String duty) {
		this.duty = duty;
	}
	/**
	 * 获取：
	 */
	public String getDuty() {
		return duty;
	}
	/**
	 * 设置：
	 */
	public void setDisrupttypename(String disrupttypename) {
		this.disrupttypename = disrupttypename;
	}
	/**
	 * 获取：
	 */
	public String getDisrupttypename() {
		return disrupttypename;
	}
}
