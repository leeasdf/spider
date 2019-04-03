package xin.tianchuang.modules.api.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 应用接口对照表
 * 
 * @author hui.deng
 * @email
 * @date 2018-10-17 16:25:42
 */
@TableName("sys_app_api")
public class SysAppApiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private Long id;
	/**
	 * 应用id
	 */
	private String appId;
	/**
	 * 接口id
	 */
	private Long apiId;
	/**
	 * 更新时间
	 */
	@TableField(value = "update_time", fill = FieldFill.UPDATE)
	private Date updateTime;
	/**
	 * 创建时间
	 */
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;
	/**
	 * 状态
	 */
	private Integer status;

	@TableField(exist = false)
	private List<Long> apiIdList;

	/**
	 * 设置：ID
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取：ID
	 */
	public Long getId() {
		return id;
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
	 * 设置：接口id
	 */
	public void setApiId(Long apiId) {
		this.apiId = apiId;
	}

	/**
	 * 获取：接口id
	 */
	public Long getApiId() {
		return apiId;
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
	 * 设置：状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 获取：状态
	 */
	public Integer getStatus() {
		return status;
	}

	public List<Long> getApiIdList() {
		return apiIdList;
	}

	public void setApiIdList(List<Long> apiIdList) {
		this.apiIdList = apiIdList;
	}
}
