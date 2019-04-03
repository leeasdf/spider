package xin.tianchuang.modules.externalApi.qichacha.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 企查查接口调用日志
 * 
 * @author jiyang.hu
 * @email 
 * @date 2018-12-21 17:11:03
 */
@TableName("qichacha_api_log")
public class QichachaApiLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 接口名称
	 */
	private String name;
	/**
	 * 查询条件
	 */
	private String searchKey;
	/**
	 * 请求地址
	 */
	private String url;
	/**
	 * 返回数据
	 */
	private String rs;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 设置：id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：接口名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：接口名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：查询条件
	 */
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	/**
	 * 获取：查询条件
	 */
	public String getSearchKey() {
		return searchKey;
	}
	/**
	 * 设置：请求地址
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：请求地址
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：返回数据
	 */
	public void setRs(String rs) {
		this.rs = rs;
	}
	/**
	 * 获取：返回数据
	 */
	public String getRs() {
		return rs;
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
}
