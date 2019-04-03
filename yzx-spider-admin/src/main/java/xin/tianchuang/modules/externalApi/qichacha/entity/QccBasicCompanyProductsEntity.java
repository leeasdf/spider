package xin.tianchuang.modules.externalApi.qichacha.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 企查查接口数据-企业关键字精确获取详细信息(Full)-公司产品
 * 
 * @author jiyang.hu
 * @email 
 * @date 2019-01-04 14:26:53
 */
@TableName("qcc_basic_company_products")
public class QccBasicCompanyProductsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 公司名称
	 */
	private String entName;
	/**
	 * 信用代码
	 */
	private String creditCode;
	/**
	 * 企业的关联链接
	 */
	private String link;
	/**
	 * 产品的图片
	 */
	private String imageUrl;
	/**
	 * 产品名称
	 */
	private String name;
	/**
	 * 产品领域
	 */
	private String domain;
	/**
	 * 产品标签
	 */
	private String tags;
	/**
	 * 产品描述
	 */
	private String description;
	/**
	 * 产品类型
	 */
	private String category;
	/**
	 * 数据状态
	 */
	private Integer dataStatus;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private String creator;
	/**
	 * 
	 */
	private Date updateTime;
	/**
	 * 
	 */
	private String updater;

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
	 * 设置：公司名称
	 */
	public void setEntName(String entName) {
		this.entName = entName;
	}
	/**
	 * 获取：公司名称
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
	 * 设置：企业的关联链接
	 */
	public void setLink(String link) {
		this.link = link;
	}
	/**
	 * 获取：企业的关联链接
	 */
	public String getLink() {
		return link;
	}
	/**
	 * 设置：产品的图片
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	/**
	 * 获取：产品的图片
	 */
	public String getImageUrl() {
		return imageUrl;
	}
	/**
	 * 设置：产品名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：产品名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：产品领域
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}
	/**
	 * 获取：产品领域
	 */
	public String getDomain() {
		return domain;
	}
	/**
	 * 设置：产品标签
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}
	/**
	 * 获取：产品标签
	 */
	public String getTags() {
		return tags;
	}
	/**
	 * 设置：产品描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：产品描述
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置：产品类型
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * 获取：产品类型
	 */
	public String getCategory() {
		return category;
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
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}
	/**
	 * 获取：
	 */
	public String getCreator() {
		return creator;
	}
	/**
	 * 设置：
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：
	 */
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	/**
	 * 获取：
	 */
	public String getUpdater() {
		return updater;
	}
}
