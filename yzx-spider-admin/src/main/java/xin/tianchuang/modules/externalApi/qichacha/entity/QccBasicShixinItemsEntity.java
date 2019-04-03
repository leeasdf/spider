package xin.tianchuang.modules.externalApi.qichacha.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 企查查接口数据-企业关键字精确获取详细信息(Full)-失信
 * 
 * @author jiyang.hu
 * @email 
 * @date 2019-01-04 14:26:54
 */
@TableName("qcc_basic_shixin_items")
public class QccBasicShixinItemsEntity implements Serializable {
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
	 * 立案日期
	 */
	private String liandate;
	/**
	 * 立案文书号
	 */
	private String anno;
	/**
	 * 组织机构代码
	 */
	private String orgno;
	/**
	 * 执行依据文号
	 */
	private String executeno;
	/**
	 * 发布时间
	 */
	private String publicdate;
	/**
	 * 被执行人的履行情况
	 */
	private String executestatus;
	/**
	 * 行为备注
	 */
	private String actionremark;
	/**
	 * 执行法院
	 */
	private String executegov;
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
	 * 设置：立案日期
	 */
	public void setLiandate(String liandate) {
		this.liandate = liandate;
	}
	/**
	 * 获取：立案日期
	 */
	public String getLiandate() {
		return liandate;
	}
	/**
	 * 设置：立案文书号
	 */
	public void setAnno(String anno) {
		this.anno = anno;
	}
	/**
	 * 获取：立案文书号
	 */
	public String getAnno() {
		return anno;
	}
	/**
	 * 设置：组织机构代码
	 */
	public void setOrgno(String orgno) {
		this.orgno = orgno;
	}
	/**
	 * 获取：组织机构代码
	 */
	public String getOrgno() {
		return orgno;
	}
	/**
	 * 设置：执行依据文号
	 */
	public void setExecuteno(String executeno) {
		this.executeno = executeno;
	}
	/**
	 * 获取：执行依据文号
	 */
	public String getExecuteno() {
		return executeno;
	}
	/**
	 * 设置：发布时间
	 */
	public void setPublicdate(String publicdate) {
		this.publicdate = publicdate;
	}
	/**
	 * 获取：发布时间
	 */
	public String getPublicdate() {
		return publicdate;
	}
	/**
	 * 设置：被执行人的履行情况
	 */
	public void setExecutestatus(String executestatus) {
		this.executestatus = executestatus;
	}
	/**
	 * 获取：被执行人的履行情况
	 */
	public String getExecutestatus() {
		return executestatus;
	}
	/**
	 * 设置：行为备注
	 */
	public void setActionremark(String actionremark) {
		this.actionremark = actionremark;
	}
	/**
	 * 获取：行为备注
	 */
	public String getActionremark() {
		return actionremark;
	}
	/**
	 * 设置：执行法院
	 */
	public void setExecutegov(String executegov) {
		this.executegov = executegov;
	}
	/**
	 * 获取：执行法院
	 */
	public String getExecutegov() {
		return executegov;
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
