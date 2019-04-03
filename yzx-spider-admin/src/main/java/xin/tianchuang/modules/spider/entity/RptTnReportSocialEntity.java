package xin.tianchuang.modules.spider.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * tyc企业年报-社保信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-12-05 17:21:32
 */
@TableName("rpt_tn_report_social")
public class RptTnReportSocialEntity implements Serializable {
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
	 * 年报主键
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long reportId;
	/**
	 * 单位参加工伤保险缴费基数
	 */
	private String injuryRadix;
	/**
	 * 工伤保险
	 */
	private String injuryNum;
	/**
	 * 参加工伤保险本期实际缴费金额
	 */
	private String injuryAmount;
	/**
	 * 参加失业保险本期实际缴费金额
	 */
	private String unemployAmount;
	/**
	 * 单位参加职工基本医疗保险累积欠缴金额
	 */
	private String medicalnsureOweAmount;
	/**
	 * 参加城镇职工基本养老保险本期实际缴费金额
	 */
	private String oldAgeAmount;
	/**
	 * 城镇职工基本养老保险
	 */
	private String oldAgeNum;
	/**
	 * 失业保险
	 */
	private String unemployNum;
	/**
	 * 职工基本医疗保险
	 */
	private String medicalNum;
	/**
	 * 生育保险
	 */
	private String maternityNum;
	/**
	 * 单位参加生育保险缴费基数
	 */
	private String maternityRadix;
	/**
	 * 单位参加工伤保险累积欠缴金额
	 */
	private String injuryinsureOweAmount;
	/**
	 * 单位参加城镇职工基本养老保险缴费基数
	 */
	private String oldAgeRadix;
	/**
	 * 单位参加城镇职工基本养老保险累积欠缴金额
	 */
	private String oldAgelnsureOweAmount;
	/**
	 * 参加职工基本医疗保险本期实际缴费金额
	 */
	private String medicalAmount;
	/**
	 * 单位参加失业保险缴费基数
	 */
	private String unemployRadix;
	/**
	 * 单位参加生育保险累积欠缴金额
	 */
	private String maternityInsureOweAmount;
	/**
	 * 参加生育保险本期实际缴费金额
	 */
	private String maternityAmount;
	/**
	 * 单位参加失业保险累积欠缴金额
	 */
	private String unemploylnsureOweAmount;
	/**
	 * 单位参加职工基本医疗保险缴费基数
	 */
	private String medicalRadix;
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
	 * 设置：主键
	 */
	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	/**
	 * 获取：主键
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
	 * 设置：年报主键
	 */
	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}
	/**
	 * 获取：年报主键
	 */
	public Long getReportId() {
		return reportId;
	}
	/**
	 * 设置：单位参加工伤保险缴费基数
	 */
	public void setInjuryRadix(String injuryRadix) {
		this.injuryRadix = injuryRadix;
	}
	/**
	 * 获取：单位参加工伤保险缴费基数
	 */
	public String getInjuryRadix() {
		return injuryRadix;
	}
	/**
	 * 设置：工伤保险
	 */
	public void setInjuryNum(String injuryNum) {
		this.injuryNum = injuryNum;
	}
	/**
	 * 获取：工伤保险
	 */
	public String getInjuryNum() {
		return injuryNum;
	}
	/**
	 * 设置：参加工伤保险本期实际缴费金额
	 */
	public void setInjuryAmount(String injuryAmount) {
		this.injuryAmount = injuryAmount;
	}
	/**
	 * 获取：参加工伤保险本期实际缴费金额
	 */
	public String getInjuryAmount() {
		return injuryAmount;
	}
	/**
	 * 设置：参加失业保险本期实际缴费金额
	 */
	public void setUnemployAmount(String unemployAmount) {
		this.unemployAmount = unemployAmount;
	}
	/**
	 * 获取：参加失业保险本期实际缴费金额
	 */
	public String getUnemployAmount() {
		return unemployAmount;
	}
	/**
	 * 设置：单位参加职工基本医疗保险累积欠缴金额
	 */
	public void setMedicalnsureOweAmount(String medicalnsureOweAmount) {
		this.medicalnsureOweAmount = medicalnsureOweAmount;
	}
	/**
	 * 获取：单位参加职工基本医疗保险累积欠缴金额
	 */
	public String getMedicalnsureOweAmount() {
		return medicalnsureOweAmount;
	}
	/**
	 * 设置：参加城镇职工基本养老保险本期实际缴费金额
	 */
	public void setOldAgeAmount(String oldAgeAmount) {
		this.oldAgeAmount = oldAgeAmount;
	}
	/**
	 * 获取：参加城镇职工基本养老保险本期实际缴费金额
	 */
	public String getOldAgeAmount() {
		return oldAgeAmount;
	}
	/**
	 * 设置：城镇职工基本养老保险
	 */
	public void setOldAgeNum(String oldAgeNum) {
		this.oldAgeNum = oldAgeNum;
	}
	/**
	 * 获取：城镇职工基本养老保险
	 */
	public String getOldAgeNum() {
		return oldAgeNum;
	}
	/**
	 * 设置：失业保险
	 */
	public void setUnemployNum(String unemployNum) {
		this.unemployNum = unemployNum;
	}
	/**
	 * 获取：失业保险
	 */
	public String getUnemployNum() {
		return unemployNum;
	}
	/**
	 * 设置：职工基本医疗保险
	 */
	public void setMedicalNum(String medicalNum) {
		this.medicalNum = medicalNum;
	}
	/**
	 * 获取：职工基本医疗保险
	 */
	public String getMedicalNum() {
		return medicalNum;
	}
	/**
	 * 设置：生育保险
	 */
	public void setMaternityNum(String maternityNum) {
		this.maternityNum = maternityNum;
	}
	/**
	 * 获取：生育保险
	 */
	public String getMaternityNum() {
		return maternityNum;
	}
	/**
	 * 设置：单位参加生育保险缴费基数
	 */
	public void setMaternityRadix(String maternityRadix) {
		this.maternityRadix = maternityRadix;
	}
	/**
	 * 获取：单位参加生育保险缴费基数
	 */
	public String getMaternityRadix() {
		return maternityRadix;
	}
	/**
	 * 设置：单位参加工伤保险累积欠缴金额
	 */
	public void setInjuryinsureOweAmount(String injuryinsureOweAmount) {
		this.injuryinsureOweAmount = injuryinsureOweAmount;
	}
	/**
	 * 获取：单位参加工伤保险累积欠缴金额
	 */
	public String getInjuryinsureOweAmount() {
		return injuryinsureOweAmount;
	}
	/**
	 * 设置：单位参加城镇职工基本养老保险缴费基数
	 */
	public void setOldAgeRadix(String oldAgeRadix) {
		this.oldAgeRadix = oldAgeRadix;
	}
	/**
	 * 获取：单位参加城镇职工基本养老保险缴费基数
	 */
	public String getOldAgeRadix() {
		return oldAgeRadix;
	}
	/**
	 * 设置：单位参加城镇职工基本养老保险累积欠缴金额
	 */
	public void setOldAgelnsureOweAmount(String oldAgelnsureOweAmount) {
		this.oldAgelnsureOweAmount = oldAgelnsureOweAmount;
	}
	/**
	 * 获取：单位参加城镇职工基本养老保险累积欠缴金额
	 */
	public String getOldAgelnsureOweAmount() {
		return oldAgelnsureOweAmount;
	}
	/**
	 * 设置：参加职工基本医疗保险本期实际缴费金额
	 */
	public void setMedicalAmount(String medicalAmount) {
		this.medicalAmount = medicalAmount;
	}
	/**
	 * 获取：参加职工基本医疗保险本期实际缴费金额
	 */
	public String getMedicalAmount() {
		return medicalAmount;
	}
	/**
	 * 设置：单位参加失业保险缴费基数
	 */
	public void setUnemployRadix(String unemployRadix) {
		this.unemployRadix = unemployRadix;
	}
	/**
	 * 获取：单位参加失业保险缴费基数
	 */
	public String getUnemployRadix() {
		return unemployRadix;
	}
	/**
	 * 设置：单位参加生育保险累积欠缴金额
	 */
	public void setMaternityInsureOweAmount(String maternityInsureOweAmount) {
		this.maternityInsureOweAmount = maternityInsureOweAmount;
	}
	/**
	 * 获取：单位参加生育保险累积欠缴金额
	 */
	public String getMaternityInsureOweAmount() {
		return maternityInsureOweAmount;
	}
	/**
	 * 设置：参加生育保险本期实际缴费金额
	 */
	public void setMaternityAmount(String maternityAmount) {
		this.maternityAmount = maternityAmount;
	}
	/**
	 * 获取：参加生育保险本期实际缴费金额
	 */
	public String getMaternityAmount() {
		return maternityAmount;
	}
	/**
	 * 设置：单位参加失业保险累积欠缴金额
	 */
	public void setUnemploylnsureOweAmount(String unemploylnsureOweAmount) {
		this.unemploylnsureOweAmount = unemploylnsureOweAmount;
	}
	/**
	 * 获取：单位参加失业保险累积欠缴金额
	 */
	public String getUnemploylnsureOweAmount() {
		return unemploylnsureOweAmount;
	}
	/**
	 * 设置：单位参加职工基本医疗保险缴费基数
	 */
	public void setMedicalRadix(String medicalRadix) {
		this.medicalRadix = medicalRadix;
	}
	/**
	 * 获取：单位参加职工基本医疗保险缴费基数
	 */
	public String getMedicalRadix() {
		return medicalRadix;
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
