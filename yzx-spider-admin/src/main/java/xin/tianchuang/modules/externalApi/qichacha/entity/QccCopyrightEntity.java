package xin.tianchuang.modules.externalApi.qichacha.entity;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import xin.tianchuang.modules.externalApi.qichacha.meta.ResultObj;

import java.io.Serializable;
import java.util.Date;

/**
 * 企查查API-软件著作权
 * 
 * @author hui.deng
 * @email 
 * @date 2018-12-19 17:47:48
 */
@TableName("qcc_copyright")
public class QccCopyrightEntity implements ResultObj , Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Long id;
	/**
	 * 分类号
	 */
	@JSONField(name="Category")
	private String category;
	/**
	 * 发布日期
	 */
	@JSONField(name="PublishDate",format="yyyy-MM-dd HH:mm:ss")
	private Date publishDate;
	/**
	 * 版本号
	 */
	@JSONField(name="VersionNo")
	private Integer versionNo;
	/**
	 * 登记号
	 */
	@JSONField(name="RegisterNo")
	private String registerNo;
	/**
	 * 登记批准日期
	 */
	@JSONField(name="RegisterAperDate",format="yyyy-MM-dd HH:mm:ss")
	private Date registerAperDate;
	/**
	 * 软件全称
	 */
	@JSONField(name="Name")
	private String name;
	/**
	 * 软件简称
	 */
	@JSONField(name="ShortName")
	private String shortName;
	/**
	 * 软件著作权人
	 */
	@JSONField(name="Owner")
	private String owner;
	/**
	 * 关键字(公司名或keyNo)
	 */
	private String entName;
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

	private Integer version;
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
	 * 设置：分类号
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * 获取：分类号
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * 设置：发布日期
	 */
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	/**
	 * 获取：发布日期
	 */
	public Date getPublishDate() {
		return publishDate;
	}
	/**
	 * 设置：版本号
	 */
	public void setVersionNo(Integer versionNo) {
		this.versionNo = versionNo;
	}
	/**
	 * 获取：版本号
	 */
	public Integer getVersionNo() {
		return versionNo;
	}
	/**
	 * 设置：登记号
	 */

	public void setRegisterNo(String registerNo) {
		this.registerNo = registerNo;
	}
	/**
	 * 获取：登记号
	 */
	public String getRegisterNo() {
		return registerNo;
	}
	/**
	 * 设置：登记批准日期
	 */
	public void setRegisterAperDate(Date registerAperDate) {
		this.registerAperDate = registerAperDate;
	}
	/**
	 * 获取：登记批准日期
	 */
	public Date getRegisterAperDate() {
		return registerAperDate;
	}
	/**
	 * 设置：软件全称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：软件全称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：软件简称
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	/**
	 * 获取：软件简称
	 */
	public String getShortName() {
		return shortName;
	}
	/**
	 * 设置：软件著作权人
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	/**
	 * 获取：软件著作权人
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * 设置：关键字(公司名或keyNo)
	 */
	public void setEntName(String entName) {
		this.entName = entName;
	}
	/**
	 * 获取：关键字(公司名或keyNo)
	 */
	public String getEntName() {
		return entName;
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
	public void setVersion(Integer version) {
		this.version = version;
	}
	/**
	 * 获取：版本号
	 */
	public Integer getVersion() {
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


	@Override
	public QccCopyrightEntity getEntity(String data) {
		return JSONObject.parseObject(data,this.getClass());
	}
}
