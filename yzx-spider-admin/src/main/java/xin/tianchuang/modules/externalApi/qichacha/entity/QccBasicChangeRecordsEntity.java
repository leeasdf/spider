package xin.tianchuang.modules.externalApi.qichacha.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 企查查接口数据-企业关键字精确获取详细信息(Full)-变更信息
 * 
 * @author jiyang.hu
 * @email 
 * @date 2019-01-04 14:26:52
 */
@TableName("qcc_basic_change_records")
public class QccBasicChangeRecordsEntity implements Serializable {
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
	 * 变更事项
	 */
	private String projectName;
	/**
	 * 变更前内容
	 */
	private String beforeContent;
	/**
	 * 变更后内容
	 */
	private String afterContent;
	/**
	 * 变更日期
	 */
	private String changeDate;
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
	 * 设置：变更事项
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * 获取：变更事项
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * 设置：变更前内容
	 */
	public void setBeforeContent(String beforeContent) {
		this.beforeContent = beforeContent;
	}
	/**
	 * 获取：变更前内容
	 */
	public String getBeforeContent() {
		return beforeContent;
	}
	/**
	 * 设置：变更后内容
	 */
	public void setAfterContent(String afterContent) {
		this.afterContent = afterContent;
	}
	/**
	 * 获取：变更后内容
	 */
	public String getAfterContent() {
		return afterContent;
	}
	/**
	 * 设置：变更日期
	 */
	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
	}
	/**
	 * 获取：变更日期
	 */
	public String getChangeDate() {
		return changeDate;
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
