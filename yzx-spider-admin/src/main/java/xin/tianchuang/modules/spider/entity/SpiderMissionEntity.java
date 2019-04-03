package xin.tianchuang.modules.spider.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

/**
 * 爬虫任务
 * 
 * @author hui.deng
 * @email 
 * @date 2018-10-17 17:04:27
 */
@TableName("spider_mission")
public class SpiderMissionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Long id;
	/**
	 * 爬虫名称
	 */
	private String spiderMissionName;
	/**
	 * 是否可用
	 */
	private Integer ifAvailable;
	/**
	 * 重试次数
	 */
	private Integer retryTimes;

	/**
	 * 爬取对象首页网址
	 */
	private String indexUrl;
	/**
	 * bean名称
	 */
	private String beanName;
	/**
	 * 方法名
	 */
	private String methodName;
	/**
	 * 备注
	 */
	private String note;
	/**
	 * 数据状态
	 */
	@TableField(value = "data_state", fill = FieldFill.INSERT)
	private Integer dataState;
	/**
	 * 最后修改时间
	 */
	 @TableField(value = "update_time", fill = FieldFill.UPDATE)
	private Date updateTime;
	/**
	 * 创建时间
	 */
	 @TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;
	/**
	 * 更新者
	 */
	private Long updater;
	/**
	 * 创建者
	 */
	private Long creator;

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
	 * 设置：爬虫名称
	 */
	public void setSpiderMissionName(String spiderMissionName) {
		this.spiderMissionName = spiderMissionName;
	}
	/**
	 * 获取：爬虫名称
	 */
	public String getSpiderMissionName() {
		return spiderMissionName;
	}
	/**
	 * 设置：是否可用
	 */
	public void setIfAvailable(Integer ifAvailable) {
		this.ifAvailable = ifAvailable;
	}
	/**
	 * 获取：是否可用
	 */
	public Integer getIfAvailable() {
		return ifAvailable;
	}
	/**
	 * 设置：爬取对象首页网址
	 */
	public void setIndexUrl(String indexUrl) {
		this.indexUrl = indexUrl;
	}
	/**
	 * 获取：爬取对象首页网址
	 */
	public String getIndexUrl() {
		return indexUrl;
	}
	/**
	 * 设置：bean名称
	 */
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	/**
	 * 获取：bean名称
	 */
	public String getBeanName() {
		return beanName;
	}
	/**
	 * 设置：方法名
	 */
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	/**
	 * 获取：方法名
	 */
	public String getMethodName() {
		return methodName;
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
	 * 设置：数据状态
	 */
	public void setDataState(Integer dataState) {
		this.dataState = dataState;
	}
	/**
	 * 获取：数据状态
	 */
	public Integer getDataState() {
		return dataState;
	}
	/**
	 * 设置：最后修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：最后修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
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
	 * 设置：更新者
	 */
	public void setUpdater(Long updater) {
		this.updater = updater;
	}
	/**
	 * 获取：更新者
	 */
	public Long getUpdater() {
		return updater;
	}
	/**
	 * 设置：创建者
	 */
	public void setCreator(Long creator) {
		this.creator = creator;
	}
	/**
	 * 获取：创建者
	 */
	public Long getCreator() {
		return creator;
	}

	public Integer getRetryTimes() {
		return retryTimes;
	}

	public void setRetryTimes(Integer retryTimes) {
		this.retryTimes = retryTimes;
	}
}
