package xin.tianchuang.modules.dataparser.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import xin.tianchuang.modules.dataparser.annotation.EntName;

import java.io.Serializable;
import java.util.Date;

/**
 * 信用中国-守信红名单
 * 
 * @author hui.deng
 * @email 
 * @date 2018-10-15 15:36:13
 */
@TableName("creditchina_honesty_tax")
public class CreditchinaHonestyTaxEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(type = IdType.ID_WORKER)
    @JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 序号
	 */
	private String no;
	/**
	 * 数据来源
	 */
	private String source;
	/**
	 * 数据类别
	 */
	private String type;
	/**
	 * 文件名
	 */
	private String fileName;
	/**
	 * 最新更新日期
	 */
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date lastUpdateTime;
	/**
	 * 纳税人名称
	 */
	@EntName
	private String taxName;
	/**
	 * 评价年度
	 */
	private String year;

	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;
	/**
	 * 更新时间
	 */
	@TableField(fill = FieldFill.UPDATE)
	private Date updateTime;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 数据状态
	 */
	@TableField(fill = FieldFill.INSERT)
	private Integer dataStatus;

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
	 * 设置：序号
	 */
	public void setNo(String no) {
		this.no = no;
	}
	/**
	 * 获取：序号
	 */
	public String getNo() {
		return no;
	}
	/**
	 * 设置：数据来源
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * 获取：数据来源
	 */
	public String getSource() {
		return source;
	}
	/**
	 * 设置：数据类别
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：数据类别
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：文件名
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * 获取：文件名
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * 设置：最新更新日期
	 */
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	/**
	 * 获取：最新更新日期
	 */
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	/**
	 * 设置：纳税人名称
	 */
	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}
	/**
	 * 获取：纳税人名称
	 */
	public String getTaxName() {
		return taxName;
	}
	/**
	 * 设置：评价年度
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * 获取：评价年度
	 */
	public String getYear() {
		return year;
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
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：数据状态
	 */
	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}
	/**
	 * 获取：数据状态
	 */
	public Integer getDataStatus() {
		return dataStatus;
	}
}
