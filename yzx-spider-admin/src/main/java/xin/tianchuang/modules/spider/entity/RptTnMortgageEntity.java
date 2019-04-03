package xin.tianchuang.modules.spider.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * 企业-动产抵押信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:21
 */
@TableName("rpt_tn_mortgage")
public class RptTnMortgageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 企业主键
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long enterpriseId;
	/**
	 * 企业名称
	 */
	private String entName;
	/**
	 * 被担保债权数额
	 */
	private String overviewAmount;
	/**
	 * 经营范围
	 */
	private String scope;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 担保范围
	 */
	private String overviewScope;
	/**
	 * 担保ID
	 */
	private String mId;
	/**
	 * 金额
	 */
	private String amount;
	/**
	 * 登记机关
	 */
	private String regDepartment;
	/**
	 * 登记日期
	 */
	private String regDate;
	/**
	 * 担保1时间
	 */
	private String overviewTerm;
	/**
	 * 登记编号
	 */
	private String regNum;
	/**
	 * 债务人履行债务期限
	 */
	private String term;
	/**
	 * 公布日期
	 */
	private String publishDate;
	/**
	 * 动产抵押登记信息
	 */
	private String changeInfoList;
	/**
	 * 抵押物信息
	 */
	private String pawnInfoList;
	/**
	 * 抵押权人信息
	 */
	private String peopleInfo;
	/**
	 * 创建人ID
	 */
	private Integer creator;
	/**
	 * 创建时间
	 */
	  @TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;
	/**
	 * 修改人ID
	 */
	private Integer updater;
	/**
	 * 修改时间
	 */
		 @TableField(value = "update_time", fill = FieldFill.UPDATE)
	private Date updateTime;
	/**
	 * 数据状态：1-正常 0-删除
	 */
	@TableField(value = "data_state", fill = FieldFill.INSERT)
private Integer dataState;

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
	 * 设置：企业主键
	 */
	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	/**
	 * 获取：企业主键
	 */
	public Long getEnterpriseId() {
		return enterpriseId;
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
	 * 设置：被担保债权数额
	 */
	public void setOverviewAmount(String overviewAmount) {
		this.overviewAmount = overviewAmount;
	}
	/**
	 * 获取：被担保债权数额
	 */
	public String getOverviewAmount() {
		return overviewAmount;
	}
	/**
	 * 设置：经营范围
	 */
	public void setScope(String scope) {
		this.scope = scope;
	}
	/**
	 * 获取：经营范围
	 */
	public String getScope() {
		return scope;
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
	 * 设置：担保范围
	 */
	public void setOverviewScope(String overviewScope) {
		this.overviewScope = overviewScope;
	}
	/**
	 * 获取：担保范围
	 */
	public String getOverviewScope() {
		return overviewScope;
	}
	/**
	 * 设置：担保ID
	 */
	public void setMId(String mId) {
		this.mId = mId;
	}
	/**
	 * 获取：担保ID
	 */
	public String getMId() {
		return mId;
	}
	/**
	 * 设置：金额
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	/**
	 * 获取：金额
	 */
	public String getAmount() {
		return amount;
	}
	/**
	 * 设置：登记机关
	 */
	public void setRegDepartment(String regDepartment) {
		this.regDepartment = regDepartment;
	}
	/**
	 * 获取：登记机关
	 */
	public String getRegDepartment() {
		return regDepartment;
	}
	/**
	 * 设置：登记日期
	 */
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	/**
	 * 获取：登记日期
	 */
	public String getRegDate() {
		return regDate;
	}
	/**
	 * 设置：担保1时间
	 */
	public void setOverviewTerm(String overviewTerm) {
		this.overviewTerm = overviewTerm;
	}
	/**
	 * 获取：担保1时间
	 */
	public String getOverviewTerm() {
		return overviewTerm;
	}
	/**
	 * 设置：登记编号
	 */
	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}
	/**
	 * 获取：登记编号
	 */
	public String getRegNum() {
		return regNum;
	}
	/**
	 * 设置：债务人履行债务期限
	 */
	public void setTerm(String term) {
		this.term = term;
	}
	/**
	 * 获取：债务人履行债务期限
	 */
	public String getTerm() {
		return term;
	}
	/**
	 * 设置：公布日期
	 */
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	/**
	 * 获取：公布日期
	 */
	public String getPublishDate() {
		return publishDate;
	}
	/**
	 * 设置：动产抵押登记信息
	 */
	public void setChangeInfoList(String changeInfoList) {
		this.changeInfoList = changeInfoList;
	}
	/**
	 * 获取：动产抵押登记信息
	 */
	public String getChangeInfoList() {
		return changeInfoList;
	}
	/**
	 * 设置：抵押物信息
	 */
	public void setPawnInfoList(String pawnInfoList) {
		this.pawnInfoList = pawnInfoList;
	}
	/**
	 * 获取：抵押物信息
	 */
	public String getPawnInfoList() {
		return pawnInfoList;
	}
	/**
	 * 设置：抵押权人信息
	 */
	public void setPeopleInfo(String peopleInfo) {
		this.peopleInfo = peopleInfo;
	}
	/**
	 * 获取：抵押权人信息
	 */
	public String getPeopleInfo() {
		return peopleInfo;
	}
	/**
	 * 设置：创建人ID
	 */
	public void setCreator(Integer creator) {
		this.creator = creator;
	}
	/**
	 * 获取：创建人ID
	 */
	public Integer getCreator() {
		return creator;
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
	 * 设置：修改人ID
	 */
	public void setUpdater(Integer updater) {
		this.updater = updater;
	}
	/**
	 * 获取：修改人ID
	 */
	public Integer getUpdater() {
		return updater;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：数据状态：1-正常 0-删除
	 */
	public void setDataState(Integer dataState) {
		this.dataState = dataState;
	}
	/**
	 * 获取：数据状态：1-正常 0-删除
	 */
	public Integer getDataState() {
		return dataState;
	}
}
