package xin.tianchuang.modules.externalApi.qichacha.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 企查查接口数据-企业关键字精确获取详细信息(Full)-执行
 * 
 * @author jiyang.hu
 * @email 
 * @date 2019-01-04 14:26:53
 */
@TableName("qcc_basic_zhixing_items")
public class QccBasicZhixingItemsEntity implements Serializable {
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
	 * 官网系统ID
	 */
	private String sourceid;
	/**
	 * 立案时间
	 */
	private String liandate;
	/**
	 * 立案号
	 */
	private String anno;
	/**
	 * 执行法院
	 */
	private String executeGov;
	/**
	 * 标地
	 */
	private String biaodi;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 身份证号码/组织机构代码
	 */
	private String partyCardNum;
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
	 * 设置：官网系统ID
	 */
	public void setSourceid(String sourceid) {
		this.sourceid = sourceid;
	}
	/**
	 * 获取：官网系统ID
	 */
	public String getSourceid() {
		return sourceid;
	}
	/**
	 * 设置：立案时间
	 */
	public void setLiandate(String liandate) {
		this.liandate = liandate;
	}
	/**
	 * 获取：立案时间
	 */
	public String getLiandate() {
		return liandate;
	}
	/**
	 * 设置：立案号
	 */
	public void setAnno(String anno) {
		this.anno = anno;
	}
	/**
	 * 获取：立案号
	 */
	public String getAnno() {
		return anno;
	}
	/**
	 * 设置：执行法院
	 */
	public void setExecuteGov(String executeGov) {
		this.executeGov = executeGov;
	}
	/**
	 * 获取：执行法院
	 */
	public String getExecuteGov() {
		return executeGov;
	}
	/**
	 * 设置：标地
	 */
	public void setBiaodi(String biaodi) {
		this.biaodi = biaodi;
	}
	/**
	 * 获取：标地
	 */
	public String getBiaodi() {
		return biaodi;
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
	 * 设置：身份证号码/组织机构代码
	 */
	public void setPartyCardNum(String partyCardNum) {
		this.partyCardNum = partyCardNum;
	}
	/**
	 * 获取：身份证号码/组织机构代码
	 */
	public String getPartyCardNum() {
		return partyCardNum;
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
