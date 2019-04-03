package xin.tianchuang.modules.externalApi.qichacha.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 企查查接口数据-企业关键字精确获取详细信息(Full)-股权出质
 * 
 * @author jiyang.hu
 * @email 
 * @date 2019-01-04 14:26:53
 */
@TableName("qcc_basic_pledge")
public class QccBasicPledgeEntity implements Serializable {
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
	 * 质权登记编号
	 */
	private String registNo;
	/**
	 * 出质人
	 */
	private String pledgor;
	/**
	 * 出质人证照编号
	 */
	private String pledgorNo;
	/**
	 * 质权人
	 */
	private String pledgee;
	/**
	 * 质权人证照编号
	 */
	private String pledgeeNo;
	/**
	 * 出质股权数额
	 */
	private String pledgedAmount;
	/**
	 * 股权出质设立登记日期
	 */
	private String regDate;
	/**
	 * 公示时间
	 */
	private String publicDate;
	/**
	 * 出质状态
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
	 * 设置：质权登记编号
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	/**
	 * 获取：质权登记编号
	 */
	public String getRegistNo() {
		return registNo;
	}
	/**
	 * 设置：出质人
	 */
	public void setPledgor(String pledgor) {
		this.pledgor = pledgor;
	}
	/**
	 * 获取：出质人
	 */
	public String getPledgor() {
		return pledgor;
	}
	/**
	 * 设置：出质人证照编号
	 */
	public void setPledgorNo(String pledgorNo) {
		this.pledgorNo = pledgorNo;
	}
	/**
	 * 获取：出质人证照编号
	 */
	public String getPledgorNo() {
		return pledgorNo;
	}
	/**
	 * 设置：质权人
	 */
	public void setPledgee(String pledgee) {
		this.pledgee = pledgee;
	}
	/**
	 * 获取：质权人
	 */
	public String getPledgee() {
		return pledgee;
	}
	/**
	 * 设置：质权人证照编号
	 */
	public void setPledgeeNo(String pledgeeNo) {
		this.pledgeeNo = pledgeeNo;
	}
	/**
	 * 获取：质权人证照编号
	 */
	public String getPledgeeNo() {
		return pledgeeNo;
	}
	/**
	 * 设置：出质股权数额
	 */
	public void setPledgedAmount(String pledgedAmount) {
		this.pledgedAmount = pledgedAmount;
	}
	/**
	 * 获取：出质股权数额
	 */
	public String getPledgedAmount() {
		return pledgedAmount;
	}
	/**
	 * 设置：股权出质设立登记日期
	 */
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	/**
	 * 获取：股权出质设立登记日期
	 */
	public String getRegDate() {
		return regDate;
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
	 * 设置：出质状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：出质状态
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
