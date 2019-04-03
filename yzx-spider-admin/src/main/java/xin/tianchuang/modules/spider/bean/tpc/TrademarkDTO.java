package xin.tianchuang.modules.spider.bean.tpc;

import java.util.Date;

/**
 * 商标信息
 * 
 * @author denghui
 * 
 */
public class TrademarkDTO {
	private int id; //
	private long companyId; //
	private String name;// 商标名称
	private String publish; //
	private String img; //
	private String status;// 商标状态
	private int isShare;// 是否共有
	private Date launchDate; // 注册公告⽇期
	private String launchNum; // 注册公告期号
	private String registerNum;// 注册号
	private String applicantCnName; // 申请⼈名称(中 )
	private String applicantEnName; // 申请⼈名称(英 )
	private String address; // 申请⼈地址
	private String applyDate; // 申请⽇期
	private int category;// 商标类型
	private String url;// 商标查看地址
	private String agentOrg;// 代理⼈名称
	private Date limitStart;// 专利权期限开始⽇期
	private Date limitEnd;// 专利权期限截⽌⽇期
	private Date initVerifyDate;// 初审公告⽇期
	private Date initVerifyNum;// 初审公告期号
	private String productList;// 商品服务列表
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPublish() {
		return publish;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getIsShare() {
		return isShare;
	}

	public void setIsShare(int isShare) {
		this.isShare = isShare;
	}

	public Date getLaunchDate() {
		return launchDate;
	}

	public void setLaunchDate(Date launchDate) {
		this.launchDate = launchDate;
	}

	public String getLaunchNum() {
		return launchNum;
	}

	public void setLaunchNum(String launchNum) {
		this.launchNum = launchNum;
	}

	public String getRegisterNum() {
		return registerNum;
	}

	public void setRegisterNum(String registerNum) {
		this.registerNum = registerNum;
	}

	public String getApplicantCnName() {
		return applicantCnName;
	}

	public void setApplicantCnName(String applicantCnName) {
		this.applicantCnName = applicantCnName;
	}

	public String getApplicantEnName() {
		return applicantEnName;
	}

	public void setApplicantEnName(String applicantEnName) {
		this.applicantEnName = applicantEnName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAgentOrg() {
		return agentOrg;
	}

	public void setAgentOrg(String agentOrg) {
		this.agentOrg = agentOrg;
	}

	public Date getLimitStart() {
		return limitStart;
	}

	public void setLimitStart(Date limitStart) {
		this.limitStart = limitStart;
	}

	public Date getLimitEnd() {
		return limitEnd;
	}

	public void setLimitEnd(Date limitEnd) {
		this.limitEnd = limitEnd;
	}

	public Date getInitVerifyDate() {
		return initVerifyDate;
	}

	public void setInitVerifyDate(Date initVerifyDate) {
		this.initVerifyDate = initVerifyDate;
	}

	public Date getInitVerifyNum() {
		return initVerifyNum;
	}

	public void setInitVerifyNum(Date initVerifyNum) {
		this.initVerifyNum = initVerifyNum;
	}

	public String getProductList() {
		return productList;
	}

	public void setProductList(String productList) {
		this.productList = productList;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
