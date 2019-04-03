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
 * 湖南省地方税务局-税务登记信息信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-12-25 09:04:52
 */
@TableName("hnds_tax_info")
public class HndsTaxInfoEntity implements Serializable {
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
	 * 统一社会信用代码/纳税人识别号
	 */
	private String taxNo;
	/**
	 * 纳税人名称
	 */
	private String taxper;
	/**
	 * 法定代表人
	 */
	private String legalName;
	/**
	 * 主管税务机关
	 */
	private String authority;
	/**
	 * 纳税人状态
	 */
	private String taxStatus;
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
	 * 设置：统一社会信用代码/纳税人识别号
	 */
	public void setTaxNo(String taxNo) {
		this.taxNo = taxNo;
	}

	/**
	 * 获取：统一社会信用代码/纳税人识别号
	 */
	public String getTaxNo() {
		return taxNo;
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
	 * 设置：法定代表人
	 */
	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	/**
	 * 获取：法定代表人
	 */
	public String getLegalName() {
		return legalName;
	}

	/**
	 * 设置：主管税务机关
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}

	/**
	 * 获取：主管税务机关
	 */
	public String getAuthority() {
		return authority;
	}

	/**
	 * 设置：纳税人状态
	 */
	public void setTaxStatus(String taxStatus) {
		this.taxStatus = taxStatus;
	}

	/**
	 * 获取：纳税人状态
	 */
	public String getTaxStatus() {
		return taxStatus;
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
