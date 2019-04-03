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
 * 企业-孵化器信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:17
 */
@TableName("enterprise_incubator_room")
public class EnterpriseIncubatorRoomEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 企业ID
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long enterpriseId;
	/**
	 * 孵化器名称
	 */
	private String incubatorName;
	/**
	 * 企业名称
	 */
	private String enterpriseName;
	/**
	 * 楼栋房号
	 */
	private String buildingRoomNo;
	/**
	 * 面积
	 */
	private String enterpriseArea;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 创建时间
	 */
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createtime;

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
	 * 设置：孵化器名称
	 */
	public void setIncubatorName(String incubatorName) {
		this.incubatorName = incubatorName;
	}
	/**
	 * 获取：孵化器名称
	 */
	public String getIncubatorName() {
		return incubatorName;
	}
	/**
	 * 设置：企业名称
	 */
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	/**
	 * 获取：企业名称
	 */
	public String getEnterpriseName() {
		return enterpriseName;
	}
	/**
	 * 设置：楼栋房号
	 */
	public void setBuildingRoomNo(String buildingRoomNo) {
		this.buildingRoomNo = buildingRoomNo;
	}
	/**
	 * 获取：楼栋房号
	 */
	public String getBuildingRoomNo() {
		return buildingRoomNo;
	}
	/**
	 * 设置：面积
	 */
	public void setEnterpriseArea(String enterpriseArea) {
		this.enterpriseArea = enterpriseArea;
	}
	/**
	 * 获取：面积
	 */
	public String getEnterpriseArea() {
		return enterpriseArea;
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
	 * 设置：创建时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreatetime() {
		return createtime;
	}
}
