package xin.tianchuang.modules.spider.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

/**
 * 
 * 
 * @author hui.deng
 * @email 
 * @date 2018-10-24 14:37:23
 */
@TableName("sys_exception_log")
public class SysExceptionLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 异常类型
	 */
	private Integer type;
	/**
	 * 
	 */
	private String method;
	/**
	 * 异常栈
	 */
	private String stack;
	/**
	 * 创建时间
	 */
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setMethod(String method) {
		this.method = method;
	}
	/**
	 * 获取：
	 */
	public String getMethod() {
		return method;
	}
	/**
	 * 设置：异常栈
	 */
	public void setStack(String stack) {
		this.stack = stack;
	}
	/**
	 * 获取：异常栈
	 */
	public String getStack() {
		return stack;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
