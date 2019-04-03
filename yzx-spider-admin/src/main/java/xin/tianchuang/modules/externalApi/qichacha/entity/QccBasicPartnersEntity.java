package xin.tianchuang.modules.externalApi.qichacha.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 企查查接口数据-企业关键字精确获取详细信息(Full)-投资人及出资信息
 * 
 * @author jiyang.hu
 * @email 
 * @date 2019-01-04 14:26:52
 */
@TableName("qcc_basic_partners")
public class QccBasicPartnersEntity implements Serializable {
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
	 * 投资人
	 */
	private String stockName;
	/**
	 * 投资人类型
	 */
	private String stockType;
	/**
	 * 出资比例
	 */
	private String stockPercent;
	/**
	 * 认缴出资额
	 */
	private String shouldCapi;
	/**
	 * 认缴出资时间
	 */
	private String shoudDate;
	/**
	 * 认出资方式
	 */
	private String investType;
	/**
	 * 实出资方式
	 */
	private String investName;
	/**
	 * 实缴出资额
	 */
	private String realCapi;
	/**
	 * 实缴时间
	 */
	private String capiDate;
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
	 * 设置：投资人
	 */
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	/**
	 * 获取：投资人
	 */
	public String getStockName() {
		return stockName;
	}
	/**
	 * 设置：投资人类型
	 */
	public void setStockType(String stockType) {
		this.stockType = stockType;
	}
	/**
	 * 获取：投资人类型
	 */
	public String getStockType() {
		return stockType;
	}
	/**
	 * 设置：出资比例
	 */
	public void setStockPercent(String stockPercent) {
		this.stockPercent = stockPercent;
	}
	/**
	 * 获取：出资比例
	 */
	public String getStockPercent() {
		return stockPercent;
	}
	/**
	 * 设置：认缴出资额
	 */
	public void setShouldCapi(String shouldCapi) {
		this.shouldCapi = shouldCapi;
	}
	/**
	 * 获取：认缴出资额
	 */
	public String getShouldCapi() {
		return shouldCapi;
	}
	/**
	 * 设置：认缴出资时间
	 */
	public void setShoudDate(String shoudDate) {
		this.shoudDate = shoudDate;
	}
	/**
	 * 获取：认缴出资时间
	 */
	public String getShoudDate() {
		return shoudDate;
	}
	/**
	 * 设置：认出资方式
	 */
	public void setInvestType(String investType) {
		this.investType = investType;
	}
	/**
	 * 获取：认出资方式
	 */
	public String getInvestType() {
		return investType;
	}
	/**
	 * 设置：实出资方式
	 */
	public void setInvestName(String investName) {
		this.investName = investName;
	}
	/**
	 * 获取：实出资方式
	 */
	public String getInvestName() {
		return investName;
	}
	/**
	 * 设置：实缴出资额
	 */
	public void setRealCapi(String realCapi) {
		this.realCapi = realCapi;
	}
	/**
	 * 获取：实缴出资额
	 */
	public String getRealCapi() {
		return realCapi;
	}
	/**
	 * 设置：实缴时间
	 */
	public void setCapiDate(String capiDate) {
		this.capiDate = capiDate;
	}
	/**
	 * 获取：实缴时间
	 */
	public String getCapiDate() {
		return capiDate;
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
