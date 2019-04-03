package xin.tianchuang.modules.externalApi.qichacha.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 企查查接口数据-企业关键字精确获取详细信息(Full)-抽查检查
 * 
 * @author jiyang.hu
 * @email 
 * @date 2019-01-04 14:26:53
 */
@TableName("qcc_basic_spot_check")
public class QccBasicSpotCheckEntity implements Serializable {
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
	private String no;
	/**
	 * 检查实施机关
	 */
	private String executiveOrg;
	/**
	 * 类型
	 */
	private String type;
	/**
	 * 日期
	 */
	private String date;
	/**
	 * 结果
	 */
	private String consequence;
	/**
	 * 备注
	 */
	private String remark;
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
	public void setNo(String no) {
		this.no = no;
	}
	/**
	 * 获取：登记编号
	 */
	public String getNo() {
		return no;
	}
	/**
	 * 设置：检查实施机关
	 */
	public void setExecutiveOrg(String executiveOrg) {
		this.executiveOrg = executiveOrg;
	}
	/**
	 * 获取：检查实施机关
	 */
	public String getExecutiveOrg() {
		return executiveOrg;
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
	 * 设置：日期
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * 获取：日期
	 */
	public String getDate() {
		return date;
	}
	/**
	 * 设置：结果
	 */
	public void setConsequence(String consequence) {
		this.consequence = consequence;
	}
	/**
	 * 获取：结果
	 */
	public String getConsequence() {
		return consequence;
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
