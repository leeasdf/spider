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
 * API日志表
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 10:14:18
 */
@TableName("api_log")
public class ApiLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 业务ID
	 */
	private String bizId;
	/**
	 * 请求信息
	 */
	private String reqInfo;
	/**
	 * 请求ID
	 */
	private String reqId;
	/**
	 * 通道类型
	 */
	private String channelType;
	/**
	 * 
	 */
	private String respInfo;
	/**
	 * 返回码
	 */
	private String respCode;
	/**
	 * 返回信息
	 */
	private String respMessage;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 创建时间
	 */
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;
	/**
	 * 更新时间
	 */
	@TableField(value = "update_time", fill = FieldFill.UPDATE)
	private Date updateTime;

	/**
	 * 设置：主键ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主键ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：业务ID
	 */
	public void setBizId(String bizId) {
		this.bizId = bizId;
	}
	/**
	 * 获取：业务ID
	 */
	public String getBizId() {
		return bizId;
	}
	/**
	 * 设置：请求信息
	 */
	public void setReqInfo(String reqInfo) {
		this.reqInfo = reqInfo;
	}
	/**
	 * 获取：请求信息
	 */
	public String getReqInfo() {
		return reqInfo;
	}
	/**
	 * 设置：请求ID
	 */
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}
	/**
	 * 获取：请求ID
	 */
	public String getReqId() {
		return reqId;
	}
	/**
	 * 设置：通道类型
	 */
	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}
	/**
	 * 获取：通道类型
	 */
	public String getChannelType() {
		return channelType;
	}
	/**
	 * 设置：
	 */
	public void setRespInfo(String respInfo) {
		this.respInfo = respInfo;
	}
	/**
	 * 获取：
	 */
	public String getRespInfo() {
		return respInfo;
	}
	/**
	 * 设置：返回码
	 */
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	/**
	 * 获取：返回码
	 */
	public String getRespCode() {
		return respCode;
	}
	/**
	 * 设置：返回信息
	 */
	public void setRespMessage(String respMessage) {
		this.respMessage = respMessage;
	}
	/**
	 * 获取：返回信息
	 */
	public String getRespMessage() {
		return respMessage;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public String getStatus() {
		return status;
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
}
