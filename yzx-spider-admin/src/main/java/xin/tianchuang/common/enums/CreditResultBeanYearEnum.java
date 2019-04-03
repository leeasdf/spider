package xin.tianchuang.common.enums;

import xin.tianchuang.common.enums.base.StrEnum;

public enum CreditResultBeanYearEnum implements StrEnum {
	// Y_2012("2012","2012年"), // 已采集
	// Y_2013("2013","2013年"), // 已采集
	// Y_2014("2014","2014年"), // 已采集
	// Y_2015("2015","2015年"), // 已采集
	// Y_2016("2016","2016年"), // 已采集
	// Y_2017("2017","2017年"), // 已采集
	Y_2018("2018", "2018年"), 
//	Y_2019("2019", "2019年"),
//	Y_2020("2020", "2020年"),
	;
	private String key;
	private String desc;

	CreditResultBeanYearEnum(String key, String desc) {
		this.key = key;
		this.desc = desc;
	}

	@Override
	public String key() {
		return key;
	}

	@Override
	public String desc() {
		return desc;
	}
}
