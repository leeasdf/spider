package xin.tianchuang.modules.api.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;
import java.util.Date;

/**
 * api菜单表
 * 
 * @author hui.deng
 * @email
 * @date 2018-10-17 16:25:41
 */
@TableName("sys_api_menu")
public class SysApiMenuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * API接口ID
	 */
	@TableId
	private Integer apiId;
	/**
	 * api访问地址
	 */
	private String apiUrl;
	/**
	 * api接口描述
	 */
	private String apiDesc;
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

	/**
	 * 设置：API接口ID
	 */
	public void setApiId(Integer apiId) {
		this.apiId = apiId;
	}

	/**
	 * 获取：API接口ID
	 */
	public Integer getApiId() {
		return apiId;
	}

	/**
	 * 设置：api访问地址
	 */
	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	/**
	 * 获取：api访问地址
	 */
	public String getApiUrl() {
		return apiUrl;
	}

	/**
	 * 设置：api接口描述
	 */
	public void setApiDesc(String apiDesc) {
		this.apiDesc = apiDesc;
	}

	/**
	 * 获取：api接口描述
	 */
	public String getApiDesc() {
		return apiDesc;
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
}
