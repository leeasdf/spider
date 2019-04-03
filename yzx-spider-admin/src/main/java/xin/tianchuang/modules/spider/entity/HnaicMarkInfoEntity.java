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
 * 湖南省工商局-商标公告
 * 
 * @author hui.deng
 * @email
 * @date 2018-12-18 09:09:38
 */
@TableName("hnaic_mark_info")
public class HnaicMarkInfoEntity implements Serializable {
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
	 * 驰名商标ID
	 */
	private String markId;
	/**
	 * 商标类型
	 */
	private String markType;
	/**
	 * 商标名称
	 */
	private String markName;
	/**
	 * 商标通过号
	 */
	private String markPassNumb;
	/**
	 * 持有人
	 */
	private String blongToEnterprise;
	/**
	 * 核定商品/服务
	 */
	private String markToPro;
	/**
	 * 认定时间
	 */
	private String selectTime;
	/**
	 * 所在地
	 */
	private String enterpriseAddr;
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
	 * 设置：驰名商标ID
	 */
	public void setMarkId(String markId) {
		this.markId = markId;
	}

	/**
	 * 获取：驰名商标ID
	 */
	public String getMarkId() {
		return markId;
	}

	/**
	 * 设置：商标类型
	 */
	public void setMarkType(String markType) {
		this.markType = markType;
	}

	/**
	 * 获取：商标类型
	 */
	public String getMarkType() {
		return markType;
	}

	/**
	 * 设置：商标名称
	 */
	public void setMarkName(String markName) {
		this.markName = markName;
	}

	/**
	 * 获取：商标名称
	 */
	public String getMarkName() {
		return markName;
	}

	/**
	 * 设置：商标通过号
	 */
	public void setMarkPassNumb(String markPassNumb) {
		this.markPassNumb = markPassNumb;
	}

	/**
	 * 获取：商标通过号
	 */
	public String getMarkPassNumb() {
		return markPassNumb;
	}

	/**
	 * 设置：持有人
	 */
	public void setBlongToEnterprise(String blongToEnterprise) {
		this.blongToEnterprise = blongToEnterprise;
	}

	/**
	 * 获取：持有人
	 */
	public String getBlongToEnterprise() {
		return blongToEnterprise;
	}

	/**
	 * 设置：核定商品/服务
	 */
	public void setMarkToPro(String markToPro) {
		this.markToPro = markToPro;
	}

	/**
	 * 获取：核定商品/服务
	 */
	public String getMarkToPro() {
		return markToPro;
	}

	/**
	 * 设置：认定时间
	 */
	public void setSelectTime(String selectTime) {
		this.selectTime = selectTime;
	}

	/**
	 * 获取：认定时间
	 */
	public String getSelectTime() {
		return selectTime;
	}

	/**
	 * 设置：所在地
	 */
	public void setEnterpriseAddr(String enterpriseAddr) {
		this.enterpriseAddr = enterpriseAddr;
	}

	/**
	 * 获取：所在地
	 */
	public String getEnterpriseAddr() {
		return enterpriseAddr;
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
