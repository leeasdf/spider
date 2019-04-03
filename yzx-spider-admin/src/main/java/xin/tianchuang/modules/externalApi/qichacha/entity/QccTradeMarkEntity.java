package xin.tianchuang.modules.externalApi.qichacha.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import xin.tianchuang.modules.externalApi.qichacha.meta.ResultObj;

import java.io.Serializable;
import java.util.Date;

/**
 * 企查查-商标查询表
 * 
 * @author hui.deng
 * @email 
 * @date 2018-12-21 14:29:10
 */
@TableName("qcc_trade_mark")
public class QccTradeMarkEntity implements Serializable {
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
	 * 注册号
	 */
	@JSONField(name="RegNo")
	private String regNo;
	/**
	 * 商标名
	 */
	@JSONField(name="Name")
	private String name;
	/**
	 * 类别号
	 */
	@JSONField(name="CategoryId")
	private Integer categoryId;
	/**
	 * 类别
	 */
	@JSONField(name="Category")
	private String category;
	/**
	 * 申请人
	 */
	@JSONField(name="Person")
	private String person;
	/**
	 * 是否有图片
	 */
	private Integer hasImage;
	/**
	 * 商标续展
	 */
	private String flow;
	/**
	 * 图片地址
	 */
	private String imageUrl;
	/**
	 * 流程状态代码
	 */
	private String flowStatus;
	/**
	 * 流程状态描述
	 */
	private String flowStatusDesc;
	/**
	 * 申请日期
	 */
	@JSONField(name="AppDate",format="yyyy-MM-dd HH:mm:ss")
	private String appDate;
	/**
	 * 商标状态
	 */
	private String status;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 版本号
	 */
	@JSONField(name="VersionNo")
	private String version;
	/**
	 * 数据状态
	 */
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
	 * 设置：注册号
	 */
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	/**
	 * 获取：注册号
	 */
	public String getRegNo() {
		return regNo;
	}
	/**
	 * 设置：商标名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：商标名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：类别号
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * 获取：类别号
	 */
	public Integer getCategoryId() {
		return categoryId;
	}
	/**
	 * 设置：类别
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * 获取：类别
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * 设置：申请人
	 */
	public void setPerson(String person) {
		this.person = person;
	}
	/**
	 * 获取：申请人
	 */
	public String getPerson() {
		return person;
	}
	/**
	 * 设置：是否有图片
	 */
	public void setHasImage(Integer hasImage) {
		this.hasImage = hasImage;
	}
	/**
	 * 获取：是否有图片
	 */
	public Integer getHasImage() {
		return hasImage;
	}
	/**
	 * 设置：商标续展
	 */
	public void setFlow(String flow) {
		this.flow = flow;
	}
	/**
	 * 获取：商标续展
	 */
	public String getFlow() {
		return flow;
	}
	/**
	 * 设置：图片地址
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	/**
	 * 获取：图片地址
	 */
	public String getImageUrl() {
		return imageUrl;
	}
	/**
	 * 设置：流程状态代码
	 */
	public void setFlowStatus(String flowStatus) {
		this.flowStatus = flowStatus;
	}
	/**
	 * 获取：流程状态代码
	 */
	public String getFlowStatus() {
		return flowStatus;
	}
	/**
	 * 设置：流程状态描述
	 */
	public void setFlowStatusDesc(String flowStatusDesc) {
		this.flowStatusDesc = flowStatusDesc;
	}
	/**
	 * 获取：流程状态描述
	 */
	public String getFlowStatusDesc() {
		return flowStatusDesc;
	}
	/**
	 * 设置：申请日期
	 */
	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}
	/**
	 * 获取：申请日期
	 */
	public String getAppDate() {
		return appDate;
	}
	/**
	 * 设置：商标状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：商标状态
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
	 * 设置：版本号
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * 获取：版本号
	 */
	public String getVersion() {
		return version;
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

	public String getEntName() {
		return entName;
	}

	public void setEntName(String entName) {
		this.entName = entName;
	}

	public String getCreditCode() {
		return creditCode;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}
}
