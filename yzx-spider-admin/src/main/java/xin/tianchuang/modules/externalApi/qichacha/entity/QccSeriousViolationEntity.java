package xin.tianchuang.modules.externalApi.qichacha.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 企查查-严重违法信息表
 * 
 * @author hui.deng
 * @email 
 * @date 2019-01-02 14:34:47
 */
@TableName("qcc_serious_violation")
public class QccSeriousViolationEntity implements Serializable {
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
	 * 类型
	 */
	private String type;
	/**
	 * 列入原因
	 */
	private String addReason;
	/**
	 * 列入时间
	 */
	private String addDate;
	/**
	 * 列入决定机关
	 */
	private String addOffice;
	/**
	 * 移除原因
	 */
	private String removeReason;
	/**
	 * 移除时间
	 */
	private String removeDate;
	/**
	 * 移除决定机关
	 */
	private String removeOffice;
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
	 * 设置：企业名称
	 */
	public void setEntName(String entName) {
		this.entName = entName;
	}
	/**
	 * 获取：企业名称
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
	 * 设置：类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：列入原因
	 */
	public void setAddReason(String addReason) {
		this.addReason = addReason;
	}
	/**
	 * 获取：列入原因
	 */
	public String getAddReason() {
		return addReason;
	}
	/**
	 * 设置：列入时间
	 */
	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	/**
	 * 获取：列入时间
	 */
	public String getAddDate() {
		return addDate;
	}
	/**
	 * 设置：列入决定机关
	 */
	public void setAddOffice(String addOffice) {
		this.addOffice = addOffice;
	}
	/**
	 * 获取：列入决定机关
	 */
	public String getAddOffice() {
		return addOffice;
	}
	/**
	 * 设置：移除原因
	 */
	public void setRemoveReason(String removeReason) {
		this.removeReason = removeReason;
	}
	/**
	 * 获取：移除原因
	 */
	public String getRemoveReason() {
		return removeReason;
	}
	/**
	 * 设置：移除时间
	 */
	public void setRemoveDate(String removeDate) {
		this.removeDate = removeDate;
	}
	/**
	 * 获取：移除时间
	 */
	public String getRemoveDate() {
		return removeDate;
	}
	/**
	 * 设置：移除决定机关
	 */
	public void setRemoveOffice(String removeOffice) {
		this.removeOffice = removeOffice;
	}
	/**
	 * 获取：移除决定机关
	 */
	public String getRemoveOffice() {
		return removeOffice;
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
}
