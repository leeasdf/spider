package xin.tianchuang.modules.externalApi.qichacha.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 企查查接口数据-企业关键字精确获取详细信息(Full)-基本信息
 * 
 * @author jiyang.hu
 * @email 
 * @date 2019-01-04 14:26:54
 */
@TableName("qcc_basic")
public class QccBasicEntity implements Serializable {
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
	 * 注册号
	 */
	private String no;
	/**
	 * 登记机关
	 */
	private String belongOrg;
	/**
	 * 法人
	 */
	private String operName;
	/**
	 * 成功日期
	 */
	private String startDate;
	/**
	 * 吊销日期
	 */
	private String endDate;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 省份
	 */
	private String province;
	/**
	 * 更新日期
	 */
	private String updatedDate;
	/**
	 * 信用代码
	 */
	private String creditCode;
	/**
	 * 注册资本
	 */
	private String registCapi;
	/**
	 * 类型
	 */
	private String econKind;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 营业范围
	 */
	private String scope;
	/**
	 * 营业期限始
	 */
	private String termStart;
	/**
	 * 营业期限至
	 */
	private String teamEnd;
	/**
	 * 发照日期
	 */
	private String checkDate;
	/**
	 * 组织机构代码
	 */
	private String orgNo;
	/**
	 * 是否上市
	 */
	private String isOnStock;
	/**
	 * 证券号
	 */
	private String stockNumber;
	/**
	 * 证券类型
	 */
	private String stockType;
	/**
	 * Logo地址(由于是企查查的域名，一般情况下不暴露)
	 */
	private String imageUrl;
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
	 * 设置：注册号
	 */
	public void setNo(String no) {
		this.no = no;
	}
	/**
	 * 获取：注册号
	 */
	public String getNo() {
		return no;
	}
	/**
	 * 设置：登记机关
	 */
	public void setBelongOrg(String belongOrg) {
		this.belongOrg = belongOrg;
	}
	/**
	 * 获取：登记机关
	 */
	public String getBelongOrg() {
		return belongOrg;
	}
	/**
	 * 设置：法人
	 */
	public void setOperName(String operName) {
		this.operName = operName;
	}
	/**
	 * 获取：法人
	 */
	public String getOperName() {
		return operName;
	}
	/**
	 * 设置：成功日期
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * 获取：成功日期
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * 设置：吊销日期
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * 获取：吊销日期
	 */
	public String getEndDate() {
		return endDate;
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
	 * 设置：省份
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取：省份
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 设置：更新日期
	 */
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	/**
	 * 获取：更新日期
	 */
	public String getUpdatedDate() {
		return updatedDate;
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
	 * 设置：注册资本
	 */
	public void setRegistCapi(String registCapi) {
		this.registCapi = registCapi;
	}
	/**
	 * 获取：注册资本
	 */
	public String getRegistCapi() {
		return registCapi;
	}
	/**
	 * 设置：类型
	 */
	public void setEconKind(String econKind) {
		this.econKind = econKind;
	}
	/**
	 * 获取：类型
	 */
	public String getEconKind() {
		return econKind;
	}
	/**
	 * 设置：地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：营业范围
	 */
	public void setScope(String scope) {
		this.scope = scope;
	}
	/**
	 * 获取：营业范围
	 */
	public String getScope() {
		return scope;
	}
	/**
	 * 设置：营业期限始
	 */
	public void setTermStart(String termStart) {
		this.termStart = termStart;
	}
	/**
	 * 获取：营业期限始
	 */
	public String getTermStart() {
		return termStart;
	}
	/**
	 * 设置：营业期限至
	 */
	public void setTeamEnd(String teamEnd) {
		this.teamEnd = teamEnd;
	}
	/**
	 * 获取：营业期限至
	 */
	public String getTeamEnd() {
		return teamEnd;
	}
	/**
	 * 设置：发照日期
	 */
	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}
	/**
	 * 获取：发照日期
	 */
	public String getCheckDate() {
		return checkDate;
	}
	/**
	 * 设置：组织机构代码
	 */
	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}
	/**
	 * 获取：组织机构代码
	 */
	public String getOrgNo() {
		return orgNo;
	}
	/**
	 * 设置：是否上市
	 */
	public void setIsOnStock(String isOnStock) {
		this.isOnStock = isOnStock;
	}
	/**
	 * 获取：是否上市
	 */
	public String getIsOnStock() {
		return isOnStock;
	}
	/**
	 * 设置：证券号
	 */
	public void setStockNumber(String stockNumber) {
		this.stockNumber = stockNumber;
	}
	/**
	 * 获取：证券号
	 */
	public String getStockNumber() {
		return stockNumber;
	}
	/**
	 * 设置：证券类型
	 */
	public void setStockType(String stockType) {
		this.stockType = stockType;
	}
	/**
	 * 获取：证券类型
	 */
	public String getStockType() {
		return stockType;
	}
	/**
	 * 设置：Logo地址
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	/**
	 * 获取：Logo地址
	 */
	public String getImageUrl() {
		return imageUrl;
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
