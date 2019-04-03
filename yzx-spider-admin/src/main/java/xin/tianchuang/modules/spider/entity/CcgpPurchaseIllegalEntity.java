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
 * 中国政府采购网-采购严重违法失信行为记录
 * 
 * @author hui.deng
 * @email
 * @date 2018-12-21 14:10:47
 */
@TableName("ccgp_purchase_illegal")
public class CcgpPurchaseIllegalEntity implements Serializable {
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
	private Long enterpriseId;
	/**
	 * 企业名称
	 */
	private String entName;
	/**
	 * 统一社会信用代码（或）组织机构代码
	 */
	private String creditCode;
	/**
	 * 企业地址
	 */
	private String address;
	/**
	 * 严重违法失信行为的具体情形
	 */
	private String illegalDetail;
	/**
	 * 处罚结果
	 */
	private String punishResult;
	/**
	 * 处罚依据
	 */
	private String base;
	/**
	 * 处罚日期
	 */
	private String punishDate;
	/**
	 * 公布日期
	 */
	private String publishDate;
	/**
	 * 执法单位
	 */
	private String authority;
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
	 * 设置：统一社会信用代码（或）组织机构代码
	 */
	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

	/**
	 * 获取：统一社会信用代码（或）组织机构代码
	 */
	public String getCreditCode() {
		return creditCode;
	}

	/**
	 * 设置：企业地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 获取：企业地址
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 设置：严重违法失信行为的具体情形
	 */
	public void setIllegalDetail(String illegalDetail) {
		this.illegalDetail = illegalDetail;
	}

	/**
	 * 获取：严重违法失信行为的具体情形
	 */
	public String getIllegalDetail() {
		return illegalDetail;
	}

	/**
	 * 设置：处罚结果
	 */
	public void setPunishResult(String punishResult) {
		this.punishResult = punishResult;
	}

	/**
	 * 获取：处罚结果
	 */
	public String getPunishResult() {
		return punishResult;
	}

	/**
	 * 设置：处罚依据
	 */
	public void setBase(String base) {
		this.base = base;
	}

	/**
	 * 获取：处罚依据
	 */
	public String getBase() {
		return base;
	}

	/**
	 * 设置：处罚日期
	 */
	public void setPunishDate(String punishDate) {
		this.punishDate = punishDate;
	}

	/**
	 * 获取：处罚日期
	 */
	public String getPunishDate() {
		return punishDate;
	}

	/**
	 * 设置：公布日期
	 */
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	/**
	 * 获取：公布日期
	 */
	public String getPublishDate() {
		return publishDate;
	}

	/**
	 * 设置：执法单位
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}

	/**
	 * 获取：执法单位
	 */
	public String getAuthority() {
		return authority;
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
