package xin.tianchuang.modules.spider.bean.litigation;

/**
 * 个⼈涉诉信息
 * 
 * @author denghui
 * 
 */
public class LitigationDetailReqDTO {

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

	private String dataid; // 涉诉详情代码

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

	public String getDataid() {
		return dataid;
	}

	public void setDataid(String dataid) {
		this.dataid = dataid;
	}

}
