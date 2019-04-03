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
 * 法院公告信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:21
 */
@TableName("rpt_tn_court_notice")
public class RptTnCourtNoticeEntity implements Serializable {
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
	 * 公告时间
	 */
	private String publishdate;
	/**
	 * 上诉方
	 */
	private String party1;
	/**
	 * 被诉方
	 */
	private String party2;
	/**
	 * 公告类型
	 */
	private String bltntypename;
	/**
	 * 法院编码
	 */
	private String courtcode;
	/**
	 * 公告内容
	 */
	private String content;
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
	 * 公告ID
	 */
	private String announceId;
	/**
	 * 公告内容
	 */
	private String reason;
	/**
	 * 公告编号
	 */
	private String bltnno;
	/**
	 * 公告状态
	 */
	private String bltnstate;
	/**
	 * 判决人联系方式
	 */
	private String judgephone;
	/**
	 * 暂无
	 */
	private String dealgradename;
	/**
	 * 暂无
	 */
	private String dealgrade;
	/**
	 * 省份
	 */
	private String province;
	/**
	 * 公告类别
	 */
	private String bltntype;
	/**
	 * 刊登日期
	 */
	private String showtxtdate;
	/**
	 * 临时保存编号
	 */
	private String tmpsaversn;
	/**
	 * 发布界面
	 */
	private String publishpage;
	/**
	 * 被诉方网址
	 */
	private String party2str;
	/**
	 * 天眼查ID
	 */
	private String tycId;
	/**
	 * 判决人
	 */
	private String judge;
	/**
	 * 上诉方网址
	 */
	private String party1str;
	/**
	 * 案件编号
	 */
	private String caseno;
	/**
	 * 法院标识
	 */
	private String courtflag;
	/**
	 * 暂无
	 */
	private String customno;
	/**
	 * 联系方式
	 */
	private String mobilephone;
	/**
	 * 企业列表
	 */
	private String companyList;
	/**
	 * cn编号
	 */
	private String cnId;

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
	 * 设置：公告时间
	 */
	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}
	/**
	 * 获取：公告时间
	 */
	public String getPublishdate() {
		return publishdate;
	}
	/**
	 * 设置：上诉方
	 */
	public void setParty1(String party1) {
		this.party1 = party1;
	}
	/**
	 * 获取：上诉方
	 */
	public String getParty1() {
		return party1;
	}
	/**
	 * 设置：被诉方
	 */
	public void setParty2(String party2) {
		this.party2 = party2;
	}
	/**
	 * 获取：被诉方
	 */
	public String getParty2() {
		return party2;
	}
	/**
	 * 设置：公告类型
	 */
	public void setBltntypename(String bltntypename) {
		this.bltntypename = bltntypename;
	}
	/**
	 * 获取：公告类型
	 */
	public String getBltntypename() {
		return bltntypename;
	}
	/**
	 * 设置：法院编码
	 */
	public void setCourtcode(String courtcode) {
		this.courtcode = courtcode;
	}
	/**
	 * 获取：法院编码
	 */
	public String getCourtcode() {
		return courtcode;
	}
	/**
	 * 设置：公告内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：公告内容
	 */
	public String getContent() {
		return content;
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
	/**
	 * 设置：公告ID
	 */
	public void setAnnounceId(String announceId) {
		this.announceId = announceId;
	}
	/**
	 * 获取：公告ID
	 */
	public String getAnnounceId() {
		return announceId;
	}
	/**
	 * 设置：公告内容
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	 * 获取：公告内容
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * 设置：公告编号
	 */
	public void setBltnno(String bltnno) {
		this.bltnno = bltnno;
	}
	/**
	 * 获取：公告编号
	 */
	public String getBltnno() {
		return bltnno;
	}
	/**
	 * 设置：公告状态
	 */
	public void setBltnstate(String bltnstate) {
		this.bltnstate = bltnstate;
	}
	/**
	 * 获取：公告状态
	 */
	public String getBltnstate() {
		return bltnstate;
	}
	/**
	 * 设置：判决人联系方式
	 */
	public void setJudgephone(String judgephone) {
		this.judgephone = judgephone;
	}
	/**
	 * 获取：判决人联系方式
	 */
	public String getJudgephone() {
		return judgephone;
	}
	/**
	 * 设置：暂无
	 */
	public void setDealgradename(String dealgradename) {
		this.dealgradename = dealgradename;
	}
	/**
	 * 获取：暂无
	 */
	public String getDealgradename() {
		return dealgradename;
	}
	/**
	 * 设置：暂无
	 */
	public void setDealgrade(String dealgrade) {
		this.dealgrade = dealgrade;
	}
	/**
	 * 获取：暂无
	 */
	public String getDealgrade() {
		return dealgrade;
	}
	/**
	 * 设置：省份
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取：省份
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 设置：公告类别
	 */
	public void setBltntype(String bltntype) {
		this.bltntype = bltntype;
	}
	/**
	 * 获取：公告类别
	 */
	public String getBltntype() {
		return bltntype;
	}
	/**
	 * 设置：刊登日期
	 */
	public void setShowtxtdate(String showtxtdate) {
		this.showtxtdate = showtxtdate;
	}
	/**
	 * 获取：刊登日期
	 */
	public String getShowtxtdate() {
		return showtxtdate;
	}
	/**
	 * 设置：临时保存编号
	 */
	public void setTmpsaversn(String tmpsaversn) {
		this.tmpsaversn = tmpsaversn;
	}
	/**
	 * 获取：临时保存编号
	 */
	public String getTmpsaversn() {
		return tmpsaversn;
	}
	/**
	 * 设置：发布界面
	 */
	public void setPublishpage(String publishpage) {
		this.publishpage = publishpage;
	}
	/**
	 * 获取：发布界面
	 */
	public String getPublishpage() {
		return publishpage;
	}
	/**
	 * 设置：被诉方网址
	 */
	public void setParty2str(String party2str) {
		this.party2str = party2str;
	}
	/**
	 * 获取：被诉方网址
	 */
	public String getParty2str() {
		return party2str;
	}
	/**
	 * 设置：天眼查ID
	 */
	public void setTycId(String tycId) {
		this.tycId = tycId;
	}
	/**
	 * 获取：天眼查ID
	 */
	public String getTycId() {
		return tycId;
	}
	/**
	 * 设置：判决人
	 */
	public void setJudge(String judge) {
		this.judge = judge;
	}
	/**
	 * 获取：判决人
	 */
	public String getJudge() {
		return judge;
	}
	/**
	 * 设置：上诉方网址
	 */
	public void setParty1str(String party1str) {
		this.party1str = party1str;
	}
	/**
	 * 获取：上诉方网址
	 */
	public String getParty1str() {
		return party1str;
	}
	/**
	 * 设置：案件编号
	 */
	public void setCaseno(String caseno) {
		this.caseno = caseno;
	}
	/**
	 * 获取：案件编号
	 */
	public String getCaseno() {
		return caseno;
	}
	/**
	 * 设置：法院标识
	 */
	public void setCourtflag(String courtflag) {
		this.courtflag = courtflag;
	}
	/**
	 * 获取：法院标识
	 */
	public String getCourtflag() {
		return courtflag;
	}
	/**
	 * 设置：暂无
	 */
	public void setCustomno(String customno) {
		this.customno = customno;
	}
	/**
	 * 获取：暂无
	 */
	public String getCustomno() {
		return customno;
	}
	/**
	 * 设置：联系方式
	 */
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}
	/**
	 * 获取：联系方式
	 */
	public String getMobilephone() {
		return mobilephone;
	}
	/**
	 * 设置：企业列表
	 */
	public void setCompanyList(String companyList) {
		this.companyList = companyList;
	}
	/**
	 * 获取：企业列表
	 */
	public String getCompanyList() {
		return companyList;
	}
	/**
	 * 设置：cn编号
	 */
	public void setCnId(String cnId) {
		this.cnId = cnId;
	}
	/**
	 * 获取：cn编号
	 */
	public String getCnId() {
		return cnId;
	}
}
