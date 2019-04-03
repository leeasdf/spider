package xin.tianchuang.modules.spider.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 信用麓谷-企业不良信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:17
 */
@TableName("rpt_plitigation_info")
public class RptPlitigationInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 会员ID
	 */
	private Integer memId;
	/**
	 * 企业ID
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long enterpriseId;
	/**
	 * 裁判文书数量
	 */
	private Integer cpwsCount;
	/**
	 * 开庭公告数量
	 */
	private Integer ktggCount;
	/**
	 * 执行公告数量
	 */
	private Integer zxggCount;
	/**
	 * 失信公告数量
	 */
	private Integer sxggCount;
	/**
	 * 网贷黑名单数量
	 */
	private Integer wdhmdCount;
	/**
	 * 案件流程数量
	 */
	private Integer ajlcCount;

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
	 * 设置：会员ID
	 */
	public void setMemId(Integer memId) {
		this.memId = memId;
	}
	/**
	 * 获取：会员ID
	 */
	public Integer getMemId() {
		return memId;
	}
	/**
	 * 设置：企业ID
	 */
	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	/**
	 * 获取：企业ID
	 */
	public Long getEnterpriseId() {
		return enterpriseId;
	}
	/**
	 * 设置：裁判文书数量
	 */
	public void setCpwsCount(Integer cpwsCount) {
		this.cpwsCount = cpwsCount;
	}
	/**
	 * 获取：裁判文书数量
	 */
	public Integer getCpwsCount() {
		return cpwsCount;
	}
	/**
	 * 设置：开庭公告数量
	 */
	public void setKtggCount(Integer ktggCount) {
		this.ktggCount = ktggCount;
	}
	/**
	 * 获取：开庭公告数量
	 */
	public Integer getKtggCount() {
		return ktggCount;
	}
	/**
	 * 设置：执行公告数量
	 */
	public void setZxggCount(Integer zxggCount) {
		this.zxggCount = zxggCount;
	}
	/**
	 * 获取：执行公告数量
	 */
	public Integer getZxggCount() {
		return zxggCount;
	}
	/**
	 * 设置：失信公告数量
	 */
	public void setSxggCount(Integer sxggCount) {
		this.sxggCount = sxggCount;
	}
	/**
	 * 获取：失信公告数量
	 */
	public Integer getSxggCount() {
		return sxggCount;
	}
	/**
	 * 设置：网贷黑名单数量
	 */
	public void setWdhmdCount(Integer wdhmdCount) {
		this.wdhmdCount = wdhmdCount;
	}
	/**
	 * 获取：网贷黑名单数量
	 */
	public Integer getWdhmdCount() {
		return wdhmdCount;
	}
	/**
	 * 设置：案件流程数量
	 */
	public void setAjlcCount(Integer ajlcCount) {
		this.ajlcCount = ajlcCount;
	}
	/**
	 * 获取：案件流程数量
	 */
	public Integer getAjlcCount() {
		return ajlcCount;
	}
}
