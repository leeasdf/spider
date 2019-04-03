package xin.tianchuang.modules.spider.bean.litigation;

/**
 * 个⼈涉诉信息
 * 
 * @author denghui
 * 
 */
public class PersonLitigationReqDTO {

	private String appId; // 授权码

	private String tokenKey; // 验证密钥，MD5(url+tokenId+param)，param为形如key=value的字符串，逗号分隔，按key的字典序排列

	// cpws 裁判?书
	// zxgg 执?公告
	// sxgg 失信公告
	// ktgg 开庭公告
	// fygg 法院公告
	// wdhmd 网贷黑名单
	// ajlc 案件流程信息
	// bgt 曝光台
	private String datatype; // 涉诉类型

	private String name; // 姓名

	private String idcard; // 身份证号

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getTokenKey() {
		return tokenKey;
	}

	public void setTokenKey(String tokenKey) {
		this.tokenKey = tokenKey;
	}

	public String getDatatype() {
		return datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

}
