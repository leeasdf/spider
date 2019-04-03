package xin.tianchuang.modules.api.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 用户平台token表
 * 
 * @author hui.deng
 * @email 
 * @date 2018-10-16 16:44:35
 */
@TableName("sys_user_api_token")
public class SysUserApiTokenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.INPUT)
	private Long userId;

	/**
	 * 用户名称,显示用
	 */
	@TableField(exist = false)
	private String username;
	/**
	 * 应用id
	 */
	private String appId;
	/**
	 * 应用名称
	 */
	private String appName;
	/**
	 * token
	 */
	private String token;
	/**
	 * 过期时间
	 */
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	private Date expireTime;
	/**
	 * 更新时间
	 */
	@TableField(value = "update_time", fill = FieldFill.UPDATE)
	private Date updateTime;
	/**
	 * 更新时间
	 */
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;
	/**
	 * 
	 */
	private Integer status;

	@TableField(exist=false)
	private List<Long> apiIdList;


	public List<Long> getApiIdList() {
		return apiIdList;
	}

	public void setApiIdList(List<Long> apiIdList) {
		this.apiIdList = apiIdList;
	}

	/**
	 * 设置：
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：应用id
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}
	/**
	 * 获取：应用id
	 */
	public String getAppId() {
		return appId;
	}
	/**
	 * 设置：应用名称
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}
	/**
	 * 获取：应用名称
	 */
	public String getAppName() {
		return appName;
	}
	/**
	 * 设置：token
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * 获取：token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * 设置：过期时间
	 */
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	/**
	 * 获取：过期时间
	 */
	public Date getExpireTime() {
		return expireTime;
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
	 * 设置：更新时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 获取：
	 */

	public Integer getStatus() {
		return status;
	}

}
