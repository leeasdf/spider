package xin.tianchuang.modules.externalApi.qichacha.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 企查查接口数据-企业关键字精确获取详细信息(Full)-经营异常
 * 
 * @author jiyang.hu
 * @email 
 * @date 2019-01-15 15:26:44
 */
@TableName("qcc_basic_exceptions")
public class QccBasicExceptionsEntity implements Serializable {
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
	 * 列入经营异常名录原因
	 */
	private String addReason;
	/**
	 * 列入日期
	 */
	private String addDate;
	/**
	 * 移出经营异常名录原因
	 */
	private String romoveReason;
	/**
	 * 移出日期
	 */
	private String removeDate;
	/**
	 * 作出决定机关
	 */
	private String decisionOffice;
	/**
	 * 移除决定机关
	 */
	private String removeDecisionOffice;
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
	 * 设置：列入经营异常名录原因
	 */
	public void setAddReason(String addReason) {
		this.addReason = addReason;
	}
	/**
	 * 获取：列入经营异常名录原因
	 */
	public String getAddReason() {
		return addReason;
	}
	/**
	 * 设置：列入日期
	 */
	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	/**
	 * 获取：列入日期
	 */
	public String getAddDate() {
		return addDate;
	}
	/**
	 * 设置：移出经营异常名录原因
	 */
	public void setRomoveReason(String romoveReason) {
		this.romoveReason = romoveReason;
	}
	/**
	 * 获取：移出经营异常名录原因
	 */
	public String getRomoveReason() {
		return romoveReason;
	}
	/**
	 * 设置：移出日期
	 */
	public void setRemoveDate(String removeDate) {
		this.removeDate = removeDate;
	}
	/**
	 * 获取：移出日期
	 */
	public String getRemoveDate() {
		return removeDate;
	}
	/**
	 * 设置：作出决定机关
	 */
	public void setDecisionOffice(String decisionOffice) {
		this.decisionOffice = decisionOffice;
	}
	/**
	 * 获取：作出决定机关
	 */
	public String getDecisionOffice() {
		return decisionOffice;
	}
	/**
	 * 设置：移除决定机关
	 */
	public void setRemoveDecisionOffice(String removeDecisionOffice) {
		this.removeDecisionOffice = removeDecisionOffice;
	}
	/**
	 * 获取：移除决定机关
	 */
	public String getRemoveDecisionOffice() {
		return removeDecisionOffice;
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
