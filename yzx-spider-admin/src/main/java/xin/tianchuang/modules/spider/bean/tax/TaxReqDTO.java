package xin.tianchuang.modules.spider.bean.tax;

/**
 * 企业商标专利著作权信息
 * 
 * @author denghui
 * 
 */
public class TaxReqDTO {

	private String appId; // 授权码

	private String tokenKey; // 验证密钥，MD5(url+tokenId+param)，param为形如key=value的字符串，逗号分隔，按key的字典序排列

	private String ename; // 企业名称

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

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

}
