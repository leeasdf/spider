package xin.tianchuang.modules.externalApi.qichacha.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 企查查接口数据-企业关键字精确获取详细信息(Full)-行政处罚
 * 
 * @author jiyang.hu
 * @email 
 * @date 2019-01-04 14:26:54
 */
@TableName("qcc_basic_penalty")
public class QccBasicPenaltyEntity implements Serializable {
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
	 * 行政处罚决定书文号
	 */
	private String docNo;
	/**
	 * 违法行为类型
	 */
	private String penaltyType;
	/**
	 * 行政处罚决定机关名称
	 */
	private String officeName;
	/**
	 * 行政处罚内容
	 */
	private String content;
	/**
	 * 作出行政处罚决定日期
	 */
	private String penaltyDate;
	/**
	 * 作出行政公示日期
	 */
	private String publicDate;
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
	 * 设置：行政处罚决定书文号
	 */
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	/**
	 * 获取：行政处罚决定书文号
	 */
	public String getDocNo() {
		return docNo;
	}
	/**
	 * 设置：违法行为类型
	 */
	public void setPenaltyType(String penaltyType) {
		this.penaltyType = penaltyType;
	}
	/**
	 * 获取：违法行为类型
	 */
	public String getPenaltyType() {
		return penaltyType;
	}
	/**
	 * 设置：行政处罚决定机关名称
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	/**
	 * 获取：行政处罚决定机关名称
	 */
	public String getOfficeName() {
		return officeName;
	}
	/**
	 * 设置：行政处罚内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：行政处罚内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：作出行政处罚决定日期
	 */
	public void setPenaltyDate(String penaltyDate) {
		this.penaltyDate = penaltyDate;
	}
	/**
	 * 获取：作出行政处罚决定日期
	 */
	public String getPenaltyDate() {
		return penaltyDate;
	}
	/**
	 * 设置：作出行政公示日期
	 */
	public void setPublicDate(String publicDate) {
		this.publicDate = publicDate;
	}
	/**
	 * 获取：作出行政公示日期
	 */
	public String getPublicDate() {
		return publicDate;
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
