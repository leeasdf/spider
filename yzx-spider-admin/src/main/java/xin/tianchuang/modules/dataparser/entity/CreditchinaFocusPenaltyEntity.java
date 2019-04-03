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
 * 信用中国-重点关注名单-证监会
 * 
 * @author hui.deng
 * @email 
 * @date 2018-10-16 14:58:55
 */
@TableName("creditchina_focus_penalty")
public class CreditchinaFocusPenaltyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(type = IdType.ID_WORKER)
    @JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 处罚处理日期
	 */
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date punishmentDate;
	/**
	 * 处罚对象名称
	 */
	private String punishmentObject;
	/**
	 * 实际处罚部门
	 */
	private String punishmentDepart;
	/**
	 * 处罚机关
	 */
	private String punishmentOrgan;
	/**
	 * 数据类别
	 */
	private String type;
	/**
	 * 处罚处理名称
	 */
	@EntName
	private String punishmentName;
	/**
	 * 最新更新日期
	 */
	private Date lastUpdateTime;
	/**
	 * 处罚决定书ID
	 */
	private String penaltyDecision;
	/**
	 * 数据来源
	 */
	private String source;
	/**
	 * 信息类型
	 */
	private String informationType;
	/**
	 * 处罚处理内容
	 */
	private String punishmentContent;
	/**
	 * 处罚处理种类
	 */
	private String punishmentType;
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
	 * 设置：处罚处理日期
	 */
	public void setPunishmentDate(Date punishmentDate) {
		this.punishmentDate = punishmentDate;
	}
	/**
	 * 获取：处罚处理日期
	 */
	public Date getPunishmentDate() {
		return punishmentDate;
	}
	/**
	 * 设置：处罚对象名称
	 */
	public void setPunishmentObject(String punishmentObject) {
		this.punishmentObject = punishmentObject;
	}
	/**
	 * 获取：处罚对象名称
	 */
	public String getPunishmentObject() {
		return punishmentObject;
	}
	/**
	 * 设置：实际处罚部门
	 */
	public void setPunishmentDepart(String punishmentDepart) {
		this.punishmentDepart = punishmentDepart;
	}
	/**
	 * 获取：实际处罚部门
	 */
	public String getPunishmentDepart() {
		return punishmentDepart;
	}
	/**
	 * 设置：处罚机关
	 */
	public void setPunishmentOrgan(String punishmentOrgan) {
		this.punishmentOrgan = punishmentOrgan;
	}
	/**
	 * 获取：处罚机关
	 */
	public String getPunishmentOrgan() {
		return punishmentOrgan;
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
	 * 设置：处罚处理名称
	 */
	public void setPunishmentName(String punishmentName) {
		this.punishmentName = punishmentName;
	}
	/**
	 * 获取：处罚处理名称
	 */
	public String getPunishmentName() {
		return punishmentName;
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
	 * 设置：处罚决定书ID
	 */
	public void setPenaltyDecision(String penaltyDecision) {
		this.penaltyDecision = penaltyDecision;
	}
	/**
	 * 获取：处罚决定书ID
	 */
	public String getPenaltyDecision() {
		return penaltyDecision;
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
	 * 设置：信息类型
	 */
	public void setInformationType(String informationType) {
		this.informationType = informationType;
	}
	/**
	 * 获取：信息类型
	 */
	public String getInformationType() {
		return informationType;
	}
	/**
	 * 设置：处罚处理内容
	 */
	public void setPunishmentContent(String punishmentContent) {
		this.punishmentContent = punishmentContent;
	}
	/**
	 * 获取：处罚处理内容
	 */
	public String getPunishmentContent() {
		return punishmentContent;
	}
	/**
	 * 设置：处罚处理种类
	 */
	public void setPunishmentType(String punishmentType) {
		this.punishmentType = punishmentType;
	}
	/**
	 * 获取：处罚处理种类
	 */
	public String getPunishmentType() {
		return punishmentType;
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
