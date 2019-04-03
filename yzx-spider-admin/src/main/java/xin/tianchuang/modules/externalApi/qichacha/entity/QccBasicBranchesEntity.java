package xin.tianchuang.modules.externalApi.qichacha.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 企查查接口数据-企业关键字精确获取详细信息(Full)-分支机构
 * 
 * @author jiyang.hu
 * @email 
 * @date 2019-01-04 14:26:52
 */
@TableName("qcc_basic_branches")
public class QccBasicBranchesEntity implements Serializable {
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
	 * 分支机构名称
	 */
	private String name;
	/**
	 * 注册号或社会统一信用代码（存在社会统一信用代码显示社会统一信用代码，否则显示注册号）
	 */
	private String regNo;
	/**
	 * 登记机关
	 */
	private String belongOrg;
	/**
	 * 法人姓名（保留字段，目前为空）
	 */
	private String operName;
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
	 * 设置：注册号或社会统一信用代码（存在社会统一信用代码显示社会统一信用代码，否则显示注册号）
	 */
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	/**
	 * 获取：注册号或社会统一信用代码（存在社会统一信用代码显示社会统一信用代码，否则显示注册号）
	 */
	public String getRegNo() {
		return regNo;
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
	 * 设置：法人姓名（保留字段，目前为空）
	 */
	public void setOperName(String operName) {
		this.operName = operName;
	}
	/**
	 * 获取：法人姓名（保留字段，目前为空）
	 */
	public String getOperName() {
		return operName;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
