package xin.tianchuang.modules.externalApi.qichacha.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 企查查接口数据-企业关键字精确获取详细信息(Full)-动产抵押
 * 
 * @author jiyang.hu
 * @email 
 * @date 2019-01-04 14:26:53
 */
@TableName("qcc_basic_m_pledge")
public class QccBasicMPledgeEntity implements Serializable {
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
	 * 登记编号
	 */
	private String registerNo;
	/**
	 * 登记时间
	 */
	private String registerDate;
	/**
	 * 公示时间
	 */
	private String publicDate;
	/**
	 * 登记机关
	 */
	private String registerOffice;
	/**
	 * 被担保债权数额
	 */
	private String debtSecuredAmount;
	/**
	 * 状态
	 */
	private String status;
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
	 * 设置：登记编号
	 */
	public void setRegisterNo(String registerNo) {
		this.registerNo = registerNo;
	}
	/**
	 * 获取：登记编号
	 */
	public String getRegisterNo() {
		return registerNo;
	}
	/**
	 * 设置：登记时间
	 */
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	/**
	 * 获取：登记时间
	 */
	public String getRegisterDate() {
		return registerDate;
	}
	/**
	 * 设置：公示时间
	 */
	public void setPublicDate(String publicDate) {
		this.publicDate = publicDate;
	}
	/**
	 * 获取：公示时间
	 */
	public String getPublicDate() {
		return publicDate;
	}
	/**
	 * 设置：登记机关
	 */
	public void setRegisterOffice(String registerOffice) {
		this.registerOffice = registerOffice;
	}
	/**
	 * 获取：登记机关
	 */
	public String getRegisterOffice() {
		return registerOffice;
	}
	/**
	 * 设置：被担保债权数额
	 */
	public void setDebtSecuredAmount(String debtSecuredAmount) {
		this.debtSecuredAmount = debtSecuredAmount;
	}
	/**
	 * 获取：被担保债权数额
	 */
	public String getDebtSecuredAmount() {
		return debtSecuredAmount;
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
