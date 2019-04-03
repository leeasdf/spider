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
 * tyc企业-竞品信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-12-04 14:24:45
 */
@TableName("rpt_tn_competitive")
public class RptTnCompetitiveEntity implements Serializable {
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
	 * 产品
	 */
	private String product;
	/**
	 * 地区
	 */
	private String area;
	/**
	 * 当前轮次
	 */
	private String turn;
	/**
	 * 行业
	 */
	private String industry;
	/**
	 * 业务
	 */
	private String business;
	/**
	 * 成立时间
	 */
	private String datetime;
	/**
	 * 估值
	 */
	private String price;
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
	 * 设置：产品
	 */
	public void setProduct(String product) {
		this.product = product;
	}

	/**
	 * 获取：产品
	 */
	public String getProduct() {
		return product;
	}

	/**
	 * 设置：地区
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * 获取：地区
	 */
	public String getArea() {
		return area;
	}

	/**
	 * 设置：当前轮次
	 */
	public void setTurn(String turn) {
		this.turn = turn;
	}

	/**
	 * 获取：当前轮次
	 */
	public String getTurn() {
		return turn;
	}

	/**
	 * 设置：行业
	 */
	public void setIndustry(String industry) {
		this.industry = industry;
	}

	/**
	 * 获取：行业
	 */
	public String getIndustry() {
		return industry;
	}

	/**
	 * 设置：业务
	 */
	public void setBusiness(String business) {
		this.business = business;
	}

	/**
	 * 获取：业务
	 */
	public String getBusiness() {
		return business;
	}

	/**
	 * 设置：成立时间
	 */
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	/**
	 * 获取：成立时间
	 */
	public String getDatetime() {
		return datetime;
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
