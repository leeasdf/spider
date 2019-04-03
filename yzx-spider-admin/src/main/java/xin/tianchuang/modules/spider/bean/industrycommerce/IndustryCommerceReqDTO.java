package xin.tianchuang.modules.spider.bean.industrycommerce;

import xin.tianchuang.common.enums.ApiEnterpriseTypeEnum;
import xin.tianchuang.modules.api.bean.v1.BaseTcreditApiDTO;

public class IndustryCommerceReqDTO extends BaseTcreditApiDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7457601611411654975L;

	/**
	 * 查询键值，可以是企业名称、⼯商注册号或者⾃然⼈证件号
	 */
	private String key;

	/**
	 * 键值类型，2-企业名称 3-⼯商注册号 4-法⼈⾝份证号码
	 */
	private ApiEnterpriseTypeEnum keyType;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public ApiEnterpriseTypeEnum getKeyType() {
		return keyType;
	}

	public void setKeyType(ApiEnterpriseTypeEnum keyType) {
		this.keyType = keyType;
	}

}
