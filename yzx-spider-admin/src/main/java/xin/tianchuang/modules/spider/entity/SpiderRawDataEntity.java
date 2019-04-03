package xin.tianchuang.modules.spider.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;
import java.util.Date;

/**
 * 从页面爬取的数据，内容格式可能是html、js、json
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-29 16:51:37
 */
@TableName("spider_raw_data")
public class SpiderRawDataEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Long id;
	/**
	 * 企业名称
	 */
	private String entName;
	/**
	 * 信用代码
	 */
	private String creditCode;
	/**
	 * 数据类型
	 */
	private Integer type;
	/**
	 * 数据类型描述
	 */
	private String typeDesc;
	/**
	 * 链接地址
	 */
	private String url;
	/**
	 * 爬取的文本内容
	 */
	private String content;
	/**
	 * 游标（记录点，可以是时间、id等等）
	 */
	private String cursorIndex;
	/**
	 * 是否已被解析
	 */
	private Integer ifAnalysised;
	/**
	 * 数据状态（0：正常 1：更新 2：删除）
	 */
	@TableField(value = "data_state", fill = FieldFill.INSERT)
	private Integer dataState;
	/**
	 * 最后修改时间
	 */
	@TableField(value = "update_time", fill = FieldFill.UPDATE)
	private Date updateTime;
	/**
	 * 创建时间
	 */
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;
	/**
	 * 更新者
	 */
	private Long updater;
	/**
	 * 创建者
	 */
	private Long creator;

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
	 * 设置：企业名称
	 */
	public void setEntName(String entName) {
		this.entName = entName;
	}

	/**
	 * 获取：企业名称
	 */
	public String getEntName() {
		return entName;
	}

	/**
	 * 设置：信用代码
	 */
	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

	/**
	 * 获取：信用代码
	 */
	public String getCreditCode() {
		return creditCode;
	}

	/**
	 * 设置：数据类型
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 获取：数据类型
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * 设置：数据类型描述
	 */
	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}

	/**
	 * 获取：数据类型描述
	 */
	public String getTypeDesc() {
		return typeDesc;
	}

	/**
	 * 设置：链接地址
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 获取：链接地址
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 设置：爬取的文本内容
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 获取：爬取的文本内容
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 设置：是否已被解析
	 */
	public void setIfAnalysised(Integer ifAnalysised) {
		this.ifAnalysised = ifAnalysised;
	}

	/**
	 * 获取：是否已被解析
	 */
	public Integer getIfAnalysised() {
		return ifAnalysised;
	}

	/**
	 * 设置：数据状态（0：正常 1：更新 2：删除）
	 */
	public void setDataState(Integer dataState) {
		this.dataState = dataState;
	}

	/**
	 * 获取：数据状态（0：正常 1：更新 2：删除）
	 */
	public Integer getDataState() {
		return dataState;
	}

	/**
	 * 设置：最后修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 获取：最后修改时间
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
	 * 设置：更新者
	 */
	public void setUpdater(Long updater) {
		this.updater = updater;
	}

	/**
	 * 获取：更新者
	 */
	public Long getUpdater() {
		return updater;
	}

	/**
	 * 设置：创建者
	 */
	public void setCreator(Long creator) {
		this.creator = creator;
	}

	/**
	 * 获取：创建者
	 */
	public Long getCreator() {
		return creator;
	}

	public String getCursorIndex() {
		return cursorIndex;
	}

	public void setCursorIndex(String cursorIndex) {
		this.cursorIndex = cursorIndex;
	}
}
