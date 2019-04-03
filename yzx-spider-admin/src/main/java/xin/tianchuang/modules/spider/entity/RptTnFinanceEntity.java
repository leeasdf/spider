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
 * tyc企业-融资历史
 * 
 * @author hui.deng
 * @email
 * @date 2018-12-04 14:24:47
 */
@TableName("rpt_tn_finance")
public class RptTnFinanceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 主键
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long enterpriseId;
	/**
	 * 企业名称
	 */
	private String entName;
	/**
	 * 时间
	 */
	private String date;
	/**
	 * 轮次
	 */
	private String time;
	/**
	 * 估值
	 */
	private String price;
	/**
	 * 金额
	 */
	private String amount;
	/**
	 * 比例
	 */
	private String perice;
	/**
	 * 投资方
	 */
	private String company;
	/**
	 * 新闻来源
	 */
	private String news;
	/**
	 * 新闻URL
	 */
	private String newsurl;
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
	 * 设置：主键
	 */
	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	/**
	 * 获取：主键
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
	 * 设置：时间
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * 获取：时间
	 */
	public String getDate() {
		return date;
	}

	/**
	 * 设置：轮次
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * 获取：轮次
	 */
	public String getTime() {
		return time;
	}

	/**
	 * 设置：估值
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * 获取：估值
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * 设置：金额
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * 获取：金额
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * 设置：比例
	 */
	public void setPerice(String perice) {
		this.perice = perice;
	}

	/**
	 * 获取：比例
	 */
	public String getPerice() {
		return perice;
	}

	/**
	 * 设置：投资方
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * 获取：投资方
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * 设置：新闻来源
	 */
	public void setNews(String news) {
		this.news = news;
	}

	/**
	 * 获取：新闻来源
	 */
	public String getNews() {
		return news;
	}

	/**
	 * 设置：新闻URL
	 */
	public void setNewsurl(String newsurl) {
		this.newsurl = newsurl;
	}

	/**
	 * 获取：新闻URL
	 */
	public String getNewsurl() {
		return newsurl;
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
