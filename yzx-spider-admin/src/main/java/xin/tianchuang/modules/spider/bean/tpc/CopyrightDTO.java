package xin.tianchuang.modules.spider.bean.tpc;

import java.util.Date;

/**
 * 著作权信息
 * 
 * @author denghui
 * 
 */
public class CopyrightDTO {
	private int id;
	private long companyId;
	private String classifyCode;// 分类号
	private String version;// 版本号
	private String registerCode;// 登记号
	private Date registerDate;// 申请时间
	private String ownerName; // 著作权⼈（国籍）
	private String fullName;// 软件全称
	private String shortName;// 软件简称
	private Date launchDate;// ⾸次发表⽇期
	private Date createTime;// 创建时间

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public String getClassifyCode() {
		return classifyCode;
	}

	public void setClassifyCode(String classifyCode) {
		this.classifyCode = classifyCode;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getRegisterCode() {
		return registerCode;
	}

	public void setRegisterCode(String registerCode) {
		this.registerCode = registerCode;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public Date getLaunchDate() {
		return launchDate;
	}

	public void setLaunchDate(Date launchDate) {
		this.launchDate = launchDate;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
