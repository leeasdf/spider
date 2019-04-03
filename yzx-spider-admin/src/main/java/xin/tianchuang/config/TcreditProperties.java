package xin.tianchuang.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * tcredit系统的一些属性
 */
@Component
@ConfigurationProperties(prefix = "tcredit")  
public class TcreditProperties {
	/**
	 * appId
	 */
	private String appId = "aa1bc141-7092-4340-8e1c-9a2558db049b";

	private String tokenId = "8d18c8b6-05bf-4001-986a-5881aba21ef8";
	
	private String apiBaseUrl = "http://10.151.30.29:9998";

	private String spiderAppId = "aa1bc141-7092-4340-8e1c-9a2558db049b";

	private String spiderTokenId = "8d18c8b6-05bf-4001-986a-5881aba21ef8";
	
	private String spiderApiBaseUrl = "http://10.151.30.29:9998";
	
	private String spiderLogUrl = "http://112.74.187.95:8086/log";
	
	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getApiBaseUrl() {
		return apiBaseUrl;
	}

	public void setApiBaseUrl(String apiBaseUrl) {
		this.apiBaseUrl = apiBaseUrl;
	}

	public String getSpiderAppId() {
		return spiderAppId;
	}

	public void setSpiderAppId(String spiderAppId) {
		this.spiderAppId = spiderAppId;
	}

	public String getSpiderTokenId() {
		return spiderTokenId;
	}

	public void setSpiderTokenId(String spiderTokenId) {
		this.spiderTokenId = spiderTokenId;
	}

	public String getSpiderApiBaseUrl() {
		return spiderApiBaseUrl;
	}

	public void setSpiderApiBaseUrl(String spiderApiBaseUrl) {
		this.spiderApiBaseUrl = spiderApiBaseUrl;
	}

	public String getSpiderLogUrl() {
		return spiderLogUrl;
	}

	public void setSpiderLogUrl(String spiderLogUrl) {
		this.spiderLogUrl = spiderLogUrl;
	}
	
}
