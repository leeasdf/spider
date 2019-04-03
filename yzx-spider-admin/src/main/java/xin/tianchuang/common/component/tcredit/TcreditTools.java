package xin.tianchuang.common.component.tcredit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import xin.tianchuang.config.TcreditProperties;
@Component
public class TcreditTools {
	@Autowired
	private TcreditProperties properties;

	public String getApiBaseUrl(){
		return properties.getApiBaseUrl();
	}

	public String getAppId(){
		return properties.getAppId();
	}
	
	public String getTokenId(){
		return properties.getTokenId();
	}
	
	public String getSpiderApiBaseUrl(){
		return properties.getSpiderApiBaseUrl();
	}

	public String getSpiderAppId(){
		return properties.getSpiderAppId();
	}
	
	public String getSpiderTokenId(){
		return properties.getSpiderTokenId();
	}
	
	public String getSpiderLogUrl(){
		return properties.getSpiderLogUrl();
	}
	// -------企业 begin
	public String getIndustryCommerce(){
		return this.getApiBaseUrl() + "/enterprise/getIndustryCommerceInfo";
	}
	public String getTpcInfo(){
		return this.getApiBaseUrl() + "/enterprise/getTpcInfo";
	}
	public String getTaxInfo(){
		return this.getApiBaseUrl() + "/enterprise/getTaxInfo";
	}
	
	public String getEnterpriseLitigation(){
		return this.getApiBaseUrl() + "/litigation/getEnterpriseLitigation";
	}
	
	public String getLitigationDetail(){
		return this.getApiBaseUrl() + "/litigation/getLitigationDetail";
	}
	public String getVerifyEnterpriseInfo(){
		return this.getApiBaseUrl() + "/enterprise/verifyEnterpriseInfo";
	}
	
	// -------企业 end
	// ---- 个人
	/**
	 * 查询个人不良信息，如在逃、前科、吸毒、涉毒
	 * @return
	 */
	public String getBadInfo(){
		return this.getApiBaseUrl() + "/litigation/getBadInfo";
	}
	
	public String getBadInfoB(){
		return this.getApiBaseUrl() + "/litigation/getBadInfoB";
	}
	
	/**
	 * 个人身份认证
	 * @return
	 */
	public String getVerifyIdcard(){
		return this.getApiBaseUrl() + "/identity/verifyIdcard";
	}
	
	/**
	 * 精准查询个人涉诉信息
	 * @return
	 */
	public String getPersonLitigation(){
		return this.getApiBaseUrl() + "/litigation/getPersonLitigation";
	}
	// ---  个人
	
	// --- 爬虫
	public String getTycEnterpriseInfo(){
		return this.getSpiderApiBaseUrl() + "/api/enterprise/getEntInfoB";
	}
	
	public String getTycLoginPageEnterpriseInfo(){
		return this.getSpiderApiBaseUrl() + "/api/enterprise/getEnterpriseBPage";
	}
	
	
}
