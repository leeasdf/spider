package xin.tianchuang.modules.spider.bean.enterprise.verify;

/**
 * 企业商标专利著作权信息
 * 
 * @author denghui
 * 
 */
public class VerifyReqDTO {

	private String appId; // 授权码

	private String tokenKey; // 验证密钥，MD5(url+tokenId+param)，param为形如key=value的字符串，逗号分隔，按key的字典序排列

	private String ename; // 公司名称，与regno选填⼀项

	private String regno; // ⼯商注册号/统⼀社会信⽤代码，与ename选填⼀项；若ename和 regno同时存在，优先按regno查询

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

	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}

}
