package xin.tianchuang.modules.externalApi.qichacha.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 企查查接口数据-专利
 * 
 * @author hui.deng
 * @email 
 * @date 2018-12-20 16:46:43
 */
@TableName("qichacha_data_patent")
public class QichachaDataPatentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
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
	 * 文档类型
	 */
	private String documentTypes;
	/**
	 * 代理人
	 */
	private String agent;
	/**
	 * 法律状态日期
	 */
	private String legalStatusDate;
	/**
	 * 审查官
	 */
	private String primaryExaminer;
	/**
	 * 助理审查官
	 */
	private String assiantExaminer;
	/**
	 * 引用
	 */
	private String cites;
	/**
	 * 其他参考文献
	 */
	private String otherReferences;
	/**
	 * 专利图片
	 */
	private String patentImage;
	/**
	 * 国际专利分类号（IPC）
	 */
	private String ipcList;
	/**
	 * 申请号
	 */
	private String applicationNumber;
	/**
	 * 申请日
	 */
	private String applicationDate;
	/**
	 * 公开（公告）号
	 */
	private String publicationNumber;
	/**
	 * 公开（公告）日
	 */
	private String publicationDate;
	/**
	 * 法律状态详情
	 */
	private String legalStatusDesc;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 摘要介绍
	 */
	private String abstractText;
	/**
	 * 专利代理机构
	 */
	private String agency;
	/**
	 * 类型名称
	 */
	private String kindCodeDesc;
	/**
	 * 国际专利分类详情
	 */
	private String ipcDesc;
	/**
	 * 发明人
	 */
	private String inventorStringList;
	/**
	 * 申请人
	 */
	private String assigneestringList;
	/**
	 * 法律状态历史记录
	 */
	private String patentLegalHistory;
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
	 * 设置：文档类型
	 */
	public void setDocumentTypes(String documentTypes) {
		this.documentTypes = documentTypes;
	}
	/**
	 * 获取：文档类型
	 */
	public String getDocumentTypes() {
		return documentTypes;
	}
	/**
	 * 设置：代理人
	 */
	public void setAgent(String agent) {
		this.agent = agent;
	}
	/**
	 * 获取：代理人
	 */
	public String getAgent() {
		return agent;
	}
	/**
	 * 设置：法律状态日期
	 */
	public void setLegalStatusDate(String legalStatusDate) {
		this.legalStatusDate = legalStatusDate;
	}
	/**
	 * 获取：法律状态日期
	 */
	public String getLegalStatusDate() {
		return legalStatusDate;
	}
	/**
	 * 设置：审查官
	 */
	public void setPrimaryExaminer(String primaryExaminer) {
		this.primaryExaminer = primaryExaminer;
	}
	/**
	 * 获取：审查官
	 */
	public String getPrimaryExaminer() {
		return primaryExaminer;
	}
	/**
	 * 设置：助理审查官
	 */
	public void setAssiantExaminer(String assiantExaminer) {
		this.assiantExaminer = assiantExaminer;
	}
	/**
	 * 获取：助理审查官
	 */
	public String getAssiantExaminer() {
		return assiantExaminer;
	}
	/**
	 * 设置：引用
	 */
	public void setCites(String cites) {
		this.cites = cites;
	}
	/**
	 * 获取：引用
	 */
	public String getCites() {
		return cites;
	}
	/**
	 * 设置：其他参考文献
	 */
	public void setOtherReferences(String otherReferences) {
		this.otherReferences = otherReferences;
	}
	/**
	 * 获取：其他参考文献
	 */
	public String getOtherReferences() {
		return otherReferences;
	}
	/**
	 * 设置：专利图片
	 */
	public void setPatentImage(String patentImage) {
		this.patentImage = patentImage;
	}
	/**
	 * 获取：专利图片
	 */
	public String getPatentImage() {
		return patentImage;
	}
	/**
	 * 设置：国际专利分类号（IPC）
	 */
	public void setIpcList(String ipcList) {
		this.ipcList = ipcList;
	}
	/**
	 * 获取：国际专利分类号（IPC）
	 */
	public String getIpcList() {
		return ipcList;
	}
	/**
	 * 设置：申请号
	 */
	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}
	/**
	 * 获取：申请号
	 */
	public String getApplicationNumber() {
		return applicationNumber;
	}
	/**
	 * 设置：申请日
	 */
	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}
	/**
	 * 获取：申请日
	 */
	public String getApplicationDate() {
		return applicationDate;
	}
	/**
	 * 设置：公开（公告）号
	 */
	public void setPublicationNumber(String publicationNumber) {
		this.publicationNumber = publicationNumber;
	}
	/**
	 * 获取：公开（公告）号
	 */
	public String getPublicationNumber() {
		return publicationNumber;
	}
	/**
	 * 设置：公开（公告）日
	 */
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}
	/**
	 * 获取：公开（公告）日
	 */
	public String getPublicationDate() {
		return publicationDate;
	}
	/**
	 * 设置：法律状态详情
	 */
	public void setLegalStatusDesc(String legalStatusDesc) {
		this.legalStatusDesc = legalStatusDesc;
	}
	/**
	 * 获取：法律状态详情
	 */
	public String getLegalStatusDesc() {
		return legalStatusDesc;
	}
	/**
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：摘要介绍
	 */
	public void setAbstractText(String abstractText) {
		this.abstractText = abstractText;
	}
	/**
	 * 获取：摘要介绍
	 */
	public String getAbstractText() {
		return abstractText;
	}
	/**
	 * 设置：专利代理机构
	 */
	public void setAgency(String agency) {
		this.agency = agency;
	}
	/**
	 * 获取：专利代理机构
	 */
	public String getAgency() {
		return agency;
	}
	/**
	 * 设置：类型名称
	 */
	public void setKindCodeDesc(String kindCodeDesc) {
		this.kindCodeDesc = kindCodeDesc;
	}
	/**
	 * 获取：类型名称
	 */
	public String getKindCodeDesc() {
		return kindCodeDesc;
	}
	/**
	 * 设置：国际专利分类详情
	 */
	public void setIpcDesc(String ipcDesc) {
		this.ipcDesc = ipcDesc;
	}
	/**
	 * 获取：国际专利分类详情
	 */
	public String getIpcDesc() {
		return ipcDesc;
	}
	/**
	 * 设置：发明人
	 */
	public void setInventorStringList(String inventorStringList) {
		this.inventorStringList = inventorStringList;
	}
	/**
	 * 获取：发明人
	 */
	public String getInventorStringList() {
		return inventorStringList;
	}
	/**
	 * 设置：申请人
	 */
	public void setAssigneestringList(String assigneestringList) {
		this.assigneestringList = assigneestringList;
	}
	/**
	 * 获取：申请人
	 */
	public String getAssigneestringList() {
		return assigneestringList;
	}
	/**
	 * 设置：法律状态历史记录
	 */
	public void setPatentLegalHistory(String patentLegalHistory) {
		this.patentLegalHistory = patentLegalHistory;
	}
	/**
	 * 获取：法律状态历史记录
	 */
	public String getPatentLegalHistory() {
		return patentLegalHistory;
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
