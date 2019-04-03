package xin.tianchuang.modules.externalApi.qichacha.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 企查查接口数据-企业关键字精确获取详细信息(Full)-行业分类数据
 * 
 * @author jiyang.hu
 * @email 
 * @date 2019-01-04 14:26:52
 */
@TableName("qcc_basic_industry")
public class QccBasicIndustryEntity implements Serializable {
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
	 * 行业门类code
	 */
	private String industryCode;
	/**
	 * 行业门类描述
	 */
	private String industry;
	/**
	 * 行业大类code
	 */
	private String subIndustryCode;
	/**
	 * 行业大类描述
	 */
	private String subIndustry;
	/**
	 * 行业中类code
	 */
	private String middleCategoryCode;
	/**
	 * 行业中类描述
	 */
	private String middleCategory;
	/**
	 * 行业小类code
	 */
	private String smallCategoryCode;
	/**
	 * 行业小类描述
	 */
	private String smallCategory;
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
	 * 设置：行业门类code
	 */
	public void setIndustryCode(String industryCode) {
		this.industryCode = industryCode;
	}
	/**
	 * 获取：行业门类code
	 */
	public String getIndustryCode() {
		return industryCode;
	}
	/**
	 * 设置：行业门类描述
	 */
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	/**
	 * 获取：行业门类描述
	 */
	public String getIndustry() {
		return industry;
	}
	/**
	 * 设置：行业大类code
	 */
	public void setSubIndustryCode(String subIndustryCode) {
		this.subIndustryCode = subIndustryCode;
	}
	/**
	 * 获取：行业大类code
	 */
	public String getSubIndustryCode() {
		return subIndustryCode;
	}
	/**
	 * 设置：行业大类描述
	 */
	public void setSubIndustry(String subIndustry) {
		this.subIndustry = subIndustry;
	}
	/**
	 * 获取：行业大类描述
	 */
	public String getSubIndustry() {
		return subIndustry;
	}
	/**
	 * 设置：行业中类code
	 */
	public void setMiddleCategoryCode(String middleCategoryCode) {
		this.middleCategoryCode = middleCategoryCode;
	}
	/**
	 * 获取：行业中类code
	 */
	public String getMiddleCategoryCode() {
		return middleCategoryCode;
	}
	/**
	 * 设置：行业中类描述
	 */
	public void setMiddleCategory(String middleCategory) {
		this.middleCategory = middleCategory;
	}
	/**
	 * 获取：行业中类描述
	 */
	public String getMiddleCategory() {
		return middleCategory;
	}
	/**
	 * 设置：行业小类code
	 */
	public void setSmallCategoryCode(String smallCategoryCode) {
		this.smallCategoryCode = smallCategoryCode;
	}
	/**
	 * 获取：行业小类code
	 */
	public String getSmallCategoryCode() {
		return smallCategoryCode;
	}
	/**
	 * 设置：行业小类描述
	 */
	public void setSmallCategory(String smallCategory) {
		this.smallCategory = smallCategory;
	}
	/**
	 * 获取：行业小类描述
	 */
	public String getSmallCategory() {
		return smallCategory;
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
