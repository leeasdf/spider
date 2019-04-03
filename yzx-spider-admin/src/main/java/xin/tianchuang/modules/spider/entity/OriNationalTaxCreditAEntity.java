package xin.tianchuang.modules.spider.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 年度纳税信用A级纳税人名单(导入)
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:23
 */
@TableName("ori_national_tax_credit_a")
public class OriNationalTaxCreditAEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 纳税人识别号
	 */
	private String taxNumber;
	/**
	 * 纳税人名称
	 */
	private String enterpriseName;
	/**
	 * 评价年度
	 */
	private String year;
	/**
	 * 主管税务机关
	 */
	private String taxAuthorities;

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
	 * 设置：纳税人识别号
	 */
	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}
	/**
	 * 获取：纳税人识别号
	 */
	public String getTaxNumber() {
		return taxNumber;
	}
	/**
	 * 设置：纳税人名称
	 */
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	/**
	 * 获取：纳税人名称
	 */
	public String getEnterpriseName() {
		return enterpriseName;
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
	 * 设置：主管税务机关
	 */
	public void setTaxAuthorities(String taxAuthorities) {
		this.taxAuthorities = taxAuthorities;
	}
	/**
	 * 获取：主管税务机关
	 */
	public String getTaxAuthorities() {
		return taxAuthorities;
	}
}
