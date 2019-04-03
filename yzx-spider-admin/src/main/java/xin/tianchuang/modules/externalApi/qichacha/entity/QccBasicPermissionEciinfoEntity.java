package xin.tianchuang.modules.externalApi.qichacha.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 企查查接口数据-企业关键字精确获取详细信息(Full)-行政许可【工商局】
 * 
 * @author jiyang.hu
 * @email 
 * @date 2019-01-04 14:26:53
 */
@TableName("qcc_basic_permission_eciInfo")
public class QccBasicPermissionEciinfoEntity implements Serializable {
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
	 * 许可文件编号
	 */
	private String licensDocNo;
	/**
	 * 许可文件名称
	 */
	private String licensDocName;
	/**
	 * 有效期自
	 */
	private String validityFrom;
	/**
	 * 有效期至
	 */
	private String validityTo;
	/**
	 * 许可机关
	 */
	private String licensOffice;
	/**
	 * 许可内容
	 */
	private String licensContent;
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
	 * 设置：许可文件编号
	 */
	public void setLicensDocNo(String licensDocNo) {
		this.licensDocNo = licensDocNo;
	}
	/**
	 * 获取：许可文件编号
	 */
	public String getLicensDocNo() {
		return licensDocNo;
	}
	/**
	 * 设置：许可文件名称
	 */
	public void setLicensDocName(String licensDocName) {
		this.licensDocName = licensDocName;
	}
	/**
	 * 获取：许可文件名称
	 */
	public String getLicensDocName() {
		return licensDocName;
	}
	/**
	 * 设置：有效期自
	 */
	public void setValidityFrom(String validityFrom) {
		this.validityFrom = validityFrom;
	}
	/**
	 * 获取：有效期自
	 */
	public String getValidityFrom() {
		return validityFrom;
	}
	/**
	 * 设置：有效期至
	 */
	public void setValidityTo(String validityTo) {
		this.validityTo = validityTo;
	}
	/**
	 * 获取：有效期至
	 */
	public String getValidityTo() {
		return validityTo;
	}
	/**
	 * 设置：许可机关
	 */
	public void setLicensOffice(String licensOffice) {
		this.licensOffice = licensOffice;
	}
	/**
	 * 获取：许可机关
	 */
	public String getLicensOffice() {
		return licensOffice;
	}
	/**
	 * 设置：许可内容
	 */
	public void setLicensContent(String licensContent) {
		this.licensContent = licensContent;
	}
	/**
	 * 获取：许可内容
	 */
	public String getLicensContent() {
		return licensContent;
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
