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
 * 作品著作权信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:20
 */
@TableName("rpt_tn_works_right")
public class RptTnWorksRightEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 企业主键
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long enterpriseId;
	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 企业名称
	 */
	private String entName;
	/**
	 * 作品名称
	 */
	private String title;
	/**
	 * 登记号
	 */
	private String regnum;
	/**
	 * 类别
	 */
	private String category;
	/**
	 * 创作完成日期
	 */
	private String finishDate;
	/**
	 * 登记日期
	 */
	private String regtime;
	/**
	 * 首次发布日期
	 */
	private String publishtime;
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
	 * 设置：作品名称
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：作品名称
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：登记号
	 */
	public void setRegnum(String regnum) {
		this.regnum = regnum;
	}
	/**
	 * 获取：登记号
	 */
	public String getRegnum() {
		return regnum;
	}
	/**
	 * 设置：类别
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * 获取：类别
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * 设置：创作完成日期
	 */
	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}
	/**
	 * 获取：创作完成日期
	 */
	public String getFinishDate() {
		return finishDate;
	}
	/**
	 * 设置：登记日期
	 */
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	/**
	 * 获取：登记日期
	 */
	public String getRegtime() {
		return regtime;
	}
	/**
	 * 设置：首次发布日期
	 */
	public void setPublishtime(String publishtime) {
		this.publishtime = publishtime;
	}
	/**
	 * 获取：首次发布日期
	 */
	public String getPublishtime() {
		return publishtime;
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
